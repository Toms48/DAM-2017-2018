/*********************************************************************************************************************
* Nombre: Ejercicio4_2
*
* Comentario: Estudia, estudia y trabaja
*
* Análisis:
* 		-Entrada: un caracter para la respuesta
* 	        	un numero que sea el dinero inicial
* 				un numero para la apuesta del jugador
* 				un numero por el que se apuesta
* 		-Salida: pinta por pantalla
* 		-Requisitos: La respuesta tiene que ser 's' o 'n'
* 					 El dinero inicial tiene que ser mayor que cero
* 					 El numero de partidas tiene que ser mayor que cero
* 					 La apuesta del Jugador no puede ser menor o igual que cero ni mayor que el dinero que tenga
*********************************************************************************************************************/

//PG
//Inicio
    //Crear fichero de texto
    //Hacer
        //Preguntar para escribir palabra en el fichero, leer y validar respuesta
        //Leer palabra
        //Escribir palabra en el fichero
        //Preguntar para repetir (leer otra palabra)
    //Mientras queramos introducir más palabras
//Fin

import java.io.*;
import java.util.Scanner;

public class Ejercicio4_2 {

    public static void main (String[] args) {

        char respuesta = ' ';
        String palabra = " ";

        Scanner teclado = new Scanner(System.in);
        File ficheroPalabras = new File("FicheroPalabras.txt");
        FileWriter escritor = null;
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        //Inicio
            //Crear fichero de texto
            try {
                //Creamos un nuevo File
                boolean resultado = ficheroPalabras.createNewFile();

                //Testeamos si se ha creado bien el nuevo File
                if(resultado==true){
                    System.out.println("Su file se ha creado correctamente: "+ficheroPalabras.getName());
                }
                else{
                    System.out.println("El file ya estaba creado: "+ficheroPalabras.getName());
                }

            }
            catch(Exception e) {
                e.printStackTrace();
            }

            do{
                //Leer palabra
                System.out.print("Introduzca su palabra: ");

                try {

                    palabra = br.readLine();

                }catch (IOException e){

                    System.out.println("Error al leer");

                }

                //Hazlo en condiciones nene <3
                //Escribir palabra en el fichero
                try{
                     escritor = new FileWriter(ficheroPalabras, true); //Declara arriba

                    escritor.write(palabra);
                    escritor.write("\n");


                }
                catch(IOException e){
                    e.printStackTrace();
                }finally{

                    try {

                        escritor.close();

                    }catch (IOException e){

                     System.out.println("Error al cerrar fichero");
                    }

                }

                //Preguntar para repetir (leer otra palabra)
                do{
                    System.out.print("Quiere introducir una palabra? (s/n): ");

                    respuesta = Character.toLowerCase(teclado.next().charAt(0));
                }
                while(respuesta!='s' && respuesta!='n');

            }
            while(respuesta != 'n'); //Mientras queramos introducir más palabras
        //Fin
    }
}