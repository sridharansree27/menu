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
 <%
 List<Menu> menu=(List<Menu>)request.getAttribute("menu");
 %>
 <%
 if(menu.isEmpty()){
 %>
 <h1><p style="color:blue">Sorry, no dishes available now !</h1>
 <%
 }else{
 %>
 <h1><p style="color:blue">AvailableToMato</h1>
 
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
 <a href="order">Order Now</a>
 <br>
 <%
 }
 %>
 <a href="orders">Orders</a>
 <br>
 <a href="logout">Log Out</a>
</body>
</html>