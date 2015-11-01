package juegoDeCartas;

public class PocionLimitada implements Pocion{
	private float factorUno;
	private float factorDos;
	private int usos;
/**
 * 
 * @param factor, Recordar poner el valor a incrementar de la forma "1,XX" para aumentar
 * y 0,XX para reducir.
 */
	public PocionLimitada(float factorUno, float factorDos){
		this.factorUno=factorUno;
		this.factorDos=factorDos;
		this.usos=3;
	}
	
	public Atributo getValor(Atributo o){
		if(this.usos==3){
			this.usos--;
			o.setValor(o.getValor()*factorUno);
			return o;
		}else if(this.usos==2){
			this.usos--;
			o.setValor(o.getValor()*factorDos);
			return o;
		}else{
			return o;
		}
		
	}
	
	@Override
	public String toString(){
		return new String("<"+"PociónLimitada"+">");
	}
}
