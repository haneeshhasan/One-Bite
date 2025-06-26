<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.tap.cart.CartItem" %>
<%@ page session="true" %>

<%
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
    if (cart == null) {
        cart = new HashMap<>();
    }

    int total = 0;
    for (CartItem item : cart.values()) {
        total += item.getPrice() * item.getQuantity();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout - Foodie</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 960px;
            margin: 40px auto;
            background: white;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
            padding: 40px;
        }

        h2, h3 {
            color: #2c3e50;
            margin-bottom: 20px;
        }

        .section {
            margin-bottom: 40px;
        }

        .cart-item {
            display: flex;
            align-items: center;
            background: #fafafa;
            border: 1px solid #eee;
            border-radius: 12px;
            padding: 12px;
            margin-bottom: 16px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.05);
        }

        .cart-item img {
            width: 60px;
            height: 60px;
            border-radius: 10px;
            object-fit: cover;
            margin-right: 16px;
        }

        .cart-item-details {
            flex-grow: 1;
        }

        .cart-item-details span {
            display: block;
            font-size: 16px;
            color: #333;
        }

        .cart-item-price {
            font-weight: bold;
            font-size: 16px;
            color: #27ae60;
        }

        .input-field {
            width: 100%;
            padding: 12px;
            border-radius: 10px;
            border: 1px solid #ccc;
            font-size: 15px;
        }

        .pm-options {
            margin-top: 12px;
        }

        .pm-options label {
            margin-right: 20px;
            font-size: 15px;
        }

        .total {
            font-size: 20px;
            font-weight: bold;
            text-align: right;
            margin-top: 20px;
            color: #2d3436;
        }

        .order-button {
            background-color: #28a745;
            color: white;
            padding: 14px 28px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            float: right;
            transition: background 0.3s ease;
        }

        .order-button:hover {
            background-color: #218838;
        }

        @media (max-width: 600px) {
            .cart-item {
                flex-direction: column;
                align-items: flex-start;
            }

            .cart-item img {
                margin-bottom: 10px;
            }

            .order-button {
                width: 100%;
                float: none;
                margin-top: 20px;
            }

            .total {
                text-align: left;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Checkout</h2>

    <form action="thankyou.jsp" method="post">
        <!-- Cart Section -->
        <div class="section">
            <h3>Your Items</h3>
            <%
                for (CartItem item : cart.values()) {
            %>
                <div class="cart-item">
                    <img src="<%= item.getImage() %>" alt="item image">
                    <div class="cart-item-details">
                        <span><strong><%= item.getName() %></strong></span>
                        <span>Quantity: <%= item.getQuantity() %></span>
                    </div>
                    <div class="cart-item-price">
                        $<%= item.getPrice() * item.getQuantity() %>
                    </div>
                </div>
            <%
                }
            %>
            <div class="total">Total Amount: $<%= total %></div>
        </div>

        <!-- Address Section -->
        <div class="section">
            <h3>Delivery Address</h3>
            <textarea class="input-field" rows="4" placeholder="Enter your delivery address..." name="address" required></textarea>
        </div>

        <!-- Payment Mode Section -->
        <div class="section">
            <h3>Payment Method</h3>
            <div class="pm-options">
                <label><input type="radio" name="pmode" value="Cash On Delivery" checked> Cash on Delivery</label>
                <label><input type="radio" name="pmode" value="UPI"> UPI</label>
                <label><input type="radio" name="pmode" value="Credit/Debit Card"> Card</label>
            </div>
        </div>

        <!-- Hidden Total -->
        <input type="hidden" name="total" value="<%= total %>">

        <!-- Submit Button -->
        <button type="submit" class="order-button">Place Order</button>
    </form>
</div>

</body>
</html>
