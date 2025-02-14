<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
	<%
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_acts","acts","Cdac@123");
				PreparedStatement psCategory = connection.prepareStatement("select * from category") ;
				ResultSet result = psCategory.executeQuery();)
		{
			while(result.next())
			{
	%>
				<tr>
					<td><%= result.getString("categoryName") %></td>
					<td><%= result.getString("categoryDescription") %></td>
					<td><%= result.getString("categoryImageUrl") %></td>
				</tr>
	<%
			}
		}	
	%>
	</table>
</body>
</html>