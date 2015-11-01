package juegoDeCartas;

public abstract class Atributo{
	private String nombre;
	private float valor;
	
	public abstract int comparar(Atributo o);
	
	public Atributo(String nombre, float valor){
		this.nombre=nombre;
		this.valor=valor;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public float getValor(){
		return this.valor;
	}
	
	public void setValor(float valor){
		this.valor=valor;
	}
	
	public boolean equals(Atributo o){
		if(this.getNombre().equals(o.getNombre())&&(this.getClass().equals(o.getClass())))
			return true;
		else
			return false;
	}
	
	public abstract Atributo clone();
	
	@Override
	public String toString(){
		return new String("["+this.getNombre()+": "+this.getValor()+"]");
	}
}
