package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	private static final String URL ="jdbc:mysql://localhost:3306/dotheway?ServerTimeZone= Europe/Moscow&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "0000" ;
	
	private Connection connect;
	
	
	
	public DbConnect()  {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	public Connection getConnect() {
		return connect;
	}

}
