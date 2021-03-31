<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@page import="com.app.pojos.Trainer" %>
    <%@page import="com.app.pojos.Customer" %>
     <%@page import="com.app.pojos.Enrollment" %>
      <%@page import="com.app.pojos.MemberShip" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>GetFit || Trainer Details</title>
<style type="text/css">
*{

}
body{
margin: 0;
padding: 0;
background:#f1f1f1;
box-sizing: border-box;
font-family: arial;
}
.parent-div{
width: 100wh;
height: 100vh;
display: grid;
place-items:center;
}
.child-div{
width: 60wh;
height: 60vh;
overflow: hidden;
/* display: inline-block; */

}
.card-container{
width: 400px;
height: 600px;
background: #FFF;
border-radius: 6px;
position: absolute;
top: 50%;
left: 50%;
transform:translate(-50%,-50%);
box-shadow: 0px 1px 10px 1px #000;
border-radius: 10px;
overflow: hidden;
display: inline-block;
}
.upper-container{
height: 40%;
/* background: #6F00FF; */
border-top-left-radius: 10px;
border-top-right-radius: 10px;
}
.lower-container{
height: 60%;
background: #CBFFFB ;
border-bottom-left-radius: 10px;
border-bottom-right-radius: 10px;
padding:20px;
padding-top:40px;
text-align: center;
}
.img-container img{
background: white;
width: 400px;
height: 270px;
border-top-left-radius: 10px;
border-top-right-radius: 10px;
}

.lower-container p,h3,h4{
box-sizing: border-box;
line-height: .6;
font-weight: lighter;

}
.lower-container h3{
color: #7F00FF;
opacity: .6;
font-weight: bold;
}
.lower-container p{
font-size: 18px;
color: grey;
margin-bottom: 20px;
}
.lower-container .btn{
padding: 12px 20px;
background: #7F00FF;
border: none;
color: white;
border-radius: 20px;
font-size: 12px;
text-decoration: none;
font-weight: bold;
transition: all .3s ease-in;
}

.lower-container .btn:hover{
background: transparent;
color: #7F00FF;
border: 2px solid #7F00FF;
}
.modal-header{
text-align: center;
}
.three-months{
text-align: center;
}
.six-months{
text-align: center;
}
.six-months h3,h5,h4{
box-sizing: border-box;
line-height: .6;
font-weight: lighter;
}
.six-months h3{
color: #7F00FF;
opacity: .6;
font-weight: bold;
}

</style>
</head>
<body>
<c:set var="c" value="${sessionScope.customer_details}" scope="session"></c:set>
<c:set var="s" value="${requestScope.trainer}" scope="request"></c:set>
<c:set var="ts" value="${requestScope.trainer.trainerSchedule}" scope="request"></c:set>

<div class="parent-div">
<div class="child-div">



<div class="card-container">
<div class="upper-container">
<div class="img-container">
  <img class="card-img-top" style="" src="../../../static/trainerImages/${s.photo}" alt="Card image cap">


</div>
</div>
<div class="lower-container">

  <div>
  <br>  <br>
  <h3>${s.trainerName}</h3>
<br>
<h4><i class="fas fa-star" style="color: yellow;" ></i>${s.rating}</h4>
<%-- <h4>${ts.days}</h4> --%>
<br>
    <p class="card-text">${s.description}</p>
  <br>  
  <a href="#" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Membership
  </a>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item"  data-toggle="modal" data-target="#myModal" href="#" >3 Months </a>
    <a class="dropdown-item"  data-toggle="modal" data-target="#myModal2" href="#" >6 Months</a>
    </div>
 

</div>
  <br>

</div>
<!-- <div class="col-lg-10">


</div>
 -->

</div>
</div>
 <!-- The Modal for 3 Months Package -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header" style="color: #74CDEC;">
          <h4 class="modal-title">3 Months Membership</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <div class="three-months" >
            <h4> <b>Schedule: </b> ${ts.days}</h4> <br>
       	 	<h5><b> Timing: </b>From ${requestScope.startTime} to ${requestScope.endTime}</h5> <br>
            <h4><b>Price:  </b>${s.priceForThreeMonth} INR (inclusive of taxes) </h4> <br>
            <form action="/enrollment/enroll" id="myForm" method="post"> 
  
  <input type="hidden" id="trainerId" name="trainerId" value="${s.trainerId}"/>
  <input type="hidden" id="custId" name="custId" value="${c.custId }"/>
  <input type="hidden" id="module" name="module" value="${c.interest}"/>
   <input type="hidden" id="memberShip" name="memberShip" value="<%=MemberShip.THREE_MOTNTHS %>"/>
<input type="hidden" id="price"  name="price" value="${s.priceForThreeMonth}"/>
  <input class="btn btn-warning" id="submit" style="border-radius: 20px;transition: all .3s ease-in;font-size: 12px;font-weight: bold;" type="submit" value="Enroll Now">
</form>
       		<%--   <a href="<spring:url value='/enrollment'/>" class="btn btn-warning" style="border-radius: 20px;transition: all .3s ease-in;font-size: 12px;font-weight: bold;" type="button" id="enroll">
   Enroll Now
  </a>   
 --%>
       		
        </div>
      </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
 
 
 <!-- The Modal for 6 Months Package -->
  <div class="modal fade" id="myModal2">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" style="color: #74CDEC;">6 Months Membership</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
                <div class="six-months">
               	<h4> <b>Schedule: </b> ${ts.days}</h4> <!-- <p>Sunday Off</p> --> <br>
       	 	<h5><b> Timing: </b>From ${requestScope.startTime} to ${requestScope.endTime}</h5> <br>
            <h4><b>Price:  </b>${s.priceForSixMonth} INR (inclusive of taxes) </h4> <br>
            
  <form action="/enrollment/enroll" id="myForm" method="post"> 
  
  <input type="hidden" id="trainerId" name="trainerId" value="${s.trainerId}"/>
  <input type="hidden" id="custId" name="custId" value="${c.custId }"/>
  <input type="hidden" id="module" name="module" value="${c.interest}"/>
   <input type="hidden" id="memberShip" name="memberShip" value="<%=MemberShip.SIX_MONTHS %>"/>
<input type="hidden" id="price"  name="price" value="${s.priceForSixMonth}"/>
  <input class="btn btn-warning" id="submit" style="border-radius: 20px;transition: all .3s ease-in;font-size: 12px;font-weight: bold;" type="submit" value="Enroll Now">
</form>

       		
        </div>
        </div>
        
 <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	<script type="text/javascript">
			$(document).ready(function() {
			var form = $('#myform');
			$('#submit').click(function(){
				$.ajax({
				url : form.attr("action"),
				type: 'post',
				data: $('#myform input').serialize(),
				success: function(data){
					console.log(data);
				}
				});
				
			});

			});
		</script>
</body>
</html>