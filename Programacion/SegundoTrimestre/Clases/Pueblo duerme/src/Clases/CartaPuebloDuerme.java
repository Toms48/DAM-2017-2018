package Clases;

/*	Nombre: CartaPuebloDuerme
 * 
 * 	Básicas:
 * 		- tipo => char => Consultable y no modificable (l para Lobo y p para pueblerinos)
 * 
 * 	Derivadas: No tiene
 * 
 * 	Compartidas: No tiene
 * 
 * 	Restricciones:
 * 		- tipo será una letra: "l" o "p"
 * 
 * 	Métodos añadidos: No tiene
 * 
 * 	char tipo
 * 		- char getTipo()
 * 
 */
public class CartaPuebloDuerme /*implements Comparable<CartaPuebloDuerme>*/{
	
	//Atributos
	private char tipo;
	
	//Constructor por defecto
	public CartaPuebloDuerme(){
		tipo = ' ';
	}
	
	//Constructor con parámetros
	public CartaPuebloDuerme(char tipo){
		this.tipo = tipo;
	}
	
	//Constructor de copia
	public CartaPuebloDuerme(CartaPuebloDuerme cartaPuebloDuermeCopia){
		this.tipo = cartaPuebloDuermeCopia.getTipo();
	}
	
	//Gets
	public char getTipo(){
		return tipo;
	}
	
	//Métodos sobrescritos
	@Override
	public CartaPuebloDuerme clone(){

		CartaPuebloDuerme copia = null;
		
		try{
			copia = (CartaPuebloDuerme)super.clone();
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
			if(obj != null && obj instanceof CartaPuebloDuerme){
				CartaPuebloDuerme other = (CartaPuebloDuerme)obj;
				
				if(this.tipo == other.tipo){
					   
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
	
	/*public int compareTo(CartaPuebloDuerme1 cartaPuebloDuerme){
		
		int ret = 0;
		
		if(this != cartaPuebloDuerme && this.getTipo() > cartaPuebloDuerme.getTipo()){
			ret = 1;
		}
		else{
			if(this.getTipo() < cartaPuebloDuerme.getTipo()){
				ret = -1;
			}
		}
		
		return ret;
	}*/
	
	@Override
	public String toString(){
		String s = "Tipo de carta: " +getTipo();
		return s;
	}
	
	@Override
	public int hashCode(){
		return (182417 + getTipo() * 31);
	}
	
}

