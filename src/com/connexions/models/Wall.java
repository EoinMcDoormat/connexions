package com.connexions.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.connexions.models.multi.Comment;

public class Wall {
	private int id;
	private String status;
	private Timestamp created;
    private List<Comment> commentList = new ArrayList<Comment>();
    private Friend friend;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
}
