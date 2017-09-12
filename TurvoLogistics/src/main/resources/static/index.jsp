<!DOCTYPE html>
<html>
<head>
    <title>Turvo Logistics</title>
   	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="app.js"></script>
	<style>
	#error { 
		color:red;
	}
	</style>
	
</head>
<body>
<noscript><h2 style="color: #ff0000">
Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable  Javascript and reload this page!
	</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
	<div class="col-md-12">
            <form class="form-inline">
                <div class="form-group">
				<u><H4>Turvo Logistics - static - .html</h4></u>
               </div>
            </form>
        </div>  
	</div>
    <div class="row">		
	 <div class="col-md-4">
	
            <form class="form-inline">
                <div class="form-group">
                    <label for="userId">Enter User Id :</label>
                    <input type="text" name="UserId"  id="userId" class="form-control" placeholder="Your user id here..."  onkeyup="verifyUserId()" required></input>
				</div>
				<div id= "error"></div>
            </form>
			
        </div>
        <div class="col-md-4" >
            <form class="form-inline">
                <div class="form-group">
               </div>
            </form>
        </div>
		<div class="col-md-4" >
            <form class="form-inline">
           
                <div class="form-group">
				     <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect</button>
                </div>
              
                <div id= "connStatus">Disconnected</div>
            </form>
        </div>
     
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Notifications  <button id="clear" class="btn btn-default" type="clear" disabled="disabled">Clear</button></th>
                </tr>
                </thead>
                <tbody id="notifications">
                </tbody>
            </table>
        </div>
		  <div class="col-md-4">
            <form class="form">
				
                <div class="form-group">
				</div>
            </form>
        </div>
    </div>
   
</div>
 
</body>
</html>