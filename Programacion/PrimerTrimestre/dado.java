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
 * 				Según el numero aleatorio imprimir lado del dado
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
				
 				//Según el numero aleatorio imprimir lado del dado
 				switch(aleatorio){
					
					case 1:	System.out.println("\t---------");
							System.out.println("\t|       |");
							System.out.println("\t|   O   |");
							System.out.println("\t|       |");
							System.out.println("\t---------");
					break;
						
					case 2:	System.out.println("\t---------");
							System.out.println("\t| O     |");
							System.out.println("\t|       |");
							System.out.println("\t|     O |");
							System.out.println("\t---------");
					break;
						
					case 3:	System.out.println("\t---------");
							System.out.println("\t| O     |");
							System.out.println("\t|   O   |");
							System.out.println("\t|     O |");
							System.out.println("\t---------");
					break;
						
					case 4:	System.out.println("\t---------");
							System.out.println("\t| O   O |");
							System.out.println("\t|       |");
							System.out.println("\t| O   O |");
							System.out.println("\t---------");
					break;
						
					case 5:	System.out.println("\t---------");
							System.out.println("\t| O   O |");
							System.out.println("\t|   O   |");
							System.out.println("\t| O   O |");
							System.out.println("\t---------");
					break;
						
					case 6:	System.out.println("\t---------");
							System.out.println("\t| O   O |");
							System.out.println("\t| O   O |");
							System.out.println("\t| O   O |");
							System.out.println("\t---------");
					break;
				}
 				
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

