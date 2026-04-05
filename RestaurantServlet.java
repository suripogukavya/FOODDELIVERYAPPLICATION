package com.tap.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import com.tap.daoImpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

@WebServlet("/restaurants")
public class RestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        List<Restaurant> list = dao.getAllRestaurants();

        req.setAttribute("restaurants", list);
        req.getRequestDispatcher("restaurants.jsp").forward(req, res);
    }
}