SELECT * FROM LTApuntes

--Ejercicio 1
/*Queremos saber cuál es la cantidad media apostada y la mayor cantidad apostada a cada caballo.
Columnas: ID Caballo, Nombre, Edad, Número de carreras disputadas, cantidad mayor apostada y cantidad media apostada a su favor*/

SELECT * FROM LTCaballos
SELECT * FROM LTApuestas
SELECT * FROM LTCaballosCarreras

/*Vista para obtener el número de carreras disputadas*/
GO
CREATE VIEW [CarrerasDisputadas] AS
SELECT IDCaballo, COUNT(IDCaballo) AS [CantidadCarreras]
	FROM LTCaballosCarreras
	GROUP BY IDCaballo
GO

/*Vista para saber cual es la apuesta máxima por cada caballo*/
GO
CREATE VIEW [ApuestasMaximaPorCaballo] AS
SELECT ca.ID, MAX(apu.Importe) AS [MaximoImporte]
	FROM LTCaballos AS ca
	INNER JOIN LTApuestas AS apu
	ON ca.ID = apu.IDCaballo
		GROUP BY ca.ID
GO

/*Consulta final*/
SELECT ca.ID, ca.Nombre, Year(Current_Timestamp -CAST(ca.FechaNacimiento AS SmallDateTime))-1900 AS [Edad caballo], cadi.CantidadCarreras AS [Número de carreras], ampc.MaximoImporte, AVG(apu.Importe) AS [Importe medio]
	FROM ApuestasMaximaPorCaballo AS ampc
	INNER JOIN LTCaballos AS ca
	ON ampc.ID = ca.ID
	INNER JOIN LTApuestas AS apu
	ON ca.ID = apu.IDCaballo
	INNER JOIN CarrerasDisputadas AS cadi
	ON apu.IDCaballo = cadi.IDCaballo
		GROUP BY ca.ID, ca.Nombre, Year(Current_Timestamp -CAST(ca.FechaNacimiento AS SmallDateTime))-1900, ampc.MaximoImporte, cadi.CantidadCarreras


--Ejercicio 2
/*Tenemos sospechas de que algún jugador pueda estar intentando amañar las carreras.
Queremos detectar los jugadores que son especialmente afortunados. 

Haz una consulta que calcule, para cada jugador, la rentabilidad que obtiene con el menor riesgo posible.

La rentabilidad se mide dividiendo el total de dinero ganado entre el dinero apostado y multiplicando el resultado por 100.
Ten en cuenta solo el dinero que haya ganado por premios, no los ingresos que haya podido hacer en su cuenta.

Columnas: ID, nombre y apellidos del jugador, total de dinero apostado, total de dinero ganado, rentabilidad.*/
SELECT * FROM LTJugadores
SELECT * FROM LTApuestas
SELECT * FROM LTCaballosCarreras

/*Vista para obtener el dinero (el importe por el premio) de los que han ganado el primer premio*/
GO
CREATE VIEW [DineroGanadoPremio1] AS
SELECT j.ID, SUM(cac.Premio1 * apu.Importe) AS [DineroPremio1]
	FROM LTJugadores AS j
	RIGHT JOIN LTApuestas AS apu
	ON j.ID = apu.IDJugador
	INNER JOIN LTCaballosCarreras AS cac
	ON apu.IDCaballo = cac.IDCaballo AND apu.IDCarrera = cac.IDCarrera
		WHERE cac.Posicion = 1
		GROUP BY j.ID
GO

/*Este SELECT es para tener todas las personas que han ganado el primer premio, incluidas las que no la han ganado */
SELECT j.ID, p1.DineroPremio1
	FROM DineroGanadoPremio1 AS p1
	RIGHT JOIN LTJugadores AS j
	ON p1.ID = j.ID

/*Vista para obtener el dinero (el importe por el premio) de los que han ganado el segundo premio*/
GO
CREATE VIEW [DineroGanadoPremio2] AS
SELECT j.ID, SUM(cac.Premio2 * apu.Importe) AS [DineroPremio2]
	FROM LTJugadores AS j
	INNER JOIN LTApuestas AS apu
	ON j.ID = apu.IDJugador
	INNER JOIN LTCaballosCarreras AS cac
	ON apu.IDCaballo = cac.IDCaballo AND apu.IDCarrera = cac.IDCarrera
		WHERE cac.Posicion = 2
		GROUP BY j.ID
GO

/*Este SELECT es para tener todas las personas que han ganado el segundo premio, incluidas las que no la han ganado */
SELECT j.ID, p2.DineroPremio2
	FROM DineroGanadoPremio2 AS p2
	RIGHT JOIN LTJugadores AS j
	ON p2.ID = j.ID

