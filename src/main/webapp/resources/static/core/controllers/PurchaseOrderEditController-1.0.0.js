/**
 * Classe PurchaseOrderEditController responsible by views/purchaseorder/edit.jsp
 */
app.controller('PurchaseOrderEditController', ['PurchaseOrderService', '$routeParams',
                                               function(PurchaseOrderService, $routeParams) {

	var self = this;
	
	/**
	 * Load 
	 */
	var init = function() {
		PurchaseOrderService.get($routeParams.id).then(function(resp) {
			self.purchaseOrder = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};

	/**
	 * set status canceled
	 */
	self.setStatusCanceled = function(purchaseOrder, reason) {
		PurchaseOrderService.cancel(purchaseOrder, reason).then(function(resp) {
			self.purchaseOrder = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);
