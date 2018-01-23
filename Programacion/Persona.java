public class Persona implements Cloneable, Comparable<Persona> {
	
	//Atributos
	private String nombre = new String();
	private int edad;
	private String DNI = new String();
	private char sexo;
	private double peso;
	private double altura;
	
	//Constructor por defecto
	public Persona (){
		nombre = "Persona PorDefecto";
		edad = 0;
		DNI = "00000000[A-Z]";
		sexo = 'X';
		peso = 0;
		altura = 0;
	}
	
	//Constructor para todos los atributos
	public Persona (String nombre, int edad, String DNI, char sexo, double peso, double altura){
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	//Constructor de copia
	public Persona(Persona PersonaCopia){
		this.nombre = PersonaCopia.getNombre();
		this.edad = PersonaCopia.getEdad();
		this.DNI = PersonaCopia.getDNI();
		this.sexo = PersonaCopia.getSexo();
		this.peso = PersonaCopia.getPeso();
		this.altura = PersonaCopia.getAltura();
	}
	
	//GETS
	public String getNombre(){
		return nombre;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public String getDNI(){
		return DNI;
	}
	
	public char getSexo(){
		return sexo;
	}
	
	public double getPeso(){
		return peso;
	}
	
	public double getAltura(){
		return altura;
	}
	
	
	//SETS
	public void setNombre (String nombre) throws ExcepcionPersona{
		
		String s = new String(getNombre());
		
		if(s.length() > 20){
			this.nombre = nombre;
		}
		else{
			throw new ExcepcionPersona("Nombre tiene caracteres no imprimibles");
		}
	}
	
	public void setEdad (int edad){
		this.edad = edad;
	}
	
	public void setSexo (char sexo){
		this.sexo = sexo;
	}
	
	public void setPeso (double peso){
		this.peso = peso;
	}
	
	public void setAltura (double altura){
		this.altura = altura;
	}
	
	//Métodos añadidos
	public int tipoIMC(){
		
		int tipoIMC = 0;
		double imc = getPeso() / (getAltura()*getAltura());
		
		if (imc < 18.50){
			
			tipoIMC = -1;
			
			if (imc >= 25.00){
				
				tipoIMC = 1;
				
				if (imc>18.50 && imc<24.99){
					
					tipoIMC = 0;
				}
			}
		}
		
		return tipoIMC;
	}
	
	//Métodos sobrescritos
	@Override
	public int compareTo(Persona other){
		
		int ret = 0;
		
		if(this != other && this.getEdad() > other.getEdad()){
			ret = 1;
		}
		else{
			if(this.getEdad() < other.getEdad()){
				ret = -1;
			}
		}
		
		return ret;
	}
	
	@Override
	public Persona clone(){
		
		Persona copia = null;
		
		try{
			copia = (Persona)super.clone();
		}
		catch(CloneNotSupportedException error){
			System.out.println("No se pudo clonar el objeto (devuelve un null)");
		}
		
		return copia;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean ret = false;
		
		//1. Comprobamos que obj no es el mismo objeto (obj == this), si lo es, devolveremos true.
		if(this == obj){
			ret = true;
		}
		else{
			if(obj != null && obj instanceof Persona){
				Persona other = (Persona)obj;
				
				if(this.nombre == other.nombre &&
				   this.edad == other.edad &&
				   this.DNI == other.DNI &&
				   this.sexo == other.sexo &&
				   this.peso == other.peso &&
				   this.altura == other.altura){
					   
					ret = true;
					
				}
			}
		}
		return ret;
	}
	
	@Override
	public String toString(){
		String s = "Nombre: " +getNombre() +"\nEdad: " +getEdad() +"\nDNI: " +getDNI() +"\nSexo: " +getSexo() +"\nPeso: " +getPeso() +"\nAltura: " +getAltura();
		
		return s;
	}
	
	@Override
	public int hashCode(){
		return ((int) ((getDNI().hashCode() + 31) * getPeso() * 7 + getAltura() * 33 * 21 * getEdad() + getAltura() * 100));
	}
	
}

