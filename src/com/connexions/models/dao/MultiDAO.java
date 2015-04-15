package com.connexions.models.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.multi.Skill;
import com.connexions.models.Friend;
import com.connexions.models.multi.ClubSoc;
import com.connexions.models.multi.Company;
import com.connexions.models.multi.Country;
import com.connexions.models.multi.FieldOfStudy;
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Location;
import com.connexions.models.multi.Position;
import com.connexions.models.multi.Qualification;
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

	public static Location getLocation(int locationId) {
		Location location = new Location();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		String searchQuery = "SELECT * FROM locations WHERE locations.id = "
				+ locationId;
		System.out.println("Query: " + searchQuery);

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		location.setId(locationId);
		location.setLocation((String) (list.get(0).get("location")));
		int countryId = (int) (list.get(0).get("country_id"));
		Country country = getCountry(countryId);
		location.setCountry(country);

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

	public static Qualification getQualification(int qualificationId) {
		Qualification qualification = new Qualification();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM qualifications WHERE id="
				+ qualificationId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			qualification.setId((int) (list.get(0).get("id")));
			qualification.setQualification((String) (list.get(0)
					.get("qualification")));
		}
		return qualification;
	}

	public static FieldOfStudy getFieldOfStudy(int fieldId) {
		FieldOfStudy fieldOfStudy = new FieldOfStudy();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM fields WHERE id=" + fieldId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			fieldOfStudy.setId((int) (list.get(0).get("id")));
			fieldOfStudy.setFieldOfStudy((String) (list.get(0).get("field")));
		}
		return fieldOfStudy;
	}

	public static List<Qualification> getAllQualifications() {
		List<Qualification> qualificationList = new ArrayList<Qualification>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM qualifications";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Qualification qualification = new Qualification();
				qualification.setId((int) (list.get(i).get("id")));
				qualification.setQualification((String) (list.get(i)
						.get("qualification")));
				qualificationList.add(qualification);
			}
		}
		return qualificationList;
	}

	public static List<FieldOfStudy> getAllFieldsOfStudy() {
		List<FieldOfStudy> fieldOfStudyList = new ArrayList<FieldOfStudy>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM fields";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				FieldOfStudy fieldOfStudy = new FieldOfStudy();
				fieldOfStudy.setId((int) (list.get(i).get("id")));
				fieldOfStudy
						.setFieldOfStudy((String) (list.get(i).get("field")));
				fieldOfStudyList.add(fieldOfStudy);
			}
		}
		return fieldOfStudyList;
	}

	public static Company getCompany(int companyId) {
		Company company = new Company();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM companies WHERE id=" + companyId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			company.setId((int) (list.get(0).get("id")));
			company.setName((String) (list.get(0).get("company")));
		}
		return company;

	}

	public static Position getPosition(int positionId) {
		Position position = new Position();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM jobs_positions WHERE id="
				+ positionId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			position.setId((int) (list.get(0).get("id")));
			position.setPosition((String) (list.get(0).get("positions")));
		}
		return position;
	}

	public static List<Position> getAllJobPositions() {
		List<Position> positionList = new ArrayList<Position>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM jobs_positions";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {

				Position position = new Position();
				position.setId((int) (list.get(i).get("id")));
				position.setPosition((String) (list.get(i).get("positions")));
				positionList.add(position);
			}
		}
		return positionList;
	}

	public static List<Company> getAllCompanies() {
		List<Company> companyList = new ArrayList<Company>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM companies";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {

				Company company = new Company();
				company.setId((int) (list.get(i).get("id")));
				company.setName((String) (list.get(i).get("company")));
				companyList.add(company);
			}
		}
		return companyList;
	}

	public static List<Location> getAllLocations() {
		List<Location> locationList = new ArrayList<Location>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM locations";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Location location = new Location();
				location.setId((int) (list.get(i).get("id")));
				location.setLocation((String) (list.get(i).get("location")));
				int countryId = (int) (list.get(i).get("country_id"));
				Country country = getCountry(countryId);
				location.setCountry(country);

				locationList.add(location);

			}
		}
		return locationList;
	}

	private static Country getCountry(int countryId) {
		Country country = new Country();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM countries WHERE id=" + countryId;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			country.setId((int) (list.get(0).get("id")));
			country.setName((String) (list.get(0).get("country")));
		}
		return country;
	}

	public static List<Skill> getAllSkills() {
		List<Skill> skillList = new ArrayList<Skill>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM skills";
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No clubs found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Skill skill = new Skill();
				skill.setId((int) (list.get(i).get("id")));
				skill.setSkill((String) (list.get(i).get("name")));
				skillList.add(skill);
			}
		}
		return skillList;
	}

}