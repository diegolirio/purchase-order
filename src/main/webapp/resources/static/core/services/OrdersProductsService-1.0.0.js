/**
 * 
 */
app.factory('OrdersProductsService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/orders_products' + url;
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
	var _save = function(orderProduct) {
		return $http.post(serverURL('/save'), orderProduct);
	};
	
	/**
	 * salvar produto (Params)
	 */
	var _saveParams = function(orderProduct) {
		var id = orderProduct.id > 0 ? orderProduct.id : 0;
		var params = "?id="+id+"&code="+orderProduct.product.id+"&amount="+orderProduct.amount;
		return $http.post(serverURL('/saveParams')+params);
	};
	
	return {
		
		getAll : _getAll,
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);