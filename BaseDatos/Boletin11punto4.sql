/*
Ejercicio 1
Escribe un procedimiento EliminarUsuario que reciba como parámetro el DNI de un usuario, le coloque un NULL en la columna Sex y borre todas las reservas futuras de ese usuario.
Ten en cuenta que si alguna de esas reservas tiene asociado un alquiler de material habrá que borrarlo también.

He tenido en cuenta que la fecha actual es 2014-01-01
*/
SELECT * FROM Usuarios
SELECT * FROM Reservas
SELECT * FROM ReservasMateriales

--SELECT para ver las reservas que tiene cada usuario
SELECT u.DNI AS [ID usuario], r.Codigo AS [Codigo reserva], r.Fecha_Hora
	FROM Usuarios AS u
	INNER JOIN Reservas AS r
	ON u.ID = r.ID_Usuario
		ORDER BY u.DNI

--SELECT para ver la reserva de material de cada usuario
SELECT u.ID, r.Codigo, rm.IDMaterial, r.Fecha_Hora
	FROM Usuarios AS u
	LEFT JOIN Reservas AS r
	ON u.ID = r.ID_Usuario
	LEFT JOIN ReservasMateriales AS rm
	ON r.Codigo = rm.CodigoReserva
		--WHERE r.Fecha_Hora > '2014-01-01'

GO
CREATE PROCEDURE EliminarUsuario
	@DNI char(12)
AS
	BEGIN
		UPDATE Usuarios
			SET Sex = NULL
			WHERE DNI = @DNI

		DELETE rm
				FROM Usuarios AS u
				LEFT JOIN Reservas AS r
				ON u.ID = r.ID_Usuario
				LEFT JOIN ReservasMateriales AS rm
				ON r.Codigo = rm.CodigoReserva
					WHERE u.DNI = @DNI AND r.Fecha_Hora > '2014-01-01' AND rm.IDMaterial IS NOT NULL

		DELETE r
			FROM Usuarios AS u
			INNER JOIN Reservas AS r
			ON u.ID = r.ID_Usuario
				WHERE u.DNI = @DNI AND r.Fecha_Hora > '2014-01-01'
		
	END
GO

BEGIN TRANSACTION
	EXECUTE EliminarUsuario '59544420G'
	EXECUTE EliminarUsuario '29233672L'
ROLLBACK
COMMIT

/*
Ejercicio 2
Escribe un procedimiento que reciba como parámetros el código de una instalación y una fecha/hora (SmallDateTime)
y devuelva en otro parámetro de salida el ID del usuario que la tenía alquilada si en ese momento la instalación estaba ocupada.
Si estaba libre, devolverá un NULL.
*/
SELECT * FROM Usuarios
SELECT * FROM Reservas
SELECT * FROM Instalaciones

SELECT u.ID, r.Codigo AS [CodigoReserva], i.Codigo AS [CodigoInstalacion], r.Fecha_Hora
	FROM Usuarios AS u
	INNER JOIN Reservas AS r
	ON u.ID = r.ID_Usuario
	INNER JOIN Instalaciones AS i
	ON r.Cod_Instalacion = i.Codigo
		--WHERE @CodigoInstalacion = i.Codigo AND @Fecha = r.Fecha_Hora
		ORDER BY u.ID

GO
CREATE PROCEDURE InstalacionAlquilada
	 @CodigoInstalacion int
	,@Fecha smalldatetime
	,@IDUsuario char(12) OUTPUT
AS
	BEGIN
		IF EXISTS (SELECT u.ID, r.Codigo AS [CodigoReserva], i.Codigo AS [CodigoInstalacion], r.Fecha_Hora
						FROM Usuarios AS u
						INNER JOIN Reservas AS r
						ON u.ID = r.ID_Usuario
						INNER JOIN Instalaciones AS i
						ON r.Cod_Instalacion = i.Codigo
							WHERE @CodigoInstalacion = i.Codigo AND @Fecha = r.Fecha_Hora)
			BEGIN
				SET @IDUsuario = (SELECT u.ID
									FROM Usuarios AS u
									INNER JOIN Reservas AS r
									ON u.ID = r.ID_Usuario
									INNER JOIN Instalaciones AS i
									ON r.Cod_Instalacion = i.Codigo
										WHERE @CodigoInstalacion = i.Codigo AND @Fecha = r.Fecha_Hora)
			END
		ELSE
			BEGIN
				SET @IDUsuario = NULL
			END
	END
