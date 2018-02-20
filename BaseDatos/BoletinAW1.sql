--1. Nombre y dirección completas de todos los clientes que tengan alguna sede en Canada.
SELECT * FROM Person.[Address]

SELECT * FROM Person.BusinessEntityAddress
SELECT * FROM Person.BusinessEntity

SELECT * FROM Person.Person
SELECT * FROM Sales.Customer
SELECT * FROM Sales.SalesTerritory

SELECT p.FirstName, p.MiddleName, p.LastName, a.AddressLine1, a.AddressLine2, a.City
	FROM Person.[Address] AS a
	INNER JOIN Person.BusinessEntityAddress AS bea
	ON a.AddressID = bea.AddressID
	INNER JOIN Person.BusinessEntity AS be
	ON bea.BusinessEntityID = be.BusinessEntityID
	INNER JOIN Person.Person AS p
	ON be.BusinessEntityID = p.BusinessEntityID
	INNER JOIN Sales.Customer AS c
	ON p.BusinessEntityID = c.PersonID
	INNER JOIN Sales.SalesTerritory AS st
	ON c.TerritoryID = st.TerritoryID

--2. Nombre de cada categoría y producto más caro y más barato de la misma, incluyendo los precios.

--3. Total de Ventas en cada país en dinero (Ya hecha en el boletín 9.3).

--4. Número de clientes que tenemos en cada país. Contaremos cada dirección como si fuera un cliente distinto.

/*5. Repite la consulta anterior pero contando cada cliente una sola vez.
Si el cliente tiene varias direcciones, sólo consideraremos aquella en la que nos haya comprado la última vez.*/

/*6. Repite la consulta anterior pero en este caso si el cliente tiene varias direcciones,
sólo consideraremos aquella en la que nos haya comprado más.*/

--7. Los tres países en los que más hemos vendido, incluyendo la cifra total de ventas y la fecha de la última venta.

/*8. Sobre la consulta tres de ventas por país, calcula el valor medio y
repite la consulta tres pero incluyendo solamente los países cuyas ventas estén por encima de la media.*/

--9. Nombre de la categoría y número de clientes diferentes que han comprado productos de cada una.

--10. Clientes que nunca han comprado ninguna bicicleta (discriminarlas por categorías).

--11. A la consulta anterior, añádele el total de compras (en dinero) efectuadas por cada cliente.