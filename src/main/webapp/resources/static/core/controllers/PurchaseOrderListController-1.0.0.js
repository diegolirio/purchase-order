/**
 * Classe PurchaseOrderListController responsible by views/purchaseorder/list.jsp
 */
app.controller('PurchaseOrderListController', ['PurchaseOrderService', 'DateCommon', 
                                               function(PurchaseOrderService, DateCommon) {

	var self = this;
	
	
	/**
	 * Load 
	 */
	var init = function() {

		self.statusList = [{status: "peding", "display": "Pendente"}, {status: "completed", "display": "Concluido"}];
		self.search = {};
		self.search.status = self.statusList[0].status;
		self.search.dateStart = DateCommon.getTodaySubtract(7);
		self.search.dateEnd = DateCommon.getToday(); 
		
		PurchaseOrderService.getAll().then(function(resp) {
			self.purchaseOrders = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
//		PurchaseOrderService.searchAdvanced(status, dateStart, dateEnd).then(function(resp) {
//			self.purchaseOrders = resp.data;
//		}, function(error) {
//			alert(JSON.stringify(error));
//		});
		
	};
	
	init();
	
}]);
