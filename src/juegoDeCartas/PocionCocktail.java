package juegoDeCartas;
import java.util.*;

public class PocionCocktail implements Pocion {
	private ArrayList<Pocion> pociones;
	
	public PocionCocktail(){
		pociones=new ArrayList<>();
	}

	public Atributo getValor(Atributo o) {
		for (int i=0;i<pociones.size();i++){
			pociones.get(i).getValor(o);
		}
		return o;
	}
	
	public void addPocion(Pocion p1){
		pociones.add(p1);
	}
	
	@Override
	public String toString(){
		return new String("<"+"Poción Cocktail"+">");
	}
}
