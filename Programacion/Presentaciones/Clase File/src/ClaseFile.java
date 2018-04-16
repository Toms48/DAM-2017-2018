//Tenemos que importar java.io para poder utilizar la clase File
import sun.awt.AWTAccessor;
import java.lang.*;
import java.io.*;

public class ClaseFile {

    public static void main (String[] args) {
        //Constructores
        File nuevo = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src\\nuevo.txt");
        File oculto = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src\\oculto.txt");

        File escrituraLectura = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src\\escrituraLectura.txt");
        File soloLectura = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src\\soloLectura.txt");

        File nombres = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src", "nombres.txt");

        //File srcClaseFile = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src");
        File srcClaseFile = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src");
        File otraCosa = new File(srcClaseFile, "otraCosa.txt");

        //array
        File [] arrayListFile;
        String [] arrayListString;

        //exists
        System.out.println("*--- exists ---*");
        System.out.println(nuevo.exists());
        System.out.println(nombres.exists());
        System.out.println(otraCosa.exists());

        System.out.println(" ");

        //isDirectory
        System.out.println("*--- isDirectory ---*");
        System.out.println(srcClaseFile.isDirectory());
        System.out.println(nombres.isDirectory());

        System.out.println(" ");

        //isFile
        System.out.println("*--- isFile ---*");
        System.out.println(srcClaseFile.isFile());
        System.out.println(nombres.isFile());
        System.out.println(otraCosa.isFile());

        System.out.println(" ");

        //isHidden
        System.out.println("*--- isHidden ---*");
        System.out.println(srcClaseFile.isHidden());
        System.out.println(nombres.isHidden());
        System.out.println(nuevo.isHidden());
        System.out.println(oculto.isHidden());

        System.out.println(" ");

        //canRead
        System.out.println("*--- canRead ---*");
        System.out.println(srcClaseFile.canRead());
        System.out.println(nombres.canRead());
        System.out.println(escrituraLectura.canRead());
        System.out.println(soloLectura.canRead());

        System.out.println(" ");

        //canWrite
        System.out.println("*--- canWrite ---*");
        System.out.println(srcClaseFile.canWrite());
        System.out.println(nombres.canWrite());
        System.out.println(escrituraLectura.canWrite());
        System.out.println(soloLectura.canWrite());

        System.out.println(" ");

        //canExecute
        System.out.println("*--- canExecute ---*");
        System.out.println(srcClaseFile.canExecute());
        System.out.println(oculto.canExecute());
        System.out.println(escrituraLectura.canExecute());
        System.out.println(soloLectura.canExecute());

        System.out.println(" ");

        //getAbsolutePath
        System.out.println("*--- getAbsolutePath ---*");
        System.out.println(srcClaseFile.getAbsolutePath());
        System.out.println(oculto.getAbsolutePath());
        System.out.println(escrituraLectura.getAbsolutePath());
        System.out.println(otraCosa.getAbsolutePath());

        System.out.println(" ");

        //getName
        System.out.println("*--- getName ---*");
        System.out.println(srcClaseFile.getName());
        System.out.println(oculto.getName());
        System.out.println(escrituraLectura.getName());
        System.out.println(otraCosa.getName());

        System.out.println(" ");

        //getParent
        System.out.println("*--- getParent ---*");
        System.out.println(srcClaseFile.getParent());
        System.out.println(oculto.getParent());
        System.out.println(escrituraLectura.getParent());
        System.out.println(otraCosa.getParent());

        System.out.println(" ");

        //getParent
        System.out.println("*--- getParent ---*");
        System.out.println(srcClaseFile.getParent());
        System.out.println(oculto.getParent());
        System.out.println(escrituraLectura.getParent());
        System.out.println(otraCosa.getParent());

        System.out.println(" ");

        //listFiles
        System.out.println("*--- listFiles ---*");
        arrayListFile = srcClaseFile.listFiles();

        for(int i=0; i<arrayListFile.length; i++){
            System.out.println(arrayListFile[i]);
        }

        System.out.println(" ");

        //list
        System.out.println("*--- list ---*");
        arrayListString = srcClaseFile.list();

        for(int i=0; i<arrayListFile.length; i++){
            System.out.println(arrayListString[i]);
        }

        System.out.println(" ");

        //createNewFile
        System.out.println("*--- createNewFile ---*");
        try {

            //Inicializar un nuevo objeto File
            File gorgeExponDies = new File("C:\\Users\\tmnuñez\\Desktop\\GitHub\\DAM-2017-2018\\Programacion\\SegundoTrimestre\\Clases\\Clase File\\src\\gorgeExponDies.txt");

            //Creamos un nuevo File
            boolean gorgeResult = gorgeExponDies.createNewFile();

            //Testeamos si se ha creado bien el nuevo File
            if(gorgeResult==true){
                System.out.println("Su file se ha creado correctamente: "+gorgeExponDies.getName());
            }
            else{
                System.out.println("El file ya estaba creado: "+gorgeExponDies.getName());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(" ");

        for(int i=0; i<arrayListFile.length; i++){
            System.out.println(arrayListString[i]);
        }

    }
}