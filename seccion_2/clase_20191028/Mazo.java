package clase_20191028;

import java.util.Random;

public class Mazo {
	Carta mazo[] = new Carta[40];
	int tope = 0;
	
	public Mazo() {
		
		int c = 0;
		int x = 1;
		for(int i=1; i<=12; i++) {
			if(i < 8 || i > 9) {
				mazo[c] = new Carta(i,"B", x);
				c++;
				x++;
			}
		}
		
		x = 1;
		for(int i=1; i<=12; i++) {
			if(i < 8 || i > 9) {
				mazo[c] = new Carta(i,"E", x);
				c++;
				x++;
			}
		}
		
		x = 1;
		for(int i=1; i<=12; i++) {
			if(i < 8 || i > 9) {
				mazo[c] = new Carta(i,"C", x);
				c++;
				x++;
			}
		}
		
		x = 1;
		for(int i=1; i<=12; i++) {
			if(i < 8 || i > 9) {
				mazo[c] = new Carta(i,"O", x);
				c++;
				x++;
			}
		}
		
	}
	
	public void mostrar() {
		
		for(int c=0; c<mazo.length; c++) {
			System.out.println(mazo[c].mostrar());
		}
	
	}
	
	public void barajar() {
		Random r = new Random();
		Carta aux = new Carta();
		
		for(int i=0; i<mazo.length; i++) {
			int h = r.nextInt(mazo.length);
			aux = mazo[i];
			mazo[i] = mazo[h];
			mazo[h] = aux;
		}
		
	}
	
	public Carta entregar() {
		Carta aux = mazo[tope];
		tope++;
		
		return aux;
	}
	
	
}
