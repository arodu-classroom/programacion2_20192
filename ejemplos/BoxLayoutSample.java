
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxLayoutSample {

	public BoxLayoutSample() {
		JFrame w = new JFrame();
		w.setLayout(new BoxLayout(w.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel lblNombre = new JLabel("Nombre");
		w.add(lblNombre);
		JTextField txtnombre = new JTextField("Juan", 10);
		w.add(txtnombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		w.add(lblApellido);
		JTextField txtApellido = new JTextField("Perez", 10);
		w.add(txtApellido);
		
		JButton btnGuardar = new JButton("Guardar datos");
		w.add(btnGuardar);
		
		w.setLocationRelativeTo(null);
		w.pack();
		w.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new BoxLayoutSample();

	}

}
