package com.tap.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import com.tap.daoImpl.OrderDAOImpl;
import com.tap.daoImpl.OrderItemDAOImpl;
import com.tap.model.Order;
import com.tap.model.OrderItem;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<Map<String,Object>> cart =
            (List<Map<String,Object>>) session.getAttribute("cart");

        if(cart == null){
            res.sendRedirect("cart.jsp");
            return;
        }

        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl itemDAO = new OrderItemDAOImpl();

        double total = 0;

        for(Map<String,Object> item : cart){
            total += (double)item.get("price");
        }

        Order order = new Order();
        order.setTotalAmount(total);
        order.setStatus("SUCCESS");

        orderDAO.addOrder(order);

        for(Map<String,Object> item : cart)
        {
            OrderItem oi = new OrderItem();

            oi.setItemName((String)item.get("name"));
            oi.setQuantity(1);
            oi.setTotalPrice((double)item.get("price"));

            itemDAO.addOrderItem(oi);
        }

        session.removeAttribute("cart");

        res.sendRedirect("success.jsp");
    }
}