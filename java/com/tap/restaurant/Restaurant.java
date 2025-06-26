package com.tap.restaurant;

public class Restaurant {

    private int restaurantId;
    private String name;
    private String cuisineType;
    private String address;
    private float ratings;
    private int deliveryTime;
    private String isActive;
    // If needed, you can use byte[] for BLOB or manage it differently
    private String image;

    public Restaurant() {
        super();
    }
   


    public Restaurant(int restaurantId, String name, String cuisineType, String address, float ratings,
                     int deliveryTime, String isActive, String image) {
        super();
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.ratings = ratings;
        this.deliveryTime = deliveryTime;
        this.isActive = isActive;
        this.image = image;
    }

    // Getters and Setters
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return restaurantId + " " + name + " " + cuisineType + " " + address + " " + ratings + " "
                + deliveryTime + " " + isActive +" " +image ;
    }
}
