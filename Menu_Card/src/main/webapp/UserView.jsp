<%@page import="DTO.User"%>
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
 User user=(User)request.getAttribute("user");
 %>
 <h1><p style="color:blue">ToMatoUser</h1>
 <table border="2px">
 
 <tr>
 <th>ID</th>
 <th>Name</th>
 <th>Email</th>
 </tr>
 
 <tr>
 <td><%=user.getId() %></td>
 <td><%=user.getName() %></td>
 <td><%=user.getEmail() %></td>
 </tr>
 
 </table>
 <br>
 <a href="logout">Log Out</a>
</body>
</html>