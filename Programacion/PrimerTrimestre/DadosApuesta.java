/*
 * Nombre: DadosApuesta
 * 
 * Comentario: Empezando con un dinero inicial igual, la máquina y el jugador dicen
 * 			   el numero que creen que saldrá en la suma de sus dados,
 * 		       después hacen una apuesta cada uno y según los resultados se suman y restan las apuestas.
 * 
 * Análisis:
 * 		-Entra: un caracter para repetir, un numero que sea el dinero inicial,
 * 				un numero para la apuesta del jugador y un numero por el que se apuesta
 * 		-Salida: pinta por pantalla
 * 
 * Estudio de los bucles:
 * -----------------------------------
 * 		- Nombre: ValidacionRespuesta
 * 		- VCB:
 * 		- Inicialización VCB:
 * 		- Actualización VBC:
 * 		- Condición de salida:
 * -----------------------------------
 * 
 * -----------------------------------
 * 		- Nombre: BucleEjecutarPrograma
 * 		- VCB:
 * 		- Inicialización VCB:
 * 		- Actualización VBC:
 * 		- Condición de salida:
 * -----------------------------------
 * 
 * PG Nivel-0:
 * 
 * 		Inicio
 * 			Preguntar, leer y validar para ejecutar
 * 			Mientras el jugador quiera seguir y el dinero del jugador y de la maquina no sea 0 //dineroJugador!=0 y dineroPc!=0 y respuesta!='n'
 * 				Escoger dinero incial
 * 				
 * 				Generar
 * 				leer numeros elegidos
 * 
 * 				GenerarApuestaPcLeerApuestaJugador
 * 				
 * 				GenerarSumarDadosPcYJugador
 * 				
 * 				Calcular diferencias con el numero apostado
 * 				
 * 				Mostrar ganador y actualizar dinero
 * 
 * 				Preguntar, leer y validar para repetir
 *			Fin_Mientras
 * 		Fin
 * 
 * 
 * PG Nivel-1:
 * 
 * 		Inicio
 * 			Mientras el jugador quiera seguir y el dinero del jugador y de la maquina no sea 0
 * 				Escoger dinero incial
 * 				
 * 				Generar y leer numeros elegidos
 * 					Generar numero aleatorio para el numero a postado por el Pc
 * 					Escoger un numero (numeroApostadoJugador)
 * 
 * 				GenerarApuestaPcLeerApuestaJugador
 * 					Generar apuesta Pc
 * 					Leer apuesta Jugador
 * 
 * 				GenerarSumarDadosPcYJugador
 * 					GenerarSumarDadosPc
 * 					GenerarSumarDadosJugador
 * 
 * 				Calcular diferencias con el numero apostado
 * 					Resta numeroApostadoPc menos sumaDadosPc
 * 						Si restaPc es menor que 0
 * 							restaPc por -1
 * 						Fin_Si
 * 
 * 					Resta numeroApostadoJugador menos sumaDadosJugador
 * 						Si restaJugador es menor que 0
 * 							restaJugador por -1
 * 						Fin_Si
 * 
 * 				Mostrar ganador y actualizar dinero
 * 					Si restaPc y restaJugador es igual
 * 						Empate
 * 					Sino
 * 						Si restaPc es mayor que restaJugador (Gana Jugador)
 * 							Al jugador se le suma la apuesta
 * 							Al Pc se le resta la apuesta
 * 						Sino (Gana Pc)
 * 							Al jugador se le resta la apuesta
 * 							Al Pc se le suma la apuesta
 * 					Fin_Si
 * 
 * 			Fin_Mientras
 * 		Fin
 */

import java.util.*;

public class DadosApuesta {
	
