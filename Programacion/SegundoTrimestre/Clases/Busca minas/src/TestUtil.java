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

    }
}
