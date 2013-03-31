var webSocket;
$(document).on("ready", iniciar);

function iniciar() {
	webSocket = io.connect("http://localhost:8888");
	webSocket.on("nombreDesdeServidor", recibirMensaje);
	$("#formulario").on("submit", enviarMensaje);
}

function enviarMensaje() {
	webSocket.emit("nuevoNombre", $("#nombre").val());
	$("#nombre").fadeOut();
}

function recibirMensaje(datosServidor) {
	$("span").text("Acaba de entrar " + datosServidor);
}