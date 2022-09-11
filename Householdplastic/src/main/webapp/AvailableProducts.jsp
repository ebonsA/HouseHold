
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reports</title>
    </head>
    <body>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "plastic";
String userId = "root";
String password = "Merry724#";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Available Products</strong></font></h2>
<a href = "index.jsp">Home</a><br/>
<a href = "CustomerReport.jsp">View Registered Customers</a>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="orange">
<td><b>Product Id</b></td>
<td><b>Product Name</b></td>
<td><b>Product Category</b></td>
<td><b>Unit Price</b></td>
<td><b>Quantity</b></td>
<td><b>Image</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM products";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="white">

<td><%=resultSet.getString("productId") %></td>
<td><%=resultSet.getString("ProductName") %></td>
<td><%=resultSet.getString("productCategory") %></td>
<td><%=resultSet.getString("unitPrice") %></td>
<td><%=resultSet.getString("Quantity") %></td>
<td><%=resultSet.getString("image") %></td>


</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
} 
%>
</table>
    </body>
</html>