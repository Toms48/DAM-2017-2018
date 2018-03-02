/* Nombre: casilla
 * 
 * Básicas:
 * 		- mina        => boolean => Consultable
 * 		- bandera     => boolean => Consultable
 * 		- numero      => int     => Consultable y Modificable
 * 		- descubierto => boolean => Consultable y Modificable
 * 		- dibujo      => char    => Consultable y Modificable
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
 * GETTERS y SETTERS
 * 
 * boolean mina
 * 		- boolean getMina();
 * 		- void setMina(boolean mina);
 * 
 * boolean bandera
 * 		- boolean getBandera();
 * 		- void setBandera(boolean bandera);
 * 
 * int numero
 * 		- int getNumero();
 * 		- void setNumero(int numero);
 * 
 * boolean descubierto
 * 		- boolean getDescubierto();
 * 		- void setDescubierto(boolean descubierto);
 * 
 * char dibujo
 * 		- char getDibujo();
 * 		- char void setDibujo(char dibujo);
 */


public class casilla implements Cloneable {
	
	//Atributos
	private boolean mina;
	private boolean bandera;
	private boolean descubierto;
	private int numero;
	private char dibujo;
	
	//Constructor por defecto
	public casilla(){
		mina = false;
		bandera = false;
		descubierto = false;
		numero = 0;
		dibujo = ' ';
	}
	
	//Constructor con parámetros
	public casilla(boolean mina, boolean bandera, boolean descubierto, int numero, char dibujo){
		this.mina = mina;
		this.bandera = bandera;
		this.descubierto = descubierto;
		this.numero = numero;
		this. dibujo = dibujo;
	}
	
	//Constructor copia
	public casilla(casilla casillaCopia){
		this.mina = casillaCopia.getMina();
		this.bandera = casillaCopia.getBandera();
		this.descubierto = casillaCopia.getDescubierto();
		this.numero = casillaCopia.getNumero();
		this.dibujo = casillaCopia.getDibujo();
	}
	
	//Gets
	public boolean getMina(){
		return mina;
	}
	
	public boolean getBandera(){
		return bandera;
	}
	
	public boolean getDescubierto(){
		return descubierto;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public char getDibujo(){
		return dibujo;
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

	public void setMina(boolean mina){
		this.mina = mina;
	}

	public void setbandera(boolean bandera){
		this.bandera = bandera;
	}
	
	public void setDescubierto(boolean descubierto){
		this.descubierto = descubierto;
	}
	
	public void setDibujo(char dibujo) throws ExcepcionCasilla{
		if(dibujo!='*' && dibujo!='P' && dibujo!=' ' && dibujo!='■'){
			throw new ExcepcionCasilla("Solo valen los simbolos: *, P,  , ■");
		}
		else{
			this.dibujo = dibujo;
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
				   this.descubierto == other.descubierto &&
				   this.numero == other.numero &&
				   this.dibujo == other.dibujo){
					   
					ret = true;
					
				}
			}
		}
		return ret;
	}
	
	@Override
	public String toString(){
		String s = "Mina: " +getMina() +", " +"Bandera: " +getBandera() +", " +"Descubierto: " +getDescubierto() +", " +"Numero: " +getNumero() +", " +"Dibujo: ";
		
		return s;
	}
		
}

