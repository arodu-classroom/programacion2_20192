package clase_20191104;

public class Principal {

	public static void main(String[] args) {
		Mazo m = new Mazo();
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		
		m.barajar();
		
		for(int i=0; i<3; i++) {
			j1.recibir(m.entregar());
			j2.recibir(m.entregar());			
		}
		
		System.out.println("Jugador 1");
		System.out.println(j1.mostrar());
		
		System.out.println("Jugador 2");
		System.out.println(j2.mostrar());
		
	}

}
