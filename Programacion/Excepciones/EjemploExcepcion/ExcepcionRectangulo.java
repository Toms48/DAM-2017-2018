/*public class ExcepcionRectangulo extends Exception
{
	public ExcepcionRectangulo (String error) 
	{
		super(error);
	}
}*/

public class ExcepcionRectangulo extends Exception
{
	public ExcepcionRectangulo(String mensaje)
	{	
		System.out.println(mensaje);
	}

}
