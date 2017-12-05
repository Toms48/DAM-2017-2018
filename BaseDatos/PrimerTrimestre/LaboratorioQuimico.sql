CREATE DATABASE LaboratorioQuimico
GO

USE LaboratorioQuimico
GO

CREATE TABLE LQ_Elementos(
	simbolo char(2) NOT NULL
		CONSTRAINT PK_LQ_Elementos Primary Key,
	nombre varchar(15) NOT NULL
)

CREATE TABLE LQ_Tipos_Compuesto(
	tipo tinyint NOT NULL IDENTITY(1,1)
		CONSTRAINT PK_LQ_Tipos_Compuesto Primary Key,
	denominacion varchar(30) NOT NULL
		CONSTRAINT UQ_denominacion_LQ_Tipos_Compuestos UNIQUE,
)