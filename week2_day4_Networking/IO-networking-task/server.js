var net = require('net');

const PORT = 8080;

var clients = [];

net.createServer(function(sock) {	
	 clients.push(sock);
    console.log('CONNECTED: ' + sock.remoteAddress +':'+ sock.remotePort);
    
    sock.on('data', function(data) {     
		clients.forEach(function(client) {
			client.write(data);
		});
    });
    
    sock.on('close', function(data) {	  
        console.log('CLOSED: ' + sock.remoteAddress +' '+ sock.remotePort);
    });   
	
	sock.on('error', function(data) {	
		console.log(data);
		console.log('big no-no from ' + sock.remoteAddress + ':' + sock.remotePort);
	});
}).listen(PORT);

console.log('Server listening on port ' + PORT);