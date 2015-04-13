package com.connexions.models.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Wall;
import com.connexions.models.multi.Comment;
import com.connexions.utils.JDBCConnectionManager;

public class WallDAO {

	public static List<Wall> getAllStatuses(int user_id) {
		List<Wall> wallList = new ArrayList<Wall>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT walls.id, walls.user_id, profiles.first_name, profiles.last_name, walls.status, walls.created FROM walls JOIN users ON walls.user_id=users.id JOIN profiles ON profiles.user_id=users.id WHERE walls.user_id="
				+ user_id
				+ " OR walls.user_id IN (SELECT 2nd_user_id FROM friends WHERE 1st_user_id ="
				+ user_id + " AND confirmed=1) ORDER BY walls.created DESC";

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Wall wall = new Wall();
				wall.setId((int) (list.get(i).get("id")));
				wall.setStatus((String) (list.get(i).get("status")));
				wall.setFriend(FriendDAO.getFriend((int) (list.get(i).get("user_id"))));
				wall.setCreated((Timestamp) (list.get(i).get("created")));
				wall.setCommentList(getcommentList(wall.getId()));
				wallList.add(wall);
			}
		}

		return wallList;
	}

	private static List<Comment> getcommentList(int wall_id) {
		List<Comment> commentList = new ArrayList<Comment>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT walls_comments.id, walls_comments.user_id, profiles.first_name, profiles.last_name, walls_comments.comment, walls_comments.created FROM walls_comments JOIN walls ON walls.id=walls_comments.wall_id JOIN users ON walls_comments.user_id = users.id JOIN profiles ON profiles.user_id=users.id WHERE walls_comments.wall_id = "
				+ wall_id;

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Comment comment = new Comment();
				comment.setId((int) (list.get(i).get("id")));
				comment.setComment((String) (list.get(i).get("comment")));
				comment.setFriend(FriendDAO.getFriend((int) (list.get(i).get("user_id"))));
				comment.setCreated((Timestamp) (list.get(i).get("created")));
				commentList.add(comment);
			}
		}
		return commentList;
	}

	public static void addStatus(int id, String status) {
		String addstatus = "INSERT INTO walls VALUES(NULL, " +id +", \"" +status +"\", NOW(), NULL)";
		System.out.println(addstatus);
		int answer = JDBCConnectionManager.updateDatabase(addstatus);
	}

	public static void addComment(int id, String status_id, String comment) {
		String addcomment = "INSERT INTO walls_comments VALUES(NULL, " +status_id +", " +id +", \"" +comment +"\", NOW())";
		System.out.println(addcomment);
		int answer = JDBCConnectionManager.updateDatabase(addcomment);
	}
}