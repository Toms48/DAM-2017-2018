/*USE Ejemplos
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
GO*/
USE pubs
GO

--SELECT simple
/*
SELECT * FROM employee
	WHERE job_lvl <= 75
*/

--PROCEDURE
BEGIN TRANSACTION
GO
	CREATE PROCEDURE ReiniciarNivelTrabajo
	AS
		BEGIN
			UPDATE employee
				SET job_lvl = 0
				WHERE job_lvl <= 75
		END
ROLLBACK
COMMIT
GO

EXECUTE ReiniciarNivelTrabajo


DECLARE @IDEmpleado char(9)
DECLARE @JobLevel tinyint

DECLARE RecorrerNiveles CURSOR FOR SELECT emp_id, job_lvl FROM employee
		WHERE job_lvl <= 75

OPEN RecorrerNiveles
	FETCH NEXT FROM RecorrerNiveles INTO @IDEmpleado, @JobLevel
	WHILE @@FETCH_STATUS <> -1
		BEGIN

			EXECUTE ReiniciarNivelTrabajo

			FETCH NEXT FROM RecorrerNiveles INTO @IDEmpleado, @JobLevel
		END
CLOSE RecorrerNiveles
DEALLOCATE RecorrerNiveles
