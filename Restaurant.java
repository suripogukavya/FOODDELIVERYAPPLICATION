package com.tap.model;

public class Restaurant {

    private int restaurantId;
    private String name;
    private int adminId;
    private String address;
    private String description;
    private String cuisineType;
    private double rating;
    private int estimatedTimeOfArrival;
    private String imageUrl;
    private boolean isAvailable;

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

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(int estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

	public Restaurant(int restaurantId, String name, int adminId, String address, String description,
			String cuisineType, double rating, int estimatedTimeOfArrival, String imageUrl, boolean isAvailable) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.adminId = adminId;
		this.address = address;
		this.description = description;
		this.cuisineType = cuisineType;
		this.rating = rating;
		this.estimatedTimeOfArrival = estimatedTimeOfArrival;
		this.imageUrl = imageUrl;
		this.isAvailable = isAvailable;
	}

	public Restaurant() {
		super();
	}
}
