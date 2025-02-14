package fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	PreparedStatement psAuthenticate = null;	
	
	// Will Initialise every thing required for one time until the servlet is destroyed
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // Imp DONOT delete else will be set to null
		
		
		Connection connection = null;// Connection
		PreparedStatement psAuthenticate = null;// PreparedStatement
		
		// Using Servlet Context fetching from web.xml 
		ServletContext application = getServletContext();
		
		String dbUrl = application.getInitParameter("dbUrl");
		String dbDriver = application.getInitParameter("dbDriver");
		String dbUser = application.getInitParameter("dbUser");
		String dbPassword = application.getInitParameter("dbPassword");
		
		try {
			Class.forName(dbDriver); // Loading of the DB Driver
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			psAuthenticate = connection.prepareStatement("select * from users where userName=? and password=?");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}



	// See in the NoteBook notes
	@Override
	public void destroy() {
		try {
			if(psAuthenticate != null) {
				psAuthenticate.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName==null || password==null)
			throw new ServletException("Input Parameter Problem !!");
		
		try {
			psAuthenticate.setString(1, userName);
			psAuthenticate.setString(2, password);
			
			ResultSet result = psAuthenticate.executeQuery();
			
			if(result.next()) {
				response.sendRedirect("Category");
			}
			else {
				out.println("Authentication Failed !!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
