package views;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.PersonaController;

public class PersonaView {
	PersonaController controller;
	
	JTextField txtNombre,txtApellido,txtTelefono;
	
	public PersonaView(PersonaController controller) {
		this.controller = controller;
	}

	public void display() {
		JFrame w = new JFrame();
		Box b = Box.createVerticalBox();
		w.add(b);
		
		JLabel lblNombre = new JLabel("Nombre");
		b.add(lblNombre);
		txtNombre = new JTextField();
		b.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		b.add(lblApellido);
		txtApellido = new JTextField();
		b.add(txtApellido);
		
		JLabel lblTelefono = new JLabel("TElefono");
		b.add(lblTelefono);
		txtTelefono = new JTextField();
		b.add(txtTelefono);
		
		JButton btnAceptar = new JButton("Aceptar");
		b.add(btnAceptar);
		
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		w.setSize(200, 200);
		//w.pack();
		w.setLocationRelativeTo(null);
		w.setVisible(true);
	}
	
	public void show(String nombre, String apellido, String telefono) {
		txtNombre.setText(nombre);
		txtApellido.setText(apellido);
		txtTelefono.setText(telefono);
	}
	
}











