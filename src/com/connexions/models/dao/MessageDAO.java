package com.connexions.models.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.connexions.models.Job;
import com.connexions.utils.JDBCConnectionManager;

public class MessageDAO {
	
	public static List<Job> getAllMessages() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		List<Job> jobList = new ArrayList<Job>();

		String searchQuery = "SELECT jobs.id, jobs.user_id, positions, description, created, expired, deleted FROM jobs JOIN jobs_positions ON jobs_positions.id=jobs.position_id ORDER BY created DESC; ";

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Job job = new Job();
				job.setId((int) (list.get(i).get("id")));
				job.setPositions((String) (list.get(i).get("positions")));
				job.setDescriptions((String) (list.get(i).get("description")));
				job.setCreated((Date) (list.get(i).get("created")));
				job.setExpired((Date) (list.get(i).get("expired")));
				job.setDeleted((Date) (list.get(i).get("deleted")));
				int userId = (int) (list.get(i).get("user_id")); 
				job.setPoster(FriendDAO.getFriend(userId));
				jobList.add(job);
			}
		}
		return jobList;
	}

}
