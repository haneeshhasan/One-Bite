package com.tap.orderitems;

public class OrderItems {

    private int orderItemsId;
    private int orderId;
    private int menuId;
    private int quantity;
    private int itemTotal;

    public OrderItems() {}

    // Constructor for full object
    public OrderItems(int orderItemsId, int orderId, int menuId, int quantity, int itemTotal) {
        this.orderItemsId = orderItemsId;
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    // Constructor for insert (excluding auto-generated ID)
    public OrderItems(int orderId, int menuId, int quantity, int itemTotal) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    // Constructor for update (orderItemsId, quantity, itemTotal only)
    public OrderItems(int orderItemsId, int quantity, int itemTotal) {
        this.orderItemsId = orderItemsId;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    // Getters and Setters
    public int getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(int orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(int itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Override
    public String toString() {
        return "OrderItems [orderItemsId=" + orderItemsId + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity=" + quantity + ", itemTotal=" + itemTotal + "]";
    }
}
