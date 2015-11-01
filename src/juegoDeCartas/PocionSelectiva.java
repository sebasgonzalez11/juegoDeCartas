package juegoDeCartas;

public class PocionSelectiva implements Pocion {
	private float factor;
	private String nombreAtri;


	public PocionSelectiva(String nombreAtri,float factor){
		this.nombreAtri=nombreAtri;
		this.factor=factor;
	}
	
	public Atributo getValor(Atributo o){
		if(o.getNombre().equals(this.nombreAtri)){
		 o.setValor(o.getValor()*this.factor);
		}	
			return o;
	}
	
	@Override
	public String toString(){
		return new String("<"+"PociónSelectiva: "+this.nombreAtri+">");
}
}