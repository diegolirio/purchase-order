/**
 * 
 */
app.factory('TelephoneService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/telephone' + url;
	};
	
	var _getListByPeople = function(people) {
		return $http.get(serverURL('/get/list/by/people/'+people.id));
	};
	
	return {
		
		getListByPeople : _getListByPeople
		
	};
	
}]);
