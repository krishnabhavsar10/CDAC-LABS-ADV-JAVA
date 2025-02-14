<%@ page language="java"  import="java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		for(int iTmp=0;iTmp<20;iTmp++)
		{
	%>
			<h3><%= new java.util.Date() %></h3>
	<%
		}
	%>
	<hr/>
	
	<%
		for(int iTmp=0;iTmp<20;iTmp++)
		{
			out.println(new Date());
		}
	%>
</body>
</html>








