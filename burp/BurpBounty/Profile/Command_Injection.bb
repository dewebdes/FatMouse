[
  {
    "ProfileName": "Command_Injection",
    "Name": "",
    "Enabled": true,
    "Scanner": 1,
    "Author": "",
    "Payloads": [
      "true,print(\u0027sy3omda\u0027)",
      "true,;print(\u0027sy3omda\u0027)",
      "true,\u0027.print(\u0027sy3omda\u0027).\u0027",
      "true,\u003c?php print(\u0027sy3omda\u0027)?\u003e"
    ],
    "Encoder": [],
    "UrlEncode": false,
    "CharsToUrlEncode": "",
    "Grep": [
      "true,,*sy3omda*"
    ],
    "Tags": [
      "commandinjection",
      "All"
    ],
    "PayloadResponse": false,
    "NotResponse": false,
    "TimeOut1": "",
    "TimeOut2": "",
    "isTime": false,
    "contentLength": "",
    "iscontentLength": false,
    "CaseSensitive": false,
    "ExcludeHTTP": false,
    "OnlyHTTP": false,
    "IsContentType": false,
    "ContentType": "",
    "HttpResponseCode": "",
    "NegativeCT": false,
    "IsResponseCode": false,
    "ResponseCode": "",
    "NegativeRC": false,
    "urlextension": "",
    "isurlextension": false,
    "NegativeUrlExtension": false,
    "MatchType": 2,
    "Scope": 0,
    "RedirType": 4,
    "MaxRedir": 3,
    "payloadPosition": 1,
    "payloadsFile": "",
    "grepsFile": "",
    "IssueName": "Command Injection",
    "IssueSeverity": "High",
    "IssueConfidence": "Certain",
    "IssueDetail": "Command Injection payload: \u003cbr\u003e \u003cpayload\u003e",
    "RemediationDetail": "",
    "IssueBackground": "",
    "RemediationBackground": "",
    "Header": [],
    "VariationAttributes": [],
    "InsertionPointType": [
      65,
      32,
      2,
      35,
      34,
      0,
      37
    ],
    "Scanas": false,
    "Scantype": 0,
    "pathDiscovery": false
  }
]