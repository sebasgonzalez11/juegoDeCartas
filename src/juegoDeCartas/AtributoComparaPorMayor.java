package juegoDeCartas;

public class AtributoComparaPorMayor extends Atributo {

	//Usa constructor de la clase Abstrasta que hereda
	public AtributoComparaPorMayor(String nombre, float valor) {
		super(nombre, valor);
	}
	
	//Implementa el Comparar por Mayor
	public int comparar(Atributo o) {
		int resultado=0;
		if(this.getValor()>o.getValor())
			resultado=1;
		if(this.getValor()<o.getValor())
			resultado= -1;
		return resultado;
	}
}
