@apiregression @U11212245EIS
Feature: UC 45 EIS Inquiry Invoice

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


@eis-inquiry-Invoice 
Scenario: TC1.1 summary 
Given url apiservice + '/v1/router/eis-inquiry-invoice/billing/summary'
And def param = { "engagementId": "XX", "agentId": "agent", "ban": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.2 list
Given url apiservice + '/v1/router/eis-inquiry-invoice/billing/list'
And def param = {"engagementId": "LPDSA0486","agentId": "agent","ban": "103726754"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.3 plans
Given url apiservice + '/v1/router/eis-inquiry-invoice/billing/plans'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent", "ban": "466305101","START_DATE": "2019-01-01","END_DATE": "2019-12-31"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.4 method
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method'
And def param = { "engagementId": "LPDSA0486", "agentId": "agent", "ban": "100004761"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.5 emails Put
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method/emails'
And def param = { "engagementId": "LPDSA0486", "agentId": "agent", "ban": "100004761", "EMAIL": "abc@345.com", "selected_language_resp": "ENGLISH", "ptn": "5188478158"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method PUT
Then status 201


@eis-inquiry-Invoice 
Scenario: TC1.6 emails POST
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method/emails'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent", "ban": "100004761"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.7 texts
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method/texts'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent","ban": "100004761","ptn": "5188478158"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.8 ptns
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method/texts/ptns'
And def param = {"engagementId": "LPDSA0486","agentId": "agent","ban": "100004761"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.9 paper PUT
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method/paper'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent", "ban": "100004761", "selected_language_resp": "ENGLISH", "paper_bill_type": "detailed_bill","validated_address": {"line1": "6060 Sprint Pkwy","line2": "","city": "Overland Park","state": "KS","zipCode": "66211","streetName": "Sprint","houseNumber": "6060","streetSuffix": "Pkwy"}}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method PUT
Then status 201

@eis-inquiry-Invoice 
Scenario: TC1.10 paper POST
Given url apiservice + '/v1/router/eis-inquiry-invoice/delivery/method/paper'
And def param = {"engagementId": "LPDSA0486","agentId": "agent","ban": "100004761"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201
