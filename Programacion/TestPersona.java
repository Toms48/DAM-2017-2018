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
		Tomas.setNombre("Tomah");
		System.out.println("Nuevo nombre: " +Tomas.getNombre());
		
		Tomas.setEdad(20);
		System.out.println("Nueva edad: " +Tomas.getEdad());
		
		Tomas.setSexo('F');
		System.out.println("Nuevo sexo: " +Tomas.getSexo());
		
		Tomas.setPeso(73.0);
		System.out.println("Nuevo peso: " +Tomas.getPeso());
		
		Tomas.setAltura(1.73);
		System.out.println("Nueva altura: " +Tomas.getAltura());
		
		System.out.println(" ");
		
		//toString con datos cambiados
		System.out.println(Tomas.toString());
		
		System.out.println(" ");
		
		//hashCode con datos cambiados
		System.out.println("HashCode: " +Tomas.hashCode());
		
	}
}

