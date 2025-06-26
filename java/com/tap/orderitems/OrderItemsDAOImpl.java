package com.tap.orderitems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAOImpl implements OrderItemsDAO {

    private static final String FETCH_ALL = "SELECT * FROM orderItems";
    private static final String INSERT_QUERY = "INSERT INTO orderItems (orderId, menuId, quantity, itemTotal) VALUES (?, ?, ?, ?)";
    private static final String FETCH_SPECIFIC = "SELECT * FROM orderItems WHERE orderItemsId = ?";
    private static final String UPDATE_QUERY = "UPDATE orderItems SET quantity = ?, itemTotal = ? WHERE orderItemsId = ?";
    private static final String DELETE_QUERY = "DELETE FROM orderItems WHERE orderItemsId = ?";
    
    private final String url = "jdbc:mysql://localhost:3306/foodclone";
    private final String user = "root";
    private final String password = "root";
    private Connection con;

    public OrderItemsDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItems> fetchAll() {
        List<OrderItems> orderItemsList = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet result = stmt.executeQuery(FETCH_ALL)) {
            
            while (result.next()) {
                orderItemsList.add(new OrderItems(result.getInt("orderItemsId"), result.getInt("orderId"), result.getInt("menuId"), result.getInt("quantity"), result.getInt("itemTotal")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItemsList;
    }

    @Override
    public int insert(OrderItems orderItems) {
        int res = 0;
        try (PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {
            pstmt.setInt(1, orderItems.getOrderId());
            pstmt.setInt(2, orderItems.getMenuId());
            pstmt.setInt(3, orderItems.getQuantity());
            pstmt.setInt(4, orderItems.getItemTotal());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public OrderItems fetchSpecific(int orderItemsId) {
        OrderItems orderItem = null;
        try (PreparedStatement pstmt = con.prepareStatement(FETCH_SPECIFIC)) {
            pstmt.setInt(1, orderItemsId);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    orderItem = new OrderItems(result.getInt("orderItemsId"), result.getInt("orderId"), result.getInt("menuId"), result.getInt("quantity"), result.getInt("itemTotal"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public int update(OrderItems orderItems) {
        int res = 0;
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {
            pstmt.setInt(1, orderItems.getQuantity());
            pstmt.setInt(2, orderItems.getItemTotal());
            pstmt.setInt(3, orderItems.getOrderItemsId());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(int orderItemsId) {
        int res = 0;
        try (PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {
            pstmt.setInt(1, orderItemsId);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
