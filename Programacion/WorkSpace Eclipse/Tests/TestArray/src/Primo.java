public class Primo
{
	
	/*
	 * esPrimo
	 * Interfaz
	 * Comentario: Esta función indica si un numero es o no primo.
	 * Cabecera: boolean esPrimo(int numero)
	 * Entrada:
	 * 	-numero
	 * Salida:
	 * 	-ret
	 * Precondiciones: El numero debe ser positivo.
	 * Postcondiciones: La función devulve 'true' cuando el numero es primo y
	 * 'false' cuando el numero no es primo. 
	 * */
	
	public static boolean esPrimo (int numero)
		 {
			 int contador, contador2 = 0;
			 boolean ret = false;
			 
			 for (contador = 1;contador <= numero;contador++)
			 {
				 if (numero % contador == 0)
					contador2++;
			 }
			 
			 if (contador2 <= 2)
				ret = true;
			
				
			 return(ret);
			 
		 }
		 
}
