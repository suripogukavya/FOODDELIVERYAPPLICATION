<%@ page import="java.util.*, com.tap.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants Near You</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Poppins', sans-serif;
}

/* Full page food background */
body {
    position: relative;
    min-height: 100vh;
    padding: 40px;
    background: url('https://images.unsplash.com/photo-1600891964599-f61ba0e24092?ixlib=rb-4.0.3&auto=format&fit=crop&w=1470&q=80') no-repeat center center/cover;
}

/* Dark overlay to make content stand out */
body::before {
    content: "";
    position: absolute;
    top:0;
    left:0;
    width:100%;
    height:100%;
    background: rgba(0,0,0,0.5); /* adjust opacity if needed */
    z-index: 0;
}

/* Title */
h2{
    text-align:center;
    color:#fff;
    font-size:36px;
    text-shadow: 2px 2px 10px rgba(0,0,0,0.7);
    margin-bottom:40px;
    position: relative;
    z-index: 1;
}

/* Grid layout */
.grid{
    display:grid;
    grid-template-columns: repeat(auto-fit,minmax(300px,1fr));
    gap:30px;
    position: relative;
    z-index:1; /* cards above overlay */
}

/* Glass cards */
.card{
    background: rgba(255,255,255,0.1); /* lighter glass effect */
    backdrop-filter: blur(15px);
    color:white;
    border-radius:15px;
    overflow:hidden;
    transition: transform 0.3s, box-shadow 0.3s;
}

/* Hover effect */
.card:hover{
    transform: scale(1.05);
    box-shadow: 0 10px 30px rgba(255, 165, 0, 0.7);
}

/* Restaurant image */
.card img{
    width:100%;
    height:180px;
    object-fit:cover;
}

/* Restaurant info */
.card-content{
    padding:15px;
    text-align:center;
}

.card-content h3{
    font-size:24px;
    margin-bottom:8px;
}

/* Cuisine & ETA */
.card-content p{
    margin:5px 0;
}

/* Rating stars */
.stars{
    color: #FFD700;
    font-size: 18px;
    margin:5px 0;
}

/* View Menu button */
.card-content a{
    display:inline-block;
    margin-top:10px;
    padding:10px 20px;
    border-radius:10px;
    background: linear-gradient(45deg, #ff512f, #dd2476);
    color:white;
    text-decoration:none;
    transition: 0.3s;
}

.card-content a:hover{
    background: linear-gradient(45deg, #f7971e, #ffd200);
    transform: scale(1.05);
    box-shadow: 0 5px 20px rgba(255,255,0,0.7);
}
</style>
</head>
<body>

<h2>Restaurants Near You</h2>

<div class="grid">
<%
List<Restaurant> list = (List<Restaurant>)request.getAttribute("restaurants");

if(list != null){
    for(Restaurant r : list){
%>
    <div class="card">
        <img src="<%= r.getImageUrl() %>" alt="<%= r.getName() %>">
        <div class="card-content">
            <h3><%= r.getName() %></h3>
            <p><%= r.getCuisineType() %> | ETA: <%= r.getEstimatedTimeOfArrival() %> mins</p>
            <div class="stars">
                <% 
                    int fullStars = (int) Math.floor(r.getRating());
                    for(int i=0;i<fullStars;i++){
                %>
                    &#9733;
                <% } %>
                <% if(r.getRating() - fullStars >= 0.5){ %>
                    &#9734;
                <% } %>
            </div>
            <a href="menu?rid=<%= r.getRestaurantId() %>">View Menu</a>
        </div>
    </div>
<% 
    }
} 
%>
</div>

</body>
</html>