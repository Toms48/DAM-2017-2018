/*	Nombre: Boletin2Ejercicio13
 * 
 * 	Comentario: Con el radio calculará el area del circulo, la longitud de la circunferencia
 * 	y el volumen de la esfera.
 * 
 * 	Análisis:
 * 		-Entrada: radio
 * 		-Salida: area del circulo, la longitud de la circunferancia y el volumen de la esfera
 * 
 * 	PG:
 * 	//Inicio
 * 		//Leer y validar radio
 * 		//Calcular area
 * 		//Calcular circunferencia
 * 		//Calcular volumen
 * 		//Imprimir resultado
 * 	//Fin
 * 
 * 	//El área del círculo es igual a pi por el radio al cuadrado.
 *	//La longitud de una circunferencia es igual a 2 pi por el radio.
 *	//El volumen es el radio al cubo por pi por 4 y el resultado entre 3.
 * 
 */

import java.util.*;
import java.lang.*;

public class Boletin2Ejercicio13 {
	
	public static void main (String[] args) {
		
		//Declaro las variables
		double pi = 3.141592;
		
		double radio = 0;
		double area = 0;
		double longitud = 0;
		double volumen = 0;
		
		//Inicializaciones
		Scanner teclado = new Scanner (System.in);
		
		//Inicio
		
			System.out.println("\t---------------");
			System.out.println("\t| Bienvenido! |");
			System.out.println("\t---------------");
		
			//Leer y validar radio
			System.out.println(" ");
			System.out.print("Por favor indique el radio: ");
			
			radio = teclado.nextDouble();
			
			//Calcular area
			area = pi * Math.pow(radio,2);
			
			//Calcular longitud
			longitud = 2 * pi * radio;
			
			//Calcular volumen
			volumen = (Math.pow(radio,3) * pi * 4) / 3;
			
			//Imprimir resultado
			System.out.println(" ");
			System.out.println("El area del circulo de radio " +radio +" es: " +area);
			System.out.println(" ");
			System.out.println("La longitud de la circunferencia de radio " +radio +" es: " +longitud);
			System.out.println(" ");
			System.out.println("El volumen de la circunferencia de radio " +radio +" es: " +volumen);
				
		//Fin
		
	}
}

