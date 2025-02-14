<%@page import="java.sql.Date"%>
<%@page import="fi.hibernate.entity.Transactions"%>
<%@page import="fi.hibernate.entity.Cards"%>
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
	<%
	
		SessionFactory hibernateFactory = (SessionFactory) application.getAttribute("hibernateFactory");
		try(Session hibernateSession = hibernateFactory.openSession())
		{
			String tmp = request.getParameter("cardNo");
			
			int cardNo = Integer.parseInt(tmp);
			
			float amount = Float.parseFloat(request.getParameter("amount"));
			String expiry = request.getParameter("expiry");
			
			Cards objCard = hibernateSession.get(Cards.class, cardNo);
			if(objCard!=null)
			{
				if(amount < objCard.getBalance())
				{
					objCard.setBalance(objCard.getBalance()-amount);
					
					Transactions tx = new Transactions();
					tx.setTransactionId(1001);
					tx.setAmount(amount);
					tx.setCardNo(cardNo);
					tx.setTxDate(new Date(System.currentTimeMillis()));
					
					hibernateSession.beginTransaction();
					hibernateSession.merge(objCard);
					hibernateSession.persist(tx);
					
					hibernateSession.getTransaction().commit();
	%>
			Your account for <%=cardNo %> has been debitted for an amount of <%=amount %> on <%=new java.util.Date() %>
			
	<%
				}
			}
			else
			{
	%>
				<font color='red'>No such card available</font>
	<%		
			}
		}
	
	
	%>
</body>
</html>