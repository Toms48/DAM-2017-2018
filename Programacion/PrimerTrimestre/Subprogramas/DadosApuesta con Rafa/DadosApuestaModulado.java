/*Nombre: DadosApuestaV8347
 * 
 * Comentario: Empezando con un dinero inicial igual, la máquina y el jugador dicen
 * 			   el numero que creen que saldrá en la suma de sus dados,
 * 		       después hacen una apuesta cada uno y según los resultados se suman y restan las apuestas.
 * 
 * Análisis:
 * 		-Entra: un caracter para repetir, un numero que sea el dinero inicial,
 * 				un numero para la apuesta del jugador y un numero por el que se apuesta
 * 		-Salida: pinta por pantalla
 * 		-Requisitos: La respuesta tiene que ser 's' o 'n'
 * 					 El dinero inicial tiene que ser mayor que cero
 * 					 El numero de partidas tiene que ser mayor que cero
 * 					 La apuesta del Jugador no puede ser menor o igual que cero ni mayor que el dinero que tenga
 * 
 * 
 */

//PG:

//Inicio
	//Leer y validar respuesta para ejecutar
	//Mientras respuesta sea s
		//Leer y validar dinero inicial
		//Leer y validar numero de partidas
		
		//Para partidasRealizadas mientras partidasRealizadas sea menor que partidasAcordadas y dinero de los participantes no sea 0, incrementa partidasRealizadas en 1)
			//Generar numero elegido por el Pc
			//Leer numero elegido por el Jugador
			
			//Generar apuesta del Pc
			//Leer y validar apuesta del jugador
			
			//Generar y sumar los dados del Pc *
			//Generar y sumar los dados del Jugador *
			
			//Calcular diferencia con la apuesta Pc *
			//Calcular diferencia con la apuesta Jugador *
			
			//Mostrar ganador y actualizar dinero *
		//Fin_Para
		
	//Leer y validar respuesta para repetir
	//Fin_Mientras
//Fin

import java.util.Scanner;
import java.util.Random;

public class DadosApuestaModulado {
	
	public static void main (String[] args) {
		
		char respuesta = ' ';
		
		int dineroJugador = 0;
		int dineroPc = 0;
		
		int partidasTotales = 0;
		int partidasRealizadas = 0;
		
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
		
		Scanner teclado = new Scanner (System.in);

		Random random = new Random ();
		
		//Inicio
			//Leer y validar respuesta para ejecutar
			
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
				- Condición de salida: respuesta=='n'
			-----------------------------------*/
			
			while(respuesta=='s'){
				//Leer y validar dinero inicial
				
				/*--------------------------------------
					- Nombre: ValidacionDineroInicial
					- VCB: Centinela
					- Inicialización VCB: Lectura anticipada antes de la primera iteración
					- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
					- Condición de salida: dineroJugador>0
				--------------------------------------*/
				
				do{
					System.out.print("Introduzca su dinero inicial: ");
				
					dineroJugador = teclado.nextInt();
					
					dineroPc = dineroJugador;
				}
				while(dineroJugador <= 0);
				
				//Leer y validar numero de partidas
				
				/*--------------------------------------
					- Nombre: ValidacionNumeroPartidas
					- VCB: Centinela
					- Inicialización VCB: Antes de la primera iteración
					- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
					- Condición de salida: dineroJugador>0
				--------------------------------------*/
				
				do{
					System.out.print("Introduzca el numero de partidas para jugar: ");
					
					partidasTotales = teclado.nextInt();
				}
				while(partidasTotales <= 0);
				
				/*-----------------------------------
					- Nombre: BucleContadorPartidas
					- VCB: Contador
					- Inicialización VCB: Antes de la primera iteración
					- Actualización VBC: Al final del bucle, antes de la siguiente iteración
					- Condición de salida: partidasRealizadas >= partidasTotales o dineroJugador==0 o dineroJugadPc==0
				-----------------------------------*/
				
				for(partidasRealizadas=0; partidasRealizadas < partidasTotales && dineroJugador !=0 && dineroPc !=0; partidasRealizadas++){
					
					//Generar numero elegido por el Pc
					
					//Leer numero elegido por el Jugador
					System.out.println();
					System.out.print("Elija el numero que cree que saldra en los dados: ");
				
					numeroElegidoJugador = teclado.nextInt();
			
					//Generar apuesta del Pc
				
					//Leer y validar apuesta del jugador
					
					/*--------------------------------------
						- Nombre: ValidacionApuestaJugador
						- VCB: Centinela
						- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
						- Actualización VBC: Antes de la siguiente iteración
						- Condición de salida: apuestaJugador > 0 && apuestaJugador <= dineroJugador
					--------------------------------------*/
					
					do{
						System.out.print("Introduzca su apuesta: ");
					
						apuestaJugador = teclado.nextInt();
					
						System.out.println();
					}
					while(apuestaJugador <= 0 || apuestaJugador > dineroJugador);
								
					//Generar y sumar los dados del Pc
				
					//Generar y sumar los dados del Jugador
					
					//Calcular diferencia con la apuesta Pc
				
					//Calcular diferencia con la apuesta Jugador
					
					//Mostrar ganador y actualizar dinero
				
				}//Fin_Para
		
				//Leer y validar respuesta para repetir
				
				/*-----------------------------------
					- Nombre: ValidacionRespuesta2
					- VCB: Centinela
					- Inicialización VCB: Lectura anticipada por teclado antes de la primera iteración
					- Actualización VBC: Fisicamente al final del bucle, antes de la siguiente iteración
					- Condición de salida: respuesta=='s' o respuesta=='n'
				-----------------------------------*/
				
				do{
					System.out.println();
					System.out.print("Quiere volver a jugan otra partida? (s/n): ");
				
					respuesta = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(respuesta !='s' && respuesta !='n');
				
			}//Fin_Mientras
		//Fin
		
	}
}
