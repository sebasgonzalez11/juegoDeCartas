package juegoDeCartas;
import java.util.*;

public class Mazo {
	private ArrayList<Carta> cartas;
	
	//Constructores
	public Mazo(){
		cartas=new ArrayList<Carta>();
	}
	public Mazo(ArrayList<Carta> cartas){
		if(this.sonValidas(cartas))
			this.cartas=cartas;
	}
	
	//METODO PRIVADO COMPRUEBA EL MAZO ANTES DE LA CONSTRUCCION
	private boolean sonValidas(ArrayList<Carta> cartas){
		Carta referencia=cartas.get(0);
		for(int i=1;i<cartas.size();i++){
			if(!referencia.equals(cartas.get(i))){
				System.out.println("No es posible crear el Mazo. Las cartas no son del mismo tipo.");
				return false;
			}
		}
		return true;
	}
	
	//Retorna la primer carta del mazo
	public Carta getPrimerCarta(){
		if(!this.isEmpty())
			return this.cartas.get(0);
		else return null;
	}
	
	//Remueve la primer Carta del ArrayList - Ojo
	public void removerCarta(){
		if(!this.isEmpty())
			this.cartas.remove(0);
		else
			System.out.println("EL MAZO ESTA VACIO");
	}
	
	//Agrega un Mazo a mi Mazo
	public void addPozo(Mazo mazoaux){
		for(int i=0; i<mazoaux.getCantidadCartas(); i++){
			this.cartas.add(mazoaux.getPrimerCarta());
			mazoaux.removerCarta();
		}			
	}
	
	//Devuelve el tamaño del ArrayList de Carta
	public int getCantidadCartas(){
			return this.cartas.size();
	}
	
	//Recibe una Carta y la agrega al Mazo
	public void addCarta(Carta o){
		if(this.isEmpty())
			this.cartas.add(o);
		else{
			if(this.getPrimerCarta().equals(o))
				this.cartas.add(o);
			else 
				System.out.println("LA CARTA QUE INTENTA AGREGAR NO ES DEL MISMO TIPO QUE LAS QUE ESTAN EN ESTE MAZO");
		}
	}

	//Recibe un int y devuelve un ArrayList con los mazos para cada jugador
	public ArrayList<Mazo> repartir(int nroMazos) {
		// Creo el arreglo de nuevos mazos
		ArrayList<Mazo> nuevosMazos = new ArrayList<>();
		for (int i=0;i<nroMazos;i++) {
			nuevosMazos.add(new Mazo());
		}
		// Mientras me queden cartas suficientes para repartir, 1 para cada mazo...
		while ((this.getCantidadCartas()>=nroMazos)){	
			// A cada uno de mis nuevos mazos le agrego una carta
			for (int i=0;i<nroMazos;i++) {
				nuevosMazos.get(i).addCarta(this.getPrimerCarta());
				this.removerCarta();
			}
		}
		//Devuelve el ArrayList con tantos mazos como jugadores
		return nuevosMazos;
	}
	
	//Devuelve true si no quedan cartas en el mazo
	public boolean isEmpty() {
		return this.getCantidadCartas()==0;
	}
	
	//Le pide a la primer carta el nombre de un atributo
	public String getAtributoRandom() {
		return this.getPrimerCarta().getAtributoRandom();
	}
	
	//Devuelve el nombre de la primer carta del mazo
	public String getNombrePrimeraCarta() {
		return this.getPrimerCarta().getNombre();
	}
	
}

