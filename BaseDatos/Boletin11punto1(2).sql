GO
/*1.Crea una funci�n a la que pasemos un intervalo de tiempo y nos devuelva una tabla con el Happy day (el d�a que m�s ha ganado)
y el black day (el d�a que m�s ha perdido) de cada jugador.
Si hay m�s de un d�a en que haya ganado o perdido el m�ximo, tomaremos el m�s reciente.
Columnas:
	ID del jugador
	Nombre
	Apellidos
	Fecha del happy day
	Cantidad ganada
	Fecha del black day
	Cantidad perdida
*/

SELECT * FROM LTApuntes
SELECT IDJugador, Fecha, Importe, Saldo FROM LTApuntes

/*GO
ALTER VIEW [MaximoImportePorJugadorCadaDia] AS
	SELECT IDJugador, MAX(Importe) AS [Importe maximo] FROM LTApuntes
		WHERE Concepto NOT LIKE('Ingreso inicial')
		GROUP BY IDJugador
GO*/

/*SELECT a.IDJugador, apuntes.Fecha, MAX(a.[Importe maximo])
	FROM (SELECT IDJugador, MAX(Importe) AS [Importe maximo] FROM LTApuntes
			WHERE Concepto NOT LIKE('Ingreso inicial')
			GROUP BY IDJugador) AS a
	INNER JOIN LTApuntes AS apuntes
	ON a.IDJugador = apuntes.IDJugador
		WHERE a.[Importe maximo] = apuntes.Importe
	GROUP BY a.IDJugador, apuntes.Fecha
	ORDER BY IDJugador*/

--Happy Day
GO
CREATE VIEW HappyDay AS
	SELECT a.IDJugador, MAX(a.Fecha) AS [Happy Day], a.[importe max] AS [Importe m�ximo]
		FROM (SELECT a.IDJugador, apuntes.Fecha, MAX(a.[Importe maximo]) AS [importe max]
				FROM (SELECT IDJugador, MAX(Importe) AS [Importe maximo] FROM LTApuntes
						WHERE Concepto NOT LIKE('Ingreso inicial')
						GROUP BY IDJugador) AS a
				INNER JOIN LTApuntes AS apuntes
				ON a.IDJugador = apuntes.IDJugador
					WHERE a.[Importe maximo] = apuntes.Importe
				GROUP BY a.IDJugador, apuntes.Fecha) AS a
		GROUP BY a.IDJugador, a.[importe max]
		--ORDER BY a.IDJugador, a.[importe max]
GO

--Black Day
GO
CREATE VIEW BlackDay AS
	SELECT a.IDJugador, MAX(a.Fecha) AS [Black Day], a.[importe min] AS [Importe m�nimo]
		FROM (SELECT a.IDJugador, apuntes.Fecha, MIN(a.[Importe minimo]) AS [importe min]
				FROM (SELECT IDJugador, MIN(Importe) AS [Importe minimo] FROM LTApuntes
						WHERE Concepto NOT LIKE('Ingreso inicial')
						GROUP BY IDJugador) AS a
				INNER JOIN LTApuntes AS apuntes
				ON a.IDJugador = apuntes.IDJugador
					WHERE a.[Importe minimo] = apuntes.Importe
				GROUP BY a.IDJugador, apuntes.Fecha) AS a
		GROUP BY a.IDJugador, a.[importe min]--, a.Fecha
		--ORDER BY a.IDJugador, a.[importe min]--, a.Fecha
GO

SELECT j.ID, j.Nombre, j.Apellidos, hd.[Happy Day], hd.[Importe m�ximo], bd.[Black Day], bd.[Importe m�nimo]
	FROM LTJugadores AS j
	INNER JOIN HappyDay AS hd
	ON j.ID = hd.IDJugador
	INNER JOIN BlackDay AS bd
	ON hd.IDJugador = bd.IDJugador
	ORDER BY j.ID

/*Creo la funci�n (debe ir entre GO porque tiene que ser la �nica instrucci�n del bloque)*/
GO
CREATE FUNCTION HappyDayBlackDay (@fechaInicio date, @fechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT j.ID, j.Nombre, j.Apellidos, hd.[Happy Day], hd.[Importe m�ximo], bd.[Black Day], bd.[Importe m�nimo]
				FROM LTJugadores AS j
				INNER JOIN HappyDay AS hd
				ON j.ID = hd.IDJugador
				INNER JOIN BlackDay AS bd
				ON hd.IDJugador = bd.IDJugador
					WHERE (hd.[Happy Day] BETWEEN @fechaInicio AND @fechaFin) AND (bd.[Black Day] BETWEEN @fechaInicio AND @fechaFin))
