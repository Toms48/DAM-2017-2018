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
public class CartaPuebloDuerme implements Cloneable /*Comparable<CartaPuebloDuerme>*/{
	
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
	public String toString(){
		String s = "Tipo de carta: " +getTipo();
		return s;
	}
}

