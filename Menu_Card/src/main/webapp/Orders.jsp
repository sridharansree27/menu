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
 List<String> orders=(List<String>)request.getAttribute("orders");
 Long price=(Long)request.getAttribute("totalPrice");
 %>
 <%
 if(orders.isEmpty()){
 request.getRequestDispatcher("menu").forward(request, response);
 }else{
 %>
 <h1><p style="color:blue">ToMatoOrders</h1>
 
 <table border="2px">
 
 <tr>
 <th>ID</th>
 <th>Dish</th>
 <th>Quantity in kg</th>
 <th>Price of total quantity</th>
 </tr>
 <%
 for(int i=0;i<orders.size();++i) {
 %>
 <tr>
 <td><%=orders.get(i) %></td>
 <td><%=orders.get(++i) %></td>
 <td><%=orders.get(++i) %></td>
 <td><%=orders.get(++i) %></td>
 </tr>
 <%
 }
 %>
 </table>
 <a href="order">Add Dish</a><br>
 <a href="GetOrder">Cancel Dish</a><br>
 <a href="Bill">Get Bill</a>
 <%
 }
 %>
</body>
</html>