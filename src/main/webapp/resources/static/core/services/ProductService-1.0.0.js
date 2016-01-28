/**
 * 
 */
app.factory('ProductService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/product' + url;
	};
	
	/**
	 * pega todos
	 */
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	return {
		
		getAll : _getAll
		
	};
	
}]);