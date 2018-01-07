public class rBoletinNavidad {

/**************************************************************************	
MT
	Nec: 
	Dev: 
	Nec/Dev: 
	Restriccion: 

Interfaz
	Comentario: 
	Cabecera: 
	Precondiciones: 
	Entrada: 
	Salida: 
	E/S: 
	Postcondiciones: 
**************************************************************************/

/**************************************************************************	
MT *
	Nec: No hay
	Dev: No hay
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Imprime por pantalla el menú
	Cabecera: void MostrarMenu()
	Precondiciones: No hay
	Entrada: No hay
	Salida: No hay
	E/S: No hay
	Postcondiciones: No hay
**************************************************************************/

	public static void MostrarMenu(){
		
		System.out.println(" ");
		System.out.println("o----------------------o");
		System.out.println("| Menu en construccion |");
		System.out.println("o----------------------o");
		System.out.println(" ");
		
	}

/**************************************************************************	
MT
	Nec: Un caracter, es un dato de entrada y se pasa por valor
	Dev: un numero
		- 1 si la letra es minuscula
		- 2 si la letra es mayuscula
		- 3 si es un signo de puntuación
		- 0 si es un numero (entre 0 y 9)
		- -1 si es no es un caracter imprimible
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Nos dirá si una letra está en mayuscula o minuscula, si es un digito entre 0 y 9 o si es un simbolo de puntuacion
	Cabecera: int ejercicio1(char caracter)
	Precondiciones: No hay
	Entrada: un caracter
	Salida: un numero
	E/S: No hay
	Postcondiciones: El numero estará entre -1 y 3
		- 1 si la letra es minuscula
		- 2 si la letra es mayuscula
		- 3 si es un signo de puntuación
		- 0 si es un numero (entre 0 y 9)
		- -1 si es no es un caracter imprimible
**************************************************************************/	
	
	public static int ejercicio1(char caracter){
		
		int numero = 0;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return numero;
		
		/*int estado = 0;
		
		if(cararter >= 33 && caracter <= 126){
			
		}
		else{
			estado = -1
		}
		
		return estado;*/
		
	}
	
/**************************************************************************	
MT
	Nec: Un numero, es un dato de entrada y se pasa por valor
	Dev: un boolean, es un dato de salida y se devuelve asociado al nombre
		- True si el numero es un numero compuesto
		- False si el numero no es un numero compuesto
	Nec/Dev: No hay
	Restriccion: Solo pueden ser numeros naturales mayores o iguales que 0

Interfaz
	Comentario: No sdirá si un numero es compuesto o no, un numero compuesto es un numero natural mayor que 1 no primo.
	Cabecera: boolean ejercicio2(int numero)
	Precondiciones: Solo pueden ser numeros naturales mayores o iguales que 0
	Entrada: Un numero
	Salida: un boolean
	E/S: No hay
	Postcondiciones: 
		- True si el numero es un numero compuesto
		- False si el numero no es un numero compuesto
**************************************************************************/
	
	public static boolean ejercicio2(int numero){
		
		boolean esCompuesto = false;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return esCompuesto;
	}
	
/**************************************************************************	
MT
	Nec: Un numero, es un dato de entrada pasado por valor
	Dev: un numero, es un dato de salida devuelto asociado al nombre
		-   1 si el numero es perfecto
		-  -1 si el numero es semiperfecto
	Nec/Dev: No hay
	Restriccion: El numero no puede ser menor o igual que 0

Interfaz
	Comentario: Conforme a un numero nos dirá si ese numero es perfecto o semiperfecto
	Cabecera: int ejercicio3(int numero)
	Precondiciones: El numero no puede ser menor o igual que 0
	Entrada: un numero
	Salida: un numero
	E/S: No hay
	Postcondiciones: 
		-   1 si el numero es perfecto
		-  -1 si el numero es semiperfecto
**************************************************************************/
	
	public static int ejercicio3(int numero){
		
		int PerfectoSemiperfecto = 0;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return PerfectoSemiperfecto;
	}
	
/**************************************************************************	
MT
	Nec: un numero, es un dato de entrada y se pasa por valor
	Dev: un boolean, es un dato de salida y se devuelve asociado al nombre
		- True si el numero es un numero friki
		- False si el numero no es friki
	Nec/Dev: No hay
	Restriccion: El numero será mayor que 0

Interfaz
	Comentario: Nos dirá si un numero es friki o no, es friki cuando sus digitos suman 15 y es multiplo de 3
	Cabecera: boolean ejercicio4(int numero)
	Precondiciones: El numero será mayor que 0
	Entrada: Un numero
	Salida: Un boolean
	E/S: No hay
	Postcondiciones: 
		- True si el numero es un numero friki
		- False si el numero no es friki
**************************************************************************/
	
	public static boolean ejercicio4(int numero){
		
		boolean esFriki = false;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return esFriki;
	}
	
/**************************************************************************	
MT
	Nec: Un numero, es un dato de entrada y se pasa por valor
	Dev: Un boolean, es un dato de salida y se devuelve asociado al nombre
		- True si el numero es primo probable
		- False si no es primo probable
	Nec/Dev: No hay
	Restriccion: El numero será mayor que 0

Interfaz
	Comentario: Nos dirá si un numero es primo probable
	Cabecera: boolean ejercicio5(int numero)
	Precondiciones: El numero será mayor que 0
	Entrada: Un numero
	Salida: Un bolean
	E/S: 
	Postcondiciones:
		- True si el numero es primo probable
		- False si no es primo probable
**************************************************************************/
	
	public static boolean ejercicio5(int numero){
		
		boolean esPrimoProbable = false;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return esPrimoProbable;
	}
	
/**************************************************************************	
MT
	Nec: Un numero, es un dato de entrada y se pasa por valor
	Dev: Un boolean, es un dato de salida y se devuelve asociado al nombre
	Nec/Dev: No hay
	Restriccion: El numero tiene que ser mayor que 0

Interfaz
	Comentario: Nos dirá si un numero es abundante
	Cabecera: boolean ejercicio6(int numero)
	Precondiciones: El numero tiene que ser mayor que 0
	Entrada: Un numero
	Salida: Un boolean
	E/S: No hay
	Postcondiciones: 
		- True si el numero es abundante
		- False si no es abundante
**************************************************************************/

	public static boolean ejercicio6(int numero){
		
		boolean esAbundante = false;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return esAbundante;
	}

/*Numero Deficiente*/

	public static boolean ejercicio7(int numero){
		
		boolean esDeficiente = false;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
		
		return esDeficiente;
	}

/*Numero Mensajillo gracioso*/

	public static void ejercicio8(int numero){
		
		int mensaje = 0;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
	}

/*Comparar fechas*/

	/*public static void ejercicio9(int numero){
		
		int mensaje = 0;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
	}*/

/*Pasar de 24h a am/pm*/

	public static void ejercicio10(int numero){
		
		int hora24 = 0;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
	}

/*Dias transcurridos*/

	/*public static void ejercicio11(int numero){
		
		int 24hora = 0;
		
		System.out.println(" ");
		System.out.println("o----------------o");
		System.out.println("|  En resguardo  |");
		System.out.println("o----------------o");
		System.out.println(" ");
	}*/

}

