package com.connexions.models.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Friend;
import com.connexions.models.multi.Skill;
import com.connexions.utils.JDBCConnectionManager;

public class FriendDAO {

	public static Friend getFriend(int user_id) {
		Friend friend = new Friend();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		String searchQuery = "SELECT users.id, profiles.first_name, profiles.last_name, qualification, institution FROM users JOIN profiles ON users.id=profiles.user_id JOIN qualifications ON qualifications.id = profiles.positions_id JOIN institutions ON institutions.id=profiles.institution_id WHERE users.id ="
				+ user_id;
		System.out.println("Query: " + searchQuery);

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		friend.setId(user_id);
		friend.setFirstName((String) (list.get(0).get("first_name")));
		friend.setLastName((String) (list.get(0).get("last_name")));
		friend.setPosition((String) (list.get(0).get("qualification")));
		friend.setInstitution((String) (list.get(0).get("institution")));

		return friend;
	}

	public static List<Friend> getAllFriends(int id) {
		List<Friend> friendList = new ArrayList<Friend>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT friends.2nd_user_id, profiles.first_name, profiles.last_name, qualification, institution FROM friends JOIN users ON friends.2nd_user_id = users.id JOIN profiles ON users.id=profiles.user_id JOIN qualifications ON qualifications.id = profiles.positions_id JOIN institutions ON institutions.id=profiles.institution_id WHERE confirmed = 1 AND deleted IS NULL AND 1st_user_id ="
				+ id;
		System.out.println("Query: " + searchQuery);
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Friend friend = new Friend();

				friend.setId((int) list.get(i).get("2nd_user_id"));
				friend.setFirstName((String) (list.get(i).get("first_name")));
				friend.setLastName((String) (list.get(i).get("last_name")));
				friend.setPosition((String) (list.get(i).get("qualification")));
				friend.setInstitution((String) (list.get(i).get("institution")));
				friendList.add(friend);
			}
		}
		return friendList;
	}
}
//
//
// static Connection currentCon = null;
// static ResultSet rs = null;
//
//
//
// public static void requestFriend(int id, int connid) {
// Statement stmt = null;
// String addcon = "INSERT INTO friends VALUES (NULL, '" + id + "', '"
// + connid + "', 0, NOW(), NULL);";
//
// System.out.println("Query: " + addcon);
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// stmt.executeUpdate(addcon);
// }
//
// catch (Exception ex) {
// System.out.println("Connexion failed: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
// }
//
// public static void acceptFriend(int id, int connid) {
// Statement stmt = null;
// String acceptcon = "UPDATE friends SET confirmed = 1 WHERE 1st_user_id = "
// + id + " AND 2nd_user_id = " + connid + ";";
// String createcon = "INSERT INTO friends VALUES (NULL, '" + connid + "', '"
// + id + "', 1, NOW(), NULL);";
//
// System.out.println("Query: " + acceptcon);
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// stmt.executeUpdate(acceptcon);
// stmt.executeUpdate(createcon);
// }
//
// catch (Exception ex) {
// System.out.println("Connexion failed: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
// }
//
// public static void rejectFriend(int id, int connid) {
// Statement stmt = null;
// String acceptcon = "UPDATE friends SET deleted = NOW() WHERE 1st_user_id = "
// + id + " AND 2nd_user_id = " + connid + ";";
//
// System.out.println("Query: " + acceptcon);
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// stmt.executeUpdate(acceptcon);
// }
//
// catch (Exception ex) {
// System.out.println("Connexion failed: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
// }
//
// public static void removeFriend(int id, int connid) {
// Statement stmt = null;
// String remcon = "UPDATE friends SET deleted = NOW() WHERE (1st_user_id = "
// + id + " AND 2nd_user_id = " + connid + ") OR (1st_user_id = "
// + connid + " AND 2nd_user_id = " + id +";";
//
// System.out.println("Query: " + remcon);
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// stmt.executeUpdate(remcon);
// }
//
// catch (Exception ex) {
// System.out.println("Connexion failed: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
// }
//
// public static List<Friend> showRequests(int id) {
// List<Friend> requests = new ArrayList<Friend>();
//
// Statement stmt = null;
// String searchQuery =
// " SELECT friends.1st_user_id AS id, users.first_name, users.last_name "
// + "FROM friends "
// + "JOIN users ON friends.1st_user_id = users.id "
// + "WHERE 2nd_user_id = "
// + id
// + " AND confirmed = 0 AND deleted IS NULL;";
//
// System.out.println("Query: " + searchQuery);
//
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// rs = stmt.executeQuery(searchQuery);
// int i = 0;
//
// while (rs.next()) {
// int connexionId = Integer.parseInt(rs.getString("id"));
// String first_name = rs.getString("first_name");
// String last_name = rs.getString("last_name");
//
// // System.out.println(connexionId +" " +first_name +" "
// // +last_name);
//
// requests.add(i, new Friend(connexionId, first_name,
// last_name));
// i++;
// }
//
// }
//
// catch (Exception ex) {
// System.out
// .println("friends not found: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
// return requests;
// }
//
// public static List<Friend> searchFriends(String searchString) {
// List<Friend> search = new ArrayList<Friend>();
//
// Statement stmt = null;
//
// String searchQuery = "SELECT users.id, users.first_name, users.last_name "
// + "FROM users WHERE users.email = '" + searchString + "';";
// System.out.println("Query: " + searchQuery);
//
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// rs = stmt.executeQuery(searchQuery);
// int i = 0;
//
// while (rs.next()) {
// int connexionId = Integer.parseInt(rs.getString("id"));
// String first_name = rs.getString("first_name");
// String last_name = rs.getString("last_name");
//
// search.add(i, new Friend(connexionId, first_name, last_name));
// i++;
// }
//
// }
//
// catch (Exception ex) {
// System.out
// .println("friends not found: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
// return search;
// }
//
// public static List<Friend> showAllFriends(int id) {
//
// List<Friend> connexion = new ArrayList<Friend>();
//
// Statement stmt = null;
//
// String searchQuery =
// " SELECT friends.2nd_user_id, users.first_name, users.last_name "
// + "FROM friends "
// + "JOIN users ON friends.2nd_user_id = users.id "
// + "WHERE 1st_user_id = "
// + id
// + " AND confirmed = 1 AND deleted IS NULL;";
// System.out.println("Query: " + searchQuery);
//
// try {
// currentCon = JDBCConnectionManager.getConnection();
// stmt = currentCon.createStatement();
// rs = stmt.executeQuery(searchQuery);
// int i = 0;
//
// while (rs.next()) {
// int connexionId = Integer.parseInt(rs.getString("2nd_user_id"));
// String first_name = rs.getString("first_name");
// String last_name = rs.getString("last_name");
//
// connexion.add(i, new Friend(connexionId, first_name,
// last_name));
// i++;
// }
//
// }
//
// catch (Exception ex) {
// System.out
// .println("friends not found: An Exception has occurred! "
// + ex);
// }
//
// {
// if (stmt != null) {
// try {
// stmt.close();
// } catch (Exception e) {
// }
// stmt = null;
// }
// if (currentCon != null) {
// try {
// currentCon.close();
// } catch (Exception e) {
// }
// currentCon = null;
// }
// }
//
// return connexion;
// }