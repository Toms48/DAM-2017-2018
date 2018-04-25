/*1.Crea una funci�n a la que pasemos un intervalo de tiempo y nos devuelva una tabla con el Happy day (el d�a que m�s ha ganado)
y el black day (el d�a que m�s ha perdido) de cada jugador.
Si hay m�s de un d�a en que haya ganado o perdido el m�ximo, tomaremos el m�s reciente.
Columnas:
	ID del jugador
	Nombre
	Apellidos
	Fecha del happy day
	Cantidad ganada
	Fecha del black day
	Cantidad perdida
*/

SELECT * FROM LTApuntes
SELECT IDJugador, Fecha, Importe, Saldo FROM LTApuntes

/*GO
ALTER VIEW [MaximoImportePorJugadorCadaDia] AS
	SELECT IDJugador, MAX(Importe) AS [Importe maximo] FROM LTApuntes
		WHERE Concepto NOT LIKE('Ingreso inicial')
		GROUP BY IDJugador
GO*/

/*SELECT a.IDJugador, apuntes.Fecha, MAX(a.[Importe maximo])
	FROM (SELECT IDJugador, MAX(Importe) AS [Importe maximo] FROM LTApuntes
			WHERE Concepto NOT LIKE('Ingreso inicial')
			GROUP BY IDJugador) AS a
	INNER JOIN LTApuntes AS apuntes
	ON a.IDJugador = apuntes.IDJugador
		WHERE a.[Importe maximo] = apuntes.Importe
	GROUP BY a.IDJugador, apuntes.Fecha
	ORDER BY IDJugador*/

--Happy Day
GO
CREATE VIEW HappyDay AS
	SELECT a.IDJugador, MAX(a.Fecha) AS [Happy Day], a.[importe max] AS [Importe m�ximo]
		FROM (SELECT a.IDJugador, apuntes.Fecha, MAX(a.[Importe maximo]) AS [importe max]
				FROM (SELECT IDJugador, MAX(Importe) AS [Importe maximo] FROM LTApuntes
						WHERE Concepto NOT LIKE('Ingreso inicial')
						GROUP BY IDJugador) AS a
				INNER JOIN LTApuntes AS apuntes
				ON a.IDJugador = apuntes.IDJugador
					WHERE a.[Importe maximo] = apuntes.Importe
				GROUP BY a.IDJugador, apuntes.Fecha) AS a
		GROUP BY a.IDJugador, a.[importe max]
		--ORDER BY a.IDJugador, a.[importe max]
GO

--Black Day
GO
CREATE VIEW BlackDay AS
	SELECT a.IDJugador, MAX(a.Fecha) AS [Black Day], a.[importe min] AS [Importe m�nimo]
		FROM (SELECT a.IDJugador, apuntes.Fecha, MIN(a.[Importe minimo]) AS [importe min]
				FROM (SELECT IDJugador, MIN(Importe) AS [Importe minimo] FROM LTApuntes
						WHERE Concepto NOT LIKE('Ingreso inicial')
						GROUP BY IDJugador) AS a
				INNER JOIN LTApuntes AS apuntes
				ON a.IDJugador = apuntes.IDJugador
					WHERE a.[Importe minimo] = apuntes.Importe
				GROUP BY a.IDJugador, apuntes.Fecha) AS a
		GROUP BY a.IDJugador, a.[importe min]--, a.Fecha
		--ORDER BY a.IDJugador, a.[importe min]--, a.Fecha
GO

SELECT j.ID, j.Nombre, j.Apellidos, hd.
	FROM LTJugadores AS j
	INNER JOIN HappyDay AS hd
	ON j.ID = hd.IDJugador
	INNER JOIN BlackDay AS bd
	ON hd.IDJugador = bd.IDJugador

/*2.Se ha creado un coeficiente para valorar los caballos.
Se calcula sumando el n�mero de carreras ganadas multiplicado por cinco m�s el n�mero de carreras en las que ha quedado segundo multiplicado por tres.
El resultado se divide entre el n�mero de carreras disputadas multiplicado por 0,2.
Al resultado de todo eso de lo multiplica por un coeficiente de edad que se calcula seg�n la tabla siguiente:

						Edad						Valor

						Seis o menos a�os ......... 100

						Siete ..................... 90

						Ocho o nueve .............. 75

						Diez ...................... 65

						M�s de diez ............... 40
*/


/*3.Queremos saber la cantidad de dinero en apuestas que mueve cada hip�dromo.
Haz una funci�n a la que se le pase un rango de fechas y nos devuelva el dinero movido en apuestas en cada hip�dromo entre esas fechas.
Tambi�n queremos saber cu�l fue la apuesta m�s alta de ese periodo.
Considerar solo las apuestas, no los premios.
Columnas:
	Nombre del hip�dromo
	Cantidad gestionada
	Fecha de la apuesta m�s alta
	Importe de la apuesta m�s alta
	Otra columna que tomar� los valores G,C o P seg�n si esa apuesta acert� el primero (Ganador), el segundo (Colocado) o no obtuvo premio (Pierde)
*/


/*4.Haz una funci�n DescalificaCaballo que reciba como par�metros el ID de un Caballo y en ID de una carrera y descalifique a ese caballo en esa carrera.
Eso puede dar lugar, si el caballo qued� primero o segundo, a que haya que alterar los premios obtenidos.

a.Si el caballo descalificado fue primero:
	Crear apuntes para descontar los premios obtenidos por los que apostaron por �l,
	anular tambi�n los apuntes de los que apostaron por el segundo, que ahora pasa a ser primero y generar los apuntes correspondientes al nuevo premio.
	Crear los apuntes correspondientes al segundo premio para los que apostaron por el tercero, que ahora pasa a ser segundo.

b.Si el caballo descalificado fue segundo:
	Anular las ganancias de los que apostaron por �l.
	Crear los apuntes correspondientes al segundo premio para los que apostaron por el tercero, que ahora pasa a ser segundo.

La funci�n nos devolver� los apuntes que haya que insertar en la tabla Apuntes.
No se borra ning�n apunte.
Los que ya no sirvan se crea uno con el importe opuesto.
*/