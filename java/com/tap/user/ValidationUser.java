package com.tap.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.secret.Encrypt;
import com.tap.secret.Secret;

/**
 * Servlet implementation class SignupValidation
 */
@WebServlet("/ValidationUser")
public class  ValidationUser extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Retrieve user inputs from the signup form
        String username = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String mobileStr = req.getParameter("mobile");
        
        PrintWriter pw = resp.getWriter();
        long mobile = 0;

        // Validate mobile number
        try {
            mobile = Long.parseLong(mobileStr);
        } catch (NumberFormatException e) {
            pw.write("Invalid mobile number");
            return;
        }
        
        
        // checks whether number is 10 digit or not
        if (!mobileStr.matches("\\d{10}")) {
            pw.write("Invalid mobile number. It must be 10 digits long.");
            return;
        }

        

        // Access the DAO for user-related operations
        UserDAO userDAO = new UserDAOImpl();
        
        // Check if the email already exists
        User existingUser = userDAO.fetchOnEmail(email);
        if (existingUser != null) {
            // Redirect to "email already exists" page
            resp.sendRedirect("emailexists.jsp");
        } else {
            // Create a new user object
            User newUser = new User(Encrypt.encrypt(username) , Encrypt.encrypt(email), Encrypt.encrypt(password), Encrypt.encrypt(mobileStr));
            
            // Insert the new user into the database
            int insertStatus = userDAO.insert(newUser);
            
            if (insertStatus > 0) {
                // Create session and cookie for the new user
                HttpSession session = req.getSession();
                session.setAttribute("Userobject", newUser);
                
                Cookie ck1 = new Cookie("Email", email);
                ck1.setMaxAge(30 * 60); // Cookie valid for 30 minutes
                resp.addCookie(ck1);
                
                // Redirect to restaurant fetching logic
               resp.sendRedirect("GetRestaurant");
             //   pw.println("user added");
            } else {
                // Redirect to signup failure page
                resp.sendRedirect("signupfailure.jsp");
            }
        }
    }
}
