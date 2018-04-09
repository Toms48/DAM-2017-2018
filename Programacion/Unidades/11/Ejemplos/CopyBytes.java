//CopyBytes.java
//Ejemplo de uso de FileInputStream y FileOutputStream

import java.io.*;
import java.util.*;

public  class  CopyBytes  
{
	public static void main(String[] args) throws IOException 
	{ 
		FileInputStream in = null;
		FileOutputStream out = null; 
		try 
		{
			in  =  new  FileInputStream("prueba.txt");
			out = new FileOutputStream("byteprueba.txt"); 
			int c;
			c = in.read();//Returns:the next byte of data, or -1 if the end of the file is reached.
			while (c != -1) 
			{ 
				out.write(c);
				c = in.read();
			}
		}  
		finally  
		{ 
			if (in != null) 
			{ 
				in.close(); 
			} 
			if (out != null) 
			{ 
				out.close();
			}
		}
		
	}
}
