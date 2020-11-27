package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbUtil.ConnexionDb;
import com.model.User;



public class UserCrud implements CrudOps {
  
	
	
   private static String Select_All ="SELECT * FROM dev";
   private static String Insert_User ="INSERT INTO dev VALUES (default,?,?,?);";
   private static String Get_One ="SELECT * FROM dev Where id =?";
   private static String Update_User="UPDATE dev set name=? , email=?, favlang=? WHERE id=?";
   private static String Del_User="DELETE FROM dev  WHERE id=?";
	
   
   
   @Override
	public void Add_User(User user) {
	    try(Connection con = ConnexionDb.Con()){
	    	PreparedStatement pr =con.prepareStatement(Insert_User);
	    	pr.setString(1, user.getName());
	    	pr.setString(2, user.getEmail());
	    	pr.setString(3, user.getFvlang());
	  
	    	pr.executeUpdate();
	    }catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public User Get_User(int id) {
	   User user =new User();
	     try(Connection con = ConnexionDb.Con()){
	    	PreparedStatement pr = con.prepareStatement(Get_One);
	    	pr.setInt(1, id);
	    	 ResultSet rs= pr.executeQuery();
	    	   while(rs.next()) {
	    		   user.setName(rs.getString("name"));
	    		   user.setEmail(rs.getString("email"));
	    		   user.setFvlang(rs.getString("favlang"));
	    	   }
	     }catch (SQLException e) {
			 e.printStackTrace();
		}
		   
		return user;
	}

	@Override
	public List<User> Get_Users() {
		List<User> AllUsers =new ArrayList<>();
	    try(Connection con= ConnexionDb.Con()){
	    	PreparedStatement prStm = con.prepareStatement(Select_All);
	        ResultSet rs =prStm.executeQuery();
	         while(rs.next()) {
	          User user =new User();
	          user.setId(rs.getInt("id"));
	          user.setName(rs.getString("name"));
	          user.setEmail(rs.getString("email"));
	          user.setFvlang(rs.getString("favlang"));
	          AllUsers.add(user);
	          
	         }
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return AllUsers;
	}

	@Override
	public boolean Del_user(int id) {
	   boolean res=false; 
		try(Connection con = ConnexionDb.Con()){
         PreparedStatement pr = con.prepareStatement(Del_User);
         pr.setInt(1, id);
	     res= pr.execute();
	    }catch(SQLException e) {
	    	  e.printStackTrace();
	    	  return false;
	    }
		return res;
	}

	@Override
	public boolean Update_User(User user) {
		  try(Connection con =ConnexionDb.Con()){
			   PreparedStatement pr = con.prepareStatement(Update_User);
			   pr.setString(1, user.getName());
			   pr.setString(2, user.getEmail());
			   pr.setString(3, user.getFvlang());
			   pr.setInt(4, user.getId());
			   pr.executeUpdate();
		  }catch(SQLException e) {
			  e.printStackTrace();
			  return false;
		  }
		return true;
	}

}





