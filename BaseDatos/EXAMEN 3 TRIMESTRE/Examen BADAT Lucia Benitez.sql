--EXAMEN LUCIA BENITEZ MARTINEZ			1�CSFP
GO
USE LeoFest
GO
--Autorizar como propietaria de la base de datos
ALTER AUTHORIZATION ON DATABASE::LeoFest TO sa

--Ejercicio 1
--Escribe un procedimiento almacenado que de de baja a una banda, actualizando su fecha de disoluci�n y la fecha de abandono de todos 
--sus componentes actuales. La fecha de disoluci�n y el ID de la banda se pasar�n como par�metros. Si no se especifica fecha, 
--se tomar� la actual.

GO
CREATE PROCEDURE DisolverBanda
	@IDBanda INT
	,@FechaDisolucion DATE = NULL
AS
BEGIN
	BEGIN TRANSACTION
		IF(@FechaDisolucion = NULL)
			BEGIN
				UPDATE LFBandas
				SET FechaDisolucion = CAST(CURRENT_TIMESTAMP AS DATE)
				WHERE ID = @IDBanda

				UPDATE LFMusicosBandas
				SET FechaAbandono = CAST(CURRENT_TIMESTAMP AS DATE)
				WHERE IDBanda = @IDBanda
			END
		ELSE
			BEGIN
				UPDATE LFBandas
				SET FechaDisolucion = @FechaDisolucion
				WHERE ID = @IDBanda

				UPDATE LFMusicosBandas
				SET FechaAbandono = @FechaDisolucion
				WHERE IDBanda = @IDBanda
			END
	COMMIT
END
GO

SET DATEFORMAT YMD

BEGIN TRANSACTION
--Sin pasar una fecha
EXECUTE DisolverBanda 1
--Pasando una fecha
EXECUTE DisolverBanda 1, '2016-05-24'
ROLLBACK TRANSACTION


--Ejercicio 2
--Escribe una funci�n que reciba como par�metro un a�o y nos devuelva una tabla indicando cuantas canciones (temas) de cada estilo se han cantado
--en los distintos festivales celebrados a lo largo de ese a�o, el mismo dato para el a�o inmediatamente anterior y una cuarta columna en la que 
--aparezca un s�mbolo "+� si ha aumentado el n�mero de canciones de ese estilo respecto al a�o anterior, un "-� si ha disminuido y un "=� si no 
--var�a.
--El resultado tendr� cuatro columnas: Estilo, n�mero de interpretaciones de ese estilo en el a�o anterior, n�mero de interpretaciones de ese 
--estilo en el a�o que nos piden y s�mbolo que indique aumento o disminuci�n.
--Puedes hacer otras funciones auxiliares a las que llames, pero no declarar vistas.

SELECT * FROM LFEdiciones

GO
CREATE FUNCTION FN_CancionesCantadasCadaA�o (@A�o INT)
RETURNS TABLE AS
RETURN(
	SELECT DISTINCT E.Estilo, VecesAnterior AS VecesAnterior, COUNT(T.ID) AS VecesA�o, 
	
	CASE
		WHEN COUNT(T.ID) - VecesAnterior > 0 THEN '+'
		WHEN COUNT(T.ID) - VecesAnterior = 0 THEN '='
		WHEN COUNT(T.ID) - VecesAnterior < 0 THEN '-'	
	END AS Diferencia
	
	FROM LFTemas AS T
		INNER JOIN LFEstilos AS E ON T.IDEstilo = E.ID
		INNER JOIN LFTemasBandasEdiciones AS TBE ON T.ID = TBE.IDTema
		INNER JOIN LFEdiciones AS EE ON TBE.Ordinal = EE.Ordinal AND TBE.IDFestival = EE.IDFestival
		INNER JOIN(
			SELECT E.Estilo, COUNT(T.ID) AS VecesAnterior FROM LFTemas AS T
			INNER JOIN LFEstilos AS E ON T.IDEstilo = E.ID
			INNER JOIN LFTemasBandasEdiciones AS TBE ON T.ID = TBE.IDTema
			INNER JOIN LFEdiciones AS EE ON TBE.Ordinal = EE.Ordinal AND TBE.IDFestival = EE.IDFestival
			WHERE (@A�o - 1) BETWEEN YEAR(EE.FechaHoraInicio) AND YEAR(EE.FechaHoraFin)
			GROUP BY E.Estilo
		) AS VecesA�oAnterior ON E.Estilo = VecesA�oAnterior.Estilo
	WHERE @A�o BETWEEN YEAR(EE.FechaHoraInicio) AND YEAR(EE.FechaHoraFin)
	GROUP BY E.Estilo, VecesAnterior
)
GO
 
