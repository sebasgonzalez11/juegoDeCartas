package juegoDeCartas;
import java.util.*;

public class Carta{
	private String nombre;
	private Hashtable<String,Atributo> atributos;
	
	//Constructores
	public Carta(String nombre, ArrayList<Atributo> atributos){
		if(limiteDeAtributos(atributos)){
			this.nombre=nombre;
			this.atributos=new Hashtable<String, Atributo>();
			for(int i=0; i<atributos.size();i++){
				this.atributos.put(atributos.get(i).getNombre(), atributos.get(i));
			}
		}
	}
	
	//Devulve el nombre de la carta
	public String getNombre(){
		return this.nombre;
	}
	
	//METODO PRIVADO - Devuelve un Atributo diciendo cual es la KEY de la Hashtable
	private Atributo getAtributo(String key){
		return atributos.get(key);
	}
	
	//Devuelve el tamaño de la Hashtable
	public int getCantidadDeAtributos(){
		try{
			return this.atributos.size();
		}catch(NullPointerException e){
			return 0;
		}
	}
	
	//Compara si dos cartas son iguales
	//IGUAL CANTIDAD DE ATRIBUTOS Y MISMA CLASE
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
	
	//Compara que carta es Mayor
	public int comparar(String key, Carta o){
		int resultado=this.atributos.get(key).comparar(o.atributos.get(key));
				return resultado;
	}
	
	//Devuelve el Key de un Atributo random
	public String getAtributoRandom(){
		ArrayList<String> nombreAtributos= new ArrayList<String>();
		Enumeration<String> llaves = atributos.keys();
		while (llaves.hasMoreElements())
		  nombreAtributos.add(llaves.nextElement());
		String key=nombreAtributos.get((int)(Math.random()*(getCantidadDeAtributos())));
		return key;
	}
	
	//Controla el tamaño de la Hastable, que respete un min de 4 y un max de 7 atributos
	private boolean limiteDeAtributos(ArrayList<Atributo> atributos){
		if((atributos.size()>=4)&&(atributos.size()<=7))
			return true;
		else{
			System.out.println("Los Atributos no cumplen las condiciones - MIN 4, MAX 7");
			return false;
		}
	}
}
