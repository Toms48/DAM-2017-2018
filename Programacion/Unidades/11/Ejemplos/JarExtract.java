import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
* @author unknown
*/
public class JarExtract 
{
 public static void extractJar(String jarFile, java.io.File directory)throws IOException
 {
	java.util.jar.JarInputStream jarInput = new java.util.jar.JarInputStream(new FileInputStream(jarFile));
	java.util.jar.JarEntry jarEntry=null;
    while((jarEntry=jarInput.getNextJarEntry())!=null)
    {
   	 java.io.File file=new java.io.File(directory,jarEntry.getName());
     if (jarEntry.isDirectory())
     {
       	if (!file.exists())
           file.mkdirs();
      }
      else
      { 
		java.io.File dir = new java.io.File(file.getParent());
        if (!dir.exists())
			dir.mkdirs();
        byte[] bytes = new byte[1024];
        java.io.InputStream inputStream   = new BufferedInputStream(jarInput);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int read = -1;
        while ((read = inputStream.read(bytes)) != -1) 
        {
	      fileOutputStream.write(bytes, 0, read);
	    }
        fileOutputStream.close();             
       }
    }
    }
/*
 * Tambien he encontrado este otro código
 public void sacarArchivoJar(String Archivo,String RutaDescarga){

try {
            InputStream in = getClass().getResourceAsStream(Archivo);
            OutputStream out = new FileOutputStream(RutaDescarga);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.print("Copiado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }

}
}
 * */
 public static void main(String[] args) throws IOException 
 {
	extractJar("Archivo.jar",new java.io.File("/home/Mine/"));
 }
}
