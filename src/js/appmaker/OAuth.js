var logger = require("logger");

exports.prediction = null;

exports.addApi = function() {

	if (exports.prediction) {
		return;
	}
	logger.info('callApi');

	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.src = 'https://apis.google.com/js/client.js?onload=handleClientLoad';
	document.getElementsByTagName('head')[0].appendChild(script);

	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.innerHTML = 'handleClientLoad = function() {require("OAuth").handleClientLoad()}';
	document.getElementsByTagName('head')[0].appendChild(script);
};

var clientId = '...';
var apiKey = '...';
var scopes = 'https://www.googleapis.com/auth/prediction';

exports.handleClientLoad = function() {
	logger.info('apiKey = ' + apiKey);
	gapi.client.setApiKey(apiKey);
	exports.checkAuth();
};

exports.checkAuth = function() {

	if (exports.prediction) {
		return;
	}
	logger.info("authenticate " + clientId);
	var token = gapi.auth.getToken();
	logger.info("Found token " + JSON.stringify(token));
	var silent = token && token.expires_in > 0 ? true : false;
	gapi.auth.authorize({
		client_id : clientId,
		scope : scopes,
		immediate : silent
	}, handleAuthResult);
}

function handleAuthResult(authResult) {
	logger.info("authResult " + JSON.stringify(authResult));
	gapi.client.load('prediction', 'v1.6', function() {
		exports.prediction = gapi.client.prediction.trainedmodels;
		logger.info("gapi.client.prediction "
				+ JSON.stringify(exports.prediction));
	});
}