USE Northwind

/*1. N�mero de clientes de cada pa�s.*/
SELECT COUNT(CustomerID) AS [N�mero de clientes], Country FROM Customers
	GROUP BY Country

/*2. N�mero de clientes diferentes que compran cada producto.*/
SELECT COUNT(c.CustomerID) AS [N�mero de clientes], p.ProductName
	FROM Customers AS c
	INNER JOIN Orders AS o
	ON c.CustomerID = o.CustomerID
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
	INNER JOIN Products AS p
	ON od.ProductID = p.ProductID
		GROUP BY p.ProductName

/*3. N�mero de pa�ses diferentes en los que se vende cada producto.*/
SELECT COUNT(o.ShipCountry) AS [N�mero de paises], p.ProductName
	FROM Orders AS o
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
	INNER JOIN Products AS p
	ON od.ProductID = p.ProductID
		GROUP BY p.ProductName

/*4. Empleados que han vendido alguna vez �Gudbrandsdalsost�, �Lakkalik��ri�, �Tourti�re� o �Boston Crab Meat�.*/
SELECT * FROM Employees
SELECT * FROM Orders
SELECT * FROM [Order Details]
SELECT * FROM Products

SELECT DISTINCT e.FirstName, e.LastName
	FROM Employees AS e
	INNER JOIN Orders AS o
	ON e.EmployeeID = o.EmployeeID
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
	INNER JOIN Products AS p
	ON od.ProductID = p.ProductID
		WHERE p.ProductName IN ('Gudbrandsdalsost', 'Lakkalik��ri', 'Tourti�re', 'Boston Crab Meat')

/*5. Empleados que no han vendido nunca �Chartreuse verte� ni �Ravioli Angelo�.*/  --Se puede quietar el DISTINCT teniendo el EXCEPT
SELECT * FROM Employees
SELECT * FROM Orders
SELECT * FROM [Order Details]
SELECT * FROM Products

SELECT DISTINCT e.FirstName, e.LastName
	FROM Employees AS e
	INNER JOIN Orders AS o
	ON e.EmployeeID = o.EmployeeID
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
	INNER JOIN Products AS p
	ON od.ProductID = p.ProductID

EXCEPT

SELECT DISTINCT e.FirstName, e.LastName
	FROM Employees AS e
	INNER JOIN Orders AS o
	ON e.EmployeeID = o.EmployeeID
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
	INNER JOIN Products AS p
	ON od.ProductID = p.ProductID
		WHERE p.ProductName IN ('Chartreuse verte', 'Ravioli Angelo')

/*6. N�mero de unidades de cada categor�a de producto que ha vendido cada empleado.*/
SELECT * FROM Employees
SELECT * FROM Orders
SELECT * FROM [Order Details]
SELECT * FROM Products
SELECT * FROM Categories

SELECT SUM(od.Quantity) AS [N�mero de unidades vendidas], c.CategoryName
	FROM Categories AS c
	INNER JOIN Products AS p
	ON c.CategoryID = p.CategoryID
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
	INNER JOIN Employees AS e
	ON o.EmployeeID = e.EmployeeID
		GROUP BY c.CategoryName
		

/*7. Total de ventas (US$) de cada categor�a en el a�o 97.*/
SELECT * FROM Categories
SELECT * FROM Products
SELECT * FROM [Order Details]
SELECT * FROM Orders

SELECT CategoryName, SUM(od.Quantity * od.UnitPrice * (1 - od.Discount)) AS [Total de ventas]
	FROM Categories AS c
	INNER JOIN Products AS p
	ON c.CategoryID = p.CategoryID
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
		WHERE YEAR(o.OrderDate) = '1997'
		GROUP BY c.CategoryName

/*8. Productos que han comprado m�s de un cliente del mismo pa�s, indicando
el nombre del producto, el pa�s y el n�mero de clientes distintos de ese pa�s que lo han comprado.*/
SELECT * FROM Products
SELECT * FROM [Order Details]
SELECT * FROM Orders
SELECT * FROM Customers

SELECT p.ProductName, o.ShipCountry, COUNT(c.CustomerID) AS [N�mero de clientes]
	FROM Products AS p
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
	INNER JOIN Customers AS c
	ON o.CustomerID = c.CustomerID
		GROUP BY p.ProductName, o.ShipCountry
		HAVING COUNT(c.CustomerID) > 1

/*9. Total de ventas (US$) en cada pa�s cada a�o.*/
SELECT * FROM [Order Details]
SELECT * FROM Orders

SELECT SUM(od.Quantity * od.UnitPrice * (1- od.Discount)) AS [Total de ventas], o.ShipCountry, YEAR(o.OrderDate) AS [A�o de venta]
	FROM [Order Details] AS od
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
		GROUP BY o.ShipCountry, YEAR(o.OrderDate)
		ORDER BY o.ShipCountry, YEAR(o.OrderDate) ASC

/*10. Producto superventas de cada a�o, indicando a�o, nombre del producto, categor�a y cifra total de ventas.*/
SELECT * FROM Categories
SELECT * FROM Products
SELECT * FROM [Order Details]
SELECT * FROM Orders

SELECT MAX(a.[Cantidad vendida]) AS [Cantidad m�xima vendida], a.A�o
	FROM (SELECT p.ProductName, SUM(od.Quantity) AS [Cantidad vendida], YEAR(o.OrderDate) AS [A�o], c.CategoryName
			FROM Categories AS c
			INNER JOIN Products AS p
			ON c.CategoryID = p.CategoryID
			INNER JOIN [Order Details] AS od
			ON p.ProductID = od.ProductID
			INNER JOIN Orders AS o
			ON od.OrderID = o.OrderID
				GROUP BY p.ProductName, YEAR(o.OrderDate), c.CategoryName) AS a
	GROUP BY a.A�o





SELECT p.ProductName, od.Quantity AS [Cantidad vendida], YEAR(o.OrderDate) AS [A�o]
	FROM Categories AS c
		INNER JOIN Products AS p
		ON c.CategoryID = p.CategoryID
		INNER JOIN [Order Details] AS od
		ON p.ProductID = od.ProductID
		INNER JOIN Orders AS o
		ON od.OrderID = o.OrderID
		GROUP BY p.ProductName, YEAR(o.OrderDate)

SELECT c.CategoryName, p.ProductName, MAX(od.Quantity) AS [Cantidad vendida], YEAR(o.OrderDate) AS [A�o]
	FROM Categories AS c
	INNER JOIN Products AS p
	ON c.CategoryID = p.CategoryID
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
		GROUP BY p.ProductName, c.CategoryName, YEAR(o.OrderDate)

/*11. Cifra de ventas de cada producto en el a�o 97 y su aumento o disminuci�n respecto al a�o anterior en US $ y en %.*/

/*12. Mejor cliente (el que m�s nos compra) de cada pa�s.*/

/*13. N�mero de productos diferentes que nos compra cada cliente.*/

/*14. Clientes que nos compran m�s de cinco productos diferentes.*/

/*15. Vendedores que han vendido una mayor cantidad que la media en US $ en el a�o 97.*/

/*16. Empleados que hayan aumentado su cifra de ventas m�s de un 10% entre dos a�os consecutivos, indicando el a�o en que se produjo el aumento.*/