GO

--Declaro las dos variable que voy a utilizar
DECLARE @fechaInicio date, @fechaFin date
SET @fechaInicio = '2018-03-03' --Le doy un valor a la primera variable
SET @fechaFin = '2018-03-05' --Le doy un valor a la segunda variable

/*Utilizo la funci�n con las dos variables de antes*/
SELECT * FROM HappyDayBlackDay (@fechaInicio, @fechaFin)
GO

/*2.Se ha creado un coeficiente para valorar los caballos.
Se calcula sumando el n�mero de carreras ganadas multiplicado por cinco m�s el n�mero de carreras en las que ha quedado segundo multiplicado por tres.
El resultado se divide entre el n�mero de carreras disputadas multiplicado por 0,2.
Al resultado de todo eso de lo multiplica por un coeficiente de edad que se calcula seg�n la tabla siguiente:

						Edad						Valor

						Seis o menos a�os ......... 100

						Siete ..................... 90

						Ocho o nueve .............. 75

						Diez ...................... 65

						M�s de diez ............... 40
*/
SELECT IDCaballo, COUNT(IDCaballo) AS [Cantidad de victorias] FROM LTCaballosCarreras
	WHERE Posicion = 1 OR Posicion = 2
	GROUP BY IDCaballo

GO
--Cantidad de veces que el caballo ha quedado en primer lugar
CREATE VIEW [CantidadPrimerosPremios] AS
SELECT IDCaballo, COUNT(IDCaballo) AS [Cantidad de victorias primero] FROM LTCaballosCarreras
	WHERE Posicion = 1
	GROUP BY IDCaballo
GO

GO
--Cantidad de veces que el caballo ha quedado en segundo lugar
CREATE VIEW [CantidadSegundosPremios] AS
SELECT IDCaballo, COUNT(IDCaballo) AS [Cantidad de victorias segundo] FROM LTCaballosCarreras
	WHERE Posicion = 2
	GROUP BY IDCaballo
GO

GO
--Cantidad de participaciones por caballo
CREATE VIEW [CantidadParticipaciones] AS
SELECT IDCaballo, COUNT(IDCaballo) AS [Cantidad de participaciones] FROM LTCaballosCarreras
	GROUP BY IDCaballo
GO

GO
--Edad del caballo
CREATE VIEW [EdadCaballo] AS
SELECT ID, Year(Current_Timestamp -CAST(FechaNacimiento AS SmallDateTime))-1900 AS [A�os] FROM LTCaballos
GO

SELECT cab.ID, ISNULL(c1p.[Cantidad de victorias primero], 0) AS [Cantidad de victorias primero], ISNULL(c2p.[Cantidad de victorias segundo], 0) AS [Cantidad de victorias segundo], cpa.[Cantidad de participaciones] AS [Cantidad de participaciones], edad.A�os AS [A�os]
	FROM LTCaballos AS cab
	LEFT JOIN CantidadPrimerosPremios AS c1p
	ON cab.ID = c1p.IDCaballo
	LEFT JOIN CantidadSegundosPremios AS c2p
	ON cab.ID = c2p.IDCaballo
	LEFT JOIN CantidadParticipaciones AS cpa
	ON cab.ID = cpa.IDCaballo
	INNER JOIN EdadCaballo AS edad
	ON edad.ID = cab.ID
	ORDER BY cab.ID

/*Creo la funci�n escalar (entre GO porque tiene que ser la �nica instrucci�n del bloque)*/
GO
CREATE FUNCTION FnValorCaballo (@IDCaballo smallint)
	RETURNS int AS
		BEGIN
			DECLARE @valorCaballo decimal(10,5)
			DECLARE @valorSinEdad decimal(10,5)

			SELECT @valorSinEdad = ((a.[Cantidad de victorias primero]*5) + (a.[Cantidad de victorias segundo]*3) / (a.[Cantidad de participaciones]*0.2)) FROM (SELECT cab.ID, ISNULL(c1p.[Cantidad de victorias primero], 0) AS [Cantidad de victorias primero], ISNULL(c2p.[Cantidad de victorias segundo], 0) AS [Cantidad de victorias segundo], cpa.[Cantidad de participaciones] AS [Cantidad de participaciones], edad.A�os AS [A�os]
								FROM LTCaballos AS cab
								LEFT JOIN CantidadPrimerosPremios AS c1p
								ON cab.ID = c1p.IDCaballo
								LEFT JOIN CantidadSegundosPremios AS c2p
								ON cab.ID = c2p.IDCaballo
								LEFT JOIN CantidadParticipaciones AS cpa
								ON cab.ID = cpa.IDCaballo
								INNER JOIN EdadCaballo AS edad
								ON edad.ID = cab.ID
								ORDER BY cab.ID) AS a


			SELECT nombre_artistico,
				CASE tipo_artista
					WHEN 'Cantaor' THEN 'Garganta privilegiada'
					WHEN 'Tocaor' THEN 'Manitas de plata'
					WHEN 'Bailaor' THEN 'Arte en movimiento'
					ELSE 'Este se ha colado'
				END AS Especialidad FROM BF_Artistas

			RETURN @valorCaballo

		END
