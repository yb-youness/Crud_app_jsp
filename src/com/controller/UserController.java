package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserCrud;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserCrud user_ops;
   
    public UserController() {
        super();
      
    }

	@Override
	public void init() throws ServletException {
		user_ops=new UserCrud();
		super.init();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();
	  
		
		     try {	   
	           
		    switch (action) {
		     case "/":
			    	// Show All The Users
		    	 List_All(request, response);
				break;
		     case "/list":
			    	// Show All The Users
		    	 List_All(request, response);
				break;	
		      case "/add":
					// Show The Add Form 
		    	  ShowForm(request, response, "Add");
					break;
		       case "/insert":
		 			// Insert logic
		 		       insert(request, response);
		 				break;		
				case "/update":
					// Show The Update Form  + bind data
				     Showupdate(request, response);
					break;
				case "/edit":
					// Presiste the edit logic
					Update(request, response);
					break;	
				case "/delete":
				     // Delete The Recored
					Delet(request, response);
					break;
					
				case "/about":
					 ShowForm(request, response, "about");
					break;		

				default:
					ShowForm(request, response, "404");
				}
		    	 
		    	 
	           }catch (Exception e) {
				 e.printStackTrace();
			}	   
		
	}

	
	
	// Show Add Form 
	private void ShowForm(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("views/"+path+".jsp");
	   rq.forward(request, response);
	}
	
	// Show Edit Form  +bind
	private void Showupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		User users= user_ops.Get_User(id);
		users.setId(id);
		request.setAttribute("Ex_Users",users);
		// To Do  Add  session variable for The Id 
		
		ShowForm(request, response,"Add");
	}
	
	
	//To do Insert
	

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user =new User();
		 user.setEmail(request.getParameter("email"));
		 user.setName(request.getParameter("name"));
		 
		 //user fav lang 
		 String [] fvlang = request.getParameterValues("lang");
		 String lang="";
		 for(String item : fvlang) {
			   lang += " "+item+",";
		 }
		 user.setFvlang(lang);
		 user_ops.Add_User(user);
	
		response.sendRedirect("add?msg=success");
		
	}
	
	
	
	// To Do Update
	private void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 //user fav lang 
		 String [] fvlang = request.getParameterValues("lang");
		 String lang="";
		 for(String item : fvlang) {
			   lang += " "+item+",";
		 }
		 
		 User user =new User();
		 user.setEmail(request.getParameter("email"));
		 user.setName(request.getParameter("name"));
		 user.setFvlang(lang);
		 user.setId(id);
		    		 user_ops.Update_User(user);
   		 response.sendRedirect("add?msg=warning");
		
	   	
	}
	
	// To Do Delete
	
	
	private void Delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
    	 user_ops.Del_user(id);
		 String [] alert ={"alert-success","Element Delete with success"};
		 response.sendRedirect("list");
		  
	}
	
	// List All Users
	private void List_All(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		List<User> All_users= user_ops.Get_Users();
		request.setAttribute("Users",All_users);
		ShowForm(request, response, "index");
	}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
