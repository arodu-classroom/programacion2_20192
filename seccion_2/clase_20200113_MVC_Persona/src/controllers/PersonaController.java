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
		//System.out.println(persona.getTelefono());
		
		view.show(persona.getNombre(), persona.getApellido(), persona.getTelefono());
	}
	
	public static void main(String[] args) {
		new PersonaController().show();

	}

}