/*En esta vista se suman las cantidades ganadas por los premios 1 y 2.
Los que no han ganado nada, lo tendrán a 0.*/
GO
CREATE VIEW [DineroPorPersona] AS
SELECT dp1.ID, (dp1.a + dp2.b) AS [Dinero total]
	FROM (SELECT j.ID, ISNULL(p1.DineroPremio1, 0) AS a
			FROM DineroGanadoPremio1 AS p1
			RIGHT JOIN LTJugadores AS j
			ON p1.ID = j.ID) AS dp1

	RIGHT JOIN (SELECT j.ID, ISNULL(p2.DineroPremio2, 0) AS b
					FROM DineroGanadoPremio2 AS p2
					RIGHT JOIN LTJugadores AS j
					ON p2.ID = j.ID) AS dp2
	ON dp1.ID = dp2.ID
GO

/*Consulta final*/
SELECT j.ID, j.Nombre, j.Apellidos, SUM(apu.Importe) AS [Total apostado], dpp.[Dinero total] AS [Dinero total ganado], ((dpp.[Dinero total] / SUM(apu.Importe))*100) AS [Rentabilidad]
	FROM LTJugadores AS j
	INNER JOIN LTApuestas AS apu
	ON j.ID = apu.IDJugador
	RIGHT JOIN DineroPorPersona AS dpp
	ON apu.IDJugador = dpp.ID
		GROUP BY j.ID, j.Nombre, j.Apellidos, dpp.[Dinero total]
		ORDER BY j.ID


--Ejercicio 3  SIN TERMINAR
/*Como todavía no estamos tranquilos, vamos a comprobar apuestas que se salgan de lo normal.
Consideramos sospechosa una apuesta ganadora grande (al menos un 50% por encima del importe medio de las apuestas de esa carrera) a caballos que se pagasen a 2 o más.

Columnas: ID Jugador, Nombre, apellidos, ID apuesta, Hipódromo, fecha de la carrera, caballo, premio, importe apostado e importe ganado.

Si no devuelve ninguna fila no pasa nada, Nuestros clientes son honrados.*/
SELECT * FROM LTJugadores
SELECT * FROM LTApuestas
SELECT * FROM LTCarreras
SELECT * FROM LTCaballosCarreras
SELECT * FROM LTCaballos

SELECT * FROM DineroPorPersona

SELECT j.ID, j.Nombre, j.Apellidos, apu.ID, car.Hipodromo, car.Fecha, apu.Importe, dpp.[Dinero total]
	FROM LTJugadores AS j
	INNER JOIN LTApuestas AS apu
	ON j.ID = apu.IDJugador
	INNER JOIN LTCarreras AS car
	ON apu.IDCarrera = car.ID
	INNER JOIN LTCaballos AS cab
	ON apu.IDCaballo = cab.ID
	INNER JOIN DineroPorPersona AS dpp
	ON apu.IDJugador = dpp.ID
		--WHERE

--Ejercicio 5a
/*Actualiza la tabla LTCarreras y genera los apuntes en LTApuntes correspondientes a los jugadores que hayan ganado utilizando dos instrucciones INSERT-SELECT,
una para los que han acertado la ganadora y otra para los que han acertado la segunda.*/
SELECT * FROM LTCaballosCarreras

/*Transaction para actualizar la posicion de los caballos y no liarla*/
GO
BEGIN TRANSACTION
	UPDATE LTCaballosCarreras
	SET Posicion = 1
	WHERE (SELECT ID FROM LTCaballos
				WHERE Nombre = 'Fiona') = IDCaballo AND IDCarrera = 21

	UPDATE LTCaballosCarreras
	SET Posicion = 2
	WHERE (SELECT ID FROM LTCaballos
				WHERE Nombre = 'Vetonia') = IDCaballo AND IDCarrera = 21

	UPDATE LTCaballosCarreras
	SET Posicion = 3
	WHERE (SELECT ID FROM LTCaballos
				WHERE Nombre = 'Witiza') = IDCaballo AND IDCarrera = 21

	UPDATE LTCaballosCarreras
	SET Posicion = 4
	WHERE (SELECT ID FROM LTCaballos
				WHERE Nombre = 'Sigerico') = IDCaballo AND IDCarrera = 21

	UPDATE LTCaballosCarreras
	SET Posicion = 5
	WHERE (SELECT ID FROM LTCaballos
				WHERE Nombre = 'Galatea') = IDCaballo AND IDCarrera = 21

	UPDATE LTCaballosCarreras
	SET Posicion = 6
	WHERE (SELECT ID FROM LTCaballos
				WHERE Nombre = 'Desdemona') = IDCaballo AND IDCarrera = 21
ROLLBACK
COMMIT

/*SELECT para ver si se ha actualizado bien la tabla LTCaballosCarreras*/
SELECT Posicion, Nombre
	FROM LTCaballosCarreras AS cac
	INNER JOIN LTCaballos AS cab
	ON cac.IDCaballo = cab.ID
		WHERE IDCarrera = 21
		ORDER BY cac.Posicion

SELECT * FROM LTApuntes

/*INSERT-SELECT sin terminar*/
/*BEGIN TRANSACTION
	INSERT INTO LTLTApuntes(IDJugador, Orden, Fecha, Importe, Saldo, Concepto)
		SELECT * FROM 
ROLLBACK
COMMIT*/