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
	 * pega lista de items de uma p.o
	 */
	var _getListByPurchaseOrder = function(po) {
		return $http.get(serverURL('/get/list/by/po/'+po.id));
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
		var params = "?id="+id+"&product.id="+orderProduct.product.id+"&amount="+orderProduct.amount+"&valueUnit="+orderProduct.product.valueUnit+
		             "&order.id="+orderProduct.purchaseOrder.id;
		console.log(serverURL('/saveParams')+params);
		return $http.post(serverURL('/saveParams')+params);
	};
	
	/**
	 * Delete item da P.O
	 */
	var _deleteOrderProduct = function(op) {
		return $http.post(serverURL('/delete/'+op.id));
	};
	
	return { 
		
		getAll : _getAll,
		
		getListByPurchaseOrder : _getListByPurchaseOrder,
		
		save : _save,
		
		saveParams : _saveParams,
		
		deleteOrderProduct : _deleteOrderProduct
		
	};
	
}]);