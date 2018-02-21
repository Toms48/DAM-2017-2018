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
		
		//casilla1.set
		
	}
}

