package com.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.entity.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userCount = 4;

	static {
		users.add(new User(1, "Kohli", new Date()));
		users.add(new User(2, "ABD", new Date()));
		users.add(new User(3, "Maxi", new Date()));
		users.add(new User(4, "Yuzi", new Date()));
	}

	public String saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);

		}
		users.add(user);
		return "" + user + "";
	}

	public User getUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<User> gwtAllUser() {

		return users;
	}

	public void removeUser(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			} 
		}
	}
}
