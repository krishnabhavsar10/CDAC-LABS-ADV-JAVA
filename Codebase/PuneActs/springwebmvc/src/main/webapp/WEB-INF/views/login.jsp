<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><spring:message code="lbl.title"/></h1>
	<form:form action="authenticate" modelAttribute="objUser">
		<spring:message code="lbl.username"/> : <form:input path="userName"/>
		<spring:message code="lbl.password"/> : <form:password path="password"/>
		<form:button value="submit"><spring:message code="lbl.submit"/></form:button>
	</form:form>
</body>
</html>