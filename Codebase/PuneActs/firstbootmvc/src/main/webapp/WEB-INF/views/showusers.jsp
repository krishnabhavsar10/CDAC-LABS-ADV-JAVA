<%@page import="java.util.Iterator"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
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
			<th>User Name</th>
			<th>Password</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		
		<%
			String jsonUsers = (String) request.getAttribute("users");
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(jsonUsers);
			Iterator<JsonNode> allUsers = root.elements();
			while(allUsers.hasNext())
			{
				JsonNode objUser = allUsers.next();
				String userName = objUser.path("userName").asText();
				String password = objUser.path("password").asText();
				String name = objUser.path("name").asText();
				String email = objUser.path("email").asText();
		%>
				<tr>
					<td><%=userName %></td>
					<td><%=password %></td>
					<td><%=name %></td>
					<td><%=email %></td>
				</tr>
		<%	
			}			
		%>
	
	</table>
	<a href='showusers?pageNo=<%=Integer.parseInt(request.getParameter("pageNo"))+1 %>'>Next</a>
	
</body>
</html>









