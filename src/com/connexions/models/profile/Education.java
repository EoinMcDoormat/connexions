package com.connexions.models.profile;

import java.util.ArrayList;
import java.util.List;

import com.connexions.models.multi.FieldOfStudy;
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Qualification;

public class Education {
	private int id, start, end;
	private Institution institution;
	private Qualification qualification;
	private FieldOfStudy fieldOfStudy;
	private String grade, description;
	private List<Results> resultList = new ArrayList<Results>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public Qualification getQualification() {
		return qualification;
	}
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
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
	public FieldOfStudy getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	
	
}
