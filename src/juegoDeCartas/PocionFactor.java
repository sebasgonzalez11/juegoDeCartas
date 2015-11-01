package juegoDeCartas;

public class PocionFactor implements Pocion{
	private float factor;
	private String nombre;
/**
 * 
 @param factor, Recordar poner el valor de la forma "1,XX" para aumentar
 * y 0,XX para reducir.
 */
	public PocionFactor(String nombre, float factor){
		this.nombre=nombre;
		this.factor=factor;
	}
	
	public Atributo getValor(Atributo o){
		o.setValor(o.getValor()*this.factor);
		return o;
	}
	
	@Override
	public String toString(){
		return new String("<"+this.nombre+">");
	}
}
