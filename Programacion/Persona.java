public class Persona {
	
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
	public void setNombre (String nombre){
		this.nombre = nombre;
	}
	
	public void setEdad (int edad){
		this.edad = edad;
	}
	
	public void setDNI (String DNI){
		this.DNI = DNI;
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
	
}

