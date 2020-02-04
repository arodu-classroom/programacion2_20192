package seccion1_20200203;

import java.sql.*;

import javax.swing.JOptionPane;

public class MysqlTest {
	
	public MysqlTest() {
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String database = "test_mysql";
			String usuario = "root";
			String clave = "1234";
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, usuario, clave);
		
			Statement s = conn.createStatement();
			
			s.executeUpdate("INSERT INTO usuarios (nombres,apellidos,cedula) VALUES ('fulano','de tal',123456)");
			
			String sql = "";
			
			sql = "UPDATE usuarios SET nombres='anita' WHERE id=4";
			s.executeUpdate(sql);
			
			//int id = 3;
			//sql = "DELETE FROM usuarios WHERE id="+id;
			//s.executeUpdate(sql);
			
			sql = "SELECT * FROM usuarios";
			ResultSet rs = s.executeQuery(sql);
			
			String out = "";
			while(rs.next()) {
				out += "Usuario "+rs.getInt("id")+": "+rs.getString("nombres")+" "+rs.getString("apellidos")+" ("+rs.getInt("cedula")+")\n";
			}
			JOptionPane.showMessageDialog(null, out);
			
			System.out.println("Realizado!!");
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error clase no encontrada: "+e.getMessage());
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en SQL");
			System.out.println(e.getMessage());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error!");
			System.out.println(e);
		}
		//this.statement = this.conn.createStatement();
		
	}

	public static void main(String[] args) {
		new MysqlTest();

	}

}
