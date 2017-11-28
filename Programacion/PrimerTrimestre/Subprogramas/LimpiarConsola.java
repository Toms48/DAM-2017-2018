public class LimpiarConsola {

	/*
	limpiarConsola()
	ANALISIS: Limpiará la consola para facilitar la lectura.
	PRECONDICIONES: -
	ENTRADAS: -
	SALIDAS: -
	POSTCONDICIONES: - //Thread.sleep(2000);
	*/	
	
	public static final void windows()
	{
	    try
	    {
	        final String sistemaOperativoActual = System.getProperty("os.name");

	        if (sistemaOperativoActual.contains("Windows"))
	        {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        System.out.println("Error: No se pudo limpiar la consola. "+e);
	    }
	}
	
}
