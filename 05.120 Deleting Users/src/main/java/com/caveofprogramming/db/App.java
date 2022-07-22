package com.caveofprogramming.db;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )   {
        System.out.println( "Hello World!" );
        
        var db = Database.instance();
        
        try {
			db.connect();
		} catch (SQLException e) {
			System.out.println("Cannopt connect to db");
		}
        
        System.out.println("Connected");
        
        UserDao userDao = new UserDaoImpl();
        
 
 //       userDao.save(new User("Neptune"));
        
        var users = userDao.getAll();
        
        users.forEach(System.out::println);
        
        var user = userDao.findById(11);
        System.out.println("retrieved: " + user);
        
        userDao.delete(new User(5, null));
        
        
        try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close db");
		}
    }
}
