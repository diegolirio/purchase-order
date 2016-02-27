/**
 * 
 */
app.factory('ProductTypeService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/producttype' + url;
	};
	
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	return {
		 
		getAll : _getAll
		
	};
	
}]);
