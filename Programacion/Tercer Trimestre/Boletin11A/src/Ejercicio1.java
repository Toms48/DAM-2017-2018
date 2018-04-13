import java.io.*;

public class Ejercicio1 {

    public static void main (String[] args) {

        //Creo un File para darle la ruta de la que quiero tener el listado
        File ejercicio1 = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\Tercer Trimestre\\Boletin11A\\src");

        //Creo dos arrays para introducir el contenido del fichero
        File [] arrayTipoFile;
        String [] arrayTipoString;

        //Le metemos al array de File todos los elementos de la ruta utilizando listFile
        arrayTipoFile = ejercicio1.listFiles();

        //Al ser un array tenemos que recorrerlo con un for
        for(int i=0; i<arrayTipoFile.length; i++){
            System.out.println(arrayTipoFile[i]);
        }

        System.out.println(" ");

        //Le metemos al array de String todos los elementos de la ruta utilizando list
        arrayTipoString = ejercicio1.list();

        //Al ser un array tenemos que recorrerlo con un for
        for(int i=0; i<arrayTipoString.length; i++){
            System.out.println(arrayTipoString[i]);
        }

    }
}