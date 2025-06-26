package com.tap.cart;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveItemController
 */
@WebServlet("/RemoveItemController")
public class RemoveItemController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
	        if (cart != null) {
	            // Get the itemId from the submitted button value
	            int itemId = Integer.parseInt(req.getParameter("itemId"));
	        
	            
	            CartDAOImpl cd = new CartDAOImpl(cart);
	            
	            cd.removeItem(itemId);
	        }
	        resp.sendRedirect("addedtocart.jsp");
	}

}
