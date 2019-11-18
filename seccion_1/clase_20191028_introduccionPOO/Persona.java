package clase_20191028;

import javax.swing.JOptionPane;

public class Persona {
	private String nombre;
	private String apellido;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void ingresar() {
		this.setNombre( JOptionPane.showInputDialog(null, "Ingrese Nombre") );
		this.setApellido(JOptionPane.showInputDialog(null, "Ingrese Apellido"));
		this.setEdad( Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese Edad") ) );
	}
	
	public String mostrar() {
		String out;
		
		out = "Nombre: "+this.getNombre()+"\n";
		out += "Apellido: "+this.getApellido()+"\n";
		out += "Edad: "+this.getEdad()+"\n";
		
		return out;
	} 
	
}















