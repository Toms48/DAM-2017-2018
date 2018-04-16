/* 
 * Ejemplos FileReader y FileWriter, by Oscar y Dylan
 * 
 */

import java.io.*;

public class FWriterFReader {

	public static void main(String[] args) {
		
		// Ejemplo de escritura y lectura
		
	        try{
	            //Abrimos el stream, crea el fichero si no existe
	            //El true indica que escribiremos sobre lo que ya está escrito
	        	  FileWriter fw = new FileWriter("..\\fichero1.txt", true);
	            
	            //Escribimos en el fichero un String y un caracter, por ejemplo 97 (a)
	              fw.write("Prueba de escritur");
	              fw.write(97);

				//Paso innecesario si vamos a cerrar immediatamente
				  fw.flush();

				//Cerramos el stream
	              fw.close(); 
	            
	            //Abrimos el stream, el fichero debe existir
	              FileReader fr = new FileReader("..\\fichero1.txt");
	            
	            //Leemos el fichero y lo mostramos por pantalla
	              int valor=fr.read();
	              while(valor!=-1){
	                  System.out.print((char)valor);
	                  valor=fr.read();
	            	  	}

	            //Cerramos el stream
	              fr.close();
	            
	        	}catch(IOException e){
	        		System.out.println("Error "+e);
	        		}
	        
//------------------------------------------------------------------------------------------------   
		
	   // Ejemplo copiar contenido de un fichero en otro
			
	       //Declaramos
			FileReader entrada = null;
			FileWriter salida = null;
			
			try 
			{
			  //Instanciamos el FileReader y el FileWriter, creando el ficheroCopia.txt que no existe
				entrada = new FileReader("..\\fichero1.txt"); 
				salida = new FileWriter("ficheroCopia.txt");
				
			  //Copiamos uno por uno los caracteres de fichero1 a ficheroCopia
				int c;
				c = entrada.read();
				while (c!= -1) 
				{ 
					salida.write(c);
					c = entrada.read();
				}
				
			  //Cerramos los streams
				entrada.close();
				salida.close();
			}  
			catch(IOException e) 
			{ 
				System.out.println("Error "+e);
			}
	        
	    }


}
