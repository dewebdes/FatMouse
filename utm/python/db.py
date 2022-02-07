conn = pymysql.connect(
    db='trabase',
    user='db-user',
    passwd='db-password',
    host='localhost')
gcu = conn.cursor()
insqls = [] #insert queries array
sqidx = 0 #active query index

#remove sql injections
def cleandata1(d):
	d2 = str(d)
	d2 = d2.replace(",", "")
	d2 = d2.replace(";", "")
	d2 = d2.replace("-", "")
	d2 = d2.replace("'", "")
	d2 = d2.replace("\"", "")
	return d2

#replace sql injections
def cleandata2(d):
	d2 = str(d)
	d2 = d2.replace(",", "#vi")
	d2 = d2.replace(";", "#se")
	d2 = d2.replace("-", "#ds")
	d2 = d2.replace("'", "#sq")
	d2 = d2.replace("\"", "#dq")
	return d2

def inshand():
	global conn
	global gcu
	global sqidx
	global insqls
	while True:
		if (sqidx < len(insqls)):
			gcu = conn.cursor()
			try:
				gcu.execute(insqls[sqidx])
				sqidx = sqidx + 1
				conn.commit()
				gcu.close()
			except conn.Error as err:
				print('insert-ERROR :: ' + str(sqidx) + " - " + insqls[sqidx])
		time.sleep(1)
