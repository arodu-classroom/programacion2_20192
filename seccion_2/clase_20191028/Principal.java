package clase_20191028;

public class Principal {

	public static void main(String[] args) {
		Mazo m = new Mazo();
		m.barajar();
		
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		
		for(int i=0; i<3; i++) {
			j1.recibir(m.entregar());
			j2.recibir(m.entregar());
		}
		
		System.out.println("Jugador 1");
		j1.mostrar();
		
		System.out.println("Jugador 2");
		j2.mostrar();

	}

}
