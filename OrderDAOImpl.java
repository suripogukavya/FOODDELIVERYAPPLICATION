package com.tap.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.tap.model.User;
import com.tap.util.DBConnection;
import java.time.LocalDateTime;
import java.util.List;
import com.tap.dao.OrderDAO;
import com.tap.model.Order;


public class OrderDAOImpl implements OrderDAO {

    Connection con = DBConnection.getConnection();

    // INSERT
    @Override
    public int addOrder(Order o) {

        int status = 0;

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO orders(user_id,restaurant_id,total_amount,order_date,address,payment_method,status) VALUES(?,?,?,?,?,?,?)"
            );

            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getRestaurantId());
            ps.setDouble(3, o.getTotalAmount());
            ps.setTimestamp(4, Timestamp.valueOf(o.getOrderDate()));
            ps.setString(5, o.getAddress());
            ps.setString(6, o.getPaymentMethod());
            ps.setString(7, o.getStatus());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // SELECT BY ID
    @Override
    public Order getOrder(int orderId) {

        Order o = null;

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM orders WHERE order_id=?"
            );

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                o = new Order();

                o.setOrderId(rs.getInt("order_id"));
                o.setUserId(rs.getInt("user_id"));
                o.setRestaurantId(rs.getInt("restaurant_id"));
                o.setTotalAmount(rs.getDouble("total_amount"));
                o.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                o.setAddress(rs.getString("address"));
                o.setPaymentMethod(rs.getString("payment_method"));
                o.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    // UPDATE
    @Override
    public void updateOrder(Order o) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE orders SET status=?, payment_method=? WHERE order_id=?"
            );

            ps.setString(1, o.getStatus());
            ps.setString(2, o.getPaymentMethod());
            ps.setInt(3, o.getOrderId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void deleteOrder(int orderId) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM orders WHERE order_id=?"
            );

            ps.setInt(1, orderId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    @Override
    public List<Order> getAllOrders() {

        List<Order> list = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

            while (rs.next()) {

                Order o = new Order();

                o.setOrderId(rs.getInt("order_id"));
                o.setUserId(rs.getInt("user_id"));
                o.setRestaurantId(rs.getInt("restaurant_id"));
                o.setTotalAmount(rs.getDouble("total_amount"));
                o.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                o.setAddress(rs.getString("address"));
                o.setPaymentMethod(rs.getString("payment_method"));
                o.setStatus(rs.getString("status"));

                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
