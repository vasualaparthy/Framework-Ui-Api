@apiregression @U42EIDevice
Feature: UC 42 EIS Device Insurance

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

@eis-Device-insurance 
Scenario: TC1.1 account info
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/broken-device/account-info'
And def param = { "ban": "100004761",  "engagementId": "9098778866765761486",  "agentId": "2345"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.2 account info dynamic form
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/broken-device/account-info-dynamic-form'
And def param = { "ban": "100004761", "engagementId": "9098778866765761486", "agentId": "2345"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.3 device info
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/broken-device/device-info'
And def param = { "agentId": "2345", "engagementId": "9098778866765761486", "ban": "100004761", "value": "21718689121","ptn": "5188478158"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.4 applecare plus inquiry
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/applecare-inquiry/applecare-plus-inquiry'
And def param = { "ban": "100004761", "engagementId": "9098778866765761486", "agentId": "2345"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.5 init
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/add-device-protection/init'
And def param = {"ban": "100004761","engagementId": "9098778866765761486", "agentId": "2345"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.6 init dynamic form
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/add-device-protection/init-dynamic-form'
And def param = {"ban": "100004761", "engagementId": "9098778866765761486","agentId": "2345"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.7 current device details
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/add-device-protection/current-device-details'
And def param = {"agentId":"39","engagementId":"9098780237303402250","ban":"511235603","smUser":"511235603_St2","userId":"st6344430815","dfDeviceDetails":"","current_index":0,"value":"13047410221","esn":"089392871304412418","ptn":"9135584984"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.8 check device type
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/add-device-protection/check-device-type'
And def param = {"agentId":"43","engagementId":"9098780234858051344","ban":"160874593","smUser":"TWREG-38877","value":"53777455021","esn":"089394944901146919","ptn":"7202537350"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-Device-insurance 
Scenario: TC1.9 subscriber submit order
Given url apiservice + '/v1/router/eis-device-insurance/device-protection-request/add-device-protection/subscriber-submit-order'
And def param = {"agentId":"43","engagementId":"9098780234858051344","ban":"160874593","smUser":"TWREG-38877","protection":"TEPPLUSWITHACS","value":"53777455021"}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

