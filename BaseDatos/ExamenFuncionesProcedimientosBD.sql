/*
Ejercicio 1
Por un error (alguien se olvidó de poner el WHERE), la columna Importe de la tabla CLPedidos ha quedado a NULL.

Queremos un procedimiento almacenado AsignarImportes que coloque los valores correctos.

Los precios de los complementos están en la tabla CLComplementos y son los mismos para todos los chiringuitos

Los de los vinos están en la tabla CLCartaVinos y pueden variar de un chiringuito a otro.

Los de los platos están en la tabla CLCartaPlatos y pueden variar de un chiringuito a otro.

PISTA: Se puede modular.
Hacer funciones que calculen cosas (funciones catalanas, que diría M. Rajoy) para un pedido y usarlas en un UPDATE brutal.
O también se puede hacer complicado si os gusta vivir al límite
*/
SELECT * FROM CLTiposVino
SELECT * FROM CLVinos
SELECT * FROM CLCartaVinos
SELECT * FROM CLPlatos
SELECT * FROM CLComplementos

SELECT * FROM CLClientes
SELECT * FROM CLEstablecimientos
SELECT * FROM CLCamarers

SELECT * FROM CLPedidos

SELECT * FROM CLPedidosVinos
SELECT * FROM CLPedidosComplementos
SELECT * FROM CLPedidosPlatos

/*
He tomado como solución pasar de las tablas cartas, porque no me gusta, me parece muy feo eso de precios distintos,
aquí todos moros o todos cristianos
*/

--SELECT para calcular el importe de Complementos por pedido
SELECT SUM(co.Importe * peco.Cantidad) AS [ImporteComplementosPorPedido], peco.IDPedido
	FROM CLComplementos AS co
	INNER JOIN CLPedidosComplementos AS peco
	ON co.ID = peco.IDComplemento
	GROUP BY peco.IDPedido

GO
CREATE FUNCTION ImporteComplementosFinal(@IDPedido bigint)
RETURNS money AS
BEGIN
	DECLARE @importeComplementos money

	SELECT @importeComplementos = SUM(co.importe * peco.Cantidad)
										FROM CLComplementos AS co
										INNER JOIN CLPedidosComplementos AS peco
										ON co.ID = peco.IDComplemento
										WHERE peco.IDPedido = @IDPedido
										GROUP BY peco.IDPedido

	RETURN @importeComplementos
END
GO

BEGIN TRANSACTION
	PRINT dbo.ImporteComplementos(1589)
ROLLBACK
COMMIT

--SELECT para calcular el importe de Vinos por pedido
SELECT SUM(v.PVP * pv.Cantidad) AS [ImporteVinosPorPedido], pv.IDPedido
	FROM CLVinos AS v
	INNER JOIN CLPedidosVinos AS pv
	ON v.ID = pv.IDVino
	GROUP BY pv.IDPedido

GO
CREATE FUNCTION ImporteVinosFinal(@IDPedido bigint)
RETURNS money AS
BEGIN
	DECLARE @importeComplementos money

	SELECT @importeComplementos = SUM(v.PVP * pv.Cantidad)
									FROM CLVinos AS v
									INNER JOIN CLPedidosVinos AS pv
									ON v.ID = pv.IDVino
									WHERE pv.IDPedido = @IDPedido
									GROUP BY pv.IDPedido

	RETURN @importeComplementos
END
GO

--SELECT para calcular el importe de los Platos por pedido (ya sumo si son tapas, medias o raciones)
SELECT SUM((pla.PVPTapaRecomendado * pepla.CantidadTapas)+
		(pla.PVPRacionRecomendado * pepla.CantidadRaciones)+
		(pla.PVPMediaRecomendado * pepla.CantidadMedias)) AS [ImportePlatosPorPedido], pepla.IDPedido
	FROM CLPlatos AS pla
	INNER JOIN CLPedidosPlatos AS pepla
	ON pla.ID = pepla.IDPlato
	GROUP BY pepla.IDPedido

GO
CREATE FUNCTION ImportePlatosFinal(@IDPedido bigint)
RETURNS money AS
BEGIN
	DECLARE @importeComplementos money

	SELECT @importeComplementos = SUM((pla.PVPTapaRecomendado * pepla.CantidadTapas)+
										(pla.PVPRacionRecomendado * pepla.CantidadRaciones)+
										(pla.PVPMediaRecomendado * pepla.CantidadMedias))
									FROM CLPlatos AS pla
									INNER JOIN CLPedidosPlatos AS pepla
									ON pla.ID = pepla.IDPlato
									WHERE pepla.IDPedido = @IDPedido
									GROUP BY pepla.IDPedido

	RETURN @importeComplementos
