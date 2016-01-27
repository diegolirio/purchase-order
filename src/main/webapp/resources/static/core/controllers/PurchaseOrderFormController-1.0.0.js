/**
 * 
 */
app.controller('PurchaseOrderFormController', ['PurchaseOrderService', function(PurchaseOrderService) {
	
	var self = this;
	
	self.REMETENTE = 'RE';
	self.DESTINATARIO = 'DE';
	self.TRANSPORTADORA = 'TR';
	self.PEDIDO = 'PO';
	self.PRODUTOS = 'PR';
	
	var init = function() {
		self.formVisible = self.REMETENTE;
	};
	
	init();
	
}]);