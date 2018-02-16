/*Enunciado: diseñar un subprograma que pinte un triangulo en pantalla.
 * 
 * Nombre: boletin5ej5
 * Entradas: numero de filas, caracter de relleno, ejecutar.
 * Salidas: ninguna.
 * Restricciones: numeroFilas solo puede contener numeros enteros positivos. caracterRelleno solo puede ser un caracter.
 * 
 * Pseudocodigo Generalizado
 * INICIO
 * 	LeerValidar ejecutar
 * 	Mientras quiera ejecutar
 * 		LeerValidar numeroFilas
 * 		LeerValidar caracterRelleno
 * 		pintarPiramide*
 * 		LeerValidar ejecutar
 * 	Fin Mientras
 * FIN
 */

import java.io.*;
import java.util.Scanner;

public class boletin5ej5{
	public static void main(String[]args){
		
		Scanner teclado = new Scanner(System.in);
		int numeroFilas=0;
		char caracterRelleno=' ', ejecutar=' ';
		
		//LeerValidar ejecutar
		do{
			System.out.println("Quieres ejecutar? S/N");
			ejecutar = Character.toLowerCase(teclado.next().charAt(0));
		}while(ejecutar != 's' && ejecutar != 'n');
		
		while(ejecutar =='s'){
			//LeerValidar numeroFilas
			do{
				System.out.println("Dime el numero de filas a pintar");
				numeroFilas = teclado.nextInt();
			}while(numeroFilas <0 || numeroFilas>100);
			//LeerValidar caracterRelleno
			do{
				System.out.println("Dime ahora el caracter de relleno");
				caracterRelleno = teclado.next().charAt(0);
			}while((int)caracterRelleno <65 && (int)caracterRelleno >122);
			//pintarPiramide*
			funcionalidades.pintarPiramide(numeroFilas, caracterRelleno);
			//LeerValidar ejecutar
			do{
				System.out.println("\n¿Quieres ejecutar? S/N");
				ejecutar = Character.toLowerCase(teclado.next().charAt(0));
			}while(ejecutar != 's' && ejecutar != 'n');
		}
	}
}
