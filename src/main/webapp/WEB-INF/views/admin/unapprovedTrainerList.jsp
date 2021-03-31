<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@page import="com.app.pojos.Trainer" %>
    <%@page import="com.app.pojos.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetFit || Trainers List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<div class="col" style="text-align: center;">
<h3>  <label class="text" style="text-align: center;">Trainer Details</label> </h3> 
<c:set var="ts" value="${requestScope.trainer.trainerSchedule}" scope="request"></c:set>
<table class="table table-striped" style="color: 2px solid black">

<tr class="tr1" style="color: 2px solid black">
			<th>Name</th>
			<th>Role</th>
			<th>Photo</th>
			<th>Rating</th>
			<th>Timing</th>
			
			<th>View Certificate</th>
			<th class="text-center">Action</th>
		
			
			</tr>
<c:forEach items="${sessionScope.trainerList}" var="train">


<tr class="tr2" style="color: 2px solid black">
		<td>${train.trainerName}  </td>
		<td>${train.trainerRole}</td>
	    <td><img src="../../../static/trainerImages/${train.photo}" height="100" width="100"/></td>
	    <%-- <td><img src="../../views/trainer/images/${train.photo}" height="100" width="100"/></td> --%>
	   <td><i class="fas fa-star" style="color: yellow;" ></i>${train.rating}</td>
	   <td>${ts.startTime}</td>
	   
	   <td> <a  type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">View Certificate</a>
	       </td>
	       <td><a href='/admin/approveTrainer?trainerId=${train.trainerId}' class="btn btn-primary">Approve</a> <br>
	      
	       
	       </td>
<!-- 	    <td> <a  type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
   Approve
  </a></td> -->
		</tr>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Trainer Certificate </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <!-- 	<form class="form-grp" action="/trainer/update" method="post"> -->
																	
								<div class="row">
								<embed src="../../../static/trainerImages/${train.certificate}" width="300px" height="400px" />
							<%-- 	<label>Certificate</label>
								 <input class="form-control"  id="status" value="${train.certificate}" name="status">
								 --%></div>
								<br>														
				<!-- 	<div class="button text-center">
					
					 <button type="submit" class="btn btn-success">Save</button>
			
					</div> -->
	<!-- </form> -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       
      </div>
    </div>
  </div>
</div>





        



</c:forEach>



</table>


 <button class="btn btn-success"><a style="text-decoration: none;color: white;" href="/admin/adminProfile"/>Back</a> </button> 

</div>

</div>
</body>
</html>