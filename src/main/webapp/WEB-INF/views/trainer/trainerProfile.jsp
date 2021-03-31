<!DOCTYPE html>
<%@page import="com.app.pojos.Customer"%>
<%@page import="com.app.pojos.Trainer"%>
<%@page import="com.app.controller.CustomerController"%>

<html>
<head>
<%-- <%@include file="./base.jsp"%> --%>
<meta charset="UTF-8">

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ=="
	crossorigin="anonymous" />

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-image: url("/static/images/athletic.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	padding: 72px;
}

.bg-common {
	background: rgba(34, 44, 51, 0.6);
}

.bg-right {
	background: /* #383f48; */
}

.nav-link {
	padding: 10px /* up */ 0 /* left */ 10px /*bottom  */ 30px /* right */;
	transition: all .4s;
	color: #bfc0cd;
}

.nav-link:hover {
	color: #F2F3F4;
}

.card {
	box-shadow: 0 /* horizontal offset */ 0 /* vertical offset */ 8px
		/* blurr offset */ 2px /* spread offset */ rgba(250, 250, 250, 0.1);
}

.card-left {
	border-radius: 5px;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: red;
	color: white;
	text-align: center;
}
</style>

<title>GetFit || TrainerProfile</title>
</head>
<body class="bg-right">

<!--NavBar starts  -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

		<a class="navbar-brand" href="/">GetFit</a>







<!-- 	logout button -->
		<button type="submit" class="btn btn-danger">
			<a style="color: white; text-decoration: none;"
				href="<spring:url value='/trainer/logout'/>">Log Out</a>
		</button>



		<div class="text mx-auto">
			<h5 class="text-white">Welcome
				${sessionScope.trainerDetails.trainerName}</h5>
		</div>
	</nav>	
<!--NavBar ends  -->
	
	
	<div class="container-fluid mt-1">
		<div class="row">

			<!-- Leftside div starts -->
			<div class="col-lg-3 col-md-4 d-md-block ">
				<div class="card bg-common card-left bg-common ">
					<div class="card-body">


<!-- vertical navs -->
						<ul class="nav  d-md-block d-none">
							<!-- <li class="nav-item"><a data-toggle="tab" class="nav-link "
								href="#edit"><i class="fas fa-user-edit mr-1"></i>Show</a></li> -->
							<li class="nav-item"><a data-toggle="tab" class="nav-link"
								href="#show"><i class="far fa-list-alt mr-1"></i>Show Customers</a></li>
						</ul>
<!-- vertical navs ends-->
					
					
					</div>
				


				</div>
			
			</div>
<!-- Leftside ends here -->


<!-- Rightside div starts here -->
			<div class="col-lg-9 col-md-8">
				<div class="card">
					<div class="card-header boarder-bottom mb-1 d-md-none">
						<ul class="nav nav-tabs card-header-tabs nav-fill ">
						<!-- 	<li class="nav-item"><a data-toggle="tab" class="nav-link"
								href="#edit"><i class="fas fa-user-edit mr-1"></i></a></li> -->

							<li class="nav-item"  ><a data-toggle="tab" class="nav-link"
								href="#show"><i class="far fa-list-alt mr-1"></i></a></li>

						</ul>
					</div>
					
					
<!--Actual Content -->
					<div class="card-body tab-content border-0">

						<div class="tab-pane " id="edit">
							<div class="edituser text-center">
								<h3>Show Customers</h3>
							</div>
							<hr>
							<br>
							
							


						</div>
						<div class="tab-pane " id="show">

				
							<div class="col" style="text-align: center;">
						
								<table class="table table-striped"
									style="color: 2px solid black">
									<tr class="tr2" style="color: 2px solid black" id="response"></tr>
								</table>
							</div>
	
						</div>
					</div>
<!-- Actual Content Ends -->

			
				</div>
			</div>
<!-- Rightside div ends -->


		</div>
		
		
<!-- Footer -->
		<div class="footer bg-dark text-white py-2">
			<p>
				<i class="fas fa-copyright"></i> 2021 GetFit Pvt Ltd. All Rights
				Reserved.
			</p>
		</div>
<!-- Footer -->


<!-- Scripts  -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script type="text/javascript">
			$(document).ready(function() {
				displaydata();
				function displaydata() {

					$.ajax({
						url : '/trainer/getEnrolledCustomerList',
						type : 'get',
						success : function(responsedata) {
							$('#response').html(responsedata);
						}

					});
				}

			});
		</script>

<!-- Scripts  -->		


	</div>
</body>
</html>