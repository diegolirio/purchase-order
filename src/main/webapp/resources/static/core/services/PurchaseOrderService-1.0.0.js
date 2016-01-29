/**
 * 
 */
app.factory('PurchaseOrderService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/purchaseorder' + url;
	};
	
	/**
	 * pega todos os pedidos
	 */
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	/**
	 * salvar P.O
	 */
	var _save = function(purchaseOrder) {
		return $http.post(serverURL('/save'), purchaseOrder);
	}
	
	/**
	 * salvar P.O Params
	 */
	var _saveParams = function(purchaseOrder) {
		var params = "?id="+purchaseOrder.id;
		return $http.post(serverURL('/save')+params);
	}
	
	return {
		
		getAll : _getAll,
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);