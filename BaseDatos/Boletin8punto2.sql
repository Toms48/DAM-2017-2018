USE pubs

/*1. Numero de libros que tratan de cada tema*/
SELECT * FROM titles

SELECT COUNT(title_id) AS [Numero de libros por tema], type FROM titles
	GROUP BY type

/*2. Número de autores diferentes en cada ciudad y estado*/
SELECT * FROM authors

SELECT COUNT(au_id), city, state FROM authors
	GROUP BY city, state
	ORDER BY state

/*3. Nombre, apellidos, nivel y antigüedad en la empresa de los empleados con un nivel entre 100 y 150.*/


/*4. Número de editoriales en cada país. Incluye el país.*/


/*5. Número de unidades vendidas de cada libro en cada año (title_id, unidades y año).*/


/*6. Número de autores que han escrito cada libro (title_id y numero de autores).*/


/*7. ID, Titulo, tipo y precio de los libros cuyo adelanto inicial (advance) tenga un valor superior a $7.000, ordenado por tipo y título*/

