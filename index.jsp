<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Login</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Poppins', sans-serif;
}

/* FOOD BACKGROUND */
body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background: url('https://images.unsplash.com/photo-1504674900247-0877df9cc836') no-repeat center center/cover;
}

/* DARK GLASS BOX */
.container{
    width:350px;
    padding:40px;
    border-radius:20px;
    background: rgba(0,0,0,0.7);
    backdrop-filter: blur(10px);
    box-shadow:0 10px 40px rgba(0,0,0,0.8);
    text-align:center;
    color:white;
    animation: fadeIn 1s ease;
}

/* Animation */
@keyframes fadeIn{
    from{
        opacity:0;
        transform:translateY(40px);
    }
    to{
        opacity:1;
        transform:translateY(0);
    }
}

h2{
    margin-bottom:20px;
    color:#ffcc70;
}

/* Inputs */
.input-box{
    margin:20px 0;
}

.input-box input{
    width:100%;
    padding:12px;
    border:none;
    border-radius:10px;
    outline:none;
}

/* Button */
button{
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
    transform:scale(1.05);
    box-shadow:0 0 15px #ff512f;
}

/* Extra text */
.extra{
    margin-top:15px;
    font-size:14px;
    color:#ddd;
}

</style>

</head>
<body>

<div class="container">

    <h2>Food Delivery</h2>

    <form action="login" method="post">

        <div class="input-box">
            <input type="email" name="email" placeholder="Enter Email" required>
        </div>

        <div class="input-box">
            <input type="password" name="password" placeholder="Enter Password" required>
        </div>

        <button type="submit">Login</button>

    </form>

    <div class="extra">
        Delicious food waiting for you.....
    </div>

</div>

</body>
</html>