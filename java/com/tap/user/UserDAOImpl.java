package com.tap.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    
	private final String FETCH_ALL = "select * from user";
	private final String INSERT_QUERY = "insert into user (username, email, password, mobile) values (?, ?, ?, ?)";
	private final String FETCH_SPECIFIC= "select * from user where uid=?";
	private final String UPDATE_QUERY= "update user set email=? where uid=?";
	private final String DELETE_QUERY="delete from user where uid=?";
	private final String FETCHONEMAIL ="select * from user where email=?";
	private String url="jdbc:mysql://localhost:3306/foodclone";
     private String usn="root";
     private String pwd="root";
	List<User> userList = new ArrayList<User>();
	private Connection con;
	private Statement stmt;
	private ResultSet result;
	private PreparedStatement pstmt;
	private int res;
	private User u;
	
	
		
	 public	UserDAOImpl(){
			try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		 con =    DriverManager.getConnection(url,usn,pwd);
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	 }
	
	@Override
	public List<User> fetchAll() {
		
		try {
               stmt =      con.createStatement();
                   result =  stmt.executeQuery(FETCH_ALL);
                   
                   userList = extractAll(result);
               
	}
		catch(Exception e) {
			e.printStackTrace();
		}
     return userList;
}
	
	List<User> extractAll(ResultSet result){
		
		try {
			
			while(result.next()) {
				
			userList.add(new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public int insert(User u) {
		
		try {
		pstmt=	con.prepareStatement(INSERT_QUERY);
		pstmt.setString(1, u.getUsername());
		pstmt.setString(2, u.getEmail());
		pstmt.setString(3, u.getPassword());
		pstmt.setString(4, u.getMobile());
		
		 res = pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public User fetchSpecific(int uid) {
		
		try {
			
		pstmt =	con.prepareStatement(FETCH_SPECIFIC);
		pstmt.setInt(1, uid);
		
		result = pstmt.executeQuery();
		
		userList = extractAll(result);
		
		if(!userList.isEmpty()) {
		u =userList.get(0);
		}
		else {
			System.out.println("No data found");
			System.exit(0);
		}		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int update(User u) {
	
		try 
		{
		pstmt =	con.prepareStatement(UPDATE_QUERY);
		pstmt.setInt(2, u.getUid());
		pstmt.setString(1, u.getEmail());
		
	    res=pstmt.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int uid) {
		
		try {
			
			pstmt= con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, uid);
			 res= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public User fetchOnEmail(String email) {
		try {
			
			pstmt =	con.prepareStatement(FETCHONEMAIL);
			pstmt.setString(1, email);
			
			result = pstmt.executeQuery();
			
			userList = extractAll(result);
			
			if(!userList.isEmpty()) {
			u =userList.get(0);
			}
			else {
				System.out.println("No data found");
//				System.exit(0);
			}		
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return u;
	}
	
	
}
