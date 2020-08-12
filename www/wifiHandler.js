/*
 * Cordova Network Provoder Plugin for Android
 * Cordova 3.0.0
 * Email: velonirinamihaja[at]gmail[dot]com
 * Author: Mihaja Velonirina
 * Date: 08/08/2020
 */


function WifiHandler() {}


WifiHandler.prototype.getWifiAvailable = function(successCallback, failureCallback) {
	return cordova.exec(
		successCallback,
		failureCallback,
		'WifiHandler',
		'getWifiAvailable',
		[]);
}

WifiHandler.prototype.getWifiStatus = function(successCallback, failureCallback) {
	return cordova.exec(
		successCallback,
		failureCallback,
		'WifiHandler',
		'getWifiStatus',
		[]);
}




// Installation constructor that binds WifiHandler to window
WifiHandler.install = function() {
	if (!window.plugins) {
	  window.plugins = {};
	}
	window.plugins.WifiHandler = new WifiHandler();
	return window.plugins.WifiHandler;
  };
  
  cordova.addConstructor(WifiHandler.install);

