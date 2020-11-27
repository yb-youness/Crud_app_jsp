package com.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDb {
	
	private static String Jdbc_UrL ="jdbc:mysql://localhost:3306/devflang";
	private static String User_Name ="root";
	private static String Pass ="";
	
	public static Connection Con() {
		Connection con=null;
	      try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  con=DriverManager.getConnection(Jdbc_UrL,User_Name,Pass);
	      }catch(SQLException e) {
	    	  e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	  
	    
		return con;		
	}

}
