package com.connexions.models;

import java.util.ArrayList;
import java.util.List;

public class Education {
	private int id;
	private String institution, level, qualification, fieldOfStudy, start, end, grade, description;
	private List<Results> resultList = new ArrayList<Results>();
	
	public Education(int id, String institution, String level,
			String qualification, String fieldOfStudy, String start,
			String end, String grade, String description,
			List<Results> resultList) {
		super();
		this.id = id;
		this.institution = institution;
		this.level = level;
		this.qualification = qualification;
		this.fieldOfStudy = fieldOfStudy;
		this.start = start;
		this.end = end;
		this.grade = grade;
		this.description = description;
		this.resultList = resultList;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Results> getResultList() {
		return resultList;
	}
	public void setResultList(List<Results> resultList) {
		this.resultList = resultList;
	}
}
