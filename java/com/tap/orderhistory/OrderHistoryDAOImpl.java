package com.tap.orderhistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

    private static final String FETCH_ALL = "SELECT * FROM OrderHistory";
    private static final String INSERT_QUERY = "INSERT INTO OrderHistory (orderId, uid, restaurantId, total, status) VALUES (?, ?, ?, ?, ?)";
    private static final String FETCH_SPECIFIC = "SELECT * FROM OrderHistory WHERE orderHistoryId = ?";
    private static final String UPDATE_QUERY = "UPDATE OrderHistory SET status = ? WHERE orderHistoryId = ?";
    private static final String DELETE_QUERY = "DELETE FROM OrderHistory WHERE orderHistoryId = ?";

    private String url = "jdbc:mysql://localhost:3306/foodclone";
    private String username = "root";
    private String password = "root";
    private Connection con;

    public OrderHistoryDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> fetchAll() {
        List<OrderHistory> orderHistoryList = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet result = stmt.executeQuery(FETCH_ALL)) {
            while (result.next()) {
                orderHistoryList.add(new OrderHistory(
                        result.getInt("orderHistoryId"),
                        result.getInt("orderId"),
                        result.getInt("uid"),
                        result.getInt("restaurantId"),
                        result.getInt("total"),
                        result.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    @Override
    public int insert(OrderHistory orderHistory) {
        int res = 0;
        try (PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setInt(2, orderHistory.getUid());
            pstmt.setInt(3, orderHistory.getRestaurantId());
            pstmt.setInt(4, orderHistory.getTotal());
            pstmt.setString(5, orderHistory.getStatus());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public OrderHistory fetchSpecific(int orderHistoryId) {
        OrderHistory orderHistory = null;
        try (PreparedStatement pstmt = con.prepareStatement(FETCH_SPECIFIC)) {
            pstmt.setInt(1, orderHistoryId);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    orderHistory = new OrderHistory(
                            result.getInt("orderHistoryId"),
                            result.getInt("orderId"),
                            result.getInt("uid"),
                            result.getInt("restaurantId"),
                            result.getInt("total"),
                            result.getString("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public int update(OrderHistory orderHistory) {
        int res = 0;
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {
            pstmt.setString(1, orderHistory.getStatus());
            pstmt.setInt(2, orderHistory.getOrderHistoryId());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(int orderHistoryId) {
        int res = 0;
        try (PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {
            pstmt.setInt(1, orderHistoryId);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
