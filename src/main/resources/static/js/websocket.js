
const ws = new WebSocket('ws://localhost:8080/crm');

ws.onmessage = function(data) {
    $("#content").html(JSON.parse(data.data).value);
}

ws.onerror = function(event) {
    console.log(event);
}

ws.onclose = function (event) {
    console.log('disconnected');
};

$(function() {
    $("#get").click(function() {
		ws.send(JSON.stringify({'value' : "getHTML"}));
	});
});