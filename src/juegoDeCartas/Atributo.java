package juegoDeCartas;

public abstract class Atributo {
	private String nombre;
	private float valor;
	
	//Métodos abstractos
	public abstract int comparar(Atributo o);
	
	//Constructor
	public Atributo(String nombre, float valor){
		this.nombre=nombre;
		this.valor=valor;
	}
	
	//Devuelve el nombre del Atributo
	public String getNombre(){
		return this.nombre;
	}
	
	//Devuelve el valor del atributo
	public float getValor(){
		return this.valor;
	}
	
	//Dado otro atributo por parámetro, devuelve true si es =, ó false si es distinto
	//COMPARA MISMO NOMBRE Y MISMA CLASE
	public boolean equals(Atributo o){
		if(this.getNombre().equals(o.getNombre())&&(this.getClass().equals(o.getClass())))
			return true;
		else
			return false;
	}
	
}
