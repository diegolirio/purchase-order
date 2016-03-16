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
