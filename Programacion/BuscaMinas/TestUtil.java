package Tests;


import Clases.Util;

public class TestUtil {
    public static void main (String[] args) {
        Util util = new Util();

        //Test arrayAleatorio
        int arrayAux[] = util.arrayAleatorio(20);

        for(int i=0; i < arrayAux.length; i++){
            System.out.println(arrayAux[i]);
        }

        System.out.println(" ");

        //Test crearTablero
        int tablero[][] = util.crearTablero(8);

        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero.length; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println(" ");
        }

    }
}
