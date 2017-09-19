<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
	<!-- <link href="/bootstrap.min.css" rel="stylesheet"> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
    <!-- <script src="/jquery-2.2.1.min.js"></script> -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	
 	<!--  <script src="/bootstrap.min.js"></script> -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
</head>
<body>
	<div class="container" style="margin:50px">
	<c:if test="${param.error ne null}">
		<div style="color: red">Invalid credentials.</div>
	</c:if> 
		
	<form action="/login" method="post" data-toggle="validator" role="form" class="well form-horizontal" id="login_form">
	
	<fieldset>
		<!-- Form Name -->
		<legend><center><h4><b>Turvo Logistics Login Form</b></h4></center></legend><br>
		
	<!-- Text input-->
	<div class="form-group">
		<label class="col-md-4 control-label" for="username" >UserName: </label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			<input type="text" class="form-control" id="username" name="username">
			</div>
 		</div>
 			<div class="help-block with-errors"></div>
	</div>
		
	<!-- Text input-->		
	<div class="form-group">
		<label class="col-md-4 control-label" for="password">Password:</label> 
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="password" class="form-control" id="pwd" name="password">
			</div>
		</div>
		<div class="help-block with-errors"></div>
	</div>
		 
	<!-- Button-->
	<div class="form-group">
		<label class="col-md-4 control-label"></label>  
    	<div class="input-group">
    		<div class="col-md-4 inputGroupContainer">
			<button type="submit" class="btn btn-success">Login <span class="glyphicon glyphicon-send"></span> </button>
			</div>
			
			<div class="col-md-4 inputGroupContainer pull-right" style="padding-left:90px">
			<button type="reset" class="btn btn-success" >Reset <span class="glyphicon glyphicon-refresh"></span> </button>
			</div>
		</div>
		
		<div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</div>
	</div>

	</fieldset>
	</form>
	</div> <!-- /Container -->
	
</body>
</html>