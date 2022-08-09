<%@page import="DTO.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1><p style="color:blue">OrderToMato</h1>
 <form action="dish" method="get">
 <%
 List<Menu> menu=(List<Menu>)request.getAttribute("menu");
 %>
 <table border="2px">
 
 <tr>
 <th>ID</th>
 <th>Dish</th>
 <th>Quantity in kg</th>
 <th>Price per kg</th>
 </tr>
 <%
 for(Menu dish:menu){
 %>
 <tr>
 <td><%=dish.getId() %></td>
 <td><%=dish.getDish() %></td>
 <td><%=dish.getQuantity_in_kg() %></td>
 <td><%=dish.getPrice_per_kg() %></td>
 </tr>
 <%
 }
 %>
 </table>
 <br>
 Enter Id <input type = "text" name = "id"><br>
 Enter Quantity <input type = "number" name = "quantity"><br>
 <input type = "submit">
</body>
</html>