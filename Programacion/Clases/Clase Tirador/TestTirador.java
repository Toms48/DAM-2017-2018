public class TestTirador {
	
	public static void main (String[] args) {
		
		//Test conductores
		System.out.println(" ");
		System.out.println("*------------------------- Constructores -------------------------*");
		System.out.println(" ");
		
		Tirador tiradoPorDefecto = new Tirador();
		
		Persona Tomas = new Persona("Tomas", 19, "77859350-A", 'H', 70.0, 1.72);
		Persona Jorge = new Persona("Jorge", 19, "48124244-X", 'H', 68.0, 1.73);
		
		ArmaEsgrima espada = new ArmaEsgrima("PBT", "Espada", 'D');
		ArmaEsgrima florete = new ArmaEsgrima("AllStar", "Florete", 'I');
		
		Tirador tirador1 = new Tirador(Tomas, espada);
		Tirador tirador2 = new Tirador(Jorge, florete);
		
		System.out.println(" ");
		System.out.println("*------------------------- Gets y Sets -------------------------*");
		System.out.println(" ");
		
		System.out.println(tirador1.getPersona());
		
		System.out.println(" ");
		
		System.out.println(tirador1.getArma());
		
		System.out.println(" ");
		
		System.out.println(tirador2.getPersona());
		
		System.out.println(" ");
		
		System.out.println(tirador2.getArma());
		
	}
}

