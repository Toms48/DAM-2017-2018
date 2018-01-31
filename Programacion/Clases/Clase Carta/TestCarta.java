public class TestCarta {
	
	public static void main (String[] args) {
		
		System.out.println(" ");
		System.out.println("*------------------- Constructores -------------------*");
		System.out.println(" ");
		
		//Constructor por defecto
		Carta cartaPorDefecto = new Carta();
		
		//Constructor con parámetros
		Carta oro1 = new Carta(1,1);
		Carta oro5 = new Carta(1,5);
		Carta oro12 = new Carta(1,12);
		
		Carta espada1 = new Carta(2,1);
		Carta espada2 = new Carta(2,2);
		Carta espada4 = new Carta(2,4);
		
		Carta copa1 = new Carta(3,1);
		Carta copa8 = new Carta(3,8);
		Carta copa3 = new Carta(3,3);
		
		Carta basto1 = new Carta(4,1);
		Carta basto7 = new Carta(4,7);
		Carta basto9 = new Carta(4,9);
		
		//Constructor de copia
		Carta oro1Copia = new Carta(oro1);
		
		System.out.println(" ");
		System.out.println("*------------------- Gets -------------------*");
		System.out.println(" ");
		
		System.out.println(oro1.getPalo());
		
		System.out.println(" ");
		
		System.out.println(oro1.getNumero());
		
		System.out.println(" ");
		System.out.println("*------------------- toString -------------------*");
		System.out.println(" ");
		
		System.out.println(oro1.toString());
		
		System.out.println(" ");
		
		System.out.println(oro5.toString());
		
		System.out.println(" ");
		
		System.out.println(oro12.toString());
		
		System.out.println(" ");
		
		System.out.println(espada1.toString());
		
		System.out.println(" ");
		
		System.out.println(espada2.toString());
		
		System.out.println(" ");
		
		System.out.println(espada4.toString());
		
		System.out.println(" ");
		
		System.out.println(copa1.toString());
		
		System.out.println(" ");
		
		System.out.println(copa8.toString());
		
		System.out.println(" ");
		
		System.out.println(copa3.toString());
		
		System.out.println(" ");
		
		System.out.println(basto1.toString());
		
		System.out.println(" ");
		
		System.out.println(basto7.toString());
		
		System.out.println(" ");
		
		System.out.println(basto9.toString());
		
		System.out.println(" ");
		System.out.println("*------------------- hashCode -------------------*");
		System.out.println(" ");
		
		System.out.println(oro1.hashCode());
		
		System.out.println(" ");
		
		System.out.println(oro5.hashCode());
		
		System.out.println(" ");
		
		System.out.println(oro12.hashCode());
		
		System.out.println(" ");
		
		System.out.println(espada1.hashCode());
		
		System.out.println(" ");
		
		System.out.println(espada2.hashCode());
		
		System.out.println(" ");
		
		System.out.println(espada4.hashCode());
		
		System.out.println(" ");
		
		System.out.println(copa1.hashCode());
		
		System.out.println(" ");
		
		System.out.println(copa8.hashCode());
		
		System.out.println(" ");
		
		System.out.println(copa3.hashCode());
		
		System.out.println(" ");
		
		System.out.println(basto1.hashCode());
		
		System.out.println(" ");
		
		System.out.println(basto7.hashCode());
		
		System.out.println(" ");
		
		System.out.println(basto9.hashCode());
		
		System.out.println(" ");
		System.out.println("*------------------- compareTo -------------------*");
		System.out.println(" ");
		
		System.out.println(basto1.compareTo(basto1));
		
		System.out.println(" ");
		
		System.out.println(copa3.compareTo(copa8));
		
		System.out.println(" ");
		
		System.out.println(espada4.compareTo(espada2));
		
		System.out.println(" ");
		System.out.println("*------------------- Equals -------------------*");
		System.out.println(" ");
		
		System.out.println(espada4.equals(espada4));
		
		System.out.println(" ");
		
		System.out.println(espada4.equals(espada2));
		
	}
}

