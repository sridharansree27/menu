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
 <br>
 <form action="DeleteOrder" method="get">
 Enter Id <input type = "text" name = "id"><br>
 Enter Quantity <input type = "number" name = "quantity"><br>
 <input type = "submit">
</body>
</html>