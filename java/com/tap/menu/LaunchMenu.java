package com.tap.menu;

import java.util.List;

public class LaunchMenu {

    public static void main(String[] args) {
        MenuDAO menuDAO = new MenuDAOImpl();

        // Inserting a menu item
        Menu newMenu = new Menu();
        int insertResult = menuDAO.insert(newMenu);
        if (insertResult != 0) {
            System.out.println("Successfully inserted the menu item.");
        } else {
            System.out.println("Insertion failed.");
        }

//        // Fetching all menu items
//        List<Menu> menus = menuDAO.fetchAll();
//        for (Menu menu : menus) {
//            System.out.println(menu);
//        }
//
//        // Fetching a specific menu item
//        Menu specificMenu = menuDAO.fetchSpecific(1);
//        System.out.println("Fetched specific menu item: " + specificMenu);
//
//        // Updating a menu item
//        specificMenu.setName("Updated Margherita Pizza");
//        int updateResult = menuDAO.update(specificMenu);
//        if (updateResult != 0) {
//            System.out.println("Updated Successfully");
//        } else {
//            System.out.println("Update failed.");
//        }
//
//        // Deleting a menu item
//        int deleteResult = menuDAO.delete(1);
//        if (deleteResult != 0) {
//            System.out.println("Deleted Successfully");
//        } else {
//            System.out.println("Deletion failed.");
//        }
//    }
}
}
