package clase_20191209;

public class Modelo {
	int turno;
	int tablero[];
	int p1=0, p2=0;
	
	public Modelo() {
		this.turno = 1;
		this.tablero = new int[9];
	}
	
	public void setPuntaje(int p) {
		if(p == 1) {
			p1++;
		}else if(p == 2) {
			p2++;
		}
	}
	
	public int getPuntaje(int p) {
		if(p == 1) {
			return p1;
		}else{
			return p2;
		}
	}
	
	public void inicio() {
		tablero = new int[9];
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
		if(turno==1) {
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
	
	public boolean isWinner() {
		int[][] check = {
		  {0,1,2},
		  {3,4,5},
		  {6,7,8},
		  {0,3,6},
		  {1,4,7},
		  {2,5,8},
		  {0,4,8},
		  {2,4,6}
		};
		
		for(int i=0; i < check.length; i++) {
			int[] l = check[i];
			if(tablero[l[0]]!=0 && tablero[l[0]]==tablero[l[1]] && tablero[l[1]] == tablero[l[2]]) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isFull() {
		for(int i=0; i < tablero.length; i++) {
			if(tablero[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
}













