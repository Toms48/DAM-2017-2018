import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boletin {




    public static void mostarDirectorio(String ruta){

        String[] listado;

        File directorio = new File(ruta);

        listado = directorio.list();


        //Ej2
        Arrays.sort(listado);


        for(int i = 0; i< listado.length; i++){

            System.out.println(listado[i]);
        }

    }















    public static void mostarDirectorioInfo(String ruta){

        File[] listado;

        File directorio = new File(ruta);

        listado = directorio.listFiles();


        //Ej2
        Arrays.sort(listado);


        for(int i = 0; i< listado.length; i++){

            //Ej3
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            System.out.println(listado[i]+" "+
                    listado[i].isDirectory()+" "+
                    listado[i].isFile()+" "+
                    sdf.format(listado[i].lastModified()) +" "+
                    listado[i].isHidden()+" "+
                    listado[i].length());
        }

    }



    public static void main (String[] args){

        Scanner teclado = new Scanner(System.in);

        String ruta = "";

        System.out.print("Diga la ruta: ");


        ruta = teclado.next();

        mostarDirectorio(ruta);

    }

}
