package clase_20191209;

import java.util.Random;

public class Controlador {

	Vista vista;
	Modelo modelo;
	boolean contra_pc = false;
	
	public Controlador() {
		modelo = new Modelo();
		vista = new Vista(this);
		vista.mostrarTurno(modelo.getTurno());
	}
	
	public void nuevo() {
		this.contra_pc = false;
		modelo.inicio();
		vista.nuevoJuego();
	}
	
	public void pc() {
		this.nuevo();
		this.contra_pc = true;
	}
	
	public boolean jugada(int pos) {
		if(modelo.setJugada(pos)) {
			vista.mostrarJugada(pos, modelo.getTurno());
			if(modelo.esGanador()) {
				modelo.setPuntaje(modelo.getTurno());
				vista.mensaje("Ganador jugador "+modelo.getTurno()+"\n\n"+this.puntaje());
				this.nuevo();
			}else {
				if(modelo.isFull()) {
					vista.mensaje("No hay ganador");
					this.nuevo();
				}
				modelo.cambiarTurno();
				vista.mostrarTurno(modelo.getTurno());
			}
			
			this.automatico();
			
			return true;
		}
		return false;
	}
	
	public void automatico() {
		if(contra_pc==true && modelo.getTurno()==2) {
			
			/*
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			Random r = new Random();
			int pos;
			do {
				pos = r.nextInt(9);
			}while( !this.jugada(pos) );
		}
	}
	
	public String puntaje() {
		return "Jugador 1: "+modelo.getPuntaje(1)+"\nJugador 2: "+modelo.getPuntaje(2);
	}
	
	public static void main(String[] args) {
		new Controlador();
	}

}










