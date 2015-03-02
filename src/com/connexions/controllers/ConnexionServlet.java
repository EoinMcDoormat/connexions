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

import com.connexions.models.Connexion;
import com.connexions.models.User;
import com.connexions.models.dao.ConnexionDAO;

@WebServlet("/connexions")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 6263655861067412880L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = request.getSession(true);
		User user = new User();
		user = (User) session.getAttribute("currentSessionUser");
		int id = user.getId();
		String action = request.getParameter("action");
		String addId = request.getParameter("add");
		String removeId = request.getParameter("remove");
		String acceptId = request.getParameter("accept");
		String rejectId = request.getParameter("reject");

		List<Connexion> connexions = new ArrayList<Connexion>();

		if (action != null) {
			if (action.equals("view")) {
				view(id, connexions, request, response);
			} else if (action.equals("showrequests")) {
				showrequests(id, connexions, request, response);
			} else if (action.equals("search")) {
				search(id, connexions, request, response);
			}
		}

		else {
			if (addId != null) {

				add(id, Integer.parseInt(addId), connexions, request, response);
			}
			if (removeId != null) {

				remove(id, Integer.parseInt(removeId), connexions, request, response);
			}
			if (acceptId != null) {

				accept(id, Integer.parseInt(acceptId), connexions, request, response);
			}
			if (rejectId != null) {

				reject(id, Integer.parseInt(rejectId), connexions, request, response);
			}
		}
	}

	private void reject(int id, int conid, List<Connexion> connexions,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			ConnexionDAO.rejectConnexion(conid, id);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void accept(int id, int conid, List<Connexion> connexions,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			ConnexionDAO.acceptConnexion(conid, id);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void remove(int id, int conid, List<Connexion> connexions,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			ConnexionDAO.removeConnexion(id, conid);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void add(int addId, int connId, List<Connexion> connexions, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			ConnexionDAO.requestConnexion(addId, connId);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
		
	}

	private void search(int id, List<Connexion> connexions,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String searchString = request.getParameter("searchString");
			connexions = ConnexionDAO.searchConnexions(searchString);
			request.setAttribute("search", connexions); // set array list
			RequestDispatcher view = request
					.getRequestDispatcher("connexion.jsp");
			view.forward(request, response);
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void showrequests(int id, List<Connexion> requests,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			requests = ConnexionDAO.showRequests(id);

			request.setAttribute("requests", requests);
			RequestDispatcher view = request
					.getRequestDispatcher("connexion.jsp");
			view.forward(request, response);

		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void view(int id, List<Connexion> connexions,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			connexions = ConnexionDAO.showAllConnexions(id);
			request.setAttribute("connexions", connexions);
			RequestDispatcher view = request
					.getRequestDispatcher("connexion.jsp");
			view.forward(request, response);
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}