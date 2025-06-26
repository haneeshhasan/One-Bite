package com.tap.menu;

import java.util.List;

public interface MenuDAO {
	
    List<Menu> fetchAll();
    
    int insert(Menu menu);
    
    Menu fetchSpecific(int menuId);
    
    int update(Menu menu);
    
    int delete(int menuId);
    
    List<Menu> fetchMenu(int restaurantId);
}
