/*
 *
 * Nombre: Boletin6Ejercicio1
 * 
 * Comentario: 
 *  
 * Análisis:
 * 		- Entrada:  
 * 					- opcionMenu
 *					- caracter
 * 					-  
 * 		- Salida: No tiene. Solo pinta por pantalla
 * 		- Requisitos:
 * 					- La opcion del menu será entre 0 y 13
 */

//PG
//Inicio
	//Mostrar menu, leer y validar opcion
	//Mientras opcion no es 0
		//Segun opcion
			//Caso 1:
			//...
			//Caso 13:
		//Fin_Segun
		//Mostrar menu, leer y validar opcion
	//Fin_Mientras
//Fin

import java.util.Scanner;

public class Boletin6Ejercicio1 {

/**************************************************************************	     TERMINAR DE HACER
MT
	Nec: No hay
	Dev: numero
	Nec/Dev: No hay
	Restriccion: numero entre

Interfaz
	Comentario: Subprograma que imprimirá el menu, leerá y validará su opcion 
	Cabecera: entero numero MMLVO()
	Precondiciones: No hay
	Entrada:
		- numero
		- caracter
	Salida: Solo imprime por pantalla. No hay.
	E/S: No hay
	Postcondiciones: No hay (porque no tiene salidas).
**************************************************************************/



/**************************************************************************	
MT
	Nec:
		- numero
		- caracter
	Dev: No hay
	Nec/Dev: No hay
	Restriccion: 
		- numero mayor que cero

Interfaz
	Comentario: Subprograma que teniendo como parámetros un carácter y un número, imprima una línea con tantas veces el carácter como indique el número.
	Cabecera: cadenaCaracteres(caracter caracter, entero numero)
	Precondiciones:
		- numero mayor que 0
	Entrada:
		- numero
		- caracter
	Salida: Solo imprime por pantalla. No hay.
	E/S: No hay
	Postcondiciones: No hay (porque no tiene salidas).
**************************************************************************/
	
	public static void lineaCaracteres(char caracterLinea, int longitudLinea){
		
		int contador;
		
		System.out.println(" ");
		
		for(contador = 0; contador < longitudLinea; contador++){
			System.out.print(caracterLinea);
		}
	}
	
/**************************************************************************	
MT
	Nec: No hay
	Dev: No hay
	Nec/Dev: caracter
	Restriccion: No hay

Interfaz
	Comentario: Subprograma para pasar de minúsculas a mayúsculas.
	Cabecera: caracter cambiarAMayuscula(caracter caracter)
	Precondiciones: No hay
	Entrada:
	Salida:
	E/S: caracter
	Postcondiciones: el caracter estará en minuscula
**************************************************************************/	

	public static void /*TENGO QUE CAMBIAR EL VOID*/ mayusculaAMinuscula(char letraMayusculaAMinuscula){
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println(" ");
		System.out.println("En construccion");
		
		/*letraMayusculaAMinuscula = Character.toLowerCase(letraMayusculaAMinuscula);
		
		return letraMayusculaAMinuscula;*/
	}
	
/**************************************************************************	
MT
	Nec: numero
	Dev: logico
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Subprograma para calcular si un año es o no bisiesto.
	Cabecera: logico bisiestoNoBisiesto(entero numero)
	Precondiciones: No hay
	Entrada: numero
	Salida: logico
	E/S: No hay
	Postcondiciones:
		- Devuelve verdadero si el numero es divisible entre cuatro pero no por 100 o numero es divisible entre 400
		- Devuelve falso si no cumple las especificaciones
**************************************************************************/	
	
	public static boolean bisiestoNoBisiesto(int anio){
		
		boolean esBisiesto = false;
		
		//System.out.print("Funciona!");
		
		if((anio%4==0 && anio%100!=0) || anio%400==0){	//anio%4==0 && (anio%100!=0 || anio%400==0) esta es otra manera de escribir la condicion, funciona igual, incluso he leido que es más eficiente
			esBisiesto = true;
		}
		
		return esBisiesto;
		
	}
	
/**************************************************************************	
MT
	Nec: caracter
	Dev: No hay
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Subprograma Digito que determine si un carácter es un dígito entre 0 y 9. 
	Cabecera: bisiestoNoBisiesto(caracter caracter)
	Precondiciones: No hay
	Entrada: caracter
	Salida: No hay. Pinta por pantalla
	E/S: No hay
	Postcondiciones: No hay. (Porque no hay salidas)
**************************************************************************/	
	
