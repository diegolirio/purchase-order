/**
 * 
 */
app.controller('PurchaseOrderListController', ['PurchaseOrderService', function(PurchaseOrderService) {

	var self = this;
	
	self.purchaseOrders = [];
	self.purchaseOrders.push({"id": 19999});
	
	var init = function() {
		PurchaseOrderService.getAll().then(function(resp) {
			self.purchaseOrders = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	
	
}]);
