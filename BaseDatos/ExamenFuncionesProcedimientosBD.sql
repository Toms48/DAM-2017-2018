/*
Ejercicio 1
Por un error (alguien se olvid� de poner el WHERE), la columna Importe de la tabla CLPedidos ha quedado a NULL.

Queremos un procedimiento almacenado AsignarImportes que coloque los valores correctos.

Los precios de los complementos est�n en la tabla CLComplementos y son los mismos para todos los chiringuitos

Los de los vinos est�n en la tabla CLCartaVinos y pueden variar de un chiringuito a otro.

Los de los platos est�n en la tabla CLCartaPlatos y pueden variar de un chiringuito a otro.

PISTA: Se puede modular.
Hacer funciones que calculen cosas (funciones catalanas, que dir�a M. Rajoy) para un pedido y usarlas en un UPDATE brutal.
O tambi�n se puede hacer complicado si os gusta vivir al l�mite
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
He tomado como soluci�n pasar de las tablas cartas, porque no me gusta, me parece muy feo eso de precios distintos,
aqu� todos moros o todos cristianos
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
		SET Importe = dbo.ImporteComplementosFinal(CLPedidos.ID) + dbo.ImportePlatosFinal(CLPedidos.ID) + dbo.ImporteVinosFinal(CLPedidos.ID) --No s� porque me actualiza mal y me pone el dinero a solo dos numeros
END
GO

BEGIN TRANSACTION
	EXECUTE AsignarImportes
ROLLBACK
COMMIT

SELECT * FROM CLPedidos

/*
Ejercicio 2
Queremos hacer un ranking de los chiringuitos en base a una serie de par�metros.
Para ello necesitamos una funci�n que nos devuelva una tabla que contenga
los siguientes datos:
	-ID del chiringuito
	-Nombre del chiringuito
	-Ciudad del chiringuito

	-N�mero de pedidos servidos en la temporada pasada

	-N�mero de platos servidos (contando tapas, medias y raciones)

	-Facturaci�n

	-N�mero de botellas de vino vendidas

	-N�mero de clientes diferentes atendidos

La funci�n recibir� como par�metros un intervalo de tiempo (inicio y fin del intervalo)
*/

--SELECT para tener el n�mero de pedidos por establecimiento
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

--Funci�n para saber cuantos pedidos hay por establecimientos
/*
ENTRADAS: ID del establecimiento
SALIDAS: el n�mero de pedidos
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

--Funci�n para tener la cantidad de platos vendidos por establecimiento
/*
ENTRADAS: ID del establecimiento
SALIDAS: el n�mero de platos vendidos
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

--Funci�n para tener la cantidad de vinos vendidos por un establecimiento
/*
ENTRADAS: ID del establecimiento
SALIDAS:el n�mero de vinos vendidos
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

--Funci�n para tener la cantidad de clientes que han pasado por all�
/*
ENTRADAS: ID del establecimiento
SALIDAS: el n�mero de clientes
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

--Funci�n final
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
	Aqu� va un SELECT utilizando las funciones anteriores para poder tener todas las columnas que nos piden
	Tendriamos que poner WHERE para que la fecha del pedido est� en el rango de fechas que nosotros le mandamos
		WHERE p.Fecha BETWEEN @FechaInicio AND @FechaFin
	*/
)
GO

/*
Aqu� escribimos un SELECT que llame a la �ltima funci�n, pasandole los par�metros de fechas se nos queda un ejercicio lamar de bien hecho
(solo que a mi no me ha dado tiempo de terminarlo)
*/








/*
Ejercicio 3
Nos interesa conocer cu�les son los vinos preferidos de nuestros clientes seg�n el tipo de plato.
Queremos una funci�n a la que se le pase el ID de un cliente y nos devuelva una tabla indicando cu�l es el vino que prefiere cuando toma platos de cada secci�n.
Las columnas de la tabla indicar�n:
	-ID de la seccion
	-Nombre de la secci�n
	-Nombre del vino que m�s veces ha acompa�ado con platos de esa secci�n
	-N�mero de veces que ha elegido ese vino
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

