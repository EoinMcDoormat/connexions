package com.connexions.models.profile;

import java.sql.Date;

import com.connexions.models.multi.ClubSoc;
import com.connexions.models.multi.Position;

public class ClubsAndSocs {
	private int id;
	private ClubSoc clubsoc;
	private Position position;
	private String description;
	private Date start, end;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ClubSoc getClubsoc() {
		return clubsoc;
	}

	public void setClubsoc(ClubSoc clubsoc) {
		this.clubsoc = clubsoc;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
