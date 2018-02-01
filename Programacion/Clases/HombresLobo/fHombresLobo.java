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
	Precondiciones: No tiene
	Entrada: No hay
	Salida: No hay
	E/S: No hay
	Postcondiciones: No tiene
**************************************************************************/	
	
	public static int JugarHombresLobo(){
		
		int cantidadHL = 1;
		int cantidadCamp = 5;
		
		int aleatorio = 0;
		
		boolean salirArray = false;
		
		ArrayList <Carta> array6Cartas = new ArrayList <Carta> (6);			//<Carta> para que no te de un warning, se le tiene que especificar el tipo de los objetos que vas a usar
		ArrayList <Carta> arrayTablero = new ArrayList <Carta> (6);
		
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
		
		Random random = new Random();
		
		//Inicio
			//RepartirPersonajes
			do{
				if(array6Cartas.size() > 1){
					
					aleatorio = random.nextInt(array6Cartas.size()-1);
				
					arrayTablero.add(array6Cartas.get(aleatorio));
				
					array6Cartas.remove(aleatorio);
					
				}
				else{
				
					arrayTablero.add(array6Cartas.get(0));
					
					salirArray = true;
				}
				
				System.out.println(array6Cartas.size());	//Para comprobar que el tamaño del array va reduciendose
			}
			while(salirArray == false);
			
			//ImprimirCartaJugador
			System.out.println(arrayTablero.get(0).toString());
			//System.out.println(arrayTablero.get(0).equals(espada1));		//Para ver si el equals es true cuando al jugador le sale la carta de espada
			
			while(cantidadHL > cantidadCamp){
				if(arrayTablero.get(0).equals(espada1) == true){
					//Noche*
				}
				else{
					
				}
				
				//Día*
			}//Fin_Mientras
		//Fin
		
		return 1;
	}
	
	public static int Noche(){
		
		//Inicio
			//Hacer 
				//Generar victima aleatoria
				//Confirmar victima
			//Mientras matar no sea s
		//Fin
		return 1;
	}
	
}

