public class Hora {
	
	//Atributos
	private int hora;
	private int minuto;
	private int segundo;
	
	//Constructor por defecto
	public Hora(){
		hora = 0;
		minuto = 0;
		segundo = 0;
	}
	
	//Constructor con 3 parámetros
	public Hora(int hora, int minuto, int segundo){
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}
	
	//Constructor de copia
	public Hora(Hora HoraCopia){
		this.hora = HoraCopia.getHora();
		this.minuto = HoraCopia.getMinuto();
		this.segundo = HoraCopia.getSegundo();
	}
	
	//GETS
	public int getHora(){
		return this.hora;
	}
	
	public int getMinuto(){
		return this.minuto;
	}
	
	public int getSegundo(){
		return this.segundo;
	}
	
	//SETS
	public void setHora(int hora){
		this.hora = hora;
	}
	
	public void setMinuto(int minuto){
		this.minuto = minuto;
	}
	
	public void setSegundo(int segundo){
		this.segundo = segundo;
	}
	
	//Métodos sobrescritos
	@Override
	public String toString(){
		String s = getHora() +":" +getMinuto() +":" +getSegundo();
		return s;
	}
	
}

