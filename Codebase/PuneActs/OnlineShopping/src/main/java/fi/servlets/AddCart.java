package fi.servlets;

import java.io.IOException;

import fi.cart.Cart;
import fi.cart.CartFactory;
import fi.cart.CartItem;
import fi.cart.ProductCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session==null)
		{
			response.sendRedirect("login.html");
			return;
		}
		
		String tmp = request.getParameter("categoryId");
		int categoryId = Integer.parseInt(tmp);
		
		tmp = request.getParameter("productId");
		int productId = Integer.parseInt(tmp);
		
		tmp = request.getParameter("productPrice");
		float productPrice = Float.parseFloat(tmp);
		
		CartItem objItem = new CartItem(categoryId, productId, productPrice);
		
		Cart objCart = (Cart)session.getAttribute("cart");
		
		if(objCart==null)
		{
			objCart = CartFactory.getInstance(getServletContext());
			session.setAttribute("cart", objCart);
		}
		System.out.println(objCart);
		objCart.addItem(objItem);
		
		response.sendRedirect("ListCart");	
		
	}

}









