/**
 * 
 */
app.factory('CustomerService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/customer' + url;
	};
	
	/**
	 * busca pelo id
	 */
	var _get = function(id) {
		return $http.get(serverURL('/get/'+id));
	};
	
	/**
	 * pega por cpfCnpj
	 */
	var _getByCpfCnpj = function(cpfCnpj) {
		return $http.get(serverURL('/get/by/cpfcnpj/'+cpfCnpj));
	};
	
	/**
	 * pega por cpfCnpj
	 */
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	/**
	 * Salvar Cliente
	 */
	var _save = function(customer) {
		return $http.post(serverURL('/save'), customer);
	};
	
	/**
	 * Salvar Cliente (Params)
	 */
	var _saveParams = function(customer) {
		return $http.post(serverURL('/save')+"?id="+customer.id+"&name="+customer.name+"&cpfCnpj="+customer.cpfCnpj+
											   "&signUpState="+customer.signUpState+"&email="+customer.email);
	};
	 
	return {
		
		get : _get,
		
		getByCpfCnpj : _getByCpfCnpj,
		
		getAll : _getAll,
		
		save : _save,

		saveParams : _saveParams
		
	};
	
}]);