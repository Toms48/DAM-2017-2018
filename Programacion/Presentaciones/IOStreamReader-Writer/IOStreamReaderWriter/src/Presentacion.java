import sun.nio.cs.UTF_32;
import sun.text.normalizer.UTF16;

import java.io.*;

public class Presentacion {

    public static void main (String [] args){

        FileOutputStream os = null;

        try{

            os = new FileOutputStream("texto.txt");

        }catch (FileNotFoundException e){

            System.out.println("No se ha encontrado el fichero");

        }

        OutputStreamWriter prueba = new OutputStreamWriter(os);


        try {

            prueba.write("Hola gente que tal \n"); //String

            prueba.write("Patata", 0, 6);  //String a cachos

            prueba.write("Patata", 1, 4);

            prueba.write(65);  //Char mediante int

            prueba.write(23);

            //prueba.write('♦'); //Char

            System.out.println(prueba.getEncoding());

            prueba.close();
            os.close();

        }catch (IOException e){

            System.out.println("Error al escribir");

        }




    }

}