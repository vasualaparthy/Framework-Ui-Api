@apiregression @U11212245EIS
Feature: UC 22 Device Protection

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

@device-protection
Scenario: TC1.1 initializes the protection change and gets the total number of subs and address info
Given url apiservice + '/v1/router/eis-device-protection/protection-change/init'
And def param = {"engagementId": "XXXX","agentId": "XXX","ban": "XXX","num_of_lines_with_protection": 2}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@device-protection
Scenario: TC1.2 validates the ptn against the list of subscribers for an account (BAN)
Given url apiservice + '/v1/router/eis-device-protection/protection-change/selected-device-info'
And def param = {"engagementId": "XXX","agentId": "XX","ban": "XX","ptn": "XX","value": "XX","smUser": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ptn = ptnId
And set param.value = valueId
And set param.smUser = smUserId
And request param
When method POST
Then status 201

@device-protection
Scenario: TC1.3 Commits the protection removal
Given url apiservice + '/v1/router/eis-device-protection/protection-change/remove-protection'
And def param = {  "engagementId": "XXX","agentId": "XXX","ban": "XXX","subscriptionId": "XX","removeServices": [ "TEPPLUS"]}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.subscriptionIdInput = subscriptionIdInput
And request param
When method POST
Then status 201