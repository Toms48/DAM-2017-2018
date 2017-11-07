CREATE DATABASE Cafeteria
GO

USE Cafeteria
GO

--Creamos la tabla cafes
CREATE TABLE cafes(
	Nombre varchar(30) NOT NULL 
		 CONSTRAINT PK_Cafes Primary Key,
	Origen varchar(40) NOT NULL
)

--Creamos la tabla propiedades
CREATE TABLE propiedades(
	ID int NOT NULL 
		CONSTRAINT PK_Propiedades Primary Key,
	Descripcion varchar(50) NOT NULL
)

--Creamos la tabla clientes
CREATE TABLE clientes(
	DNI varchar(10) NOT NULL
		CONSTRAINT PK_clientes Primary Key,
	Nombre varchar(20) NOT NULL,
	Direccion varchar(30) NOT NULL
)

--Creamos la tabla mezclas
CREATE TABLE mezclas(
	Codigo varchar(20) NOT NULL
		CONSTRAINT PK_mezclas Primary Key,
	Nombre varchar(30) NOT NULL,
	DNI_Clientes varchar(10) NOT NULL
		CONSTRAINT FK_mezclas_clientes Foreign Key
		REFERENCES clientes(DNI)
)

--Creamos la tabla cafesPropiedades
--Tabla creada por la relacion N:M
CREATE TABLE cafesPropiedades(
	Nombre_Cafes varchar(30) NOT NULL
		CONSTRAINT FK_cafesPropiedades_cafes Foreign Key
		REFERENCES cafes(Nombre),
	ID_Propiedades int NOT NULL
		CONSTRAINT FK_cafesPropiedades_propiedades Foreign Key
		REFERENCES propiedades(ID),
	CONSTRAINT PK_cafesPropiedades Primary Key (Nombre_Cafes, ID_Propiedades)
)

--Creamos la tabla cafesMezclas
--Tabla creada por la relacion N:M
CREATE TABLE cafesMezclas(
	Nombre_Cafes varchar(30) NOT NULL
		CONSTRAINT FK_cafesMezcla_cafes Foreign Key
		REFERENCES cafes(Nombre),
	Codigo_Mezclas varchar(20) NOT NULL
		CONSTRAINT FK_cafesMezcla_mezclas Foreign Key
		REFERENCES mezclas(Codigo),
	CONSTRAINT PK_cafesMezclas Primary Key (Nombre_Cafes, Codigo_Mezclas),
	Proporcion int NOT NULL
)

--Creamos mezclasClientes
--Tabla creada por la relacion N:M
CREATE TABLE mezclasClientes(
	Codigo_Mezclas varchar(20) NOT NULL
		CONSTRAINT FK_mezclasCliente_mezclas Foreign Key
		REFERENCES mezclas(Codigo),
	DNI_Clientes varchar(10) NOT NULL
		CONSTRAINT FK_mezclasCliente_clientes Foreign Key
		REFERENCES clientes(DNI),
	CONSTRAINT PK_mezclasClientes Primary Key (DNI_clientes, Codigo_Mezclas)
)

/*
USE master
DROP DATABASE Cafeteria
GO
*/