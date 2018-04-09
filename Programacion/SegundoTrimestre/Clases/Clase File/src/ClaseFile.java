//Tenemos que importar java.io para poder utilizar la clase File
import sun.awt.AWTAccessor;

import java.io.*;

public class ClaseFile {

    public static void main (String[] args) {
        //Constructores
        File nuevo = new File("nuevo.txt");

        File nombres = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src", "nombres.txt");

        //File srcClaseFile = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src");
        File srcClaseFile = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src");
        File otraCosa = new File(srcClaseFile, "otraCosa.txt");

        //exists
        System.out.println(nuevo.exists());
        System.out.println(nombres.exists());
        System.out.println(otraCosa.exists());

    }
}