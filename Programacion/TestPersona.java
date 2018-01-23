public class TestPersona {
	
	public static void main (String[] args) {
		
		//Constructor por defecto
		Persona porDefecto = new Persona();
		
		//toString para ver constructor por defecto
		System.out.println(porDefecto.toString());
		
		System.out.println(" ");
		
		//hashCode para el objeto por defecto
		System.out.println("HashCode: " +porDefecto.hashCode());
		
		System.out.println(" ");
		System.out.println("*--------------------------------------------------------------*");
		System.out.println(" ");
		
		//Constructor con parámetros
		Persona Jorge = new Persona("Jorge", 19, "9999999-A", 'M', 68.0, 1.73);
		
		//toString
		System.out.println(Jorge.toString());
		
		
		System.out.println(" ");
		System.out.println("*--------------------------------------------------------------*");
		System.out.println(" ");
		
		//Constructor con parámetros
		Persona Tomas = new Persona("Tomas", 19, "77859350-A", 'M', 70.0, 1.72);
		
		//toString para ver el constructor con parámetros
		System.out.println(Tomas.toString());
		
		System.out.println(" ");
		
		//hashCode para el objeto con parámetros
		System.out.println("HashCode: " +Tomas.hashCode());
		
		System.out.println(" ");
		
		//equals para el objeto con parámetros
		System.out.println("Equals (Tomas y Tomas): " +Tomas.equals(Tomas));
		System.out.println("Equals (Tomas y porDefecto): " +Tomas.equals(porDefecto));
		
		System.out.println(" ");
		
		//clone para el objeto con parámetros
		System.out.println(Tomas.clone());
		
		System.out.println(" ");
		System.out.println("*--------------------------------------------------------------*");
		System.out.println(" ");
		
		//Constructor de copia
		Persona CopiaTomas = new Persona(Tomas);
		
		//toString para ver el constructor copia
		System.out.println(CopiaTomas.toString());
		
		System.out.println(" ");
		
		System.out.println("HashCode: " +CopiaTomas.hashCode());
		
		System.out.println(" ");
		System.out.println("*--------------------------------------------------------------*");
		System.out.println(" ");
		
		//Tests de los SETS y GETS
		try{
			Tomas.setNombre("Tomas osdjifgisadfhñogpoweirgpoiurgourhgpieurjgaijghrfgeiurhgighe");
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Nuevo nombre: " +Tomas.getNombre());
		
		try{
			Tomas.setEdad(-19);
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Nueva edad: " +Tomas.getEdad());
		
		try{
			Tomas.setSexo('j');
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Nuevo sexo: " +Tomas.getSexo());
		
		try{
			Tomas.setPeso(-73.0);
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Nuevo peso: " +Tomas.getPeso());
		
		try{
			Tomas.setAltura(-1.73);
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Nueva altura: " +Tomas.getAltura());
		
		System.out.println(" ");
		
		//toString con datos cambiados
		System.out.println(Tomas.toString());
		
		System.out.println(" ");
		
		//hashCode con datos cambiados
		System.out.println("HashCode: " +Tomas.hashCode());
		
		System.out.println(Jorge.compareTo(Tomas));
		
	}
}

