[
  {
    "ProfileName": "find-Tokens",
    "Name": "",
    "Enabled": true,
    "Scanner": 2,
    "Author": "@ayadi0x1",
    "Payloads": [],
    "Encoder": [],
    "UrlEncode": false,
    "CharsToUrlEncode": "",
    "Grep": [
      "true,,(([a-z0-9]+)(_|-){1,}){1,}((key|pass|credentials|auth|cred|creds|secret|password|access|token|passwd|db|api|admin|private|bash)(\\\\s|_|-){0,}){1,}(\u003d|:|is){0,}",
      "true,Or,(password|pwd|passwd|pass|key|secret|private|access|cred|creds|api|token)((_|-){0,})(\\\\s){0,}(key|pass|pwd|passwd|private|credentials|auth|cred|creds|secret|password|access|token)(\\\\s){0,}(\u003d|:|is){0,}",
      "true,Or,([a-z0-9]+)((_|-){0,}(\\\\s){0,})(key|pass|credentials|auth|cred|creds|secret|password|access|token|api)(\\\\s){0,}(\u003d|:|is){0,}",
      "true,Or,(password|pwd|passwd|pass|key|secret|private|access|cred|creds|api|token)(\\\\s){0,}(\u003d|:|is){0,}"
    ],
    "Tags": [
      "token",
      "API",
      "regex",
      "InformationDisclosure",
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
    "ExcludeHTTP": true,
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
    "RedirType": 0,
    "MaxRedir": 0,
    "payloadPosition": 0,
    "payloadsFile": "",
    "grepsFile": "",
    "IssueName": "Token Founded",
    "IssueSeverity": "Medium",
    "IssueConfidence": "Firm",
    "IssueDetail": "api key - secrets - leaks founded ",
    "RemediationDetail": "",
    "IssueBackground": "",
    "RemediationBackground": "",
    "Header": [],
    "VariationAttributes": [],
    "InsertionPointType": [],
    "Scanas": false,
    "Scantype": 0,
    "pathDiscovery": false
  }
]
