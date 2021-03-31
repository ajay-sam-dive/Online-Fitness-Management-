<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="../header.jsp"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetFit || Customer Registration</title>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	background-image: url("/static/images/gym.jpg");
	background-size: cover;
	font-family: new time roman;
}

h1 {
	font-size: 50px;
	color: #CFF1E9;
}

img {
	width: 130px;
	height: 130px;
	border-radius: 100px;
	margin-left: 200px;
	transition: 1s;
}

img:hover {
	-webkit-transform: scale(1.3);
}

.form-control {
	background: transparent;
	border-radius: 3px;
	border: 0px;
	border-bottom: 2px solid lightgreen;
	font-size: 21px;
	margin-top: 18px;
	padding: 23px;
	color: white;
	transition: 1s;
}
.form-control:hover {
	-webkit-transform: scale(1.3);
}

.btn-info{
margin-top: 20px;
font-size: 21px;
border-radius:30px;
background: transparent;

}
.col-md-6{
box-shadow: -1px 1px 60px 10px black;
border-radius: 50px 50px 50px 50px;
margin-top: 100px;
height: 90vh;
background: rgba(0,0,0,0.4); 
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md"></div>
			<div class="col-md-6">
			<h4 class="text-danger">${requestScope.message}</h4>
				<h1 class="text-center">Customer Registration</h1>
				<hr>
				<img alt="" src="/static/images/workout.jpeg">
				<form action="/customer/register" method="post">
					<div class="form-group">
						<input type="email" class="form-control" placeholder="Enter email"
							id="custEmail" name="custEmail" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Enter password" id="custPassword" name="custPassword" required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter name"
							id="custName" name="custName" required>
					</div>
					<div class="form-group">
						
							<input type="text" 	class="form-control"  id="custPhoneNumber" placeholder="Enter phone"  name="custPhoneNumber" required  maxlength="10"/>
						
					</div>
					<div class="form-group text-center">
						<button type="submit" class="btn btn-info btn-block">Register</button>
					</div>
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>

</body>
</html>
<%@include file="../footer.jsp"%>