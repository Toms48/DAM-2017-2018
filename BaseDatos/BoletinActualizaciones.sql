/*1. Inserta un nuevo cliente.*/
SELECT * FROM Customers

INSERT INTO Customers(CustomerID, CompanyName, ContactName, ContactTitle, [Address], City, PostalCode, Country, Phone)
	VALUES('ELTAL', 'El taller', 'Tomás Núñez', 'Owner', 'C/ Almería, 35', 'Utrera', 41710, 'Spain', 628119707)

/*2. Véndele (hoy) tres unidades de "Pavlova”, diez de "Inlagd Sill” y 25 de "Filo Mix”. El distribuidor será Speedy Express y el vendedor Laura Callahan.*/
SELECT * FROM Products
SELECT * FROM [Order Details]
SELECT * FROM Orders
SELECT * FROM Shippers

GO
CREATE VIEW LauraCallahanID AS
SELECT EmployeeID FROM Employees
	WHERE FirstName = 'Laura' AND LastName = 'Callahan'
GO

GO
CREATE VIEW SpeedyExpressID AS
SELECT ShipperID FROM Shippers
	WHERE CompanyName = 'Speedy Express'
GO

GO
CREATE VIEW TomasNunezID AS
SELECT CustomerID FROM Customers
	WHERE ContactName = 'Tomás Núñez'
GO

BEGIN TRANSACTION
	INSERT INTO Orders(CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry)
		VALUES(
			 (SELECT * FROM TomasNunezID)
			,(SELECT * FROM LauraCallahanID)
			,CURRENT_TIMESTAMP
			,NULL
			,NULL
			,1
			,NULL
			,(SELECT CompanyName FROM Customers
				WHERE ContactName = 'Tomás Núñez')
			,(SELECT [Address] FROM Customers
				WHERE ContactName = 'Tomás Núñez')
			,(SELECT City FROM Customers
				WHERE ContactName = 'Tomás Núñez')
			,(SELECT Region FROM Customers
				WHERE ContactName = 'Tomás Núñez')
			,(SELECT PostalCode FROM Customers
				WHERE ContactName = 'Tomás Núñez')
			,(SELECT Country FROM Customers
				WHERE ContactName = 'Tomás Núñez')
		)
ROLLBACK
COMMIT

BEGIN TRANSACTION
	INSERT INTO [Order Details](OrderID, ProductID, UnitPrice, Quantity, Discount)
		VALUES(
			 (SELECT OrderID FROM Orders
				WHERE ShipName = 'El taller')
			,(SELECT ProductID FROM Products
				WHERE ProductName = 'Pavlova')
			,(SELECT UnitPrice FROM Products
				WHERE ProductName = 'Pavlova')
			,3
			,0
		)

		INSERT INTO [Order Details](OrderID, ProductID, UnitPrice, Quantity, Discount)
		VALUES(
			 (SELECT OrderID FROM Orders
				WHERE ShipName = 'El taller')
			,(SELECT ProductID FROM Products
				WHERE ProductName = 'Inlagd Sill')
			,(SELECT UnitPrice FROM Products
				WHERE ProductName = 'Inlagd Sill')
			,10
			,0
		)

		INSERT INTO [Order Details](OrderID, ProductID, UnitPrice, Quantity, Discount)
		VALUES(
			 (SELECT OrderID FROM Orders
				WHERE ShipName = 'El taller')
			,(SELECT ProductID FROM Products
				WHERE ProductName = 'Filo Mix')
			,(SELECT UnitPrice FROM Products
				WHERE ProductName = 'Filo Mix')
			,25
			,0
		)
ROLLBACK
COMMIT

/*3. Ante la bajada de ventas producida por la crisis, hemos de adaptar nuestros precios según las siguientes reglas:*/
/*1) Los productos de la categoría de bebidas (Beverages) que cuesten más de $10 reducen su precio en un dólar.*/
SELECT * FROM Products
SELECT * FROM Categories

