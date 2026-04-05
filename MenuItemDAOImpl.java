package com.tap.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuItemDAO;
import com.tap.model.MenuItem;
import com.tap.util.DBConnection;

public class MenuItemDAOImpl implements MenuItemDAO {

    Connection con = DBConnection.getConnection();

    // INSERT
    @Override
    public int addMenuItem(MenuItem item) {

        int status = 0;

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO menu_item(restaurant_id,name,description,price,rating,image_url,types_of_dishes,is_available) VALUES(?,?,?,?,?,?,?,?)"
            );

            ps.setInt(1, item.getRestaurantId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getPrice());
            ps.setDouble(5, item.getRating());
            ps.setString(6, item.getImageUrl());
            ps.setString(7, item.getTypesOfDishes());
            ps.setBoolean(8, item.isAvailable());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // SELECT BY ID
    @Override
    public MenuItem getMenuItem(int itemId) {

        MenuItem item = null;

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM menu_item WHERE item_id=?"
            );

            ps.setInt(1, itemId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                item = new MenuItem();

                item.setItemId(rs.getInt("item_id"));
                item.setRestaurantId(rs.getInt("restaurant_id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setRating(rs.getDouble("rating"));
                item.setImageUrl(rs.getString("image_url"));
                item.setTypesOfDishes(rs.getString("types_of_dishes"));
                item.setAvailable(rs.getBoolean("is_available"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    // SELECT BY RESTAURANT
    @Override
    public List<MenuItem> getItemsByRestaurant(int restaurantId) {

        List<MenuItem> list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM menu_item WHERE restaurant_id=?"
            );

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                MenuItem item = new MenuItem();

                item.setItemId(rs.getInt("item_id"));
                item.setRestaurantId(rs.getInt("restaurant_id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setRating(rs.getDouble("rating"));
                item.setImageUrl(rs.getString("image_url"));
                item.setTypesOfDishes(rs.getString("types_of_dishes"));
                item.setAvailable(rs.getBoolean("is_available"));

                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    @Override
    public void updateMenuItem(MenuItem item) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE menu_item SET price=?, rating=?, is_available=? WHERE item_id=?"
            );

            ps.setDouble(1, item.getPrice());
            ps.setDouble(2, item.getRating());
            ps.setBoolean(3, item.isAvailable());
            ps.setInt(4, item.getItemId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void deleteMenuItem(int itemId) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM menu_item WHERE item_id=?"
            );

            ps.setInt(1, itemId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    @Override
    public List<MenuItem> getAllMenuItems() {

        List<MenuItem> list = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu_item");

            while (rs.next()) {

                MenuItem item = new MenuItem();

                item.setItemId(rs.getInt("item_id"));
                item.setRestaurantId(rs.getInt("restaurant_id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setRating(rs.getDouble("rating"));
                item.setImageUrl(rs.getString("image_url"));
                item.setTypesOfDishes(rs.getString("types_of_dishes"));
                item.setAvailable(rs.getBoolean("is_available"));

                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
