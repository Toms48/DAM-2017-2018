/*
 * Nombre: DadosApuesta
 * 
 * Comentario: Se escoge un numero entre 2 y 12, se apuesta una cantidad de dinero y se comparan los resultados
 * 
 * Análisis:
 * 		-Entra:
 * 		-Salida:
 * 
 * PG:
 * 		Inicio
 * 			Hacer
 * 				Escoger dinero incial
 * 
 * 				Generar numero aleatorio para la opcion del Pc
 * 				Escoger un numero (Opcion del Jugador)
 * 
 * 				Apuesta Pc
 * 				Apuesta Jugador
 * 
 * 				Generar aleatorioPc1 (dado 1)
 * 				Generar aleatorioPc2 (dado 2)
 * 				Sumar aleatorios de Pc (sumaDadosPc)
 * 
 * 				Generar aleatorioJugador1 (dado 1)
 * 				Generar aleatorioJugador2 (dado 2)
 * 				Sumar aleatorios de Jugador (sumaDadosJugador)
 * 
 * 				Resta opcionPc menos sumaDadosPc
 * 				Si restaPc < 0
 * 					restaPc * -1
 * 				Fin_Si
 * 
 * 				Resta opcionJugador menos sumaDadosJugador
 * 				Si restaJugador < 0
 * 					restaJugador * -1
 * 				Fin_Si
 * 
 * 				Si restaPc y restaJugador es igual
 * 					Empate
 * 				Fin_Si
 * 
 * 				Sino
 * 
 * 					Si restaPc > restaJugador (Gana Jugador)
 * 						Al jugador se le suma la apuesta
 * 						Al Pc se le resta la apuesta
 * 					Fin_Si
 * 
 * 					Sino (Gana Pc)
 * 						Al jugador se le resta la apuesta
 * 						Al Pc se le suma la apuesta
 * 					Fin_Sino
 * 
 * 				Fin_Sino
 * 
 * 				Preguntar para repetir
 * 
 * 			Mientras DineroJugador no sea 0 o DineroPc no sea 0 y se quiera jugar otra vez (repetir)
 * 		Fin
 * 
 */

import java.util.*;

public class DadosApuesta {
	
	public static void main (String[] args) {
		
		//Declaraciones
		int dineroJugador = 0;
		int dineroPc = dineroJugador;
		
		int opcionPc = 0;
		int opcionJugador = 0;
		
		//Inicializaciones
		Scanner teclado = new Scanner (System.in);
		
		Random random = new Random ();
		
		//Inicio
			//Hacer
			do{
				//Escoger dinero incial
				System.out.print("Introduzca su dinero inicial: ");
				
				dineroJugador = teclado.nextInt();
				
				//Generar numero aleatorio para la opcion del Pc
				opcionPc = random.nextInt(10) +2;
				
				//Escoger un numero (Opcion del Jugador)
				System.out.print("Elija el numero que cree que saldrá en los dados: ");
				
				opcionJugador = teclado.nextInt();
				
				//Apuesta Pc
				apuestaPc = random.nextInt(dineroPc) +1;
				
				System.out.print("La puesta del Pc es: " +apuestaPc);
				
				//Apuesta Jugador
				
				//Generar aleatorioPc1 (dado 1)
				//Generar aleatorioPc2 (dado 2)
				//Sumar aleatorios de Pc (sumaDadosPc)
				
				//Generar aleatorioJugador1 (dado 1)
				//Generar aleatorioJugador2 (dado 2)
				//Sumar aleatorios de Jugador (sumaDadosJugador)
				
				//Resta opcionPc menos sumaDadosPc
				//Si restaPc < 0
					//restaPc * -1
				//Fin_Si
				
				//Resta opcionJugador menos sumaDadosJugador
				//Si restaJugador < 0
					//restaJugador * -1
				//Fin_Si
				
				//Si restaPc y restaJugador es igual
					//Empate
				//Fin_Si
				
				//Sino
					//Si restaPc > restaJugador (Gana Jugador)
						//Al jugador se le suma la apuesta
						//Al Pc se le resta la apuesta
					//Fin_Si
					
					//Sino (Gana Pc)
						//Al jugador se le resta la apuesta
						//Al Pc se le suma la apuesta
					//Fin_Sino
					
				//Fin_Sino
				
				//Preguntar para repetir
			}

			//Mientras DineroJugador no sea 0 o DineroPc no sea 0 y se quiera jugar otra vez (repetir)
			while();
		//Fin
		
	}
}

