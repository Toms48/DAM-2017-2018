--El nombre completo de cada jugador que haya apostado a algun caballo que haya nacido en 2009
--y haya obtenido mas victorias ese mismo año

SELECT * FROM LTCaballos
	WHERE YEAR(FechaNacimiento) = 2009

GO
CREATE VIEW CaballosGanadores2009 AS
SELECT ca.ID, ca.Nombre, COUNT(cc.Posicion) AS [Numero de victorias en 2009]
	FROM LTCaballos AS ca
	INNER JOIN LTCaballosCarreras AS cc
	ON ca.ID = cc.IDCaballo
		WHERE (cc.Posicion = 1 OR cc.Posicion = 2) AND (YEAR(ca.FechaNacimiento) = 2009)
		GROUP BY ca.Nombre, ca.ID
GO

SELECT MAX(cg09.[Numero de victorias en 2009])
	FROM CaballosGanadores2009 AS cg09
	INNER JOIN LTApuestas AS a
	ON cg09.ID = a.IDCaballo
	INNER JOIN LTJugadores AS j
	ON a.IDJugador = j.ID

SELECT j.Nombre, j.Apellidos
	FROM CaballosGanadores2009 AS cg09
	INNER JOIN LTApuestas AS a
	ON cg09.ID = a.IDCaballo
	INNER JOIN LTJugadores AS j
	ON a.IDJugador = j.ID
		WHERE cg09.[Numero de victorias en 2009] = (SELECT MAX(cg09.[Numero de victorias en 2009])
														FROM CaballosGanadores2009 AS cg09
														INNER JOIN LTApuestas AS a
														ON cg09.ID = a.IDCaballo
														INNER JOIN LTJugadores AS j
														ON a.IDJugador = j.ID)

--Nombre del hipodromo donde se haya hecho la apuesta mas grande a un caballo que llevase numero par
SELECT * FROM LTCarreras
SELECT * FROM LTApuestas
SELECT * FROM LTCaballos

GO
ALTER VIEW MaximoImporteCaballoPar AS
SELECT MAX(a.Importe) AS [Maximo importe]
	FROM LTCarreras AS ca
	INNER JOIN LTApuestas AS a
	ON ca.ID = a.IDCarrera
	INNER JOIN LTCaballosCarreras AS caca
	ON a.IDCaballo = caca.IDCaballo
		WHERE caca.Numero % 2 = 0
GO

SELECT ca.Hipodromo
	FROM LTCarreras AS ca
	INNER JOIN LTApuestas AS a
	ON ca.ID = a.IDCarrera
	INNER JOIN MaximoImporteCaballoPar AS micp
	ON a.Importe = micp.[Maximo importe]

--Precio del los primeros premios que se hayan ganado en las segundas carreras del Gran Hipodromo de Andalucia
SELECT * FROM LTCarreras
	WHERE Hipodromo = 'Gran Hipodromo de Andalucia' AND NumOrden = 2

SELECT * FROM LTCaballosCarreras

SELECT * FROM LTCaballosCarreras
	WHERE Premio1 IS NOT NULL

SELECT (apu.Importe*b.Premio1) AS [Dinero]
	FROM LTApuestas AS apu
	INNER JOIN LTCarreras AS a
	ON apu.IDCarrera = a.ID
	INNER JOIN LTCaballosCarreras AS b
	ON apu.IDCarrera = b.IDCarrera AND apu.IDCaballo = b.IDCaballo
		WHERE a.Hipodromo = 'Gran Hipodromo de Andalucia' AND a.NumOrden = 2 AND b.Posicion = 1

SELECT * FROM LTApuestas

/*Insertando un nuevo caballo*/
SELECT * FROM LTCaballos

INSERT INTO LTCaballos(ID, Nombre, FechaNacimiento, Sexo)
	VALUES(31, 'Azafrán', '2008-04-20', 'H')