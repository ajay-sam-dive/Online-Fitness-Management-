<!DOCTYPE html>
<%@page import="com.app.pojos.Customer"%>
<%@page import="com.app.pojos.Trainer"%>
<%@page import="com.app.controller.CustomerController"%>

<html>
<head>
<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />

<meta charset="UTF-8">

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	/* response.setHeader("Cache-control", "no-cache, no-store"); */
Customer customer = (Customer) session.getAttribute("customer_details");

HttpSession sesion = request.getSession(false);
if (sesion == null || customer == null) {
	response.sendRedirect("signin.jsp");
}
%>

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
	background-image: url("/static/images/cross.jpg");
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

<title>GetFit || CustomerProfile</title>
</head>
<body class="bg-right">

<!--NavBar starts  -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

		<a class="navbar-brand" href="/">GetFit</a>







<!-- 	logout button -->
		<button type="submit" class="btn btn-danger">
			<a style="color: white; text-decoration: none;"
				href="<spring:url value='/customer/logout'/>">Log Out</a>
		</button>



		<div class="text mx-auto">
			<h5 class="text-white">Welcome
				${sessionScope.customer_details.custName}</h5>
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
						<h5 class="text-success">${requestScope.mesg}</h5>
						<h5 class="text-success" >${requestScope.message}</h5>
						<ul class="nav  d-md-block d-none">
							<li class="nav-item"><a data-toggle="tab" class="nav-link "
								href="#edit"><i class="fas fa-user-edit mr-1"></i>Update
									Details</a></li>
							<li class="nav-item"><a data-toggle="tab" class="nav-link"
								href="#show"><i class="far fa-list-alt mr-1"></i>Show
									Trainers</a></li>
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
							<li class="nav-item"><a data-toggle="tab" class="nav-link"
								href="#edit"><i class="fas fa-user-edit mr-1"></i></a></li>

							<li class="nav-item"><a  data-toggle="tab" class="nav-link"
								href="#show"><i class="far fa-list-alt mr-1"></i></a></li>

						</ul>
					</div>
					
					
<!--Actual Content -->
					<div class="card-body tab-content border-0">

						<div class="tab-pane " id="edit">
							<div class="edituser text-center">
								<h3>Update Your Details</h3>
							</div>
							<hr>
							<br>
							
							
<!-- Update	Form Body -->
							<form method="post" action="/customer/update">
							
								<input type="hidden" name="custId"
									value="<%=customer.getCustId()%>">
								<div class="form-row">
									<div class="form-group col-md-4">
										<label>Age</label><input type="number" class="form-control"
											id="age" name="age" placeholder="<%=customer.getAge()%>"
											value="<%=customer.getAge()%>">
									</div>
									<div class="form-group col-md-4">
										<label>Height(cm)</label> <input type="number"
											class="form-control" name="height" id="height"
											value="<%=customer.getHeight()%>">
									</div>
									<div class="form-group col-md-4">
										<label>Weight(kg)</label> <input type="number"
											class="form-control" name="weight" id="weight"
											value="<%=customer.getWeight()%>">
									</div>
								</div>


								<!-- 	Gender -->
								<div class="form-row">
									<div class="form-group col-md-6">
										<label>Gender</label> <select
											<input type="text" id="gender"
													name="gender" value="<%=customer.getGender()%>"/>
											class="form-control" id="gender">
											<option><%=customer.getGender()%></option>
											<option>Male</option>
											<option>Female</option>
										</select>
									</div>

									<!-- 	Interest -->
									<div class="form-group col-md-6">
										<div class="form-group">
											<label>Interest</label> <select
												<input type="text" id="interest"
													name="interest"  value="<%=customer.getInterest()%>"/>
												class="form-control" id="interest">
												<option><%=customer.getInterest()%></option>
												<option>GYM</option>
												<option>YOGA</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-6">
										<!-- 	Goals -->
										<div class="form-group">
											<label>Goal</label> <br /> <select
												<input type="text" id="goals"
													name="goals" value="<%=customer.getGoals()%>"/>
												class="form-control" id="goals">
												<option><%=customer.getGoals()%></option>
												<option>Weight Loss</option>
												<option>Weight Gain</option>
											</select>
										</div>
									</div>
									<div class="form-group col-md-6">
										<!-- 	Body Fat -->
										<div class="form-group">
											<label> Bodyfat(%) </label>
											<button type="button" class="btn btn-warning" data-toggle="modal" data-target=".bd-example-modal-lg">Body Fat Chart</button>
											 <input type="text" name="bodyFat"
												class="form-control" id="bodyFat"
												value="<%=customer.getBodyFat()%>">
										</div>
										
