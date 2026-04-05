package com.tap.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));

        HttpSession session = req.getSession();

        List<Map<String,Object>> cart =
            (List<Map<String,Object>>) session.getAttribute("cart");

        if(cart == null){
            cart = new ArrayList<>();
        }

        Map<String,Object> item = new HashMap<>();
        item.put("id", itemId);
        item.put("name", name);
        item.put("price", price);

        cart.add(item);

        session.setAttribute("cart", cart);

        res.sendRedirect("cart.jsp");
    }
}