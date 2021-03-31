<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

			<%@include file="header.jsp" %>
			<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.bg{
	background: url('/static/images/1087636.jpg') no-repeat;
	width: 100%;
	height: 100vh;
	background-size: 100%;
}
.form-container{
background:transparent;
opacity:0.75; 
	position:absolute;
	/*  top:15vh;  */
	border-radius:0.5rem;
	background: #ffff;
	padding: 30px;
	box-shadow: 0px 0px 10px 0px #000;
}

@media only screen and(max-width: 678px) {
	.bg{
		background-size: 300%;
	}

}

h1{
font-size: 2.5rem;   
 padding: 9vh; 
 color:#CCFFEC;
 text-align: center;  
 text-shadow: 0px 0px 10px 0px #000;  
font-variant: small-caps;

}


</style>
<!-- <link href="/static/styles/style.css" rel="stylesheet"> -->
<meta charset="UTF-8">
 
<title>GetFit || Login</title>

</head>
<body>

	
     <h5>${requestScope.message}</h5>
	<section class="container-fluid bg">
		<h1>Welcome To GetFit</h1>
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<form method="post" action="/customer/login" class="form-container" > 
					<div class="form-group">
						<h3 class="text-center py:5">Sign in</h3>
						<hr>
						<label for="exampleInputEmail1">Email address</label> 
						<input type="email" class="form-control" id="custEmail" name="email"
							aria-describedby="emailHelp" placeholder="Enter email" required> <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="custPassword"
							name="password"
							placeholder="Password" required>
					</div>

					<button type="submit" class="btn btn-primary btn-block" style="border-radius: 1rem">Login</button>


				</form>

			</section>
		</section>
	</section>


</body>
</html>
	<%@include file="footer.jsp" %>