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
Welcome <b><%=session.getAttribute("userName") %></b>
	<table border='1'>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
	<%
			Connection connection = (Connection)application.getAttribute("globalConnection");
			try(
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