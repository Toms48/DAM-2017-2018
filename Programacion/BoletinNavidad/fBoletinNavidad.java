public class fBoletinNavidad {
	
/**************************************************************************	
MT
	Nec: No hay
	Dev: No hay
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Imprime por pantalla el menú
	Cabecera: void MostrarMenu()
	Precondiciones: No hay
	Entrada: No hay
	Salida: No hay
	E/S: No hay
	Postcondiciones: No hay
**************************************************************************/

	public static void MostrarMenu(){
		
		System.out.println("Bienvenido al Boletin de Navidad");
		System.out.println(" ");
		System.out.println("1 ---> Caracter del alfabeto");
		System.out.println("2 ---> Numero Compuesto");
		System.out.println("3 ---> Numero Perfecto o Semiperfecto");
		System.out.println("4 ---> Numero Friki");
		System.out.println("5 ---> Numero Primo probable");
		System.out.println("6 ---> Numero Abundante");
		System.out.println("7 ---> Numero Deficiente");
		System.out.println("8 ---> Mensajillo gracioso");
		System.out.println("9 ---> Comparar fechas");
		System.out.println("10 ---> conv24hAmPm");
		System.out.println("11 ---> Dias transcurridos");
		
	}
	
	public static void ejercicio8(int numero){
		
		switch(numero){
			case 0:
				System.out.println(" ");
				System.out.println("Cero, soy el mas fiestero");
				System.out.println(" ");
			break;
			
			case 1:
				System.out.println(" ");
				System.out.println("Uno, me ducho que huelo a zorruno");
				System.out.println(" ");
			break;
			
			case 2:
				System.out.println(" ");
				System.out.println("Dos, no dejo de tener tos");
				System.out.println(" ");
			break;
			
			case 3:
				System.out.println("Tres, mi amigo es ingles");
			break;
			
			case 4:
				System.out.println("Cuatro, a tocar al teatro");
			break;
			
			case 5:
				System.out.println("Cinco, mi animal favorito es el ornitorrinco");
			break;
			
			case 6:
				System.out.println("Seis, las copas que me bebi de anis");
			break;

			case 7:
				System.out.println("Siete, toco la percusion pero tambien el clarinete");
			break;
			
			case 8:
				System.out.println("Ocho, cuando mientes te pareces a Pinocho");
			break;
			
			case 9:
				System.out.println("Nueve, esta rima es muy breve");
			break;
		}
		
	}
	
}
