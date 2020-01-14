package models;

public class Persona {
	private String nombre="juan";
	private String apellido="hernandez";
	private String telefono="121232132";
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		System.out.println("Nombre guardado");
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
		System.out.println("Apellido guardado");
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		System.out.println("Telefono guardado");
	}

}













