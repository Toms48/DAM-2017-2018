/**Nombre: TestRectangulo
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class TestRectangulo 
{
	public static void main(String[] args) //throws ExcepcionRectangulo
	{
		try
		{
			Rectangulo r1=new Rectangulo(4.0,7.0);
			//Rectangulo r1=new Rectangulo(-10,20);
			//Rectangulo r1=new Rectangulo(10,-20);
			
			System.out.println("Antes del cambio: "+r1.getLargo()+" "+r1.getAncho());
			
			//prueba getters y setters
			System.out.println("---------------------------------------------------");
			System.out.println("Get y set de Largo:");
			//r1.setLargo(3);
			r1.setLargo(-3);
			System.out.println(r1.getLargo());
			
			System.out.println("---------------------------------------------------");
			System.out.println("Get y set de Ancho:");
			r1.setAncho(8);
			//r1.setAncho(-8);
			System.out.println(r1.getAncho());
			//fin
			
			System.out.println("---------------------------------------------------");
			System.out.println("Despues del cambio: "+r1.getLargo()+" "+r1.getAncho());
			
			//prueba de area
			System.out.println("---------------------------------------------------");
			System.out.println("Area:");
			System.out.println(r1.getArea());
			//fin prueba area
			
			//prueba de parametro
			System.out.println("---------------------------------------------------");
			System.out.println("Perimetro:");
			System.out.println(r1.getPerimetro());
			//fin prueba parametro
			
			//prueba de calcular diagonal
			System.out.println("---------------------------------------------------");
			System.out.println("Diagonal:");
			System.out.println(r1.CalcularDiagonal());
			//fin prueba alcular diagonal
			
		}catch(ExcepcionRectangulo error)
		{
			System.out.println("No  ha sido posible completar la operacion");
		}
		
		System.out.println("No pasa nada porque el programa sigue");
	}
}
