--1. Crea una base de datos de nombre �Laboratorio Quimico�.

CREATE DATABASE LaboratorioQuimico
GO

USE LaboratorioQuimico
GO

/*2. Crea una tabla de nombre LQ_Elementos, con las columnas simbolo (dos caracteres, clave primaria) y nombre (Cadena variable de tama�o 15). Ninguna admite nulos.*/

CREATE TABLE LQ_Elementos(
	simbolo char(2) NOT NULL
		CONSTRAINT PK_LQ_Elementos Primary Key,
	nombre varchar(15) NOT NULL
)

/*3. Crea otra tabla llamada LQ_Tipos_Compuesto con dos columnas: tipo (entero corto, clave primaria, identidad) y denominacion (cadena variable de tama�o 30).
Ninguna admite nulos. Define denominacion como clave alternativa.*/

CREATE TABLE LQ_Tipos_Compuesto(
	tipo tinyint NOT NULL IDENTITY(1,1)
		CONSTRAINT PK_LQ_Tipos_Compuesto Primary Key,
	denominacion varchar(30) NOT NULL
		CONSTRAINT UQ_denominacion_LQ_Tipos_Compuestos UNIQUE,
)

/*4. Crea otra tabla llamada LQ_Moleculas con las columnas: 
	- nombre_clasico (cadena variable longitud 30)
	- nombre_IUPAC (cadena variable longitud 30)
	- color (cadena variable longitud 20)
	- densidad (decimal de dos cifras enteras y tres decimales)
	- punto_fusion(real)
	- punto_ebullicion (real)

Ninguna admite nulos excepto densidad y color.
punto_fusion y punto_ebullicion toman valores positivos. El valor de punto_ebullici�n ha de ser superior a punto_fusion. */

CREATE TABLE LQ_Moleculas(
	nombre_clasico varchar(30) NOT NULL,
	nombre_IUPAC varchar(30) NOT NULL,
	color varchar(20) NULL,
	densidad decimal(5,3) NULL,		--5 es la cantidad de numeros enteros y decimales, 3 es la cantidad de numeros decimales
	punto_fusion real NOT NULL
		CONSTRAINT CK_punto_fusion CHECK (punto_fusion >= 0),
	punto_ebullicion real NOT NULL
		CONSTRAINT CK_punto_ebullicion CHECK (punto_ebullicion >= 0),
	CONSTRAINT CK_puntofusion_puntoebullicion CHECK (punto_ebullicion > punto_fusion),
)

/*5. A�ade dos nuevas columnas a la tabla LQ_Elementos: numero_atomico (entero corto, sin nulos) y masa_atomica (tres cifras enteras y cinco decimales, admite nulos).
El n�mero at�mico no debe admitir valores inferiores a uno ni superiores a 300 y ser� clave alternativa.*/

ALTER TABLE LQ_Elementos ADD
	numero_atomico smallint NOT NULL

ALTER TABLE LQ_Elementos ADD
	masa_atomica decimal(8,5) NULL

/*6. A�ade una nueva columna a LQ_Moleculas llamada codigo. Ser� de tipo entero, identidad y def�nela como clave primaria.*/

ALTER TABLE LQ_Moleculas ADD
	codigo int NOT NULL IDENTITY(1,1)
		CONSTRAINT PK_LQ_Moleculas PRIMARY KEY

/*7. Crea una nueva tabla que relacione LQ_Elementos con LQ_Moleculas, ll�mala LQ_MoleculasElementos.
A�ade una columna numero que indique el sub�ndice del elemento en la mol�cula (entero corto sin nulos, valor m�nimo 1).
Crea las restricciones de clave primaria y ajena que sean necesarias.*/

CREATE TABLE LQ_MoleculasElementos(
	subindiceElementoMolecula tinyint NOT NULL
		CONSTRAINT CK_LQ_MoleculasElementos CHECK (subindiceElementoMolecula >= 1),
	LQ_Elementos_LQ_MoleculasElementos char(2) NOT NULL,
	LQ_Moleculas_LQ_MoleculasElementos int NOT NULL,
	CONSTRAINT PK_LQ_MoleculasElementos PRIMARY KEY (LQ_Elementos_LQ_MoleculasElementos, LQ_Moleculas_LQ_MoleculasElementos)
)

ALTER TABLE LQ_MoleculasElementos ADD
	CONSTRAINT LQ_MoleculasElementos_LQ_Elementos FOREIGN KEY (LQ_Elementos_LQ_MoleculasElementos) REFERENCES LQ_Elementos(simbolo)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION

ALTER TABLE LQ_MoleculasElementos ADD
	CONSTRAINT LQ_MoleculasElementos_LQ_Moleculas FOREIGN KEY (LQ_Moleculas_LQ_MoleculasElementos) REFERENCES LQ_Moleculas(codigo)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION