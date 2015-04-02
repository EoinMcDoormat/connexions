package com.connexions.models.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.connexions.models.User;
import com.connexions.utils.JDBCConnectionManager;

public class UserDAO {

	public static User register(User user) {
		int answer = 0;
		String searchQuery = "INSERT INTO users VALUES (null, '" + user.getUsername()
				+ "', '" + user.getPassword() + "');";
		
		System.out.println("Query: " + searchQuery);

		answer = JDBCConnectionManager.updateDatabase(searchQuery);

		if (answer == 0) {
			System.out.println("Problems with registration");
			user.setValid(false);
		}

		else if (answer == 1) {
			user.setValid(true);
		}

		return user;
	}

	public static User login(User user) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String username = user.getUsername();
		String password = user.getPassword();
		String searchQuery = "SELECT * FROM users WHERE email='" + username
				+ "' AND password='" + password + "'";

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		System.out.println("Query: " + searchQuery);
		// Print results to console
		for (HashMap elem : list)
			System.out.println(elem.get("email"));

		if (list.isEmpty()) {
			System.out
					.println("Sorry, you are not a registered user! Please sign up first");
			user.setValid(false);
		} else {
			int id = (int) (list.get(0).get("id"));
			user.setId(id);
			user.setUserName(username);
			user.setPassword(password);
			user.setValid(true);
		}
		return user;
	}
}
