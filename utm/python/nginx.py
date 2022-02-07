#!/usr/bin/python
import subprocess, sys
import socket, select
from io import StringIO
import time
from datetime import datetime
import shlex
import pymysql
import base64
import re
from watchdog.observers import Observer
from watchdog.events import PatternMatchingEventHandler
from past.builtins import execfile
import threading
from threading import Thread


execfile('netfilter.py') #work with iptables
execfile('db.py') #work with database

lineindx = 0 #last line index in nginx log

def on_modified(event):
	try:
		global lineindx
		i = 0
		linesar = []
		if event.src_path == '/var/log/nginx/firelog.log':
			with open(event.src_path, 'r') as file:
				data = file.read()
				linesar = data.splitlines()
				i = lineindx
				while i < len(linesar):
					line = linesar[i].replace('\n','').replace('\r','')
					tmpar = line.split(' #nnff# ')
					qur = "INSERT INTO nginx (time_local, remote_addr, request_method, request, request_length, status, bytes_sent, body_bytes_sent, http_referer, http_user_agent, upstream_addr, upstream_status, request_time, upstream_response_time, upstream_connect_time, upstream_header_time, request_body, flags) VALUES ('" + cleandata2(tmpar[0]) + "', '" + cleandata2(tmpar[1].split('=')[1]) + "', '" + cleandata2(tmpar[2].split('=')[1]) + "', '" + cleandata2(tmpar[3].split('=')[1]) + "', '" + cleandata2(tmpar[4].split('=')[1]) + "', '" + cleandata2(tmpar[5].split('=')[1]) + "', '" + cleandata2(tmpar[6].split('=')[1]) + "', '" + cleandata2(tmpar[7].split('=')[1]) + "', '" + cleandata2(tmpar[8].split('=')[1]) + "', '" + cleandata2(tmpar[9].split('=')[1]) + "', '" + cleandata2(tmpar[10].split('=')[1]) + "', '" + cleandata2(tmpar[11].split('=')[1]) + "', '" + cleandata2(tmpar[12].split('=')[1]) + "', '" + cleandata2(tmpar[13].split('=')[1]) + "', '" + cleandata2(tmpar[14].split('=')[1]) + "', '" + cleandata2(tmpar[15].split('=')[1]) + "', '" + cleandata2(tmpar[16].split('=')[1]) + "', '" + '' + "');"
					insqls.append(qur)

					i = i + 1
				
				lineindx = len(linesar)
	except:
		print('Error-Parse-Line ==> ')# + linesar[i])

if __name__ == '__main__':
	open("/var/log/nginx/firelog.log", "w").close() #clean nginx log file
	
	Thread(target = inshand).start() #start db handler

	#watchdog definitions for check alert_fast.txt snort log file
	patterns = "*"
	ignore_patterns = ""
	ignore_directories = False
	case_sensitive = True
	my_event_handler = PatternMatchingEventHandler(patterns, ignore_patterns, ignore_directories, case_sensitive)
	my_event_handler.on_modified = on_modified
	path = "/var/log/nginx"
	go_recursively = True
	my_observer = Observer()
	my_observer.schedule(my_event_handler, path, recursive=go_recursively)
	my_observer.start()
	try:
		while True:
			time.sleep(1)
	except KeyboardInterrupt:
		my_observer.stop()
		my_observer.join()
