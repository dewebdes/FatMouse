from http.server import BaseHTTPRequestHandler, HTTPServer
import time
from datetime import datetime
import ipaddress
from past.builtins import execfile
import re
import subprocess, sys
import threading
from threading import Thread
import shlex
import pymysql
import base64


execfile('db.py') #work with database

hostName = "0.0.0.0"
serverPort = 2222
whiteips = ['master-server-ip','trusted-ip-1','trusted-ip-N']
blacklist = []

def getnow():
	now = datetime.now()
	tk = now.strftime("%m/%d/%Y-%H:%M:%S")
	return tk

def blockip(ip):
    retcode = subprocess.call(["iptables","-I", "INPUT", "-s", ip, "-j", "DROP"])

class MyServer(BaseHTTPRequestHandler):
    def log_message(self, format, *args):
        return

    def do_GET(self):
        cip = (self.client_address[0])

        iswhite = False
        for w in whiteips:
            iswhite = ipaddress.IPv4Address(cip) in ipaddress.IPv4Network(w)
            if iswhite == True: break

        if iswhite == False:
            if cip not in blacklist:
                blacklist.append(cip)
                blockip(cip)
                dtime = getnow()
                qur = "INSERT INTO attacks (msg,remoteip,remoteport,flags,dtime) VALUES('" + cleandata1('honeypot') + "','" + cleandata1(cip) + "','" + cleandata1(serverPort) + "','','" + cleandata1(dtime) + "');"
                insqls.append(qur)
                print('block : ' + cip)
        else:
            tip = self.path.split('ip=')[1].split('&')[0]
            blockip(tip)
            print('block : ' + tip)

        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(bytes("<html><head><title>Admin Panel</title></head>", "utf-8"))
        self.wfile.write(bytes("<body>", "utf-8"))
        self.wfile.write(bytes("<p>Welcome, please wait...</p>", "utf-8"))
        self.wfile.write(bytes("</body></html>", "utf-8"))

if __name__ == "__main__":      
    Thread(target = inshand).start() #start db handler
    webServer = HTTPServer((hostName, serverPort), MyServer)
    print("Server started http://%s:%s" % (hostName, serverPort))

    try:
        webServer.serve_forever()
    except KeyboardInterrupt:
        pass

    webServer.server_close()
    print("Server stopped.")