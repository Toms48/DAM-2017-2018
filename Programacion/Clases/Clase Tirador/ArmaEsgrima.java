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
 * 		- manoBuena solo puede ser la letra D o d (para diestro) y I o i (para zurdo)
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

public class ArmaEsgrima implements Cloneable{
	
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
	
	//Constructor de copia
	public ArmaEsgrima(ArmaEsgrima armaCopia){
		this.marca = armaCopia.getMarca();
		this.tipo = armaCopia.getTipo();
		this.manoBuena = armaCopia.getManoBuena();
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
		
		if(manoBuena == 'D'|| manoBuena == 'I' || manoBuena == 'd'|| manoBuena == 'i'){
			this.manoBuena = manoBuena;
		}
		else{
			throw new ExcepcionArmaEsgrima("La letra para la mano buena solo puede ser D, I, d o i");
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
	
	@Override
	public boolean equals(Object obj){
		
		boolean ret = false;
		
		if(this == obj){
			ret = true;
		}
		else{
			if(obj != null && obj instanceof ArmaEsgrima){
				
				ArmaEsgrima other = (ArmaEsgrima)obj;
				
				if(this.marca == other.marca &&
				   this.tipo == other.tipo &&
				   this.manoBuena == other.manoBuena){
					   
					ret = true;
				}
			}
		}
		return ret;
	}
	
	@Override
	public ArmaEsgrima clone(){
		ArmaEsgrima copia = null;
		
		try{
			copia = (ArmaEsgrima)super.clone();
		}
		catch(CloneNotSupportedException error){
			System.out.println("No se pudo clonar el objeto (devuelve un null)");
		}
		
		return copia;
	}
	
}

