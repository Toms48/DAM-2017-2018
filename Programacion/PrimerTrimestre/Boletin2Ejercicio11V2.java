/* Nombre: Boletin2Ejercicio11V2
 * 
 * Análisis:
 * 		Diseña un algoritmo para calcular el área y el volumen del cubo, cuyos datos
 * 		se leerán de teclado y pintar en pantalla los resultados correspondientes.
 * 
 * 		-Entradas: Lado del cubo
 * 		-Salidas: Area y volumen del cubo
 * 
 * PG:
 * 		Inicio
 * 			Leer y validar lado del cubo
 * 			Calcular area
 * 			Calcular volumen
 * 			Escribir área y volumen
 * 		Fin
 * 
 */

import java.lang.*;
import java.util.*;

public class Boletin2Ejercicio11V2 {
	
	public static void main (String args[]) {
		
		//Declaro las variables
		double area='0';
		double volumen='0';
		
		double lado='0';
		
		//Inicializar el scanner
		Scanner teclado = new Scanner (System.in);
		
		//Inicio
			//Leer y validar lado del cubo
			System.out.println("\t------------------");
			System.out.println("\t|   Bienvenido!  |");
			System.out.println("\t------------------");
			
			do{
				System.out.println(" ");
				System.out.print("Por favor, indique cuanto mide un lado del cubo: ");
				lado = teclado.nextDouble();
			}
			while(lado<=0);
				
			
			//Calcular area
			area = (lado*lado)*6;
			
			//Calcular volumen
			volumen = Math.pow(lado,3);
			
			//Escribir área y volumen
			System.out.println(" ");
			System.out.println("El area es: " +area);
			System.out.println(" ");
			System.out.println("El volumen es: " +volumen);
			System.out.println(" ");
			
		//Fin
		
	}
}

