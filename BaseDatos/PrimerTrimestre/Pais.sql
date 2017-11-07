CREATE DATABASE Pais
GO

USE Pais
GO

CREATE TABLE Comunidad(
	Nombre varchar(20) NOT NULL
		CONSTRAINT PK_comunidad PRIMARY KEY,
	Superficie int NOT NULL,
	Poblacion int NOT NULL,
	Nombre_localidad varchar(30) NOT NULL
		/*CONSTRAINT FK_comunidad_localidad FOREIGN KEY
		REFERENCES localidad(Nombre)*/
)

CREATE TABLE Provincia(
	CP int NOT NULL
		CONSTRAINT PK_Provincia PRIMARY KEY,
	Nombre varchar(20) NOT NULL,
	Superficie int NOT NULL,
	Poblacion int NOT NULL,
	Nombre_localidad varchar(30) NOT NULL,
		/*CONSTRAINT FK_provincia_localidad FOREIGN KEY
		REFERENCES localidad(Nombre),*/
	Nombre_comunidad varchar(30) NOT NULL
		/*CONSTRAINT FK_provincia_comunidad FOREIGN KEY
		REFERENCES comunidad(Nombre)*/
)

CREATE TABLE Localidad(
	Nombre varchar(30) NOT NULL
		CONSTRAINT PK_Localidad PRIMARY KEY,
	Poblacion int NOT NULL,
	CP_provincia int NOT NULL
		/*CONSTRAINT FK_localidad_provincia FOREIGN KEY
		REFERENCES provincia(CP)*/
)

ALTER TABLE Comunidad ADD
	CONSTRAINT FK_comunidad_localidad FOREIGN KEY (Nombre_localidad)
	REFERENCES localidad(Nombre)