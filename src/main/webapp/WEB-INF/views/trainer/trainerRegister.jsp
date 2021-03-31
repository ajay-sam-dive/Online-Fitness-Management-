<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- navbar included in this file -->
<%@include file="../header.jsp"%>

<!-- footer -->
<%@include file="../footer.jsp"%>

<!DOCTYPE html>
<html>
<head>

<!-- css link -->
<link rel="stylesheet" href="/static/styles/trainer.css">
<meta charset="UTF-8">
<title>GetFit || Trainer Registration</title>
<style type="text/css">
body{
background-attachment:fixed;
background-size: cover;
background-position:center center;
background-repeat:no-repeat;
background-image: url("/static/images/gym.jpg");
}

#ui{
opacity:0.85;
border-radius:1rem;
padding: 30px;
margin: 50px;
background: black;

}
#ui label{
color: white;
}
#h3-head{
color: white;
}


</style>

</head>
<body>
	<div class="container">

			<div class="row">
			<div class="col"></div>
			<div class="col-lg-9">
				<div  id="ui"  >
				<h3 class="text-center" id="h3-head">Trainer Registration</h3>
				<hr>	
			
					<form class="form-grp" action="/trainer/register" method="post" enctype="multipart/form-data">
			
					<div class="row">
						<div class="col-lg-6">
							<label>Name</label> <input class="form-control" type="text"
								id="trainerName" name="trainerName" required>

						</div>
						<div class="col-lg-6">
							<label>Phone Number</label> <input class="form-control"
								type="text" id="trainerPhoneNumber" name="trainerPhoneNumber" min="10" maxlength="10" required >

						</div>
						<!-- row ends here -->
						</div>
						<br>
						
						
						<div class="row">
							<div class="col-md-4">
								<label>Role</label> 
								<br>
								<select
								      input class="form-group" type="text" id="trainerRole"
									class="form-control" name="trainerRole" required >
									<option>Choose Role</option>
									<option>GYM</option>
									<option>YOGA</option>
								</select>

							</div>

					<div class="col-md-4">
								
								<label class="form-label" >Photo</label> <input type="file" accept="image/png,image/jpg" class="form-control"
								name="photo1"	id="photo1" required />
							</div>
								<div class="col-md-4">
								
								<label class="form-label" >Certificate</label> <input type="file" accept="application/pdf" class="form-control"
								name="certificate1"	id="certificate1" required />
							</div>
				

						</div>
						
						<br>
						
						
						<div class="row">
							<div class="col-lg-6">
								<label>Email</label> <input class="form-control" type="email"
									id="trainerEmail" name="trainerEmail" required >

							</div>
							<div class="col-lg-6">
								<label>Password</label> <input class="form-control"
									type="password" id="trainerPass" name="trainerPass" required>

							</div>
							</div>
							
							<br>
							
							
								<div class="row">
									
									<div class="col-md-4">
									<label>Schedule</label>
									<input type="text"
												id="days" name="days" required>
							<!-- 		 <select
														
													name="days"	class="form-control" id="days">
													<option>Monday</option>
											<option>Tuesday</option>
											<option>Wednesday</option>
											<option>Thursday</option>
											<option>Friday</option>
											<option>Saturday</option>
													</select> -->
										
									</div>
																<div class="col-md-4">
																 <label>From</label> <input
												type="time" id="startTime" name="startTime" required  >
																</div>
														
												
												<div class="col-md-4">
												<label> To </label> 
												<input type="time"
												id="endTime" name="endTime">
												</div>
											
												</div>
												<br>
								<div class="row">
								
								
								<div class="col-lg-6">
							<label>	3 Months package price</label>
							  <input type="number" id="priceForThreeMonth" name="priceForThreeMonth" class="form-control" required/>
               
							
								</div>
									<div class="col-lg-6">
									<label>	6 Months package price</label>
							  <input type="number" id="priceForSixMonth" name="priceForSixMonth" class="form-control" required />
               
								</div>
								
								</div>
								<br>
								<div class="row">
								<div class="col-md-4">
								
								<div class="col">	<label>City</label> <input class="form-control" type="text" name="city" id="city" required>
								</div>
								<div class="col"><label>Landmark</label> <input class="form-control" type="text" name="landMark" id="landMark" placeholder="fixed 6 charactersS" required >
									</div>
								
								</div>
								<div class="col-md-4">		<div class="col">	
								<label>State</label> <input class="form-control" type="text" name="state" id="state" required="required" >
							</div>
									<div class="col">	<label>Country</label> <input class="form-control" type="text" name="country" id="country" required >
									</div></div>
								<div class="col-md-4">	<div class="col"><label>Pin Code</label> <input class="form-control" type="number" name="pinCode" id="pinCode"  maxlength="6" required >
								</div></div>
							
								
								</div>
								<br>
								<div class="row">
								<label>Description</label>
								 <textarea class="form-control" rows="5" id="description" name="description"></textarea>
								</div>
								<br>														
					<div class="button text-center">
					
					<button type="submit" class="btn btn-primary">Register</button>
			
					</div>
	</form>
	</div>
		</div>
		<div class="col">
		<!-- <h3>Upload Certificate & Photo</h3>
		<form method="get" action="/trainer/register/upload enctype="multipart/form-data">
  <label for="certificate">Certificate</label>
  <input type="file" id="certificate" name="certificate"><br><br>
  <label for="photo">Photo</label>
  <input type="file" id="photo" name="photo"><br><br>
  <input type="submit" value="upload">
</form> -->
		</div>
		
		<!-- row ends here  -->
		</div>
		<!-- container ends here -->
			</div>
	
	



</body>
</html>