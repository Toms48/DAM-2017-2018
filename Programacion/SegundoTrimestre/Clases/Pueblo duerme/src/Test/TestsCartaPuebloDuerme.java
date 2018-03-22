package Test;

import Clases.CartaPuebloDuerme;

public class TestsCartaPuebloDuerme {
    public static void main (String[] args) {

        //Tests constructores
        System.out.println(" ");
        System.out.println("*---------- Constructores ----------*");

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
        System.out.println(" ");
        System.out.println("*---------- Gets ----------*");

        System.out.println("Tipo de cartaPorDefecto: " +cartaPorDefecto.getTipo());
        System.out.println("Tipo de cartaP1: " +cartaP1.getTipo());
        System.out.println("Tipo de cartaP1Copia: " +cartaP1Copia.getTipo());
        System.out.println("Tipo de cartaP2: " +cartaP2.getTipo());
        System.out.println("Tipo de cartaL1: " +cartaL1.getTipo());
        System.out.println("Tipo de cartaL1Copia: " +cartaL1Copia.getTipo());

        //Tests clone
        System.out.println(" ");
        System.out.println("*---------- clone ----------*");

        System.out.println(cartaP1.clone());

        //Tests toString
        System.out.println(" ");
        System.out.println("*---------- toString ----------*");

        System.out.println(cartaP1.toString());
        System.out.println(cartaP2.toString());
        System.out.println(cartaL1.toString());

        //Tests hashCode
        System.out.println(" ");
        System.out.println("*---------- hashCode ----------*");

        System.out.println(cartaP1.hashCode());
        System.out.println(cartaP2.hashCode());
        System.out.println(cartaL1.hashCode());

    }
}
