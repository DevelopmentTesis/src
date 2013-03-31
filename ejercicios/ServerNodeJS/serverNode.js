var testServer = require("socket.io").listen(8888);

testServer.sockets.on("connection", arranque);

function arranque(usuario){
		usuario.on("nuevoNombre", emitir);
	  		 }

function emitir(data){	
	testServer.sockets.emit("nombreDesdeServidor", data);
		     }

