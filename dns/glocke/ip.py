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

f = open("ipdb.txt", "r")
fc = f.read().splitlines()
for ln in fc:
	ipl = ln.split(',')
	for ir in ipl:
		if ir:
			if ':' in ir:
				for ip in ipaddress.IPv6Network(unicode(ir)):
					#myfile.write(str(ip) + '\n')
					cmd = "nmap -6 -sP " + str(ip)
					output = run_command(cmd)
					parse_output(output)
			else:
				for ip in ipaddress.IPv4Network(unicode(ir)):
					#myfile.write(str(ip) + '\n')
					cmd = "nmap -sP " + str(ip)
					output = run_command(cmd)
					parse_output(output)
