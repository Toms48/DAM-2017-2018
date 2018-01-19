
public class Prueba {

	public static void main(String[] args) {
		
		Punto punto1 = new Punto(1,2);
		Punto punto2 = new Punto(3,2);
		Elipse elipse1 = new Elipse(punto1, 30, 12);
		Elipse elipse2 = new Elipse(punto2, 35, 12);
		
		System.out.println(elipse1.equals(elipse2));
		
	}

}
