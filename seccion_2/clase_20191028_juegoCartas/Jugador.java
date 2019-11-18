package clase_20191028;

public class Jugador {
	Carta mano[] = new Carta[3];
	int c = 0;
	
	public void recibir(Carta carta) {
		mano[c] = carta;
		c++;
	}
	
	public void mostrar() {
		for(int i=0; i<c; i++) {
			System.out.println(mano[i].mostrar());
		}
		System.out.println(this.canto());
		System.out.println("------------------\n");
	}
	
	public String canto() {
		this.ordenar();
		
		if(mano[0].getNum() == mano[1].getNum() && mano[1].getNum() == mano[2].getNum()) {
			return "Tribilin";
		}
		
		if(mano[0].getNum() == 1 && mano[1].getNum()==11 && mano[2].getNum()==12) {
			return "Registro";
		}
		
		if(mano[0].getX() == mano[1].getX() && mano[1].getX()+1==mano[2].getX()) {
			return "Vigia";
		}
		
		if(mano[0].getX() == mano[1].getX() && mano[1].getX()-1==mano[2].getX()) {
			return "Vigia";
		}
		
		if(mano[1].getX() == mano[2].getX() && mano[1].getX()+1==mano[0].getX()) {
			return "Vigia";
		}
		
		if(mano[1].getX() == mano[2].getX() && mano[1].getX()-1==mano[0].getX()) {
			return "Vigia";
		}
		
		if(mano[0].getNum()==mano[1].getNum() && mano[2].getNum() != mano[0].getNum()) {
			return "Ronda";
		}
		
		if(mano[1].getNum()==mano[2].getNum() && mano[0].getNum() != mano[1].getNum()) {
			return "Ronda";
		}
		
		if(mano[0].getX()+1 == mano[1].getX() && mano[1].getX()+1==mano[2].getX()) {
			return "Patrulla";
		}
		
		return "";
	}
	
	
	public void ordenar() {
		Carta aux = new Carta();
		
		for(int i=0; i < mano.length; i++) {
			for(int j=0; j < (mano.length-1); j++ ) {
				if(mano[i].getNum() < mano[j].getNum()) {
					aux = mano[i];
					mano[i] = mano[j];
					mano[j] = aux;
				}
			}
		}
		
	}	
}












