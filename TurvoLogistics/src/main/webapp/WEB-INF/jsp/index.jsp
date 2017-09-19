<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Turvo Logistics</title>
	 <meta charset="utf-8">
 	 <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- <link href="/bootstrap.min.css" rel="stylesheet"> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<scrpit src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></scrpit>

	<style>
		body { padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar*/
		}
		
	</style>
	
	<!-- <script src="/jquery-2.2.1.min.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!--  <script src="/bootstrap.min.js"></script> -->
	<scrpit src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></scrpit>
	
    
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
	<div class="navbar-inner">
		<div class = "container">
		 <img src="<c:url value='logo.jpg'/>" /> 
		<!-- <img src="logo.jpg" /> -->
			<ui class = "nav navbar-nav pull-right">
				<li class="active"><a href="#">Home</a></li>
    		    <li><a href="registerUser.html">Add User</a></li>
    		    <li><a href="#">Update User</a></li>
                <li><a href="#">Delete User</a></li>
				<li><a href="subscribe.html">Subscribe</a></li>
				<li><a href="/logout">Logout</a></li>
			</ui> 
		</div>
	</div>
</div>
	
<div class = "container">
<!--	<div class="hero-unit"> -->
		<div>
			<h1> Welcome to Turvo Logistics !</h1>
		</div>
		<!--
		<a class="btn btn-primary" hred=""> Add User </a>
		<a class="btn btn-primary" hred=""> Add User </a>
		<a class="btn btn-primary" hred=""> Add User </a>
		</br></br> -->
		</br>
		<div class="panel-group"> 
			<!-- First panel -->
			<div class="panel panel-default">
				<div class="panel panel-body">
					<div class = "row"> <!-- row 1 --> 
						<div class="col-md-6" style="padding-top:70px">
						<p><h3><b>Bring Order To Chaos</b></h3>
						Logistics is broken.  
						Too many people using pen and paper, spreadsheets, and old software. 
						Too many back and forth phone calls and redundant manual tasks. 
						Too many siloes, creating too much complexity. Ultimately, too much time and money wasted.</p>
						</div>
						<div class="col-md-6">
						
						<!--  <img src="orderToChaos.jpg" /> -->
						<img src="<c:url value='orderToChaos.jpg'/>" />
						
						</div>
					</div> <!-- /row -->
					
					<div class = "row"> <!-- row 2 --> 

						<div class="col-md-6">
							<!-- <img src="whatIsTurvo.jpg"/> -->
							<img src="<c:url value='whatIsTurvo.jpg' />" />
						</div>

						<div class="col-md-6" style="padding-top:70px">
						<p><h3><b>See Everything In One Place</b></h3>
						Turvo is the only real-time collaborative logistics platform that connects anyone, 
						anywhere to move things. Turvo creates a smarter way for shippers, brokers, 
						and carriers to seamlessly work together to get things done faster.</p>
						</div>
					</div> <!-- /row -->
					
					<div class = "row"> <!-- row 3--> 
						<div class="col-md-12">
							<!-- <img src="oneCollaborativeCloud.jpg" width="1100px"/> -->
							<img scr= "<c:url value='oneCollaborativeCloud.jpg'/>"  width="1100px"/>
						</div>
					</div> <!-- /row 3 -->

					<div class="row"> <!-- row 4 -->
						<div class = "col-md-6">
							<!-- <img src="seeEverything.jpg"/>  -->
							<img scr= "<c:url value='seeEverything.jpg'/>" />
						</div>
						<div class = "col-md-6" style="padding-top:130px">
							
							<p><h3><b>See Everything In One Place</b></h3>
							<b>Bring it all together.</b>See your business at a glance with a personalized dashboard 
							and powerful visualizations to make smarter, faster decisions. </p>
							
							<p><b>No more hide & seek.</b>See your business at a glance with a personalized dashboard 
							and powerful visualizations to make smarter, faster decisions. </p>					
							
							<p><b>From chaos to clarity.</b>See your business at a glance with a personalized dashboard 
							and powerful visualizations to make smarter, faster decisions. </p>
						</div>
					</div>
					<div class="row"> <!-- row 5 -->
						<div class = "col-md-6" style="padding-top:80px;padding-left:50px">

							<p><h3><b>Collaborate With Anyone, Anywhere</b></h3>
							<b>No more phone tag.</b>See your business at a glance with a personalized dashboard 
							and powerful visualizations to make smarter, faster decisions. </p>
							
							<p><b>Less email, more productivity.</b>See your business at a glance with a personalized dashboard 
							and powerful visualizations to make smarter, faster decisions. </p>					
							
							<p><b>Real-time presence.</b>See your business at a glance with a personalized dashboard 
							and powerful visualizations to make smarter, faster decisions. </p>

						</div>
						<div class = "col-md-6" style="padding-top:40px;padding-left:50px">
							<!-- <img src="collaborate.jpg"/> -->
							<img src = "<c:url value='collaborate.jpg' />" />
						</div>
					</div>

						<div class="row"> <!-- row 6 -->
						<div class = "col-md-6" style="padding-top:50px">
							<!-- <img src="workSmart.jpg"/> -->
							<img src = "<c:url value='workSmart.jpg' />" />
						</div>
						<div class = "col-md-6" style="padding-top:100px">
							
							<p><h3><b>Work Smarter, Not Harder</b></h3>
							<b>Less digging, more results.</b>Search across all your data and instantly find what 
							you are looking for with inline previews and quick actions. </p>
							
							<p><b>Always be in the know.</b>Smart notifications keep you updated whether a 
							shipment is running late, a task is due, or you missed an important message. </p>					
							
							<p><b>Turn data into insights.</b>Turvo's AI-powered recommendations for rate optimization, 
							carrier matching, and order management, mean data-driven decisions, instead of guesswork. </p>

						</div>
					</div>


					</div>
				</div>

			</div> <!-- /first panel -->
		</div>  <!-- /pannel group -->
	
<!-- </div> --> <!-- /hero-unit-->
  </div>
</body>
</html>