package fi.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Products
 */
@WebServlet(
		
		"/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement psProducts;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		// Loading of the DB Driver
		// Connection
		// PreparedSTatement
		try {
			ServletContext application = getServletContext();
			String dbUrl = application.getInitParameter("dbUrl");
			String dbDriver = application.getInitParameter("dbDriver");
			String dbUser = application.getInitParameter("dbUser");
			String dbPassword = application.getInitParameter("dbPassword");
			
			
			Class.forName(dbDriver);
			
			connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			psProducts = connection.prepareStatement("select * from products where categoryId=?");
		} catch (ClassNotFoundException | SQLException e) 
		{
			throw new ServletException("Failed to initialize Authenticate Servlet due to DB Connection issues",e);
		}		
	}

	@Override
	public void destroy() {
		try {
			if(psProducts!=null)
				psProducts.close();
			if(connection!=null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			
			HttpSession session = request.getSession(false);
			if(session==null)
			{
				response.sendRedirect("login.html");
				return;
			}
			
				String userName = (String)session.getAttribute("userName");
				
				String tmp = request.getParameter("categoryId");
				int categoryId = Integer.parseInt(tmp);
				
				psProducts.setInt(1, categoryId);
				
				try(ResultSet result = psProducts.executeQuery())
				{
					
					out.println("<html>");
					out.println("<body>");
					out.println("Welcome <b>" + userName + "</b><br/><br/>");
					out.println("<table border='1'>");
					out.println("<tr>");
					out.println("<th>Name</th>");
					out.println("<th>Description</th>");
					out.println("<th>Price</th>");
					out.println("<th>Image</th>");
					out.println("</tr>");
					
					while(result.next())
					{
						out.println("<tr>");
						out.println("<td>" + result.getString("productName") + "</td>");
						out.println("<td>" + result.getString("productDescription") + "</td>");
						out.println("<td>" + result.getString("productPrice") + "</td>");
						out.println("<td><img src='Images/" + result.getString("productImageUrl") + "' height='60px' width='60px'/></td>");
						out.println("<td><a href='AddCart?categoryId=" + result.getInt("categoryId") +  
											"&productId=" + result.getInt("productId") + 
											"&productPrice=" + result.getFloat("productPrice") 
											+ "'>Add to Cart</a></td>");
						out.println("</tr>");
						
					}
						
					out.println("</table>");
					out.println("</body>");
					out.println("</html>");
				}
			}
			catch(SQLException sql)
			{
				sql.printStackTrace();
			}
				
	}

}
