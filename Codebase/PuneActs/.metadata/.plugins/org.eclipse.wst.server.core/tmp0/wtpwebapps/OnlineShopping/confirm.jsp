<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="objUser" class="fi.beans.User" scope="session"/>
	
	<%
		objUser.display(pageContext);
	%>
	
	
	<jsp:setProperty property="*" name="objUser"/>
	 
	User Name : <jsp:getProperty property="userName" name="objUser"/>
	<br/>
	Name : <jsp:getProperty property="name" name="objUser"/><br/>
	Email : <jsp:getProperty property="email" name="objUser"/>
	<a href='Register'>Register</a>
	
</body>
</html>