SELECT * FROM FN_CancionesCantadasCadaA�o (2007) ORDER BY Estilo

--Ejercicio 3
--Escribe un procedimiento TemaEjecutado y anote en la tabla LFBandasEdiciones que una banda ha interpretado ese tema en una edici�n concreta 
--de un festival.
--Los datos de entrada son: Titulo, IDAutor, Estilo (nombre del estilo), Duracion, El Id de un festival, el ordinal de la edici�n, el ID de una 
--banda y una fecha/hora.
--Si el tema es nuevo y no est� dado de alta en la base de datos, se insertar� en la tabla correspondiente. Si el estilo no existe, tambi�n se 
--dar� de alta.

GO
CREATE PROCEDURE TemaEjecutado
	@Titulo VARCHAR(120)
	,@IDAutor INT
	,@Estilo VARCHAR(30)
	,@Duracion TIME(7)
	,@IDFestival INT
	,@Ordinal TINYINT
	,@IDBanda SMALLINT
AS
BEGIN
	--SI NO EXISTE EL ESTILO LO INSERTAMOS
	IF NOT EXISTS(SELECT Estilo FROM LFEstilos WHERE Estilo = @Estilo)
		BEGIN
			INSERT INTO LFEstilos (ID, Estilo)
			VALUES((SELECT MAX(ID) + 1 FROM LFEstilos), @Estilo)
		END
	
	--SI NO EXISTE EL TEMA LO INSERTAMOS
	IF NOT EXISTS(SELECT Titulo FROM LFTemas WHERE Titulo = @Titulo)
		BEGIN
			INSERT INTO LFTemas (ID, Titulo, IDAutor, IDEstilo, Duracion)
			VALUES(NEWID(), @Titulo, @IDAutor, (SELECT ID FROM LFEstilos WHERE Estilo = @Estilo), @Duracion)
		END

	INSERT INTO LFTemasBandasEdiciones (IDBanda, IDFestival, Ordinal, IDTema)
	VALUES (@IDBanda, @IDFestival, @Ordinal, (SELECT ID FROM LFTemas WHERE Titulo = @Titulo))
END
GO

BEGIN TRANSACTION
--un tema que no exista
EXECUTE TemaEjecutado 'Mi estrella Blanca', 1, 'Flamenco', '04:20', 5, 3, 1
--un estilo y un tema que no exista
EXECUTE TemaEjecutado 'Palabras de Papel', 1, 'TecnoFlamenco', '04:20', 5, 3, 1
--todo existe
EXECUTE TemaEjecutado 'Lagartija solidaria', 11, 'Hip-Hop', '02:40', 5, 3, 11
ROLLBACK TRANSACTION

--Ejercicio 4
--Escribe un procedimiento almacenado que actualice la columna cach� de la tabla LFBandas de acuerdo a las siguientes reglas:
--�	Se computar�n 105 � por cada miembro activo de la banda
--�	Se a�adir�n 170 � por cada actuaci�n en los tres a�os anteriores
--�	Esa cantidad se incrementar� un 5% si la banda toca alguno de los estilos Rock, Flamenco, Jazz o Blues y se decrementar� un 50% si toca 
--	Reggaeton o Hip-Hop

SELECT * FROM LFTemasBandasEdiciones

GO
CREATE PROCEDURE ActualizarCache
AS
BEGIN

	--CUENTA EL NUMERO DE MUSICOS POR BANDA Y LE MULTIPLICA EL CACHE
	SELECT COUNT(M.ID) * 105 FROM LFMusicosBandas AS MB 
	INNER JOIN LFMusicos AS M ON M.ID = MB.IDMusico
	WHERE MB.IDBanda = 1

	--CONTAMOS EL NUMERO DE ACTUACIONES EN LOS ULTIMOS 3 A�OS Y LOS MULTIPLICAMOS POR SU CACHE
	SELECT COUNT(TBE.IDBanda) FROM LFBandas AS B

		--aqui a�adirimos en caso de que toque tal... y en caso de que toque lo otro...
		CASE
			WHEN  THEN 
			WHEN  THEN 	
		END AS CACHE

	INNER JOIN LFTemasBandasEdiciones AS TBE ON B.ID = TBE.IDBanda
	INNER JOIN LFEdiciones AS E ON E.Ordinal = TBE.Ordinal AND E.IDFestival = TBE.IDFestival 
	WHERE DATEADD(YEAR, 3, CURRENT_TIMESTAMP) BETWEEN E.FechaHoraInicio AND E.FechaHoraFin

END
GO