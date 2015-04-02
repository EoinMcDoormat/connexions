package com.connexions.models;

public class User {
	private int id;
	private String username;
	private String password;
	public boolean valid;

	public User() {
		this.username = "";
		this.password = "";
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String firstName,
			String lastName) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String newUsername) {
		username = newUsername;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}	
}
