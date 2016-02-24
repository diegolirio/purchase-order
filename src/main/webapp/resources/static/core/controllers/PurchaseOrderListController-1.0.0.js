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

		self.statusList = [{status: "pending", "display": "Pendente"}, 
		                   {status: "completed", "display": "Concluido"},
		                   {status: "canceled", "display": "Cancelado"}];
		self.search = {};
		self.search.status = self.statusList[0].status;
		//self.search.dateStart = DateCommon.getTodayAddUsEn(-7);
		self.search.dateStart = new Date().toISOString().split("T")[0];
		var data = new Date();
		data.setDate(data.getDate()+1);
	    self.search.dateEnd = data.toISOString().split("T")[0];//DateCommon.getTodayAddUsEn(1);
		self.searchAdv(self.search.status,self.search.dateStart, self.search.dateEnd);
	};
 
	/**
	 * consulta avancada
	 */
	self.searchAdv = function(status, dateStart, dateEnd) {
//		PurchaseOrderService.getAll().then(function(resp) {
//		self.purchaseOrders = resp.data;
//	}, function(error) {
//		alert(JSON.stringify(error));
//	});
		PurchaseOrderService.searchAdvanced(status, dateStart, dateEnd).then(function(resp) {
			self.purchaseOrders = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});		
	};

	/**
	 * Exclui PO
	 */
	self.deletePO = function(po) {
		PurchaseOrderService.deletePO(po).then(function(resp) {
			self.searchAdv(self.search.status,self.search.dateStart, self.search.dateEnd);
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * 
	 */
	self.showModalFilter = function() {
		$('#idModalFilter').modal('show');
	};
	
	/**
	 * Busca PO(s)
	 */
	self.findPOs = function(numero) {
		PurchaseOrderService.get(numero).then(function(resp) {
			self.purchaseOrders = [];
			self.purchaseOrders.push(resp.data);
			$('#idModalFilter').modal('hide');
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);
