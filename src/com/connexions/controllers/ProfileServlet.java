package com.connexions.controllers;

import java.io.IOException;
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
import com.connexions.models.multi.Institution;
import com.connexions.models.multi.Position;
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

		if (request.getParameter("personalProfile") != null) {
		    
		    String firstName = request.getParameter("firstName");
		    String lastName = request.getParameter("lastName");
		    String summary = request.getParameter("summary");
		    int position = Integer.parseInt(request.getParameter("position"));
		    int institution = Integer.parseInt(request.getParameter("institution"));
		    
		    ProfileDAO.updatePersonalProfile(id, firstName, lastName, summary, position, institution);
		}
		if (request.getParameter("clubsAndSocs") != null) {
		    int profileClubSocId = Integer.parseInt(request.getParameter("profileClubSocId"));
		    int clubsoc = Integer.parseInt(request.getParameter("clubSoc"));
		    int position = Integer.parseInt(request.getParameter("clubSocPosition"));
		    int clubSocStart = Integer.parseInt(request.getParameter("clubSocStart"));
		    int clubSocEnd = Integer.parseInt(request.getParameter("clubSocEnd"));
		    String description = request.getParameter("clubSocDesc");
		    
		    ProfileDAO.updateProfileClubsAndSocs(profileClubSocId, clubsoc, position, description, clubSocStart, clubSocEnd);
		}
		
		
		response.sendRedirect("profiles");
	}	

}