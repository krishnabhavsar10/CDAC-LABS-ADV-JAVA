package fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,
								HttpServletResponse response)
	throws IOException, ServletException
	{
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Current Time : <h3>" + new Date() + "</h3>");
		out.println("</body>");
		out.println("</html>");		
		
	}
}











