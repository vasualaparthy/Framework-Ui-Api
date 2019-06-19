@apiregression @U34EISResume
Feature: UC 34 EIS Resume Service

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

@eis-resume-services
Scenario: TC1.1 accountstatus
Given url apiservice + '/v1/router/eis/resume/services/accountstatus'
And def param = {"ban": "XX","engagementId": "XX","agentId": "XX"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-resume-services @test
Scenario: TC1.2 line selection
Given url apiservice + '/v1/router/eis/resume/services/line/selection'
And def param = {"ban":"169728469","subscriberId":"99308616121","ptn":"5405228608","engagementId":"234567","agentId":"2345"}
#And set param.ban = banId
#And set param.subscriptionId = subscriptionIdInput
#And set param.ptn = ptnId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.smUser = smUserId
And request param
When method POST
Then status 201

@eis-resume-services
Scenario: TC1.3 service/selection
Given url apiservice + '/v1/router/eis/resume/services/service/selection'
And def param = {"ban": "XX", "engagementId": "XX", "agentId": "agent"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-resume-services
Scenario: TC1.4 subscriptions list
Given url apiservice + '/v1/router/eis/resume/services/subscriptions/list'
And def param = {"ban": "XX", "engagementId": "XX", "agentId": "agent"}
And set param.ban = banId
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And request param
When method POST
Then status 201

@eis-resume-services @test
Scenario: TC1.5 service
Given url apiservice + '/v1/router/eis/resume/services/restore/service'
And def param = {"ban":"104004441","engagementId":"234567","agentId":"2345","subscriberId":"87021222121","ptn":"2198104193","smUser":"TWREG-39208"}
#And set param.ban = banId
#And set param.subscriptionId = subscriptionIdInput
#And set param.ptn = ptnId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.smUser = smUserId
And request param
When method POST
Then status 201