SELECT p.ProductName, UnitPrice
	FROM Products AS p
	INNER JOIN Categories AS c
	ON p.CategoryID = c.CategoryID
		WHERE c.CategoryName = 'Beverages' AND p.UnitPrice > 10

BEGIN TRANSACTION
	UPDATE Products
		SET UnitPrice = UnitPrice-1
		WHERE ProductName IN (SELECT p.ProductName
								FROM Products AS p
								INNER JOIN Categories AS c
								ON p.CategoryID = c.CategoryID
									WHERE c.CategoryName = 'Beverages' AND p.UnitPrice > 10)
ROLLBACK
COMMIT

/*2) Los productos de la categoría Lácteos que cuesten más de $5 reducen su precio en un 10%.*/
SELECT * FROM Products
SELECT * FROM Categories

SELECT p.ProductName, p.UnitPrice, c.CategoryName
	FROM Products AS p
	INNER JOIN Categories AS c
	ON p.CategoryID = c.CategoryID
		WHERE c.CategoryName = 'Dairy Products' AND P.UnitPrice > 5

BEGIN TRANSACTION
	UPDATE Products
	SET UnitPrice = UnitPrice - ((10*UnitPrice)/100)
	WHERE ProductName IN (SELECT p.ProductName
							FROM Products AS p
							INNER JOIN Categories AS c
							ON p.CategoryID = c.CategoryID
								WHERE c.CategoryName = 'Dairy Products' AND P.UnitPrice > 5)
ROLLBACK
COMMIT

/*3) Los productos de los que se hayan vendido menos de 200 unidades en el último año, reducen su precio en un 5%.*/
SELECT * FROM Products
SELECT * FROM [Order Details]
SELECT * FROM Orders

SELECT p.ProductName, SUM(od.Quantity) AS [Cantidad], YEAR(o.OrderDate) AS [Año], p.UnitPrice
	FROM Products AS p
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
		WHERE YEAR(o.OrderDate) = 1998
		GROUP BY p.ProductName, YEAR(o.OrderDate), p.UnitPrice
		HAVING SUM(od.Quantity) < 200

BEGIN TRANSACTION
	UPDATE Products
	SET UnitPrice = UnitPrice - ((5*UnitPrice)/100)
	WHERE ProductName IN (SELECT p.ProductName
							FROM Products AS p
							INNER JOIN [Order Details] AS od
							ON p.ProductID = od.ProductID
							INNER JOIN Orders AS o
							ON od.OrderID = o.OrderID
								WHERE YEAR(o.OrderDate) = 1998
								GROUP BY p.ProductName, YEAR(o.OrderDate)
								HAVING SUM(od.Quantity) < 200)

ROLLBACK
COMMIT
	

/*4. Inserta un nuevo vendedor llamado Michael Trump. Asígnale los territorios de Louisville, Phoenix, Santa Cruz y Atlanta.*/
SELECT * FROM Employees
SELECT * FROM EmployeeTerritories
SELECT * FROM Territories

BEGIN TRANSACTION
	INSERT INTO Employees(LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, [Address], City, PostalCode, Country, HomePhone, Extension, Notes, ReportsTo)
		VALUES('Trump', 'Michael', 'Sales Representative', 'Mr.', '1948-05-08 00:00:00.000', '1992-05-01 00:00:00.000', 'Calle de María de Molina 16', 'Madrid', 28006, 'Spain', 954261443, 467, 'Es gracioso.', 5)
ROLLBACK
COMMIT

SELECT EmployeeID FROM Employees
	WHERE FirstName = 'Michael' AND LastName = 'Trump'

SELECT (SELECT EmployeeID FROM Employees
			WHERE FirstName = 'Michael' AND LastName = 'Trump'), TerritoryID FROM Territories
	WHERE TerritoryDescription IN ('Louisville', 'Phoenix', 'Santa Cruz', 'Atlanta')


