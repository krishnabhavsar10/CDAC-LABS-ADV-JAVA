package fi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement psCheckCard;
	PreparedStatement psUpdateBalance;
	PreparedStatement psInsertTransaction;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			ServletContext application = getServletContext();
		String dbUrl = application.getInitParameter("dbUrl");
		String dbDriver = application.getInitParameter("dbDriver");
		String dbUser = application.getInitParameter("dbUser");
		String dbPassword = application.getInitParameter("dbPassword");
		
		
		Class.forName(dbDriver);
		
		connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		psCheckCard = connection.prepareStatement("select * from cards where cardNo=?");
		psUpdateBalance = connection.prepareStatement("update cards set balance=? where cardNo=?");
		psInsertTransaction = connection.prepareStatement("insert into transactions(cardNo,txDate,amount,status) values(?,?,?,?)");
		} catch (ClassNotFoundException | SQLException e) 
		{
			throw new ServletException("Failed to initialize Authenticate Servlet due to DB Connection issues",e);
		}		
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// close all preparedstaement and connection
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tmp = request.getParameter("cardNo");
		int cardNo = Integer.parseInt(tmp);
		
		String expiry =  request.getParameter("expiry");
		
		HttpSession session = request.getSession(false);
		if(session==null)
		{
			response.sendRedirect("login.html");
			return;
		}
		
		try {
			float amount= (float)((double)session.getAttribute("total"));
			
			psCheckCard.setInt(1, cardNo);
			
			ResultSet resultCheckCard = psCheckCard.executeQuery();
			
			if(resultCheckCard.next())
			{
				int status = -1;
				String dbExpiry = resultCheckCard.getString("expiry");
				float balance = resultCheckCard.getFloat("balance");
				
				if(expiry.equals(dbExpiry) && amount < balance)
				{
					psUpdateBalance.setFloat(1, balance-amount);
					psUpdateBalance.setInt(2, cardNo);
					
					psUpdateBalance.executeUpdate();
					
					status = 1;
				}
				else 
					status = 0;
					
					psInsertTransaction.setInt(1, cardNo);
					psInsertTransaction.setDate(2, new Date(System.currentTimeMillis()));
					psInsertTransaction.setFloat(3, amount);
					psInsertTransaction.setInt(4, status);
					psInsertTransaction.executeUpdate();
					if(status==1)
						response.sendRedirect("orderplaced.html");
					else
						response.sendRedirect("invalidcard.html");
				
			}
			else
				response.sendRedirect("invalidcard.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}













