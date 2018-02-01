/*
 * 
 * 
 */

import java.util.Random;
import java.util.ArrayList;

public class fHombresLobo {
	
/**************************************************************************	
Interfaz
	Comentario: Subprograma que simulará el juego de los hombres lobos
	Cabecera: void JugarHombresLobo()
	Precondiciones: cantidadHL es mayor que cantidadCamp
	Entrada: No hay
	Salida: No hay
	E/S: No hay
	Postcondiciones: No tiene
**************************************************************************/	
	
	public static int JugarHombresLobo(){
		
		int cantidadHL = 1;
		int cantidadCamp = 5;
		
		int aleatorio = 0;
		
		ArrayList array6Cartas = new ArrayList(6);
		ArrayList array6CartasCopia = new ArrayList(6);
		Carta [] arrayTablero = new Carta [6];
		
		Carta espada1 = new Carta(2,1);
		
		Carta bastos1 = new Carta(4,1);
		Carta bastos2 = new Carta(4,2);
		Carta bastos3 = new Carta(4,3);
		Carta bastos4 = new Carta(4,4);
		Carta bastos5 = new Carta(4,5);
		
		array6Cartas.add(0,espada1);
		
		array6Cartas.add(1,bastos1);
		array6Cartas.add(2,bastos2);
		array6Cartas.add(3,bastos3);
		array6Cartas.add(4,bastos4);
		array6Cartas.add(5,bastos5);
		
		array6CartasCopia = array6Cartas.clone();
		
		Random random = new Random();
		
		//Inicio
			//RepartirPersonajes
			
			
			while(cantidadHL > cantidadCamp){
				//Noche*
				//Día*
			}//Fin_Mientras
		//Fin
		
		return 1;
	}
}

