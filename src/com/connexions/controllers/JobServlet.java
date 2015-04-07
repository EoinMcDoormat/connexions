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

import com.connexions.models.Job;
import com.connexions.models.Profile;
import com.connexions.models.User;
import com.connexions.models.Wall;
import com.connexions.models.dao.JobDAO;
import com.connexions.models.dao.ProfileDAO;
import com.connexions.models.dao.WallDAO;

@WebServlet("/jobs")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = -2037933989085481943L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		List<Job> jobList = new ArrayList<Job>();
		jobList = JobDAO.getAllJobs();
		request.setAttribute("jobs", jobList); // set array list		
		RequestDispatcher view = request
				.getRequestDispatcher("jobs/index.jsp");
		view.forward(request, response);
	}
}
