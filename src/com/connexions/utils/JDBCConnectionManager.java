package com.connexions.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBCConnectionManager {

	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		String username = "root", password = "Dywtsmcp369";
		String url = "jdbc:mysql://localhost:3306/connexions";
		Class.forName("com.mysql.jdbc.Driver");

		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}

	public static int updateDatabase(String update) {
		Statement stmt = null;
		int answer = 0;
		Connection currentCon = null;

		try {
			currentCon = JDBCConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			answer = stmt.executeUpdate(update);
			System.out.println("Answer: " + answer);
		}

		catch (Exception ex) {
			System.out.println("An Exception has occurred! " + ex);
		}

		{
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return answer;
	}

	public static List queryDatabase(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection currentCon = null;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		System.out.println("Query: " + query);

		try {
			currentCon = JDBCConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(query);
			list = convertResultSetToList(rs);
		} catch (Exception ex) {
			System.out
					.println("Query execution failed: An Exception has occurred! "
							+ ex);
		}

		{
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
		}

		return list;
	}

	public static List<HashMap<String, Object>> convertResultSetToList(
			ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		while (rs.next()) {
			HashMap<String, Object> row = new HashMap<String, Object>(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(row);
		}

		return list;
	}
}
