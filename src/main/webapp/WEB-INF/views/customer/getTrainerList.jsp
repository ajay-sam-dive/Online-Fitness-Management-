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
<table class="table table-striped" style="color: 2px solid black">

<tr class="tr1" style="color: 2px solid black">
			<th>Name</th>
			<th>Role</th>
			<th>Photo</th>
			<th>Rating</th>
			<th class="text-center">Action</th>
		
			
			</tr>
<c:forEach items="${requestScope.trainerList}" var="train">
<c:choose>
<c:when test ="${train.trainerRole eq customer_details.interest}"> 
<tr class="tr2" style="color: 2px solid black">
		<td>${train.trainerName}  </td>
		<td>${train.trainerRole}</td>
	    <td><img src="../../../static/trainerImages/${train.photo}" height="100" width="100"/></td>
	  	   <td><i class="fas fa-star" style="color: yellow;" ></i>${train.rating}</td>
	    <td><a href='/customer/trainerById?trainerId=${train.trainerId}' class="btn btn-primary">View</a></td>
		</tr>
		</c:when>
		    <c:otherwise>
       
    </c:otherwise>
		

</c:choose>


</c:forEach>



</table>

</div>
<div class="col">

<!-- <form action="/customer/login" method="get">
<button class="btn btn-success" type="submit">Back</button>  -->

 <button class="btn btn-success"><a style="text-decoration: none;color: white;" href="/customer/customerProfile"/>Back</a> </button> 

<!-- </form> -->
</div>
</div>
</body>
</html>