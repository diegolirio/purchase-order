/**
 * 
 */
app.factory('PurchaseOrderService', ['$http', function($http) {
	
	var self = this;
	
	var serverURL = function(url) {
		return SERVER_APP + '/purchaseorder' + url;
	};
	
	/**
	 * pega todos os pedidos
	 */
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	return {
		
		getAll : _getAll
		
	};
	
}]);