END
GO

--PROCEDURE AsignarImportes
GO
ALTER PROCEDURE AsignarImportes
AS
BEGIN
	UPDATE CLPedidos
		SET Importe = dbo.ImporteComplementosFinal(CLPedidos.ID) + dbo.ImportePlatosFinal(CLPedidos.ID) + dbo.ImporteVinosFinal(CLPedidos.ID) --No sé porque me actualiza mal y me pone el dinero a solo dos numeros
END
GO

BEGIN TRANSACTION
	EXECUTE AsignarImportes
ROLLBACK
COMMIT

SELECT * FROM CLPedidos

/*
Ejercicio 2
Queremos hacer un ranking de los chiringuitos en base a una serie de parámetros.
Para ello necesitamos una función que nos devuelva una tabla que contenga
los siguientes datos:
	-ID del chiringuito
	-Nombre del chiringuito
	-Ciudad del chiringuito

	-Número de pedidos servidos en la temporada pasada

	-Número de platos servidos (contando tapas, medias y raciones)

	-Facturación

	-Número de botellas de vino vendidas

	-Número de clientes diferentes atendidos

La función recibirá como parámetros un intervalo de tiempo (inicio y fin del intervalo)
*/

--SELECT para tener el número de pedidos por establecimiento
SELECT e.ID, COUNT(p.ID) AS [Numero de pedidos]
	FROM CLEstablecimientos AS e
	INNER JOIN CLPedidos AS p
	ON e.ID = p.IDEstablecimiento
	GROUP BY e.ID

GO
CREATE FUNCTION Prueba2 (@IDEstablecimiento smallint)
RETURNS TABLE AS
RETURN(SELECT e.ID, COUNT(p.ID) AS [Numero de pedidos]
			FROM CLEstablecimientos AS e
			INNER JOIN CLPedidos AS p
			ON e.ID = p.IDEstablecimiento
			WHERE e.ID = @IDEstablecimiento
			GROUP BY e.ID)
GO

--Función para saber cuantos pedidos hay por establecimientos
/*
ENTRADAS: ID del establecimiento
SALIDAS: el número de pedidos
*/
GO
CREATE FUNCTION PedidosEstablecimientoFinal (@IDEstablecimiento smallint)
RETURNS int AS
BEGIN
	DECLARE @pedidosEstablecimiento int

	SELECT @pedidosEstablecimiento = COUNT(p.ID)
										FROM CLEstablecimientos AS e
										INNER JOIN CLPedidos AS p
										ON e.ID = p.IDEstablecimiento
										WHERE e.ID = @IDEstablecimiento
										GROUP BY e.ID

	RETURN @pedidosEstablecimiento
END
GO

--SELECT para calcular la cantidad de platos por establecimiento
SELECT e.ID AS [IDEstablecimiento], SUM(pp.CantidadMedias+pp.CantidadRaciones+pp.CantidadTapas) AS [Cantidad de platos vendidos]
	FROM CLEstablecimientos AS e
	INNER JOIN CLPedidos AS p
	ON e.ID = p.IDEstablecimiento
	INNER JOIN CLPedidosPlatos AS pp
	ON p.ID = pp.IDPedido
	GROUP BY e.ID

--Función para tener la cantidad de platos vendidos por establecimiento
/*
ENTRADAS: ID del establecimiento
SALIDAS: el número de platos vendidos
*/
GO
ALTER FUNCTION PlatosEstablecimientoFinal (@IDEstablecimiento smallint)
RETURNS int AS
BEGIN
	DECLARE @platosEstablecimiento int

	SELECT @platosEstablecimiento = SUM(pp.CantidadMedias+pp.CantidadRaciones+pp.CantidadTapas)
											FROM CLEstablecimientos AS e
											INNER JOIN CLPedidos AS p
											ON e.ID = p.IDEstablecimiento
											INNER JOIN CLPedidosPlatos AS pp
											ON p.ID = pp.IDPedido
											WHERE e.ID = @IDEstablecimiento
											GROUP BY e.ID

	RETURN @platosEstablecimiento