<!-- Model Body -->									
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    <img alt="" src="/static/images/bodyf.jpg">
    </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
      </div>
  </div>
</div>	
<!-- Model Body End -->	

									</div>
								</div>


								<div class="form-row">
									<!-- 	Fitness Level -->
									<div class="form-group col-md-6">
										<label>Fitness Level</label> <select
											<input type="text" id="fitnessLevel"
													name="fitnessLevel" value="<%=customer.getFitnessLevel()%>"/>
											class="form-control" id="fitness">
											<option><%=customer.getFitnessLevel()%></option>
											<option>Beginner</option>
											<option>Intermediate</option>
											<option>Pro</option>
										</select>
									</div>

									<!-- 	Activity Level -->
									<div class="form-group col-md-6">
										<label>Activity level </label> <select
											<input type="text" id="activityLeval"
													name="activityLeval" value="<%=customer.getActivityLeval()%>"/>
											class="form-control" id="activity">
											<option><%=customer.getActivityLeval()%></option>
											<option>None</option>
											<option>Once in a week</option>
											<option>Weekly</option>
										</select>

									</div>


								</div>

								<div class="form-row">
									<div class="form-group col-md-6">
						<!-- 	Date of Birth -->
										<div class="form-group">
											<label>Date of Birth</label> <input type="date"
											class="txtDate"	id="birthDate" name="birthDate"
												value="<%=customer.getBirthDate()%>" />
										</div>

									</div>
									<div class="form-group col-md-6">
						<!-- 	Food Preference -->
										<div class="form-group">
											<label>Food Preference</label> <select
												<input type="text" id="foodPreference"
													name="foodPreference" value="<%=customer.getFoodPreference()%>"/>
												class="form-control" id="foodPref">
												<option><%=customer.getFoodPreference()%></option>
												<option>Veg</option>
												<option>Non-Veg</option>
											</select>
										</div>
									</div>
								</div>




								<!-- 	Workout Timing -->
								<div class="form-group col">
									<b>Schedule :</b><label>Monday to Saturday </label> <label>From</label>
									<input type="time" id="startTime" name="startTime"
										value="<%=customer.getStartTime()%>"> <label>
										to </label> <input type="time" id="endTime" name="endTime"
										value="<%=customer.getEndTime()%>">
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-success" id="invokesToastMessage" >Update</button>
								</div>
							</form>
<!-- Update	Form Body ends -->


						</div>
						<div class="tab-pane " id="show">

					<!-- 			<form action="/customer/getTrainerList"> -->
							<div class="col" style="text-align: center;">
							<!-- 	<h3>
									<label class="text" style="text-align: center;">Trainer
										Details</label>
								</h3> -->
								<table class="table table-striped"
									style="color: 2px solid black">
									<tr class="tr2" style="color: 2px solid black" id="response"></tr>
								</table>
							</div>
			<!-- 						</form> -->
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
		 <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<!--     <script>$('#invokesToastMessage').click(function () {
   
    	toastr.success('mesg', 'Updated Successfully');
    	timeout: 1500;
    	});
    </script>
		 -->
		
		<script type="text/javascript">
			$(document).ready(function() {
				displaydata();
				function displaydata() {

					$.ajax({
						url : '/customer/getTrainerList',
						type : 'get',
						success : function(responsedata) {
							$('#response').html(responsedata);
						}

					});
				};

				
				

			});
	
		</script>
<!-- Scripts  -->		


	</div>
</body>
</html>