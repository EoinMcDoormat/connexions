package com.connexions.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connexions.models.User;
import com.connexions.models.dao.UserDAO;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = -2037933989085481943L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");

		if(action.equals("logout")) {
			logout(request, response);
		}
		else if (action.equals("Sign in")) {
			login(username, password, request, response);
		} else if (action.equals("register")) {
			register(username, password, request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
        try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private void register(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			user = UserDAO.register(user);

			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("home.jsp");
			} else
				response.sendRedirect("register.jsp?invalidRegistration");

		} catch (Throwable theException) {
			System.out.println(theException);
		}

	}

	private void login(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = new User(username, password);
			user = UserDAO.login(user);

			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("walls");
			} else
				response.sendRedirect("login.jsp?invalidLogin");

		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}