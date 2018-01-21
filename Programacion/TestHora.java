public class TestHora {
	
	public static void main (String[] args) {
		
		//Test constructor por defecto
		Hora hora0 = new Hora();
		
		//Tests constructor con parámetros
		Hora hora1 = null;
		
		try{
			hora1 = new Hora(23,30,48);
		}
		
		catch(ExcepcionHora mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		Hora hora2 = null;
		try{
			hora2 = new Hora(-5,12,53);
		}
		catch(ExcepcionHora mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		Hora hora3 = null;
		try{
			hora3 = new Hora(2,-11,34);
		}
		catch(ExcepcionHora mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		Hora hora4 = null;
		try{
			hora4 = new Hora(15,2,78);
		}
		catch(ExcepcionHora mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		Hora horaCopia = null;
		
		try{
			horaCopia = new Hora(hora1);
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		
		//Tests toString
		try{
			System.out.println("toString del constructor por defecto: " +hora0.toString());
			System.out.println(" ");
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		try{
			System.out.println("toString del constructor con parametros 1: " +hora1.toString());
			System.out.println(" ");
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		try{
			System.out.println("toString del constructor con parametros 2: " +hora2.toString());
			System.out.println(" ");
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		try{
			System.out.println("toString del constructor con parametros 3: " +hora3.toString());
			System.out.println(" ");
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		try{
			System.out.println("toString del constructor con parametros 4: " +hora4.toString());
			System.out.println(" ");
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		try{
			System.out.println("toString del constructor copia: " +horaCopia.toString());
			System.out.println(" ");
		}catch(NullPointerException err){
			System.out.println("No se pudo hacer el toString");
		}
		
		
		//Test GETS del constructor por defecto
		System.out.println("Gets del constructor por defecto: ");
		System.out.println("   - Hora: " +hora0.getHora());
		System.out.println("   - Minutos: " +hora0.getMinuto());
		System.out.println("   - Segundos: " +hora0.getSegundo());
		
		System.out.println(" ");
		System.out.println("*------------------------------------------------------*");
		System.out.println(" ");
		
		//Test GETS
		
		System.out.println("Gets del constructor completo");
		System.out.println("La hora es: " +hora1.getHora());
		System.out.println("Los minutos son: " +hora1.getMinuto());
		System.out.println("Los segundos son: " +hora1.getSegundo());
		System.out.println(" ");
		
		System.out.println("Gets del constructor completo");
		System.out.println("La hora es: " +hora2.getHora());
		System.out.println("Los minutos son: " +hora2.getMinuto());
		System.out.println("Los segundos son: " +hora2.getSegundo());
		System.out.println(" ");
		
		System.out.println("Gets del constructor copia");
		System.out.println("La hora es: " +horaCopia.getHora());
		System.out.println("Los minutos son: " +horaCopia.getMinuto());
		System.out.println("Los segundos son: " +horaCopia.getSegundo());
		System.out.println(" ");
		
		System.out.println("Sets del constructor completo");
		
		/*hora1.setHora(3);
		hora1.setMinuto(59);
		hora1.setSegundo(27);*/
		
		System.out.println("La hora es: " +hora1.getHora());
		System.out.println("Los minutos son: " +hora1.getMinuto());
		System.out.println("Los segundos son: " +hora1.getSegundo());
		System.out.println(" ");
		
	}
}

