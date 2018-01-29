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


public class Tirador {
	
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
	
	/*//Constructor de copia
	public Tirador(Tirador tirador){
		
	}*/
	
	//GETS
	public Persona getPersona(){
		return persona;
	}
	
	public ArmaEsgrima getArma(){
		return arma;
	}
	
}

