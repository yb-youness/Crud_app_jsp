package com.service;

import java.util.List;

import com.model.User;

public interface CrudOps {

	void Add_User(User user);  // Add A single user
	User Get_User(int id); // get A single User
	List <User> Get_Users(); // List All Users
	boolean Del_user (int id); // Del One User
	boolean Update_User(User user); // Update A user 
	
}
