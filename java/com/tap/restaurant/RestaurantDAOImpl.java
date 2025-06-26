package com.tap.restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.user.User;

public class RestaurantDAOImpl implements RestaurantDAO {

    private final String FETCH_ALL = "SELECT * FROM restaurant";
    private final String INSERT_QUERY = "INSERT INTO restaurant (restaurantId, name, cuisineType, address, ratings, deliveryTime, isActive, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String FETCH_SPECIFIC = "SELECT * FROM restaurant WHERE restaurantId=?";
    private final String UPDATE_QUERY = "UPDATE restaurant SET name=?, cuisineType=?, address=?, ratings=?, deliveryTime=?, isActive=?, image=? WHERE restaurantId=?";
    private final String DELETE_QUERY = "DELETE FROM restaurant WHERE restaurantId=?";
    
    private String url = "jdbc:mysql://localhost:3306/foodclone";
    private String usn = "root";
    private String pwd = "root";
    
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet result;
//	private List<Restaurant> restaurantList;

    public RestaurantDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usn, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> fetchAll() {
     
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeQuery(FETCH_ALL);
            
            return extractAll(result);
         
        } catch (Exception e) {
            e.printStackTrace();
        }
     return null;
    }
    
	List<Restaurant> extractAll(ResultSet result){
		   List<Restaurant> restaurantList = new ArrayList<>();
		try {
			
			   while (result.next()) {
	                restaurantList.add(new Restaurant(
	                        result.getInt("restaurantId"),
	                        result.getString("name"),
	                        result.getString("cuisineType"),
	                        result.getString("address"),
	                        result.getFloat("ratings"),
	                        result.getInt("deliveryTime"),
	                        result.getString("isActive"),
	                        result.getString("image") // Use bytes for image BLOB
	                ));
	            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

    @Override
    public int insert(Restaurant r) {
        int res = 0;
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1, r.getRestaurantId());
            pstmt.setString(2, r.getName());
            pstmt.setString(3, r.getCuisineType());
            pstmt.setString(4, r.getAddress());
            pstmt.setFloat(5, r.getRatings());
            pstmt.setInt(6, r.getDeliveryTime());
            pstmt.setString(7, r.getIsActive());
            pstmt.setString(8, r.getImage()); // Store image as bytes
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Restaurant fetchSpecific(int restaurantId) {
        Restaurant restaurant = null;
        try {
            pstmt = con.prepareStatement(FETCH_SPECIFIC);
            pstmt.setInt(1, restaurantId);
            result = pstmt.executeQuery();
            if (result.next()) {
                restaurant = new Restaurant(
                        result.getInt("restaurantId"),
                        result.getString("name"),
                        result.getString("cuisineType"),
                        result.getString("address"),
                        result.getFloat("ratings"),
                        result.getInt("deliveryTime"),
                        result.getString("isActive"),
                        result.getString("image")
                );
            } else {
                System.out.println("No data found for restaurantId: " + restaurantId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public int update(Restaurant r) {
        int res = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1, r.getName());
            pstmt.setString(2, r.getCuisineType());
            pstmt.setString(3, r.getAddress());
            pstmt.setFloat(4, r.getRatings());
            pstmt.setInt(5, r.getDeliveryTime());
            pstmt.setString(6, r.getIsActive());
            pstmt.setString(7, r.getImage());
            pstmt.setInt(8, r.getRestaurantId());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(int restaurantId) {
        int res = 0;
        try {
            pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, restaurantId);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
