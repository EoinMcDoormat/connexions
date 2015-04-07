package com.connexions.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connexions.models.Profile;
import com.connexions.models.User;
import com.connexions.models.dao.ProfileDAO;
import com.connexions.models.dao.UserDAO;

@WebServlet("/profiles")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -2037933989085481943L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
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

		response.sendRedirect("index.jsp");
	}	

}