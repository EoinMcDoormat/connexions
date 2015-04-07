package com.connexions.models.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Profile;
import com.connexions.models.User;
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
		String searchQuery = "SELECT profiles_clubsandsocs.id AS id, clubsoc_name, institution, clubsandsocs_positions.name AS position, profiles_clubsandsocs.description AS description FROM profiles_clubsandsocs JOIN clubsandsocs ON clubsoc_id=clubsandsocs.id JOIN clubsandsocs_positions ON clubsandsocs_positions.id=position_id JOIN institutions ON clubsandsocs.institution_id=institutions.id WHERE profiles_clubsandsocs.id = "
				+ profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);
		
		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				ClubsAndSocs clubsandsocs = new ClubsAndSocs();
				clubsandsocs.setId((int) (list.get(i).get("id")));
				clubsandsocs.setClubsAndSocsName((String) (list.get(i).get("clubsoc_name")));
				clubsandsocs.setInstitution((String) (list.get(i).get("institution")));
				clubsandsocs.setPosition((String) (list.get(i).get("name")));
				clubsandsocs.setDescription((String) (list.get(i).get("description")));
				System.out.println("NAME: " +clubsandsocs.getClubsAndSocsName());
				clubsAndSocsList.add(clubsandsocs);
			}
		}	
		
		return clubsAndSocsList;
	}

	private static List<Experience> getExperienceProfile(int profile_id) {
		List<Experience> experienceList = new ArrayList<Experience>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String searchQuery = "SELECT profiles_experience.id, company, positions, location, description, start, end FROM profiles_experience JOIN companies ON company_id=companies.id JOIN jobs_positions ON jobs_positions.id=position_id JOIN locations ON locations.id=profiles_experience.location_id WHERE profiles_experience.profile_id="
				+ profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Experience experience = new Experience();
				experience.setId((int) (list.get(i).get("id")));
				experience.setCompany((String) (list.get(i).get("company")));
				experience.setPosition((String) (list.get(i).get("positions")));
				experience.setLocation((String) (list.get(i).get("location")));
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
		String searchQuery = "SELECT profiles_academia.id AS id, institution, levels.name AS level, qualification, field_of_study, start, end, grade, description FROM profiles_academia JOIN institutions ON institutions.id = institution_id JOIN levels ON levels.id = level_id JOIN qualifications ON qualifications.id = qualification_id WHERE profile_id ="
				+ profile_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);
		System.out.println("LIST SIZE " + list.size());
		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Education education = new Education();
				List<Results> resultsList = new ArrayList<Results>();
				education.setId((int) (list.get(i).get("id")));
				education.setInstitution((String) (list.get(i)
						.get("institution")));
				education.setLevel((String) (list.get(i).get("level")));
				education.setQualification((String) (list.get(i)
						.get("qualification")));
				education.setFieldOfStudy((String) (list.get(i)
						.get("field_of_study")));
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
		String searchQuery = "SELECT * FROM profiles WHERE user_id=" + user_id;
		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			profile.setId((int) (list.get(0).get("id")));
			profile.setFirst_name((String) (list.get(0).get("first_name")));
			profile.setLast_name((String) (list.get(0).get("last_name")));
			profile.setSummary((String) (list.get(0).get("summary")));
		}
		return profile;
	}
}
