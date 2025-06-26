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

import com.tap.secret.Decrypt;
import com.tap.secret.Encrypt;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    private HttpSession session;
    private PrintWriter pw;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email"); // Original email entered by the user
        String password = req.getParameter("password");

        pw = resp.getWriter();

        // Encrypt the entered email before querying the database
        String encryptedEmail = Encrypt.encrypt(email); // Assuming `Encrypt` is your encryption utility class

        UserDAO usd = new UserDAOImpl();

        // Fetch user details based on the encrypted email
        User u1 = usd.fetchOnEmail(encryptedEmail);

        if (u1 != null) {
            // Decrypt the user's stored password
            String decryptedPassword = Decrypt.decrypt(u1.getPassword()); // Assuming `Decrypt` is your decryption utility class

            // Check if the decrypted password matches the input password
            if (decryptedPassword.equals(password)) {
                // Decrypt other sensitive data (if needed)
            //    String decryptedName = Decrypt.decrypt(u1.getUsername());

                // Update user object with decrypted values
          //      u1.setUsername(decryptedName);
                
                // Create session and set attributes
                session = req.getSession();
                session.setAttribute("Userobject", u1);

                // Create a cookie for email and add it to the response
                Cookie ck1 = new Cookie("Email", email);
                ck1.setMaxAge(30); // Set cookie lifetime
                resp.addCookie(ck1);

                // Redirect to GetRestaurant servlet
                resp.sendRedirect("GetRestaurant");
            } else {
                // Redirect to wrong password page
                resp.sendRedirect("wrongpass.jsp");
            }
        } else {
            // Redirect to wrong email page
            resp.sendRedirect("wrongemail.jsp");
        }
    }
}
