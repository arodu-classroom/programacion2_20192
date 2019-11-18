package clase_20191118;

public class Modelo {
	
	int turno;
	int tablero[];

	public Modelo() {
		turno = 1;
		tablero = new int[9];
		inicio();
	}
	
	public void inicio() {
		for(int i=0; i<9; i++) {
			tablero[i] = 0;
		}
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	public void cambiarTurno() {
		if(turno == 1) {
			turno = 2;
		}else {
			turno = 1;
		}
	}
	
	public boolean setJugada(int pos) {
		if(tablero[pos] == 0) {
			tablero[pos] = turno;
			return true;
		}
		
		return false;
	}
	
	
}











