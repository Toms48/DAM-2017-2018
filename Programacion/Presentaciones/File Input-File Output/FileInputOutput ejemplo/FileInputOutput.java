import java.io.*;
//import java.util.*;

public  class  FileInputOutput  
{
	public static void main(String[] args) throws IOException 
	{ 
		FileInputStream fin = null;//sirve para leer datos
		FileOutputStream fout = null; //sirve para escribir datos
		
		try 
		{
			fin  =  new  FileInputStream("prueba.txt");
			fout = new FileOutputStream("byteprueba.txt"); 
			int variable;
			
			variable = fin.read();
			
			while (variable != -1) 
			{ 
				fout.write(variable);
				variable = fin.read();
			}
			
			
		}/*catch(IOException error)
		{
			System.out.println(error);
		}*/
		finally 
		{
			fin.close(); 
		
			fout.close();
		}
		
	}
}
