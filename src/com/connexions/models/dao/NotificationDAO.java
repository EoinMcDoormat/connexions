package com.connexions.models.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.connexions.models.Job;
import com.connexions.models.Notification;
import com.connexions.utils.JDBCConnectionManager;

public class NotificationDAO {

	public static List<Notification> index(int userId) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		List<Notification> notificationList = new ArrayList<Notification>();

		String searchQuery = "SELECT notifications.id, notifications_types.name, notifications_types.link, link_id, checked FROM notifications JOIN notifications_types ON notification_type_id=notifications_types.id WHERE user_id=" +userId;

		list = JDBCConnectionManager.queryDatabase(searchQuery);

		if (list.isEmpty()) {
			System.out.println("No profile found");

		} else {
			for (int i = 0; i < list.size(); i++) {
				Notification notification = new Notification();
				notification.setId((int) (list.get(i).get("id")));
				notification.setNotificationType((String) (list.get(i).get("name")));
				String link = (String) (list.get(i).get("link"));
				link += (int) (list.get(i).get("link_id"));
				notification.setLink(link);
				notification.setRead((boolean) (list.get(i).get("checked")));
				
				notificationList.add(notification);
			}
		}
		return notificationList;
	}

	
	
}
