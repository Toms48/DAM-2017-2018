public class TestTirador {
	
	public static void main (String[] args) {
		
		//Test conductores
		System.out.println(" ");
		System.out.println("*------------------------- Constructores -------------------------*");
		System.out.println(" ");
		
		//Constructor por defecto
		Tirador tiradorPorDefecto = new Tirador();
		
		//Constructores con parámetros de persona y armaEsgrima
		Persona Tomas = new Persona("Tomas", 19, "77859350-A", 'H', 70.0, 1.72);
		Persona Jorge = new Persona("Jorge", 19, "48124244-X", 'H', 68.0, 1.73);
		
		ArmaEsgrima sable = new ArmaEsgrima("Insignia", "Sable", 'D');
		ArmaEsgrima florete = new ArmaEsgrima("AllStar", "Florete", 'I');
		ArmaEsgrima espada = new ArmaEsgrima("PBT", "Espada", 'D');
		
		//Constructor con parámetros
		Tirador tirador1 = new Tirador(Tomas, sable);
		Tirador tirador2 = new Tirador(Jorge, florete);
		
		//Constructor de copia
		Tirador tirador1Copia = new Tirador(tirador1);
		
		System.out.println(" ");
		System.out.println("*------------------------- Gets y Sets -------------------------*");
		System.out.println(" ");
		
		//Gets
		System.out.println("*----- Gets del tirador 1 -----*");
		
		System.out.println(tirador1.getPersona());
		
		System.out.println(" ");
		
		System.out.println(tirador1.getArma());
		
		System.out.println(" ");
		
		System.out.println("*----- Gets del tirador 1 copia -----*");
		
		System.out.println(tirador1Copia.getPersona());
		
		System.out.println(" ");
		
		System.out.println(tirador1Copia.getArma());
		
		System.out.println(" ");
		
		//Sets
		System.out.println("*----- Set del arma del tirador 1 -----*");
		
		tirador1.setArma(espada);
		System.out.println(tirador1.getArma());
		
		System.out.println(" ");
		
		System.out.println("*----- Set del arma del tirador 2 -----*");
		
		tirador2.setArma(sable);
		System.out.println(tirador2.getArma());
		
		System.out.println(" ");
		System.out.println("*------------------------- toString -------------------------*");
		System.out.println(" ");
		
		System.out.println(tirador2.toString());
		
		System.out.println(" ");
		
		System.out.println(tirador1Copia.toString());
		
		System.out.println(" ");
		
		System.out.println(tiradorPorDefecto.toString());
		
		System.out.println(" ");
		System.out.println("*------------------------- Clone -------------------------*");
		System.out.println(" ");
		
		System.out.println(tirador2.toString());
		
		System.out.println(" ");
		
		System.out.println(tirador2.clone());
		
		System.out.println(" ");
		System.out.println("*------------------------- Equals -------------------------*");
		System.out.println(" ");
		
		System.out.println("Tirador1 y Tirador2: " +tirador1.equals(tirador2));
		
		System.out.println(" ");
		
		System.out.println("Tirador1 y Tirador1: " +tirador1.equals(tirador1));
		
		System.out.println(" ");
		
		System.out.println("TiradorPorDefecto y Tirador2: " +tiradorPorDefecto.equals(tirador2));
		
		System.out.println(" ");
		System.out.println("*------------------------- hashCode -------------------------*");
		System.out.println(" ");
		
		System.out.println("hashCode tirador1: " +tirador1.hashCode());
		
		System.out.println(" ");
		
		System.out.println("hashCode tirador2: " +tirador2.hashCode());
		
		System.out.println(" ");
		System.out.println("*------------------------- Array -------------------------*");
		System.out.println(" ");
		
		Tirador [] arrayTiradores = new Tirador [2];
		
		arrayTiradores [0] = tirador1;
		arrayTiradores [1] = tirador2;
		
		/*System.out.println(arrayTiradores [0]);
		
		System.out.println(" ");
		
		System.out.println(arrayTiradores [1]);
		
		System.out.println(" ");
		System.out.println(" ");*/
		
		for(int i=0; i < arrayTiradores.length; i++){
			
			System.out.println(arrayTiradores [i]);
			System.out.println(" ");
			
		}
		
	}
}

