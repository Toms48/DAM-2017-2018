USE Ejemplos
GO
DECLARE @ID Int
DECLARE @Palabrita NVarChar(20)
DECLARE RecorrePalabras CURSOR FOR SELECT ID, Palabra FROM Palabras2
	ORDER BY Palabra
--Bucle para recorrer una tabla con un Cursor
OPEN RecorrePalabras
-- Posicionamos el cursor
FETCH NEXT FROM RecorrePalabras INTO @ID, @Palabrita
WHILE @@FETCH_STATUS <> -1
	BEGIN
	-- Procesamos la fila
	PRINT @Palabrita
	--Actualizamos el cursor
	FETCH NEXT FROM RecorrePalabras INTO @ID, @Palabrita
	END -- WHILE
CLOSE RecorrePalabras
DEALLOCATE RecorrePalabras
GO

USE pubs
GO

SELECT * FROM employee
	WHERE job_lvl <= 75