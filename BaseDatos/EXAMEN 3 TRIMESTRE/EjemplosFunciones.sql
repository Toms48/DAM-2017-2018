USE AirLeo
-- Funciones sencillas
-- Funci�n que nos devuelva la duraci�n de un vuelo
CREATE FUNCTION FN_HorasVuelo (@CodigoVuelo Int) 
	RETURNS TinyInt
	AS
	BEGIN
		DECLARE @Horas TinyInt = 0
		SELECT @Horas = DATEDIFF(minute,Salida,Llegada)/60 FROM AL_Vuelos WHERE Codigo = @CodigoVuelo
		RETURN @Horas
	END
	GO
SELECT dbo.FN_HorasVuelo (900)
GO
-- Funci�n que devuelva el numero de horas de un avi�n
ALTER FUNCTION FN_HorasVueloAvion (@MatriculaAvion Char(10)) 
	RETURNS Int
	AS
	BEGIN
		DECLARE @Horas Int = 0
		SELECT @Horas = SUM(DATEDIFF(minute,Salida,Llegada)/60) FROM AL_Vuelos WHERE Matricula_Avion = @MatriculaAvion
		RETURN @Horas
	END
	GO
-- Pruebas
SELECT dbo.FN_HorasVueloAvion ('USA5068   ')
GO
-- Funci�n que devuelva el numero de horas de un avi�n usando la primera funci�n
CREATE FUNCTION FN_HorasVueloAvion2 (@MatriculaAvion Char(10)) 
	RETURNS Int
	AS
	BEGIN
		DECLARE @Horas Int = 0
		SELECT @Horas = SUM(dbo.FN_HorasVuelo(Codigo)) FROM AL_Vuelos WHERE Matricula_Avion = @MatriculaAvion
		RETURN @Horas
	END
	GO

-- Para comparar ambas
SELECT dbo.FN_HorasVueloAvion ('USA5068   ')
SELECT dbo.FN_HorasVueloAvion2('USA5068   ')


-- Funciones m�s interesantes
USE CentroDeportivo
GO

--Funci�n Escalar
--Nos devuelve el n�meor de veces que se ha alquilado una instalaci�n, cuyo c�digo pasamos como par�metro
CREATE FUNCTION NumAlquileres (@CodigoInstalacion int) RETURNS SmallInt AS
	BEGIN
	DECLARE @Resultado SmallInt
	SELECT @Resultado = COUNT (*) FROM Reservas WHERE Cod_Instalacion = @CodigoInstalacion
	RETURN @Resultado
	END
GO
--Prueba
Print dbo.NumAlquileres (12)

--Funciones que devuelven tablas
-- Funcion INLINE

--Funci�n que nos devuelva una tabla con todas las instalaciones que ha reservado un usuario concreto, indicando cu�ntas veces las ha reservado y cu�nto ha pagado

--SELECT ORIGINAL
SELECT I.Codigo, I.Descripcion, COUNT (*) AS [Num veces], SUM(R.Tiempo*I.Precio_Hora) AS [Total pagado] FROM Usuarios AS U
	JOIN Reservas AS R ON U.ID = R.ID_Usuario
	JOIN Instalaciones AS I ON R.Cod_Instalacion = I.Codigo
	WHERE U.DNI = '30244478G'
	GROUP BY I.Codigo, I.Descripcion

-- Lo convertimos en FUNCTION
GO
CREATE FUNCTION UsoInstalaciones (@DNI_Usuario AS CHAR(9)) RETURNS TABLE AS
	RETURN (SELECT I.Codigo, I.Descripcion, COUNT (*) AS [Num veces], SUM(R.Tiempo*I.Precio_Hora) AS [Total pagado] FROM Usuarios AS U
	JOIN Reservas AS R ON U.ID = R.ID_Usuario
	JOIN Instalaciones AS I ON R.Cod_Instalacion = I.Codigo
	WHERE U.DNI = @DNI_Usuario
	GROUP BY I.Codigo, I.Descripcion)
GO
--Probamos la funci�n
SELECT * FROM UsoInstalaciones ('30244478G')
GO
--Funci�n de m�ltiples intrucciones
-- Queremos a�adir a la anterior dos columnas que indiquen el total de veces que se ha reservado esa instalaci�n y qu� porcentaje significa ese usuario respecto del total
CREATE FUNCTION UsoInstalacionesPorcentaje (@DNI_Usuario AS CHAR(9)) RETURNS @Resultado TABLE (
		Codigo int Not NULL
		,NombreInstalacion VarChar(50) NULL
		,TotalAlquileres SmallInt NULL
		,AlquileresUsuario SmallInt NULL
		,Porcentaje AS AlquileresUsuario*100/NULLIF(TotalAlquileres,0)
		,ImportePagado SmallMoney NULL
		) AS
	BEGIN
		INSERT @Resultado (Codigo,NombreInstalacion,AlquileresUsuario,ImportePagado) --Omitimos las columnas nuevas
			SELECT Codigo, Descripcion, [Num veces],[Total pagado]  FROM UsoInstalaciones (@DNI_Usuario)
		UPDATE @Resultado 
			SET TotalAlquileres = dbo.NumAlquileres(Codigo)
		RETURN
	END -- FUNCTION UsoInstalacionesPorcentaje
GO
--Prueba
SELECT * FROM UsoInstalacionesPorcentaje ('30244478G')