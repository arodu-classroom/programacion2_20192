package MysqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlHelper{
	private Connection conn;
	private Statement statement;
	private String lastError;
	private boolean debug = true;
	private int affectRows;
	private ResultSet lastResulset;
	
	private String user;
	private String password;
	private String database;
	
	public static int SELECT = 0;
	public static int INSERT = 1;
	public static int UPDATE = 2;
	public static int DELETE = 2;
	
	public MySqlHelper(String user, String password, String database){
		this.user = user;
		this.password = password;
		this.database = database;
		
		this.connect();
	}
    
    public Connection getConn(){
		return conn;
	}
    
    public String getLastError() {
		return lastError;
	}
    
    public int getAffectRows() {
		return affectRows;
	}
    
    public ResultSet getLastResulset() {
		return lastResulset;
	}
    
    public void connect(){
		try {
	        //Class.forName("com.mysql.jdbc.Driver");
	        Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database, this.user, this.password);
			this.statement = this.conn.createStatement();
			
		}catch(ClassNotFoundException e){
			this.error(e.getMessage());
			
		} catch (SQLException e) {
			this.error(e.getMessage());
			
		}
    }
    
    public void close(){
    	try{
    		this.statement.close();
			this.conn.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
    }
    
    public boolean query(String sql, int type){
    	boolean out;
    	try{
    		switch (type) {
	    		case 0:  // SELECT
	    			this.lastResulset = statement.executeQuery(sql);
	    			break;
	    		case 1:  // INSERT
	    			this.affectRows = statement.executeUpdate(sql);
	    			break;
				case 2:  // UPDATE, DELETE
					this.affectRows = statement.executeUpdate(sql);
					break;
			}
        	out = true;
        }catch(SQLException e){
        	this.error(e.getMessage());
        	out = false;
        }
        return out;
    }
    
    public ResultSet select(String sql){
       	this.lastResulset = null;
       	this.query(sql, SELECT);
        return this.lastResulset;
    }
    
    public int insert(String sql){
    	this.query(sql, MySqlHelper.INSERT);
    	return this.affectRows;
    }
    
    public int update(String sql){
    	this.query(sql, MySqlHelper.UPDATE);
    	return this.affectRows;
    }
    
    public int delete(String sql){
    	this.query(sql, MySqlHelper.DELETE);
    	return this.affectRows;
    }
    
    private void error(String out){
    	this.lastError = out;
    	this.debug(out, true);
    }
    
    public void debug(String out, boolean error){
    	if(this.debug){
    		if(error){
    			System.err.println(out);
    		}else{
    			System.out.println(out);
    		}
    	}
    }

}
