package juegoDeCartas;
import java.util.*;

public class Carta{
	private String nombre;
	private Hashtable<String,Atributo> atributos;
	private Pocion pocima;
	
	public Carta(String nombre, ArrayList<Atributo> atributos){
		if(limiteDeAtributos(atributos)){
			this.nombre=nombre;
			this.atributos=new Hashtable<String, Atributo>();
			for(int i=0; i<atributos.size();i++){
				this.atributos.put(atributos.get(i).getNombre(), atributos.get(i));
			}
			pocima=new PocionFactor("Inocua",1);
		}
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	private Atributo getAtributo(String key){
		return atributos.get(key);
	}
	
	public int getCantidadDeAtributos(){
			return this.atributos.size();
	}
	
	public boolean equals(Carta o){
		if (this.getCantidadDeAtributos()==o.getCantidadDeAtributos()){
			for (Enumeration<String> llaves = atributos.keys();llaves.hasMoreElements();){
				String key=llaves.nextElement();
				if(!(o.atributos.containsKey(key))||!((this.atributos.get(key).equals(o.getAtributo(key))))){
					return false;
				}
			}return true;
		}else
			return false;
	}
	
	//
	public int comparar(String key, Carta o){
		return aplicarPocima(key).comparar(o.aplicarPocima(key));
	}
	//
	private Atributo aplicarPocima(String key){
		return pocima.getValor(this.getAtributo(key).clone());
	}
	
	
	//
	public String getClave(int a){
		ArrayList<String> nombreAtributos= new ArrayList<String>();
		Enumeration<String> llaves = atributos.keys();
		while (llaves.hasMoreElements())
		  nombreAtributos.add(llaves.nextElement());
		String key=nombreAtributos.get(a);
		return key;
	}
	
	private boolean limiteDeAtributos(ArrayList<Atributo> atributos){
		if((atributos.size()>=4)&&(atributos.size()<=7))
			return true;
		else{
			System.out.println("Los Atributos no cumplen las condiciones - MIN 4, MAX 7");
			return false;
		}
	}
	
	//
	public void setPocion(Pocion p1){
		this.pocima=p1;
	}
	//
	@Override
	public String toString(){
		Enumeration<Atributo> e=this.atributos.elements();
		String toStrAtri=new String();
		if(this.pocima!=null)
			toStrAtri=this.pocima.toString()+": {";
		while(e.hasMoreElements())
			toStrAtri+=e.nextElement().toString()+", ";
		return new String (this.nombre+" "+toStrAtri+"}");
	}
}
