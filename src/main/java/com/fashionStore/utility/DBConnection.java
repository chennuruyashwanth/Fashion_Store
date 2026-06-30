package com.fashionStore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/fashion_store";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "Yash@2586";
    

    public static Connection getConnection() {
    	
    	Connection connection = null;

        try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		}

        return connection;
    }
}
