package clase_20191021;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		//Persona p1 = new Persona();
		
		//p1.setNombre("Juan");
		//JOptionPane.showMessageDialog(null, p1.getNombre());
		
		//p1.ingresar();
		//JOptionPane.showMessageDialog(null, p1.mostrar());
		
		//Trabajador t1 = new Trabajador();
		
		//t1.ingresar();
		//JOptionPane.showMessageDialog(null, t1.mostrar());
		
		int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de trabajadores"));
		
		Trabajador t[] = new Trabajador[c];
		
		for (int i = 0; i < t.length; i++) {
			t[i] = new Trabajador();
			t[i].ingresar();
		}
		
		String out = "";
		for (int i = 0; i < t.length; i++) {
			out += t[i].mostrar();
			out += "-----------------------\n";
		}
		JOptionPane.showMessageDialog(null, out);
		
	}

}













