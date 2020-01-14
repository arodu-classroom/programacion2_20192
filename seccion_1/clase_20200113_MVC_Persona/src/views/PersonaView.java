package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.PersonaController;

public class PersonaView implements ActionListener{
	PersonaController controller;
	
	JTextField txtNombre, txtApellido, txtTelefono;
	JButton btnAceptar;
	
	public PersonaView(PersonaController controller) {
		this.controller = controller;
	}

	public void display() {
		JFrame w = new JFrame();
		w.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(5, 5, 200, 20);
		w.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(5, 30, 200, 20);
		w.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(5, 60, 200, 20);
		w.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(5, 85, 200, 20);
		w.add(txtApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(5, 110, 200, 20);
		w.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(5, 135, 200, 20);
		w.add(txtTelefono);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(5, 165, 200, 20);
		btnAceptar.addActionListener(this);
		w.add(btnAceptar);
		
		w.setResizable(false);
		w.setLocationRelativeTo(null);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(230, 250);
		w.setVisible(true);
	}
	
	public void show(String n, String a, String t) {
		txtNombre.setText(n);
		txtApellido.setText(a);
		txtTelefono.setText(t);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(btnAceptar)) {
			controller.save(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText());
		}
		
	}
	
	
}







