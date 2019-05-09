package bookmall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.43:3307/bookmall";
			conn = DriverManager.getConnection(url,"bookmall","bookmall");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return conn;
	}
}
