package com.connexions.models.profile;

public class Results {
	private int id, year;
	private String subject, result;
	
	public Results(int id, int year, String subject, String result) {
		super();
		this.id = id;
		this.year = year;
		this.subject = subject;
		this.result = result;
	}
	public Results() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
