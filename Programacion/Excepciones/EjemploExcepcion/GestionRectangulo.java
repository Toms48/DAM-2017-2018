/** Nombre de la clase: GestionRectangulo
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class GestionRectangulo
{
	/*
	public static double AreaRectangulo(double largo, double ancho) throws ExcepcionRectangulo
	{
		//Rectangulo r=new Rectangulo(5,10);
		Rectangulo r=new Rectangulo(-5,10);
		//Rectangulo r=new Rectangulo(5,-10);
		double area;
		
		area=r.getAncho()*r.getLargo();
		
		return area;
	}*/
	
	public static double PerimetroRectangulo(double largo, double ancho) throws ExcepcionRectangulo
	{
		double perimetro=0.0;
		//Rectangulo r=new Rectangulo(5,10);
		Rectangulo r=new Rectangulo(-5,10);
		//Rectangulo r=new Rectangulo(5,-10);
		
		if(largo<1)
		{
			throw new ExcepcionRectangulo("El largo tiene que ser mayor de cero");
		}
		else if(ancho<1)
		{
			throw new ExcepcionRectangulo("El ancho tiene que ser mayor de cero");
		}else
		{
			perimetro=(r.getAncho()+r.getLargo())*2;
		}
		
		return perimetro;
	}
	
	public static void main (String [] args) //throws ExcepcionRectangulo
	{
		double ancho=5;
		double largo=10;
		
		try
		{
			//System.out.println("Area= "+AreaRectangulo(largo,ancho));
			System.out.println("Perimetro= "+PerimetroRectangulo(largo,ancho));
		}
		catch(ExcepcionRectangulo error)
		{
			if(ancho<1)
			{
				System.out.println("El ancho tiene que ser mayor de cero");
				//error.printStackTrace();
			}
		}
		catch(Exception err)
		{
			if(largo<1)
			{
				System.out.println("El largo tiene que ser mayor de cero");
				//err.printStackTrace();
			}
		}
		
		System.out.println("No te preocupes. El programa sigue");
	}
}

