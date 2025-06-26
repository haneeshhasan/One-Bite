<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.cart.CartItem" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.tap.menu.Menu" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        
        h1 {
            color: #343a40;
            margin: 0;
        }
        
        .back-button {
            background-color: #6c757d;
            color: white;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            font-size: 14px;
        }
        
        .cart-container {
            max-width: 800px;
            margin: 0 auto;
        }
        
        .cart-items {
            display: grid;
            gap: 15px;
            margin-bottom: 20px;
        }
        
        .cart-item {
            background: white;
            border-radius: 8px;
            padding: 15px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            display: flex;
            align-items: center;
            gap: 15px;
        }
        
        .item-image {
            width: 80px;
            height: 80px;
            object-fit: cover;
            border-radius: 4px;
        }
        
        .item-info {
            flex: 1;
        }
        
        .item-name {
            font-weight: bold;
            margin-bottom: 5px;
            color: #343a40;
        }
        
        .item-details {
            color: #6c757d;
            font-size: 14px;
        }
        
        .item-price {
            font-weight: bold;
            color: #28a745;
            min-width: 80px;
            text-align: right;
        }
        
        .cart-total {
            background: white;
            border-radius: 8px;
            padding: 15px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: right;
            font-weight: bold;
            font-size: 18px;
        }
        
        .empty-cart {
            text-align: center;
            color: #6c757d;
            padding: 40px 0;
        }

        /* New styles for added functionality */
        .item-actions {
            display: flex;
            gap: 8px;
            margin-top: 8px;
        }
        
        .quantity-input {
            width: 50px;
            padding: 4px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        
        .update-btn, .remove-btn {
            padding: 4px 8px;
            border-radius: 4px;
            font-size: 12px;
            cursor: pointer;
        }
        
        .update-btn {
            background-color: #17a2b8;
            color: white;
            border: none;
        }
        
        .remove-btn {
            background-color: #ffc107;
            color: #212529;
            border: none;
            text-decoration:none;
        }
        
        .cart-actions {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        
        .empty-cart-btn, .checkout-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
            text-decoration:none;
        }
        
        .empty-cart-btn {
            background-color: #dc3545;
            color: white;
        }
        
        .checkout-btn {
            background-color: #28a745;
            color: white;
        }
        
        .empty-cart-container {
    text-align: center;
    padding: 60px 20px;
    background-color: #f8f9fa;
    border-radius: 8px;
    margin: 40px auto;
    max-width: 500px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
}



		.empty-cart-icon {
		    margin-bottom: 20px;
		}
		
		.empty-cart-icon svg {
		    opacity: 0.7;
		}
		
		.empty-cart-title {
		    color: #343a40;
		    font-size: 24px;
		    margin-bottom: 10px;
		    font-weight: 600;
		}
		
		.empty-cart-message {
		    color: #6c757d;
		    font-size: 16px;
		    margin-bottom: 25px;
		}
		
		.empty-cart-button {
		    display: inline-block;
		    padding: 12px 30px;
		    background-color: #28a745;
		    color: white;
		    text-decoration: none;
		    border-radius: 4px;
		    font-weight: 500;
		    transition: all 0.3s ease;
		    border: none;
		    cursor: pointer;
		}
		
		.empty-cart-button:hover {
		    background-color: #218838;
		    transform: translateY(-2px);
		    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
		}
		
				/* Navigation buttons */
				.nav-buttons {
			    display: flex;
			    align-items: center;
			    justify-content: space-between;
			    width: 100%;
			}
			
			.nav-buttons > .left,
			.nav-buttons > .center,
			.nav-buttons > .right {
			    flex: 1;
			    display: flex;
			    align-items: center;
			}
			
			.nav-buttons > .left {
			    justify-content: flex-start;
			}
			
			.nav-buttons > .center {
			    justify-content: center;
			}
			
			.nav-buttons > .right {
			    justify-content: flex-end;
			}
			
			.nav-buttons h1 {
			    margin: 0;
			    font-size: 24px;
			    color: #343a40;
			}
			
			/* Button styles */
			.nav-button {
			    padding: 8px 16px;
			    border-radius: 4px;
			    text-decoration: none;
			    font-size: 14px;
			    font-weight: 500;
			    transition: all 0.3s ease;
			}
			
			.home-button {
			    background-color: #17a2b8;
			    color: white;
			}
			
			.menu-button {
			    background-color: #6c757d;
			    color: white;
			}
			
			.nav-button:hover {
			    transform: translateY(-2px);
			    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
			}
			
			.home-button:hover {
			    background-color: #138496;
			}
			
			.menu-button:hover {
			    background-color: #5a6268;
			}

    </style>
</head>
<body>
           <%
            ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("menuList");
           %>
    
    <div class="header">
    <div class="nav-buttons">
        <div class="left">
            <a href="home.jsp" class="nav-button home-button">Home</a>
        </div>
        <div class="center">
            <h1>Your Cart</h1>
        </div>
        <div class="right">
            <% if (menuList != null && !menuList.isEmpty()) { %>
                <a href="menu.jsp" class="nav-button menu-button">Menu</a>
            <% } %>
        </div>
    </div>
</div>

    
    
    <div class="cart-container">
        <%
            Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
                double total = 0;
        %>
        <form method="post">
            <div class="cart-items">
                <%
                    for (CartItem item : cart.values()) {
                        total += item.getPrice() * item.getQuantity();
                %>
                <div class="cart-item">
                    <% if (item.getImage() != null && !item.getImage().isEmpty()) { %>
                        <img src="<%= item.getImage() %>" alt="<%= item.getName() %>" class="item-image">
                    <% } else { %>
                        <div class="item-image" style="background: #eee; display: flex; align-items: center; justify-content: center;">
                            <span style="color: #999;">No Image</span>
                        </div>
                    <% } %>
                    <div class="item-info">
                        <div class="item-name"><%= item.getName() %></div>
                        <div class="item-details">
                            Quantity: 
                            <input type="number"  name="quantity_<%= item.getItemId() %>"  value="<%= item.getQuantity() %>" 
										 min="1" max="10" 
                                   class="quantity-input">
                            x $<%= item.getPrice() %>
                        </div>
                        <div class="item-actions">
                            <button type="submit" formaction="UpdateCartController?itemId=<%= item.getItemId() %>" 
                                    class="update-btn">Update</button>					                                    
                            <button type="submit" formaction="RemoveItemController?itemId=<%= item.getItemId() %>" 
                               class="remove-btn">Remove</button>
                        </div>
                    </div>
                    <div class="item-price">
                        $<%= item.getPrice() * item.getQuantity() %>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            
            <div class="cart-total">
                Total: $<%= total %>
            </div>
            
            <div class="cart-actions">
                <a href="EmptyCartController" class="empty-cart-btn">Empty Cart</a>
                <a href="checkout.jsp" class="checkout-btn">Proceed to Checkout</a>
            </div>
        </form>
        <%
            } else {
        %>
        <div class="empty-cart-container">
    <div class="empty-cart-icon">
        <svg xmlns="http://www.w3.org/2000/svg" width="64" height="64" fill="#6c757d" viewBox="0 0 16 16">
            <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
        </svg>
    </div>
    <h3 class="empty-cart-title">Your cart feels lonely</h3>
    <p class="empty-cart-message">You haven't added any delicious items yet</p>
    <a href="home.jsp" class="empty-cart-button">Browse Restaurant</a>
</div>
		   
        <%
            }
        %>
    </div>
</body>
</html>