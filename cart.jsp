<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Poppins', sans-serif;
}

/* FULLSCREEN COLORFUL FOOD BACKGROUND */
body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background: url('https://img.freepik.com/free-photo/vegetables-set-left-black-slate_1220-685.jpg?semt=ais_hybrid&w=740&q=80') no-repeat center center/cover;
    position: relative;
}

/* Gradient overlay for vibrancy */
body::after{
    content:"";
    position:absolute;
    top:0; left:0;
    width:100%; height:100%;
    background: rgba(255,255,255,0.1);
    z-index:0;
}

/* GLASS EFFECT CART BOX */
.overlay{
    position: relative;
    z-index:1;
    width:450px;
    max-width:90%;
    padding:30px;
    border-radius:20px;
    background: rgba(255,255,255,0.85);
    backdrop-filter: blur(10px);
    box-shadow:0 12px 25px rgba(0,0,0,0.3);
    animation: fadeInUp 0.8s ease forwards;
    opacity:0;
    transform: translateY(20px);
}

/* Fade in animation */
@keyframes fadeInUp {
    to {
        opacity:1;
        transform: translateY(0);
    }
}

h2{
    text-align:center;
    margin-bottom:25px;
    color:#ff6f61;
}

/* Cart items */
.cart-item{
    display:flex;
    align-items:center;
    justify-content: space-between;
    padding:12px 0;
    border-bottom:1px solid #ddd;
}

.cart-item:last-child{
    border-bottom:none;
}

/* Item image */
.cart-item img{
    width:60px;
    height:60px;
    border-radius:50%;
    object-fit:cover;
    margin-right:15px;
    box-shadow:0 2px 6px rgba(0,0,0,0.2);
}

/* Item info */
.item-info{
    flex:1;
    display:flex;
    flex-direction: column;
}

.item-info span{
    font-size:16px;
    color:#333;
    margin-bottom:4px;
}

.item-price{
    font-weight:bold;
    color:#1e90ff;
}

/* Total price */
.total{
    text-align:right;
    font-size:18px;
    font-weight:bold;
    color:#ff4500;
    margin-top:20px;
}

/* Place order button */
button{
    margin-top:20px;
    width:100%;
    padding:12px;
    border:none;
    border-radius:10px;
    background: linear-gradient(to right, #ff512f, #dd2476);
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    transform: scale(1.05);
    box-shadow: 0 0 15px #ff512f;
}

/* Empty cart text */
.empty{
    text-align:center;
    color:#555;
    font-size:16px;
    margin:20px 0;
}
</style>
</head>
<body>

<div class="overlay">
    <h2>Your Cart</h2>

<%
List<Map<String,Object>> cart = (List<Map<String,Object>>) session.getAttribute("cart");
double total = 0;

if(cart != null && !cart.isEmpty()){
    for(Map<String,Object> item : cart){
        total += (double)item.get("price");
        // Use default image if "image" field is missing
        String img = (item.get("image") != null) ? (String)item.get("image") : "https://via.placeholder.com/60";
%>
    <div class="cart-item">
        <img src="<%= img %>" alt="<%= item.get("name") %>">
        <div class="item-info">
            <span><%= item.get("name") %></span>
            <span class="item-price">₹<%= item.get("price") %></span>
        </div>
    </div>
<%
    }
}else{
%>
    <div class="empty">Your cart is empty.</div>
<%
}
%>

<div class="total">Total: ₹<%= total %></div>

<form action="order" method="post">
    <button>Place Order</button>
</form>
</div>

</body>
</html>