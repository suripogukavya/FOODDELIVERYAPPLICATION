package com.tap.model;

import java.sql.Timestamp;
import java.util.Date;

public class User {

    private int userId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phonenumber;
    private String role;
    private Timestamp lastLogindate;
    private Timestamp createddate;

    // Correct Constructor
 
	// Getters
    public int getUserId() {
    	return userId; 
    	}
    public String getUsername() { 
    	return username;
    	}
    public String getPassword() {
    	return password; 
    	}
    public String getEmail() { 
    	return email; 
    	}
    public String getAddress() {
    	return address; 
    	}
    public String getPhonenumber() { 
    	return phonenumber; 
    	}
    public String getRole() {
    	return role; 
    	}
    public Timestamp getLastLogindate() {
    	return lastLogindate;
    	}
    public Timestamp getCreateddate() {
    	return createddate; 
    	}

    // Setters
    public void setUserId(int userId) {
    	this.userId = userId; 
    	}
    public void setUsername(String username) {
    	this.username = username;
    	}
    public void setPassword(String password) {
    	this.password = password;
    	}
    public void setEmail(String email) {
    	this.email = email; 
    	}
    public void setAddress(String address) { 
    	this.address = address;
    	}
    public void setPhonenumber(String phonenumber) {
    	this.phonenumber = phonenumber; 
    	}
    public void setRole(String role) {
    	this.role = role; 
    	}
    public void setLastLogindate(Timestamp lastLogindate) {
    	this.lastLogindate = lastLogindate; 
    	}
    public void setCreateddate(Timestamp createddate) { 
    	this.createddate = createddate; 
    	}

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username +
                ", email=" + email + ", role=" + role + "]";
    }
}