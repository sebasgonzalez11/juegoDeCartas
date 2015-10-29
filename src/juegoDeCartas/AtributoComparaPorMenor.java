package juegoDeCartas;

public class AtributoComparaPorMenor extends Atributo{
	
	//Usa constructor de la clase Abstrasta que hereda
	public AtributoComparaPorMenor(String nombre, float valor) {
		super(nombre, valor);
	}
	
	//Implementa el Comparar por menor
	public int comparar(Atributo o) {
		int resultado=0;
		if(this.getValor()<o.getValor())
			resultado=1;
		if(this.getValor()>o.getValor())
			resultado= -1;
		return resultado;
	}
}