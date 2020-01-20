package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controladores.PersonaControlador;
import modelos.PersonaEntity;

public class PersonaVista extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	int pos;
	PersonaControlador controlador;
	JPanel panel, panelGrid;
	JButton btnEditar, btnBorrar, btnCancelar, btnSig, btnAnt, btnAgregar;
	JLabel lblNombre, lblApellido, lblCedula, lblNumero;
	JLabel txtNombre, txtApellido, txtCedula, txtNumero;
	
	public PersonaVista(PersonaControlador controlador) {
		this.controlador = controlador;
	}

	public void display() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		// -- Botones
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnAnt = new JButton("<");
		btnAnt.addActionListener(this);
		panel.add(btnAnt);
		
		btnSig = new JButton(">");
		btnSig.addActionListener(this);
		panel.add(btnSig);
		
		btnAgregar = new JButton("+");
		btnAgregar.addActionListener(this);
		panel.add(btnAgregar);
		
		this.add(panel, BorderLayout.NORTH);
		
		// -- Botones
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		this.add(panel, BorderLayout.SOUTH);
		
		// -- Labels
		panelGrid = new JPanel(new GridLayout(4,1));
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblNumero = new JLabel("Numero: ");
		panel.add(lblNumero);
		txtNumero = new JLabel("");
		panel.add(txtNumero);
		panelGrid.add(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblNombre = new JLabel("Nombre: ");
		panel.add(lblNombre);
		txtNombre = new JLabel("");
		panel.add(txtNombre);
		panelGrid.add(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblApellido = new JLabel("Apellido: ");
		panel.add(lblApellido);
		txtApellido = new JLabel("");
		panel.add(txtApellido);
		panelGrid.add(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblCedula = new JLabel("Cedula: ");
		panel.add(lblCedula);
		txtCedula = new JLabel("");
		panel.add(txtCedula);
		panelGrid.add(panel);
		
		this.add(panelGrid, BorderLayout.CENTER);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actualizar(int pos,PersonaEntity persona, int cant) {
		this.pos = pos;
		txtNumero.setText(Integer.toString(pos+1)+" / "+cant);
		txtNombre.setText(persona.getNombre());
		txtApellido.setText(persona.getApellido());
		txtCedula.setText(persona.getCedula());
		
		chequear(cant);
	}
	
	private void chequear(int cant) {
		if(pos <= 0) {
			btnAnt.setEnabled(false);
		}else {
			btnAnt.setEnabled(true);
		}
		if(pos >= cant-1) {
			btnSig.setEnabled(false);
		}else {
			btnSig.setEnabled(true);
		}
		
		if(pos >=0 && pos <= cant-1) {
			btnEditar.setEnabled(true);
			btnBorrar.setEnabled(true);
		}else {
			btnEditar.setEnabled(false);
			btnBorrar.setEnabled(false);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(btnCancelar)) {
			System.exit(0);
		}
		
		if(arg0.getSource().equals(btnEditar)) {
			controlador.edit(pos);
		}
		
		if(arg0.getSource().equals(btnBorrar)) {
			if(JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar los datos?", "Borrar", JOptionPane.YES_NO_OPTION) == 0) {
				controlador.delete(pos);
			}
		}
		
		if(arg0.getSource().equals(btnAgregar)) {
			controlador.add();
		}
		
		if(arg0.getSource().equals(btnSig)) {
			controlador.cambiar(pos+1);
		}
		
		if(arg0.getSource().equals(btnAnt)) {
			controlador.cambiar(pos-1);
		}
	}
	
}

















