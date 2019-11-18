package clase_20191118;

public class Controlador {
	
	Modelo modelo;
	Vista vista;

	public Controlador() {
		modelo = new Modelo();
		vista = new Vista(this);
		vista.cambiarTurno(modelo.getTurno());
	}

	public void jugada(int pos) {
		if(modelo.setJugada(pos)) {
			vista.mostrarJugada(pos, modelo.getTurno());
			modelo.cambiarTurno();
			vista.cambiarTurno(modelo.getTurno());
		}
	}
	
	public static void main(String[] args) {
		new Controlador();
	}

}
