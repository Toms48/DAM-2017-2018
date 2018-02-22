public class TestCasilla {
	
	public static void main (String[] args) {
		
		//Tests constructores
		System.out.println(" ");
		System.out.println("*----------- Constructores -----------*");
		System.out.println(" ");
		
		//Constructor por defecto
		casilla casillaPorDefecto = new casilla();
		
		//Constructor con parámetros
		casilla casilla1 = new casilla(true, false, 0);
		
		//Constructor copia
		casilla casilla1Copia = new casilla(casilla1);
		
		//Tests constructores
		System.out.println(" ");
		System.out.println("*----------- Gets -----------*");
		System.out.println(" ");
		
		System.out.println("Hay mina en PorDefecto: " +casillaPorDefecto.getMina());
		System.out.println("Hay bandera en PorDefecto: " +casillaPorDefecto.getBandera());
		System.out.println("Numero: " +casillaPorDefecto.getNumero());
		
		System.out.println(" ");
		
		System.out.println("Hay mina en 1: " +casilla1.getMina());
		System.out.println("Hay bandera en 1: " +casilla1.getBandera());
		System.out.println("Numero de la casilla 1: " +casilla1.getNumero());
		
		//Tests constructores
		System.out.println(" ");
		System.out.println("*----------- Sets -----------*");
		System.out.println(" ");
		
		try{
			casilla1.setNumero(1);
			System.out.println("Nuevo numero de casilla1: " +casilla1.getNumero());
		}
		catch(ExcepcionCasilla mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		try{
			casillaPorDefecto.setNumero(-1);
			System.out.println("Nuevo numero de casilla1: " +casilla1.getNumero());
		}
		catch(ExcepcionCasilla mensaje){
			System.out.println(mensaje);
		}
		
		//Tests toString
		System.out.println(" ");
		System.out.println("*----------- toString -----------*");
		System.out.println(" ");
		
		System.out.println(casillaPorDefecto.toString());
		System.out.println(" ");
		System.out.println(casilla1.toString());
		System.out.println(" ");
		System.out.println(casilla1Copia.toString());
		
		//Tests Clone
		System.out.println(" ");
		System.out.println("*----------- Clone -----------*");
		System.out.println(" ");
		
		System.out.println(casilla1.clone());
		
		//Tests Equals
		System.out.println(" ");
		System.out.println("*----------- Equals -----------*");
		System.out.println(" ");
		
		System.out.println(casilla1.equals(casilla1Copia));
		
	}
}