GO

BEGIN TRANSACTION
	DECLARE @IDUsuario char(12)
	EXECUTE InstalacionAlquilada 1, '2018-12-12 15:00:00', @IDUsuario OUTPUT
	PRINT ISNULL(@IDUsuario, 'NULL')
ROLLBACK
COMMIT

/*
Ejercicio 3
Escribe un procedimiento que reciba como parámetros el código de una instalación y dos fechas (DATE)
y devuelva en otro parámetro de salida el número de horas que esa instalación ha estado alquilada entre esas dos fechas, ambas incluidas.
Si se omite la segunda fecha, se tomará la actual con GETDATE().

Devuelve con return códigos de error si el código de la instalación es erróneo o si la fecha de inicio es posterior a la de fin.
*/
SELECT * FROM Usuarios
SELECT * FROM Reservas
SELECT * FROM Instalaciones

SELECT u.ID, r.Codigo AS [CodigoReserva], i.Codigo AS [CodigoInstalacion], r.Fecha_Hora
	FROM Usuarios AS u
	INNER JOIN Reservas AS r
	ON u.ID = r.ID_Usuario
	INNER JOIN Instalaciones AS i
	ON r.Cod_Instalacion = i.Codigo
		ORDER BY u.ID

SELECT i.Codigo AS [CodigoInstalacion], COUNT(r.Fecha_Hora) AS [Cantidad de horas alquilada]
	FROM Usuarios AS u
	INNER JOIN Reservas AS r
	ON u.ID = r.ID_Usuario
	INNER JOIN Instalaciones AS i
	ON r.Cod_Instalacion = i.Codigo
		WHERE i.Codigo = 1 AND r.Fecha_Hora BETWEEN '2008-01-01' AND '2014-01-01'
		GROUP BY i.Codigo	

GO
ALTER PROCEDURE InstalacionHorasAlquiladas
	 @CodigoInstalacion int
	,@HorasAlquiladas int OUTPUT
	,@FechaInicio date
	,@FechaFin date = NULL
AS
	BEGIN
		DECLARE @codigoError int = 0
		
		IF(@FechaFin IS NULL)
			BEGIN
				SET @FechaFin = GETDATE()
			END

		IF EXISTS (SELECT Codigo FROM Instalaciones)
			BEGIN
				IF (@FechaInicio < @FechaFin)
					BEGIN
						SET @HorasAlquiladas = (SELECT COUNT(r.Fecha_Hora) AS [Cantidad de horas alquilada]
													FROM Usuarios AS u
													INNER JOIN Reservas AS r
													ON u.ID = r.ID_Usuario
													INNER JOIN Instalaciones AS i
													ON r.Cod_Instalacion = i.Codigo
														WHERE i.Codigo = @CodigoInstalacion AND r.Fecha_Hora BETWEEN @FechaInicio AND @FechaFin)
					END
				ELSE
					BEGIN
						SET @codigoError = 2
					END
			END
		ELSE
			BEGIN
				SET @codigoError = 1
			END

		RETURN @codigoError
	END
GO

BEGIN TRANSACTION
	DECLARE @HorasAlquiladas int
	DECLARE @CodigoError int

	EXECUTE @CodigoError = InstalacionHorasAlquiladas 1, @HorasAlquiladas OUTPUT, '2008-01-01'
	PRINT CONCAT('Cantidad de horas alquilada: ', @HorasAlquiladas)
	PRINT CONCAT('Código de error: ', @CodigoError)
ROLLBACK
COMMIT

/*
Ejercicio 4
Escribe un procedimiento EfectuarReserva que reciba como parámetro el DNI de un usuario, el código de la instalación, la fecha/hora de inicio de la reserva y la fecha/hora final.

El procedimiento comprobará que los datos de entradas son correctos y grabará la correspondiente reserva. Devolverá el código de reserva generado mediante un parámetro de salida. Para obtener el valor generado usar la función @@identity tras el INSERT.

Devuelve un cero si la operación se realiza con éxito y un código de error según la lista siguiente:

3: La instalación está ocupada para esa fecha y hora
4: El código de la instalación es incorrecto
5: El usuario no existe
8: La fecha/hora de inicio del alquiler es posterior a la de fin
11: La fecha de inicio y de fin son diferentes
*/