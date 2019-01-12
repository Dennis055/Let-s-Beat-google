<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Houses For Rent</title>
</head>
<style>
body{background-image:url('http://insightreport.debeersgroup.com/_images/backgrounds/global-consumer-demand-bg.jpg');background-repeat:no-repeat;}
p{font-family:cursive;text-align:center;font-size:60px;color:#000000;text-shadow:0px 0px 25px #0033FF}
img{position:absolute;width :200px; height=:200px;top:17%;left:45%;shadow:12px 21px 25px #0033FF}

input[type="text"]{position:absolute;left:34%;top:40%;font-size:13px;
font-style:italic;width:523px;height:20px;z-index:2;border:2px solid#FFFFFF;border-radius: 15px;box-shadow:9px 9px 7px 0px rgba(42,42,42,.75);margin:auto;}
input[type="text"]:hover{box-shadow:9px 9px 7px 0px rgba(23,87,214,.75);}
input[type="submit"]{position:absolute;left:70%;top:40%;border-radius:10px;color:#000000;background-color:#FFFFFF;box-shadow:6px 4px 6px 0px rgba(42,42,42,.75);height:25px;width:70px}
input[type="submit"]:hover{color:#0099FF;box-shadow:6px 4px 6px 0px rgba(23,87,214,.75)}
</style>
<body>


<form action='${requestUri}' method='get'>
<p>Houses For Rent</p>
<img src= "http://www.lifetimeearn.com/images/home-icon.png"  />
<input  type='text' name='keyword' placeholder = 'keyword'  />
<input  type='submit' value='search' />
</form>
</body>
</html>

