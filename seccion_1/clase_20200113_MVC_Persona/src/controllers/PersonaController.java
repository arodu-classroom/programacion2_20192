package controllers;

import models.Persona;
import views.PersonaView;

public class PersonaController {
	Persona persona;
	PersonaView view;
	
	public PersonaController() {
		persona = new Persona();
		view = new PersonaView(this);
		view.display();
	}
	
	public void show() {
		view.show(persona.getNombre(), persona.getApellido(), persona.getTelefono());
	}
	
	public void save(String n, String a, String t) {
		persona.setNombre(n);
		persona.setApellido(a);
		persona.setTelefono(t);
		this.show();
	}

	public static void main(String[] args) {
		new PersonaController().show();

	}

}
