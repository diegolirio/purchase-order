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
	
	/**
	 * Salvar Por Params :(
	 */
	var _saveParams = function(phone) {
		var params = "?id="+phone.id+"&number="+phone.number+"&contactType="+phone.contactType+"&people.id="+phone.people.id;
		return $http.post(serverURL('/saveParams')+params);
	};
	
	return {
		 
		getListByPeople : _getListByPeople,
		
		saveParams : _saveParams
		
	};
	
}]);
