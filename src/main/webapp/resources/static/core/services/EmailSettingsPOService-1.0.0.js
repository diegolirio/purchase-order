/**
 * 
 */
app.factory('EmailSettingsPOService', ['$http', function($http) {
 
	var serverURL = function(url) {
		return SERVER_APP + '/emailsettingspo' + url;
	};
	
	var _getMain = function() {
		return $http.get(serverURL('/get/main'));
	};
	
	var _save = function(emailSettingsPO) {
		return $http.post(serverURL('/save'), emailSettingsPO);
	};

	var _saveParams = function(emailSettingsPO) {
		return $http.post(serverURL('/saveParams')+"?id="+emailSettingsPO.id+"&fromEmail="+emailSettingsPO.fromEmail+
										      	   "&username="+emailSettingsPO.username+"&password="+emailSettingsPO.password+
										      	   "&port="+emailSettingsPO.port+"&host="+emailSettingsPO.host);
	};
	
	return {
		
		getMain : _getMain,
		
		save : _save,

		saveParams : _saveParams
		
	}
	
}]);
