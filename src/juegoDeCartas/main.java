package juegoDeCartas;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Carta> cartasCargadas=new ArrayList<>();
		ArrayList<Atributo> atributos=new ArrayList<>();
		try{
			InputStream is=new FileInputStream("cartas.txt");
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String read=br.readLine();
			while(read!=null){
				String [] valores=read.split(",");
				for(int i=1; i<valores.length-2; i=i+3){
					String valorString=valores[i+1];
					float valor=Float.parseFloat(valorString);
					String boo=valores[i+2];
					boolean bool= Boolean.parseBoolean(boo);
					if(bool){
						AtributoComparaPorMayor a=new AtributoComparaPorMayor(valores[i], valor);
						atributos.add(a);
					}else{
						AtributoComparaPorMenor a=new AtributoComparaPorMenor(valores[i], valor);
						atributos.add(a);
					}
				}
				Carta c=new Carta(valores[0], atributos);
				cartasCargadas.add(c);
				atributos.clear();
				read=br.readLine();
			}
			br.close();
		}catch(Exception e){// aca va algo
		}
		Mazo mazo=new Mazo(cartasCargadas);
		Jugador j1=new Jugador("S Escribá");
		Jugador j2=new Jugador("S González");
		Juego juego=new Juego(j1,j2,mazo);
		//CREO LAS POCIMAS Y LAS AGREGO AL JUEGO
		for(int i=0;i<4;i++){
			PocionFactor p1=new PocionFactor("Kriptonita", (float)0.25);
			PocionSelectiva p2=new PocionSelectiva("altura", (float)1.25);
			PocionLimitada p3=new PocionLimitada((float)0.5, (float)0.25);
			PocionValorFijo p4=new PocionValorFijo((float)45);
			juego.addPocion(p1);
			juego.addPocion(p2);
			juego.addPocion(p3);
			juego.addPocion(p4);
		}
		
		PocionFactor p1=new PocionFactor("Kriptonita", (float)0.25);
		PocionSelectiva p2=new PocionSelectiva("altura", (float)1.25);
		PocionLimitada p3=new PocionLimitada((float)0.5, (float)0.25);
		PocionValorFijo p4=new PocionValorFijo((float)45);
		PocionCocktail p5=new PocionCocktail();
		p5.addPocion(p1);
		p5.addPocion(p2);
		p5.addPocion(p4);
		p5.addPocion(p3);
		juego.addPocion(p5);
		juego.jugar();
	}
}
