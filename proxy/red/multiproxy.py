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
				upserv = "pxip2"
			if self.num == 3:
				upserv = "pxip3"
			if self.num == 4:
				upserv = "pxip4"
			if self.num == 5:
				upserv = "pxip5"
			if self.num == 6:
				upserv = "pxip6"
				
			#ctx.log.info("request to :> " + upserv)
			address = (upserv, 8080)
			flow.server_conn = Server(flow.server_conn.address)
			flow.server_conn.via = ServerSpec("http", address)
	    
addons = [multiproxy()]
