--Ejercicio 1
--Escribe un procedimiento almacenado que de de baja a una banda, actualizando su fecha de disolución y la fecha de abandono de todos 
--sus componentes actuales. La fecha de disolución y el ID de la banda se pasarán como parámetros.
--Si no se especifica fecha, se tomará la actual.

SELECT * FROM LFBandas
SELECT * FROM LFMusicosBandas

ALTER PROCEDURE DisolverBanda2 @IDBanda smallint, @FechaDisolucion date = NULL
AS
BEGIN
	IF (@FechaDisolucion IS NULL)
		BEGIN
			--UPDATE para actualizar la fecha de disolución de la banda que le pasamos por parámetros
			UPDATE LFBandas
				SET FechaDisolucion = CAST(CURRENT_TIMESTAMP AS date) --Como se cumple la condición de que no le hemos mandado una fecha por defecto lo pone a NULL y tenemos que poner la fecha actual (Casteamos porque CURRENT_TIMESTAMP es datetime)
				WHERE ID = @IDBanda

			--UPDATE para actualizar la fecha de abandono del músico de la banda pasada por parámetro
			UPDATE LFMusicosBandas
				SET FechaAbandono = CAST(CURRENT_TIMESTAMP AS date) --Como se cumple la condición de que no le hemos mandado una fecha por defecto lo pone a NULL y tenemos que poner la fecha actual (Casteamos porque CURRENT_TIMESTAMP es datetime)
				WHERE (IDBanda = @IDBanda) AND (FechaAbandono IS NULL) --Tenemos que actualizar la fecha de abandono donde (el ID de la banda sea el que le pasamos) y (que el músico no tenga ya una fecha de abandono) --Se pide que se cambien los que están actualmente en la banda, significa que tenemos que cambiar los que están a NULL
		END
	ELSE
		BEGIN
			--UPDATE para actualizar la fecha de disolución de la banda que le pasamos por parámetros
			UPDATE LFBandas
				SET FechaDisolucion = @FechaDisolucion --Como ahora sí le pasamos una fecha de disolución por parámetro se la asignamos y yasta tio, así de fasi bro
				WHERE ID = @IDBanda

			--UPDATE para actualizar la fecha de abandono del músico de la banda pasada por parámetro
			UPDATE LFMusicosBandas
				SET FechaAbandono = @FechaDisolucion --Como ahora sí le pasamos una fecha de disolución por parámetro se la asignamos
				WHERE (IDBanda = @IDBanda) AND (FechaAbandono IS NULL) --Tenemos que actualizar la fecha de abandono donde (el ID de la banda sea el que le pasamos) y (que el músico no tenga ya una fecha de abandono) --Se pide que se cambien los que están actualmente en la banda, significa que tenemos que cambiar los que están a NULL
		END
END

BEGIN TRANSACTION
	--Ejecutamos el procedimiento pero sin fecha
	EXECUTE DisolverBanda2 2

	--Ejecutamos el procedimiento pasandole los dos parámetros
	EXECUTE DisolverBanda2 2, '2018-05-24'
ROLLBACK
COMMIT

--Ejercicio 4
--Escribe un procedimiento almacenado que actualice la columna caché de la tabla LFBandas de acuerdo a las siguientes reglas:
--•	Se computarán 105 € por cada miembro activo de la banda
--•	Se añadirán 170 € por cada actuación en los tres años anteriores
--•	Esa cantidad se incrementará un 5% si la banda toca alguno de los estilos Rock, Flamenco, Jazz o Blues y se decrementará un 50% si toca 
--	Reggaeton o Hip-Hop

SELECT * FROM LFBandas
SELECT * FROM LFMusicosBandas

SELECT * FROM LFTemasBandasEdiciones
SELECT * FROM LFEdiciones
SELECT * FROM LFEstilos

--SELECT para tener el número de miembros activos en el grupo
GO
CREATE VIEW MiembrosActivos105 AS
SELECT b.ID, COUNT(IDMusico) * 105 [Cantidad de miembros activos * 105]
	FROM LFMusicosBandas AS mb
	RIGHT JOIN LFBandas AS b
	ON mb.IDBanda = b.ID AND FechaAbandono IS NULL
	GROUP BY b.ID
GO

/*GO
CREATE FUNCTION FnMiembrosActivos (@IDBanda smallint)
	RETURNS int AS
	BEGIN
		RETURN (SELECT COUNT(IDMusico) [Cantidad de miembros activos]
				FROM LFMusicosBandas AS mb
				WHERE mb.IDBanda = @IDBanda AND FechaAbandono IS NULL
			)
	END
GO
SELECT dbo.FnMiembrosActivos (7)*/



