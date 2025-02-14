package com.cdac.assign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterNewUser")
public class RegisterNewUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
			PreparedStatement psInsert = connection.prepareStatement("insert into users values(?,?,?,?)");
			
			psInsert.setString(1, userName);
			psInsert.setString(2, password);
			psInsert.setString(3, fullName);
			psInsert.setString(4, email);
			
			psInsert.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Details</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; width: 50%; margin: auto; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f4f4f4; }");
        out.println("body { font-family: Arial, sans-serif; text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Registration Details</h2>");
        out.println("<table>");
        out.println("<tr><th>Field</th><th>Value</th></tr>");
        out.println("<tr><td>Username</td><td>" + userName + "</td></tr>");
        out.println("<tr><td>Password</td><td>" + password + "</td></tr>"); // Note: Never display passwords in plain text in real applications.
        out.println("<tr><td>Name</td><td>" + fullName + "</td></tr>");
        out.println("<tr><td>Email</td><td>" + email + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
		
	}
	
	
}
