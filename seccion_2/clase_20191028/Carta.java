package clase_20191028;

public class Carta {
	private int num;
	private String pinta;
	private int x;
	
	public Carta() {
	}
	
	public Carta(int num, String pinta, int x) {
		this.num = num;
		this.pinta = pinta;
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public int getNum() {
		return num;
	}

	public String getPinta() {
		return pinta;
	}

	public String mostrar() {
		String out="";
		out += "+---+\n";
		if(this.num < 10) {
			out += "| "+this.num+" |\n";
		}else {
			out += "| "+this.num+"|\n";
		}
		out += "| "+this.pinta+" |\n";
		out += "+---+\n";
		return out;
	}
	
}
