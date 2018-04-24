import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/*********************************************************************************************************************
 * Nombre: Ejercicio5
 *
 * Comentario: ---
 *
 * Análisis:
 * 		-Entrada: un String para la ruta
 * 		-Salida: pinta por pantalla
 * 		-Requisitos:
 *********************************************************************************************************************/

//PG
//Inicio
    //Preguntar, leer y validar ruta del archivo
    //Contar numero de palabras del fichero
    //Contar numero de parrafos del fichero
    //Contar el numero de caracteres del fichero
    //Calcular la media de caracteres por palabra
    //Calcular la media de palabras por parrafo
//Fin

public class Ejercicio5 {

    public static void main (String[] args) {

        String rutaString;
        boolean existe;

        Scanner teclado = new Scanner(System.in);

        FileReader fr = null;
        BufferedReader br = null;

        //Inicio
            //Preguntar, leer y validar ruta del archivo
            do{
                System.out.print("Introduzca una ruta existente: ");

                rutaString = teclado.nextLine();

                File ruta = new File(rutaString);

                existe = ruta.exists();

                if(existe==false){
                    System.out.println("El fichero no existe o la ruta esta mal escrita, por favor introduzca vuelva a escribir la ruta");
                    System.out.println(" ");
                }

            }
            while(existe != true);

            //Contar numero de palabras del fichero


            //Contar numero de parrafos del fichero

            try{

            }
            catch{

            }

            //Contar el numero de caracteres del fichero
            //Calcular la media de caracteres por palabra
            //Calcular la media de palabras por parrafo
        //Fin
    }
}
