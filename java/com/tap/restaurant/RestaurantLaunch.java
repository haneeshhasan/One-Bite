package com.tap.restaurant;

import java.util.List;

public class RestaurantLaunch {

    public static void main(String[] args) {
    	
    	
        RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

        // Inserting a restaurant
//   Restaurant restaurant1 = new Restaurant(1, "Pizza Place", "Italian", "123 Main St", 4.5f, 30, "Yes", null);
     //   Restaurant restaurant = new Restaurant(2, "Sushi Corner", "Japanese", "456 Elm St", 4.8f, 25, "Yes", null);
      //  Restaurant restaurant = new Restaurant(3, "Burger Hub", "American", "789 Oak St", 4.2f, 20, "Yes", null);
    //    Restaurant restaurant = new Restaurant(4, "Curry House", "Indian", "101 Maple Ave", 4.6f, 35, "Yes", null);
     //   Restaurant restaurant = new Restaurant(5, "Taco Villa", "Mexican", "202 Pine St", 4.1f, 15, "No", null);
      //  Restaurant restaurant = new Restaurant(6, "Noodle Nirvana", "Chinese", "303 Cedar Rd", 4.4f, 40, "Yes", null);
     //   Restaurant restaurant = new Restaurant(7, "Steak Station", "Steakhouse", "404 Birch Blvd", 4.7f, 45, "Yes", null);
      //  Restaurant restaurant = new Restaurant(8, "Falafel Hut", "Mediterranean", "505 Aspen Ave", 4.3f, 25, "No", null);
     //   Restaurant restaurant = new Restaurant(9, "Pasta Palace", "Italian", "606 Redwood Rd", 4.6f, 30, "Yes", null);
     //   Restaurant restaurant = new Restaurant(10, "Bento Box", "Japanese", "707 Willow Dr", 4.9f, 20, "Yes", null);
      //  Restaurant restaurant = new Restaurant(11, "Grill & Chill", "American", "808 Cherry Ln", 4.0f, 35, "No", null);
    //    Restaurant restaurant = new Restaurant(12, "Spice Route", "Indian", "909 Spruce St", 4.5f, 30, "Yes", null);
     //   Restaurant restaurant = new Restaurant(13, "Burrito Bar", "Mexican", "1010 Fir St", 4.2f, 25, "Yes", null);
    //   Restaurant restaurant = new Restaurant(14, "Pho Paradise", "Vietnamese", "1111 Palm St", 4.6f, 40, "Yes", null);
     //   Restaurant restaurant = new Restaurant(15, "Salad Stop", "Healthy", "1212 Sequoia St", 4.3f, 20, "Yes", null);
     //   Restaurant restaurant = new Restaurant(16, "Kebab Kitchen", "Middle Eastern", "1313 Alder St", 4.4f, 30, "No", null);
     //   Restaurant restaurant = new Restaurant(17, "Pancake House", "Breakfast", "1414 Hemlock Ave", 4.7f, 15, "Yes", null);
     //  Restaurant restaurant = new Restaurant(18, "Seafood Shack", "Seafood", "1515 Magnolia Dr", 4.8f, 45, "Yes", null);
     //   Restaurant restaurant = new Restaurant(19, "Gourmet Greens", "Vegan", "1616 Cedar St", 4.2f, 25, "Yes", null);
     //   Restaurant restaurant = new Restaurant(20, "Ramen House", "Japanese", "1717 Poplar Blvd", 4.9f, 35, "Yes", null);



        
        int insertResult = restaurantDAO.insert(restaurant);
        if (insertResult != 0) {
            System.out.println("Successfully inserted the restaurant.");
        } else {
            System.out.println("Insertion failed.");
        }

        
//        // Fetching all restaurants
//        List<Restaurant> restaurants = restaurantDAO.fetchAll();
//        for (Restaurant restaurant : restaurants) {
//            System.out.println(restaurant);
//        }
//
//        // Fetching a specific restaurant
//        Restaurant specificRestaurant = restaurantDAO.fetchSpecific(1);
//        System.out.println("Fetched specific restaurant: " + specificRestaurant);
//
//        // Updating a restaurant
//        specificRestaurant.setName("Updated Pizza Place");
//        int updateResult = restaurantDAO.update(specificRestaurant);
//        if (updateResult != 0) {
//            System.out.println("Updated Successfully");
//        } else {
//            System.out.println("Update failed.");
//        }
//
//        // Deleting a restaurant
//        int deleteResult = restaurantDAO.delete(1);
//        if (deleteResult != 0) {
//            System.out.println("Deleted Successfully");
//        } else {
//            System.out.println("Deletion failed.");
//        }
    }
}
