<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
			.navbar {
			    background-color: #343a40;
			    padding: 10px 20px;
			    color: white;
			    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
			    position: sticky;
			    top: 0;
			    z-index: 1000;
			}
			
			.nav-container {
			    display: flex;
			    justify-content: space-between;
			    align-items: center;
			}
			
			.nav-logo {
			    font-size: 20px;
			    color: white;
			    text-decoration: none;
			    font-weight: bold;
			}
			
			.nav-links a {
			    margin: 0 15px;
			    color: white;
			    text-decoration: none;
			    font-size: 16px;
			    transition: color 0.3s ease;
			}
			
			.nav-links a:hover {
			    color: #ffc107;
			}
			</style>

<body>
		<nav class="navbar">
		    <div class="nav-container">
		        <a href="home.jsp" class="nav-logo">🍔 Foodie</a>
		        <div class="nav-links">
		            <a href="home.jsp">Home</a>
		            <a href="menu.jsp">Menu</a>
		            <a href="addedtocart.jsp">Cart</a>
		            <!-- <a href="profile.jsp">Profile</a> -->
		            <!-- <a href="logout.jsp">Logout</a> -->
		        </div>
		    </div>
		</nav>

</body>
</html>