GO

--SELECT * FROM LTApuestas

/*Declaro las variables que voy a utilizar y les doy unos valores con SET*/
DECLARE @IDCaballo smallint
SET @IDCaballo = 1

/*Utilizo la funci�n escalar con las dos variables de antes*/
SELECT dbo.FnTotalApostadoCC (@IDCaballo, @IDCarrera) AS [Dinero apostado a un caballo en una carrera]
	


/*3.Queremos saber la cantidad de dinero en apuestas que mueve cada hip�dromo.
Haz una funci�n a la que se le pase un rango de fechas y nos devuelva el dinero movido en apuestas en cada hip�dromo entre esas fechas.
Tambi�n queremos saber cu�l fue la apuesta m�s alta de ese periodo.
Considerar solo las apuestas, no los premios.
Columnas:
	Nombre del hip�dromo
	Cantidad gestionada
	Fecha de la apuesta m�s alta
	Importe de la apuesta m�s alta
	Otra columna que tomar� los valores G,C o P seg�n si esa apuesta acert� el primero (Ganador), el segundo (Colocado) o no obtuvo premio (Pierde)
*/

SELECT * FROM LTApuestas
SELECT * FROM LTApuntes

GO
CREATE VIEW [ApuestaMasAlta] AS
	SELECT MAX(apu.Importe) AS [Apuesta m�s alta]
		FROM LTApuestas AS apu
		INNER JOIN LTCarreras AS car
		ON apu.IDCarrera = car.ID
GO

SELECT * FROM 

/*Creo la funci�n (debe ir entre GO porque tiene que ser la �nica instrucci�n del bloque)*/
GO
CREATE FUNCTION DineroMovido (@fechaInicio date, @fechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT car.Hipodromo, SUM(apu.Importe) AS [Dinero movido]
				FROM LTApuestas AS apu
				INNER JOIN LTCarreras AS car
				ON apu.IDCarrera = car.ID
				INNER JOIN ApuestaMasAlta AS apumax
				ON 
					WHERE car.Fecha BETWEEN @fechaInicio AND @fechaFin
					GROUP BY car.Hipodromo)
GO

--Declaro las dos variable que voy a utilizar
DECLARE @fechaInicio date, @fechaFin date
SET @fechaInicio = '2018-01-20' --Le doy un valor a la primera variable
SET @fechaFin = '2018-03-02' --Le doy un valor a la segunda variable

/*Utilizo la funci�n con las dos variables de antes*/
SELECT * FROM DineroMovido (@fechaInicio, @fechaFin)
GO

/*4.Haz una funci�n DescalificaCaballo que reciba como par�metros el ID de un Caballo y en ID de una carrera y descalifique a ese caballo en esa carrera.
Eso puede dar lugar, si el caballo qued� primero o segundo, a que haya que alterar los premios obtenidos.

a.Si el caballo descalificado fue primero:
	Crear apuntes para descontar los premios obtenidos por los que apostaron por �l,
	anular tambi�n los apuntes de los que apostaron por el segundo, que ahora pasa a ser primero y generar los apuntes correspondientes al nuevo premio.
	Crear los apuntes correspondientes al segundo premio para los que apostaron por el tercero, que ahora pasa a ser segundo.

b.Si el caballo descalificado fue segundo:
	Anular las ganancias de los que apostaron por �l.
	Crear los apuntes correspondientes al segundo premio para los que apostaron por el tercero, que ahora pasa a ser segundo.

La funci�n nos devolver� los apuntes que haya que insertar en la tabla Apuntes.
No se borra ning�n apunte.
Los que ya no sirvan se crea uno con el importe opuesto.
*/