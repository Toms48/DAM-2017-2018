public class TestHora {
	
	public static void main (String[] args) {
		//Test constructores
		Hora hora0 = new Hora();
		Hora hora1 = null;
		
		//try{
			
			hora1 = new Hora(14,30,45);
			
		/*}
		catch(ExcepcionHora mensaje){
			
			System.out.println(mensaje);
			
		}*/
		
		Hora horaCopia = new Hora(hora1); 
		
		//Test toString
		System.out.println("toString del constructor por defecto");
		System.out.println(hora0.toString());
		System.out.println(" ");
		
		System.out.println("toString del constructor con parametros");
		System.out.println(hora1.toString());
		System.out.println(" ");
		
		System.out.println("toString del constructor copia");
		System.out.println(horaCopia.toString());
		System.out.println(" ");
		
		//Test GETS
		System.out.println("Gets del constructor por defecto");
		System.out.println("La hora es: " +hora0.getHora());
		System.out.println("Los minutos son: " +hora0.getMinuto());
		System.out.println("Los segundos son: " +hora0.getSegundo());
		System.out.println(" ");
		
		System.out.println("Gets del constructor completo");
		System.out.println("La hora es: " +hora1.getHora());
		System.out.println("Los minutos son: " +hora1.getMinuto());
		System.out.println("Los segundos son: " +hora1.getSegundo());
		System.out.println(" ");
		
		System.out.println("Gets del constructor copia");
		System.out.println("La hora es: " +horaCopia.getHora());
		System.out.println("Los minutos son: " +horaCopia.getMinuto());
		System.out.println("Los segundos son: " +horaCopia.getSegundo());
		System.out.println(" ");
		
		System.out.println("Sets del constructor completo");
		
		hora1.setHora(3);
		hora1.setMinuto(59);
		hora1.setSegundo(27);
		
		System.out.println("La hora es: " +hora1.getHora());
		System.out.println("Los minutos son: " +hora1.getMinuto());
		System.out.println("Los segundos son: " +hora1.getSegundo());
		System.out.println(" ");
		
	}
}

