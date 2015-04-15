package com.connexions.controllers;

import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connexions.models.Profile;
import com.connexions.models.User;
import com.connexions.models.dao.MultiDAO;
import com.connexions.models.dao.ProfileDAO;
import com.connexions.models.dao.UserDAO;
import com.connexions.models.multi.ClubSoc;
import com.connexions.models.multi.Company;
import com.connexions.models.multi.FieldOfStudy;
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Location;
import com.connexions.models.multi.Position;
import com.connexions.models.multi.Qualification;
import com.connexions.models.multi.Skill;
import com.connexions.models.profile.ClubsAndSocs;

@WebServlet("/profiles")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -2037933989085481943L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		List<Position> positionList = new ArrayList<Position>();
		positionList = MultiDAO.getAllAcademicPositions();
		request.setAttribute("positions", positionList);

		List<Institution> institutionList = new ArrayList<Institution>();
		institutionList = MultiDAO.getAllAcademicInstitutions();
		request.setAttribute("institutions", institutionList);

		List<Position> clubPositionList = new ArrayList<Position>();
		clubPositionList = MultiDAO.getAllClubPositions();
		request.setAttribute("clubPositions", clubPositionList);

		List<ClubSoc> clubSocList = new ArrayList<ClubSoc>();
		clubSocList = MultiDAO.getAllClubAndSocs();
		request.setAttribute("clubsocs", clubSocList);

		List<Qualification> qualificationList = new ArrayList<Qualification>();
		qualificationList = MultiDAO.getAllQualifications();
		request.setAttribute("qualifications", qualificationList);

		List<FieldOfStudy> fieldOfStudyList = new ArrayList<FieldOfStudy>();
		fieldOfStudyList = MultiDAO.getAllFieldsOfStudy();
		request.setAttribute("fields", fieldOfStudyList);

		List<Position> jobPositionList = new ArrayList<Position>();
		jobPositionList = MultiDAO.getAllJobPositions();
		request.setAttribute("experiencePosition", jobPositionList);

		List<Company> companyList = new ArrayList<Company>();
		companyList = MultiDAO.getAllCompanies();
		request.setAttribute("experienceCompanies", companyList);

		List<Location> locationList = new ArrayList<Location>();
		locationList = MultiDAO.getAllLocations();
		request.setAttribute("locations", locationList);
		
		List<Skill> skillList = new ArrayList<Skill>();
		skillList = MultiDAO.getAllSkills();
		request.setAttribute("skills", skillList);

		HttpSession session = request.getSession(true);
		User user = new User();
		user = (User) session.getAttribute("currentSessionUser");
		int id = user.getId();
		Profile profile = new Profile();
		profile = ProfileDAO.index(id);
		request.setAttribute("profile", profile); // set array list
		RequestDispatcher view = request
				.getRequestDispatcher("profiles/index.jsp");
		view.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = request.getSession(true);
		User user = new User();
		user = (User) session.getAttribute("currentSessionUser");
		int id = user.getId();
		Profile profile = ProfileDAO.getPersonalProfile(id);

		if (request.getParameter("personalProfile") != null) {

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String summary = request.getParameter("summary");
			int position = Integer.parseInt(request.getParameter("position"));
			int institution = Integer.parseInt(request
					.getParameter("institution"));

			ProfileDAO.updatePersonalProfile(id, firstName, lastName, summary,
					position, institution);
		}
		if (request.getParameter("clubsAndSocs") != null) {
			int profileClubSocId = Integer.parseInt(request
					.getParameter("profileClubSocId"));
			int clubsoc = Integer.parseInt(request.getParameter("clubSoc"));
			int position = Integer.parseInt(request
					.getParameter("clubSocPosition"));
			int clubSocStart = Integer.parseInt(request
					.getParameter("clubSocStart"));
			int clubSocEnd = Integer.parseInt(request
					.getParameter("clubSocEnd"));
			String description = request.getParameter("clubSocDesc");

			ProfileDAO.updateProfileClubsAndSocs(profileClubSocId, clubsoc,
					position, description, clubSocStart, clubSocEnd);
		}
		if (request.getParameter("clubsAndSocsDel") != null) {
			int profileClubSocId = Integer.parseInt(request
					.getParameter("profileClubSocId"));

			ProfileDAO.delProfileClubsAndSocs(profileClubSocId);
		}

		if (request.getParameter("clubsAndSocsNew") != null) {
			int clubsoc = Integer.parseInt(request.getParameter("clubSoc"));
			int position = Integer.parseInt(request
					.getParameter("clubSocPosition"));
			int clubSocStart = Integer.parseInt(request
					.getParameter("clubSocStart"));
			int clubSocEnd = Integer.parseInt(request
					.getParameter("clubSocEnd"));
			String description = request.getParameter("clubSocDesc");

			ProfileDAO.addProfileClubsAndSocs(profile.getId(), clubsoc,
					position, description, clubSocStart, clubSocEnd);
		}
		if (request.getParameter("privacyForm") != null) {
			System.out.println("PRIVACY CHANGED");
			int privacySetting = (request.getParameter("privacyForm"))
					.equals("true") ? 1 : 0;

			ProfileDAO.updatePrivacy(profile.getId(), privacySetting);
		}

		if (request.getParameter("educationChange") != null
				|| request.getParameter("educationAdd") != null) {
			int educationQualification = Integer.parseInt(request
					.getParameter("educationQualification"));
			int educationInstitution = Integer.parseInt(request
					.getParameter("educationInstitution"));
			int educationFieldOfStudy = Integer.parseInt(request
					.getParameter("educationFieldOfStudy"));
			int educationStart = Integer.parseInt(request
					.getParameter("educationStart"));
			int educationEnd = Integer.parseInt(request
					.getParameter("educationEnd"));
			String educationGrade = request
					.getParameter("educationQualification");
			String educationDescription = request
					.getParameter("educationDescription");

			if (request.getParameter("educationChange") != null) {
				int profileEducationId = Integer.parseInt(request
						.getParameter("profileEducationId"));

				String values = " profile_id =" + profileEducationId;
				values += ", institution_id=" + educationInstitution;
				values += ", qualification_id=" + educationQualification;
				values += ", field_of_study_id=" + educationFieldOfStudy;
				values += ", grade=\"" + educationGrade + "\"";
				values += ", description=\"" + educationDescription + "\"";
				values += ", start=" + educationStart;
				values += ", end='" + educationEnd;

				ProfileDAO.updateRow("profiles_academia", values,
						profileEducationId);
			} else {
				String values = "NULL";
				values += ", " + profile.getId();
				values += ", " + educationInstitution + ",NULL";
				values += ", " + educationQualification;
				values += ", " + educationFieldOfStudy;
				values += ", " + educationStart;
				values += ", " + educationEnd;
				values += ", \"" + educationGrade + "\"";
				values += ", \"" + educationDescription + "\"";

				ProfileDAO.addRow("profiles_academia", values);
			}
		}

		if (request.getParameter("educationDelete") != null) {
			int profileEducationId = Integer.parseInt(request
					.getParameter("profileEducationId"));

			ProfileDAO.deleteRow("profiles_academia", profileEducationId);
		}

		if (request.getParameter("experienceForm") != null
				|| request.getParameter("experienceNew") != null) {

			int experiencePosition = Integer.parseInt(request
					.getParameter("experiencePosition"));
			int experienceCompany = Integer.parseInt(request
					.getParameter("experienceCompany"));
			int experienceLocation = Integer.parseInt(request
					.getParameter("experienceLocation"));
			String expStart = request.getParameter("expStartIn");
			String expEnd = request.getParameter("expEndIn");
			String description = request.getParameter("expDesc");
			DateFormat df = new SimpleDateFormat("MMM yyyy");
			DateFormat dfSql = new SimpleDateFormat("yyyy-MM-dd");
			Date start = null;
			Date end = null;
			try {
				start = df.parse(expStart);
				end = df.parse(expEnd);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (request.getParameter("experienceForm") != null) {
				int profileExperienceId = Integer.parseInt(request
						.getParameter("profileExperienceId"));

				String values = " position_id =" + experiencePosition;
				values += ", company_id=" + experienceCompany;
				values += ", location_id=" + experienceLocation;
				values += ", description=\"" + description + "\"";
				values += ", start='" + dfSql.format(start).toString() + "'";
				values += ", end='" + dfSql.format(end).toString() + "'";

				ProfileDAO.updateRow("profiles_experience", values,
						profileExperienceId);
			} else {
				String values = "NULL";
				values += ", " + profile.getId();
				values += ", " + experienceCompany;
				values += ", " + experiencePosition;
				values += ", " + experienceLocation;
				values += ", \"" + description + "\"";
				values += ", '" + dfSql.format(start).toString() + "'";
				values += ", '" + dfSql.format(end).toString() + "'";

				ProfileDAO.addRow("profiles_experience", values);
			}
		}

		if (request.getParameter("expDel") != null) {
			int profileExperienceId = Integer.parseInt(request
					.getParameter("profileExperienceId"));

			ProfileDAO.deleteRow("profiles_experience", profileExperienceId);
		}

		if (request.getParameter("resultChange") != null
				|| request.getParameter("resultAdd") != null
				|| request.getParameter("resultDelete") != null) {
			

			if (request.getParameter("resultDelete") != null) {
				int resultId = Integer.parseInt(request.getParameter("resultId"));
				ProfileDAO.deleteRow("profiles_academia_results", resultId);
			} else {
				int resultYear = Integer.parseInt(request
						.getParameter("resultYear"));
				String resultSubject = request.getParameter("resultSubject");
				String resultResult = request.getParameter("resultResult");

				if (request.getParameter("resultChange") != null) {
					int resultId = Integer.parseInt(request.getParameter("resultId"));
					String values = "year =" + resultYear;
					values += ", subject =\"" + resultSubject + "\"";
					values += ", result =\"" + resultResult + "\"";

					ProfileDAO.updateRow("profiles_academia_results", values,
							resultId);
				}
				else{
					int educationId = Integer.parseInt(request
							.getParameter("educationId"));
					String values = "NULL, " +educationId;
					values += ", " +resultYear;
					values += ", \"" + resultSubject + "\"";
					values += ", \"" + resultResult + "\"";
 							
					
					ProfileDAO.addRow("profiles_academia_results", values);	
				}
			}

		}
		
		if (request.getParameter("skillAdd") != null|| (request.getParameter("skillDelete") != null)) {
			if(request.getParameter("skillDelete") != null){
				int skillId = Integer.parseInt(request
						.getParameter("skillId"));
				ProfileDAO.deleteRow("profiles_skills", skillId);
			}
			
			else {
				int skill = Integer.parseInt(request
						.getParameter("profileSkill"));
				String values = "NULL, " +profile.getId() +"," +skill;
				ProfileDAO.addRow("profiles_skills", values);
			}
		}

		response.sendRedirect("profiles");
	}

}