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
	public Hora(int hora, int minuto, int segundo) throws ExcepcionHora{
		
		if(hora >= 0 && hora <= 23){
			
			if(minuto >= 0 && minuto <= 59){
				
				if(segundo >= 0 && segundo <= 59){
					this.hora = hora;
					this.minuto = minuto;
					this.segundo = segundo;
				}
				else{
					throw new ExcepcionHora("Segundos mal introducidos");
				}
			}
			else{
				throw new ExcepcionHora("Minutos mal introducidos");
			}
			
		}
		else{
			throw new ExcepcionHora("Hora mal introducida");
		}
		
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
	public void setHora(int hora) throws ExcepcionHora{
		if(hora >= 0 && hora <= 23){
			this.hora = hora;
		}
		else{
			throw new ExcepcionHora("Hora mal introducida");
		}
	}
	
	public void setMinuto(int minuto) throws ExcepcionHora{
		if(minuto >= 0 && minuto <= 59){
			this.minuto = minuto;
		}
		else{
			throw new ExcepcionHora("Minutos mal introducidos");
		}
		
	}
	
	public void setSegundo(int segundo) throws ExcepcionHora{
		if(segundo >= 0 && segundo <= 59){
			this.segundo = segundo;
		}
		else{
			throw new ExcepcionHora("Segundos mal introducidos");
		}
		
	}
	
	//Métodos sobrescritos
	@Override
	public String toString(){
		String s = getHora() +":" +getMinuto() +":" +getSegundo();
		return s;
	}
	
	@Override
	public int hashCode(){
		return ((int) (getHora() * 7 + getSegundo() * 33 * 21 * getMinuto() + getMinuto()));
	}
	
	@Override
	public boolean equals(Object obj){
		boolean ret = false;
		
		if(this == obj){
			ret = true;
		}
		else if(obj != null && obj instanceof Elipse){
			
		}
		
		return ret;

	}
	
}

