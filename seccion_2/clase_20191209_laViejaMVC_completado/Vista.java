package clase_20191209;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Vista implements ActionListener{
	Controlador controlador;
	
	JFrame ventana;
	JButton celdas[];
	JLabel info;
	FlowLayout statusBar;
	JMenuItem nuevo, acerca, salir, puntos, pc;
	
	public Vista(Controlador controlador) {
		this.controlador = controlador;
		this.inicio();
	}
	
	public void inicio() {
		ventana = new JFrame();
		
		ventana.setSize(300, 340);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(new BorderLayout());
		
		// Centro
		JPanel centro = new JPanel(new GridLayout(3,3));
		celdas = new JButton[9];
		
		for(int i=0; i<9; i++) {
			celdas[i] = new JButton("");
			celdas[i].setBackground(Color.white);
			celdas[i].setFont(new Font("Arial", Font.BOLD, 50));
			celdas[i].addActionListener(this);
			centro.add(celdas[i]);
		}
		ventana.add(centro, BorderLayout.CENTER);
		
		// sur
		statusBar = new FlowLayout(FlowLayout.LEFT);
		JPanel abajo = new JPanel(statusBar);
		info = new JLabel("Jugador 1");
		abajo.add(info);
		
		ventana.add(abajo, BorderLayout.SOUTH);
		
		// menu
		JMenuBar bar = new JMenuBar();
		
		JMenu juego = new JMenu("Juego");
		bar.add(juego);
		
		nuevo = new JMenuItem("Nuevo Juego");
		nuevo.addActionListener(this);
		juego.add(nuevo);
		
		pc = new JMenuItem("Contra PC");
		pc.addActionListener(this);
		juego.add(pc);
		
		puntos = new JMenuItem("Puntaje...");
		puntos.addActionListener(this);
		juego.add(puntos);
		
		juego.addSeparator();
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		juego.add(salir);		
		
		JMenu ayuda = new JMenu("Ayuda");
		bar.add(ayuda);
		
		acerca = new JMenuItem("Acerca de...");
		acerca.addActionListener(this);
		ayuda.add(acerca);
		
		ventana.add(bar, BorderLayout.NORTH);
		
		ventana.setVisible(true);
	}
	
	public void cambiarTurno(int turno){
		if(turno == 1) {
			statusBar.setAlignment(FlowLayout.LEFT);
		}else {
			statusBar.setAlignment(FlowLayout.RIGHT);
		}
		info.setText("Jugador "+turno);
	}
	
	public void mostrarJugada(int pos, int turno) {
		if(turno == 1) {
			this.celdas[pos].setText("X");
			this.celdas[pos].setForeground(Color.blue);
		}else {
			this.celdas[pos].setText("O");
			this.celdas[pos].setForeground(Color.red);
		}	
	}
	
	public void mensaje(String msg) {
		JOptionPane.showMessageDialog(ventana, msg);
	}
	
	public void nuevo() {
		for(int i=0; i<9; i++) {
			celdas[i].setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(int i=0; i<9; i++) {
			if(arg0.getSource().equals(this.celdas[i])) {
				controlador.jugada(i);
			}
		}
		
		if(arg0.getSource().equals(acerca)) {
			JOptionPane.showMessageDialog(ventana, "Este juego fue hecho por el profesor Alberto Rodriguez");
		}
		
		if(arg0.getSource().equals(puntos)) {
			controlador.puntos();
		}
		
		if(arg0.getSource().equals(pc)) {
			controlador.pc();
		}
		
		if(arg0.getSource().equals(nuevo)) {
			controlador.nuevo();
		}
		
		if(arg0.getSource().equals(salir)) {
			if(JOptionPane.showConfirmDialog(ventana, "¿Esta seguro que desea salir?", "La Vieja", JOptionPane.YES_NO_OPTION) == 0) {
				System.exit(0);
			}
		}
		
	}
	
	
}




















