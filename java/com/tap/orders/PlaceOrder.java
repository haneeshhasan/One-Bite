package com.tap.orders;

import com.tap.cart.CartItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        Integer userId = (Integer) session.getAttribute("userId");
        String address = request.getParameter("address");
        String paymentMode = request.getParameter("pmode");
        int total = Integer.parseInt(request.getParameter("total"));
        java.sql.Date orderDate = new java.sql.Date(System.currentTimeMillis());

        if (cart == null || cart.isEmpty() || userId == null) {
            response.sendRedirect("checkout.jsp?error=Invalid+Order+Data");
            return;
        }
         
        Connection conn = null;
        PreparedStatement psOrder = null, psItems = null, psHistory = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "yourpassword");
            conn.setAutoCommit(false);

            // 1. Insert into orders table
            String orderSql = "INSERT INTO orders(user_id, total_price, address, payment_mode, order_date) VALUES (?, ?, ?, ?, ?)";
            psOrder = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            psOrder.setInt(1, userId);
            psOrder.setInt(2, total);
            psOrder.setString(3, address);
            psOrder.setString(4, paymentMode);
            psOrder.setDate(5, orderDate);
            psOrder.executeUpdate();

            rs = psOrder.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // 2. Insert into order_items table
            String itemSql = "INSERT INTO order_items(order_id, item_id, item_name, quantity, price) VALUES (?, ?, ?, ?, ?)";
            psItems = conn.prepareStatement(itemSql);

            for (CartItem item : cart.values()) {
                psItems.setInt(1, orderId);
                psItems.setInt(2, item.getItemId());
                psItems.setString(3, item.getName());
                psItems.setInt(4, item.getQuantity());
                psItems.setInt(5, item.getPrice());
                psItems.addBatch();
            }
            psItems.executeBatch();

            // 3. Insert into order_history table
            String historySql = "INSERT INTO order_history(order_id, status, timestamp) VALUES (?, ?, ?)";
            psHistory = conn.prepareStatement(historySql);
            psHistory.setInt(1, orderId);
            psHistory.setString(2, "Placed");
            psHistory.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            psHistory.executeUpdate();

            conn.commit();

            // Clear cart
            session.removeAttribute("cart");

            // Redirect
            response.sendRedirect("thankyou.jsp");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            throw new ServletException("Order failed", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (psOrder != null) psOrder.close();
                if (psItems != null) psItems.close();
                if (psHistory != null) psHistory.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
