

import java.io.*;


public class Presentacion2 {

    public static void main (String [] args){

        FileOutputStream os = null;

        try{

            os = new FileOutputStream("texto.txt");

        }catch (FileNotFoundException e){

            System.out.println("No se ha encontrado el fichero");

        }

        OutputStreamWriter prueba = null;
        

        try {

            prueba = new OutputStreamWriter(os, "UTF-16");

        }catch (UnsupportedEncodingException e){

            System.out.println("No se permite dicho encoding");
        }



        try {

            prueba.write("Hola ");
            //prueba.write('♦');

            System.out.println(prueba.getEncoding());

            prueba.close();
            os.close();

        }catch (IOException e){

            System.out.println("Error al escribir");

        }




        //Leer

        FileInputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        int data = 0;
        char caracter = ' ';

        try{

            inputStream = new FileInputStream("texto.txt");
            inputStreamReader = new InputStreamReader(inputStream);

            //Metodo ready
            System.out.println(inputStreamReader.ready());


            //Metodo read, lee el ASCII
            data = inputStreamReader.read();

            while(data != -1){ //Mientras no sea fin de fichero

                caracter = (char) data; //Castea a caracter

                System.out.print(caracter);  //Lo pinta por pantalla

                data = inputStreamReader.read();  //Actualiza la variable del bucle
            }

            //Metodo ready
            System.out.println(inputStreamReader.ready());

            inputStreamReader.close();
            inputStream.close();

            //Metodo ready
            //System.out.println(inputStreamReader.ready());


        }catch(IOException error){
            System.out.println("Error en la lectura.");
        }








    }

}