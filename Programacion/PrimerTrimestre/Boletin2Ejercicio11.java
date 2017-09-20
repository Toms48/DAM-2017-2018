/* Nombre: Boletin2Ejercicio11
 * 
 * 
 * 
 * Análisis:
 * 		
 * 		Diseña un algoritmo para calcular el área y el volumen del prisma, cuyos datos
 * 		se leerán de teclado y pintar en pantalla los resultados correspondientes.
 * 
 * 		
 * 		-Entradas: Datos del prisma
 * 		-Salidas: Area y volumen del prisma
 * 
 * PG:
 * 		Inicio
 * 			Preguntar y leer datos del prisma
 * 			Calcular area
 * 			Calcular volumen
 * 			Escribir área y volumen
 * 		Fin
 * 
 */

import java.util.*;

public class Boletin2Ejercicio11 {
	
	public static void main (String args[]) {
		
		//Declaro las variables
		int area='0';
		int volumen='0';
		
		int ancho='0';
		int alto='0';
		int fondo='0';
		
		//Inicializar el scanner
		Scanner teclado = new Scanner (System.in);
		
		//Inicio
			//Preguntar y leer datos del prisma
			System.out.println("Buenas!");
			
			System.out.print("Por favor, indique el ancho del prisma: ");
			ancho = teclado.nextInt();
			
			System.out.print("Por favor, indique el alto del prisma: ");
			alto = teclado.nextInt();
			
			System.out.print("Por favor, indique el fondo del prisma: ");
			fondo = teclado.nextInt();
			
			//Calcular area
			area = (ancho*alto)*6;
			
			//Calcular volumen
			volumen = area*3;
			
			//Escribir área y volumen
			System.out.println("El area es: " +area);
			System.out.println("El volumen es: " +volumen);
			
		//Fin
		
	}
}

