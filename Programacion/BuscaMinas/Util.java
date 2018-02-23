package Clases;

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

}
