<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<%@include file="../header.jsp" %>
			<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<link href="/static/styles/style.css" rel="stylesheet">
<meta charset="UTF-8">
 
<title>GetFit || Login</title>

</head>
<body>


     <h2>${requestScope.message}</h2>
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<form method="post" action="/trainer/authenticate" class="form-container" > 
					<div class="form-group">
						<h3 class="text-center py:5">Sign in</h3>
						<hr>
						<label for="exampleInputEmail1">Email address</label> 
						<input type="email" class="form-control" id="trainerEmail" name="email"
							aria-describedby="emailHelp" placeholder="Enter email" required> <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="trainerPass"
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
	<%@include file="../footer.jsp" %>