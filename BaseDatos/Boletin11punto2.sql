/*
1.Escribe un procedimiento para dar de alta un nuevo jugador.
Los parámetros de entrada serán todos los datos del jugador y la cantidad de su aportación inicial para apostar.
El procedimiento insertará al jugador y generará su primer apunte.
*/
SELECT * FROM LTJugadores
SELECT * FROM LTApuntes

SELECT MAX(Orden)+1 FROM LTApuntes
	WHERE IDJugador = 1

GO
/*
Entradas:
	- ID del jugador
	- Nombre del jugador
	- Apellido del jugador
	- Dirección del jugador
	- Teléfono del jugador
	- Ciudad del jugador
	- Ingreso inicial
			 
Salidas: No tiene
*/
BEGIN TRANSACTION
GO
CREATE PROCEDURE AltaJugador @IDJugador int, @NombreJugador varchar(20), @ApellidosJugador varchar(30), @DireccionJugador varchar(50), @TelefonoJugador char(9), @CiudadJugador varchar(20), @IngresoInicial smallmoney
AS
	BEGIN
		INSERT INTO LTJugadores(ID, Nombre, Apellidos, Direccion, Telefono, Ciudad)
			VALUES(@IDJugador, @NombreJugador, @ApellidosJugador, @DireccionJugador, @TelefonoJugador, @CiudadJugador)

		INSERT INTO LTApuntes(IDJugador, Orden, Fecha, Importe, Saldo, Concepto)
				VALUES(@IDJugador, 1, CURRENT_TIMESTAMP, @IngresoInicial, @IngresoInicial, 'Ingreso inicial')

		/*IF EXISTS (SELECT * FROM LTApuntes WHERE IDJugador = @IDJugador)
			BEGIN
				INSERT INTO LTApuntes(IDJugador, Orden, Fecha, Importe, Saldo, Concepto)
					VALUES(@IDJugador, (SELECT MAX(Orden)+1 FROM LTApuntes WHERE IDJugador = @IDJugador), CURRENT_TIMESTAMP, @IngresoInicial, @IngresoInicial, 'Ingreso inicial')
			END
		ELSE
			BEGIN
				INSERT INTO LTApuntes(IDJugador, Orden, Fecha, Importe, Saldo, Concepto)
					VALUES(@IDJugador, 1, CURRENT_TIMESTAMP, @IngresoInicial, @IngresoInicial, 'Ingreso inicial')
			END*/
		
	END -- Procedure AltaJugador
ROLLBACK
COMMIT
GO

EXECUTE AltaJugador 999, 'Pajarito', 'Illane', 'Calle Alpiste', 666666666, 'Utrera', 500


/*
2.Escribe un procedimiento para inscribir un caballo en una carrera.
El procedimiento tendrá como parámetros de entrada el ID de la carrera y el ID del caballo,
y devolverá un parámetro de salida que indicará el número asignado al caballo en esa carrera.

El número estará comprendido entre 1 y 99 y lo puedes asignar por el método que quieras,
aunque teniendo en cuenta que no puede haber dos caballos con el mismo número en una carrera.

Si la carrera no existe, si hay ocho caballos ya inscritos o si el caballo no existe o está ya inscrito en esa carrera, el parámetro de salida devolverá NULL.
*/
SELECT TOP 1 Numero FROM LTCaballosCarreras
	WHERE IDCarrera = 2
	ORDER BY IDCarrera DESC
SELECT * FROM LTCaballos
SELECT * FROM LTCarreras

SELECT COUNT(IDCarrera) AS [Numero de caballos por carrera] FROM LTCaballosCarreras WHERE IDCarrera = 25
SELECT * FROM LTCaballos WHERE ID = 2

SELECT Numero FROM LTCaballosCarreras WHERE IDCarrera = 25

/* https://blog.sqlauthority.com/2007/04/29/sql-server-random-number-generator-script-sql-query/ */

