/*1.Crea una funci�n inline llamada FnCarrerasCaballo que reciba un rango de fechas (inicio y fin) y
nos devuelva el n�mero de carreras disputadas por cada caballo entre esas dos fechas.
Las columnas ser�n:
	ID (del caballo)
	nombre
	sexo
	fecha de nacimiento
	n�mero de carreras disputadas.*/

/*Un SELECT para tener una tabla con los datos que me piden*/
SELECT cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento, COUNT(car.ID) AS [N�mero de carreras disputadas]
	FROM LTCaballosCarreras AS cc
	INNER JOIN LTCarreras AS car
	ON cc.IDCarrera = car.ID
	INNER JOIN LTCaballos AS cab
	ON cc.IDCaballo = cab.ID
		GROUP BY cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento

/*Creo la funci�n (debe ir entre GO porque tiene que ser la �nica instrucci�n del bloque)*/
GO
CREATE FUNCTION FnCarrerasCaballo (@fechaInicio date, @fechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento, COUNT(car.ID) AS [N�mero de carreras disputadas]
				FROM LTCaballosCarreras AS cc
				INNER JOIN LTCarreras AS car
				ON cc.IDCarrera = car.ID
				INNER JOIN LTCaballos AS cab
				ON cc.IDCaballo = cab.ID
					WHERE car.Fecha BETWEEN @fechaInicio AND @fechaFin
					GROUP BY cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento)
GO

--Declaro las dos variable que voy a utilizar
DECLARE @fechaInicio date, @fechaFin date
SET @fechaInicio = '2018-01-03' --Le doy un valor a la primera variable
SET @fechaFin = '2018-03-05' --Le doy un valor a la segunda variable

/*Utilizo la funci�n con las dos variables de antes*/
SELECT * FROM FnCarrerasCaballo (@fechaInicio, @fechaFin)



/*2.Crea una funci�n escalar llamada FnTotalApostadoCC que reciba como par�metros el ID de un caballo y
el ID de una carrera y nos devuelva el dinero que se ha apostado a ese caballo en esa carrera.*/

/*Creo la funci�n escalar (entre GO porque tiene que ser la �nica instrucci�n del bloque)*/
GO
CREATE FUNCTION FnTotalApostadoCC (@IDCaballo smallint, @IDCarrera smallint)
	RETURNS smallmoney AS
		BEGIN
			DECLARE @dineroApostadoCaballoCarrera smallmoney

			SELECT @dineroApostadoCaballoCarrera = Importe FROM LTApuestas
				WHERE IDCaballo = @IDCaballo AND IDCarrera = @IDCarrera

			RETURN @dineroApostadoCaballoCarrera
		END
GO

--SELECT * FROM LTApuestas

/*Declaro las variables que voy a utilizar y les doy unos valores con SET*/
DECLARE @IDCaballo smallint, @IDCarrera smallint
SET @IDCaballo = 1
SET @IDCarrera = 1

/*Utilizo la funci�n escalar con las dos variables de antes*/
SELECT dbo.FnTotalApostadoCC (@IDCaballo, @IDCarrera) AS [Dinero apostado a un caballo en una carrera]



/*3.Crea una funci�n escalar llamada FnPremioConseguido que reciba como par�metros el ID de una apuesta y
nos devuelva el dinero que ha ganado dicha apuesta.
Si todav�a no se conocen las posiciones de los caballos, devolver� un NULL.*/
SELECT * FROM LTApuestas
SELECT * FROM LTCaballosCarreras

GO
ALTER FUNCTION FnPremioConseguido (@IDApuesta smallmoney)
	RETURNS smallmoney AS
		BEGIN
			DECLARE @dineroGanadoApuesta smallmoney
			DECLARE @posicion tinyint

			SELECT @posicion = Posicion
				FROM LTCaballosCarreras AS cc
				INNER JOIN LTApuestas AS a
				ON cc.IDCaballo = a.IDCaballo AND cc.IDCarrera = a.IDCarrera
					WHERE a.ID = @IDApuesta

			IF @posicion = 1
				Select @dineroGanadoApuesta = a.Importe*cc.Premio1
					FROM LTCaballosCarreras AS cc
					INNER JOIN LTApuestas AS a
					ON cc.IDCaballo = a.IDCaballo AND cc.IDCarrera = a.IDCarrera
						Where a.ID = @IDApuesta
			ELSE
				IF @posicion = 2
					Select @dineroGanadoApuesta = A.Importe*CC.Premio2
						FROM LTCaballosCarreras AS CC
						INNER JOIN LTApuestas AS A
						ON CC.IDCaballo = A.IDCaballo AND CC.IDCarrera = A.IDCarrera
							Where A.ID = @IDApuesta
				ELSE
					IF @posicion > 2
					SET @dineroGanadoApuesta = 0

			RETURN @dineroGanadoApuesta
		END
GO

