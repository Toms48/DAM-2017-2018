BEGIN TRANSACTION
GO
	--Creamos 
	CREATE PROCEDURE Existe
		--Declaramos las variables de entrada
		@NombreProducto nvarchar(40)
	AS
		BEGIN
			IF EXISTS (SELECT * FROM Products WHERE ProductName = @NombreProducto)
				BEGIN
					Print 'Ya existe'
				END
			ELSE
				BEGIN
					Print 'Que va, no existe'
				END
		END
ROLLBACK
COMMIT
GO

/*1. Deseamos incluir un producto en la tabla Products llamado "Cruzcampo lata” pero no estamos seguros si se ha insertado o no.
El precio son 4,40, el proveedor es el 16, la categoría 1 y la cantidad por unidad es "Pack 6 latas” "Discontinued” toma el valor 0 y el resto a NULL.
Escribe un script que compruebe si existe un producto con ese nombre.
En caso afirmativo, actualizará el precio y en caso negativo insertarlo.*/
IF EXISTS (SELECT * FROM Products WHERE ProductName = 'Cruzcampo lata')
	BEGIN
		Print 'Ya existe'
	END
ELSE
	BEGIN
		Print 'Que va, no existe'
	END

DECLARE @NombreProducto nvarchar(40)
SET @NombreProducto = 'Cruzcampo lata'
EXECUTE Existe @NombreProducto

BEGIN TRANSACTION
	INSERT INTO Products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, Discontinued)
		VALUES('Cruzcampo lata', 16, 1, 'Pack 6 latas', 4.40, 0)
ROLLBACK
COMMIT

BEGIN TRANSACTION
	UPDATE Products
		SET UnitPrice = 5.40
		WHERE ProductName = 'Cruzcampo lata'
ROLLBACK
COMMIT

IF EXISTS (SELECT * FROM Products WHERE ProductName = 'Cruzcampo lata')
	BEGIN
		UPDATE Products
			SET UnitPrice = 4.40
			WHERE ProductName = 'Cruzcampo lata'
	END
ELSE
	BEGIN
		INSERT INTO Products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, Discontinued)
			VALUES('Cruzcampo lata', 16, 1, 'Pack 6 latas', 4.40, 0)
	END


/*2. Comprueba si existe una tabla llamada ProductSales.
Esta tabla ha de tener de cada producto:
	- el ID
	- el Nombre
	- el Precio unitario
	- el número total de unidades vendidas
	- el total de dinero facturado con ese producto.
Si no existe, créala.*/
SELECT * FROM SYSOBJECTS
	WHERE name = 'ProductSales'

IF EXISTS (SELECT * FROM SYSOBJECTS WHERE name = 'ProductSales')
	BEGIN
		PRINT 'La tabla ya existe'
	END
ELSE
	BEGIN
		CREATE TABLE ProductSales(
			ID int NOT NULL
				CONSTRAINT PK_ProductSales Primary Key,
			Nombre varchar(50) NULL,
			PrecioUnitario money NULL,
			TotalUnidadesVendidas int NULL,
			DineroFacturadoTotal money NULL
		)
	END


/*3. Comprueba si existe una tabla llamada ShipShip.
Esta tabla ha de tener de cada Transportista:
	- el ID
	- el Nombre de la compañía
	- el número total de envíos que ha efectuado
	- el número de países diferentes a los que ha llevado cosas
Si no existe, créala.*/
SELECT * FROM SYSOBJECTS
	WHERE name = 'ShipShip'

IF EXISTS (SELECT * FROM SYSOBJECTS WHERE name = 'ShipShip')
	BEGIN
		PRINT 'La tabla ya existe'
	END
ELSE
	BEGIN
		CREATE TABLE ShipShip(
			ID int NOT NULL
				CONSTRAINT PK_ShipShip Primary Key,
			NombreCompania varchar(50) NOT NULL,
			EnviosTotalesEfectuados int NULL,
			TotalUnidadesVendidas int NULL,
			PaisesDiferentes int NULL
		)
	END

/*4. Comprueba si existe una tabla llamada EmployeeSales.
Esta tabla ha de tener de cada empleado:
	- su ID
	- el Nombre completo
	- el número de ventas totales que ha realizado
	- el número de clientes diferentes a los que ha vendido
	- el total de dinero facturado
Si no existe, créala.*/
SELECT * FROM SYSOBJECTS
	WHERE name = 'EmployeeSales'

IF EXISTS (SELECT * FROM SYSOBJECTS WHERE name = 'EmployeeSales')
	BEGIN
		PRINT 'La tabla ya existe'
	END
ELSE
	BEGIN
		CREATE TABLE EmployeeSales(
			ID int NOT NULL
				CONSTRAINT PK_EmployeeSales Primary Key,
			Nombre varchar(30) NOT NULL,
			NumeroVentasTotales int NULL,
			ClientesDiferentes int NULL,
			DineroFacturadoTotal money NULL
		)
	END

/*5. Entre los años 96 y 97 hay productos que han aumentado sus ventas y otros que las han disminuido.
Queremos cambiar el precio unitario según la siguiente tabla:*/

/*
-------------------------------------------------------
Incrementos de ventas	|	Incrementos de precio	   
-------------------------------------------------------
	Negativo			|			-10%					   
-------------------------------------------------------
	Entre 0% y 10%		|			No varía
-------------------------------------------------------
	Entre 10% y 50%		|			+5%
-------------------------------------------------------
	Mayor del 50%		|	10% con un máximo de 2,25
-------------------------------------------------------
*/