END
GO

--SELECT para saber el numero de vinos vendidos
SELECT e.ID AS [IDEstablecimiento], SUM(Cantidad) AS [Cantidad de vinos]
	FROM CLEstablecimientos AS e
	INNER JOIN CLPedidos AS p
	ON e.ID = p.IDEstablecimiento
	INNER JOIN CLPedidosVinos AS pv
	ON p.ID = pv.IDPedido
	GROUP BY e.ID

--Función para tener la cantidad de vinos vendidos por un establecimiento
/*
ENTRADAS: ID del establecimiento
SALIDAS:el número de vinos vendidos
*/
GO
ALTER FUNCTION VinosEstablecimientoFinal (@IDEstablecimiento smallint)
RETURNS int AS
BEGIN
	DECLARE @vinosEstablecimiento int

	SELECT @vinosEstablecimiento = SUM(Cantidad)
										FROM CLEstablecimientos AS e
										INNER JOIN CLPedidos AS p
										ON e.ID = p.IDEstablecimiento
										INNER JOIN CLPedidosVinos AS pv
										ON p.ID = pv.IDPedido
										WHERE e.ID = @IDEstablecimiento
										GROUP BY e.ID

	RETURN @vinosEstablecimiento
END
GO

--SELECT para saber el numero de clientes atendidos
SELECT e.ID AS [IDEstablecimiento], COUNT(c.ID) AS [Cantidad de clientes]
	FROM CLEstablecimientos AS e
	INNER JOIN CLPedidos AS p
	ON e.ID = p.IDEstablecimiento
	INNER JOIN CLClientes AS c
	ON p.IDCliente = c.ID
	GROUP BY e.ID

--Función para tener la cantidad de clientes que han pasado por allí
/*
ENTRADAS: ID del establecimiento
SALIDAS: el número de clientes
*/
GO
create FUNCTION CantidadClientesFinal (@IDEstablecimiento smallint)
RETURNS int AS
BEGIN
	DECLARE @CLIENTESEstablecimiento int

	SELECT @CLIENTESEstablecimiento = COUNT(c.ID)
										FROM CLEstablecimientos AS e
										INNER JOIN CLPedidos AS p
										ON e.ID = p.IDEstablecimiento
										INNER JOIN CLClientes AS c
										ON p.IDCliente = c.ID
										WHERE e.ID = @IDEstablecimiento
										GROUP BY e.ID

	RETURN @CLIENTESEstablecimiento
END
GO

--Función final
/*
ENTRADAS: Fecha inicio y una fecha fin
SALIDAS: todas las comunas que me pides arriba
*/
GO
CREATE FUNCTION Ejercicio2 (@FechaInicio smalldatetime, @FechaFin smalldatetime)
RETURNS TABLE AS
RETURN(

	SELECT e.ID, e.Denominacion, e.Ciudad
		FROM CLEstablecimientos AS e
	
	/*
	Aquí va un SELECT utilizando las funciones anteriores para poder tener todas las columnas que nos piden
	Tendriamos que poner WHERE para que la fecha del pedido esté en el rango de fechas que nosotros le mandamos
		WHERE p.Fecha BETWEEN @FechaInicio AND @FechaFin
	*/
)
GO

/*
Aquí escribimos un SELECT que llame a la última función, pasandole los parámetros de fechas se nos queda un ejercicio lamar de bien hecho
(solo que a mi no me ha dado tiempo de terminarlo)
*/








/*
Ejercicio 3
Nos interesa conocer cuáles son los vinos preferidos de nuestros clientes según el tipo de plato.
Queremos una función a la que se le pase el ID de un cliente y nos devuelva una tabla indicando cuál es el vino que prefiere cuando toma platos de cada sección.
Las columnas de la tabla indicarán:
	-ID de la seccion
	-Nombre de la sección
	-Nombre del vino que más veces ha acompañado con platos de esa sección
	-Número de veces que ha elegido ese vino
*/

SELECT p.ID, pla.Nombre
	FROM CLPedidos AS p
	INNER JOIN CLPedidosPlatos AS pp
	ON p.ID = pp.IDPedido
	INNER JOIN CLPlatos AS pla
	ON pp.IDPlato = pla.ID

GO
CREATE FUNCTION VinoPreferidoPorSeccion(@IDCliente int)
RETURNS TABLE AS
RETURN()
GO

