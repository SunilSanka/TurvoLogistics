<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<html>
<head>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
  
    <script type="text/javascript">
        $(document).ready(function() {
        $('#multiple-checkboxes').multiselect();
    });
   
    </script>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
	<div class="navbar-inner">
		<div class = "container">
		 <img src="<c:url value='logo.jpg'/>" />
			<ui class = "nav navbar-nav pull-right">
				<li><a href="index.html">Home</a></li>
    		    <li><a href="#">Update User</a></li>
                <li><a href="#">Delete User</a></li>
			</ui> 
		</div>
	</div>
</div>

<div class="container" style="padding:60px">

<form data-toggle="validator" role="form" class="well form-horizontal" action=" " method="post"  id="user_form" >

<fieldset>

<!-- Form Name -->
<legend><center><h2><b>User Registration Form</b></h2></center></legend><br>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="first_name">First Name</label>  
  <div class="col-md-4 inputGroupContainer">
	<div class="input-group">
		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		<input type="text" class="form-control" name="first_name" placeholder="First Name" required>
    </div>
  </div>
  <div class="help-block with-errors"></div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" for="last_name">Last Name</label> 
  <div class="col-md-4 inputGroupContainer">
	<div class="input-group">
		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		<input type="text" class="form-control" name="last_name" placeholder="Last Name" required>
    </div>
  </div>
 <div class="help-block with-errors"></div>
</div>

<!--
 <div class="form-group"> 
  <label class="col-md-4 control-label">Department / Office</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="department" class="form-control selectpicker">
      <option value="">Select your Department/Office</option>
      <option>Department of Engineering</option>
      <option>Department of Agriculture</option>
      <option >Accounting Office</option>
      <option >Tresurer's Office</option>
      <option >MPDC</option>
      <option >MCTC</option>
      <option >MCR</option>
      <option >Mayor's Office</option>
      <option >Tourism Office</option>
    </select>
  </div>
</div>
</div>   -->

<!-- Subscription Channels -->
<div class = "form-group">
	<label class="col-md-4 control-label">Notification Subscriptions</label>
	<div class="col-md-4 selectContainer">
		<div class="input-group">
		<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
			<select id="multiple-checkboxes" multiple="multiple">
				<option value="shipmentCreated">Shipment Created</option>
				<option value="shipmentPacked">Shipment Packed</option>
				<option value="shipmentShipped">Shipment Shipped</option>
				<option value="shipmentRunningLate">Shipment Running Late</option>
				<option value="shipmentDelivered">Shipment Delivered</option>
			</select>
        </div>
	</div>
</div>

<!-- Notification Subscription Check Box -->
 <div class="form-group"> 
   <label class="col-md-4 control-label">Notification Channels</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<div class="form-check form-check-inline">
	
			<!-- <label class="form-check-label"> </label> 
			<i class="material-icons" style="font-size:19px">public</i>-->
			<span class="glyphicon glyphicon-globe"></span>
			<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="web"> Web 
			&nbsp
	
			<!-- <i class="material-icons" style="font-size:19px">email</i> -->
			<span class="glyphicon glyphicon-envelope"></span>
			<input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="email"> Email
			&nbsp
		
			<!-- <i class="material-icons" style="font-size:19px">perm_phone_msg</i> -->
			<!-- <i class="material-icons" style="font-size:19px">textsms</i> -->
			<span class="glyphicon glyphicon-comment"></span>
			<input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="sms"> SMS
			&nbsp
		
			<!-- <i class="material-icons" style="font-size:19px">call</i> -->
			<span class="glyphicon glyphicon-earphone"></span>
			<input class="form-check-input" type="checkbox" id="inlineCheckbox4" value="call" disabled>Call
			&nbsp
		
			</div>
		</div>
	</div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="user_name">Username</label>  
  <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
          <input type="text" class="form-control" name="user_name" placeholder="Username" required>
    </div>
   </div>
   <div class="help-block with-errors"></div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" for="user_password">Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <input type="password" class="form-control" name="user_password" placeholder="Password" required>
    </div>
  </div>
 <div class="help-block">Minimum of 6 characters</div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" for="confirm_password" >Confirm Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
     <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
     <input type="password" class="form-control" name="confirm_password" data-match="#user_password" data-match-error="Whoops, these don't match" placeholder="Confirm Password"  required>
    </div>
  </div>
 <div class="help-block with-errors"></div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label"for="email">E-Mail</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
      <input type="email" class="form-control" name="email" placeholder="E-Mail Address" data-error="Bruh, that email address is invalid" required>
    </div>
  </div>
  <div class="help-block with-errors"></div>
</div>


<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-4 control-label" for="contact_no">Contact No.</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
        <input type="text" class="form-control"  name="contact_no" placeholder="(+91)" pattern="^[0-9]$" maxlength="15" >
    </div> 
  </div>
  <div class="help-block with-errors"></div>
</div>

<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-4 control-label" for="aadhar_no">Aadhar No.</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
        <input type="text" class="form-control"  name="aadhar_no" placeholder="Aadhar Number" pattern="^[0-9]$" maxlength="12" >
    </div> 
  </div>
  <div class="help-block with-errors"></div>
</div>

<!-- Select Basic -->

<!-- Success message
<div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.</div>
 -->
<!-- Button 
<div class="form-group">    
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4"><br>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit" class="btn btn-warning" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
  </div>
</div> -->
<!-- Button --> 
<div class="form-group">    
    <label class="col-md-4 control-label"></label>  
        <div class="input-group">
        <div class="col-md-4 inputGroupContainer">
            <button type="submit" class="btn btn-warning">Submit <span class="glyphicon glyphicon-send"></span></button>
         </div>
         <div class="col-md-4 inputGroupContainer pull-right" style="padding-left:52px">
            <button type="reset" class="btn btn-warning">Reset <span class="glyphicon glyphicon-refresh"></span></button>
        </div>
        </div>
</div> 
</fieldset>
</form>

    </div><!-- /.container -->
	
	</body>
</html>