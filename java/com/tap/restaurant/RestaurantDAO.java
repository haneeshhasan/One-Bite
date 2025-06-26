package com.tap.restaurant;

import java.util.List;

public interface RestaurantDAO {
    List<Restaurant> fetchAll();
    
    int insert(Restaurant r);
    
    Restaurant fetchSpecific(int restaurantId);
    
    int update(Restaurant r);
    
    int delete(int restaurantId);
    
    
     
    
}
