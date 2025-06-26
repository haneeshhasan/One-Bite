package com.tap.menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {

    private final String FETCH_ALL = "SELECT * FROM menu";
    private final String INSERT_QUERY = "INSERT INTO menu (menuId, restaurantId, name, description, price, rating, isAvailable,image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String FETCH_SPECIFIC = "SELECT * FROM menu WHERE menuId=?";
    private final String UPDATE_QUERY = "UPDATE menu SET restaurantId=?, name=?, description=?, price=?, rating=?, isAvailable=? WHERE menuId=?";
    private final String DELETE_QUERY = "DELETE FROM menu WHERE menuId=?";
    private final String FETCH_MENU="select * from menu where restaurantId=?";
    private String url = "jdbc:mysql://localhost:3306/foodclone";
    private String usn = "root";
    private String pwd = "root";
    
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet result;
    List<Menu> menuList = new ArrayList<>();

    public MenuDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usn, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> fetchAll() {
      
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeQuery(FETCH_ALL);
            while (result.next()) {
                menuList.add(new Menu(
                        result.getInt("menuId"),
                        result.getInt("restaurantId"), // Fixed spelling error
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("price"),
                        result.getFloat("rating"),
                        result.getString("isAvailable"),
                        result.getString("image")
                        
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public int insert(Menu menu) {
        int res = 0;
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1, menu.getMenuId());
            pstmt.setInt(2, menu.getRestaurantId()); // Fixed spelling error
            pstmt.setString(3, menu.getName());
            pstmt.setString(4, menu.getDescription());
            pstmt.setInt(5, menu.getPrice());
            pstmt.setFloat(6, menu.getRating());
            pstmt.setString(7, menu.getIsAvailable());
            pstmt.setString(8, menu.getImage());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Menu fetchSpecific(int menuId) {
        Menu menu = null;
        try {
            pstmt = con.prepareStatement(FETCH_SPECIFIC);
            pstmt.setInt(1, menuId);
            result = pstmt.executeQuery();
            if (result.next()) {
                menu = new Menu(
                        result.getInt("menuId"),
                        result.getInt("restaurantId"), // Fixed spelling error
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("price"),
                        result.getFloat("rating"),
                        result.getString("isAvailable"),
                        result.getString("image")
                );
            } else {
                System.out.println("No data found for menuId: " + menuId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int update(Menu menu) {
        int res = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setInt(1, menu.getRestaurantId()); // Fixed spelling error
            pstmt.setString(2, menu.getName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setInt(4, menu.getPrice());
            pstmt.setFloat(5, menu.getRating());
            pstmt.setString(6, menu.getIsAvailable());
            pstmt.setInt(7, menu.getMenuId());
            
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(int menuId) {
        int res = 0;
        try {
            pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, menuId);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

	@Override
	public List<Menu> fetchMenu(int restaurantId) {
	try {
		pstmt = con.prepareStatement(FETCH_MENU);
		pstmt.setInt(1, restaurantId);
		result = pstmt.executeQuery();
	    while (result.next()) {
            menuList.add(new Menu(
                    result.getInt("menuId"),
                    result.getInt("restaurantId"), // Fixed spelling error
                    result.getString("name"),
                    result.getString("description"),
                    result.getInt("price"),
                    result.getFloat("rating"),
                    result.getString("isAvailable"),
                    result.getString("image")
            ));
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return menuList;
			
	}
}
