/*
 *	Nombre: Boletin5Ejercicio6
 * 	
 * 	Comentario: Leyendo dos momentos de tiempo (expresados en horas, minutos y segundos) nos dirá su diferencia
 * 
 * 	Análisis:
 * 		Entradas:
 * 			- caracter para respuesta
 * 		Salidas:
 * 		Requisitos:
 */
 
//PG
//Inicio
	//Leer y validar para ejecutar el programa
	//Mientras respuesta sea s
		//Leer y validar los instantes de tiempo
		//Calcular diferencia horaria *
		//Mostrar la diferencia
	//Fin_Mientras
//Fin

import java.util.Scanner;

public class Boletin5Ejercicio6 {
	
	public static void main (String[] args) {
		
		char respuesta = ' ';
		
		int hora1 = 0;
		
		Scanner teclado = new Scanner (System.in);
		
			//Leer y validar para ejecutar el programa
			do{
				System.out.print("Desea ejecutar el programa? (s/n): ");
				
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
			}
			while(respuesta!='s' && respuesta!='n');
			
			
			while(respuesta=='s'){	//Mientras respuesta sea s
				//Leer y validar los instantes de tiempo
				do{
					System.out.print("Introduzca una hora entre 0 y 23: ");
					
					hora1 = teclado.nextInt();
				}
				while(hora1 < 0 || hora1 > 23);
				
				//Calcular diferencia horaria *
				//Mostrar la diferencia
			}//Fin_Mientras
		
	}
}