DECLARE @IDApuesta smallmoney
SET @IDApuesta = 3

SELECT dbo.FnPremioConseguido (@IDApuesta) AS [Dinero]

/*4.El procedimiento para calcular los premios en las apuestas de una carrera (los valores que deben figurar en la columna Premio1 y Premio2) es el siguiente:

	--a.Se calcula el total de dinero apostado en esa carrera

	--b.El valor de la columna Premio1 para cada caballo se calcula dividiendo el total de dinero apostado
		entre lo apostado a ese caballo y se multiplica el resultado por 0.6

	--c.El valor de la columna Premio2 para cada caballo se calcula dividiendo el total de dinero apostado
		entre lo apostado a ese caballo y se multiplica el resultado por 0.2

	--d.Si a alg�n caballo no ha apostado nadie tanto el Premio1 como el Premio2 se ponen a 100.

Crea una funci�n que devuelva una tabla con tres columnas: ID de la apuesta, Premio1 y Premio2.

Debes usar la funci�n del Ejercicio 2. Si lo estimas oportuno puedes crear otras funciones para realizar parte de los c�lculos.*/



/*5.Crea una funci�n FnPalmares que reciba un ID de caballo y un rango de fechas y nos devuelva el palmar�s de ese caballo en ese intervalo de tiempo.
El palmar�s es el n�mero de victorias, segundos puestos, etc.
Se devolver� una tabla con dos columnas: Posici�n y NumVeces, que indicar�n, respectivamente, cada una de las posiciones y las veces que el caballo ha obtenido ese resultado.
Queremos que aparezcan 8 filas con las posiciones de la 1 a la 8. Si el caballo nunca ha finalizado en alguna de esas posiciones, aparecer� el valor 0 en la columna NumVeces.*/
SELECT * FROM LTCaballosCarreras
	ORDER BY Posicion
SELECT * FROM LTCarreras

DECLARE @tabla8Posiciones table(
	Posicion int
)

INSERT INTO @tabla8Posiciones (Posicion)
	VALUES(1),(2),(3),(4),(5),(6),(7),(8)

SELECT t8p.Posicion, COUNT(cc.Posicion) AS [NumVeces]
	FROM LTCaballosCarreras AS cc
	INNER JOIN LTCarreras AS car
	ON cc.IDCarrera = car.ID AND car.Fecha BETWEEN '2018-01-03' AND '2018-03-05'
	RIGHT JOIN @tabla8Posiciones AS t8p 
	ON cc.Posicion = t8p.Posicion 
		GROUP BY t8p.Posicion

GO
CREATE FUNCTION FnPalmares (@IDCaballo smallint, @fechaInicio date, @fechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT Posicion
				FROM LTCaballosCarreras AS cc
				INNER JOIN LTCarreras AS car
				ON cc.IDCarrera = car.ID
				INNER JOIN LTCaballos AS cab
				ON cc.IDCaballo = cab.ID
					WHERE car.Fecha BETWEEN @fechaInicio AND @fechaFin
					GROUP BY cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento)
GO

--TERMINAR

/*6.Crea una funci�n FnCarrerasHipodromo que nos devuelva las carreras celebradas en un hip�dromo en un rango de fechas.
La funci�n recibir� como par�metros el nombre del hip�dromo y la fecha de inicio y fin del intervalo y
nos devolver� una tabla con las siguientes columnas:
	Fecha de la carrera
	n�mero de orden
	numero de apuestas realizadas
	n�mero de caballos inscritos
	n�mero de caballos que la finalizaron
	nombre del ganador*/

--Entradas: Nombre del hip�dromo
--			Fecha inicio y Fecha fin
--Salidas: Tabla con las columnas anteriores

SELECT * FROM LTCarreras
SELECT * FROM LTApuestas
SELECT * FROM LTCaballosCarreras

GO
ALTER FUNCTION FnCantidadApuestas (@NombreHipodromo varchar(40), @FechaInicio date, @FechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT car.ID, COUNT(apu.ID) AS [Numero de apuestas]
				FROM LTCarreras AS car
				INNER JOIN LTApuestas AS apu
				ON car.ID = apu.IDCarrera
					WHERE (car.Hipodromo = @NombreHipodromo) AND (car.Fecha BETWEEN @FechaInicio AND @FechaFin)
					GROUP BY car.ID)
GO

SELECT * FROM dbo.FnCantidadApuestas ('Gran Hipodromo de Andalucia', '2018-01-20', '2018-03-03')

GO

CREATE FUNCTION FnCantidadCaballos (@NombreHipodromo varchar(40), @FechaInicio date, @FechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT car.ID, COUNT(cc.IDCaballo) AS [Cantidad de caballos inscritos]
				FROM LTCarreras AS car
				INNER JOIN LTCaballosCarreras AS cc
				ON car.ID = cc.IDCarrera
					WHERE (car.Hipodromo = @NombreHipodromo) AND (car.Fecha BETWEEN @FechaInicio AND @FechaFin)
					GROUP BY car.ID)