	public static void digito(char caracterDigito){
		
		//System.out.println("Funciona!");
		
		if(caracterDigito>=48 && caracterDigito<=57){
			System.out.println(" ");
			System.out.println("Su caracter '" +caracterDigito +"' es un digito entre 0 y 9");
		}
		else{
			System.out.println(" ");
			System.out.println("Su caracter '" +caracterDigito +"' no es un digito entre 0 y 9");
		}
		
	}
	
/**************************************************************************	
MT
	Nec: caracter
	Dev: No hay
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Subprograma Digito que determine si un carácter es un dígito entre 0 y 9. 
	Cabecera: bisiestoNoBisiesto(caracter caracter)
	Precondiciones: No hay
	Entrada: caracter
	Salida: No hay. Pinta por pantalla
	E/S: No hay
	Postcondiciones: No hay. (Porque no hay salidas)
**************************************************************************/	

	public static void numeroPerfecto(){
		System.out.println(" ");
		System.out.println("En construccion");
	}
	
	public static void main (String[] args) {
		
		int opcionMenu = 0;
		
		char caracterLinea = ' ';
		int longitudLinea = 0;
		
		char letraMayusculaAMinuscula = ' ';
		
		int anio = 0;
		
		char caracterDigito = ' ';
		
		Scanner teclado = new Scanner(System.in);
		
		//Inicio
			//Mostrar menu, leer y validar opcion
			do{
				System.out.println(" ");
				System.out.println("1  ---> Linea de caracteres");
				System.out.println("2  ---> Mayusculas a minusculas");
				System.out.println("3  ---> Anio bisiesto");
				System.out.println("4  ---> Digito");
				System.out.println("5  ---> Numero perfecto");
				System.out.println("6  ---> ");
				System.out.println("7  ---> ");
				System.out.println("8  ---> ");
				System.out.println("9  ---> ");
				System.out.println("10 ---> ");
				System.out.println("11 ---> ");
				System.out.println("12 ---> ");
				System.out.println("13 ---> ");
				System.out.println("0  ---> Salir");
				System.out.println(" ");
				System.out.print  ("Su opcion es: ");
				
				opcionMenu = teclado.nextInt();
			}
			while(opcionMenu<0 || opcionMenu>13);
			
			while(opcionMenu!=0){
				//Segun opcion
				switch(opcionMenu){
					case 1:
						
						do{
							System.out.print("Introduzca una longitud para la linea de caracteres: ");
							
							longitudLinea = teclado.nextInt();
						}
						while(longitudLinea<=0);
						
						do{
							System.out.print("Introduzca un caracter para la linea de caracteres: ");
							
							caracterLinea = teclado.next().charAt(0);
						}
						while(caracterLinea<33 || caracterLinea>126);
						
						lineaCaracteres(caracterLinea, longitudLinea);
						
					break;
					
					case 2:
					
						do{
							System.out.print("Introduzca una letra mayuscula para pasarla a minuscula: ");
							
							letraMayusculaAMinuscula = teclado.next().charAt(0);
						}
						while(letraMayusculaAMinuscula<65 || letraMayusculaAMinuscula>90);
						
						mayusculaAMinuscula(letraMayusculaAMinuscula);
						
					break;
					
					case 3:
					
						do{
							System.out.print("Introduzca un anio a partir del 1582 (inclusive) para saber si es o no bisiesto: ");
							
							anio = teclado.nextInt();
							
						}
						while(anio<1582);
						
						bisiestoNoBisiesto(anio);
							
						if(bisiestoNoBisiesto(anio)==true){
							System.out.println(" ");
							System.out.println("El anio " +anio +" es bisiesto");
						}
						else{
							System.out.println(" ");
							System.out.println("El anio " +anio +" no es bisiesto");
						}
						
					break;
					
					case 4:
						
						System.out.println("Introduzca un caracter para ver si es un digito entre 0 y 9.");
						System.out.print("Su caracter es: ");
						
						caracterDigito = teclado.next().charAt(0);
						
						digito(caracterDigito);
						
					break;
					
					case 5:
					
						numeroPerfecto();
					
					break;
					
				}//Fin_Segun
				
				//Mostrar menu, leer y validar opcion
				do{
					System.out.println(" ");
					System.out.println("1  ---> Linea de caracteres");
					System.out.println("2  ---> Mayusculas a minusculas");
					System.out.println("3  ---> Anio bisiesto");
					System.out.println("4  ---> Digito");
					System.out.println("5  ---> ");
					System.out.println("6  ---> ");
					System.out.println("7  ---> ");
					System.out.println("8  ---> ");
					System.out.println("9  ---> ");
					System.out.println("10 ---> ");
					System.out.println("11 ---> ");
					System.out.println("12 ---> ");
					System.out.println("13 ---> ");
					System.out.println("0  ---> Salir");
					System.out.println(" ");
					System.out.print  ("Su opcion es: ");
					
					opcionMenu = teclado.nextInt();
					
				}
				while(opcionMenu<0 || opcionMenu>13);
				
			}//Fin_Mientras
			System.out.println();
			System.out.println("Hasta luego!");
			System.out.println();
		//Fin
		
	}
}

