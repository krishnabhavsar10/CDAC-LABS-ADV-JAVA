<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fi.hibernate.entity.Category"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
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
	<%
		SessionFactory hibernateFactory = (SessionFactory)application.getAttribute("hibernateFactory");
		try(Session hibernateSession = hibernateFactory.openSession())
		{
			Query<Category> query = hibernateSession.createQuery("from Category"); //HQL
			/* Query<Category> query = hibernateSession.createQuery(
										"select object(oCategory) from Category oCategory where oCategory.categoryId=:cid"); //HQL
						query.setParameter("cid",1); */
						
			List<Category> listCategory = query.getResultList();
			Iterator<Category> iterCategory = listCategory.iterator();
			while(iterCategory.hasNext())
			{
				Category objCategory = iterCategory.next();
	%>
				<tr>
					<td><%=objCategory.getCategoryName() %></td>
					<td><%=objCategory.getCategoryDescription()%></td>
					<td><%=objCategory.getCategoryImageUrl() %></td>
				</tr>
	<%
			}
		}
	%>
	</table>
</body>
</html>










