import java.io.*;
import java.util.Scanner;

public class Ejercicio4_2 {

    public static void main (String[] args) {
        char respuesta = ' ';

        Scanner teclado = new Scanner(System.in);

        do{
            System.out.print("Quiere introducir una palabra? (s/n): ");

            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }
        while(respuesta!='s' && respuesta!='n');

        while(respuesta != 'n'){

        }
        System.out.println("Introduzca su  palabra: ");
    }
}