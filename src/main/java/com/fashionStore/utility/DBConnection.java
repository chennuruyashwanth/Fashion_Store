package com.fashionStore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	 private static final String URL  = System.getenv("DB_URL") ;

	    private static final String USERNAME  = System.getenv("DB_USER");

	    private static final String PASSWORD = System.getenv("DB_PASSWORD");
	    
    public static Connection getConnection() {
    	
    	Connection connection = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("URL = " + URL);
        	System.out.println("USER = " + USERNAME);
        	
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database Connected Successfully");
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		}

        return connection;
    }
}
