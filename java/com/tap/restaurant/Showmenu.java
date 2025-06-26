package com.tap.restaurant;

import java.io.IOException;
import java.util.ArrayList;
import com.tap.menu.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Showmenu
 */
@WebServlet("/Showmenu")
public class Showmenu extends HttpServlet {

    ArrayList<Menu> menulist = new ArrayList<Menu>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	
    	int restId =Integer.parseInt(req.getParameter("restId"));
    	
    	MenuDAOImpl mend = new MenuDAOImpl();
    	
    	menulist  = (ArrayList<Menu>) mend.fetchMenu(restId);
    	
    	req.getSession().setAttribute("menuList", menulist);
    	
    	resp.sendRedirect("menu.jsp");
    	
    	
    }

}

