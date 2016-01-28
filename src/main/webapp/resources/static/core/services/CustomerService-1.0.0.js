/**
 * 
 */
app.factory('CustomerService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/customer' + url;
	};
	
	/**
	 * pega por cpfCnpj
	 */
	var _getByCpfCnpj = function(cpfCnpj) {
		return $http.get(serverURL('/get/by/cpfcnpj/'+cpfCnpj));
	};
	
	return {
		
		getByCpfCnpj : _getByCpfCnpj
		
	};
	
}]);