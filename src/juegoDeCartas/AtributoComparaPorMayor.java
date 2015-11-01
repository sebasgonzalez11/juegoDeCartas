package juegoDeCartas;

public class AtributoComparaPorMayor extends Atributo {

	
	public AtributoComparaPorMayor(String nombre, float valor) {
		super(nombre, valor);
	}
	
	public int comparar(Atributo o) {
		System.out.print(this.toString()+" : "+o.toString());
		int resultado=0;
		if(this.getValor()>o.getValor())
			resultado=1;
		if(this.getValor()<o.getValor())
			resultado= -1;
		return resultado;
	}
	
	//
	public Atributo clone(){
		return new AtributoComparaPorMayor(this.getNombre(),this.getValor());
	}
}
