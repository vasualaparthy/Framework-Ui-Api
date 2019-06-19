@apiregression @U11212245EIS
Feature: UC 21 EIS Add Service

Background:
Given header applicationId = '2IE'
And header applicationUserId = '2IE'
And header Content-Type = 'application/json'
And header enterpriseMessageId = '2IE-746291747989833708'
And header messageDateTimeStamp = '2007-10-01T14:20:33'
And header messageId = '746291747989833708'
And header consumerId = 'APPCHAT'
And header Authorization = 'Basic bHZvc3Q6c3ByaW50'
And header locale = 'en_us'

@eis-add-service 
Scenario: TC1.1 Service Add on Init Details
Given url apiservice + '/v1/router/eis-add-services/service-add-on/service-add-on-init-details'
And def param = {"engagementId": "{{engagementId}}",agentId": "{{agentId}}","ban": "{{BAN}}","smUser": "BlueStarqxq168","requested_add_on_service": "Hulu"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201
And match response contains {"selected_service": "Hulu"}

@eis-add-service 
Scenario: TC1.2 Alternative Service Details
Given url apiservice + '/v1/router/eis-add-services/service-add-on/alternative-service-details'
And def param = {"engagementId":"9098778866765761486","agentId":"2345","ban":"100004761","smUser":"TWREG-43028","serviceName":"Hulu","value":"HULUVOD01","num_of_alternate_services":2,"categoryCode":"srvc1018000cat"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-add-service
Scenario: TC1.3 Current Device Details
Given url apiservice + '/v1/router/eis-add-services/service-add-on/current-device-details'
And def param = {"engagementId": "{{engagementId}}","agentId": "{{agentId}}","ban": "{{BAN}}","smUser": "BlueStarqxq168","add_present_or_alternate_service": "alternate","value": "PDSTIDTRI","serviceSOCSKU": "PRIMEATCH","current_index": 0,"currentDeviceList": [{"deviceModel": "iPhone 7 32GB","deviceNickname": "WEB TEST ACCOUNT RTB1 WEB TEST ACCOUNT","ptn": "{{PTN}}","subscriberId": "{{subscriberId}}", "value": 1}]}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ptn = ptnId
And set param.subscriptionId = subscriptionIdPtnInput
And request param
When method POST
Then status 201

@eis-add-service
Scenario: TC1.4 Service Commit Details
Given url apiservice + '/v1/router/eis-add-services/service-add-on/service-commit-details'
And def param = { "engagementId": "9098778866765761486", "agentId": "2345", "ban": "113978083", "smUser": "BanU110623", "subscriberId": "52468276121", "removedServices": [], "addedServices": ["HULUVOD01"]}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.ptn = ptnId
#And set param.subscriptionId = subscriptionIdPtnInput
And request param
When method POST
Then status 201

@eis-add-service
Scenario: TC1.5 Alternate Service Details
Given url apiservice + '/v1/router/eis-add-services/service-add-on/alternative-service-list'
And def param = { "engagementId": "LPDSA0486", "agentId": "agent", "ban": "{{BAN}}", "smUser": "BlueStarqxq168", "categoryCode": "srvc1018000cat" }
And set param.ban = banId
And request param
When method POST
Then status 201

@eis-add-service
Scenario: TC1.6 Display Device List
Given url apiservice + '/v1/router/eis-add-services/service-add-on/display-device-list'
And def param = { "engagementId": "{{engagementId}}", "agentId": "{{agentId}}", "ban": "{{BAN}}", "smUser": "{{smUser}}", "add_present_or_alternate_service": "alternate", "value": "PDSTIDTRI", "serviceSOCSKU": "PRIMEATCH" }
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.smUser = smUserId
And request param
When method POST
Then status 201

@eis-add-service
Scenario: TC1.7 Service List
Given url apiservice + '/v1/router/eis-add-services/service-add-on/service-list'
And def param = { "engagementId": "LPDSA0486", "agentId": "agent", "ban": "{{BAN}}", "smUser": "Blotterqxq91", "serviceList": [ "PDSTIDTRA" ] }
And set param.ban = banId
And request param
When method POST
Then status 201

@eis-add-service
Scenario: /v1/router/eis-add-services/service-add-on/service-data
Given url apiservice + '/v1/router/eis-add-services/service-add-on/service-data'
And def param = { "engagementId": "LPDSA0486", "agentId": "agent", "ban": "{{BAN}}", "smUser": "Blotterqxq91", "value": "PDSTIDTRA", "serviceList": [ "PDSTIDTRA" ] }
And set param.ban = banId
And request param
When method POST
Then status 201

@eis-add-service
Scenario: /v1/router/eis-add-services/service-add-on/current-service-init
Given url apiservice + '/v1/router/eis-add-services/service-add-on/current-service-init'
And def param = {"engagementId":"LPDSA0486","agentId":"agent","ban":"140009533","smUser":"TWREG-39019","form_select_service_resp":"hulu"}
#And set param.ban = banId
And request param
When method POST
Then status 201