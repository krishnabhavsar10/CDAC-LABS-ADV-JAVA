<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="login" modelAttribute="objUser">
		UName : <form:input path="userName"/><form:errors path="userName" cssStyle="color:red"/> <br/>
		Pwd : <form:password path="password"/><form:errors path="password" cssStyle="color:red"/><br/>
		<form:button value="submit">Login</form:button>
	</form:form>
</body>
</html>