function() {   
  var env = karate.env; // get java system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev'; // a custom 'intelligent' default
  }
  var config = { // base config JSON
    appId: 'my.app.id',
    appSecret: 'my.secret',
    someUrlBase: 'https://some-host.com/v1/auth/',
    anotherUrlBase: 'https://another-host.com/v1/'
  };
  if (env == 'st1') {
	  		config.banId = "100004761"
			config.ptnId = "5188478158"
			config.valueId = "00792839021"
			config.subscriptionIdInput = "00792839021"
			config.engagementIdInput = "234567"
			config.agentIdInput = "2345"
			config.smUserId = "AOST1-665428377"
			config.subscriptionIdPtnInput = "65836386121"
			config.apiservice = 'https://st1-apiservices-web.test.sprint.com:7441/api/digital/aiva';
  } else if (env == 'st2') {
		config.banId = "196485315"
		config.ptnId = "2138417451"
		config.valueId = "00792839021"
		config.subscriptionIdInput = "00792839021"
		config.engagementIdInput = "234567"
		config.agentIdInput = "2345"
		config.smUserId = "AOST1-665428377"
		config.subscriptionIdPtnInput = "65836386121"
		config.apiservice = 'https://st2-apiservices-web.test.sprint.com:7441/api/digital/aiva';
  } else if (env == 'e2e') {
    config.someUrlBase = 'https://e2e-host/v1/auth';
  }
  // don't waste time waiting for a connection or if servers don't respond within 5 seconds
  karate.configure('connectTimeout', 16000);
  karate.configure('readTimeout', 15000);
  karate.configure('ssl',true);
  return config;
}