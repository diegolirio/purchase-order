/**
 * 
 */
app.factory('AddressService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/address' + url;
	};
	
	/**
	 * pega 
	 */
	var _getListByPeople = function(people) {
		return $http.get(serverURL('/get/list/by/people/'+people.id));
	};
	
	return {
		
		getListByPeople : _getListByPeople
		
	};
	
}]);
