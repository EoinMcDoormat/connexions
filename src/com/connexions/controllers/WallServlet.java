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
import com.connexions.models.Wall;
import com.connexions.models.dao.ProfileDAO;
import com.connexions.models.dao.UserDAO;
import com.connexions.models.dao.WallDAO;

@WebServlet("/walls")
public class WallServlet extends HttpServlet {
	private static final long serialVersionUID = -2037933989085481943L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession(true);
		User user = new User();
		user = (User) session.getAttribute("currentSessionUser");
		int id = user.getId();
		List<Wall> wallList = new ArrayList<Wall>();
		wallList = WallDAO.getAllStatuses(id);
		request.setAttribute("wall", wallList); // set array list		
		RequestDispatcher view = request
				.getRequestDispatcher("walls/index.jsp");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession(true);
		User user = new User();
		user = (User) session.getAttribute("currentSessionUser");
		int id = user.getId();
		String status = request.getParameter("status");
		String comment = request.getParameter("comment");
		String status_id = request.getParameter("status_id");

		if(status != null){
		WallDAO.addStatus(id, status);
		}
		else if (comment != null){
			WallDAO.addComment(id, status_id, comment);			
		}

		response.sendRedirect("walls");
	}	

}