	public static void main (String[] args) {
		
		//Declaraciones
		char respuesta = ' ';
		
		int dineroJugador = 0;
		int dineroPc = 0;
		
		int numeroElegidoPc = 0;
		int numeroElegidoJugador = 0;
		
		int apuestaPc = 0;
		int apuestaJugador = 0;
		
		int sumaDadosPc = 0;
		int sumaDadosJugador = 0;
		
		int aleatorioPc1 = 0;
		int aleatorioPc2 = 0;
		int aleatorioJugador1 = 0;
		int aleatorioJugador2 = 0;
		
		int restaPc = 0;
		int restaJugador = 0;
		
		//Inicializaciones
		Scanner teclado = new Scanner (System.in);

		Random random = new Random ();
		
		//Inicio
		
			//Preguntar, leer y validar dinero incial
			do{
				System.out.print("Introduzca su dinero inicial: ");
				
				dineroJugador = teclado.nextInt();
				
				dineroPc = dineroJugador;
			}
			while(dineroJugador <= 0);
				
			do{
				//Generar numero aleatorio para la opcion del Pc
				opcionPc = random.nextInt(10) +2;
				
				//Escoger un numero (Opcion del Jugador)
				System.out.println();
				System.out.print("Elija el numero que cree que saldra en los dados: ");
				
				opcionJugador = teclado.nextInt();
				
				//Apuesta Pc
				apuestaPc = random.nextInt(dineroPc) +1;
				
				System.out.println();
				System.out.println("La puesta del Pc es: " +apuestaPc);
				
				//Apuesta Jugador
				do{
					System.out.print("Introduzca su apuesta: ");
					
					apuestaJugador = teclado.nextInt();
					
					System.out.println();
				}
				
				while(apuestaJugador > dineroJugador);
				
				//Generar aleatorioPc1 (dado 1)
				aleatorioPc1 = random.nextInt(6) +1;
				System.out.println("Dado 1 del Pc: " +aleatorioPc1);
				
				//Generar aleatorioPc2 (dado 2)
				aleatorioPc2 = random.nextInt(6) +1;
				System.out.println("Dado 2 del Pc: " +aleatorioPc2);
				
				//Sumar aleatorios de Pc (sumaDadosPc)
				sumaDadosPc = aleatorioPc1 + aleatorioPc2;
				System.out.println("Suma de los dados: " +sumaDadosPc);
				
				//Generar aleatorioJugador1 (dado 1)
				aleatorioJugador1 = random.nextInt(6) +1;
				System.out.println();
				System.out.println("Dado 1 del Jugador: " +aleatorioJugador1);
				
				//Generar aleatorioJugador2 (dado 2)
				aleatorioJugador2 = random.nextInt(6) +1;
				System.out.println("Dado 2 del Jugador: " +aleatorioJugador2);
				
				//Sumar aleatorios de Jugador (sumaDadosJugador)
				sumaDadosJugador = aleatorioJugador1 + aleatorioJugador2;
				System.out.println("Suma de los dados: " +sumaDadosJugador);
				System.out.println();
				
				//Resta opcionPc menos sumaDadosPc
				restaPc = opcionPc - sumaDadosPc;
				
				if(restaPc < 0){
					restaPc = restaPc * -1;
				}
				
				System.out.println("RestaPc: " +restaPc);
				System.out.println();
				
				//Resta opcionJugador menos sumaDadosJugador
				restaJugador = opcionJugador - sumaDadosJugador;
				
				if(restaJugador < 0){
					restaJugador = restaJugador * -1;
				}
				
				System.out.println("RestaJugador: " +restaJugador);
				
				if(restaPc == restaJugador){
					System.out.println();
					System.out.println("#-----------------------------#");
					System.out.println("|           EMPATE!           |");
					System.out.println("| (nadie gana ni pierde nada) |");
					System.out.println("#-----------------------------#");
				}
				
				else{
					if(restaPc > restaJugador){
						System.out.println();
						System.out.println("#------------------#");
						System.out.println("| GANA EL JUGADOR! |");
						System.out.println("#------------------#");
						
						//Al jugador se le suma la apuesta
						dineroJugador = dineroJugador + apuestaJugador;
						
						System.out.println();
						System.out.println("El Jugador gana " +apuestaJugador +" y se queda con un total de " +dineroJugador);
						System.out.println();
						
						//Al Pc se le resta la apuesta
						dineroPc = dineroPc - apuestaPc;
						
						System.out.println("El Pc pierde " +apuestaPc +" y se queda con un total de " +dineroPc);
					}
					
					else{
						System.out.println();
						System.out.println("#-------------#");
						System.out.println("| GANA EL PC! |");
						System.out.println("#-------------#");
						
						//Al jugador se le resta la apuesta
						dineroJugador = dineroJugador - apuestaJugador;
						
						System.out.println();
						System.out.println("El Jugador pierde " +apuestaJugador +" y se queda con un total de " +dineroJugador);
						System.out.println();
						
						//Al Pc se le suma la apuesta
						dineroPc = dineroPc + apuestaPc;
						
						System.out.println("El Pc gana " +apuestaPc +" y se queda con un total de " +dineroPc);
					}	
				}
				
				//Preguntar, leer y validar para repetir
				do{
					System.out.println();
					System.out.print("Quiere seguir jugando? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(respuesta !='s' && respuesta !='n');
				
			}
			
			while((dineroJugador != 0 || dineroPc != 0) && respuesta == 's'); //Mientras DineroJugador no sea 0 o DineroPc no sea 0 y se quiera jugar otra vez (repetir)
		//Fin
		
	}
}

