package modelos;

import java.util.ArrayList;

public class Personas {
	ArrayList<PersonaEntity> lista= new ArrayList<PersonaEntity>();
	
	public void create(PersonaEntity persona) {
		lista.add(persona);
	}
	
	public PersonaEntity read(int pos) {
		return lista.get(pos);
	}
	
	public void update(int pos, PersonaEntity persona) {
		lista.set(pos, persona);
	}
	
	public void delete(int pos) {
		lista.remove(pos);
	}
	
	public int qty() {
		return lista.size();
	}
	
}