BEGIN TRANSACTION 
	INSERT INTO EmployeeTerritories(EmployeeID, TerritoryID)
		SELECT (SELECT EmployeeID FROM Employees WHERE FirstName = 'Michael' AND LastName = 'Trump'), TerritoryID FROM Territories
				WHERE TerritoryDescription IN ('Louisville', 'Phoenix', 'Santa Cruz', 'Atlanta')

		/*SELECT e.EmployeeID, t.TerritoryID
			FROM Territories AS t
			INNER JOIN EmployeeTerritories AS et
			ON t.TerritoryID = et.TerritoryID
			INNER JOIN Employees AS e
			ON et.EmployeeID = e.EmployeeID
				WHERE TerritoryDescription IN ('Louisville', 'Phoenix', 'Santa Cruz', 'Atlanta')*/

ROLLBACK
COMMIT

SELECT et.EmployeeID, t.TerritoryID, t.TerritoryDescription
	FROM EmployeeTerritories AS et
	INNER JOIN Territories AS t
	ON et.TerritoryID = t.TerritoryID
		ORDER BY EmployeeID

/*5. Haz que las ventas del año 97 de Robert King que haya hecho a clientes de los estados de California y Texas se le asignen al nuevo empleado.*/
SELECT * FROM [Order Details]
SELECT * FROM Orders
SELECT * FROM Employees

SELECT a.ProductSales
	FROM [Product Sales for 1997] AS a
	INNER JOIN Products AS p
	ON a.ProductName = p.ProductName
	INNER JOIN [Order Details] AS od
	ON p.ProductID = od.ProductID
	INNER JOIN Orders AS o
	ON od.OrderID = o.OrderID
	INNER JOIN Employees AS e
	ON o.EmployeeID = e.EmployeeID
		WHERE e.FirstName = 'Robert' AND e.LastName = 'King'

/*6. Inserta un nuevo producto con los siguientes datos:
	ProductID: 90
	ProductName: Nesquick Power Max
	SupplierID: 12
	CategoryID: 3
	QuantityPerUnit: 10 x 300g
	UnitPrice: 2,40
	UnitsInStock: 38
	UnitsOnOrder: 0
	ReorderLevel: 0
	Discontinued: 0*/
SELECT * FROM Products


BEGIN TRANSACTION
	INSERT INTO Products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
		VALUES('Nesquick Power Max', 12, 3, '10 x 300g', 2.40, 38, 0, 0, 0)
ROLLBACK
COMMIT

/*7. Inserta un nuevo producto con los siguientes datos:
	ProductID: 91
	ProductName: Mecca Cola
	SupplierID: 1
	CategoryID: 1
	QuantityPerUnit: 6 x 75 cl
	UnitPrice: 7,35
	UnitsInStock: 14
	UnitsOnOrder: 0
	ReorderLevel: 0
	Discontinued: 0*/
SELECT * FROM Products


BEGIN TRANSACTION
	INSERT INTO Products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
		VALUES('Mecca Cola', 1, 1, '6 x 75 cl', 7.35, 14, 0, 0, 0)
ROLLBACK
COMMIT

/*8. Todos los que han comprado "Outback Lager" han comprado cinco años después la misma cantidad de Mecca Cola al mismo vendedor.*/
SELECT * FROM Customers
SELECT * FROM Orders
SELECT * FROM [Order Details]
SELECT * FROM Products

GO
CREATE VIEW CantidadOutbackLagerComprada AS
SELECT c.CompanyName, SUM(od.Quantity) AS [Cantidad], O.EmployeeID, p.ProductName
	FROM Customers AS c
	INNER JOIN Orders AS o
	ON c.CustomerID = o.CustomerID
	INNER JOIN [Order Details] AS od
	ON o.OrderID = od.OrderID
	INNER JOIN Products AS p
	ON od.ProductID = p.ProductID
		WHERE p.ProductName = 'Outback Lager'
		GROUP BY c.CompanyName, O.EmployeeID, p.ProductName
GO

BEGIN TRANSACTION

ROLLBACK
COMMIT

/*9. El pasado 20 de enero, Margaret Peacock consiguió vender una caja de Nesquick Power Max a todos los clientes que le habían comprado algo anteriormente.
Los datos de envío (dirección, transportista, etc) son los mismos de alguna de sus ventas anteriores a ese cliente).*/
