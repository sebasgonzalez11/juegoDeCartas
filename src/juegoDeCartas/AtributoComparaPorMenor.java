package juegoDeCartas;

public class AtributoComparaPorMenor extends Atributo{
	

	public AtributoComparaPorMenor(String nombre, float valor) {
		super(nombre, valor);
	}
	
	public int comparar(Atributo o) {
		System.out.print(this.toString()+" : "+o.toString());
		int resultado=0;
		if(this.getValor()<o.getValor())
			resultado=1;
		if(this.getValor()>o.getValor())
			resultado= -1;
		return resultado;
	}
	
	//
	public Atributo clone(){
		return new AtributoComparaPorMenor(this.getNombre(),this.getValor());
	}
}