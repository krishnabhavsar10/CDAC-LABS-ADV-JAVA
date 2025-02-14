package fi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fi.beans.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		try {
			
			HttpSession session = request.getSession();
			User objUser = (User) session.getAttribute("objUser");
			
			Connection connection =(Connection) application.getAttribute("globalConnection");
			PreparedStatement psInsert = connection.prepareStatement("insert into users values(?,?,?,?)");
			
			psInsert.setString(1,objUser.getUserName());
			psInsert.setString(2,objUser.getPassword());
			psInsert.setString(3,objUser.getName());
			psInsert.setString(4,objUser.getEmail());
			
			psInsert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
