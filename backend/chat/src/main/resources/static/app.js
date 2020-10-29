var stompClient = null;


// Get rooms and put in single select
$(document).ready(function() {
	$("#neptunButton").prop("disabled", true);
	$("#sendButton").prop("disabled", true);
	$("#disconnectButton").prop("disabled", true);
	$("#neptun").prop("disabled", true);
	$("#message").prop("disabled", true);
    $.ajax({
        url: "http://localhost:8082/chat/rooms"
    }).then(function(data) {
    	for(a of data){
    		$("#rooms").append("<option value="+a.roomId+">" + a.roomName + "</option>")
    	}
    });
});

// Get neptun code
var senderUser=null;
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
var room=null;
function getRoom() {
	var roomId = $("#rooms").val();
	 $.ajax({
	        url: "http://localhost:8082/chat/room?roomId=" + roomId
	    }).then(function(data) {
	    	room = data;
	    });
	console.log(room)
}

//Get last 15 messages by room id
function getLastMessages() {
	var roomId = $("#rooms").val();
	 $.ajax({
	        url: "http://localhost:8082/chat/search/last-5-messages?roomId=" + roomId
	    }).then(function(data) {
	    	for(a of data){
	    		showMessages(a)
	    	}
	    });
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
function connect() {
	var socket = new SockJS('/chat-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/chat/' + room.roomId, function(message) {
			showMessages(JSON.parse(message.body));
		});		
	});

}

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

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});

	$("#sendButton").click(function() {
		sendMessage();
		$("#message").val('');
	});
	
	$("#neptunButton").click(function() {
		getNeptunCode();
		$("#neptunButton").prop("disabled", true);
		$("#neptun").prop("disabled", true);
		$("#message").prop("disabled", false);
		$("#sendButton").prop("disabled", false);
	});
	
	$("#roomButton").click(function() {
		getRoom();
		getLastMessages();
		connect();
		$("#neptunButton").prop("disabled", false);
		$("#neptun").prop("disabled", false);
		$("#disconnectButton").prop("disabled", false);
		$("#roomButton").prop("disabled", true);
		$("#rooms").prop("disabled", true);

	});
	$("#disconnectButton").click(function() {
		$("#disconnectButton").prop("disabled", true);
		$("#roomButton").prop("disabled", false);
		$("#rooms").prop("disabled", false);
		$("#neptun").prop("disabled", true);
		$("#message").prop("disabled", true);
		$("#sendButton").prop("disabled", true);
		$("#neptunButton").prop("disabled", true);
		$("#message").val('');
		$("#messages").empty();
		disconnect();

	});
});