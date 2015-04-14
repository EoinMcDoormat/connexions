package com.connexions.models.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Friend;
import com.connexions.models.multi.ClubSoc;
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Location;
import com.connexions.models.multi.Position;
import com.connexions.models.profile.ClubsAndSocs;
import com.connexions.utils.JDBCConnectionManager;

public class MultiDAO {

	public static Institution getInstitution(int user_id) {
		Institution institution = new Institution();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		String searchQuery = "SELECT * FROM institutions";
		System.out.println("Query: " + searchQuery);

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		institution.setId((int) (list.get(0).get("id")));
		institution.setInstitution((String) (list.get(0).get("institution")));
		int locationId = (int) (list.get(0).get("location_id"));
		Location location = MultiDAO.getLocation(locationId);
		institution.setLocation(location);

		return institution;
	}

	private static Location getLocation(int locationId) {
		Location location = new Location();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		String searchQuery = "SELECT locations.id, location, countries.country FROM locations JOIN countries ON locations.country_id=countries.id WHERE locations.id = "
				+ locationId;
		System.out.println("Query: " + searchQuery);

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		location.setId(locationId);
		location.setLocation((String) (list.get(0).get("location")));
		location.setCountry((String) (list.get(0).get("country")));

		return location;
	}

	public static List getAllAcademicPositions() {
		List<Position> positionList = new ArrayList<Position>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM qualifications";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No qualifications found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Position position = new Position();
				position.setId((int) (list.get(i).get("id")));
				position.setPosition((String) (list.get(i).get("qualification")));
				positionList.add(position);
			}
		}
		return positionList;
	}

	public static Position getAcademicPosition(int positionId) {
		Position position = new Position();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM qualifications WHERE id="
				+ positionId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No qualifications found");

		} else {
			position.setId((int) (list.get(0).get("id")));
			position.setPosition((String) (list.get(0).get("qualification")));
		}
		return position;
	}

	public static List getAllClubPositions() {
		List<Position> positionList = new ArrayList<Position>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM clubsandsocs_positions";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No positions found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Position position = new Position();
				position.setId((int) (list.get(i).get("id")));
				position.setPosition((String) (list.get(i).get("name")));
				positionList.add(position);
			}
		}
		return positionList;
	}

	public static Position getClubSocPosition(int position_id) {
		Position position = new Position();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM clubsandsocs_positions WHERE id="
				+ position_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No positions found");

		} else {

			position.setId((int) (list.get(0).get("id")));
			position.setPosition((String) (list.get(0).get("name")));

		}

		return position;
	}

	public static List getAllAcademicInstitutions() {
		List<Institution> institutionList = new ArrayList<Institution>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM institutions";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No institutions found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Institution institution = new Institution();
				institution.setId((int) (list.get(i).get("id")));
				institution.setInstitution((String) (list.get(i)
						.get("institution")));
				institutionList.add(institution);
			}
		}
		return institutionList;
	}

	public static List<ClubSoc> getAllClubAndSocs() {
		List<ClubSoc> clubSocList = new ArrayList<ClubSoc>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM clubsandsocs";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				ClubSoc clubsoc = new ClubSoc();
				clubsoc.setId((int) (list.get(i).get("id")));
				clubsoc.setName((String) (list.get(i).get("clubsoc_name")));
				clubSocList.add(clubsoc);
			}
		}
		return clubSocList;
	}

	public static ClubSoc getClubSoc(int clubSocId) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM clubsandsocs WHERE id=" + clubSocId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		ClubSoc clubsoc = new ClubSoc();

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			clubsoc.setId((int) (list.get(0).get("id")));
			clubsoc.setName((String) (list.get(0).get("clubsoc_name")));
		}
		return clubsoc;
	}
}