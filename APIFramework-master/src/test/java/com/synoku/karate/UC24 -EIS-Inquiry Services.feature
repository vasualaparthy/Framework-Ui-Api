@apiregression @U24EISInquiry
Feature: UC 24 EIS Inquiry Service

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

@eis-inquiry-service
Scenario: TC1.1 device details
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/device-details'
And def param = { "engagementId": "XX", "agentId": "agent", "ban": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-inquiry-service
Scenario: TC1.2 service details
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/device-details'
And def param = { "engagementId": "XX", "agentId": "agent", "ban": "XX","subscriptionId": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-service
Scenario: TC1.3 service list
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/service-list'
And def param = { "engagementId": "XX", "agentId": "agent", "ban": "XX","subscriptionId": "XX","smUser": "smUser","PTN": "1234567890","DEVICE_MODEL": "Galaxy"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.subscriptionId = subscriptionIdInput
And set param.ptn = ptnId
And request param
When method POST
Then status 201

@eis-inquiry-service @test
Scenario: TC1.4 verification
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/verification'
And def param = {"agentId":"43","engagementId":"9098778374261726386","ban":"113978083","smUser":"BanU110623","PTN":"3473850542","subscriptionId":"52468276121","DEVICE_MODEL":"LGV30+","serviceList":[{"service":"TotalEquipmentProtection-TEPMAX","cost":13,"value":"TEPMAX","soc":"TEPMAX"},{"service":"PremiumInternationalExperience","cost":0,"value":"PDSIPIE","soc":"PDSIPIE"},{"service":"","cost":7.99,"value":"ASLCHGBAN","soc":"ASLCHGBAN"}],"current_index":0}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.smUser = smUserId
#And set param.ptn = ptnId
#And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-service @test
Scenario: TC1.5 commit
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/commit'
And def param = {"engagementId":"LPDSA0486","agentId":"agent","ban":"113978083","subscriptionId":"52468276121","soc":"TEPMAX","TIED_SOC_SKUS":["TEPMAX"],"newlySelectedServices":[]}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-service
Scenario: TC1.6 change
Given url apiservice + '/v1/router/eis-inquiry-services/remove-service/change'
And def param = {"agentId":"2345","engagementId":"9098778866765761486","ban":"113978083","smUser":"BanU110623","PTN":"3473850542","subscriptionId":"52468276121","DEVICE_MODEL":"LGV30+","form_alternate_service_dynamic_resp":"PDSL5090","service":"Hulu","serviceCost":23}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201