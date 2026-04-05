package com.tap.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.UserDAO;
import com.tap.model.User;
import java.util.List;
import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    Connection con = DBConnection.getConnection();

    // INSERT
    @Override
    public int addRestaurant(Restaurant r) {

        int status = 0;

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO restaurant(name,admin_id,address,description,cuisine_type,rating,estimated_time_of_arrival,image_url,is_available) VALUES(?,?,?,?,?,?,?,?,?)"
            );

            ps.setString(1, r.getName());
            ps.setInt(2, r.getAdminId());
            ps.setString(3, r.getAddress());
            ps.setString(4, r.getDescription());
            ps.setString(5, r.getCuisineType());
            ps.setDouble(6, r.getRating());
            ps.setInt(7, r.getEstimatedTimeOfArrival());
            ps.setString(8, r.getImageUrl());
            ps.setBoolean(9, r.isAvailable());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // SELECT BY ID
    @Override
    public Restaurant getRestaurant(int restaurantId) {

        Restaurant r = null;

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM restaurant WHERE restaurant_id=?"
            );

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                r = new Restaurant();

                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setAdminId(rs.getInt("admin_id"));
                r.setAddress(rs.getString("address"));
                r.setDescription(rs.getString("description"));
                r.setCuisineType(rs.getString("cuisine_type"));
                r.setRating(rs.getDouble("rating"));
                r.setEstimatedTimeOfArrival(rs.getInt("estimated_time_of_arrival"));
                r.setImageUrl(rs.getString("image_url"));
                r.setAvailable(rs.getBoolean("is_available"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }

    // UPDATE
    @Override
    public void updateRestaurant(Restaurant r) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE restaurant SET name=?, address=?, rating=?, is_available=? WHERE restaurant_id=?"
            );

            ps.setString(1, r.getName());
            ps.setString(2, r.getAddress());
            ps.setDouble(3, r.getRating());
            ps.setBoolean(4, r.isAvailable());
            ps.setInt(5, r.getRestaurantId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void deleteRestaurant(int restaurantId) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM restaurant WHERE restaurant_id=?"
            );

            ps.setInt(1, restaurantId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> list = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurant");

            while (rs.next()) {

                Restaurant r = new Restaurant();

                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setAdminId(rs.getInt("admin_id"));
                r.setAddress(rs.getString("address"));
                r.setDescription(rs.getString("description"));
                r.setCuisineType(rs.getString("cuisine_type"));
                r.setRating(rs.getDouble("rating"));
                r.setEstimatedTimeOfArrival(rs.getInt("estimated_time_of_arrival"));
                r.setImageUrl(rs.getString("image_url"));
                r.setAvailable(rs.getBoolean("is_available"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}