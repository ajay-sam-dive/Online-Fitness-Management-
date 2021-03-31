<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" sizes="16x16" href="/static/favicon-16x16.png">
<!-- <link rel="manifest" href="/static/site.webmanifest"> -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!--  <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon" > -->

 <!--  
  	<link rel="stylesheet" href="/static/bootstrap.min.css">
 
   -->
 
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
  <!-- Brand -->
  <a class="navbar-brand" href="/" style="color:  	#01FFFF; text-shadow: 2px 2px 4px #000000;" >GetFit </a>

  <!-- Links -->
  <ul class="navbar-nav">
   
    <li class="nav-item">
      <a class="nav-link" href="#">About</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" role="button" data-toggle="dropdown"><span class="glyphicon glyphicon-log-in"></span>
        Sign Up
      </a>
      <div class="dropdown-menu">
 <!--       <a class="dropdown-item" href="/admin">Admin</a>
        	<div class="dropdown-divider"></div> -->
        <a class="dropdown-item" href="/customer">Customer</a>
        	<div class="dropdown-divider"></div>
        <a class="dropdown-item" href="/trainer">Trainer</a>
     
      </div>
    </li>
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" role="button" data-toggle="dropdown"><span class="glyphicon glyphicon-log-in"></span>
        Login
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/customer/loginPage">Customer</a>
        	<div class="dropdown-divider"></div>
        <a class="dropdown-item" href="/trainer/loginPage">Trainer</a>
     <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="/admin/loginPage">Admin</a>
      </div>
    </li>
	
  </ul>
  

  
</nav>

 <!-- 
 <script src="/static/jquery.min.js"></script>
<script src="/static/popper.min.js"></script>
<script src="/static/bootstrap.min.js"></script>
 
  -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
</body>
</html>