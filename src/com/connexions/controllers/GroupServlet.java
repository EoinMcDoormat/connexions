package com.connexions.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connexions.models.Group;
import com.connexions.models.Notification;
import com.connexions.models.User;
import com.connexions.models.dao.GroupDAO;
import com.connexions.models.dao.NotificationDAO;

	@WebServlet("/groups")
	public class GroupServlet extends HttpServlet {
		private static final long serialVersionUID = -2037933989085481943L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, java.io.IOException {
			
			List<Group> groupList = new ArrayList<Group>();
			
			HttpSession session = request.getSession(true);
			User user = new User();
			user = (User) session.getAttribute("currentSessionUser");
			int id = user.getId();
			

			groupList = GroupDAO.index(id);

			
			request.setAttribute("groups", groupList); // set array list
			RequestDispatcher view = request
					.getRequestDispatcher("groups/index.jsp");
			view.forward(request, response);
			
		}
}
