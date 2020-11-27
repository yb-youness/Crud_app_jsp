<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.model.User"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/lux/bootstrap.min.css" integrity="sha384-9+PGKSqjRdkeAU7Eu4nkJU8RFaH8ace8HGXnkiKMP9I9Te0GJ4/km3L1Z8tXigpG" crossorigin="anonymous">
<%
  String action="";
  User user=(User) request.getAttribute("Ex_Users");
  boolean ejava=false,ec=false,ephp=false,ejavascript=false, ecpl=false;
     String action_msg ="insert";
     if(user==null){
    	   action="insert";
    	   
       }else{
    	   action="edit?id="+user.getId();
    	   action_msg ="Update";
    	   ejava=user.getFvlang().contains("Java");
    	   ejavascript=user.getFvlang().contains("JavaScript");		
    	   ec=user.getFvlang().contains("c++");
    	   ephp=user.getFvlang().contains("php");
    	   ec=user.getFvlang().contains("C#");
    	   	
    	  
       }
       
       String msg= (String) request.getParameter("msg");
       String msg_display="";   
        if(msg!=null){
        	 if(msg.equals("success")){
          	   msg_display="Record added with success !";  
                 }else if(!msg.equals("success")){ 
              	   msg_display="User Updated Whith Succses !";}
        }
      
      
%>
<title><%=action %>  User </title>
</head>
<body>
<%@ include file="./inc/nav.jsp" %>

<div class="container mt-3">
       <h1><%=action_msg %> User</h1>

 <% if(msg!=null) {%>
<div class="alert alert-dismissible alert-<%=msg%>">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
    <%= msg_display %>
</div>
<% } %>
	   <form method="POST" action="<%=action %>">
	     <div class="form-group">
	      <label for="exampleInputEmail1">Email address</label>
	      <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" <%if(action_msg=="Update") { %> value=<%out.print(user.getEmail());} %>>
	    </div>
	     <div class="form-group">
	      <label for="name">Name</label>
	      <input type="text" name="name"  class="form-control"  placeholder="Enter Name" <%if(action_msg=="Update")  { %> value="<%=user.getName() %> <%} %>">
	    </div>
	      <div class="form-check">
	        <div class="form-check-label"> Langages Prefere:
	          <ul>
	            <li><input class="form-check-input" name="lang" type="checkbox" value="Java" <% if(ejava){ %> checked="checked" <%} %>>   java</li>
	            <li><input class="form-check-input" name="lang" type="checkbox" value="C#" <% if(ec){ %> checked="checked" <%} %>>   C#</li>
	             <li><input class="form-check-input" name="lang" type="checkbox" value="JavaScript" <% if(ejavascript){ %> checked="checked" <%} %> >  javascript</li>
	              <li><input class="form-check-input" name="lang" type="checkbox" value="c++" <% if(ecpl){ %> checked="checked" <%} %>>  C++</li>
	               <li><input class="form-check-input" name="lang" type="checkbox" value="php" <% if(ephp){ %> checked="checked" <%} %> >  php</li>
	          </ul>
	        </div>
	        <button type="submit" class="btn btn-primary" ><%= action_msg %> User !</button>
	        
	      </div>
	      
	     
	    </form>
 </div>
 
  <%@ include file="./inc/footer.html" %>