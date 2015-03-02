package com.connexions.components;
import java.sql.*;

public class JDBCConnectionManager {
	static Connection con;
	static String url;
	private static String username = "root", password = "Dywtsmcp369";
	
	public static Connection getConnection() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/connexions";
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
