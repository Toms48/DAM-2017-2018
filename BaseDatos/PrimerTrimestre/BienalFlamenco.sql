CREATE DATABASE BienalFlamenco
GO

USE BienalFlamenco
GO

CREATE TABLE Empresa(
	CIF int NOT NULL
		CONSTRAINT PK_Empresa PRIMARY KEY, 
	Nombre varchar(30) NOT NULL,
	Direccion varchar(50) NULL
)

CREATE TABLE Trabajador(
	DNI char(10) NOT NULL
		CONSTRAINT PK_Trabajador PRIMARY KEY,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(20) NOT NULL,
	Direccion varchar (50) NULL,
	TipoTrabajo varchar(20) NOT NULL,
	CIF_Empresa int NOT NULL
)

--ALTER para las FK de las tablas
ALTER TABLE Trabajador ADD
	CONSTRAINT FK_CIF_Empresa FOREIGN KEY (CIF_Empresa) REFERENCES Empresa(CIF)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Espectaculo(
	ID int NOT NULL
		CONSTRAINT PK_Espectaculo PRIMARY KEY,
	DNI_Trabajador char(10) NOT NULL
)

--ALTER para las FK de las tablas
ALTER TABLE Espectaculo ADD
	CONSTRAINT FK_Trabajador FOREIGN KEY (DNI_Trabajador) REFERENCES Trabajador(DNI)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Artista(  --FK DNI_Trabajador
	DNI char(10) NOT NULL
		CONSTRAINT PK_Artista PRIMARY KEY,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(20) NOT NULL,
	Direccion varchar (50) NULL,
	TipoTrabajo varchar(50) NOT NULL,
	DNI_Representante varchar(10) NOT NULL
)

--ALTER para las FK de las tablas
ALTER TABLE Espectaculo ADD
	CONSTRAINT FK_ FOREIGN KEY (DNI_Trabajador) REFERENCES Trabajador(DNI)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Representante(
	DNI char(10) NOT NULL
		CONSTRAINT PK_Representante PRIMARY KEY,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(20) NOT NULL,
	Direccion varchar (50) NULL
)

CREATE TABLE Funcion(
	ID int NOT NULL
		CONSTRAINT PK_Funcion PRIMARY KEY,
	Recinto varchar(20) NOT NULL,
	Dia varchar(20) NOT NULL,
	Hora time NOT NULL
)

CREATE TABLE Localidad(
	ID int NOT NULL
		CONSTRAINT PK_Localidad PRIMARY KEY,
	Zona varchar(20) NOT NULL,
	Espectaculo varchar(20) NOT NULL,
	Recinto varchar(20) NOT NULL,
	Dia varchar(20) NOT NULL,
	Hora time NOT NULL,
	Fila int NOT NULL,
	Asiento int NOT NULL
)

CREATE TABLE Zona(
	ID int NOT NULL
		CONSTRAINT PK_Zona PRIMARY KEY,
	Fila int NOT NULL,
	Asiento int NOT NULL
)

CREATE TABLE Espacio(
	ID int NOT NULL
		CONSTRAINT PK_Espacio PRIMARY KEY,
	TipoEspacio varchar(30) NOT NULL,
	Nombre varchar(20) NOT NULL,
	Direccion varchar(20) NOT NULL,
	Aforo int NOT NULL
)




/*
USE master
GO
DROP DATABASE BienalFlamenco
GO
*/