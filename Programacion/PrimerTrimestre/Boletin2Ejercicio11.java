/* Nombre: Boletin2Ejercicio11
 * 
 * 
 * 
 * Análisis:
 * 		
 * 		Diseña un algoritmo para calcular el área y el volumen del cubo, cuyos datos
 * 		se leerán de teclado y pintar en pantalla los resultados correspondientes.
 * 
 * 		
 * 		-Entradas: Lado del cubo
 * 		-Salidas: Area y volumen del cubo
 * 
 * PG:
 * 		Inicio
 * 			Leer lado del cubo
 * 			Calcular area
 * 			Calcular volumen
 * 			Escribir área y volumen
 * 		Fin
 * 
 */

import java.lang.*;
import java.util.*;

public class Boletin2Ejercicio11 {
	
	public static void main (String args[]) {
		
		//Declaro las variables
		int area='0';
		double volumen='0';
		
		int lado='0';
		
		//Inicializar el scanner
		Scanner teclado = new Scanner (System.in);
		
		//Inicio
			//Leer lado del cubo
			System.out.println("Bienvenido!");
			
			System.out.print("Por favor, indique cuanto mide un lado del cubo: ");
			lado = teclado.nextInt();
			
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

