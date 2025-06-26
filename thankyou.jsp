<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thank You - Foodie</title>
    <style>
        body {
            background: linear-gradient(to right, #f8f9fa, #e8f5e9);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .thankyou-container {
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            animation: slideIn 0.6s ease-out;
        }

        @keyframes slideIn {
            from {
                transform: translateY(20px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        .thankyou-container h1 {
            color: #28a745;
            font-size: 32px;
            margin-bottom: 10px;
        }

        .thankyou-container p {
            font-size: 18px;
            color: #555;
            margin-bottom: 30px;
        }

        .back-home-btn {
            display: inline-block;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            padding: 12px 30px;
            font-size: 16px;
            border-radius: 6px;
            transition: background 0.3s ease;
        }

        .back-home-btn:hover {
            background-color: #218838;
        }

        .success-icon {
            font-size: 50px;
            color: #28a745;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="thankyou-container">
    <div class="success-icon">✅</div>
    <h1>Thank You for Your Order!</h1>
    <p>Your food is getting ready for dispatch. We appreciate your trust in Foodie.</p>
    <a href="home.jsp" class="back-home-btn">Go to Home</a>
</div>

</body>
</html>
