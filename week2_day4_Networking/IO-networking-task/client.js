var net = require('net');
var readline = require('readline');

const HOST = '127.0.0.1';
const PORT = 8080;

var client = new net.Socket();

client.connect(PORT, HOST, function() {
    console.log('CONNECTED TO: ' + HOST + ':' + PORT);
});

client.on('data', function(data) { 
    console.log(String(data));
});

client.on('close', function() {
    console.log('Connection closed');
});

client.on('error', function() {
	console.log('Server terminated');
});

var reader = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  terminal: false
});

reader.on('line', function(line){
    client.write(line);
})