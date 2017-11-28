/*
Nombre:

Comentraio: 

Análisis:
	- Entrada:
	- Salida:
	- Requisitos:



PG:

Inicio
	Leer y validar respuesta para ejecutar
	Mientras se quiera ejecutar
		Mientras la vida del jugador y del Pc no sean 0
			Leer y validar movimiento del jugador
			Generar movimiento del Pc
			Mover personajes y actualizar vida
		Fin_Mientras
		Leer y validar respuesta para volver a ejecutar
	Fin_Mientras
Fin





*/

import java.util.Scanner;
import java.util.Random;

public class Batalla {
	
	public static void main (String[] args) {
		
		char respuesta = ' '; 
		
		//Inicio
			//Leer y validar respuesta para ejecutar
			do{
				System.out.print("Quiere ejecutar el juego? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta !='s' && respuesta !='n');
			
			while(respuesta=='s'){
				
				while(vidaJugador!=0 && vidaPc!=0){
					//Leer y validar movimiento del jugador
					//Generar movimiento del Pc
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

