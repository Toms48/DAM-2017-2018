public class TestPersona {
	
	public static void main (String[] args) {
		
		//Tests Constructores
		System.out.println(" ");
		System.out.println("*------------------- Constructores -------------------*");
		System.out.println(" ");
		
		//Constructor por defecto
		Persona porDefecto = new Persona();
		
		//Constructor con parámetros
		Persona Jorge = new Persona("Jorge", 19, "48124244-X", 'H', 68.0, 1.73);
		Persona Tomas = new Persona("Tomas", 19, "77859350-A", 'H', 70.0, 1.72);
		Persona Rafa = new Persona("Rafa", 21, "47394697-E", 'H', 81.0, 1.82);
		Persona Yeray = new Persona("Yeray", 20, "47429304-S", 'H', 65.0, 1.56);
		
		//Constructor de copia
		Persona copiaJorge = new Persona(Jorge);
		Persona copiaTomas = new Persona(Tomas);
		Persona copiaRafa = new Persona(Rafa);
		Persona copiaYeray = new Persona(Yeray);
		
		//Tests Gets
		System.out.println(" ");
		System.out.println("*------------------- Gets -------------------*");
		System.out.println(" ");
		
		System.out.println(Jorge.getNombre());
		System.out.println(Jorge.getEdad());
		System.out.println(Jorge.getDNI());
		System.out.println(Jorge.getSexo());
		System.out.println(Jorge.getPeso());
		System.out.println(Jorge.getAltura());
		
		System.out.println(" ");
		
		System.out.println(Yeray.getNombre());
		System.out.println(Yeray.getEdad());
		System.out.println(Yeray.getDNI());
		System.out.println(Yeray.getSexo());
		System.out.println(Yeray.getPeso());
		System.out.println(Yeray.getAltura());
		
		//Tests Sets
		System.out.println(" ");
		System.out.println("*------------------- Sets -------------------*");
		System.out.println(" ");
		
		try{
			Rafa.setNombre("Rafael");
			System.out.println("Nuevo nombre: " +Rafa.getNombre());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Rafa.setEdad(22);
			System.out.println("Nueva edad: " +Rafa.getEdad());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
			
		try{
			Rafa.setSexo('H');
			System.out.println("Nuevo sexo: " +Rafa.getSexo());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Rafa.setPeso(82.0);
			System.out.println("Nuevo peso: " +Rafa.getPeso());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Rafa.setAltura(1.83);
			System.out.println("Nueva altura: " +Rafa.getAltura());
			
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		try{
			Tomas.setNombre("Tomas Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso");
			System.out.println("Nuevo nombre: " +Tomas.getNombre());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Tomas.setEdad(-19);
			System.out.println("Nueva edad: " +Tomas.getEdad());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Tomas.setSexo('A');
			System.out.println("Nuevo sexo: " +Tomas.getSexo());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Tomas.setPeso(0.0);
			System.out.println("Nuevo peso: " +Tomas.getPeso());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
			System.out.println(" ");
		
		try{
			Tomas.setAltura(-758.41);
			System.out.println("Nueva altura: " +Tomas.getAltura());
		}
		catch(ExcepcionPersona mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		System.out.println("*------------------- toString -------------------*");
		System.out.println(" ");
		
		System.out.println(porDefecto.toString());
		
		System.out.println(" ");
		
		System.out.println(Jorge.toString());
		
		System.out.println(" ");
		
		System.out.println(Tomas.toString());
		
		System.out.println(" ");
		
		System.out.println(Yeray.toString());
		
		System.out.println(" ");
		
		System.out.println(Rafa.toString());
		
		System.out.println(" ");
		System.out.println("*------------------- hashCode -------------------*");
		System.out.println(" ");
		
		System.out.println(porDefecto.hashCode());
		
		System.out.println(" ");
		
		System.out.println(Jorge.hashCode());
		
		System.out.println(" ");
		
		System.out.println(Tomas.hashCode());
		
		System.out.println(" ");
		
		System.out.println(Yeray.hashCode());
		
		System.out.println(" ");
		
		System.out.println(Rafa.hashCode());
		
		System.out.println(" ");
		System.out.println("*------------------- Clone -------------------*");
		System.out.println(" ");
		
		System.out.println(Tomas.toString());
		
		System.out.println(" ");
		
		System.out.println(Tomas.clone());
		
		System.out.println(" ");
		System.out.println("*------------------- Equals -------------------*");
		System.out.println(" ");
		
		System.out.println("Yeray y Yeray: " +Yeray.equals(Yeray));
		System.out.println("copiaRafa y Rafa: " +copiaRafa.equals(Rafa));
		System.out.println("Tomas y copiaJorge: " +Tomas.equals(copiaJorge));
		System.out.println("Jorge y Yeray: " +Jorge.equals(Yeray));
		
		System.out.println(" ");
		System.out.println("*------------------- compareTo -------------------*");
		System.out.println(" ");
		
		System.out.println(Tomas.compareTo(Tomas));
		System.out.println(Jorge.compareTo(Tomas));
		System.out.println(Rafa.compareTo(Yeray));
		System.out.println(copiaTomas.compareTo(Yeray));
		
	}
}

