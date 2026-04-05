package com.tap.model;

import java.time.LocalDateTime;

public class Order {

    public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", totalAmount="
				+ totalAmount + ", orderDate=" + orderDate + ", address=" + address + ", paymentMethod=" + paymentMethod
				+ ", status=" + status + "]";
	}

	public Order(int orderId, int userId, int restaurantId, double totalAmount, LocalDateTime orderDate,
			String address, String paymentMethod, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	private int orderId;
    private int userId;
    private int restaurantId;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String address;
    private String paymentMethod;
    private String status;

    // Getters & Setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
