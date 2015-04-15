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

import com.connexions.models.Message;
import com.connexions.models.Notification;
import com.connexions.models.User;
import com.connexions.models.dao.NotificationDAO;

@WebServlet("/messages")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 6263655861067412880L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		HttpSession session = request.getSession(true);
		User user = new User();
		user = (User) session.getAttribute("currentSessionUser");
		int id = user.getId();
		
		List<Message> inbox = new ArrayList<Message>();
		inbox = MessageDAO.getAllMessages(id);
		
		request.setAttribute("inbox", inbox); // set array list
		RequestDispatcher view = request
				.getRequestDispatcher("messages/index.jsp");
		view.forward(request, response);
	}
}