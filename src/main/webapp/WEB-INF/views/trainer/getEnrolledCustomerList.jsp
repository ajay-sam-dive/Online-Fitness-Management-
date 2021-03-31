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
<title>GetFit || Enrolled Customer List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<div class="col" style="text-align: center;">
<h3>  <label class="text" style="text-align: center;">Customer Details</label> </h3> 
<table class="table table-striped" style="color: 2px solid black">

<tr class="tr1" style="color: 2px solid black">
			<th>Name</th>
			<th>Module</th>
			<th>Gender</th>
			<th>Goals</th>
			<th>Food Preference</th>
			<th>Fitness Level</th>
			<th>Time</th>
			<th>Enrollment</th>
		
		
			
			</tr>
<c:forEach items="${requestScope.customer_details}" var="cust">
<c:choose>
<c:when test ="${train.trainerRole eq customer_details.interest}"> 
<tr class="tr2" style="color: 2px solid black">
		<td>${cust.custName}  </td>
		<td>${cust.interest}</td>
		<td>${cust.gender}</td>
		<td>${cust.goals}</td>
		<td>${cust.foodPreference}</td>
		<td>${cust.fitnessLevel}</td>
		<td>${cust.startTime} to ${cust.endTime}</td>
		<td>${cust.enrollment}</td>
	  
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