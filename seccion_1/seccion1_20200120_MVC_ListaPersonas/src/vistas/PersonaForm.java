package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.PersonaControlador;
import modelos.PersonaEntity;

public class PersonaForm extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	int pos;
	PersonaControlador controlador;
	JPanel panel, panelGrid;
	JButton btnAceptar, btnCancelar;
	JLabel lblNombre, lblApellido, lblCedula, lblNumero, txtNumero;
	JTextField txtNombre, txtApellido, txtCedula;
	
	public PersonaForm(PersonaControlador controlador) {
		this.controlador = controlador;
	}

	public void display() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		// -- Botones
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		this.add(panel, BorderLayout.SOUTH);
		
		// -- Labels
		panelGrid = new JPanel(new GridLayout(4,1));
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblNumero = new JLabel("Numero:  ");
		panel.add(lblNumero);
		txtNumero = new JLabel();
		panel.add(txtNumero);
		panelGrid.add(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblNombre = new JLabel("Nombre:  ");
		panel.add(lblNombre);
		txtNombre = new JTextField(20);
		panel.add(txtNombre);
		panelGrid.add(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblApellido = new JLabel("Apellido: ");
		panel.add(lblApellido);
		txtApellido = new JTextField(20);
		panel.add(txtApellido);
		panelGrid.add(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblCedula = new JLabel("Cedula:   ");
		panel.add(lblCedula);
		txtCedula = new JTextField(20);
		panel.add(txtCedula);
		panelGrid.add(panel);
		
		this.add(panelGrid, BorderLayout.CENTER);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);
	}

	public void actualizar(int pos, PersonaEntity persona) {
		this.pos = pos;
		txtNumero.setText(Integer.toString(pos+1));
		txtNombre.setText(persona.getNombre());
		txtApellido.setText(persona.getApellido());
		txtCedula.setText(persona.getCedula());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(btnCancelar)) {
			this.setVisible(false);
		}
		
		if(arg0.getSource().equals(btnAceptar)) {
			controlador.update(
					pos,
					txtNombre.getText(), 
					txtApellido.getText(), 
					txtCedula.getText());
		}
		
	}
	
}

















