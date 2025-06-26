package com.tap.cart;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmptyCartController
 */
@WebServlet("/EmptyCartController")
public class EmptyCartController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		  Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
		  
          CartDAOImpl cd = new CartDAOImpl(cart);
          cd.clear();
          resp.sendRedirect("addedtocart.jsp");
	}

}
