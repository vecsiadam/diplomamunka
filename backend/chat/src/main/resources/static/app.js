var stompClient = null;


// Get rooms and put in single select
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8082/chat/rooms"
    }).then(function(data) {
    	for(a of data){
    		$("#rooms").append("<option value="+a.roomId+">" + a.roomName + "</option>")
    	}
    });
});

// Get neptun code
var senderUser={};
function getNeptunCode() {
	var neptun = $("#neptun").val();
	$.ajax({
	        url: "http://localhost:8082/chat/user-by-neptun?neptun=" + neptun
	    }).then(function(data) {
	    	senderUser = data;
	    });
	console.log(senderUser)
}

// Get room code
var room={};
function getRoom() {
	var roomId = $("#rooms").val();
	 $.ajax({
	        url: "http://localhost:8082/chat/room?roomId=" + roomId
	    }).then(function(data) {
	    	room = data;
	    });
	console.log(room)
}

// send message
function sendMessage() {
	$.ajax({
	    contentType: 'application/json',
	    data: JSON.stringify({ "message": $("#message").val(), room, senderUser }),
	    dataType: 'json',
	    type: 'POST',
	    url: "http://localhost:8082/kafka/message?roomId=" + room.roomId
	}).then(function(data) {
		console.log(data)
    });	
}

//connect to the socket
$(document).ready(function connect() {
	var socket = new SockJS('/chat-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/greetings', function(message) {
			showMessages(JSON.parse(message.body));
		});		
	});
});

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#message").html("");
}

function showMessages(message) {
	console.log(message)
	$("#messages").append("<tr><td>" + message.dateTime +": "+message.senderUser.name + ": "+ message.message + "</td></tr>");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});

	$("#send").click(function() {
		sendMessage();
	});
	
	$("#neptunButton").click(function() {
		getNeptunCode();
	});
	
	$("#roomButton").click(function() {
		getRoom();
	});
});