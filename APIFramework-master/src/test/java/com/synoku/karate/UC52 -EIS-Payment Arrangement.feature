@apiregression
Feature: UC 52 EIS Payment Arrrangement

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

@eis-inquiry-service @test
Scenario: TC4.1 Remove-service device details
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/device-details'
And def param = { "engagementId": "XX", "agentId": "agent", "ban": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

