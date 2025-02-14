package fi.servlets;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fi.hibernate.entity.Users;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		ServletContext application = getServletContext();
		
		SessionFactory hibernateFactory = (SessionFactory)application.getAttribute("hibernateFactory");
		
		try{
			Session hibernateSession = hibernateFactory.openSession();
			
			Users objUser = hibernateSession.get(Users.class, userName);
			if(objUser == null) {
				response.getWriter().println("User Name Does not Exist");
			}
			else if(password.equals(objUser.getPassword())) {
				response.sendRedirect("category.jsp");
				return;
			}else {
				response.getWriter().println("Invalid Password");
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		response.sendRedirect("login.html");
	}

}
