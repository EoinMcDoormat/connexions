package com.connexions.models.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Friend;
import com.connexions.models.Group;
import com.connexions.models.multi.Comment;
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Skill;
import com.connexions.utils.JDBCConnectionManager;

public class GroupDAO {

	public static List<Group> index(int id) {
		List<Group> groupList = new ArrayList<Group>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * from groups";
		list = JDBCConnectionManager.queryDatabase(searchQuery);
		
		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Group group = new Group();
				group.setId((int) (list.get(i).get("id")));
				group.setName((String) (list.get(i).get("name")));
				Friend admin = FriendDAO.getFriend((int) (list.get(i).get("admin_id")));
				group.setAdmin(admin);
				List<Friend> memberList = getAllMembers(group.getId());
				group.setMemberList(memberList);
				List<Comment> commentList = getAllComments(group.getId());
				group.setCommentList(commentList);

				groupList.add(group);
			}
		}

		return groupList;
	}

	public static List<Friend> getAllMembers(int group_id) {
		List<Friend> friendList = new ArrayList<Friend>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT groups_members.user_id, profiles.first_name, profiles.last_name, qualification, institution_id FROM groups_members JOIN users ON groups_members.user_id = users.id JOIN profiles ON users.id=profiles.user_id JOIN qualifications ON qualifications.id = profiles.positions_id WHERE group_id=" +group_id;
		System.out.println("Query: " + searchQuery);
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Friend friend = new Friend();

				friend.setId((int) list.get(i).get("user_id"));
				friend.setFirstName((String) (list.get(i).get("first_name")));
				friend.setLastName((String) (list.get(i).get("last_name")));
				friend.setPosition((String) (list.get(i).get("qualification")));
				int institutionId = (int) (list.get(i).get("institution_id"));
				Institution institution = MultiDAO.getInstitution(institutionId);
				friend.setInstitution(institution);
				friendList.add(friend);
			}
		}
		return friendList;
	}

	private static List<Comment> getAllComments(int groupId) {
		List<Comment> commentList = new ArrayList<Comment>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT groups_comments.id, groups_comments.user_id, profiles.first_name, profiles.last_name, groups_comments.comment, groups_comments.created FROM groups_comments JOIN groups ON groups.id=groups_comments.group_id JOIN users ON groups_comments.user_id = users.id JOIN profiles ON profiles.user_id=users.id WHERE groups_comments.group_id = "
				+ groupId;

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

}
