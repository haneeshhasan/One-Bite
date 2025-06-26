package com.tap.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRestaurant
 */
@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {

	ArrayList<Restaurant> rest;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RestaurantDAOImpl rstd= new RestaurantDAOImpl();
		
		 rest =  (ArrayList<Restaurant>) rstd.fetchAll();
		 
		 req.getSession().setAttribute("restList", rest);
		 
		 resp.sendRedirect("home.jsp");
		 
	}

}
