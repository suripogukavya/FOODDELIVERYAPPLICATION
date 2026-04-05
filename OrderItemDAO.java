package com.tap.dao;

import java.util.List;
import com.tap.model.OrderItem;

public interface OrderItemDAO {

    int addOrderItem(OrderItem item);

    OrderItem getOrderItem(int orderItemId);

    List<OrderItem> getItemsByOrderId(int orderId);

    void updateOrderItem(OrderItem item);

    void deleteOrderItem(int orderItemId);
}
