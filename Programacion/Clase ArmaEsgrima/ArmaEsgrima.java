/*
 * Nombre: ArmaEsgrima
 * 
 * Básicas:
 * 		- marca => String => Consultable
 * 		- tipo => String => Consultable
 * 		- manoBuena => char => Consultable y Modificable
 * 
 * Derivadas: No hay
 * 
 * Compartidas: No hay
 * 
 * Restricciones:
 * 		- tipo solo puede ser Espada, Florete o Sable
 * 		- manoBuena solo puede ser la letra D o d (para diestro) y Z o z (para zurdo)
 * 
 * Métodos añadidos: No hay
 * 
 * marca String
 * 		- String getMarca()
 * 		- No tiene set
 * 
 * tipo String
 * 		- String getTipo()
 * 		- No tiene set
 * 
 * manoBuena char
 * 		- char getManoBuena()
 * 		- void setManoBuena(char manoBuena)
 */

public class ArmaEsgrima {
	
	//Atributos
	private String marca = new String();
	private String tipo = new String();
	private char manoBuena;
	
	//Constructor por defecto
	public ArmaEsgrima(){
		tipo = "Espada";
		manoBuena = 'D';
	}
	
	//Constructor con parámetros
	public ArmaEsgrima(String marca, String tipo, char manoBuena){
		this.marca = marca;
		this.tipo = tipo;
		this.manoBuena = manoBuena;
	}
	
	//GETS
	public String getMarca(){
		return marca;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public char getManoBuena(){
		return manoBuena;
	}
	
	//SETS
	public void setManoBuena(char manoBuena) throws ExcepcionArmaEsgrima{
		
		if(manoBuena == 'D'|| manoBuena == 'Z' || manoBuena == 'd'|| manoBuena == 'z'){
			this.manoBuena = manoBuena;
		}
		else{
			throw new ExcepcionArmaEsgrima("La letra para la mano buena solo puede ser D, Z, d o z");
		}
	}
	
	//Métodos sobrescritos
	@Override
	public int hashCode(){
		
		String m = new String(marca);
		String t = new String(tipo);
		
		return ( (int) ((m.length() * 97) / t.length() * 7 + (getMarca().hashCode() + 7)) );
	}
	
	@Override
	public String toString(){
		String s = "Marca: " +getMarca() +"\nTipo: " +getTipo() +"\nMano buena: " +getManoBuena();
		
		return s;
	}
	
}

