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

import com.connexions.models.dao.FriendDAO;
import com.connexions.models.Friend;
import com.connexions.models.User;

@WebServlet("/friends")
public class FriendServlet extends HttpServlet {
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

		List<Friend> friends = new ArrayList<Friend>();

		if (action != null) {
			if (action.equals("view")) {
				view(id, friends, request, response);
			} else if (action.equals("showrequests")) {
				showrequests(id, friends, request, response);
			} else if (action.equals("search")) {
				search(id, friends, request, response);
			}
		}

		else {
			if (addId != null) {

				add(id, Integer.parseInt(addId), friends, request, response);
			}
			if (removeId != null) {

				remove(id, Integer.parseInt(removeId), friends, request, response);
			}
			if (acceptId != null) {

				accept(id, Integer.parseInt(acceptId), friends, request, response);
			}
			if (rejectId != null) {

				reject(id, Integer.parseInt(rejectId), friends, request, response);
			}
		}
	}

	private void reject(int id, int conid, List<Friend> friends,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			FriendDAO.rejectFriend(conid, id);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void accept(int id, int conid, List<Friend> friends,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			FriendDAO.acceptFriend(conid, id);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void remove(int id, int conid, List<Friend> friends,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			FriendDAO.removeFriend(id, conid);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void add(int addId, int connId, List<Friend> friends, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			FriendDAO.requestFriend(addId, connId);
			response.sendRedirect("home.jsp");				
		
		} catch (Throwable theException) {
			System.out.println(theException);
		}
		
	}

	private void search(int id, List<Friend> friends,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String searchString = request.getParameter("searchString");
			friends = FriendDAO.searchFriends(searchString);
			request.setAttribute("search", friends); // set array list
			RequestDispatcher view = request
					.getRequestDispatcher("friends/index.jsp");
			view.forward(request, response);
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void showrequests(int id, List<Friend> requests,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			requests = FriendDAO.showRequests(id);

			request.setAttribute("requests", requests);
			RequestDispatcher view = request
					.getRequestDispatcher("friends/index.jsp");
			view.forward(request, response);

		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void view(int id, List<Friend> friends,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			friends = FriendDAO.showAllFriends(id);
			request.setAttribute("friends", friends);
			RequestDispatcher view = request
					.getRequestDispatcher("friends/index.jsp");
			view.forward(request, response);
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}