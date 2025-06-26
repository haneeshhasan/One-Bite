package com.tap.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	
	private static Connection con;

	public static Connection connect() {
	
		try {

			String url ="jdbc:mysql://localhost:3306/foodclone";
			String usn="root";
			String pswd="root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,usn,pswd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
