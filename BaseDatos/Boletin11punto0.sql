/*1.Crea una función inline llamada FnCarrerasCaballo que reciba un rango de fechas (inicio y fin) y
nos devuelva el número de carreras disputadas por cada caballo entre esas dos fechas.
Las columnas serán:
	ID (del caballo)
	nombre
	sexo
	fecha de nacimiento
	número de carreras disputadas.*/

/*Un SELECT para tener una tabla con los datos que me piden*/
SELECT cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento, COUNT(car.ID) AS [Número de carreras disputadas]
	FROM LTCaballosCarreras AS cc
	INNER JOIN LTCarreras AS car
	ON cc.IDCarrera = car.ID
	INNER JOIN LTCaballos AS cab
	ON cc.IDCaballo = cab.ID
		GROUP BY cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento

/*Creo la función (debe ir entre GO porque tiene que ser la única instrucción del bloque)*/
GO
CREATE FUNCTION FnCarrerasCaballo (@fechaInicio date, @fechaFin date)
	RETURNS TABLE AS
	RETURN (SELECT cab.ID, cab.Nombre, cab.Sexo, cab.FechaNacimiento, COUNT(car.ID) AS [Número de carreras disputadas]
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

/*Utilizo la función con las dos variables de antes*/
SELECT * FROM FnCarrerasCaballo (@fechaInicio, @fechaFin)



/*2.Crea una función escalar llamada FnTotalApostadoCC que reciba como parámetros el ID de un caballo y
el ID de una carrera y nos devuelva el dinero que se ha apostado a ese caballo en esa carrera.*/

/*Creo la función escalar (entre GO porque tiene que ser la única instrucción del bloque)*/
GO
ALTER FUNCTION FnTotalApostadoCC (@IDCaballo smallint, @IDCarrera smallint)
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

/*Utilizo la función escalar con las dos variables de antes*/
SELECT dbo.FnTotalApostadoCC (@IDCaballo, @IDCarrera) AS [Dinero apostado a un caballo en una carrera]



/*3.Crea una función escalar llamada FnPremioConseguido que reciba como parámetros el ID de una apuesta y
nos devuelva el dinero que ha ganado dicha apuesta.
Si todavía no se conocen las posiciones de los caballos, devolverá un NULL.*/
SELECT * FROM LTApuestas

GO
CREATE FUNCTION FnPremioConseguido (@IDApuesta smallmoney)
	RETURNS smallmoney AS
		BEGIN
			DECLARE @dineroGanadoApuesta smallmoney
			DECLARE @posicion tinyint

			SELECT @posicion = Posicion
				FROM LTCaballosCarreras AS CC
				INNER JOIN LTApuestas AS A
				ON CC.IDCaballo = A.IDCaballo AND CC.IDCarrera = A.IDCarrera
					Where A.ID = @IDApuesta

			IF @posicion = 1
				Select @dineroGanadoApuesta = A.Importe*CC.Premio1
					FROM LTCaballosCarreras AS CC
					INNER JOIN LTApuestas AS A
					ON CC.IDCaballo = A.IDCaballo AND CC.IDCarrera = A.IDCarrera
						Where A.ID = @IDApuesta
			ELSE
				IF @posicion = 2
					Select @dineroGanadoApuesta = A.Importe*CC.Premio2
						FROM LTCaballosCarreras AS CC
						INNER JOIN LTApuestas AS A
						ON CC.IDCaballo = A.IDCaballo AND CC.IDCarrera = A.IDCarrera
							Where A.ID = @IDApuesta

			RETURN @dineroGanadoApuesta
		END
GO

DECLARE @IDApuesta smallmoney
SET @IDApuesta = 1

SELECT dbo.FnPremioConseguido (@IDApuesta) AS [Dinero]

/*4.El procedimiento para calcular los premios en las apuestas de una carrera (los valores que deben figurar en la columna Premio1 y Premio2) es el siguiente:

	--a.Se calcula el total de dinero apostado en esa carrera

	--b.El valor de la columna Premio1 para cada caballo se calcula dividiendo el total de dinero apostado
		entre lo apostado a ese caballo y se multiplica el resultado por 0.6

	--c.El valor de la columna Premio2 para cada caballo se calcula dividiendo el total de dinero apostado
		entre lo apostado a ese caballo y se multiplica el resultado por 0.2

	--d.Si a algún caballo no ha apostado nadie tanto el Premio1 como el Premio2 se ponen a 100.

Crea una función que devuelva una tabla con tres columnas: ID de la apuesta, Premio1 y Premio2.

Debes usar la función del Ejercicio 2. Si lo estimas oportuno puedes crear otras funciones para realizar parte de los cálculos.


/*5.Crea una función FnPalmares que reciba un ID de caballo y un rango de fechas y nos devuelva el palmarés de ese caballo en ese intervalo de tiempo.
El palmarés es el número de victorias, segundos puestos, etc.
Se devolverá una tabla con dos columnas: Posición y NumVeces, que indicarán, respectivamente, cada una de las posiciones y las veces que el caballo ha obtenido ese resultado.
Queremos que aparezcan 8 filas con las posiciones de la 1 a la 8. Si el caballo nunca ha finalizado en alguna de esas posiciones, aparecerá el valor 0 en la columna NumVeces.


/*6.Crea una función FnCarrerasHipodromo que nos devuelva las carreras celebradas en un hipódromo en un rango de fechas.
La función recibirá como parámetros el nombre del hipódromo y la fecha de inicio y fin del intervalo y
nos devolverá una tabla con las siguientes columnas:
	Fecha de la carrera
	número de orden
	numero de apuestas realizadas
	número de caballos inscritos
	número de caballos que la finalizaron
	nombre del ganador


/*7.Crea una función FnObtenerSaldo a la que pasemos el ID de un jugador y una fecha y nos devuelva su saldo en esa fecha.
Si se omite la fecha, se devolverá el saldo actual.