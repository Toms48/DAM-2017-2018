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
 * 
 * PG:
 * 
 * 		Inicio
 * 			Leer y validar para ejecutar
 * 			Mientras el jugador quiera seguir 
 * 				Escoger dinero incial
 * 				
 * 				Generar numero elegido por el Pc
 * 				Leer numero elegido por el Jugador
 * 				
 * 				Generar apuesta del Pc
 * 				Leer apuesta del jugador
 * 				
 * 				Generar y sumar los dados del Pc
 * 				Generar y sumar los dados del Jugador
 * 				
 * 				Calcular diferencia con la apuesta Pc
 * 				Calcular diferencia con la apuesta Jugador
 * 				
 * 				Mostrar ganador y actualizar dinero
 * 
 * 				Leer y validar para repetir
 *			Fin_Mientras
 * 		Fin
 */
 
//Inicio
	//Leer y validar respuesta
	//Mientras
//Fin

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
			//Leer y validar para ejecutar
			
			/*-----------------------------------
				- Nombre: ValidacionRespuesta1
				- VCB: Centinela
				- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
				- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
				- Condición de salida: respuesta=='s' o respuesta=='n'
			-----------------------------------*/
			
			do{
				System.out.print("Quiere ejecutar el programa? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta !='s' && respuesta !='n');
			
			/*-----------------------------------
				- Nombre: BucleEjecutarPrograma
				- VCB: Centinela
				- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
				- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
				- Condición de salida: dineroJugador==0 o dineroJugadPc==0 o respuesta=='n'
			-----------------------------------*/
			
			while(dineroJugador!=0 && dineroPc!=0 && respuesta!='n'){
				//Escoger dinero incial
				
				/*-----------------------------------
					- Nombre: ValidacionDineroInicial
					- VCB: Centinela
					- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
					- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
					- Condición de salida: dineroJugador>0
				-----------------------------------*/
				
				do{
					System.out.print("Introduzca su dinero inicial: ");
				
					dineroJugador = teclado.nextInt();
				
					dineroPc = dineroJugador;
				}
				while(dineroJugador <= 0);
				
				//Generar numero elegido por el Pc
				numeroElegidoPc = random.nextInt(10) +2;
				
				//Leer numero elegido por el Jugador
				System.out.println();
				System.out.print("Elija el numero que cree que saldra en los dados: ");
				
				numeroElegidoJugador = teclado.nextInt();
				
				//Generar apuesta del Pc
				apuestaPc = random.nextInt(dineroPc) +1;
				
				System.out.println();
				System.out.println("La puesta del Pc es: " +apuestaPc);
				
				//Leer apuesta del jugador
				
				/*-----------------------------------
					- Nombre: ValidacionApuestaJugador
					- VCB: Centinela
					- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
					- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
					- Condición de salida: apuestaJugador<=dineroJugador
				-----------------------------------*/
				
				do{
					System.out.print("Introduzca su apuesta: ");
					
					apuestaJugador = teclado.nextInt();
					
					System.out.println();
				}
				while(apuestaJugador > dineroJugador);
				
				//Generar y sumar los dados del Pc
				aleatorioPc1 = random.nextInt(6) +1; //Generar dado 1 del pc
				System.out.println("Dado 1 del Pc: " +aleatorioPc1);
				
				
				aleatorioPc2 = random.nextInt(6) +1; //Generar dado 2 del pc
				System.out.println("Dado 2 del Pc: " +aleatorioPc2);
				
				
				sumaDadosPc = aleatorioPc1 + aleatorioPc2; //Sumar dados del pc
				System.out.println("Suma de los dados: " +sumaDadosPc);
				
				//Generar y sumar los dados del Jugador
				aleatorioJugador1 = random.nextInt(6) +1; //Generar dado 1 del Jugador
				System.out.println();
				System.out.println("Dado 1 del Jugador: " +aleatorioJugador1);
				
				aleatorioJugador2 = random.nextInt(6) +1; //Generar dado 2 del Jugador
				System.out.println("Dado 2 del Jugador: " +aleatorioJugador2);
				
				sumaDadosJugador = aleatorioJugador1 + aleatorioJugador2; //Sumar dados del Jugador
				System.out.println("Suma de los dados: " +sumaDadosJugador);
				System.out.println();
				
				//Calcular diferencia con la apuesta Pc
				restaPc = numeroElegidoPc - sumaDadosPc;
				
				if(restaPc < 0){
					restaPc = restaPc * -1;
				}
				
				System.out.println("RestaPc: " +restaPc);
				System.out.println();
				
				//Calcular diferencia con la apuesta Jugador
				restaJugador = numeroElegidoJugador - sumaDadosJugador;
				
				if(restaJugador < 0){
					restaJugador = restaJugador * -1;
				}
				
				System.out.println("RestaJugador: " +restaJugador);
				
				//Mostrar ganador y actualizar dinero
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
						
						dineroJugador = dineroJugador + apuestaJugador; //Al jugador se le suma la apuesta
						
						System.out.println();
						System.out.println("El Jugador gana " +apuestaJugador +" y se queda con un total de " +dineroJugador);
						System.out.println();
						
						dineroPc = dineroPc - apuestaPc; //Al Pc se le resta la apuesta
						
						System.out.println("El Pc pierde " +apuestaPc +" y se queda con un total de " +dineroPc);
					}
					
					else{
						System.out.println();
						System.out.println("#-------------#");
						System.out.println("| GANA EL PC! |");
						System.out.println("#-------------#");
						
						dineroJugador = dineroJugador - apuestaJugador; //Al jugador se le resta la apuesta
						
						System.out.println();
						System.out.println("El Jugador pierde " +apuestaJugador +" y se queda con un total de " +dineroJugador);
						System.out.println();
						
						dineroPc = dineroPc + apuestaPc; //Al Pc se le suma la apuesta
						
						System.out.println("El Pc gana " +apuestaPc +" y se queda con un total de " +dineroPc);
					}
				}
				
				//Leer y validar para ejecutar otra vez
				
				/*-----------------------------------
					- Nombre: ValidacionRespuesta2
					- VCB: Centinela
					- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
					- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
					- Condición de salida: respuesta=='s' o respuesta=='n'
				-----------------------------------*/
				
				do{
					System.out.println();
					System.out.print("Quiere seguir jugando? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(respuesta !='s' && respuesta !='n');
				
			} //Fin_Mientras
		//Fin
	}
}












//numero de partidas
//condicion del while, cuidado con el dinero
//revisar el while

