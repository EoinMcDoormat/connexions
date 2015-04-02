package com.connexions.models;

public class Results {
	private int id;
	private double year;
	private String subject, result;
	
	public Results(int id, double year, String subject, String result) {
		super();
		this.id = id;
		this.year = year;
		this.subject = subject;
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getYear() {
		return year;
	}
	public void setYear(double year) {
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
