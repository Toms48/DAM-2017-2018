--1. Nombre de los proveedores y número de productos que nos vende cada uno.
SELECT * FROM Suppliers
SELECT * FROM Products

SELECT s.ContactName, COUNT(ProductID) AS [Número de productos que vende]
	FROM Suppliers AS s
	INNER JOIN Products AS p
	ON s.SupplierID = p.SupplierID
		GROUP BY s.ContactName

--2. Nombre completo y telefono de los vendedores que trabajen en New York, Seattle, Vermont, Columbia, Los Angeles, Redmond o Atlanta.
SELECT * FROM Employees
SELECT * FROM EmployeeTerritories
SELECT * FROM Territories

SELECT e.FirstName, e.LastName, e.HomePhone, t.TerritoryDescription
	FROM Employees AS e
	INNER JOIN EmployeeTerritories AS et
	ON e.EmployeeID = et.EmployeeID
	INNER JOIN Territories AS t
	ON et.TerritoryID = t.TerritoryID
		WHERE t.TerritoryDescription IN ('New York', 'Seattle', 'Vermont', 'Columbia', 'Los Angeles', 'Redmond', 'Atlanta')

--3. Número de productos de cada categoría y nombre de la categoría.
SELECT * FROM Products
SELECT * FROM Categories

SELECT c.CategoryName, COUNT(p.ProductID) AS [Número de productos por categoría]
	FROM Categories AS c
	INNER JOIN Products AS p
	ON c.CategoryID = p.CategoryID
		GROUP BY CategoryName

--4. Nombre de la compañía de todos los clientes que hayan comprado queso de cabrales o tofu.
SELECT * FROM Customers
SELECT * FROM Orders
SELECT * FROM [Order Details]
SELECT * FROM Products

SELECT c.CompanyName, p.ProductName 
	FROM Products AS p
		INNER JOIN [Order Details] AS od
		ON p.ProductID = od.ProductID
		INNER JOIN Orders AS o
		ON od.OrderID = o.OrderID
		INNER JOIN Customers AS c
		ON o.CustomerID = c.CustomerID
			WHERE p.ProductName IN ('Queso Cabrales', 'Tofu')

--5. Empleados (ID, nombre, apellidos y teléfono) que han vendido algo a Bon app' o Meter Franken.
SELECT * FROM Employees

SELECT e.EmployeeID, e.FirstName, e.LastName, e.HomePhone, c.CompanyName
	FROM Employees AS e
	INNER JOIN Orders AS o
	ON e.EmployeeID = o.EmployeeID
	INNER JOIN Customers AS c
	ON o.CustomerID = c.CustomerID
		WHERE c.CompanyName IN ('Bon app''', 'Meter Franken')

--6. Empleados (ID, nombre, apellidos, mes y día de su cumpleaños) que no han vendido nunca nada a ningún cliente de Francia. *
SELECT * FROM Employees
SELECT * FROM Orders
SELECT * FROM Customers

SELECT e.EmployeeID, e.FirstName, e.LastName, MONTH(e.BirthDate) AS [Mes de nacimiento], DAY(e.BirthDate) AS [Día de nacimiento], c.Country
	FROM Employees AS e
	INNER JOIN Orders AS o
	ON e.EmployeeID = o.EmployeeID
	INNER JOIN Customers AS c
	ON o.CustomerID = c.CustomerID
		WHERE c.Country <> 'France'

--7. Total de ventas en US$ de productos de cada categoría (nombre de la categoría).
SELECT * FROM Categories
SELECT * FROM Products
SELECT * FROM [Order Details]

SELECT c.CategoryName, SUM(od.UnitPrice * od.Quantity) AS [Total de ventas en US$]
	FROM Categories AS c
	INNER JOIN Products AS p
	ON c.CategoryID = p.CategoryID
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
		GROUP BY c.CategoryName

--8. Total de ventas en US$ de cada empleado cada año (nombre, apellidos, dirección).
SELECT * FROM Employees
SELECT * FROM Orders
SELECT * FROM [Order Details]

SELECT e.FirstName, e.LastName, e.[Address], SUM(od.UnitPrice * od.Quantity) AS [Total de ventas en US$], YEAR(o.OrderDate) AS [Año de venta]
	FROM Employees AS e
	INNER JOIN Orders AS o
	ON e.EmployeeID = o.EmployeeID
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
		GROUP BY e.FirstName, e.LastName, e.[Address], YEAR(o.OrderDate)
		ORDER BY e.FirstName, e.LastName, YEAR(o.OrderDate)

--9. Ventas de cada producto en el año 97. Nombre del producto y unidades.
SELECT * FROM Products
SELECT * FROM [Order Details]
SELECT * FROM Orders

SELECT p.ProductName, SUM(od.Quantity) AS [Cantidad de unidades], YEAR(o.OrderDate) AS [Año de venta]
	FROM Products AS p
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
		WHERE YEAR(o.OrderDate) = '1997' 
		GROUP BY P.ProductName, YEAR(o.OrderDate)

--10. Cuál es el producto del que hemos vendido más unidades en cada país. *


--11. Empleados (nombre y apellidos) que trabajan a las órdenes de Andrew Fuller.


--12. Número de subordinados que tiene cada empleado, incluyendo los que no tienen ninguno. Nombre, apellidos, ID.



--* Se necesitan subconsultas