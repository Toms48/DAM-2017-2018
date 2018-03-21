package Test;

import Clases.CartaPuebloDuerme;

public class TestsCartaPuebloDuerme {
    public static void main (String[] args) {

        //Tests constructores
        System.out.print(" ");
        System.out.print("*---------- Constructores ----------*");
        System.out.print(" ");

        //Constructor por defecto
        CartaPuebloDuerme cartaPorDefecto = new CartaPuebloDuerme();

        //Constructor con parámetros
        CartaPuebloDuerme cartaP1 = new CartaPuebloDuerme('p');
        CartaPuebloDuerme cartaP2 = new CartaPuebloDuerme('p');
        CartaPuebloDuerme cartaL1 = new CartaPuebloDuerme('l');

        //Constructor de copia
        CartaPuebloDuerme cartaP1Copia = new CartaPuebloDuerme(cartaP1);
        CartaPuebloDuerme cartaL1Copia = new CartaPuebloDuerme(cartaL1);

        //Tests Gets
        System.out.print(" ");
        System.out.print("*---------- Gets ----------*");
        System.out.print(" ");

        System.out.println("Tipo de cartaP1: " +cartaP1.getTipo());
        System.out.println("Tipo de cartaP2: " +cartaP2.getTipo());
        System.out.println("Tipo de cartaL1: " +cartaL1.getTipo());

    }
}
