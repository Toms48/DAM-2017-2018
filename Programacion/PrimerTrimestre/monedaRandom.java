/* Nombre: moneda
 * 
 * Comentario: Se lanzará una moneda y se llevará la cuenta de las caras y las cruces
 * 
 * Análisis:
 * 		- Entrada: Respuesta para ejecutar el programa
 * 		- Salida: El lado de la moneda (Pinta por pantalla)  
 */
 
 /* Estudio de los bucles
  * 	1) 
  * 
  * 
  * 
  */
  
  //PG
	
	//Inicio
		//Preguntar, leer y validar respuesta
		//Mientras respuesta sea s
			//Generar numero aleatorio
			//Si el numero es 1
				//Actualizar contadorCaras
				//Mostrar resultados
			//Else
				//Actualizar contadorCruces
				//Mostrar resultados
			//Fin_Si
			//Preguntar para repetir
		//Fin_Mientras
	//Fin


import java.util.Scanner; //Importamos la clase scanner localizada en util
import java.util.Random; //Importamos la clase Random localizada en util

public class moneda {
	
	public static void main (String[] args) {
		
		//Declaraciones
		char respuesta = ' ';
		
		int contadorCaras = 0;
		int contadorCruces = 0;
		
		int aleatorio = 0;
		
		//Inicializaciones
		Scanner teclado = new Scanner(System.in);   //Inicializamos el objeto teclado de la clase Scanner
		
		Random random = new Random();   //Inicializamos el objeto random de la clase Random
		
		//Inicio
			//Preguntar, leer y validar respuesta
			do{
				System.out.print("Quiere ejecutar el programa? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta!='s' && respuesta!='n');
			
			while(respuesta=='s'){
				//Generar numero aleatorio
				aleatorio = random.nextInt(2) +1;  //Generamos el numero con un máximo de 2 posibilidades, el +1 nos indica que empezará apartir del 1 y le asignamos el valor a la variable aleatorio
				
				if(aleatorio==1){
					//Actualizar contadorCaras
					contadorCaras = contadorCaras+1;
					
					//Mostrar resultados
					System.out.println();
					System.out.println("   ******   ");
					System.out.println("  *      *  ");
					System.out.println(" *  CARA  * ");
					System.out.println("  *      *  ");
					System.out.println("   ******   ");
					System.out.println();
					System.out.println("Cara: " +contadorCaras +"\tCruz: " +contadorCruces);
				}
				else{
					//Actualizar contadorCruces
					contadorCruces = contadorCruces+1;
					
					//Mostrar resultados
					System.out.println();
					System.out.println("   ******   ");
					System.out.println("  *      *  ");
					System.out.println(" *  CRUZ  * ");
					System.out.println("  *      *  ");
					System.out.println("   ******   ");
					System.out.println();
					System.out.println("Cara: " +contadorCaras +"\tCruz: " +contadorCruces);
				}//Fin_Si
				
				//Preguntar, leer y validar para repetir
				do{
					System.out.println();
					System.out.print("Otra tirada? (s/n): ");
				
					respuesta = Character.toLowerCase(teclado.next().charAt(0));
				}
				while(respuesta!='s' && respuesta!='n');
				
			}//Fin_Mientras
		//Fin
		
	}
}

