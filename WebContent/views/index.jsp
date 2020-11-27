<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.List,com.model.User"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/lux/bootstrap.min.css" integrity="sha384-9+PGKSqjRdkeAU7Eu4nkJU8RFaH8ace8HGXnkiKMP9I9Te0GJ4/km3L1Z8tXigpG" crossorigin="anonymous">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<title> Show Users </title>
</head>
<body>
   <%@ include file="./inc/nav.jsp" %>
   
   <div class="container">
  <%
    String [] alert =(String []) request.getAttribute("alert");
     if(alert != null)  {
  %>    
   <div class="alert alert-dismissible  <%= alert[0]%> mt-3">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
      <strong> <%= alert[1]%> </strong> 
   </div>
    <%} 
     List<User> all =(List<User>)request.getAttribute("Users");
     if(!all.isEmpty()){
    
    %>
	 <table class="table table-hover mt-3">
	  <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Name</th>
	      <th scope="col">Email</th>
	      <th scope="col">Favorite Programming Lang</th>
	       <th scope="col" colspan="2">Opreation</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	 
	      for(User user : all){
	   %>
	    <tr class="table-active">
	      <td><%=user.getId() %></td>
	      <td><%=user.getName() %></td>
	      <td><%=user.getEmail() %></td>
	      <td><%=user.getFvlang() %></td>
	      <td><a class="btn btn-warning"  href="update?id=<%=user.getId() %>">Edit</a></td>
	       <td><a class="btn btn-danger"  href="delete?id=<%=user.getId() %>" onclick="return confirm('Vous Volulez Suprimer !!!')" >Delete</a></td>
	    </tr>
	    <%} }else{%>
	         <p class="mt-3 text-warning">Data base Empty !</p>
	    <% } %>
	   </tbody>
	  </table> 

 
<%@ include file="./inc/footer.html" %>

  
