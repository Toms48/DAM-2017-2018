/* Nombre: Boletin2Ejercicio12
 * 
 * Análisis:
 * 		 Escribe un algoritmo para calcular el cuadrado y el cubo
 * 		 de un número introducido por teclado. 
 * 
 * 		 -Entrada: numero entero o decimal
 * 		 -Salida: cubo y cuadrado del número
 * 
 * 	PG:
 * 		Inicio
 * 			Leer y validar el numero
 * 			Calcular el cuadrado
 * 			Calcular el cubo
 * 			Pintar resultado
 * 		Fin
 * 
 * 
 */

import java.util.*;
import java.lang.*;

public class Boletin2Ejercicio12 {
	
	public static void main (String args[]) {
		
	//Declaro las variables
	double numero = 0;
	double cuadrado = 0;
	double cubo = 0;
		
	//Inicialilzo el scanner
	Scanner teclado = new Scanner (System.in);
		
	//Inicio
		
		System.out.println("\t---------------");
		System.out.println("\t| Bienvenido! |");
		System.out.println("\t---------------");
	
		//Leer y validar el numero
		System.out.println(" ");
		System.out.print("Por favor introduzca un numero: ");
		
		numero = teclado.nextDouble();
		
		//Calcular el cuadrado
		cuadrado = Math.pow(numero,2);
		
		//Calcular el cubo
		cubo = Math.pow(numero,3);
		
		//Pintar resultados
		System.out.println(" ");
		System.out.println("El cuadrado de " +numero +" es: " +cuadrado);
		System.out.print("El cubo de " +numero +" es: " +cubo);
	//Fin
		
	}
}

