package juegoDeCartas;

public class PocionValorFijo implements Pocion{
	private float factor;

	public PocionValorFijo(float factor){
		this.factor=factor;
	}
	
	public Atributo getValor(Atributo o){
		o.setValor(factor);
		return o;
	}
	
	@Override
	public String toString(){
		return new String("<"+"ValorFijo"+">");
	}
}
