package juegoDeCartas;
public class Jugador{
	private String nombre;
	private Mazo mazo;
	
	public Jugador(String nombre){
		this.nombre=nombre;
		this.mazo=new Mazo();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void addPozo(Mazo mazo) {
		this.mazo.addPozo(mazo);
	}
	
	//
	public String getClave(){
		//linea que elige random el numero de atributo
		int a=((int)(Math.random()*(mazo.getPrimerCarta().getCantidadDeAtributos())));
		return mazo.getClave(a);
	
	}
	
	public Carta getPrimerCarta(){
		return this.mazo.getPrimerCarta();
	}
	
	public String getNombrePrimeraCarta(){
		return this.mazo.getNombrePrimeraCarta();
	}
	
	public void addCarta(Carta o){
		this.mazo.addCarta(o);
	}
	
	public void removerCarta(){
		this.mazo.removerCarta();
	}
	
	public boolean isEmpty(){
		return this.mazo.isEmpty();
	}
	
	public int jugar(String key, Jugador otro){
		return (this.getPrimerCarta().comparar(key, otro.getPrimerCarta()));
	}
}
