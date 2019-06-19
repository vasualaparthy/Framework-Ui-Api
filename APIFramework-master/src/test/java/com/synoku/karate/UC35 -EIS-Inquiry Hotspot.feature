@apiregression @U35EISinquiry
Feature: UC 35 EIS Inquiry Hotspot

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

@eis-inquiry-hotspot
Scenario: TC1.1 add init details
Given url apiservice + '/v1/router/eis-inquiry-hotspot/hotspot/add-init-details'
And def param = {"engagementId": "XX", "agentId": "agent", "ban": "XX", "smUser": "smUser", "subscriptionId": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.smUser = smUserId
And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-hotspot
Scenario: TC1.2 remove init details
Given url apiservice + '/v1/router/eis-inquiry-hotspot/hotspot/remove-init-details'
And def param = {"agentId": "XX", "engagementId": "XX", "ban": "XX", "smUser": "smUser", "userId": "Blotterqxq91","ptn": "XX","subscriptionId": "XX","form_remove_hotspot_resp": "yes","form_hotspot_service_resp": "yes"}
And set param.agentId = agentIdInput
And set param.engagementId = engagementIdInput
And set param.ban = banId
And set param.smUser = smUserId
And set param.ptn = ptnId
And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-hotspot
Scenario: TC1.3 remove init commit
Given url apiservice + '/v1/router/eis-inquiry-hotspot/hotspot/remove-init-commit'
And def param = {"engagementId": "XX","agentId": "XX","ban": "XX","ptn": "XX","subscriptionId": "XX","soc": "PDPISE","smUser": "smUser"}
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ban = banId
And set param.ptn = ptnId
And set param.subscriptionId = subscriptionIdInput
And set param.smUser = smUserId
And request param
When method POST
Then status 201

@eis-inquiry-hotspot
Scenario: TC1.4 inquiry
Given url apiservice + '/v1/router/eis-inquiry-hotspot/hotspot/inquiry'
And def param = {"engagementId": "XX","agentId": "XX","ban": "XX","smUser": "smUser","subscriptionId": "XX",}
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ban = banId
And set param.smUser = smUserId
And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-hotspot
Scenario: TC1.5 usage details
Given url apiservice + '/v1/router/eis-inquiry-hotspot/hotspot/usage-details'
And def param = {"engagementId": "XX","agentId": "XX","ban": "XX","ptn": "XX","subscriptionId": "XX","smUser": "smUser"}
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ban = banId
And set param.ptn = ptnId
And set param.subscriptionId = subscriptionIdInput
And set param.smUser = smUserId
And request param
When method POST
Then status 201

