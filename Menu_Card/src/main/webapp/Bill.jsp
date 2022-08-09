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
 <h1><p style="color:blue">ToMatoBill</h1>
 
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
 <h1>Total Price: <%=price%>Rupee</h1>
 <a href="menu">Get Menu</a>
</body>
</html>