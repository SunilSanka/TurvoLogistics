
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    $("#notifications").html("");
}

function connect() {
    var socket = new SockJS('/turvo-logistics');
	var userId = $("#userId").val();
	
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        $("#connStatus").html("Connected Successfully !");
        $("#userId").prop("disabled", true);
        stompClient.subscribe('/topic/'+userId, function (notification) {
        	$("#clear").prop("disabled", false);
            showNotification(JSON.parse(JSON.stringify(notification)).body);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
        $("#connStatus").html("Disconnected");
       $("#userId").prop("disabled", false);
    }
    setConnected(false);
    console.log("Disconnected");
}

function clearMessages() {
$("#notifications").empty();
$("#clear").prop("disabled", true);
}

function showNotification(message) {
    $("#notifications").append("<tr><td>" + message + "</td></tr>");
}
function verifyUserId(){
if($("#userId").val() > 0){
$("#connect").prop("disabled", false);
}else{
$("#connect").prop("disabled", true);
}

}

$(document).ready(function () {
	  $("#userId").keypress(function (e) {
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        $("#error").html("Digits Only").show().fadeOut(3000);
	               return false;
	    }
       });
	
	});
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#clear" ).click(function() { clearMessages(); });
});