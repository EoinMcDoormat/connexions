package com.connexions.models;

import java.util.ArrayList;
import java.util.List;

public class Profile {
	private int id;
	private String first_name;
	private String last_name;
	private String position;
	private String institution;
    private List<Education> educationList = new ArrayList<Education>();
    private List<Experience> experienceList = new ArrayList<Experience>();
    private List<Skills> skillList = new ArrayList<Skills>();
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public List<Education> getEducationList() {
		return educationList;
	}
	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}
	public List<Experience> getExperienceList() {
		return experienceList;
	}
	public void setExperienceList(List<Experience> experienceList) {
		this.experienceList = experienceList;
	}
	public List<Skills> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<Skills> skillList) {
		this.skillList = skillList;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
