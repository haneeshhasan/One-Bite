package com.tap.orders;

public class Orders {
    private int orderId;
    private int uid;
    private int restaurantId;
    private int menuId;
    private int quantity;
    private int total;
    private String paymentMode;
    private String status;

    // Default constructor
    public Orders() {
        super();
    }

    // Constructor for creating a new order
    public Orders(int uid, int restaurantId, int menuId, int quantity, int total, String paymentMode, String status) {
        this.uid = uid;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.total = total;
        this.paymentMode = paymentMode;
        this.status = status;
    }

    // Constructor for updating status or total
    public Orders(int orderId, int total, String status) {
        this.orderId = orderId;
        this.total = total;
        this.status = status;
    }

    // Constructor for fetchAll
    
    public Orders(int orderId, int uid, int restaurantId, int menuId, int quantity, int total, String paymentMode, String status) {
        this.orderId = orderId;
        this.uid = uid;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.total = total;
        this.paymentMode = paymentMode;
        this.status = status;
    }

    // ...


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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", uid=" + uid +
                ", restaurantId=" + restaurantId +
                ", menuId=" + menuId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", paymentMode='" + paymentMode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

	
}
