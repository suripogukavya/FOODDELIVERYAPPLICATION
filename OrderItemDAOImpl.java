package com.tap.daoImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    Connection con = DBConnection.getConnection();

    // INSERT
    @Override
    public int addOrderItem(OrderItem item) {

        int status = 0;

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO order_items(order_id,item_name,quantity,total_price) VALUES(?,?,?,?)"
            );

            ps.setInt(1, item.getOrderId());
            ps.setString(2, item.getItemName());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getTotalPrice());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // SELECT BY ID
    @Override
    public OrderItem getOrderItem(int orderItemId) {

        OrderItem item = null;

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM order_items WHERE order_item_id=?"
            );

            ps.setInt(1, orderItemId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                item = new OrderItem();

                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setItemName(rs.getString("item_name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setTotalPrice(rs.getDouble("total_price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    // SELECT BY ORDER ID
    @Override
    public List<OrderItem> getItemsByOrderId(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM order_items WHERE order_id=?"
            );

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                OrderItem item = new OrderItem();

                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setItemName(rs.getString("item_name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setTotalPrice(rs.getDouble("total_price"));

                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    @Override
    public void updateOrderItem(OrderItem item) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE order_items SET quantity=?, total_price=? WHERE order_item_id=?"
            );

            ps.setInt(1, item.getQuantity());
            ps.setDouble(2, item.getTotalPrice());
            ps.setInt(3, item.getOrderItemId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void deleteOrderItem(int orderItemId) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM order_items WHERE order_item_id=?"
            );

            ps.setInt(1, orderItemId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
