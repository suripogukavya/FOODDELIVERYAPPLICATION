package com.tap.model;

public class MenuItem {

    private int itemId;
    private int restaurantId;
    private String name;
    private String description;
    private double price;
    private double rating;
    private String imageUrl;
    private String typesOfDishes;
    private boolean isAvailable;

    // Getters & Setters

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTypesOfDishes() {
        return typesOfDishes;
    }

    public void setTypesOfDishes(String typesOfDishes) {
        this.typesOfDishes = typesOfDishes;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

	@Override
	public String toString() {
		return "MenuItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", name=" + name + ", description="
				+ description + ", price=" + price + ", rating=" + rating + ", imageUrl=" + imageUrl
				+ ", typesOfDishes=" + typesOfDishes + ", isAvailable=" + isAvailable + "]";
	}

	public MenuItem(int itemId, int restaurantId, String name, String description, double price, double rating,
			String imageUrl, String typesOfDishes, boolean isAvailable) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.typesOfDishes = typesOfDishes;
		this.isAvailable = isAvailable;
	}

	public MenuItem() {
		super();
	}
}
