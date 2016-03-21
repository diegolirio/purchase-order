/**
 * Classe PurchaseOrderEditController responsible by views/purchaseorder/edit.jsp
 */
app.controller('PurchaseOrderEditController', ['PurchaseOrderService', '$routeParams', 'OrdersProductsService',
                                               function(PurchaseOrderService, $routeParams, OrdersProductsService) {

	var self = this;
	
	/**
	 * Carrega o total do Pedido
	 */
	self.loadTotalPO = function(ordersProducts) {
		self.totalPO = 0;
		for(var i = 0; i <= self.ordersProducts.length-1; i++) {
			self.totalPO = self.totalPO + (self.ordersProducts[i].product.valueUnit * self.ordersProducts[i].amount);
		}
	};	
	
	/**
	 * Load 
	 */
	var init = function() {
		PurchaseOrderService.get($routeParams.id).then(function(resp) {
			self.purchaseOrder = resp.data;
			return resp;
		}).then(function(respPO) {
			// ao salvar PO carrega os items(produtos)
			OrdersProductsService.getListByPurchaseOrder(respPO.data).then(function(resp) {
				self.ordersProducts = resp.data;
				self.loadTotalPO(self.ordersProducts);
			}, function(error) {
				alert(JSON.stringify(error));
			});
			
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};

	/**
	 * set status canceled
	 */
	self.setStatusCanceled = function(purchaseOrder, reason) {
		var _confirm = confirm('Deseja realmente Cancelar Coleta? Uma vez cancelada não podera mais ser revertida!');
		if(_confirm == true) {
			PurchaseOrderService.cancel(purchaseOrder, reason).then(function(resp) {
				self.purchaseOrder = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}
	};
	
	/**
	 * 
	 */
	self.sendMail = function(po) {
		var _confirm = confirm('Deseja realmente renviar email?');
		if(_confirm != true)
			return;
		PurchaseOrderService.sendMail(po).then(function(resp) {
			alert('Email enviado com sucesso');
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);
