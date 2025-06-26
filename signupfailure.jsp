<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign Up Failure</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #343a40;
            text-align: center;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 40px;
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        h1 {
            font-size: 24px;
            color: #e74c3c;
        }

        p {
            font-size: 18px;
            color: #555555;
            margin-top: 20px;
        }

        .btn {
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 16px;
            margin-top: 30px;
            display: inline-block;
        }

        .btn:hover {x
            background-color: #2980b9;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Sign Up Failed</h1>
        <p>There was an issue with your sign-up. Please try again or contact support.</p>
        <a href="signup.html" class="btn">Try Again</a>
    </div>
</body>
</html>
