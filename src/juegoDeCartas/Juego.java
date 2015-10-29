package juegoDeCartas;
import java.util.*;

public class Juego {
	private Jugador j1;
	private Jugador j2;
	private Mazo mazo;
	
	//Constructor
	public Juego(Jugador j1, Jugador j2, Mazo mazo){
			this.j1=j1;
			this.j2=j2;
			this.mazo=mazo;
	}
	
	//Llama al metodo de mazo, le asigna un mazo a cada jugador
	private void repartir(){ 
		ArrayList<Mazo> mazos = this.mazo.repartir(this.getNroJugadores());
		j1.addPozo(mazos.get(0));
		j2.addPozo(mazos.get(1));
	}
	
	//Duelve el número de jugadores, se crea el servicio en caso de en la próxima entrega haya más jugadores
	private int getNroJugadores() {
		return 2;
	}
	
	//Se desarrola el juego--->
	public void jugar(){
		try{
			repartir();
			//POZO EN EL QUE SE GUARDAN LAS CARTAS EN CASO DE EMPATE
			Mazo pozo=new Mazo();
			//EL JUGADOR 1 ELIGE EL ATRIBUTO
			String key=j1.getAtributoRandom();
			int ronda=0;
			
			//MIENTRAS LOS DOS JUGADORES TENGAN CARTAS--->
			while( (!j1.isEmpty()) && (!j2.isEmpty()) ){
				ronda++;
				System.out.print("Ronda "+ronda+" se compite con el atributo "+key+":--> ");
				 // 1 si gana j1, 0 si empatan, -1 si gana j2
				switch(j1.jugar(key,j2)){
				case 1: //Pregunto si hay cartas en el pozo, es decir si la mano anterior fué un empate
						if(!pozo.isEmpty())
							j1.addPozo(pozo);
						key=j1.getAtributoRandom();
						break;
						
				case -1: //GANA EL JUGADOR J2
						if(!pozo.isEmpty())
							j2.addPozo(pozo);
						//EL JUGADOR 2 AHORA ELIGE EL ATRIBUTO POR EL QUE SE COMPITE
						key=j2.getAtributoRandom();
						break;
						
				default:
						System.out.println("¡Ha sido un empate! Se juega otra ronda con el atributo: "+key+"\n");
						
						//NO HUBO GANADOR, NO SE CAMBIA EL ATRIBUTO Y LAS CARTAS JUGADAS VAN AL POZO
						pozo.addCarta(j1.getPrimerCarta());
						j1.removerCarta();
						pozo.addCarta(j2.getPrimerCarta());
						j2.removerCarta();
						break;
				}
			}
			//PREGUNTO SI AMBOS JUGADORES SE QUEDARON SIN CARTAS, SI ES ASI, DECLARO EMPATE
			if(j1.isEmpty()&&j2.isEmpty()){
				System.out.println("¡EL JUEGO SE HA EMPATADO!");
			}
			else{//SI EL JUGADOR 1 SE QUEDO SIN CARTAS GANO EL JUGADOR 2
				if(j1.isEmpty())
					System.out.println("¡HA GANADO EL JUGADOR: "+j2.getNombre()+"!");
				else//SINO GANO EL JUGADOR 1
					System.out.println("¡HA GANADO EL JUGADOR: "+j1.getNombre()+"!");
			}
		}catch(NullPointerException e){
			System.out.println("NO SE PUEDE DESARROLAR EL JUEGO");
		}
			
	}
}

