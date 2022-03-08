import ipaddress
import subprocess

def run_command(command):
	cmd = command.split()
	p = subprocess.Popen(cmd,stdout=subprocess.PIPE,stderr=subprocess.STDOUT)
	return iter(p.stdout.readline, b'')
	
def parse_output(outp):
	host = ''
	isup = False
	for line in outp:
		if 'Nmap scan report for ' in str(line):
			host = str(line).split('Nmap scan report for ')[1]
		if '1 host up' in str(line):
			isup = True
		#print(line)
	if isup:
		print(host)
		myfile = open("uphosts.txt","a")
		myfile.write(str(ip) + '\n')
		myfile.close()
		myfile = open("banners.txt","a")
		myfile.write(str(host) + '\n')
		myfile.close()

f = open("ipdb.txt", "r")
fc = f.read().splitlines()
f.close()
f = open("uphosts.txt", "r")
hlines = f.read().splitlines()
doscan = True
lasthost = ''
if len(hlines) > 0:
	lasthost = hlines[len(hlines) - 1]
	doscan = False
f.close()
	  
for ln in fc:
	ipl = ln.split(',')
	for ir in ipl:
		if ir:
			if ':' in ir:
				for ip in ipaddress.IPv6Network(unicode(ir)):
					if doscan:
						cmd = "nmap -6 -sP " + str(ip)
						output = run_command(cmd)
						parse_output(output)
					else:
						if str(ip) == lasthost:
							doscan = True
			else:
				for ip in ipaddress.IPv4Network(unicode(ir)):
					if doscan:
						cmd = "nmap -sP " + str(ip)
						output = run_command(cmd)
						parse_output(output)
					else:
						if str(ip) == lasthost:
							doscan = True

