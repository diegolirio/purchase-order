/**
 * 
 */
app.factory('ProductService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/product' + url;
	};
	
	/**
	 * 
	 */
	var _get = function(id) {
		return $http.get(serverURL('/get/'+id));
	};
	
	/**
	 * pega todos
	 */
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	/**
	 * busca 
	 */
	var _findAdvanced = function(fieldSearch) {
		return $http.get(serverURL('/find/advanced/'+fieldSearch));
	};
	
	/**
	 * busca por codigo
	 */
	var _getByCode = function(code) {
		return $http.get(serverURL('/get/by/code/'+code));
	};	
	
	/**
	 * busca por code ou descricao
	 */
	var _getByCodeOrDescription = function(code, description) {
		return $http.get(serverURL('/get/by/code/'+code+'/or/description/'+description));
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
		var params = "?id="+product.id+"&code="+product.code+"&description="+product.description+"&valueUnit="+product.valueUnit+"&productType.id="+product.productType.id;
		return $http.post(serverURL('/saveParams')+params);
	};
	
	return {
	
		get : _get, 
		
		getAll : _getAll,
		
		getByCode : _getByCode,
	
		getByCodeOrDescription : _getByCodeOrDescription,
	
		findAdvanced : _findAdvanced,
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);