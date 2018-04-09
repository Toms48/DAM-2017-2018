/*lee de un fichero de texto y pinta en pantalla, no pintará los blancos*/

import java.io.FileReader;
import java.io.IOException;

public class FicheroTApp1 {
 
    public static void main(String[] args) {
 
        final String nomFichero="prueba.txt";
        try{
			FileReader fr = new FileReader (nomFichero);
            int valor=fr.read();
            while(valor!=-1){
                //Si el caracter es un espacio no lo escribe
                if(valor!=32){
                    System.out.print((char)valor);
                }
                valor=fr.read();
            }
         
        }catch(IOException e){
            System.out.println("Problemas con el E/S "+e);
        }
    }
}
