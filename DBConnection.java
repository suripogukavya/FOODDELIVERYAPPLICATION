package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static final String URL="jdbc:mysql://localhost:3306/FOODAPP";
	static final String USERNAME="root";
	static final String PASSWORD="rgukt123";
	private static Connection connection;
	public static Connection getConnection()
	{
	try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
     	}
	catch(Exception e)
	{
		e.printStackTrace();

	
	}
	return connection;
   }
}  
