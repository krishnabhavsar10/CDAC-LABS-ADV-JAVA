<%@page import="org.hibernate.HibernateException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fi.hibernate.entity.Category"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
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
				<th>Name</th>
				<th>Description</th>
				<th>Images</th>
			</tr>
		
		<%
			SessionFactory hibernateFactory = (SessionFactory)application.getAttribute("hibernateFactory");
			
			try(Session hibernateSession = hibernateFactory.openSession()){
				
				Query<Category> query = hibernateSession.createQuery("from Category");//HQL
				/* 	Query<Category> query1 = hibernateSession.createQuery("select object(oCategory) from Category oCategory where oCategory.categoryId=:cid"); //HQL
				query1.setParameter("cid", 1); */
				
				List<Category> listCategory = query.getResultList();
				
				Iterator<Category> iterCategory = listCategory.iterator();
				while(iterCategory.hasNext()){
					Category objCat = iterCategory.next();
		%>
				<tr>
					<td><%= objCat.getCategoryName() %></td>
					<td><%= objCat.getCategoryDescription() %></td>
					<td><%= objCat.getCategoryImageUrl() %></td>
				</tr>
		<%
				}
			}catch(HibernateException e){
				e.printStackTrace();
			}
		%>
	</table>
</body>
</html>