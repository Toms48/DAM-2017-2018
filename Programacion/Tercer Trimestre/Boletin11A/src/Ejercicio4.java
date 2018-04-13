import java.io.*;
import java.text.SimpleDateFormat;

public class Ejercicio4 {

    public static void main (String[] args) {
        //Creo un File para darle la ruta de la que quiero tener el listado
        File ejercicio4 = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\Tercer Trimestre\\Boletin11A\\src");

        //Creo un array para introducir el contenido del fichero
        File [] arrayTipoFile;

        //Le metemos al array de File todos los elementos de la ruta utilizando listFile
        arrayTipoFile = ejercicio4.listFiles();

        //Le doy formato con simpledateformat
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //Al ser un array tenemos que recorrerlo con un for
        for(int i=0; i<arrayTipoFile.length; i++){
            System.out.println(arrayTipoFile[i]);
            System.out.println("\tEs un Fichero?: " +arrayTipoFile[i].isFile());
            System.out.println("\tEs un Directorio?: " +arrayTipoFile[i].isDirectory());
            System.out.println("\tEs oculto: " +arrayTipoFile[i].isHidden());
            System.out.println("\tFecha de ultima modificacion: " +sdt.format(arrayTipoFile[i].lastModified()));
            System.out.println("\tTamanio: " +arrayTipoFile[i].length() +" bytes");
            System.out.println("");
        }
    }
}