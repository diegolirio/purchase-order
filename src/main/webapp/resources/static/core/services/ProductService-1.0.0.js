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
	
	/**
	 * salvar produto
	 */
	var _save = function(product) {
		return $http.post(serverURL('/save'), product);
	};
	
	/**
	 * salvar produto (Params)
	 */
	var _saveParams = function(product) {
		var id = product.id > 0 ? product.id : 0;
		var params = "?id="+id+"&code="+product.code+"&description="+product.description+"&valueUnit="+product.valueUnit;
		return $http.post(serverURL('/saveParams')+params);
	};
	
	return {
		
		getAll : _getAll,
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);