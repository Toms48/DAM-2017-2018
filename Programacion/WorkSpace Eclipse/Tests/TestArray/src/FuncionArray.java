import java.util.*;

public class FuncionArray
{
	/*
	 * obtenerElementosPares
	 * 
	 * Comentario: Dado un array cargado aleatoriamente, se genera a partir 
	 * de él otro array que contiene los elementos pares que se encuentran en el primero.
	 * Esta función solo funciona con array's de tipo entero.
	 * Cabecera: int[] obtenerElementosPares (int otro[])
	 * Entrada:
	 * 	-otro[]
	 * Salida:
	 * 	-ret[]
	 * Postcondiciones: La función devolverá un array que contenga los
	 * elementos pares del primero.
	 * */
	 
	 public static int[] obtenerElementosPares (int otro[])
	 {
		 /*int ret [] = new int [(otro.length/2)], i, contador = 0;
		 
			for (i = 0; i < otro.length;i++)
			{
				if (i % 2 == 0)
				{
					ret[contador] = otro[i];
					
					contador += 1;
				}
				
			}
		 
		 return ret;*/
		 int contador = 0, contador2 = 0;
		 
		 for(int i = 0;i < otro.length;i++)
		 {
			 if ((otro[i] % 2 == 0) && (otro[i] != 0))
				contador++;
		 }
		 
		 int ret [] = new int [contador];
		 
		 
		 for (int i = 0; i < otro.length;i++)
			{
				if ((otro[i] % 2 == 0) && (otro[i] != 0))
				{
					ret[contador2] = otro[i];
					
					contador2++;
				}
				
				
				
			}
		 return ret;
	 }
	 
	 /*
	 * arrayRandom
	 * 
	 * Comentario: Esta función crea un array de 20 elementos, con números aleatorios comprendidos entre 100 y 300, 
	 * de forma que no se repita ningún elemento. 
	 * Cabecera: int[] arrayRandom ()
	 * Salida:
	 * 	-almacen[]
	 * Postcondiciones: La función devuelve un array que contiene 20
	 * elementos con valores aleatorios entre 100 y 300 sin ningún valor
	 * repetido asociado al nombre. 
	 * */
	 
	 public int[] arrayRandom ()
	 {
		 Random random = new Random();
		 int aleatorio;
		 int almacen[] = new int [20];
		 boolean repetido = false;
		 
		 
			for (int i=0 ;i < almacen.length; i++)
			{
				aleatorio = random.nextInt(200)+100;
				
				
				for(int j = 0; j < almacen.length; j++)
				{
					if (almacen[j] == aleatorio)
						repetido = true;
						
				}
				
				if (repetido == true)
				{
					i--;
					repetido = false;
				}
				else
					almacen[i] = aleatorio;
				
				
			}
		 
		 
		 return almacen; 
	 }
	 
	  /*
	 * almacenarPrimos
	 * 
	 * Comentario: Esta función crea un array con los elementos primos de otro array introducido como parámetro. 
	 * Cabecera: int[] almacenarPrimos (int otro[])
	 * Salida:
	 * 	-ret[]
	 * Postcondiciones: La función devuelve un array con los elementos primos del primer array introducido por parametro
	 * asociado al nombre.
	 * */
	 
	 public int[] almacenarPrimos (int otro[])
	 {
		 /*int ret[] = new int[otro.length];
		 int numero = 0, contador = 0;
		 
		 for(int i = 0;i < otro.length;i++)
		 {
			 contador = 0;
			 numero = otro [i];
			 for(int j = 1; j <= numero; j++)
			 {
				 if (numero % j == 0)
					contador++;
				
			 }
			 if (contador <= 2)
				ret[i] = numero;
			
			 	 
		 }
		 
		 return ret;*/
		 
		 int contador = 0, contador2 = 0, contador3 = 0;
		 
		 for(int i = 0;i < otro.length;i++)
		 {
			 contador2 = otro[i];
			 
			 if ((Primo.esPrimo(contador2) == true) && (otro[i] > 0))
				contador++;
		 }
		 
		 int ret[] = new int [contador];
		 
		 for (int i = 0; i < otro.length;i++)
			{
				contador2 = otro[i];
				
				if ((Primo.esPrimo(contador2) == true) && (otro[i] > 0))
				{
					ret[contador3] = otro[i];
					
					contador3++;
				}
				
			}
			
		 return ret;
	 }
	 
	   /*
	 * arrayReves
	 * 
	 * Comentario: Esta función copia un array invirtiendo el orden de sus elementos. 
	 * Cabecera: int[] arrayReves (int otro[])
	 * Salida:
	 * 	-ret[]
	 * Postcondiciones: La función devuelve un array con los elementos inversos del primero.
	 * */
	 
	 public int[] arrayReves (int otro[])
	 {
		 
		 int ret[] = new int [otro.length]; 
		 int contador = 0;
	
		 for(int i = otro.length -1; i >= 0; i--)
		 {
			 ret[contador] = otro[i];
				 
			 contador++;
	   	 }
		 
		 return ret; 
	 }
	 
	 /*
	  * seleccionarElemento
	  * 
	  * Comentario: La funcion recibe un array de enteros y un número, luego devuelve la posición del elemento selecccionado,
	  * según el numero.En el array no se aceptan números repetidos.Devuleve 0 si el número no está en el array.
	  * Cabecera: int seleccionarElemento (int otro[], int numero)
	  * Entrada:
	  *  -otro[]
	  *  -numero
	  * Salida:
	  *  -ret (int)
	  * Precondiciones:
	  *  -numero >= 0
	  * Postcondiciones:La función devuleve un número asociado al nombre, 
	  * devuelve 0 en caso de no encontrar un elemento en el array.
	  * */
	  
	  public int seleccionarElemento (int otro[], int numero) throws ExcepcionFuncionArray
	  {
		 
		 int ret = 0;
		 
		
			
		 if (numero >= 0 && numero <= otro.length)
		 {
			 for(int i = 0;i <= (numero + 1);i++)
			 {
				 if (numero == i)
				 { 
					ret = otro[i];
				 }
			 }
		 }
		 
		 return ret;
	  }
	 
	 
}
