<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	System.out.println("firstjsp fired");
		String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	%>
	this is the first jsp page 
			<%=userName %><br/>
			<%-- <jsp:forward page="second.jsp"></jsp:forward> --%>
		<%
			response.sendRedirect("https://google.co.in");
		%>	
			
</body>
</html>