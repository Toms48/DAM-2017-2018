/**Nombre de la clase: Rectangulo
 * 
 * 
 * Propiedades basicas:
 * 
 * 		largo: tipo double, consultable, modificable 
 * 		ancho: tipo double, consultable, modificable 
 * 
 * Propiedades derivadas: 
 * 
 * 		area: tipo double, consultable
 * 		perimetro: tipo double, consultable
 * 
 * restricciones: el largo y el ancho tienen que ser mayores que cero
 * 
 * Recuerda: Las propiedades basicas se convierten en atributos, las derivadas NO
 * 
 * INTERFAZ DE LA CLASE
 * 
 * GETTERS Y SETTERS
 * 
 * public double getLargo()
 * public void setLargo(double largo)
 * 
 * public double getAncho()
 * public void setAncho(double ancho)
 * 
 * public double getArea()
 * 
 * public double getPerimetro()
 * 
 * 
 * metodos añadidos: 
 * 			
 * 			CalcularDiagonal()
 * 
 */
 
public class Rectangulo
{
	
	private double largo;
	private double ancho;
	
	//constructores 
	
	//por defecto
	public Rectangulo()
	{
		double largo=0.0;
		double ancho=0.0;
	}
	
	//sobrecargados
	public Rectangulo(double largo, double ancho) throws ExcepcionRectangulo//esto no esta bien hacerlo es solo para un ejemplo
	{
		if(largo<1)
		{
			throw new ExcepcionRectangulo("El largo tiene que ser mayor que cero");//esto sirve para lanzar un mensaje
		}																			
		else if(ancho<1)
		{
			throw new ExcepcionRectangulo("El ancho tiene que ser mayor que cero");
		}
		else
		{
			this.largo=largo;
			this.ancho=ancho;
		}
	}
	
	//de copia
	public Rectangulo(Rectangulo rectangulo)
	{
		this.largo=rectangulo.getLargo();
		this.ancho=rectangulo.getAncho();
	}
	
	
	//getters y setters
	public double getLargo() 
	{
		return largo;
	}
    public void setLargo(double largo) 
    {
		this.largo=largo;
	}
  
    public double getAncho()
    {
		return ancho;
	}
    public void setAncho(double ancho)
    {
		this.ancho=ancho;
	}
	
	public double getArea()
	{
		double area=0.0;
		
		area=getAncho()*getLargo();
		
		return area;
	}
	
	public double getPerimetro()
	{
		double perimetro=0.0;
		
		perimetro=(getAncho()+getLargo())*2;
		
		return perimetro;
	}
	
	/*
	//interfaz
	prototipo: public static double CalcularDiagonal()
	comentarios: este metodo calcula la diagonal de un rectangulo
	precondiciones: no hay
	entradas: no hay
	salidas: double resultado
	entr/sal: no hay
	postcondiciones: AN devolvera el resultado
	*/
	/*
	//resguardo
	public static double CalcularDiagonal()
	{
		System.out.println("En construccion");
		return 1.0;
	}*/
	
	public double CalcularDiagonal() //throws ExcepcionRectangulo
	{		
		double diagonal=0.;
		
		diagonal=Math.sqrt((Math.pow(getAncho(),2))+(Math.pow(getLargo(),2)));
		
		return diagonal;
	}
}

