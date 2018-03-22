package Gestora;

import Clases.CartaPuebloDuerme;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class GestoraPuebloDuerme {

/**************************************************************************
Interfaz
Comentario: Repartirá 6 cartas aleatoriamente en las 6 posiciones del tablero
Cabecera: ArrayList <CartaPuebloDuerme> RepartirCartas()
Precondiciones: No tiene
Entrada: No hay
Salida: Un ArrayList (representando al tablero)
E/S: No hay
Postcondiciones: El ArrayList tendrá tamaño 6
**************************************************************************/
	public ArrayList <CartaPuebloDuerme> RepartirCartas(){

		Random random = new Random();
		int aleatorio;

		//Creo un array de tamaño 6 para las cartas que voy a utilizar
		ArrayList <CartaPuebloDuerme> array6Cartas = new ArrayList<CartaPuebloDuerme>(6);	//<CartaPuebloDuerme> para que no te de un warning, se le tiene que especificar el tipo de los objetos que vas a usar

		CartaPuebloDuerme lobo = new CartaPuebloDuerme('l');
		CartaPuebloDuerme pueblerino1 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino2 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino3 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino4 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino5 = new CartaPuebloDuerme('p');

		//Cargo ordenadamente el array de cartas con 6 cartas (un lobo y 5 campesinos)
		array6Cartas.add(0,lobo);
		array6Cartas.add(1,pueblerino1);
		array6Cartas.add(2,pueblerino2);
		array6Cartas.add(3,pueblerino3);
		array6Cartas.add(4,pueblerino4);
		array6Cartas.add(5,pueblerino5);

		//Creo un array de tamaño 6 para el tablero
		ArrayList <CartaPuebloDuerme> tablero = new ArrayList <CartaPuebloDuerme> (6);

		//Reparto las cartas del array ordenado de cartas al tablero desordenadamente
		for(int i=0; i<array6Cartas.size(); i++){

			aleatorio = random.nextInt(6);

			if(tablero.get(aleatorio) == null){  //Si en la posicion hay un null meto el objeto
				tablero.add(aleatorio, array6Cartas.get(i));
			}
			else{ //Sino vuelvo a entrar en el bucle for con el mismo numero de i, hasta meter el objeto en una posicion vacia (null)
				i--;
			}
		}

		return tablero;
	}


/**************************************************************************
Interfaz
Comentario: Subprograma que simulará el juego del Pueblo duerme
Cabecera: void JugarHombresLobo()
Precondiciones: No tiene
Entrada: No hay
Salida: No hay
E/S: No hay
Postcondiciones: No tiene
**************************************************************************/
	/*public void JugarHombresLobo(){
		
		int cantidadHL = 1;
		int cantidadCamp = 5;
		
		int contadorHL = 0;
		int contadorCamp = 0;
		
		int posicionLobo = 0;
		
		int aleatorio = 0;
		int victimaAleatorio = 0;
		
		boolean salirArray = false;
		
		ArrayList <CartaPuebloDuerme> array6Cartas = new ArrayList<CartaPuebloDuerme>(6);			//<CartaPuebloDuerme> para que no te de un warning, se le tiene que especificar el tipo de los objetos que vas a usar
		ArrayList <CartaPuebloDuerme> arrayTablero = new ArrayList <CartaPuebloDuerme> (6);

		CartaPuebloDuerme lobo = new CartaPuebloDuerme('l');

		CartaPuebloDuerme pueblerino1 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino2 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino3 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino4 = new CartaPuebloDuerme('p');
		CartaPuebloDuerme pueblerino5 = new CartaPuebloDuerme('p');

		array6Cartas.add(0,lobo);
		array6Cartas.add(1,pueblerino1);
		array6Cartas.add(2,pueblerino2);
		array6Cartas.add(3,pueblerino3);
		array6Cartas.add(4,pueblerino4);
		array6Cartas.add(5,pueblerino5);
		
		Random random = new Random();
		
		//Inicio
			//RepartirPersonajes
			/*do{
				if(array6Cartas.size() > 1){
					
					aleatorio = random.nextInt(array6Cartas.size()-1);
				
					arrayTablero.add(array6Cartas.get(aleatorio));
				
					array6Cartas.remove(aleatorio);
					
				}
				else{
				
					arrayTablero.add(array6Cartas.get(0));
					
					salirArray = true;
				}
				
				System.out.println(array6Cartas.size());	//Para comprobar que el tamaño del array va reduciendose
			}
			while(salirArray == false);
			
			//MostrarCartaJugador
			System.out.println(arrayTablero.get(0).toString());
			System.out.println(arrayTablero.get(0).equals(espada1));	//Para ver si el equals es true cuando al jugador le sale la carta de espada
			
			if(arrayTablero.get(0).equals(espada1) == true){
				
				arrayTablero.remove(0);
				
				while(arrayTablero.size() != 1){
					//NocheJugador*
					NocheJugador(arrayTablero);
					
					//DiaJugador*
				}
			}
			else{
				
				while(cantidadHL < cantidadCamp && cantidadHL != 0){
					
					for(int i=0; arrayTablero.get(i).equals(espada1) != true; i++){
						posicionLobo = i;
					}
					
					victimaAleatorio = random.nextInt(arrayTablero.size()-1);
					
					if(victimaAleatorio < posicionLobo){
						arrayTablero.remove(victimaAleatorio);
					}
					else{
						arrayTablero.remove(victimaAleatorio + 1);
					}
					
					for(Carta elemento : arrayTablero){
						
						if(elemento.getPalo() == 'b'){
							contadorCamp++;
						}
						else{
							contadorHL++;
						}
					}
					
				}
			}
		//Fin
	}*/
	
/**************************************************************************	
Interfaz
	Comentario: Simulará la noche cuando el jugador sea el lobo (espada1)
	Cabecera: ArrayList<Carta> NocheJugador(ArrayList <Carta> array)
	Precondiciones: en su primera iteracion el tamaño del array será 5, cada siguiente iteración será el tamaño del array - 1
	Entrada: No tiene
	Salida: No tiene
	E/S: Un ArrayList<Carta>
	Postcondiciones: el array tendrá el tamaño de entrada - 1
**************************************************************************/	
	
	/*public static ArrayList<Carta> NocheJugador(ArrayList<Carta> arrayTablero){
		
		int victima = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		//Inicio
			//PreguntarLeerValidarVictima
			do{
				for(int i=0; i < arrayTablero.size(); i++){
					//System.out.println(arrayTablero.get(i).toString());
					System.out.println("Victima " +(i+1) +" " +arrayTablero.get(i).getPalo() +arrayTablero.get(i).getNumero());
					
				}
				
				System.out.println(" ");
				
				System.out.println("Que victima quiere ejecutar?");
				System.out.print("Victima numero: ");
				
				victima = teclado.nextInt() - 1;
			}
			while(victima < 0 || victima > arrayTablero.size() - 1);
			
			//Matar victima
			arrayTablero.remove(victima);
			
		//Fin
		
		return arrayTablero;
	}*/
	
/**************************************************************************	
Interfaz
	Comentario: Simulará el día cuando el jugador sea el lobo (espada1)
	Cabecera: ArrayList<Carta> DiaJL(ArrayList <Carta> array)
	Precondiciones: ?
	Entrada: No tiene
	Salida: No tiene
	E/S: Un ArrayList<Carta>
	Postcondiciones: el array tendrá el tamaño de entrada - 1
**************************************************************************/

	/*public static void DiaJL(ArrayList <Carta> array){
		
		//Inicio
			//
		//Fin
		
	}*/
}