BEGIN TRANSACTION
GO
CREATE PROCEDURE InscribirCaballo @IDCarrera smallint, @IDCaballo smallint, @valorReturn int OUTPUT
AS
	BEGIN
		DECLARE @CaballosPorCarrera int = (SELECT COUNT(IDCarrera) AS [Numero de caballos por carrera] FROM LTCaballosCarreras WHERE IDCarrera = @IDCarrera)
		DECLARE @Random int = (ROUND(((99 - 1 -1) * RAND() + 1), 0))	--Print @Random		--Que el Pablo diga lo que no se me ocurrió a mi por parguela (¡Grande Pablo!)
		--DECLARE @NumeroUltimoCaballoInscrito int = (SELECT TOP 1 Numero FROM LTCaballosCarreras WHERE IDCarrera = @IDCarrera AND IDCaballo = @IDCaballo)
		--SELECT Numero FROM LTCaballosCarreras WHERE IDCarrera = @IDCarrera

		WHILE @Random IN (SELECT Numero FROM LTCaballosCarreras WHERE IDCarrera = @IDCarrera)
			BEGIN
				--PRINT 'Hola, soy un print para saber si se ejecuta el random'
				SET @Random = (ROUND(((99 - 1 -1) * RAND() + 1), 0))
			END

		IF EXISTS (SELECT * FROM LTCaballosCarreras WHERE IDCarrera = @IDCarrera)
			BEGIN
				IF (@CaballosPorCarrera < 8)
					BEGIN
						IF EXISTS (SELECT * FROM LTCaballos WHERE ID = @IDCaballo)
							BEGIN
								IF NOT EXISTS (SELECT * FROM LTCaballosCarreras WHERE IDCaballo = @IDCaballo AND IDCarrera = @IDCarrera)
									BEGIN

										INSERT INTO LTCaballosCarreras(IDCaballo, IDCarrera, Numero, Posicion, Premio1, Premio2)
											VALUES(@IDCaballo, @IDCarrera, @Random, NULL, NULL, NULL)

										SET @valorReturn = @Random
									END
								ELSE
									BEGIN
										SET @valorReturn = NULL
										PRINT 'El caballo seleccionado ya participa en esta carrera' --Depuración
									END
							END
						ELSE
							BEGIN
								SET @valorReturn = NULL
								PRINT 'El caballo seleccionado no existe'
							END
					END
				ELSE
					BEGIN
						SET @valorReturn = NULL
						PRINT 'La carrera ya tiene el número máximo de caballos'
					END
			END
		ELSE
			BEGIN
				SET @valorReturn = NULL
				PRINT 'La carrera seleccionada no existe'
			END

	END --PROCEDURE InscribirCaballo
ROLLBACK
COMMIT
GO

DECLARE @salida int
EXECUTE InscribirCaballo 25, 7, @salida OUTPUT
PRINT ISNULL(@salida,666)

SELECT * FROM LTCaballosCarreras
	WHERE IDCarrera = 25

/*
3.Añade a la tabla LTJugadores una nueva columna llamada LimiteCredito de tipo SmallMoney con el valor por defecto 50.
Este valor indicará el máximo saldo negativo que se permite al jugador.
El saldo del jugador más el valor de esa columna no puede ser nunca inferior a 0.
Escribe un procedimiento para grabar una apuesta.
El procedimiento recibirá como parámetros el jugador, la carrera, el caballo y el importe a apostar y devolverá con return un código de terminación según la siguiente tabla:

			Circunstancia								Valor

			La carrera no existe ........................ 2								SI LA CARRERA EXISTE *

			La carrera ya se ha disputado ............... 3								SI LA CARRERA NO SE HA DISPUTADO *

			El caballo no corre en esa carrera .......... 5								SI EL CABALLO CORRE EN ESA CARRERA *

			El saldo del jugador no es suficiente ....... 10							SI EL SALDO DEL JUGADOR ES SUFICIENTE (que no supere el LimiteCredito) *

			Ninguna de las anteriores ................... 0

*/
/*GO
Create Procedure GrabarApuesta AS
Begin
	Declare @Salida SmallInt = 0
	If -- La carrera existe
		Set @Salida = 2
	Else

	Return @Salida
End	-- Procedure GrabarApuesta
GO
--^Pruebas
Declare @Terminacion SmallInt
Execute @Terminacion = GrabarApuesta*/


SELECT * FROM LTJugadores
SELECT * FROM LTCarreras
SELECT * FROM LTApuestas
SELECT * FROM LTCaballosCarreras
SELECT * FROM LTApuntes

SELECT ID, Fecha FROM LTCarreras

SELECT IDCarrera FROM LTCaballosCarreras
	WHERE IDCaballo = 1

