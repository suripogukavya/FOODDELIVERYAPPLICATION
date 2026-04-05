package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    // 1️⃣ Register User
    @Override
    public boolean registerUser(User user) {
        boolean result = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO user(name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int i = ps.executeUpdate();
            if (i > 0) result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 2️⃣ Login User
    @Override
    public User loginUser(String email, String password) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email.trim());
            ps.setString(2, password.trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // 3️⃣ Add user (advanced with more fields)
    @Override
    public int addUser(User user) {
        int res = 0;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO user(user_id,name,password,email,address,phone_number,role,last_login_date,created_date) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhonenumber());
            ps.setString(7, user.getRole());
            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(9, new Timestamp(System.currentTimeMillis()));

            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    // 4️⃣ Get User by ID
    @Override
    public User getUser(int userId) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM user WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = mapResultSetToUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // 5️⃣ Get User by Email
    @Override
    public User getUser(String email) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM user WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = mapResultSetToUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // 6️⃣ Update User (only password for simplicity)
    @Override
    public void updateUser(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE user SET password=? WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7 Delete User
    @Override
    public void deleteUser(int userId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM user WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8️⃣ Get all users
    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM user";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToUser(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔹 Helper method to map ResultSet to User object
    private User mapResultSetToUser(ResultSet rs) throws Exception {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setPhonenumber(rs.getString("phone_number"));
        user.setRole(rs.getString("role"));
        user.setLastLogindate(rs.getTimestamp("last_login_date"));
        user.setCreateddate(rs.getTimestamp("created_date"));
        return user;
    }

}