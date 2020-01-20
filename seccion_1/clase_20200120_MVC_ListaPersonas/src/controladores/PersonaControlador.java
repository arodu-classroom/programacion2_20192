package controladores;

import modelos.PersonaEntity;
import modelos.Personas;
import vistas.PersonaForm;
import vistas.PersonaVista;

public class PersonaControlador{
	PersonaVista vista;
	PersonaForm form;
	Personas modelo;
	
	public PersonaControlador() {
		vista = new PersonaVista(this);
		form = new PersonaForm(this);
		form.display();
		modelo = new Personas();
	}
	
	public void view(int pos) {
		if(pos < 0) {
			vista.display();
			vista.actualizar(pos,new PersonaEntity(), modelo.qty());			
		}else {
			vista.actualizar(pos,modelo.read(pos), modelo.qty());
		}
	}
	
	public void add() {
		form.setVisible(true);
		form.actualizar(modelo.qty(),new PersonaEntity());
	}
	
	public void edit(int pos) {
		form.setVisible(true);
		form.actualizar(pos, modelo.read(pos));
	}
	
	public void update(int pos, String nombre, String apellido, String cedula) {
		PersonaEntity aux = new PersonaEntity();
		aux.setNombre(nombre);
		aux.setApellido(apellido);
		aux.setCedula(cedula);
		
		if(pos >= modelo.qty()) { // nuevo
			modelo.create(aux);
		}else { // editar
			modelo.update(pos, aux);
		}
		
		form.setVisible(false);
		vista.actualizar(pos, modelo.read(pos), modelo.qty());
	}
	
	public void cambiar(int pos) {
		vista.actualizar(pos, modelo.read(pos), modelo.qty());
	}
	
	public void delete(int pos) {
		modelo.delete(pos);
		if(modelo.qty() == 0){
			vista.actualizar(-1, new PersonaEntity(), modelo.qty());
		}else if(pos > modelo.qty()-1) {
			vista.actualizar(pos-1, modelo.read(pos-1), modelo.qty());
		}else {
			vista.actualizar(pos, modelo.read(pos), modelo.qty());			
		}
	}
	
	
}





















