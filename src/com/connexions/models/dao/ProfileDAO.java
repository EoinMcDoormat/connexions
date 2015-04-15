package com.connexions.models.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Profile;
import com.connexions.models.User;
import com.connexions.models.multi.ClubSoc;
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Position;
import com.connexions.models.multi.Skill;
import com.connexions.models.profile.ClubsAndSocs;
import com.connexions.models.profile.Education;
import com.connexions.models.profile.Experience;
import com.connexions.models.profile.Results;
import com.connexions.utils.JDBCConnectionManager;

public class ProfileDAO {

	public static Profile index(int user_id) {
		Profile profile = new Profile();
		List<Education> educationList = new ArrayList<Education>();
		List<Experience> experienceList = new ArrayList<Experience>();
		List<ClubsAndSocs> clubsAndSocsList = new ArrayList<ClubsAndSocs>();
		List<Skill> skillsList = new ArrayList<Skill>();

		profile = getPersonalProfile(user_id);
		educationList = getAcademicProfile(profile.getId());
		profile.setEducationList(educationList);
		experienceList = getExperienceProfile(profile.getId());
		profile.setExperienceList(experienceList);
		clubsAndSocsList = getClubsAndSocsProfile(profile.getId());
		profile.setClubsAndSocsList(clubsAndSocsList);
		skillsList = getSkillsProfile(profile.getId());
		profile.setSkillList(skillsList);

		return profile;
	}

