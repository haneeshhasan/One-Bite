package com.tap.orders;

import java.util.List;

public class Launch {
    public static void main(String[] args) {
        OrdersDAO ordersDAO = new OrdersDAOImpl();

//        // Insert new order
        Orders newOrder = new Orders(1, 2, 3, 5, 500, "Credit Card", "Pending");
        int insertResult = ordersDAO.insert(newOrder);
        if (insertResult != 0) {
            System.out.println("Order Inserted Successfully with ID: " + newOrder.getOrderId());
        }

//        // Fetch all orders
        List<Orders> ordersList = ordersDAO.fetchAll();
        System.out.println("Orders List:");
        for (Orders order : ordersList) {
            System.out.println(order);
        }
//
//        // Fetch specific order
//        Orders specificOrder = ordersDAO.fetchSpecific(newOrder.getOrderId());
//        System.out.println("Fetched Order: " + specificOrder);
//
//        // Update order
//        specificOrder.setTotal(550);
//        specificOrder.setStatus("Completed");
//        int updateResult = ordersDAO.update(specificOrder);
//        System.out.println(updateResult != 0 ? "Order Updated Successfully" : "Order Update Failed");
//
//        // Delete order
//        int deleteResult = ordersDAO.delete(newOrder.getOrderId());
//        System.out.println(deleteResult != 0 ? "Order Deleted Successfully" : "Order Deletion Failed");
//    }
}
}
