package com.tap.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.tap.daoImpl.MenuItemDAOImpl;
import com.tap.daoImpl.RestaurantDAOImpl;
import com.tap.model.MenuItem;
import com.tap.model.Restaurant;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch restaurants
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();

        // Fetch menu items
        MenuItemDAOImpl menuItemDAO = new MenuItemDAOImpl();
        List<MenuItem> items = menuItemDAO.getAllMenuItems();

        // Group items by restaurant with max 5 items
        Map<Integer, List<MenuItem>> restaurantItems = new HashMap<>();
        for (MenuItem m : items) {
            if (m.isAvailable()) {
                List<MenuItem> list = restaurantItems.computeIfAbsent(m.getRestaurantId(), k -> new ArrayList<>());
                if (list.size() < 5) {
                    list.add(m);
                }
            }
        }

        // Set attributes for JSP
        request.setAttribute("restaurants", restaurants);
        request.setAttribute("restaurantItems", restaurantItems);

        // Forward to menu.jsp
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}