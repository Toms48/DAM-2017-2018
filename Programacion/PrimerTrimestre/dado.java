/*
 * Nombre: dado
 * 
 * Comentario: Simula que tira un dado de 6 caras
 * 
 * Análisis:
 * 		-Entrada: respuesta para ejecutar de nuevo
 * 		-Salida: Imprime por pantalla un numero
 * 
 * PG:
 * 		Inicio
 * 			Hacer
 * 				Generar numero aleatorio
 * 				Imprimir numero aleatorio
 * 				Preguntar por repetir
 * 			Mientras repetir sea s
 * 		Fin
 * 
 */

import java.util.*;

public class dado {
	
	public static void main (String[] args) {
		
		//Declaraciones de las variables
		char repetir = ' ';
		
		int aleatorio = 0;
		
		//Inicializaciones
		Scanner teclado = new Scanner (System.in);
		
		Random random = new Random ();
		
		//Inicio
			
			System.out.println("\t---------------");
			System.out.println("\t| BIENVENIDO! |");
			System.out.println("\t---------------");
			
 			//Hacer
 			do{
				//Generar numero aleatorio
				System.out.println(" ");
				aleatorio = random.nextInt(6)+1;
				
 				//Imprimir numero aleatorio
 				System.out.println("\t*___*");
 				System.out.println("\t| " +aleatorio +" |");
 				System.out.println("\t*___*");
 				
 				//Preguntar, leer y validar para repetir
 				do{
					System.out.println(" ");
					System.out.print("Quiere tirar otra vez el dado? (s/n): ");
 				
					repetir = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(repetir!='s' && repetir!='n');
			}	
			
 			//Mientras repetir sea s
 			while(repetir == 's');
 		//Fin
		
	}
}

