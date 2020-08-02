<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
<head>
     <meta name="viewport" content="width=device-width,initial-scale=1.0">
     <title>Paypal site</title>
     <link rel="stylesheet" href="page.css">
</head>

<style>
*{
padding:0;
margin:0;
}
.wrapper{
background:url(final.jpg) no-repeat;
background-size:cover;
height:100vh;
}
.navbar{
height:80px;
width:100%;
background:rgba(0,0,0,0.4);
}
.logo{
width:180px;
height:auto;
padding:10px 50px;

}
.navbar ul{
float:right;
margin-right:30px
}
.navbar ul li{
list-style:none;
margin: 0 8px;
display:inline-block;
line-height:80px;
}
.navbar ul li a{
text-decoration:none;
color:white;
font-size:20px;
padding:6px 13px;
font-family: "Lucida Console", Courier, monospace;

transition: .4s;
}
.navbar ul li a.active,
.navbar ul li a:hover{
background:red;
border-radius:2px;
}
.wrapper .center{
position:absolute;
top:50%;
left:50%;
transform: translate(-50%, -50%);
font-family:sans-serif;
user-select:none;
}
.center h1{
color:#01022e;
font-size:45px;
font-weight:bold;
width:900px;
 font-family: "Times New Roman", Times, serif;
font-weight:bold



}
.center h2{
color:#040326;
font-size:30px;
font-weight:bold;
width:600px;
margin-top:10px;
font-weight:bold;


}
.center h3{
color:#c70404;

font-weight:bold;

}
.center .buttons{
margin:50px 280px;
}
.buttons button{
height:50px;
width: 150px;
font-size:18px;
font-weight:bold;
color:#ffb3b3;
background:white;
border: 1px solid #cc0000;
outline:none;
cursor:pointer;
border-radius:25px;
}
.buttons .btn{
margin-left:25px;
}
.buttons button:hover{
background:#afbab2;
}
</style>
<body>
    <div class="wrapper">
      <nav class="navbar">
           <img class="logo" src="logo3.png">

       <ul>
<li><a class="active" href="#">Home</a></li>
<li><a href="#">Indiviual</a></li>
<li><a href="#">Business</a></li>
<li><a href="#">Partners</a></li>
<li><a href="#">Feedbacks</a></li>
       </nav>

<div class="center">
<marquee><h3> Safe & secured  transaction  with  24/7....</h3></marquee>
<h1>Welcome To PayPal</h1>
<h2>Your true value is determined by how much more you Transfer</h2>
<div class="buttons">
 <a href="registerprocess">REGISTER</a>            
<a href="logincall">LOGIN</a>
               

              
</div>
     </div>
</body>
</html>