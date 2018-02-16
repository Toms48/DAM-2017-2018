/*	TIPO DE DATO ELIPSE
 ************************
 *	
 *	Propiedades basicas
 * ---------------------
 *	int ancho, alto : Consultables y modificables.
 *	Punto centro : Consultable y modificable.
 *	Color colorRelleno, colorBorde : Consultables y modificables.
 *
 *	Propiedades derivadas
 * -----------------------
 * 	double area : Consultable.
 *
 *	Restricciones
 ******************
 * 	No hay restricciones ya que esta es una clase para explicar el overriding de los metodos de object, para centrarnos en ese tema.
 * 
 * 	INTERFAZ
 *************
 
    public int getAncho()
	public void setAncho(int ancho)
	
	public int getAlto()
	public void setAlto(int alto)
	
	public Punto getCentro() 
	public void setCentro(Punto centro)
	
	public Color getColorRelleno()
	public void setColorRelleno(Color colorRelleno)
	
	public Color getColorBorde()
	public void setColorBorde(Color colorBorde)
	
	public double getArea()
 
 */


//Geany es basura, que cosa mas fea, por esnupi ES NUPI XxSnoopy_87xX
public class Elipse implements Cloneable, Comparable<Elipse>{
	
	//Atributos
	private int ancho;
	private int alto;
	
	private Punto centro;
	private Color colorRelleno;
	private Color colorBorde;
	
	//Constructores
	
	public Elipse(Punto centro, int ancho, int alto) {
		
		this.centro = centro;
		this.ancho = ancho;
		this.alto = alto;
		this.colorRelleno = new Color(255);
		this.colorBorde = new Color(0);
		
	}
	
	public Elipse(Punto centro, int ancho, int alto, Color colorRelleno) {
		
		this.centro = centro;
		this.ancho = ancho;
		this.alto = alto;
		this.colorRelleno = colorRelleno;
		this.colorBorde = new Color(0);
		
	}
	
	public Elipse(Punto centro, int ancho, int alto, Color colorRelleno, Color colorBorde) {
		
		this.centro = centro;
		this.ancho = ancho;
		this.alto = alto;
		this.colorRelleno = colorRelleno;
		this.colorBorde = colorBorde;
		
	}
	
	//Getters y setters
	
	public int getAncho() { return ancho; }
	public void setAncho(int ancho) { this.ancho = ancho; }
	
	public int getAlto() { return alto; }
	public void setAlto(int alto) { this.alto = alto; }
	
	public Punto getCentro() { return centro; }
	public void setCentro(Punto centro) { this.centro = centro; }
	
	public Color getColorRelleno() { return colorRelleno; }
	public void setColorRelleno(Color colorRelleno) { this.colorRelleno = colorRelleno; }
	
	public Color getColorBorde() { return colorBorde; }
	public void setColorBorde(Color colorBorde) { this.colorBorde = colorBorde; }
	
	public double getArea() { return Math.PI * alto * ancho; }
	
	@Override
	public String toString() {
		
		return "Elipse [ancho=" + ancho + ", alto=" + alto + ", centro=" + centro + ", colorRelleno=" + colorRelleno
				+ ", colorBorde=" + colorBorde + "]";
		
	}
	
	@Override
	public int hashCode() {
		
		return ancho + 17 * alto + colorBorde.hashCode() + colorRelleno.hashCode() * 13 + centro.hashCode() * 21;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean ret = false;
		
		//1. Comprobamos que obj no es el mismo objeto (obj == this), si lo es, devolveremos true.
		if (this == obj) ret = true;
		
		//2. Comprobamos que obj no vale null (No esta instanciado) y que pertenece es el mismo tipo de dato, si no, devolvemos false.
		else if (obj != null && obj instanceof Elipse) {
			
			Elipse other = (Elipse)obj; //3. Casteamos obj al tipo de dato.
			
			//4. Comparamos los atributos uno a uno y si todos coinciden, devolvemos true
			if(this.alto == other.alto &&
			   this.ancho == other.ancho &&
			   this.centro != null && other.getCentro() != null && this.centro.equals(other.getCentro()) && //Si son objetos comprobamos primero que estan instanciados, para evitar nullPointerException
			   this.colorRelleno != null && other.getColorRelleno() != null && this.colorRelleno.equals(other.getColorRelleno()) &&
			   this.colorBorde != null && other.getColorBorde() != null && this.colorBorde.equals(other.getColorBorde())) {
				
				ret = true;
				
			}
			
		}
		
		return ret;
		
	}
	
	@Override
	public Elipse clone(){ //1. Implementamos la interface Cloneable a nuestra clase (Linea 34).
		
		Elipse copia = null; //2. Declaramos el objeto copia sin instanciarlo (Se queda a null).
		
		try {
			
			//3. Asignamos una copia del objeto a la variable de referencia con el método de Object (nos referimos a el con “super.”),
		    //y la casteamos a nuestro tipo de dato.
			
			copia = (Elipse)super.clone();
			
			//4. Si tenemos otros tipos de datos abstractos en los atributos de la clase y queremos hacer una deep copy del objeto, 
			//copiamos también esos atributos con sus respectivos métodos clone().
			
			copia.setCentro(this.centro.clone()); 
			copia.setColorBorde(this.colorBorde.clone());
			copia.setColorRelleno(this.colorRelleno.clone());
		
		}catch(CloneNotSupportedException error) { //5. Como puede lanzar una excepcion CloneNotSupportedException, la capturamos.
			
			System.out.println("Objeto no clonado, devuelve un null.");
			
		}
		
		return copia; //6. Devolvemos la copia.
		
	}
	
	@Override	
	public int compareTo(Elipse other) {
		
		int ret = 0;
		
		if(this != other && this.getArea() > other.getArea()) ret = 1;
		else if(this.getArea() < other.getArea()) ret = -1;
		
		return ret;
		
	}
	
}
