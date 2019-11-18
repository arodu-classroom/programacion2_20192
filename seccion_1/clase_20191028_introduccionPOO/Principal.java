package clase_20191028;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
	
		//Persona p = new Persona();
		//p.ingresar();
		//System.out.println(p.getNombre());
		//JOptionPane.showMessageDialog(null, p.mostrar()());
		
		//Trabajador t = new Trabajador();
		//t.ingresar();
		//JOptionPane.showMessageDialog(null, t.mostrar());
		
		int c = Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese cantidad de trabajadores"));
		
		Trabajador t[] = new Trabajador[c];
		
		for(int i=0; i<t.length; i++) {
			t[i] = new Trabajador();
			t[i].ingresar();
		}
		
		String out = "";
		for(int i=0; i<t.length; i++) {
			out += t[i].mostrar();
			out += "----------------\n";
		}
		JOptionPane.showMessageDialog(null, out);
		
		
	}

}










