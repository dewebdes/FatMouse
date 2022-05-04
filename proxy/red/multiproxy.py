from mitmproxy import http
from mitmproxy.connection import Server
from mitmproxy.net.server_spec import ServerSpec
from mitmproxy import ctx

class multiproxy:

	def __init__(self):
		self.num = 0
		
	def request(self, flow) -> None:
		self.num = self.num + 1
		
		if self.num > 6:
			self.num = 0
			
		if self.num > 1:
			upserv = ""
			if self.num == 2:
				upserv = "78.47.48.181"
			if self.num == 3:
				upserv = "116.202.159.139"
			if self.num == 4:
				upserv = "176.9.151.236"
			if self.num == 5:
				upserv = "116.202.82.150"
			if self.num == 6:
				upserv = "116.202.82.187"
				
			#ctx.log.info("request to :> " + upserv)
			address = (upserv, 8080)
			flow.server_conn = Server(flow.server_conn.address)
			flow.server_conn.via = ServerSpec("http", address)
	    
addons = [multiproxy()]