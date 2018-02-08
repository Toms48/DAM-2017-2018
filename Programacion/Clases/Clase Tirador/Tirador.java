/*	Nombre: Tirador
 * 
 * 	Básicas:
 * 		- persona => Persona => Consultable y Modificable
 * 		- arma => ArmaEsgrima => Consultable y Modificable
 * 
 * 	Derivadas: 
 * 		No hay
 * 	
 * 	Compartidas:
 * 		No hay
 * 
 * 	Restricciones:
 * 		No tiene
 * 
 * 	Métodos añadidos:
 * 		- Categorias
 * 
 * 	persona Persona
 * 		- Persona getPersona()
 * 		- void setPersona(Persona persona)
 * 
 * 	arma ArmaEsgrima
 * 		- ArmaEsgrima getArma()
 * 		- void setArma(ArmaEsgrima arma)
 * 
 */


public class Tirador implements Cloneable{
	
	//Atributos
	private Persona persona/* = new Persona()*/;
	private ArmaEsgrima arma/* = new ArmaEsgrima()*/;
	
	//Constructor por defecto
	public Tirador(){
		persona = new Persona();
		arma = new ArmaEsgrima();
	}
	
	//Constructor con parámetros
	public Tirador(
		String nombre, int edad, String DNI, char sexo, double peso, double altura,
		String marca, String tipo, char manoBuena){
			
		this.persona = new Persona(nombre, edad, DNI, sexo, peso, altura);
		this.arma = new ArmaEsgrima(marca, tipo, manoBuena);
	}
	
	//Constructor de copia
	public Tirador(Tirador tiradorCopia){
		this.persona = new Persona(tiradorCopia.persona);
		this.arma = new ArmaEsgrima(tiradorCopia.arma);
	}
	
	//GETS
	public Persona getPersona(){
		return persona;
	}
	
	public String getNombre(){
		return persona.getNombre();
	}
	
	public int getEdad(){
		return persona.getEdad();
	}
	
	public String getDNI(){
		return persona.getDNI();
	}
	
	public char getSexo(){
		return persona.getSexo();
	}
	
	public double getPeso(){
		return persona.getPeso();
	}
	
	public double getAltura(){
		return persona.getAltura();
	}
	
	
	public ArmaEsgrima getArma(){
		return arma;
	}
	
	public String getMarca(){
		return arma.getMarca();
	}
	
	public String getTipo(){
		return arma.getTipo();
	}
	
	public char getManoBuena(){
		return arma.getManoBuena();
	}
	
	
	//SETS
	public void setNombre(){
		this.persona.getNombre();
	}
	
	public void setEdad(){
		this.persona.getEdad()
	}
	
	public void setDNI(){
		this.persona
	}
	
	public void setSexo(){
		this.persona
	}
	
	public void setPeso(){
		this.persona
	}
	
	public void setAltura(){
		this.persona
	}

	
	public void setMarca(){
		this.arma
	}
	
	public void setTipo(){
		this.arma
	}
	
	public void setManoBuena(){
		this.arma
	}
	
	
	//Métodos sobrescritos
	@Override
	public Tirador clone(){
		
		Tirador copia = null;
		
		try{
			copia = (Tirador)super.clone();
		}
		catch(CloneNotSupportedException error){
			System.out.println("No se pudo clonar el objeto (devuelve un null)");
		}
		
		return copia;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean ret = false;

		if(this == obj){
			ret = true;
		}
		else{
			if(obj != null && obj instanceof Tirador){
				Tirador other = (Tirador)obj;
				
				if(this.persona == other.getPersona() &&
				   this.arma == other.getArma()){
					   
					ret = true;
					
				}
			}
		}
		return ret;
	}
	
	@Override
	public String toString(){
		String s = "*----- Persona -----*" +"\n" +getPersona() +"\n\n*----- Arma -----*" +"\n" +getArma();
		
		return s;
	}
	
	@Override
	public int hashCode(){
		return ((int) ((persona.hashCode() * 7) + (arma.hashCode() + persona.hashCode() ) ));
	}
	
	
}

