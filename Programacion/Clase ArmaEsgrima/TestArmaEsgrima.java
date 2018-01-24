public class TestArmaEsgrima {
	
	public static void main (String[] args) {
		
		System.out.println(" ");
		System.out.println("*------------------- Constructores -------------------*");
		System.out.println(" ");
		
		//Constructor por defecto
		ArmaEsgrima armaPordefecto = new ArmaEsgrima();
		
		//Constructores con parámetros
		ArmaEsgrima espada = new ArmaEsgrima("AllStar", "Espada", 'D');
		ArmaEsgrima florete = new ArmaEsgrima("PBT", "Florete", 'Z');
		ArmaEsgrima sable = new ArmaEsgrima("Insignia", "Sable", 'D');
		
		//Constructor copia
		ArmaEsgrima espadaCopia = new ArmaEsgrima(espada);
		
		//Tests Gets
		System.out.println(" ");
		System.out.println("*------------------- Gets -------------------*");
		System.out.println(" ");
		
		System.out.println("Marca del objeto espada: " +espada.getMarca());
		System.out.println("Tipo del objeto espada: " +espada.getTipo());
		System.out.println("Mano buena del objeto espada: " +espada.getManoBuena());
		
		System.out.println("");
		
		System.out.println("");
		System.out.println("Marca del objeto florete: " +florete.getMarca());
		System.out.println("Tipo del objeto florete: " +florete.getTipo());
		System.out.println("Mano buena del objeto florete: " +florete.getManoBuena());
		
		System.out.println("");
		
		System.out.println("");
		System.out.println("Marca del objeto sable: " +sable.getMarca());
		System.out.println("Tipo del objeto sable: " +sable.getTipo());
		System.out.println("Mano buena del objeto sable: " +sable.getManoBuena());
		
		System.out.println(" ");
		
		//Tests Set
		System.out.println(" ");
		System.out.println("*------------------- Sets -------------------*");
		System.out.println(" ");
		
		try{
			espada.setManoBuena('S');
		}
		catch(ExcepcionArmaEsgrima mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Mano buena del objeto espada: " +espada.getManoBuena());
		
		System.out.println(" ");
		
		try{
			florete.setManoBuena('d');
		}
		catch(ExcepcionArmaEsgrima mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Mano buena del objeto florete: " +florete.getManoBuena());
		
		System.out.println(" ");
		
		try{
			sable.setManoBuena('z');
		}
		catch(ExcepcionArmaEsgrima mensaje){
			System.out.println(mensaje);
		}
		System.out.println("Mano buena del objeto sable: " +sable.getManoBuena());
		
		//Tests toString
		System.out.println(" ");
		System.out.println("*------------------- toString -------------------*");
		System.out.println(" ");
		
		System.out.println(espada.toString());
		
		System.out.println(" ");
		
		System.out.println(florete.toString());
		
		System.out.println(" ");
		
		System.out.println(sable.toString());
		
		System.out.println(" ");
		
		System.out.println(espadaCopia.toString());
		
		//Tests hashCode
		System.out.println(" ");
		System.out.println("*------------------- hashCode -------------------*");
		System.out.println(" ");
		
		System.out.println(espada.hashCode());
		
		System.out.println(" ");
		
		System.out.println(florete.hashCode());
		
		System.out.println(" ");
		
		System.out.println(sable.hashCode());
		
		System.out.println(" ");
		
		System.out.println(espadaCopia.hashCode());
		
		//Tests equals
		System.out.println(" ");
		System.out.println("*------------------- equals -------------------*");
		System.out.println(" ");
		
		System.out.println("Espada y EspadaCopia: " +espada.equals(espadaCopia));
		
		System.out.println(" ");
		
		System.out.println("Espada y Espada: " +espada.equals(espada));
		
		System.out.println(" ");
		
		System.out.println("Espada y Florete: " +espada.equals(florete));
		
		System.out.println(" ");
		
		System.out.println("Sable y EspadaCopia: " +sable.equals(espadaCopia));
		
		System.out.println(" ");
		
		System.out.println("Florete y Florete: " +florete.equals(florete));
		
	}
}

