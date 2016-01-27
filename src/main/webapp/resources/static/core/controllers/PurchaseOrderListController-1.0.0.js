/**
 * Classe PurchaseOrderListController responsible by views/purchaseorder/list.jsp
 */
app.controller('PurchaseOrderListController', ['PurchaseOrderService', function(PurchaseOrderService) {

	var self = this;
	
	/**
	 * Load 
	 */
	var init = function() {
		PurchaseOrderService.getAll().then(function(resp) {
			self.purchaseOrders = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);
