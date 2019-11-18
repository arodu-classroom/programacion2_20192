package clase_20191118;

public class Controlador {

	Vista vista;
	Modelo modelo;
	
	public Controlador() {
		modelo = new Modelo();
		vista = new Vista(this);
		vista.mostrarTurno(modelo.getTurno());
	}
	
	public void jugada(int pos) {
		if(modelo.setJugada(pos)) {
			vista.mostrarJugada(pos, modelo.getTurno());
			modelo.cambiarTurno();
			vista.mostrarTurno(modelo.getTurno());
		}
		
	}
	
	public static void main(String[] args) {
		new Controlador();
	}

}
