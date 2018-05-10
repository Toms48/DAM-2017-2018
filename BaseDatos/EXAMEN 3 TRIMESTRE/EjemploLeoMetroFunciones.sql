USE LeoMetro
GO
-- FnCuentaParadas
-- Funci�n que nos devuelve el n�mero de veces que un tren ha parado en una estaci�n en un periodo
-- Entrada: ID del tren (int), ID de la Estaci�n (SmallInt), inicio del periodo (date), fin del periodo (date)
-- Salida: n�mero de veces que un tren ha parado en la estaci�n proporcionada entre esas dos fechas

ALTER FUNCTION FnCuentaParadas (@IDTren Int, @IDEstacion SmallInt, @Inicio Date, @Fin Date) RETURNS Int AS
BEGIN
	DECLARE @Veces Int = 0
	SELECT @Veces = Count(*) FROM LM_Recorridos
		WHERE Tren = @IDTren AND estacion = @IDEstacion AND CAST (Momento AS DATE) Between @Inicio AND @Fin
	RETURN @Veces
END

GO

-- Ejemplos de uso
-- Sencillo
DECLARE @Paradas Int
SET @Paradas = dbo.FnCuentaParadas (108,5,DATEFROMPARTS (1990,1,1),DATEFROMPARTS (2020,1,1))
PRINT @Paradas

-- Consulta que nos indica cuantas veces ha pasado un tren por cada una de las estaciones
DECLARE @Tren Int = 106

SELECT E.ID, E.Denominacion, dbo.FnCuentaParadas (@Tren,E.ID,DATEFROMPARTS (1990,1,1),DATEFROMPARTS (2020,1,1))
	FROM LM_Estaciones AS E
