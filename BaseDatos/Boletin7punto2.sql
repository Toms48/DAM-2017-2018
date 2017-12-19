/*1. T�tulo, precio y notas de los libros (titles) que tratan de cocina, ordenados de mayor a menor precio.*/
SELECT * FROM titles
SELECT title,price,notes FROM titles
	WHERE type IN ('mod_cook','trad_cook')
	--WHERE type LIKE '%cook%'
	ORDER BY price DESC

/*2. ID, descripci�n y nivel m�ximo y m�nimo de los puestos de trabajo (jobs) que pueden tener un nivel 110.*/
SELECT * FROM jobs
	WHERE min_lvl >= 110

/*3. T�tulo, ID y tema de los libros que contengan la palabra "and� en las notas.*/
SELECT * FROM titles
SELECT title_id, title, type, notes FROM titles
	WHERE notes LIKE '%and%'

/*4. Nombre y ciudad de las editoriales (publishers) de los Estados Unidos que no est�n en California ni en Texas.*/
SELECT * FROM publishers
SELECT pub_name,city FROM publishers
	WHERE country = 'USA' AND state NOT IN ('CA', 'TX')

/*5. T�tulo, precio, ID de los libros que traten sobre psicolog�a o negocios y cuesten entre diez y 20 d�lares.*/
SELECT * FROM titles
SELECT title, price, title_id FROM titles
	WHERE type IN ('psychology', 'business') AND price BETWEEN 10 AND 20

/*6. Nombre completo (nombre y apellido) y direcci�n completa de todos los autores que no viven en California ni en Oreg�n.*/
SELECT * FROM authors
SELECT au_fname, au_lname, [address], city, [state] FROM authors
	WHERE [state] NOT IN ('CA','OR')

/*7. Nombre completo y direcci�n completa de todos los autores cuyo apellido empieza por D, G o S.*/
SELECT * FROM authors
SELECT au_fname, au_lname, [address], city, [state] FROM authors
	WHERE au_lname LIKE ('[DGS]%')

/*8. ID, nivel y nombre completo de todos los empleados con un nivel inferior a 100, ordenado alfab�ticamente.*/
SELECT * FROM employee
SELECT emp_id,job_lvl, fname, lname FROM employee
	WHERE job_lvl < 100
	ORDER BY fname, lname
