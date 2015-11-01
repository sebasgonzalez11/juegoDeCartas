package juegoDeCartas;
import java.util.*;

public class Mazo {
	private ArrayList<Carta> cartas;
	

	public Mazo(){
		cartas=new ArrayList<Carta>();
	}
	public Mazo(ArrayList<Carta> cartas){
		if(this.sonValidas(cartas))
			this.cartas=cartas;
	}

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
	

	public Carta getPrimerCarta(){
		if(!this.isEmpty())
			return this.cartas.get(0);
		else return null;
	}
	

	public void removerCarta(){
		this.cartas.remove(0);
	}
	

	public void addPozo(Mazo mazoaux){
		while(!mazoaux.isEmpty()){
			this.cartas.add(mazoaux.getPrimerCarta());
			mazoaux.removerCarta();
		}		
	}
	
	
	public int getCantidadCartas(){
			return this.cartas.size();
	}
	

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

	//
	public ArrayList<Mazo> repartir(int nroMazos) {
		ArrayList<Mazo> nuevosMazos = new ArrayList<>();
		for (int i=0;i<nroMazos;i++) {
			nuevosMazos.add(new Mazo());
		}
		while ((this.getCantidadCartas()>=nroMazos)){	
			for (int i=0;i<nroMazos;i++) {
				nuevosMazos.get(i).addCarta(this.getPrimerCarta());
				this.removerCarta();
			}
		}
		return nuevosMazos;
	}
	
	//
	private Carta removeCartaRandom(){	
		return this.cartas.remove((int)(Math.random()*this.cartas.size()));
	}
	
	//
	public void imprimir(){
		for(int i=0;i<this.cartas.size();i++)
			System.out.println(this.cartas.get(i).toString()+"\n");
		System.out.println("Numero de cartas: "+this.cartas.size());
		System.out.println("");
	}
	
	//
	public void barajarMazo(){
		ArrayList<Carta> aux=new ArrayList<>();
		while(!this.isEmpty())
		aux.add(this.removeCartaRandom());
		this.cartas=aux;
	}
	
	
	public boolean isEmpty() {
		return this.getCantidadCartas()==0;
	}
	

	public String getClave(int a) {
		return this.getPrimerCarta().getClave(a);
	}
	

	public String getNombrePrimeraCarta() {
		return this.getPrimerCarta().getNombre();
	}
	
}

