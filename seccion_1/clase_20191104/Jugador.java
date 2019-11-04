package clase_20191104;

public class Jugador {
	Carta mano[] = new Carta[3];
	int c = 0;
	
	public void recibir(Carta carta) {
		this.mano[c] = carta;
		c++;
	}
	
	public String mostrar() {
		String out="";
		for(int i=0; i<mano.length; i++) {
			out += mano[i].mostrar();
		}
		out += this.canto()+"\n";
		return out;
	}
	
	public String canto() {
		this.ordenar();		
		if(mano[0].getNum()==mano[1].getNum() && mano[1].getNum()==mano[2].getNum()) {
			return "Tribilin";
		}
		
		if(mano[0].getNum()==1 && mano[1].getNum()==11 && mano[2].getNum()==12) {
			return "Registro";
		}
		
		if(mano[0].getX()+1==mano[1].getX() && mano[1].getX()+1==mano[2].getX()) {
			return "Patrulla";
		}
		
		if(mano[0].getX()==mano[1].getX() && mano[1].getX()+1==mano[2].getX()) {
			return "Vigia";
		}
		
		if(mano[2].getX()==mano[1].getX() && mano[1].getX()-1==mano[0].getX()) {
			return "Vigia";
		}
		
		if(mano[0].getNum()==mano[1].getNum() && mano[2].getNum()!=mano[0].getNum()) {
			return "Ronda";
		}
		
		if(mano[2].getNum()==mano[1].getNum() && mano[0].getNum()!=mano[2].getNum()) {
			return "Ronda";
		}
		
		return "";
	}
	
	private void ordenar() {
		Carta aux = new Carta();
		for(int i=0; i<mano.length; i++) {
			for(int j=0; j<(mano.length-1); j++) {
				if(mano[i].getNum() < mano[j].getNum()) {
					aux = mano[i];
					mano[i] = mano[j];
					mano[j] = aux;
				}
			}
		}	
	}
	
	
}












