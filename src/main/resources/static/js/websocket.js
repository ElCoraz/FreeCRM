
const ws = new WebSocket('ws://localhost:8080/crm');

ws.onmessage = function(data) {
    $("#message").html(JSON.parse(data.data).value);
}

ws.onclose = function (event) {
    console.log('disconnected');
};

$(function() {
    $("#get").click(function() {
		ws.send(JSON.stringify({'value' : "getHTML"}));
	});
});