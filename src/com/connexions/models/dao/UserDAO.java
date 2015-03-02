package com.connexions.models.dao;
import java.sql.*;

import com.connexions.components.JDBCConnectionManager;
import com.connexions.models.User;
public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
public static User register(User user) {
		
		Statement stmt = null;
		String username = user.getUsername();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String searchQuery = "INSERT INTO users VALUES (null, '" + username
				+ "', '" + password + "', '" +firstName + "', '" +lastName  +"');";
		
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		try {
			currentCon = JDBCConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			int answer = stmt.executeUpdate(searchQuery);
			System.out.println("Answer: " + answer);
		
			if (answer == 0) {
				System.out.println("Problems with registration");
				user.setValid(false);
			}
		
			else if (answer == 1) {
				user.setValid(true);
			}
		}
		
		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "	+ ex);
		}
		
		{	if (stmt != null) {
				try {
					stmt.close();
				}
				catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				}
				catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return user;
	}
	
	public static User login(User user) {
		
		Statement stmt = null;
		String username = user.getUsername();
		String password = user.getPassword();
		String searchQuery = "select * from users where email='" + username
				+ "' AND password='" + password + "'";
		
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		try {
			currentCon = JDBCConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
		
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				user.setValid(false);
				
			}
		
			else if (more) {
				int id = Integer.parseInt(rs.getString("id"));
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				System.out.println("Welcome " + firstName);
				user.setId(id);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setValid(true);
			}
		}
		
		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "	+ ex);
		}
		
		{
			if (rs != null) {
				try {
					rs.close();
				}
				catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				}
				catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				}
				catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return user;
	}
}
