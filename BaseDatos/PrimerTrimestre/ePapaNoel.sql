CREATE DATABASE ePapaNoel
GO

USE ePapaNoel
GO

CREATE TABLE Persona(
	DNI char(10)
	FechaNac date
	Nombre varchar(30)
	Telefono char(9)
)

CREATE TABLE Ruta(
	ID int
	Zona varchar(50)
)

CREATE TABLE Peticion(
	ID int
	DNI_Persona char(10)
	ID_Ruta int
)

CREATE TABLE Pedido(
	ID int
	Fecha date
	ID_Tienda int
)

CREATE TABLE Tienda(
	ID int
	Denominacio varchar(30)
	Telefono
)

CREATE TABLE Accion(
	Codigo int
	Descripcion varchar()
	FechaHora
	Lugar
)

CREATE TABLE Buena(
	CodigoAccion
	Periodico
	Recompensa
)

CREATE TABLE Mala(
	CodigoAccion
	Coste
	Delito
)

CREATE TABLE Regalo(
	ID
)

CREATE TABLE Categoria(
	IDRegalo
)

CREATE TABLE Producto(
	IDRegalo
)

--N:M reflexivas

CREATE TABLE ProductoSustituyeProducto(
	ID_Producto1
	ID_Producto2
)

CREATE TABLE PersonaInformaPersona(
	ID_Informante
	ID_Sujeto
)

--N:M

CREATE TABLE Persona_Accion(
	ID_Persona
	Codigo_Accion
	Motivo
)

CREATE TABLE Persona_Mala(
	Id_Persona
	Codigo_Accion
)

CREATE TABLE Peticion_Regalo(
	ID_Peticion
	ID_Regalo
)

CREATE TABLE Producto_Pedido(
	IDRegalo_Producto
	ID_Pedido
)

CREATE TABLE Producto_Tienda(
	IDRegalo_Producto
	ID_Pedido
)

CREATE TABLE Producto_Categoria(
	IDRegalo_Producto
	IDRegalo_Categoria
)