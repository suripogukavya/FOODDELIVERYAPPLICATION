<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.tap.model.MenuItem, com.tap.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 40px;
            color: #fff;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.7);
        }

        .restaurant-section {
            margin: 40px auto;
            max-width: 1200px;
            opacity: 0;
            animation: fadeIn 0.8s forwards;
        }

        @keyframes fadeIn {
            to { opacity: 1; }
        }

        .restaurant-name {
            font-size: 24px;
            margin-bottom: 20px;
            color: #222;
        }

        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 20px;
        }

        .menu-card {
            background: white;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            display: flex;
            flex-direction: column;

            /* Animation */
            opacity: 0;
            transform: translateY(20px);
            animation: fadeInUp 0.5s forwards;
            animation-delay: var(--delay);
            transition: transform 0.3s, box-shadow 0.3s;
        }

        @keyframes fadeInUp {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .menu-card:hover {
            transform: translateY(-10px) scale(1.05);
            box-shadow: 0 12px 25px rgba(0,0,0,0.25);
        }

        .menu-card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
        }

        .menu-content {
            padding: 15px;
            flex-grow: 1;
            display: flex;
            flex-direction: column;
        }

        .menu-content h4 {
            margin: 0 0 10px 0;
            font-size: 18px;
            color: #444;
        }

        .menu-content p {
            margin: 5px 0;
            font-size: 14px;
            color: #666;
        }

        .menu-content .price {
            font-weight: bold;
            color: #1e90ff;
        }

        .menu-content .rating {
            color: gold;
            margin: 5px 0;
        }

        .menu-content .add-cart {
            margin-top: auto;
            padding: 10px;
            background: #1e90ff;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            transition: background 0.3s;
        }

        .menu-content .add-cart:hover {
            background: #0d5fae;
        }

        .restaurant-bg {
            border-radius: 12px;
            padding: 20px;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            margin-bottom: 40px;
            color: white;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.7);
        }

        @media (max-width: 768px) {
            .menu-grid {
                grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
            }
        }
    </style>
</head>
<body>

<%
List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurants");
Map<Integer, List<MenuItem>> restaurantItems = (Map<Integer, List<MenuItem>>) request.getAttribute("restaurantItems");

for (Restaurant restaurant : restaurants) {
    List<MenuItem> itemsList = restaurantItems.get(restaurant.getRestaurantId());
    if (itemsList == null || itemsList.isEmpty()) continue;
%>

<div class="restaurant-section">

    <div class="restaurant-bg" style="background-image: url('<%= restaurant.getImageUrl() %>');">
        <h2><%= restaurant.getName() %></h2>
        <p><%= restaurant.getDescription() %></p>
    </div>

    <div class="menu-grid">
        <% for (MenuItem item : itemsList) { %>
            <div class="menu-card" style="--delay: <%= 0.1 * itemsList.indexOf(item) %>s;">
                <img src="<%= item.getImageUrl() %>" alt="<%= item.getName() %>">
                <div class="menu-content">
                    <h4><%= item.getName() %></h4>
                    <p><%= item.getTypesOfDishes() %></p>
                    <p class="price">₹ <%= item.getPrice() %></p>
                    
                    <!-- Rating stars -->
                    <p class="rating">
                        <% 
                            int fullStars = (int)Math.floor(item.getRating());
                            for(int i=0;i<fullStars;i++){ %>
                                &#9733;
                        <% } %>
                        <% if(item.getRating() - fullStars >= 0.5){ %>
                            &#9734;
                        <% } %>
                    </p>

                    <form action="addToCart" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <button type="submit" class="add-cart">Add to Cart</button>
                    </form>
                 
                </div>
            </div>
        <% } %>
    </div>

</div>

<% } %>

</body>
</html>