GO

SELECT * FROM dbo.FnCantidadCaballos ('Gran Hipodromo de Andalucia', '2018-01-20', '2018-03-03')

GO
CREATE FUNCTION FnCaballosTerminanCarrera (@NombreHipodromo varchar(40), @FechaInicio date, @FechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT cc.IDCarrera, COUNT(cc.Posicion) AS [Caballos que han acabado la carrera]
				FROM LTCaballosCarreras AS cc
				INNER JOIN LTCarreras AS car
				ON cc.IDCarrera = car.ID
					WHERE (car.Hipodromo = @NombreHipodromo) AND (car.Fecha BETWEEN @FechaInicio AND @FechaFin)
					GROUP BY IDCarrera)
GO

SELECT * FROM dbo.FnCaballosTerminanCarrera ('Gran Hipodromo de Andalucia', '2018-01-20', '2018-03-03')

GO
CREATE FUNCTION FnCaballoGanador (@NombreHipodromo varchar(40), @FechaInicio date, @FechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT cab.Nombre, cc.IDCaballo, cc.IDCarrera
				FROM LTCaballosCarreras AS cc
				INNER JOIN LTCaballos AS cab
				ON cc.IDCaballo = cab.ID
				INNER JOIN LTCarreras AS car
				ON cc.IDCarrera = car.ID
					WHERE cc.Posicion = 1 AND car.Hipodromo = @NombreHipodromo AND car.Fecha BETWEEN @FechaInicio AND @FechaFin)
GO

SELECT * FROM dbo.FnCaballoGanador ('Gran Hipodromo de Andalucia', '2018-01-20', '2018-03-03')

(@NombreHipodromo, @FechaInicio, @FechaFin)

GO
ALTER FUNCTION FnCarrerasHipodromo (@NombreHipodromo varchar(40), @FechaInicio date, @FechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT Fecha, NumOrden, [CantidadApuestas].[Numero de apuestas], CantidadCaballos.[Cantidad de caballos inscritos], CaballosTerminanCarrera.[Caballos que han acabado la carrera], CaballoGanador.Nombre AS [Nombre del ganador]
				FROM LTCarreras AS car
				INNER JOIN (SELECT * FROM dbo.FnCantidadApuestas (@NombreHipodromo, @FechaInicio, @FechaFin)) AS [CantidadApuestas]
				ON car.ID = CantidadApuestas.ID
				INNER JOIN (SELECT * FROM dbo.FnCantidadCaballos (@NombreHipodromo, @FechaInicio, @FechaFin)) AS [CantidadCaballos]
				ON car.ID = CantidadCaballos.ID
				INNER JOIN (SELECT * FROM dbo.FnCaballosTerminanCarrera (@NombreHipodromo, @FechaInicio, @FechaFin)) AS [CaballosTerminanCarrera]
				ON car.ID = CaballosTerminanCarrera.IDCarrera
				INNER JOIN (SELECT Nombre, IDCarrera FROM dbo.FnCaballoGanador (@NombreHipodromo, @FechaInicio, @FechaFin)) AS [CaballoGanador]
				ON car.ID = CaballoGanador.IDCarrera
					WHERE car.Hipodromo = @NombreHipodromo AND car.Fecha BETWEEN @FechaInicio AND @FechaFin)
GO

SELECT * FROM dbo.FnCarrerasHipodromo ('Gran Hipodromo de Andalucia', '2018-01-20', '2018-03-03')


/*7.Crea una funci�n FnObtenerSaldo a la que pasemos el ID de un jugador y una fecha y nos devuelva su saldo en esa fecha.
Si se omite la fecha, se devolver� el saldo actual.*/

--Entradas: IDJugador y/o una Fecha
--Salidas: Saldo

SELECT * FROM LTApuntes

/*Creo la funci�n escalar (entre GO porque tiene que ser la �nica instrucci�n del bloque)*/
GO
CREATE FUNCTION FnObtenerSaldo (@IDJugador int, @Fecha date)
	RETURNS smallmoney AS
		BEGIN
			DECLARE @saldoConsultado smallmoney

			IF @Fecha = NULL
				SELECT @saldoConsultado = Saldo FROM LTApuntes
					WHERE IDJugador = @IDJugador AND Fecha = @Fecha

			ELSE
				SELECT @saldoConsultado = Saldo FROM LTApuntes
					WHERE IDJugador = @IDJugador

			RETURN @saldoConsultado
		END
GO

/*Declaro las variables que voy a utilizar y les doy unos valores con SET*/
DECLARE @IDJugador int, @Fecha date
SET @IDJugador = 2
SET @Fecha = NULL

/*Utilizo la funci�n escalar con las dos variables de antes*/
SELECT dbo.FnObtenerSaldo(@IDJugador, @Fecha) AS [Saldo de un Jugador en una Fecha]