<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
  String username=(String)session.getAttribute("username");
  if(username==null){
	  request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
  }
 %>
 <h1><p style="color:blue">WelcomeToMatoHome !</h1>
 <h2><a href="view">My Profile</a></h2>
 <h2><a href="menu">Get Menu </a></h2>
 <h2><a href="logout">Log Out</a></h2>
</body>
</html>