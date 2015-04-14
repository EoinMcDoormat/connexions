package com.connexions.models;

import java.util.ArrayList;
import java.util.List;

import com.connexions.models.multi.Skill;
import com.connexions.models.profile.ClubsAndSocs;
import com.connexions.models.profile.Education;
import com.connexions.models.profile.Experience;

public class Profile {
	private int id;
	private String first_name;
	private String last_name;
	private String position;
	private String institution;
	private String summary;	
    private List<Education> educationList = new ArrayList<Education>();
    private List<ClubsAndSocs> clubsAndSocsList = new ArrayList<ClubsAndSocs>();
    private List<Experience> experienceList = new ArrayList<Experience>();
    private List<Skill> skillList = new ArrayList<Skill>();
    private boolean privacy;
    
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
	public List<Skill> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<Skill> skillList) {
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<ClubsAndSocs> getClubsAndSocsList() {
		return clubsAndSocsList;
	}
	public void setClubsAndSocsList(List<ClubsAndSocs> clubsAndSocsList) {
		this.clubsAndSocsList = clubsAndSocsList;
	}
	public boolean isPrivacy() {
		return privacy;
	}
	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}
}
