package juegoDeCartas;

public class Jugador{
	private String nombre;
	private Mazo mazo;
	
	//Constructor
	public Jugador(String nombre){
		this.nombre=nombre;
		this.mazo=new Mazo();
	}
	
	//Devuelve el Nombre
	public String getNombre(){
		return this.nombre;
	}
	
	//Agrega las cartas de otro mazo a mi mazo
	public void addPozo(Mazo mazo) {
		this.mazo.addPozo(mazo);
	}
	
	//Le pide un atributo random al mazo que tiene las cartas
	public String getAtributoRandom(){
		return mazo.getAtributoRandom();
	}
	
	//Devuelve la primer carta del mazo
	public Carta getPrimerCarta(){
		return this.mazo.getPrimerCarta();
	}
	
	//Devuelve el nombre de la Primera Carta
	public String getNombrePrimeraCarta(){
		return this.mazo.getNombrePrimeraCarta();
	}
	
	//Agrega una carta al mazo del jugador
	public void addCarta(Carta o){
		this.mazo.addCarta(o);
	}
	
	//Remueve la primer carta del mazo del jugador
	public void removerCarta(){
		this.mazo.removerCarta();
	}
	
	//Devuelve si le quedan cartas en el mazo al jugador
	public boolean isEmpty(){
		return this.mazo.isEmpty();
	}
	
	public int jugar(String key, Jugador otro){
		switch (this.getPrimerCarta().comparar(key, otro.getPrimerCarta())) {
		
		// Ganó this
		case 1:
			System.out.println("Ganó: " + this.getNombre()+" <-- con la carta: "+this.getNombrePrimeraCarta()
			+" contra la Carta: "+otro.getNombrePrimeraCarta()+"\n");
			//AGREGO LA CARTA DEL JUGADOR GANADOR AL FINAL Y LA BORRO DE SU MAZO->
			this.addCarta(this.getPrimerCarta());
			this.removerCarta();
			//<--
			
			//AGREGO LA CARTA DEL JUGADOR PERDEDOR AL FINAL Y LA BORRO DE SU MAZO->
			this.addCarta(otro.getPrimerCarta());
			otro.removerCarta();
			//<--
			return 1; 
			
		// Gana el otro
		case -1:
			System.out.println("Ganó: " + otro.getNombre()+" <-- con la carta: "+otro.getNombrePrimeraCarta()
			+" contra la Carta: "+this.getNombrePrimeraCarta()+"\n");
			otro.addCarta(otro.getPrimerCarta());
			otro.removerCarta();
			otro.addCarta(this.getPrimerCarta());
			this.removerCarta();
			return -1;
			
		// Empate
		default:
			return 0;	
		}
	}
}