SELECT IDJugador, MAX(Orden) FROM LTApuntes
	--WHERE IDJugador = 1
	GROUP BY IDJugador

/*SELECT apuntes.IDJugador ,apuntes.Saldo, a.orden
	FROM LTApuntes AS apuntes
	INNER JOIN (SELECT IDJugador, MAX(Orden) AS orden FROM LTApuntes
					GROUP BY IDJugador) AS a
	ON apuntes.Orden = a.orden
	WHERE */

GO --ALTER para añadir la nuevaldoa columna LimiteCredito
BEGIN TRANSACTION
	ALTER TABLE LTJugadores
	ADD LimiteCredito smallmoney NOT NULL DEFAULT(50)
ROLLBACK
COMMIT
GO

BEGIN TRANSACTION
GO
	CREATE PROCEDURE GrabarApuesta @IDJugador int, @IDCarrera smallint, @IDCaballo smallint, @Importe money
	AS
		BEGIN
			DECLARE @Salida smallint
			DECLARE @SaldoActual money = (SELECT TOP 1 Saldo FROM LTApuntes
											WHERE IDJugador = 1
											ORDER BY Orden DESC)

			IF EXISTS (SELECT * FROM LTCaballosCarreras WHERE IDCarrera = @IDCarrera)
				BEGIN
					IF ((SELECT Fecha FROM LTCarreras WHERE ID = @IDCarrera) > CURRENT_TIMESTAMP)
						BEGIN
							IF EXISTS (SELECT IDCarrera FROM LTCaballosCarreras WHERE IDCaballo = @IDCaballo AND IDCarrera = @IDCarrera)
								BEGIN
									IF ((@SaldoActual + (SELECT LimiteCredito FROM LTJugadores WHERE ID = @IDJugador)) >= 0)
										BEGIN
											INSERT INTO LTApuestas(ID, Clave, IDCaballo, IDCarrera, Importe, IDJugador)
												VALUES( ((SELECT TOP 1 ID FROM LTApuestas ORDER BY ID DESC)+1), NULL, @IDCaballo, @IDCarrera, @Importe, @IDJugador)

											INSERT INTO LTApuntes(IDJugador, Orden, Fecha, Importe, Saldo, Concepto)
												VALUES(@IDJugador, (SELECT TOP 1 Orden FROM LTApuntes WHERE IDJugador = @IDJugador ORDER BY Orden DESC), CURRENT_TIMESTAMP, NULL, NULL, NULL)

											SET @Salida = 0
										END
									ELSE
										BEGIN
											SET @Salida = 10
										END
								END
							ELSE
								BEGIN
									SET @Salida = 5
								END
						END
					ELSE
						BEGIN
							SET @Salida = 3
						END
				END
			ELSE
				BEGIN
					SET @Salida = 2
				END
		END --Procedure GrabarApuesta
ROLLBACK
COMMIT
GO

Declare @Terminacion SmallInt
Execute @Terminacion = GrabarApuesta 1, 11, 1, 10
PRINT @Terminacion

/*
4.Algunas veces se bonifica a los jugadores que más apuestan reglándoles saldo extra.
Escribe un procedimiento AplicarBonificacion que reciba como parámetros un rango de fechas, la cantidad mínima apostada para tener derecho a la bonificación y la cuantía de la bonificación.
También un parámetro de tipo bit. Si ese parámetro vale 0, la bonificación se entiende como una cantidad de dinero que se suma a todos los que cumplan los criterios de fecha y cantidad apostada.
Si el parámetro vale 1, la bonificación que hay que sumar será igual a un porcentaje del total apostado entre esas dos fechas.
En este segundo caso, el valor de la bonificación no podrá ser superior a 10.
El procedimiento debe generar los apuntes que correspondan con el concepto "Bonificación”
*/

/*
5.Escribe un procedimiento almacenado que calcule y actualice los valores de las columnas Premio1 y Premio2 de la tabla LTCaballosCarreras.
El procedimiento recibirá un parámetro que será el ID de la carrera y devolverá un código de error en un parametro de salida que valdrá 1 si la carrera ya se ha disputado, 3 si no existe y 0 en los demás casos.
Los valores de Premio1 y Premio2 se calcularán de acuerdo a las instrucciones del ejercicio 4 del boletín 11.0.
*/