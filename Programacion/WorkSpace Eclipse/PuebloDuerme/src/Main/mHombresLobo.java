package Main;

/*
 * Nombre: Main.mHombresLobo
 * 
 * Comentario: simulara el juego de los hombres lobo/el pueblo/the werewolfs(?)
 * 
 * Analisis:
 * 		- Entrada:
 * 			- respuesta para ejecutar
 * 			- respuesta para repetir 
 * 		- Salida: 
 */
 
	//PG nivel 0:
		//Inicio
			//LeerValidarParaEjecutar
				//Mientras se quiera ejecutar
				//EjecutarJuego*
				//LeerValidarParaEjecutar
			//Fin_Mientras
		//Fin

import java.util.Scanner;

public class mHombresLobo {
	
	public static void main (String[] args) {
		
		char respuesta = ' ';
		
		Scanner teclado = new Scanner(System.in);
		
		//Inicio
			//LeerValidarParaEjecutar
			do{
				System.out.print("Quiere ejecutar el programa? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta != 's' && respuesta != 'n');
			
			//Mientras se quiera ejecutar
			while(respuesta == 's'){
				//JugarHombresLobo*
				//Resguardos.rHombresLobo.JugarHombresLobo();
				//LeerValidarParaEjecutar
				do{
					System.out.print("Quiere ejecutar el programa de nuevo? (s/n): ");
					
					respuesta = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(respuesta != 's' && respuesta != 'n');
			}//Fin_Mientras
		//Fin
		
	}
}

