CREATE DATABASE BienalFlamenco
GO

USE BienalFlamenco
GO

--Mirar los NOT NULL
--Repasar el LIKE para el DNI
--

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

--ALTER para la FK
ALTER TABLE Trabajador ADD
	CONSTRAINT FK_CIF_Empresa FOREIGN KEY (CIF_Empresa) REFERENCES Empresa(CIF)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Espectaculo(
	ID int NOT NULL
		CONSTRAINT PK_Espectaculo PRIMARY KEY,
	DNI_Trabajador char(10) NOT NULL
)

--ALTER para la FK
ALTER TABLE Espectaculo ADD
	CONSTRAINT FK_DNITrabajador FOREIGN KEY (DNI_Trabajador) REFERENCES Trabajador(DNI)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Artista(
	DNI char(10) NOT NULL
		CONSTRAINT PK_Artista PRIMARY KEY,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(20) NOT NULL,
	Direccion varchar (50) NULL,
	TipoTrabajo varchar(50) NOT NULL,
	DNI_Representante char(10) NOT NULL
)

--ALTER para la FK
ALTER TABLE Artista ADD
	CONSTRAINT FK_Representante FOREIGN KEY (DNI_Representante) REFERENCES Representante(DNI)
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
	Asiento int NOT NULL,
	ID_Zona int NOT NULL
)

--ALTER para la FK
ALTER TABLE Localidad ADD
	CONSTRAINT FK_Zona FOREIGN KEY (ID_Zona) REFERENCES Zona(ID)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Zona(
	ID int NOT NULL
		CONSTRAINT PK_Zona PRIMARY KEY,
	Fila int NOT NULL,
	Asiento int NOT NULL,
	ID_Espacio int NOT NULL
)

--ALTER para la FK
ALTER TABLE Zona ADD
	CONSTRAINT FK_Espacio FOREIGN KEY (ID_Espacio) REFERENCES Espacio(ID)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

CREATE TABLE Espacio(
	ID int NOT NULL
		CONSTRAINT PK_Espacio PRIMARY KEY,
	TipoEspacio varchar(30) NOT NULL,
	Nombre varchar(20) NOT NULL,
	Direccion varchar(20) NOT NULL,
	Aforo int NOT NULL
)

CREATE TABLE EspacioEspectaculo(
	ID_Espacio int NOT NULL
		CONSTRAINT FK_EspacioEspectaculo_Espacio FOREIGN KEY (ID_Espacio) REFERENCES Espacio(ID),
	ID_Espectaculo int NOT NULL
		CONSTRAINT FK_EspacioEspectaculo_Espectaculo FOREIGN KEY (ID_Espectaculo) REFERENCES Espectaculo(ID),
	CONSTRAINT PK_EspacioEspectaculo PRIMARY KEY (ID_Espacio, ID_Espectaculo)
)

CREATE TABLE LocalidadFuncion(
	ID_Localidad int NOT NULL
		CONSTRAINT FK_LocalidadFuncion_Localidad FOREIGN KEY (ID_Localidad) REFERENCES Localidad(ID),
	ID_Funcion int NOT NULL
		CONSTRAINT FK_LocalidadFuncion_Funcion FOREIGN KEY (ID_Funcion) REFERENCES Funcion(ID),
	CONSTRAINT PK_LocalidadFuncion PRIMARY KEY (ID_Localidad, ID_Funcion)
)

CREATE TABLE ArtistaEspectaculo(
	DNI_Artista char(10) NOT NULL
		CONSTRAINT FK_ArtistaEspectaculo_Artista FOREIGN KEY (DNI_Artista) REFERENCES Artista(DNI),
	ID_Espectaculo int NOT NULL
		CONSTRAINT FK_ArtistaEspectaculo_Espectaculo FOREIGN KEY (ID_Espectaculo) REFERENCES Espectaculo(ID),
	CONSTRAINT PK_ArtistaEspectaculo PRIMARY KEY (DNI_Artista, ID_Espectaculo)
)

CREATE TABLE TrabajadorEspectaculo(
	DNI_Trabajador char(10) NOT NULL
		CONSTRAINT FK_TrabajadorEspectaculo_Trabajador FOREIGN KEY (DNI_Trabajador) REFERENCES Trabajador(DNI),
	ID_Espectaculo int NOT NULL
		CONSTRAINT FK_TrabajadorEspectaculo_Espectaculo FOREIGN KEY (ID_Espectaculo) REFERENCES Espectaculo(ID),
	CONSTRAINT PK_TrabajadorEspectaculo PRIMARY KEY (DNI_Trabajador, ID_Espectaculo)
)

ALTER TABLE Empresa ADD
	CONSTRAINT CK_CIF CHECK(CIF > 0)

ALTER TABLE Trabajador ADD
	CONSTRAINT CK_TipoTrabajo CHECK(TipoTrabajo IN ('técnico','organizador','relaciones','seguridad','transportista'))

ALTER TABLE Artista ADD
	CONSTRAINT CK_TipoTrabajoTrabajador CHECK(TipoTrabajo IN ('cantores','tocadores','bailaores','músicos de acompañamiento','actores'))



/*
USE master
GO
DROP DATABASE BienalFlamenco
GO
*/