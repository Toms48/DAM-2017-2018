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


import java.util.Scanner; //Importamos la clase Scanner localizada en util
import java.lang.Math; //Importamos Math localizado en java.lang

public class monedaMath {
	
	public static void main (String[] args) {
		
		//Declaraciones
		char respuesta = ' ';
		
		int contadorCaras = 0;
		int contadorCruces = 0;
		
		double aleatorio = 0;  //IMPORTANTE!  Al generar un double la variable a la que le asignemos el dato tiene que ser double también
		
		//Inicializaciones
		Scanner teclado = new Scanner(System.in);   //Inicializamos el objeto teclado de la clase Scanner
				
		//Inicio
			//Preguntar, leer y validar respuesta
			do{
				System.out.print("Quiere ejecutar el programa? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta!='s' && respuesta!='n');
			
			while(respuesta=='s'){
				//Generar numero aleatorio
				aleatorio = Math.random();  	//Genera un número entre 0 y 1.0
				System.out.println(aleatorio);
				if(aleatorio>=0.5){
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

