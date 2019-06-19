@apiregression @U36EIRoam
Feature: UC 36 EIS Roaming Inquiry

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

@eis-Roaming-inquiry
Scenario: TC1.1 line list
Given url apiservice + '/v1/router/eis-roaming-inquiry/subscriber/line-list'
And def param = {"engagementId": "XX", "agentId": "agent", "ban": "XX"}
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ban = banId
And request param
When method POST
Then status 201

@eis-Roaming-inquiry
Scenario: TC1.2 line details
Given url apiservice + '/v1/router/eis-roaming-inquiry/subscriber/line-details'
And def param = {"engagementId": "9098778866765761486","agentId": "2345","ban": "XX","current_index": 0,"roamingServiceDevList": [{"PTN": "XX8","DEVICE_MODEL": "iPhone 7 32GB", "DEVICE_NICKNAME": "WEB TEST ACCOUNT RTB1 WEB TEST ACCOUNT","value": "21718689121","subscriptionId": "21718689121","equipmentId": "089157402501210147"}]}}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-Roaming-inquiry
Scenario: TC1.3 roaming details
Given url apiservice + '/v1/router/eis-roaming-inquiry/subscriber/roaming-details'
And def param = {"engagementId":"LPDSA0486","agentId":"agent","ban":"119451476","subscriptionId":"35492386121","equipmentId":"268435457810103872","more_lines_selected":true,"DEVICE_MODEL":"Galaxy","PTN":"5554443332","roamingServiceDevList":[{"PTN":"3163041849","DEVICE_MODEL":"iPhone732GB","DEVICE_NICKNAME":"WEBTESTACCOUNTRTB1WEBTESTACCOUNT","value":"03953248121","subscriptionId":"03953248121","equipmentId":"089595264800169588"},{"PTN":"3035206991","DEVICE_MODEL":"iPhone732GB","DEVICE_NICKNAME":"WEBTESTACCOUNTRTB1WEBTESTACCOUNT","value":"37314248121","subscriptionId":"37314248121","equipmentId":"089872026305792259"}],"current_index":0}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-Roaming-inquiry
Scenario: TC1.4 roaming commit
Given url apiservice + '/v1/router/eis-roaming-inquiry/subscriber/roaming-commit'
And def param = {"agentId":"43","engagementId":"9098778510761381511","ban":"972690893","smUser":"Blotterqxq115","subscriptionId":"13448386121","has_global_roaming":false,"is_disableir":true,"is_japan":false,"is_cruise":false,"has_premium_intl":false,"is_eligible_for_premium_intl":true,"soc_sku_list":["PREMRES03","DISABLEIR"]}
#And set param.ban = banId
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201