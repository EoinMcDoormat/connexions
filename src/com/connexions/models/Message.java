package com.connexions.models;

public class Message {

	private int id;
	private Friend sender, recipient;
	private String message;
	private Boolean read;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Friend getSender() {
		return sender;
	}
	public void setSender(Friend sender) {
		this.sender = sender;
	}
	public Friend getRecipient() {
		return recipient;
	}
	public void setRecipient(Friend recipient) {
		this.recipient = recipient;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}	
}
