<%@page import="java.sql.PreparedStatement"%>
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
	<jsp:useBean id="objUser" scope="session" type="fi.beans.User"/>
	
	<%
	
		Connection connection =(Connection) application.getAttribute("globalConnection");
		PreparedStatement psInsert = connection.prepareStatement("insert into users values(?,?,?,?)");
		
		psInsert.setString(1,objUser.getUserName());
		psInsert.setString(2,objUser.getPassword());
		psInsert.setString(3,objUser.getName());
		psInsert.setString(4,objUser.getEmail());
		
		psInsert.executeUpdate();
				
	%>
	User registered....
</body>
</html>