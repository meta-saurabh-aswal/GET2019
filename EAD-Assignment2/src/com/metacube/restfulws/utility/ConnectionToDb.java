package com.metacube.restfulws.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb 
{
	public static Connection getConnection()
	{
		Connection conn = null;
		
		String dbUrl = UtilityDb.dbUrl;
		String username = UtilityDb.dbUser;
	    String password = UtilityDb.dbPassword;
	    
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn = DriverManager.getConnection(dbUrl, username, password);
	    	
	    }
	    catch (SQLException e)
	    {
	    	e.printStackTrace();
        }
	    catch (ClassNotFoundException e)
	    { 
	    	e.printStackTrace();
	    }
	    
	    System.out.println(conn);
	    
	    return conn;
	}

}
