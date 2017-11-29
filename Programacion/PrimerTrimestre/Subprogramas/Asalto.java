/*
Nombre: Asalto

Comentraio: Simulará un asalto de esgrima

Análisis:
	- Entrada:
			- un caracter para respuesta
			- un numero para 
	- Salida:
	- Requisitos:
			- respuesta tiene que ser s o n



PG:

Inicio
	Leer y validar respuesta para ejecutar
	Mientras se quiera ejecutar
		Mientras la vida del jugador y del Pc no sean 0
			Mostrar movimientos, leer y validar movimiento del jugador
			Generar movimiento del Pc
			Mover personajes y actualizar vida
		Fin_Mientras
		Leer y validar respuesta para volver a ejecutar
	Fin_Mientras
Fin





*/

import java.util.Scanner;
import java.util.Random;

public class Asalto {
	
	public static void main (String[] args) {
		
		char respuesta = ' ';
		
		int movimientoJ = 0;
		int movimientoP = 0;
		
		int vidaJugador = 0;
		int vidaPc = 0;
		
		Scanner teclado = new Scanner (System.in);
		Random random = new Random ();
		
		//Inicio
			//Leer y validar respuesta para ejecutar
			do{
				System.out.print("Quiere ejecutar el juego? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta !='s' && respuesta !='n');
			
			while(respuesta=='s'){
				
				while(vidaJugador!=0 && vidaPc!=0){
					
					//Mostrar movimientos, leer y validar movimiento del jugador
					do{
						System.out.print("1 ---> Marchar  ");
						System.out.print("2 ---> Romper   ");
						System.out.print("3 ---> Defender ");
						System.out.print("4 ---> Atacar   ");
						System.out.print("Su movimiento es: ");
						
						movimientoJ = teclado.nextInt();
					}
					while(movimientoJ < 1 || movimientoJ > 4);
					
					//Generar movimiento del Pc
					movimientoP = random.nextInt(4) +1;
						
					//Mover personajes y actualizar vida
				}
				
				//Leer y validar respuesta para volver a ejecutar
				do{
					System.out.print("Quiere ejecutar el juego otra vez? (s/n): ");
				
					respuesta = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(respuesta !='s' && respuesta !='n');
			}
		//Fin
		
	}
}

