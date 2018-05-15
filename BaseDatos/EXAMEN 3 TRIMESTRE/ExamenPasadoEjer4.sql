USE LeoFest

--Ejercicio 4
--Escribe un procedimiento almacenado que actualice la columna caché de la tabla LFBandas de acuerdo a las siguientes reglas:
--•	Se computarán 105 € por cada miembro activo de la banda
--•	Se añadirán 170 € por cada actuación en los tres años anteriores
--•	Esa cantidad se incrementará un 5% si la banda toca alguno de los estilos Rock, Flamenco, Jazz o Blues y se decrementará un 50% si toca 
--	Reggaeton o Hip-Hop

SELECT * FROM LFBandas
SELECT * FROM LFMusicosBandas WHERE IDBanda = 5

SELECT * FROM LFTemasBandasEdiciones
SELECT * FROM LFEdiciones
SELECT * FROM LFEstilos

GO

CREATE FUNCTION fnNumeroMiembrosActivosBanda(@IDBanda int)
RETURNS int AS
	BEGIN
		DECLARE @NumMusicosActivos int
		RETURN(
			SELECT COUNT(IDMusico)
			FROM LFMusicosBandas 
			WHERE IDBanda = @IDBanda AND FechaAbandono IS NULL
		)
	END
GO

PRINT dbo.fnNumeroMiembrosActivosBanda(2)

CREATE FUNCTION fnActuacionesUltimosTresAñosBanda(@IDBanda int)
	RETURNS int AS
	BEGIN
		RETURN(
		SELECT COUNT(IDBanda)
		FROM LFBandasEdiciones AS BE
		JOIN LFEdiciones AS E
			ON BE.IDFestival = E.IDFestival AND BE.Ordinal = E.Ordinal
		WHERE BE.IDBanda = @IDBanda 
			AND YEAR(E.FechaHoraInicio) BETWEEN YEAR(DATEADD(YEAR, -3, CURRENT_TIMESTAMP)) 
				AND YEAR(CURRENT_TIMESTAMP)
		)
	END
GO

PRINt dbo.fnActuacionesUltimosTresAñosBanda(2)

CREATE FUNCTION fnMultiplicadorEstiloBanda(@IDBanda int) --Rock, Flamenco, Jazz o Blues
	RETURNS decimal(4,2) AS
	BEGIN
		DECLARE @Multiplicador decimal(3,2) = 1
		DECLARE @HayPositivo int = 0
		DECLARE @Haynegativo int = 0

		SELECT @HayPositivo = SUM(
			CASE
			WHEN E.Estilo IN ('Rock', 'Flamenco', 'Jazz' , 'Blues') THEN 1
			ELSE 0
			END
			),@HayNegativo = SUM(
			CASE
			WHEN E.Estilo IN ('Reggaeton','Hip-Hop') THEN 1
			ELSE 0
			END
			)

		FROM LFBandasEstilos AS BA JOIN LFEstilos AS E ON BA.IDEstilo = E.ID
		WHERE BA.IDBanda = @IDBanda

		IF @HayPositivo>0
		BEGIN
			SET @Multiplicador = 1.05
		END
		ELSE
			IF @Haynegativo > 0
			BEGIN
				SET @Multiplicador = 0.5
			END
			ELSE
				SET @Multiplicador = 1

		RETURN @Multiplicador
	END
GO

SELECT * FROM LFBandasEstilos WHERE IDBanda = 2

PRINT dbo.fnMultiplicadorEstiloBanda(1)
PRINT dbo.fnMultiplicadorEstiloBanda(2)
PRINT dbo.fnMultiplicadorEstiloBanda(3)
PRINT dbo.fnMultiplicadorEstiloBanda(4)
PRINT dbo.fnMultiplicadorEstiloBanda(5)
PRINT dbo.fnMultiplicadorEstiloBanda(6)
PRINT dbo.fnMultiplicadorEstiloBanda(7)

GO

CREATE FUNCTION fnCalcularCacheBanda(@IDBanda int)
RETURNS decimal(9,2) AS
BEGIN

	DECLARE @cache decimal(9,2)
	SET @cache = ( dbo.fnNumeroMiembrosActivosBanda(@IDBanda) * 105 + dbo.fnActuacionesUltimosTresAñosBanda(@IDBanda) * 170 ) * dbo.fnMultiplicadorEstiloBanda(@IDBanda)

	RETURN @cache
END
GO

PRINT dbo.fnCalcularCacheBanda(1)
PRINT dbo.fnCalcularCacheBanda(2)
PRINT dbo.fnCalcularCacheBanda(3)
PRINT dbo.fnCalcularCacheBanda(4)
PRINT dbo.fnCalcularCacheBanda(5)
PRINT dbo.fnCalcularCacheBanda(6)
PRINT dbo.fnCalcularCacheBanda(7)

GO

CREATE PROCEDURE ActualizarCacheBandas
AS
BEGIN
	--BEGIN TRANSACTION
		UPDATE LFBandas
			SET CacheMinimo = dbo.fnCalcularCacheBanda(LFBandas.ID) 
	--COMMIT TRAN
END 
GO

SELECT * FROM LFBandas

BEGIN TRAN 
EXECUTE ActualizarCacheBandas