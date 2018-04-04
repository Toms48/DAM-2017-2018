package Resguardos;/*
 * 
 * 
 */


public class rHombresLobo {
	
/**************************************************************************	
Interfaz
	Comentario: Subprograma que simulará el juego de los hombres lobos
	Cabecera: int JugarHombresLobo()
	Precondiciones: No hay
	Entrada: No hay
	Salida: numero
	E/S: No hay
	Postcondiciones: Devolverá un número para saber que funciona
**************************************************************************/	
	
	public static int JugarHombresLobo(){
		
		System.out.println("En resguardo");
		
		System.out.println(" ");
		
		System.out.println("Noche del Jugador Lobo");
		NocheJL();
		
		System.out.println(" ");
		
		System.out.println("Dia del Jugador Lobo");
		DiaJL();
		
		return 1;
	}
	
/**************************************************************************	
Interfaz
	Comentario: Simulará la noche cuando el jugador sea el lobo (espada1)
	Cabecera: int NocheJL()
	Precondiciones: No tiene
	Entrada: No tiene
	Salida: Un número
	E/S: No tiene
	Postcondiciones: se devolverá un 1 cuando la clase funcione correctamente
**************************************************************************/	
	
	public static int NocheJL(){
		
		System.out.println("En resguardo");
		
		return 1;
	}

/**************************************************************************	
Interfaz
	Comentario: Simulará el día cuando el jugador sea el lobo (espada1)
	Cabecera: ArrayList<Carta> DiaJL(ArrayList <Carta> array)
	Precondiciones: ?
	Entrada: No tiene
	Salida: No tiene
	E/S: Un ArrayList<Carta>
	Postcondiciones: el array tendrá el tamaño de entrada - 1
**************************************************************************/

	public static int DiaJL(){
		
		System.out.println("En resguardo");
		
		return 1;
	}
	
}