	private static List<Skill> getSkillsProfile(int profile_id) {
		List<Skill> skillsList = new ArrayList<Skill>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT profiles_skills.id, skills.name FROM profiles_skills JOIN skills ON profiles_skills.skill_id=skills.id WHERE profiles_skills.profile_id = "
				+ profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Skill skills = new Skill();
				skills.setId((int) (list.get(i).get("id")));
				skills.setSkill((String) (list.get(i).get("name")));
				skillsList.add(skills);
			}
		}

		return skillsList;
	}

	private static List<ClubsAndSocs> getClubsAndSocsProfile(int profile_id) {
		List<ClubsAndSocs> clubsAndSocsList = new ArrayList<ClubsAndSocs>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM profiles_clubsandsocs WHERE profiles_clubsandsocs.profile_id = "
				+ profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				ClubsAndSocs clubsandsocs = new ClubsAndSocs();
				clubsandsocs.setId((int) (list.get(i).get("id")));
				int clubSocId = (int) (list.get(i).get("clubsoc_id"));
				ClubSoc clubsoc = MultiDAO.getClubSoc(clubSocId);
				clubsandsocs.setClubsoc(clubsoc);
				int positionId = (int) (list.get(i).get("position_id"));
				Position position = MultiDAO.getClubSocPosition(positionId);
				clubsandsocs.setPosition(position);
				clubsandsocs.setDescription((String) (list.get(i)
						.get("description")));
				clubsandsocs.setStart((Date) (list.get(i).get("start")));
				clubsandsocs.setEnd((Date) (list.get(i).get("end")));
				clubsAndSocsList.add(clubsandsocs);
			}
		}

		return clubsAndSocsList;
	}

	private static List<Experience> getExperienceProfile(int profile_id) {
		List<Experience> experienceList = new ArrayList<Experience>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM profiles_experience WHERE profiles_experience.profile_id="
				+ profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Experience experience = new Experience();
				experience.setId((int) (list.get(i).get("id")));
				
				int companyId = (int) (list.get(i).get("company_id"));
				experience.setCompany(MultiDAO.getCompany(companyId));
				
				int positionId = (int) (list.get(i).get("position_id"));
				experience.setPosition(MultiDAO.getPosition(positionId));
				
				int locationId = (int) (list.get(i).get("location_id"));
				experience.setLocation(MultiDAO.getLocation(locationId));
				
				experience.setDescription((String) (list.get(i)
						.get("description")));
				experience.setStart((Date) (list.get(i).get("start")));
				experience.setEnd((Date) (list.get(i).get("end")));
				experienceList.add(experience);
			}
		}
		return experienceList;
	}

	private static List getResults(int education_id) {
		List<Results> ResultsList = new ArrayList<Results>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM profiles_academia_results WHERE profile_academia_id ="
				+ education_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);
		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Results result = new Results();
				List<Results> resultsList = new ArrayList<Results>();
				result.setId((int) (list.get(i).get("id")));
				result.setYear((int) (list.get(i).get("year")));
				result.setSubject((String) (list.get(i).get("subject")));
				result.setResult((String) (list.get(i).get("result")));
				ResultsList.add(result);
			}
		}
		return ResultsList;
	}

	private static List getAcademicProfile(int profile_id) {
		List<Education> educationList = new ArrayList<Education>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT * FROM profiles_academia WHERE profile_id =" + profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);
		System.out.println("LIST SIZE " + list.size());
		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Education education = new Education();
				List<Results> resultsList = new ArrayList<Results>();
				education.setId((int) (list.get(i).get("id")));
				
				int qualificationId = ((int) (list.get(i)
						.get("qualification_id")));
				education.setQualification(MultiDAO.getQualification(qualificationId));
				
				int institutionId = ((int) (list.get(i)
						.get("institution_id")));
				education.setInstitution(MultiDAO.getInstitution(institutionId));
				
				int fieldId = ((int) (list.get(i)
						.get("field_of_study_id")));
				education.setFieldOfStudy(MultiDAO.getFieldOfStudy(fieldId));
				
				education.setStart((int) (list.get(i).get("start")));
				education.setEnd((int) (list.get(i).get("end")));
				education.setGrade((String) (list.get(i).get("grade")));
				education.setDescription((String) (list.get(i)
						.get("description")));
				resultsList = getResults(education.getId());
				education.setResultList(resultsList);
				educationList.add(education);
			}
		}
		return educationList;
	}

	public static Profile getPersonalProfile(int user_id) {
		Profile profile = new Profile();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT profiles.id, profiles.first_name, profiles.last_name, profiles.summary, qualifications.qualification, institutions.institution, private FROM profiles JOIN qualifications ON profiles.positions_id = qualifications.id JOIN institutions ON profiles.institution_id = institutions.id WHERE user_id="
				+ user_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			profile.setId((int) (list.get(0).get("id")));
			profile.setFirst_name((String) (list.get(0).get("first_name")));
			profile.setLast_name((String) (list.get(0).get("last_name")));
			profile.setSummary((String) (list.get(0).get("summary")));
			profile.setPosition((String) (list.get(0).get("qualification")));
			profile.setInstitution((String) (list.get(0).get("institution")));
			profile.setPrivacy((boolean)(list.get(0).get("private")));;
		}
		return profile;
	}

	public static void updatePersonalProfile(int id, String firstName,
			String lastName, String summary, int position, int institution) {
		String updatePersonalProfile = "UPDATE profiles SET first_name=\""
				+ firstName + "\", last_name=\"" + lastName + "\", summary=\""
				+ summary + "\", positions_id=" + position
				+ ", institution_id=" + institution + " WHERE user_id=" + id;
		int answer = JDBCConnectionManager
				.updateDatabase(updatePersonalProfile);

		if (answer == 0) {
			String addPersonalProfile = "INSERT INTO profiles VALUES(NULL,"
					+ id + ", \"" + firstName + "\", \"" + lastName + "\", \""
					+ summary + "\", " + position + ", " + institution + ")";
			answer = JDBCConnectionManager.updateDatabase(addPersonalProfile);
		}
	}

	public static void updateProfileClubsAndSocs(int profileClubSocId,
			int clubsoc, int position, String description, int start, int end) {

		String strEnd = String.valueOf(end);

		if (end == 0) {
			strEnd = "null";
		}

		String updateProfileClubsAndSocs = "UPDATE profiles_clubsandsocs SET clubsoc_id="
				+ clubsoc
				+ ", position_id="
				+ position
				+ ", description=\""
				+ description
				+ "\", start="
				+ start
				+ ", end="
				+ strEnd
				+ " WHERE id=" + profileClubSocId;

		int answer = JDBCConnectionManager
				.updateDatabase(updateProfileClubsAndSocs);
	}

	public static void addProfileClubsAndSocs(int profileId, int clubsoc,
			int position, String description, int clubSocStart, int clubSocEnd) {

		String strEnd = String.valueOf(clubSocEnd);

		if (clubSocEnd == 0) {
			strEnd = "null";
		}
		String addProfileClubsAndSocs = "INSERT INTO profiles_clubsandsocs VALUES(NULL, "
				+ profileId
				+ ", "
				+ clubsoc
				+ ", "
				+ position
				+ ", \""
				+ description + "\"," + clubSocStart + ", " + strEnd +")";
		int answer = JDBCConnectionManager
				.updateDatabase(addProfileClubsAndSocs);
	}

	public static void delProfileClubsAndSocs(int profileClubSocId) {
		// TODO Auto-generated method stub
		String delProfileClubsAndSocs = "DELETE FROM profiles_clubsandsocs WHERE id =" +profileClubSocId;
		
		int answer = JDBCConnectionManager
				.updateDatabase(delProfileClubsAndSocs);
		
	}

	public static void updatePrivacy(int id, int privacySetting) {
		// TODO Auto-generated method stub
		String updatePrivacy = "UPDATE profiles SET private=" +privacySetting +" WHERE id=" +id;
		int answer = JDBCConnectionManager
				.updateDatabase(updatePrivacy);
	}

	public static void deleteRow(String table, int id) {
		// TODO Auto-generated method stub
		String deleteRow = "DELETE FROM " +table +" WHERE id =" +id;
		
		int answer = JDBCConnectionManager
				.updateDatabase(deleteRow);
	}

	public static void updateRow(String table, String values, int id) {
		// TODO Auto-generated method stub
		String updateRow = "UPDATE " +table +" SET " +values +" WHERE id=" +id;
		
		int answer = JDBCConnectionManager
				.updateDatabase(updateRow);
	}

	public static void addRow(String table, String values) {
		// TODO Auto-generated method stub
		String addRow = "INSERT INTO " +table +" VALUES(" +values +");";
		
		int answer = JDBCConnectionManager
				.updateDatabase(addRow);
	}
}
