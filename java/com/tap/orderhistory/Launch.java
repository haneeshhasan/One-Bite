package com.tap.orderhistory;

import java.util.List;

public class Launch {

    public static void main(String[] args) {
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOImpl();

        // Insert a new order history
        OrderHistory newOrderHistory = new OrderHistory(10, 5, 3, 500, "Completed");
        int insertResult = orderHistoryDAO.insert(newOrderHistory);
        System.out.println(insertResult > 0 ? "Inserted Successfully" : "Insert Failed");

//        // Fetch all order history records
        List<OrderHistory> allOrderHistories = orderHistoryDAO.fetchAll();
        System.out.println("Order History Records:");
        for (OrderHistory orderHistory : allOrderHistories) {
            System.out.println(orderHistory);
        }
//
//        // Fetch specific order history by ID
//        OrderHistory specificOrderHistory = orderHistoryDAO.fetchSpecific(1);
//        System.out.println("Fetched Order History: " + specificOrderHistory);
//
//        // Update order history status
//        OrderHistory updatedOrderHistory = new OrderHistory();
//        updatedOrderHistory.setOrderHistoryId(1);
//        updatedOrderHistory.setStatus("Shipped");
//        int updateResult = orderHistoryDAO.update(updatedOrderHistory);
//        System.out.println(updateResult > 0 ? "Updated Successfully" : "Update Failed");
//
//        // Delete an order history by ID
//        int deleteResult = orderHistoryDAO.delete(2);
//        System.out.println(deleteResult > 0 ? "Deleted Successfully" : "Delete Failed");
  }
}
