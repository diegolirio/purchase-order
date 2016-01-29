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
	
	/**
	 * Salvar
	 */
	var _save = function(address) {
		return $http.post(serverURL('/save'), address);
	};
	
	/**
	 * Salvar Por Params :(
	 */
	var _saveParams = function(address) {
		var params = "?id="+address.id+"&cep="+address.cep+"&publicPlace="+address.publicPlace+
		              "&number="+address.number+"&neighborhood="+address.neighborhood+"&city="+address.city+
		              "&state.id="+address.state.id+"&people.id="+address.people.id;
		return $http.post(serverURL('/saveParams')+params);
	};
	
	return {
		
		getListByPeople : _getListByPeople,
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);
