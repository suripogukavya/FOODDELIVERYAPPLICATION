package com.tap.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

import com.tap.daoImpl.MenuItemDAOImpl;
import com.tap.model.MenuItem;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int itemId = Integer.parseInt(request.getParameter("itemId"));

        MenuItemDAOImpl menuItemDAO = new MenuItemDAOImpl();
        MenuItem item = menuItemDAO.getMenuItem(itemId);

        if(item != null){
            HttpSession session = request.getSession();
            List<Map<String,Object>> cart = (List<Map<String,Object>>) session.getAttribute("cart");

            if(cart == null){
                cart = new ArrayList<>();
            }

            Map<String,Object> cartItem = new HashMap<>();
            cartItem.put("name", item.getName());
            cartItem.put("price", item.getPrice());

            // ⭐ FIXED LINE
            cartItem.put("image", item.getImageUrl());

            cart.add(cartItem);

            session.setAttribute("cart", cart);
        }

        response.sendRedirect("cart.jsp");
    }
}