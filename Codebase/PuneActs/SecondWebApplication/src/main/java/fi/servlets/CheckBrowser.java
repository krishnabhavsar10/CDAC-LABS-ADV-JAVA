package fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBrowser
 */
@WebServlet("/CheckBrowser")
public class CheckBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userAgent = request.getHeader("user-agent");
		PrintWriter out = response.getWriter();
		
		if(userAgent.indexOf("Edg")!=-1)
			out.println("You are using Edge Browser");
		else if(userAgent.indexOf("Firefox")!=-1)
			out.println("You are using Firefox Browser");
		else
			out.println("You are using an unusual Broswer");
		
		
		
	}

}










