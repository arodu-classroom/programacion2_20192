package seccion2_20200203;

import java.sql.*;

import javax.swing.JOptionPane;

public class TestMysql {

	public TestMysql() {
		
		try {
	        //Class.forName("com.mysql.jdbc.Driver");
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        String database = "test_mysql";
	        String user = "root";
	        String password = "1234";
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			System.out.println("Conectado a la base de datos "+database);
			
			Statement statement = conn.createStatement();
			
			String sql;
			
			//statement.executeQuery(arg0);
			
			//statement.executeUpdate("INSERT INTO usuarios (nombres,apellidos,cedula) VALUES ('jose','perez',123456)");
			
			sql = "UPDATE usuarios SET nombres='juan' WHERE id=4";
			statement.executeUpdate(sql);
			
			//int id = 2;
			//sql = "DELETE FROM usuarios WHERE id="+id;
			//statement.executeUpdate(sql);
			
			sql = "SELECT * FROM usuarios";
				ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println( rs.getInt("id")+": "+rs.getString("nombres")+" "+rs.getString("apellidos")+" ("+rs.getInt("cedula")+")" );
			}
			
			System.out.println("Realizado!!");
			
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Clase no encontrada "+e.getMessage());
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error de MySql: "+e.getMessage());
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		new TestMysql();
	}

}
