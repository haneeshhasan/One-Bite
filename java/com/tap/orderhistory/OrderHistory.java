package com.tap.orderhistory;

public class OrderHistory {

    private int orderHistoryId;
    private int orderId;
    private int uid;
    private int restaurantId;
    private int total;
    private String status;

    public OrderHistory() {}

    // Full parameterized constructor
    public OrderHistory(int orderHistoryId, int orderId, int uid, int restaurantId, int total, String status) {
        this.orderHistoryId = orderHistoryId;
        this.orderId = orderId;
        this.uid = uid;
        this.restaurantId = restaurantId;
        this.total = total;
        this.status = status;
    }

    // Constructor for insert (excluding auto-generated orderHistoryId)
    public OrderHistory(int orderId, int uid, int restaurantId, int total, String status) {
        this.orderId = orderId;
        this.uid = uid;
        this.restaurantId = restaurantId;
        this.total = total;
        this.status = status;
    }

    // Getters and Setters
    public int getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(int orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", uid=" + uid +
               ", restaurantId=" + restaurantId + ", total=" + total + ", status=" + status + "]";
    }
}
