package stack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseAccess {

	public static Connection getConn() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		}
		return connection;
	}

	private static Connection connection = null;
	public static boolean verification(String name,String password) throws SQLException, ClassNotFoundException {
		
			boolean status = false;
			Connection con = getConn();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_tab" 
					+ " where USER_NAME='" + name
					+ "' and PASSWORD='" + password + "'");
			if(rs.next()) {
				status = true;
			}
			rs.close();
			stmt.close();
			return status;
		
	}
	
}
