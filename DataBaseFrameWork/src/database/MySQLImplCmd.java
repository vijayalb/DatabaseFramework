package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class MySQLImplCmd {
	
	private Connection connection;
	String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/database";
	private String username = "root";
	private String password = "BeHappyAlways:)";
	
	public void execute() {
		try {
			connectDB();
			queryDB();
			processResult();
			
		} catch (Exception e) {
			disconnectDB();
			e.printStackTrace();
		}
		
	}
	
	public void redo() throws SQLException {
		try {
			execute();
		} finally {
			System.out.println("Redo Success!");
		}
		
	}
	
	public void undo() throws SQLException {
		try {
			PreparedStatement undo = getConnection().prepareStatement("ROLLBACK");
			undo.executeUpdate();
			} finally {
				System.out.println("Undo Success!");
			}
	}
	
	protected abstract ResultSet processResult();

	protected abstract void queryDB();
	
	public void connectDB() throws SQLException {
		
		this.setConnection(DriverManager.getConnection(url,username,password));
		
	}
	
	public void disconnectDB() {
		if(getConnection() != null)
			try {
				getConnection().close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