--SELECT para tener el numero de actuaniones
/*SELECT tbe.IDBanda, tbe.IDFestival, tbe.Ordinal, YEAR(edi.FechaHoraInicio)
	FROM LFTemasBandasEdiciones AS tbe
	INNER JOIN LFEdiciones AS edi
	ON tbe.IDFestival = edi.IDFestival AND tbe.Ordinal = edi.Ordinal
		ORDER BY YEAR(edi.FechaHoraInicio)

SELECT tbe.IDBanda, COUNT(tbe.IDBanda) * 107 AS [Cantidad de actuaciones]--, YEAR(edi.FechaHoraInicio) AS [Año de las actuaciones]

	FROM LFTemasBandasEdiciones AS tbe
	INNER JOIN LFEdiciones		AS edi  ON tbe.IDFestival = edi.IDFestival AND tbe.Ordinal = edi.Ordinal
	INNER JOIN LFBandas			AS b	ON tbe.IDBanda = b.ID
	INNER JOIN LFBandasEstilos	AS be	ON b.ID = be.IDBanda
	INNER JOIN LFEstilos		AS est  ON be.IDEstilo = est.ID

		WHERE YEAR(edi.FechaHoraInicio) BETWEEN YEAR(DATEADD(YEAR, -3, CURRENT_TIMESTAMP)) AND YEAR(CURRENT_TIMESTAMP)
		GROUP BY tbe.IDBanda--, YEAR(edi.FechaHoraInicio)
		--ORDER BY YEAR(edi.FechaHoraInicio)

SELECT tbe.IDBanda, COUNT(tbe.IDBanda) *
	CASE
		WHEN est.Estilo = 'Rock' THEN (107 + 5.35)
		WHEN est.Estilo = 'Flamenco' THEN (107 + 5.35)
		WHEN est.Estilo = 'Jazz' THEN (107 + 5.35)
		WHEN est.Estilo = 'Blues' THEN (107 + 5.35)
		WHEN est.Estilo = 'Reggaeton' THEN (107 - 53.5)
		WHEN est.Estilo = 'Hip-Hop' THEN (107 - 53.5)
		ELSE 107
	END AS [Cantidad de actuaciones]--, YEAR(edi.FechaHoraInicio) AS [Año de las actuaciones]

	FROM LFTemasBandasEdiciones AS tbe
	INNER JOIN LFEdiciones AS edi
	ON tbe.IDFestival = edi.IDFestival AND tbe.Ordinal = edi.Ordinal
	INNER JOIN LFBandas AS b
	ON tbe.IDBanda = b.ID
	INNER JOIN LFBandasEstilos AS be
	ON b.ID = be.IDBanda
	INNER JOIN LFEstilos AS est
	ON be.IDEstilo = est.ID
		WHERE YEAR(edi.FechaHoraInicio) BETWEEN YEAR(DATEADD(YEAR, -3, CURRENT_TIMESTAMP)) AND YEAR(CURRENT_TIMESTAMP)
		GROUP BY tbe.IDBanda, est.Estilo--, YEAR(edi.FechaHoraInicio)
		--ORDER BY YEAR(edi.FechaHoraInicio)*/

GO
CREATE VIEW Actuaciones3Anios107 AS
SELECT b.ID, ISNULL(a2.[Cantidad de actuaciones107],0) AS [Cantidad de actuaciones]
	FROM (SELECT a1.IDBanda, SUM(a1.[Cantidad de actuaciones * 107]) AS [Cantidad de actuaciones107]
			FROM ( SELECT tbe.IDBanda, COUNT(tbe.IDBanda) *
				CASE
					WHEN est.Estilo = 'Rock' THEN (107 + 5.35)
					WHEN est.Estilo = 'Flamenco' THEN (107 + 5.35)
					WHEN est.Estilo = 'Jazz' THEN (107 + 5.35)
					WHEN est.Estilo = 'Blues' THEN (107 + 5.35)
					WHEN est.Estilo = 'Reggaeton' THEN (107 - 53.5)
					WHEN est.Estilo = 'Hip-Hop' THEN (107 - 53.5)
					ELSE 107
				END AS [Cantidad de actuaciones * 107]--, YEAR(edi.FechaHoraInicio) AS [Año de las actuaciones]

				FROM LFTemasBandasEdiciones AS tbe
				INNER JOIN LFEdiciones AS edi
				ON tbe.IDFestival = edi.IDFestival AND tbe.Ordinal = edi.Ordinal
				INNER JOIN LFBandas AS b
				ON tbe.IDBanda = b.ID
				INNER JOIN LFBandasEstilos AS be
				ON b.ID = be.IDBanda
				INNER JOIN LFEstilos AS est
				ON be.IDEstilo = est.ID
					WHERE YEAR(edi.FechaHoraInicio) BETWEEN YEAR(DATEADD(YEAR, -3, CURRENT_TIMESTAMP)) AND YEAR(CURRENT_TIMESTAMP)
					GROUP BY tbe.IDBanda, est.Estilo--, YEAR(edi.FechaHoraInicio)
					--ORDER BY YEAR(edi.FechaHoraInicio)
			) AS a1
			GROUP BY a1.IDBanda
		 ) AS a2
	RIGHT JOIN LFBandas AS b
	ON a2.IDBanda = b.ID
GO

SELECT ma105.[Cantidad de miembros activos * 105] + a3a107.[Cantidad de actuaciones]
	FROM LFBandas AS b
	RIGHT JOIN MiembrosActivos105 AS ma105
	ON b.ID = ma105.ID
	RIGHT JOIN Actuaciones3Anios107 AS a3a107
	ON b.ID = a3a107.ID

GO
CREATE PROCEDURE TomasActualizarCache
AS
BEGIN

	BEGIN TRANSACTION
		UPDATE LFBandas
			SET CacheMinimo = (ma105.[Cantidad de miembros activos * 105] + a3a107.[Cantidad de actuaciones])
			FROM LFBandas AS b
			INNER JOIN MiembrosActivos105 AS ma105
			ON b.ID = ma105.ID
			INNER JOIN Actuaciones3Anios107 AS a3a107
			ON b.ID = a3a107.ID
	ROLLBACK
	COMMIT

END --PROCEDURE TomasActualizarCache
GO