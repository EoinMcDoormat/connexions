package com.connexions.models;

import java.util.ArrayList;
import java.util.List;

import com.connexions.models.multi.Comment;

public class Group {
	private int id;
	private String name;
	private Friend admin;
	private List<Friend> memberList = new ArrayList<Friend>();
	private List<Comment> commentList = new ArrayList<Comment>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Friend getAdmin() {
		return admin;
	}
	public void setAdmin(Friend admin) {
		this.admin = admin;
	}
	public List<Friend> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Friend> memberList) {
		this.memberList = memberList;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
