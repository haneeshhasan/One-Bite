<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.menu.Menu" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        

        .menu-container {
            max-width: 1200px;
            margin: 20px auto;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }

        .menu-card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            overflow: hidden;
            text-align: center;
            transition: transform 0.2s;
        }

        .menu-card:hover {
            transform: translateY(-5px);
        }

        .menu-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .menu-details {
            padding: 15px;
        }

        .menu-title {
            font-size: 18px;
            font-weight: bold;
            color: #343a40;
            margin: 10px 0;
        }

        .menu-description {
            font-size: 14px;
            color: #6c757d;
            margin: 5px 0;
        }

        .menu-rating {
            font-size: 14px;
            color: #ffc107;
            margin: 5px 0;
        }

        .menu-price {
            font-size: 16px;
            font-weight: bold;
            color: #28a745;
            margin: 10px 0;
        }

        .menu-availability {
            font-size: 14px;
            color: #dc3545;
            margin: 5px 0;
        }

        .add-button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.2s;
            margin-top: 10px;
        }

        .add-button:hover {
            background-color: #0056b3;
        }
        
        /* New quantity dropdown styles */
        .quantity-wrapper {
            margin: 15px 0;
        }
        
        .quantity-select {
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ced4da;
            margin-right: 10px;
        }
	        .floating-back-btn {
    display: none !important;
}
        
    </style>
</head>
<body>
  <div style="text-align: center; margin-top: 20px;">
    <!-- Back to Restaurants Button -->
    <a href="GetRestaurant" style="text-decoration: none; margin-right: 10px;">
        <button style="padding: 10px 20px; background-color: #6c757d; color: white; border: none; border-radius: 5px; font-size: 14px; cursor: pointer;">
            Back to Restaurants
        </button>
    </a>

    <!-- Cart Button with Icon -->
    <a href="addedtocart.jsp" class="cart-button" style="display: inline-block; vertical-align: middle; text-decoration: none; margin-left: 10px;">
        <button style="padding: 10px 16px; background-color: #17a2b8; color: white; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; display: flex; align-items: center; gap: 5px;">
            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" viewBox="0 0 16 16">
                <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
            </svg>
            Cart
        </button>
    </a>
</div>

    
    <div class="menu-container">
        <%
            ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("menuList");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menuItem : menuList) {
        %>
        <div class="menu-card">
            <img src="<%= menuItem.getImage() %>" alt="Menu Item" class="menu-image">
            <div class="menu-details">
                <div class="menu-title"><%= menuItem.getName() %></div>
                <div class="menu-description"><%= menuItem.getDescription() %></div>
                <div class="menu-rating">Rating: <%= menuItem.getRating() %></div>
                <div class="menu-price">Price: <%= menuItem.getPrice() %></div>
                <div class="menu-availability">
                    <% if ("Yes".equalsIgnoreCase(menuItem.getIsAvailable())) { %>
                        <span style="color: #28a745;">Available</span>
                    <% } else { %>
                        <span style="color: #dc3545;">Not Available</span>
                    <% } %>
                </div>
                
                <!-- Modified section with quantity dropdown -->
     <div class="quantity-wrapper">
    <form action="AddToCartController" method="post">
        <input type="hidden" name="menuId" value="<%= menuItem.getMenuId() %>">
        <select name="quantity" class="quantity-select" >
            <% for (int i = 1; i <= 10; i++) { %>
                <option value="<%= i %>" <%= (i == 1) ? "selected" : "" %>><%= i %></option>
            <% } %>
        </select>
        <button type="submit" class="add-button">ADD TO CART</button>
    </form>
</div>
                
            </div>
        </div>
        <%
                }
            } else {
        %>
        <p style="text-align: center; font-size: 18px; color: #6c757d;">No menu items found.</p>
        <% } %>
    </div>
    <a href="GetRestaurant" class="floating-back-btn"></a>
    
</body>
</html>