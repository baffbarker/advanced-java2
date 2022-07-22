package com.caveofprogramming.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Properties props = new Properties();
		try {
			props.load(App.class.getResourceAsStream("/config/db.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
		var db = Database.instance();

		try {
			db.connect(props);
		} catch (SQLException e) {
			System.out.println("Cannopt connect to db");
			return;
		}

		System.out.println("Connected");

		UserDao userDao = new UserDaoImpl();

		// userDao.save(new User("Neptune"));

		var users = userDao.getAll();

		users.forEach(System.out::println);

		var userOpt = userDao.findById(4);

		if (userOpt.isPresent()) {

			User user = userOpt.get();
			System.out.println("retrieved: " + user);
			user.setName("Snoopy");
			userDao.update(user);
		} else {
			System.out.println("No user retrieved");
		}

		userDao.delete(new User(5, null));

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close db");
		}
	}
}
