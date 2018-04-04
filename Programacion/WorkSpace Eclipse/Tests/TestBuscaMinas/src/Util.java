//package Clases;

import java.util.Random;

/***********************************************************
*  Nombre:
*
* Comentario:
*
* Cabecera:
*
* Precondiciones:
* Entradas:
* Salidas:
* E/S:
* Postcondiciones:
***********************************************************/

public class Util {

/*********************************************************************
*  Nombre: arrayAleatorio
*
* Comentario: carga un array del tamaño que se le indique aleatoriamente entre 1 y el tamaño del array
*
* Cabecera: int[] arrayAleatorio(int tamanioArray)
*
* Precondiciones: el número será mayor o igual que 0
* Entradas: Un número
* Salidas: Un array de enteros
* E/S: No tiene
* Postcondiciones: serán numero entre 1 y el tamaño del array
*********************************************************************/

    public int[] arrayAleatorio(int tamanioArray){
        Random random = new Random();

        int arrayaleatorio[] = new int [tamanioArray];
        int aleatorio;

        for(int i=0; i < arrayaleatorio.length; i++){

            aleatorio = random.nextInt(tamanioArray)+1;

            arrayaleatorio[i] = aleatorio;

        }

        return arrayaleatorio;
    }

    /* CÓDIGO DE YERAY
	 * arrayRandom
	 *
	 * Comentario: Esta funciÃ³n crea un array de 20 elementos, con nÃºmeros aleatorios comprendidos entre 100 y 300,
	 * de forma que no se repita ningÃºn elemento.
	 * Cabecera: int[] arrayRandom ()
	 * Salida:
	 * 	-almacen[]
	 * Postcondiciones: La funciÃ³n devuelve un array que contiene 20
	 * elementos con valores aleatorios entre 100 y 300 sin ningÃºn valor
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

}
