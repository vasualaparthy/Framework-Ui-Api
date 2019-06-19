@apiregression @U11EISInquiry 
Feature: UC 11 - EIC Inquiry Account

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
And def engagementId = 'LPDSA0486'
And def agentId = 'agent'
And def selectedSubscriber = '15706072021'

@eis-inquiry-account 
Scenario:TC1.1 device list
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/device-list'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent","ban": "XXX","smUser": "AOST1-719808797"}
And set param.ban = banId
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.2 plan details
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/plan-details'
And def param = {"agentId": "47","engagementId": "9098778356483894694","ban": "XXX","smUser": "Rainbowqxq196","datainquiryDeviceList": [{ "deviceModel": "iPhone664GB","deviceNickName": "WEBTESTACCOUNTRTB1WEBTESTACCOUNT","planName": "","status": "ACTIVE","ptn": "XXX","value": "XXX","subscriptionId": "XXX"}],"current_index": 0}
And set param.ban = banId
And set param.datainquiryDeviceList[0].ptn = ptnId
And set param.datainquiryDeviceList[0].value = valueId
And set param.datainquiryDeviceList[0].subscriptionId = subscriptionIdInput
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.3 data list
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/data-list'
And def param = {"engagementId": "XX", "agentId": "XX","ban": "XXX","ptn": "XXX","subscriptionId": "XXX","smUser": "XX"}
And set param.ban = banId
And set param.ptn = ptnId
And set param.subscriptionId = subscriptionIdInput
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.smUser = smUserId
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.4 purchase data
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/purchase-data'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent","ban": "196485315","ptn": "6125581162","categoryCode": "VAH", "deviceModel": "iPhone 6 64GB","deviceNickName": "WEB TEST ACCOUNT RTB1 WEB TEST ACCOUNT","subscriptionId": "29341786121","id": "1"}
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ban = banId
And set param.ptn = ptnId
And set param.subscriptionId = subscriptionIdPtnInput
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.5 Commit data
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/commit-data'
And def param = {"engagementId": "9098778867151375818","agentId": "2345","ban": "456080090","PTN": "6125581162","category_type": "VAH","id": "1","sharingGroupId": "3020414","budgetControlOfferId": "1258714","isSingleSubOnSharedPlan": false,"subscriptionId": "29341786121"}
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.6 data usage device list
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/data-usage-device-list'
And def param = {"engagementId": "XX", "agentId": "XX","ban": "XX","smUser": "XX"}
And set param.engagementId = engagementIdInput
And set param.agentId = agentIdInput
And set param.ban = banId
And set param.smUser = smUserId
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.7 data usage detailss
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/data-usage-details'
And def param = {"engagementId":"LPDSA0486","agentId":"agent","ban":"113978083","subscriptionId":"52468276121","no_of_active_lines":1,"ptn":"3473850542"}
#And set param.engagementId = engagementIdInput
#And set param.agentId = agentIdInput
#And set param.ban = banId
#And set param.subscriptionId = subscriptionIdInput
#And set param.ptn = ptnId
And request param
When method POST
Then status 201

@eis-inquiry-account
Scenario:TC1.8 device usage
Given url apiservice + '/v1/router/eis-inquiry-account/account/datainquiry/device-usage'
And def param = {"engagementId": "LPDSA0486", "agentId": "agent","ban": "196485315","selectedSubscriber": "15706072021","usage_form_resp": "data","number_of_lines_on_account": 1}
And set param.ban = banId
And set param.selectedSubscriber = valueId
And request param
When method POST
Then status 201
And match $.no_of_active_lines == 1
