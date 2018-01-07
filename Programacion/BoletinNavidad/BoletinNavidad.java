/*	Nombre: BoletinNavidad
 * 
 * Comentario: Presentará un menú con los ejercicios del boletín
 * 
 * Análisis:
 * 		- Entradas: 
 * 			- Un numero para la opncion del menu
 * 			- 
 * 		- Salidas: No tiene
 * 		- Requisitos: La opcion tiene ser un numero entre 1 y 11
 * 
 */

//Inicio
	//MostrarMenuLeerValidarOpcion
	//Mientras opcion no sea 0
		//Según la opcion del menu
			//caso 1: ejercicio 1
			//caso 2: ejercicio 2
			//caso 3: ejercicio 3
			//caso 4: ejercicio 4
			//caso 5: ejercicio 5
			//caso 6: ejercicio 6
			//caso 7: ejercicio 7
			//caso 8: ejercicio 8
			//caso 9: ejercicio 9
			//caso 10: ejercicio 10
			//caso 11: ejercicio 11
		//Fin_Según
		//MostrarMenuLeerValidarOpcion
	//Fin_Mientras
//Fin

import java.util.Scanner;

public class BoletinNavidad {
	
	public static void main (String[] args) {
		
		int opcionMenu = 0;
		int numeroRima = 0;
		
		Scanner teclado = new Scanner (System.in);
		
		//Inicio
			//MostrarMenuLeerValidarOpcion
			do{
				//rBoletinNavidad.MostrarMenu();
				fBoletinNavidad.MostrarMenu();
				
				System.out.print("Su opcion es: ");
				
				opcionMenu = teclado.nextInt();
			}
			while(opcionMenu < 0 || opcionMenu > 11);
			
			while(opcionMenu != 0){
				switch(opcionMenu){
					case 1:
						System.out.println(rBoletinNavidad.ejercicio1('t'));
					break;

					case 2:
						System.out.println(rBoletinNavidad.ejercicio2(54));
					break;

					case 3:
						System.out.println(rBoletinNavidad.ejercicio3(5));
					break;

					case 4:
						System.out.println(rBoletinNavidad.ejercicio4(5));
					break;

					case 5:
						System.out.println(rBoletinNavidad.ejercicio5(5));
					break;

					case 6:
						System.out.println(rBoletinNavidad.ejercicio6(5));
					break;

					case 7:
						System.out.println(rBoletinNavidad.ejercicio7(5));
					break;

					case 8:
						//rBoletinNavidad.ejercicio8(5);
						
						do{
							System.out.print("Introduzca el numero para hacer una rima: ");
				
							numeroRima = teclado.nextInt();
						}
						while(numeroRima < 1 || numeroRima > 9);
						
						fBoletinNavidad.ejercicio8(numeroRima);
						
					break;

					case 9:
						System.out.println("o-----------------o");
						System.out.println("| En construccion |");
						System.out.println("o-----------------o");
					break;

					case 10:
						rBoletinNavidad.ejercicio10(5);
					break;

					case 11:
						System.out.println("o-----------------o");
						System.out.println("| En construccion |");
						System.out.println("o-----------------o");
					break;

				}
				
				//MostrarMenuLeerValidarOpcion
				do{
					//rBoletinNavidad.MostrarMenu();
					fBoletinNavidad.MostrarMenu();
				
					System.out.print("Su opcion es: ");
				
					opcionMenu = teclado.nextInt();
				}
				while(opcionMenu < 0 || opcionMenu > 11);
				
			}
		//Fin
		
	}
}

