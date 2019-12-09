package clase_20191209;

import java.util.Random;

public class Controlador {
	
	Modelo modelo;
	Vista vista;
	boolean contra_pc = false;

	public Controlador() {
		modelo = new Modelo();
		vista = new Vista(this);
		vista.cambiarTurno(modelo.getTurno());
	}
	
	public void nuevo() {
		contra_pc = false;
		modelo.inicio();
		vista.nuevo();
	}
	
	public void pc() {
		nuevo();
		contra_pc = true;
	}

	public boolean jugada(int pos) {
		if(modelo.setJugada(pos)) {
			vista.mostrarJugada(pos, modelo.getTurno());
			
			if(modelo.isWinner()) {
				vista.mensaje("Ganador jugador "+modelo.getTurno());
				modelo.setPuntaje(modelo.getTurno());
				this.nuevo();
			}else {
				if(modelo.isFull()) {
					vista.mensaje("No hay ganador");
					this.nuevo();
				}
				modelo.cambiarTurno();
				vista.cambiarTurno(modelo.getTurno());
			}
			this.ia();
			return true;
		}
		return false;
	}
	
	public void ia() {
		if(contra_pc==true && modelo.getTurno() == 2) {
			Random r = new Random();
			int pos;
			do {
				pos = r.nextInt(9);
			}while( !this.jugada(pos) );
		}	
	}
	
	public void puntos() {
		String out = "Jugador 1: "+modelo.getPuntaje(1)+"\nJugador 2: "+modelo.getPuntaje(2);
		vista.mensaje(out);
	}
	
	public static void main(String[] args) {
		new Controlador();
	}

}







