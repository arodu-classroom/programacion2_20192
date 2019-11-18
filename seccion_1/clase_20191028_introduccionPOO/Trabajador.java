package clase_20191028;

import javax.swing.JOptionPane;

public class Trabajador extends Persona {
	private int ht;
	private int ph;
	
	public int getHt() {
		return ht;
	}
	public void setHt(int ht) {
		this.ht = ht;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public int getSueldo() {
		return this.getHt()*this.getPh();
	}
	
	public void ingresar() {
		super.ingresar();
		this.setHt( Integer.parseInt( JOptionPane.showInputDialog(null, "Horas Trabajadas") ) );
		this.setPh( Integer.parseInt( JOptionPane.showInputDialog(null, "Pago por Hora") ) );
	}
	
	public String mostrar() {
		String out = "";
		
		out += super.mostrar();
		out += "Horas Trabajadas: "+this.getHt()+"\n";
		out += "Pago por Hora: "+this.getPh()+"\n";
		out += "Sueldo: "+this.getSueldo()+"\n";
		
		return out;
	}
	
}
















