package com.tap.orderitems;

import java.util.List;

public class Launch {

    public static void main(String[] args) {
        OrderItemsDAO orderItemsDAO = new OrderItemsDAOImpl();

        // Insert new order item
        OrderItems newOrderItem = new OrderItems(1, 2, 3, 150);
        int insertResult = orderItemsDAO.insert(newOrderItem);
        System.out.println(insertResult > 0 ? "Inserted Successfully" : "Insert Failed");

//        // Fetch all order items
//        List<OrderItems> orderItemsList = orderItemsDAO.fetchAll();
//        for (OrderItems orderItem : orderItemsList) {
//            System.out.println(orderItem);
//        }
//
//        // Fetch specific order item by ID
//        OrderItems fetchedItem = orderItemsDAO.fetchSpecific(1);
//        System.out.println("Fetched Item: " + fetchedItem);
//
//        // Update an order item
//        OrderItems updateOrderItem = new OrderItems(1, 4, 120);
//        int updateResult = orderItemsDAO.update(updateOrderItem);
//        System.out.println(updateResult > 0 ? "Updated Successfully" : "Update Failed");
//
//        // Delete an order item
//        int deleteResult = orderItemsDAO.delete(1);
//        System.out.println(deleteResult > 0 ? "Deleted Successfully" : "Delete Failed");
    }
}
