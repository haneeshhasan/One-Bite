
package com.tap.user;

import java.util.Scanner;

public class UserLaunch {


	public static void main(String[] args) {
	
		User u = new User(1,"aneesh5000@gmail.com");
		
		UserDAO usd = new UserDAOImpl();
		
		// Fetching details of all user :
           
//			List<User> li = usd.fetchAll();
//			
//			for(User ur : li) {
//				System.out.println(ur);
//			}
//			
		// Fetch Specific
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter email id to fetch details");
		String email = scanner.nextLine();
		
		User u2 =  usd.fetchOnEmail(email);
		System.out.println(u2);
		
		
		
		// Inserting values into user:
			
//		     int x =     usd.insert(u);
//		     
//		     if(x!=0)
//		     {
//		    	 System.out.println("Successfully inserted");
//		     }
		     
//			User u2=usd.fetchSpecific(2);
//			System.out.println(u2);
		
		
		// Update data in user :
//		int x = usd.update(u);
//		if(x!=0) {
//			System.out.println("Updated Successfully");
//		}
//		else {
//			System.out.println("Failure");
//		}
//		
		// Delete user
		
		
//		 int y= usd.delete(3);
//		 
//		 if(y!=0) {
//			 System.out.println("Success");
//		 }
//		 else {
//			 System.out.println("Failure");
//		 }
		
	}

}
