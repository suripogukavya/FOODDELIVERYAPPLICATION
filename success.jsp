<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins', sans-serif;
}

/* FULLSCREEN BACKGROUND */
body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    position: relative;
    overflow: hidden;
}

/* Background image layer with blur */
.bg-image{
    position: absolute;
    top:0;
    left:0;
    width:100%;
    height:100%;
    background: url('https://t3.ftcdn.net/jpg/06/37/79/62/360_F_637796226_liOHveRjDicrSL7U5Z4ErzMaFf2c1ybe.jpg') no-repeat center center/cover;
    z-index:0;
}

/* GLASS EFFECT BOX - TRANSPARENT */
.overlay{
    position:relative;
    z-index:1;
    width:450px;
    padding:35px;
    border-radius:20px;
    background: rgba(255,255,255,0.15); /* more transparent glass */
    backdrop-filter: blur(12px);
    box-shadow:0 12px 25px rgba(0,0,0,0.3);
    text-align:center;
    animation: fadeInUp 0.8s ease forwards;
    opacity:0;
    transform: translateY(20px);
}

/* Fade-in animation */
@keyframes fadeInUp {
    to { opacity:1; transform: translateY(0); }
}

/* CHEF IMAGE */
.chef-img{
    width:120px;
    height:auto;
    margin-bottom:15px;
}

/* CHECKMARK ANIMATION INSIDE BOX */

@keyframes scaleIn {
    from { opacity:0; transform: scale(0.5); }
    to { opacity:1; transform: scale(1); }
}


@keyframes draw{
    from { opacity:0; height:0; }
    to { opacity:1; height:40px; }
}

h2{
    color:#fff;
    margin-bottom:10px;
    text-shadow: 1px 1px 4px rgba(0,0,0,0.6);
}

p{
    color:#fff;
    font-size:16px;
    margin-bottom:20px;
    text-shadow: 1px 1px 3px rgba(0,0,0,0.5);
}

button{
    padding:12px 20px;
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
    box-shadow:0 0 15px #ff512f;
}

</style>
</head>
<body>

<!-- Blurred background -->
<div class="bg-image"></div>

<div class="overlay">

    <!-- Chef image -->
    <img class="chef-img" src="https://www.shutterstock.com/image-vector/cute-chef-girl-mascot-logo-600nw-2572732163.jpg" alt="Chef">

    <!-- Tick mark -->
    <div class="checkmark"></div>

    <h2>Order Successfully Placed!</h2>
    <p>Your delicious food is on the way!</p>

    <form action="menu" method="get">
        <button>Back to Menu</button>
    </form>

</div>

</body>
</html>