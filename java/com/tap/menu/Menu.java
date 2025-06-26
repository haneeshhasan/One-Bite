package com.tap.menu;

public class Menu {

    private int menuId;
    private int restaurantId; 
    private String name;
    private String description;
    private int price;
    private float rating;
    private String isAvailable;
    private String image;

    public Menu() {
        super();
    }

    public Menu(int menuId, int restaurantId, String name, String description, int price, float rating,
                String isAvailable,String image) {
        super();
        this.menuId = menuId;
        this.restaurantId = restaurantId; 
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.isAvailable = isAvailable;
        this.image=image;
    }

    // Constructor for updates
    public Menu(int menuId, String name, String description, int price, float rating, String isAvailable) {
        this.menuId = menuId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
    

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + name + ", description="
				+ description + ", price=" + price + ", rating=" + rating + ", isAvailable=" + isAvailable + ", image="
				+ image + "]";
	}

	
}
