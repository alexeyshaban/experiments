var logger = require("logger");

exports.predict = function(text, field, predictedCallback) {
	var request = require('OAuth').prediction.predict({
		"id" : field,
		"project" : "36166962206",
		"input" : {
			"csvInstance" : [ text ]
		}
	});
	logger.info("request " + JSON.stringify(request));
	request.execute(function(resp) {
		logger.info("Prediction response " + JSON.stringify(resp));
		if (predictedCallback) {
			predictedCallback(resp)
		}
	});
}

exports.analyze = function(model) {
	var request = require('OAuth').prediction.analyze({
		"id" : model,
		"project" : "36166962206"
	});
	request.execute(function(resp) {
		logger.info("Prediction response " + JSON.stringify(resp));
	});
}

exports.update = function(text, model, answer) {
	logger.info(require('OAuth').prediction.update);
	var request = require('OAuth').prediction.update({
		"id" : model,
		"project" : "36166962206",
		"output" : answer,
		"csvInstance" : [ text ]
	});
	logger.info("request " + JSON.stringify(request));
	request.execute(function(resp) {
		logger.info("Prediction response " + JSON.stringify(resp));
	});
}