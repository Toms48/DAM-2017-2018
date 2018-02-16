/*	Nombre: Carta
 * 
 * 	Básicas:
 * 		- palo => char => Consultable y no modificable (o para Oro, e para Espada, c para Copa y b para Bastos)
 * 		- numero => int => Consultable y no modificable
 * 
 * 	Derivadas: No tiene
 * 
 * 	Compartidas: No tiene
 * 
 * 	Restricciones:
 * 		- palo será una letra: o, e, c o b
 * 		- numero será un numero entre 1 y 12 (incluidos)
 * 
 * 	Métodos añadidos: No tiene
 * 
 * 	char palo
 * 		- char getPalo()
 * 	
 * int numero
 * 		- int getNumero()
 * 
 */


public class Carta implements Comparable<Carta>{
	
	//Atributos
	private char palo;
	private int numero;
	
	//Constructor por defecto
	public Carta(){
		palo = ' ';
		numero = 0;
	}
	
	//Constructor con parámetros
	public Carta(char palo, int numero){
		this.palo = palo;
		this.numero = numero;
	}
	
	//Constructor de copia
	public Carta(Carta cartaCopia){
		this.palo = cartaCopia.getPalo();
		this.numero = cartaCopia.getNumero();
	}
	
	//Gets
	public char getPalo(){
		return palo;
	}
	
	public int getNumero(){
		return numero;
	}
	
	//Métodos sobrescritos
	@Override
	public Carta clone(){
		
		Carta copia = null;
		
		try{
			copia = (Carta)super.clone();
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
			if(obj != null && obj instanceof Carta){
				Carta other = (Carta)obj;
				
				if(this.palo == other.palo &&
				   this.numero == other.numero){
					   
					ret = true;
					
				}
			}
		}
		return ret;
	}
	
	/*Compara por el número de la carta
	 * 	 0 si tienen el mismo numero
	 * 	 1 si la primera carta es mayor que la segunda
	 * 	-1 si la primera carta es menor que la segunda
	 */
	
	public int compareTo(Carta carta){
		
		int ret = 0;
		
		if(this != carta && this.getNumero() > carta.getNumero()){
			ret = 1;
		}
		else{
			if(this.getNumero() < carta.getNumero()){
				ret = -1;
			}
		}
		
		return ret;
	}
	
	@Override
	public String toString(){
		
		String s = "o---------o"
				+"\n| "+getNumero()+"       |"
				+"\n|         |"
				+"\n|         |"
				+"\n|    "+getPalo()+"    |"
				+"\n|         |"
				+"\n|         |"
				+"\n|       "+getNumero()+" |"
				+"\no---------o";

		
		return s;
	}
	
	@Override
	public int hashCode(){
		return ((int) (182417 + getNumero() * 31) );
	}
	
}

