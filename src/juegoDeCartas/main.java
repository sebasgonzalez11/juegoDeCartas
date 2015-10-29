package juegoDeCartas;

import java.io.*;
import java.util.ArrayList;


public class main {
	public static void main(String[] args) {
		ArrayList<Carta> cartasCargadas=new ArrayList<>();
		ArrayList<Atributo> atributos=new ArrayList<>();
		try{
			InputStream is=new FileInputStream("cartas.txt");
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String read=br.readLine();
			while(read!=null){
			//Separa los valores que esten delimitados por ","
				String [] valores=read.split(",");
			//Crea una nueva carta y le asigna el [] de Strings
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
		}catch(Exception e){
		}
		System.out.println(cartasCargadas.get(1).getCantidadDeAtributos());
		System.out.println(cartasCargadas.size());
		Mazo mazo=new Mazo(cartasCargadas);
		Jugador j1=new Jugador("S Escribá");
		Jugador j2=new Jugador("S González");
		Juego juego=new Juego(j1,j2,mazo);
		juego.jugar();
	}
}
