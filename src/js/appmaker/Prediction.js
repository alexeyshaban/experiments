var logger = require("logger");

exports.addApi = function() {
	logger.info('callApi');

	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.src = 'https://apis.google.com/js/client.js?onload=handleClientLoad';
	document.getElementsByTagName('head')[0].appendChild(script);

	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.innerHTML = 'handleClientLoad = function() {require("TestAuth").handleClientLoad()}';
	document.getElementsByTagName('head')[0].appendChild(script);
};

// Enter a client ID for a web application from the Google Developer Console.
// The provided clientId will only work if the sample is run directly from
// https://google-api-javascript-client.googlecode.com/hg/samples/authSample.html
// In your Developer Console project, add a JavaScript origin that corresponds
// to the domain
// where you will be running the script.
var clientId = '36166962206-erv831nnjtsdfr6c3d183sbdq6vup1b1.apps.googleusercontent.com';

// Enter the API key from the Google Develoepr Console - to handle any
// unauthenticated
// requests in the code.
// The provided key works for this sample only when run from
// https://google-api-javascript-client.googlecode.com/hg/samples/authSample.html
// To use in your own application, replace this API key with your own.
var apiKey = 'AIzaSyB-4-Cs_97XooaFBC50J33-NYhyGuIBmTY';

// To enter one or more authentication scopes, refer to the documentation for
// the API.
var scopes = 'https://www.googleapis.com/auth/prediction';

exports.handleClientLoad = function() {
	logger.info('handleClientLoad');
	logger.info('apiKey = ' + apiKey);
	// Use a button to handle authentication the first time.
	gapi.client.setApiKey(apiKey);
	logger.info(apiKey);
	window.setTimeout(checkAuth, 1);
	// checkAuth();
};

function checkAuth() {
	logger.info(clientId);
	gapi.auth.authorize({
		client_id : clientId,
		scope : scopes,
		immediate : true
	}, handleAuthResult);
}

function handleAuthResult(authResult) {
	logger.info("authResult " + JSON.stringify(authResult));
	makeApiCall();
}

function makeApiCall() {
	gapi.client.load('prediction', 'v1.6', function() {
		logger.info("gapi.client.prediction "
				+ JSON.stringify(gapi.client.prediction.trainedmodels));
		var request = gapi.client.prediction.trainedmodels.predict({
			"id" : "languageidentifier",
			"project" : "36166962206",
			"input" : {
				"csvInstance" : [ 'This is a test request in English' ]
			}
		});
		request.execute(function(resp) {
			logger.info("Prediction response " + JSON.stringify(resp));
		});
	});
}