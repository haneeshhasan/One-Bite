<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.user.User" %>
<%@ page import="com.tap.restaurant.Restaurant" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery App</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #ff6b6b;
            --secondary-color: #4ecdc4;
            --background-color: #f7f7f7;
            --text-color: #2d3436;
            --card-shadow: 0 8px 30px rgba(0, 0, 0, 0.12);
            --cuisine-color: #6c5ce7;
        }

        body {
            font-family: 'Nunito', sans-serif;
            background-color: var(--background-color);
            margin: 0;
            padding: 0;
            color: var(--text-color);
        }

        .header {
            background-color: var(--primary-color);
            padding: 20px;
            color: white;
            text-align: center;
        }

        .header h1 {
            margin: 0;
            font-size: 28px;
            font-weight: 700;
        }

        .search-bar {
            max-width: 600px;
            margin: 30px auto;
            padding: 0 20px;
            position: relative;
        }

        .search-bar input {
            width: 100%;
            padding: 15px 20px;
            border: none;
            border-radius: 50px;
            box-shadow: var(--card-shadow);
            font-size: 16px;
            transition: all 0.3s ease;
        }

        .container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 30px;
            padding: 20px;
            max-width: 1300px;
            margin: 0 auto;
        }

       .card {
    background-color: white;
    border-radius: 20px;
    overflow: hidden;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    box-shadow: var(--card-shadow);
    position: relative;
    cursor: pointer; /* Makes the card feel clickable */
}

.card:hover {
    transform: translateY(-10px);
    box-shadow: 0 12px 36px rgba(0, 0, 0, 0.2);
}


        .card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            transition: transform 0.3s ease;
        }

        .card-content {
            padding: 20px;
        }

        .card-title {
            font-size: 22px;
            font-weight: 700;
            margin: 0 0 10px 0;
            color: var(--primary-color);
        }

        .card-info {
            color: #636e72;
            font-size: 14px;
            margin: 5px 0;
            display: flex;
            align-items: center;
        }

        .card-ratings {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 50%;
            width: 50px;
            height: 50px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 18px;
            font-weight: 700;
            color: var(--primary-color);
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .card-delivery {
            font-size: 14px;
            color: var(--secondary-color);
            font-weight: 600;
            margin-top: 10px;
            display: flex;
            align-items: center;
        }

        .tag-view-menu-container {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-top: 10px;
        }

        .tag {
            display: inline-block;
            background-color: var(--cuisine-color);
            color: white;
            padding: 6px 15px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 700;
            transition: background-color 0.3s ease;
        }

        .tag:hover {
            background-color: #5a4bbf;
        }

        .view-menu-button {
            padding: 8px 15px;
            background-color: var(--primary-color);
            color: white;
            font-size: 14px;
            font-weight: 700;
            border: none;
            border-radius: 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .view-menu-button:hover {
            background-color: #e05656;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Welcome, <%= ((User) session.getAttribute("Userobject")).getUsername() %>!</h1>
    </div>

    <div class="search-bar">
        <input type="text" placeholder="Craving something? Search here...">
    </div>

    <div class="container">
        <%
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) session.getAttribute("restList");
        if (restaurants != null && !restaurants.isEmpty()) {
            for (Restaurant restaurant : restaurants) {
        %>
        <div class="card">
            <img src="<%= restaurant.getImage() %>" alt="<%= restaurant.getName() %> Image">
            <div class="card-ratings"><%= restaurant.getRatings() %></div>
            <div class="card-content">
                <h2 class="card-title"><%= restaurant.getName() %></h2>
                <div class="card-info">
                    <%= restaurant.getAddress() %>
                </div>
                <div class="tag-view-menu-container">
                    <span class="tag"><%= restaurant.getCuisineType() %></span>
                    <button class="view-menu-button">View Menu</button>
                </div>
                <div class="card-delivery">
                    <%= restaurant.getDeliveryTime() %> mins
                </div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <p>No restaurants available at the moment. Please check back later!</p>
        <% } %>
    </div>
</body>
</html>
