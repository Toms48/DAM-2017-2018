/*  Nombre: PiedraPapelTijera
 * 
 *  Análisis:
 * 		El clásico juego de piedra, papel o tijera, llevará una cuenta de las partidas ganadas y perdidas de la maquina
 * 		y del jugador, así como los empates, podremos elejir el numero de partidas a jugar.
 * 			(EN OTRA VERSION ESTARA QUE SOLO PUEDAS ELEGIR UNA CANTIDAD IMPAR DE PARTIDAS)
 * 
 * 		-Entradas: Opcion de para jugar, opcion para salir, opcion para repetir (el juego), opcionUsuario
 * 		-Salidas: Imprimimos por pantalla
 * 
 * 	PG:
 * 		Inicio
 * 			Hacer
 * 				MostrarMenu
 * 				LeerOpcionMenu
 * 			Mientras OpcionMenu sea 0, 1 o 2
 * 
 * 			Si OpcionMenu es 1
 * 				Hacer
 * 					PreguntarPartidas
 * 				Mientras NumeroPartidas=<0
 * 				Hacer
 * 					Hacer
 * 						MostrarMenuPPT
 * 						LeerOpcionJugador
 * 					Mientras OpcionJugador no sea 1, 2 o 3
 * 
 * 					GenerarAleatorio
 * 
 * 					Si OpcionJugador es igual a OpcionPc
 * 						ContadorEmpate aumenta
 * 						PartidasJugadas aumenta
 * 					Fin_Si
 * 
 * 					Sino
 * 						Si OpcionJugador==1 y OpcionPc==2 o OpcionJugador==2 y OpcionPc==3 o OpcionJugador==3 y OpcionPc==1
 * 							ContadorGanarPc aumenta
 * 							ContadorPerderJugador aumenta (Esto no se lo meteré al final)
 * 							PartidasJugadas aumenta
 * 						Fin_Si
 * 						
 * 						Sino
 * 							ContadorGanarJugador aumenta
 * 							ContadorPerderPc aumenta (Esto no se lo meteré al final)
 * 							PartidasJugadas aumenta
 * 						Fin_Sino
 * 					Fin_Sino
 * 				Mientras PartidasJugadas != NumeroPartidas
 * 			Fin_Si
 * 		Fin 
 * 
 */

import java.util.*;

public class PiedraPapelTijera {
	
	public static void main (String[] args) {
		
		char repetirMenu = ' ';	
		
		int opcionMenu = 0;	
		int numeroPartidas = 0;
		
		Scanner teclado = new Scanner (System.in);
		Random random = new Random ();
		
		//Inicio
			//Hacer
			do{
				//Hacer
				do{
					//MostrarMenu
					System.out.println("Bienvenido!");
					System.out.println("[1] Clasico");
					System.out.println("[2] Ampliado");
					System.out.println("[0] Salir");
					System.out.print("Su opcion es: ");
					
					//Leer OpcionMenu
					opcionMenu = teclado.nextInt();
				}
				//Mientras OpcionMenu no sea 0, 1 o 2
				while(opcionMenu!=0 && opcionMenu!=1 && opcionMenu!=2);
				
				//Según OpcionMenu mostrar clásico, Ampliado o Salir
				switch(opcionMenu){
					
					case 0: //Salir del menu
					break;
					
					case 1: //Clásico
						System.out.println(" ");
						System.out.println("Soy el piedra, papel o tijera clasico! (pero WIP)");
						
						//Hacer
							//Preguntar numero de partidas
							System.out.println("Cuantas partidas quiere hacer?");
							System.out.print("Numero de partidas a jugar: ");
							
							numeroPartidas = teclado.nextInt();
							
						//Mientras numeroPartidas sea menor o igual que 0
						while( numeroPartidas <= 0);
						
						//Generar opcionPc aleatoriamente
						
					break;
					
					case 2: //Ampliado
					System.out.println(" ");
						System.out.println("Soy el piedra, papel, tijera, lagarto o Spock! (pero WIP)");
					break;
				}
				//Fin_Según
				
				//Si opcionMenu es 1 o 2
				if(opcionMenu==1 || opcionMenu==2){
					//Preguntar para volver a mostrar el menu
					System.out.println(" ");
					System.out.println("Quiere volver al menu principal? (s/n): ");
					
					repetirMenu = Character.toLowerCase(teclado.next().charAt(0));
				}
				//Fin_Si	
				
				//Sino
				else{
					repetirMenu = 'n';
				}
				
				
			}
			//Mientras respuestaRepetir sea si
			while(repetirMenu=='s');
			
			System.out.println("Hasta luego!");
			
		//Fin
	
	}

}

