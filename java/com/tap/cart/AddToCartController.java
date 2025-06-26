package com.tap.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.menu.Menu;
import com.tap.menu.MenuDAOImpl;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        // Get or create cart from session
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if(cart == null) {
            cart = new HashMap<Integer, CartItem>();
        }
        
        // Get parameters from request
        int menuId = Integer.parseInt(req.getParameter("menuId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        
        // Fetch menu details including image
        MenuDAOImpl mdaoi = new MenuDAOImpl();
        Menu m = mdaoi.fetchSpecific(menuId);
        
        // Create CartItem with image support
        CartItem ci = new CartItem(
            menuId, 
            m.getRestaurantId(),
            m.getName(),
            quantity,
            m.getPrice(),
            m.getImage()  // Added image parameter
        );
        
        // Update cart
        CartDAOImpl cdaoi = new CartDAOImpl(cart);
        cart = cdaoi.addItem(ci);
        
        // Store updated cart in session
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect("addedtocart.jsp");
    }
}