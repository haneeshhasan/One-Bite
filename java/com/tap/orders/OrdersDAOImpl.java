package com.tap.orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {
    private final String FETCH_ALL = "SELECT * FROM Orders";
    private final String INSERT_QUERY = "INSERT INTO Orders (uid, restaurantId, menuId, quantity, total, paymentMode, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String FETCH_SPECIFIC = "SELECT * FROM Orders WHERE orderId=?";
    private final String UPDATE_QUERY = "UPDATE Orders SET total=?, status=? WHERE orderId=?";
    private final String DELETE_QUERY = "DELETE FROM Orders WHERE orderId=?";

    private String url = "jdbc:mysql://localhost:3306/foodclone";
    private String usn = "root";
    private String pwd = "root";

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet result;
    private int res;

    public OrdersDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usn, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> fetchAll() {
        List<Orders> ordersList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeQuery(FETCH_ALL);
            while (result.next()) {
                ordersList.add(new Orders(result.getInt("orderId"), result.getInt("uid"),
                		result.getInt("restaurantId"),result.getInt("menuId"),result.getInt("quantity"), result.getInt("total"),
                		result.getString("paymentMode"),result.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public int insert(Orders order) {
        try {
            pstmt = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, order.getUid());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setInt(3, order.getMenuId());
            pstmt.setInt(4, order.getQuantity());
            pstmt.setInt(5, order.getTotal());
            pstmt.setString(6, order.getPaymentMode());
            pstmt.setString(7, order.getStatus());

            res = pstmt.executeUpdate();
            if (res > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setOrderId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Orders fetchSpecific(int orderId) {
        Orders order = null;
        try {
            pstmt = con.prepareStatement(FETCH_SPECIFIC);
            pstmt.setInt(1, orderId);
            result = pstmt.executeQuery();
            if (result.next()) {
                order = new Orders(
                        result.getInt("orderId"),
                        result.getInt("uid"),
                        result.getInt("restaurantId"),
                        result.getInt("menuId"),
                        result.getInt("quantity"),
                        result.getInt("total"),
                        result.getString("paymentMode"),
                        result.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int update(Orders order) {
        try {
            pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setInt(1, order.getTotal());
            pstmt.setString(2, order.getStatus());
            pstmt.setInt(3, order.getOrderId());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(int orderId) {
        try {
            pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, orderId);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
