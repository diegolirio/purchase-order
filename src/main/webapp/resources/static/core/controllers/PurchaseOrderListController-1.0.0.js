/**
 * Classe PurchaseOrderListController responsible by views/purchaseorder/list.jsp
 */
app.controller('PurchaseOrderListController', ['PurchaseOrderService', function(PurchaseOrderService) {

	var self = this;
	
	self.statusList = [{status: "peding", "display": "Pendente"}, {status: "completed", "display": "Concluído"}];
	
	/**
	 * Load 
	 */
	var init = function() {
		
		self.search = {};
		self.search.status = "peding";
		
		PurchaseOrderService.getAll().then(function(resp) {
			self.purchaseOrders = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);
