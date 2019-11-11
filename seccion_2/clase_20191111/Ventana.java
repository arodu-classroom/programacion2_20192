package clase_20191111;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana implements ActionListener{

	private JButton aceptar;
	private JButton cancelar;
	private JFrame ventana;
	
	public Ventana() {
		ventana = new JFrame();
		ventana.setLayout(new BorderLayout());
		
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);

		
		JPanel panel_south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		panel_south.add(aceptar);		
		panel_south.add(cancelar);
		
		ventana.add(panel_south, BorderLayout.SOUTH);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(400, 300);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			JOptionPane.showMessageDialog(ventana, "Click en el boton aceptar");
		}
		if(arg0.getSource().equals(cancelar)) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ventana();

	}

}










