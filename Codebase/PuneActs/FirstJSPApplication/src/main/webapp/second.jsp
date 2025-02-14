<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
this is the second jsp page
<%
	System.out.println("second jsp fired");
%>
	<%=request.getParameter("userName") %>
	<%=request.getParameter("password") %>
	
</body>
</html>