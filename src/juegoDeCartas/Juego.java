package juegoDeCartas;
import java.util.*;

public class Juego {
	private Jugador j1;
	private Jugador j2;
	private Mazo mazo;
	private ArrayList<Pocion> pociones;
	
	public Juego(Jugador j1, Jugador j2, Mazo mazo){
			this.j1=j1;
			this.j2=j2;
			this.mazo=mazo;
			this.pociones=new ArrayList<>();
	}
	//
	public void addPocion(Pocion p1){
		pociones.add(p1);
	}
	
//
	private void repartir(){ 
		this.repartirPociones();
		this.mazo.barajarMazo();
		this.mazo.imprimir();
		ArrayList<Mazo> mazos = this.mazo.repartir(this.getNroJugadores());
		j1.addPozo(mazos.get(0));
		j2.addPozo(mazos.get(1));
		
	}
	//
	private void repartirPociones(){
		for(int i=0; i<pociones.size();i++){
			Carta aux=this.mazo.getPrimerCarta();
			this.mazo.removerCarta();
			aux.setPocion(this.pociones.get(i));
			this.mazo.addCarta(aux);
		}
	}
	
	private int getNroJugadores() {
		return 2;
	}
	
	public void jugar(){
		try{
			repartir();
			Mazo pozo=new Mazo();
			String key=j1.getClave();
			int ronda=0;
			while( (!j1.isEmpty()) && (!j2.isEmpty()) ){
				ronda++;
				System.out.print("Ronda "+ronda+" Atributo "+key+":-> ");
				switch(j1.jugar(key,j2)){
				case 1:	
					System.out.println("-> Ganó: " + j1.getNombre()+" <-- con la carta: "+j1.getNombrePrimeraCarta()
					+" contra la Carta: "+j2.getNombrePrimeraCarta()+"\n");
					j1.addCarta(j1.getPrimerCarta());
					j1.removerCarta();
					j1.addCarta(j2.getPrimerCarta());
					j2.removerCarta(); 
					if(!pozo.isEmpty())
						j1.addPozo(pozo);
					key=j1.getClave();
					break;

				case -1:
					System.out.println("Ganó: " + j2.getNombre()+" <-- con la carta: "+j2.getNombrePrimeraCarta()
					+" contra la Carta: "+j1.getNombrePrimeraCarta()+"\n");
					j2.addCarta(j2.getPrimerCarta());
					j2.removerCarta();
					j2.addCarta(j1.getPrimerCarta());
					j1.removerCarta();
					if(!pozo.isEmpty())
						j2.addPozo(pozo);
					key=j2.getClave();
					break;
						
				default:
					System.out.println("¡Ha sido un empate! Se juega otra ronda con el atributo: "+key+"\n");
					pozo.addCarta(j1.getPrimerCarta());
					j1.removerCarta();
					pozo.addCarta(j2.getPrimerCarta());
					j2.removerCarta();
					break;
				}
			}
			
			if(j1.isEmpty()&&j2.isEmpty()){
				System.out.println("¡EL JUEGO SE HA EMPATADO!");
			}
			else{
				if(j1.isEmpty())
					System.out.println("¡HA GANADO EL JUGADOR: "+j2.getNombre()+"!");
				else
					System.out.println("¡HA GANADO EL JUGADOR: "+j1.getNombre()+"!");
			}
		}catch(NullPointerException e){
			System.out.println("NO SE PUEDE DESARROLAR EL JUEGO");
		}
			
	}
}

