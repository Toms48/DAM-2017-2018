/* Nombre: casilla
 * 
 * Básicas:
 * 		- mina => boolean => Consultable y no Modificable
 * 		- bandera => boolean => Consultable y no Modificable
 * 		- numero => int => Consultable y Modificable
 * 
 * Derivadas: No tiene
 * 
 * Compartidas: No tiene
 * 
 * Restricciones:
 * 		- numero será un número mayor o igual que 0
 * 
 * Métodos añadidos:
 * 		- BanderaConMina
 * 
 * 
 * GETTERS y SETTERS
 * 
 * boolean mina
 * 		- boolean getMina();
 * 
 * boolean bandera
 * 		- boolean getBandera();
 * 
 * int numero
 * 		- int getNumero();
 * 		- void setNumero(int numero);
 */


public class casilla implements Cloneable {
	
	//Atributos
	private boolean mina;
	private boolean bandera;
	private int numero;
	
	//Constructor por defecto
	public casilla(){
		mina = false;
		bandera = false;
		numero = 0;
	}
	
	//Constructor con parámetros
	public casilla(boolean mina, boolean bandera, int numero){
		this.mina = mina;
		this.bandera = bandera;
		this.numero = numero;
	}
	
	public casilla(casilla casillaCopia){
		this.mina = casillaCopia.getMina();
		this.bandera = casillaCopia.getBandera();
		this.numero = casillaCopia.getNumero();
	}
	
	//Gets
	public boolean getMina(){
		return mina;
	}
	
	public boolean getBandera(){
		return bandera;
	}
	
	public int getNumero(){
		return numero;
	}
	
	//Sets
	public void setNumero(int numero) throws ExcepcionCasilla{
		if(numero < 0){
			throw new ExcepcionCasilla("El numero no puede ser menor que 0");
		}
		else{
			this.numero = numero;
		}
	}
	
	//Métodos sobrescritos
	@Override
	public casilla clone(){
		
		casilla copia = null;
		
		try{
			copia = (casilla)super.clone();
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
			if(obj != null && obj instanceof casilla){
				casilla other = (casilla)obj;
				
				if(this.mina == other.mina &&
				   this.bandera == other.bandera &&
				   this.numero == other.numero){
					   
					ret = true;
					
				}
			}
		}
		return ret;
	}
	
	@Override
	public String toString(){
		String s = "Mina: " +getMina() +", " +"Bandera: " +getBandera() +", " +"Numero: " +getNumero();
		
		return s;
	}
		
}

