var fs = require('fs');
var exec = require('child_process').exec;

var hosts = new Array();
var scancommands = new Array();
var cmdindx = 0;
var hostindx = 0;
var scancmdindx = 0;
var lasthost = "";

function getconfig(){
	fs.readFile("commands.txt", 'utf8', function(err, data) {
			scancommands = data.split("\n");
			fs.readFile("hosts.txt", 'utf8', function(err, data) {
				hosts = data.split("\n");
				cmdindx = 0;
				hostindx = 0;
				scancmdindx = 0;
				startscan();
			});
	});
}

function startscan(){
	if(hostindx < hosts.length-1){
		var thost = hosts[hostindx].trim();
		if(thost.length > 0){
			cmdindx = 0;
			lasthost = thost;
			scanhost();
		}else{
			hostindx++;
			startscan();
		}
	}else{
		console.log('finish ...');
	}
}

function runcommandhost(cmd,host){
	console.log("Discover - "+host);
	var child;
	child = exec(cmd,
			function (error, stdout, stderr) {
				var dlog = 'stdout: ' + stdout + "\n";
				dlog += 'stderr: ' + stderr + "\n";
				if (error !== null) {
					dlog += 'exec error: ' + error + "\n";
				}
				cmdindx++;
				scanhost();
			});
}

function scanhost(){
	if(cmdindx <= scancommands.length-1){
		var command = scancommands[cmdindx].trim();
		if(command.length > 0){
			command = command.replace("host",lasthost);
			runcommandhost(command,lasthost);
		}else{
			cmdindx++;
			scanhost();
		}
	}else{
		cmdindx = 0;
		hostindx++;
		startscan();
	}
}

getconfig();


