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
	private Persona persona = new Persona();
	private ArmaEsgrima arma = new ArmaEsgrima();
	
	//Constructor por defecto
	public Tirador(){
		persona = null;
		arma = null;
	}
	
	//Constructor con parámetros
	public Tirador(Persona persona, ArmaEsgrima arma){
		this.persona = persona;
		this.arma = arma;
	}
	
	//Constructor de copia
	public Tirador(Tirador tirador){
		this.persona = tirador.getPersona();
		this.arma = tirador.getArma();
	}
	
	//GETS
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
	public void setPersona(Persona persona){
		this.persona = persona;
	}
	
	public void setArma(ArmaEsgrima arma){
		this.arma = arma;
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

