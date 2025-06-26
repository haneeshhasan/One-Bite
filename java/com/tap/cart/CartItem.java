package com.tap.cart;

public class CartItem {
    private int itemId;
    private int restId;
    private String name;
    private int quantity;
    private int price;
    private String image; // New field for image URL

    // Constructors
    public CartItem() {
        super();
    }

    public CartItem(int itemId, int restId, String name, int quantity, int price, String image) {
        super();
        this.itemId = itemId;
        this.restId = restId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // toString() method
    @Override
    public String toString() {
        return "CartItem [itemId=" + itemId + ", restId=" + restId + ", name=" + name 
             + ", quantity=" + quantity + ", price=" + price + ", image=" + image + "]";
    }
}