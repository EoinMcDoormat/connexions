package com.connexions.models.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Profile;
import com.connexions.models.User;
import com.connexions.utils.JDBCConnectionManager;

public class ProfileDAO {

	public static Profile index(int user_id) {
		Profile profile = new Profile();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM profiles WHERE user_id='" + user_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			int id = (int) (list.get(0).get("id"));
			String first_name = (String) (list.get(0).get("first_name"));
			String last_name = (String) (list.get(0).get("last_name"));
		}

		// String searchQuery = "SELECT * FROM profiles WHERE user_id='"
		// +user_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		return profile;
	}
	
	public static Profile getProfile(int user_id) {
		Profile profile = new Profile();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM profiles WHERE user_id='" + user_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			int id = (int) (list.get(0).get("id"));
			String first_name = (String) (list.get(0).get("first_name"));
			String last_name = (String) (list.get(0).get("last_name"));
		}

		// String searchQuery = "SELECT * FROM profiles WHERE user_id='"
		// +user_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		return profile;
	}
}
