package clase_20191104;

import java.util.Random;

public class Mazo {
	Carta mazo[] = new Carta[40];
	int tope = 0;
	
	public Mazo() {
		int p = 0;
		int x = 1;
		for(int i=1; i<=12; i++) {
			if(i<=7 || i>=10) {
				mazo[p] = new Carta(i,"B", x);
				p++;				
				x++;
			}
		}
		x = 1;
		for(int i=1; i<=12; i++) {
			if(i<=7 || i>=10) {
				mazo[p] = new Carta(i,"E",x);
				p++;		
				x++;
			}
		}
		x = 1;
		for(int i=1; i<=12; i++) {
			if(i<=7 || i>=10) {
				mazo[p] = new Carta(i,"C",x);
				p++;			
				x++;
			}
		}
		x = 1;
		for(int i=1; i<=12; i++) {
			if(i<=7 || i>=10) {
				mazo[p] = new Carta(i,"O",x);
				p++;	
				x++;
			}
		}
	}

	public String mostrar() {
		String out = "";
		for(int p=0; p<mazo.length; p++) {
			out += mazo[p].mostrar();
		}
		
		return out;
	}
	
	public void barajar() {
		Random r = new Random();
		Carta aux = new Carta();
		
		for(int i=0; i<mazo.length; i++) {
			int a = r.nextInt(mazo.length);
			aux = mazo[i];
			mazo[i] = mazo[a];
			mazo[a] = aux;
		}
		
	}
	
	public Carta entregar() {
		Carta carta = mazo[tope];
		this.tope++;
		return carta;
	}



}











