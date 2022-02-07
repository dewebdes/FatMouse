whiteips = ['server-ip-1','trusted-ip-1','trusted-vpn-ip-1','trusted-ip-range-1']
blacklist = []
honeypots = ['http://honeypot1-ip:2222/?ip=','honeypot-N']

with open('googlebot-ip-ranges.txt', 'r') as file:
	data = file.read()
	linesar = data.splitlines()
	for line in linesar:
		line2 = line.replace('\n','').replace('\r','').split()[0]
		whiteips.append(line2)

def blockip(dtime, ip, port, msg):
	iswhite = False
	if ip not in blacklist:
		for w in whiteips:
			iswhite = ipaddress.IPv4Address(ip) in ipaddress.IPv4Network(w)
			if iswhite == True: break
	else:
		iswhite = True
		
	if iswhite == False:
		retcode = subprocess.call(["iptables","-I", "INPUT", "-s", ip, "-j", "DROP"])
		blacklist.append(ip)

		#After run honeypots then uncomment these 2 lines
		#for h in honeypots:
			#requests.get(h + ip)
			
		qur = "INSERT INTO attacks (msg,remoteip,remoteport,flags,dtime) VALUES('" + cleandata1(msg) + "','" + cleandata1(ip) + "','" + cleandata1(port) + "','','" + cleandata1(dtime) + "');"
		insqls.append(qur)
		print('ATTACK; ' + dtime + ' ==> ' + ip + ' : ' + port + ' < ' + msg)

