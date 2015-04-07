package com.connexions.models.profile;

public class ClubsAndSocs {
	private int id;
	private String clubsAndSocsName, position, institution, description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClubsAndSocsName() {
		return clubsAndSocsName;
	}
	public void setClubsAndSocsName(String clubsAndSocsName) {
		this.clubsAndSocsName = clubsAndSocsName;
	}
	
}
