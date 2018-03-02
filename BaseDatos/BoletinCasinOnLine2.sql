--Ejercicio 1
/*Escribe una consulta que nos devuelva el n�mero de veces que se ha apostado a cada n�mero con apuestas de los tipos 10, 13 o 15.
Ordena el resultado de mayor a menos popularidad.*/
SELECT * FROM COL_NumerosApuesta
SELECT * FROM COL_Apuestas

SELECT COUNT(j.Numero) AS [Cantidad de veces apostado], j.Numero, a.Tipo
	FROM COL_Jugadas AS j
	INNER JOIN COL_Apuestas AS a
	ON j.IDJugada = a.IDJugada
		WHERE Tipo = 10 OR Tipo = 13 OR Tipo = 15
		GROUP BY j.Numero, a.Tipo
		ORDER BY COUNT(j.Numero) DESC

--Ejercicio 2
/*El casino quiere fomentar la participaci�n y decide regalar saldo extra a los jugadores que hayan apostado m�s de tres veces en el �ltimo mes.
Se considera el mes de febrero.
La cantidad que se les regalar� ser� un 5% del total que hayan apostado en ese mes*/
SELECT * FROM COL_Apuestas

SELECT a.IDJugador, j.MomentoJuega
	FROM COL_Apuestas AS a
	INNER JOIN COL_Jugadas AS j
	ON a.IDJugada = j.IDJugada
		WHERE MONTH(j.MomentoJuega) = MONTH(CURRENT_TIMESTAMP) -1

SELECT COUNT(IDJugada), MomentoJuega FROM COL_Jugadas
	WHERE MONTH(MomentoJuega) = MONTH(CURRENT_TIMESTAMP) -1
	GROUP BY MomentoJuega

--Ejercicio 3
/*El d�a 2 de febrero se celebr� el d�a de la marmota.
Para conmemorarlo, el casino ha decidido volver a repetir todas las jugadas que se hicieron ese d�a,
	pero poni�ndoles fecha de ma�ana (con la misma hora) y permitiendo que los jugadores apuesten.
El n�mero ganador de cada jugada se pondr� a NULL y el NoVaMas a 0.
Crea esas nuevas filas con una instrucci�n INSERT-SELECT*/


--Ejercicio 4
/*Crea una vista que nos muestre, para cada jugador, nombre, apellidos, Nick,
n�mero de apuestas realizadas, total de dinero apostado y total de dinero ganado/perdido.*/


--Ejercicio 5
/*Nos comunican que la polic�a ha detenido a nuestro cliente Ombligo Pato por delitos de estafa, falsedad, administraci�n desleal y mal gusto para comprar ba�adores. 
Dado que nuestro casino est� en Gibraltar, siguiendo la tradici�n de estas tierras, queremos borrar todo rastro de su paso por nuestro casino.
Borra todas las apuestas que haya realizado, pero no busques su ID a mano en la tabla COL_Clientes. Utiliza su Nick (bankiaman) para identificarlo en la instrucci�n DELETE.*/

