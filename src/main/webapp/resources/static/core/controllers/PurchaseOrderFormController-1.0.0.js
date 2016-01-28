/**
 * 
 */
app.controller('PurchaseOrderFormController', ['PurchaseOrderService', 'CustomerService', 'AddressService',
                                               function(PurchaseOrderService, CustomerService, AddressService) {
	
	var self = this;
	
	self.REMETENTE = 'RE';
	self.DESTINATARIO = 'DE';
	self.TRANSPORTADORA = 'TR';
	self.PEDIDO = 'PO';
	self.PRODUTOS = 'PR';
	
	var init = function() {
		self.formVisible = self.REMETENTE;
		// TODO busca endereco destino por customer
		// TODO busca telefone destino por customer
	};
	
	/**
	 * busca cliente remetente por cpfCnpj
	 */
	self.getCustomerSenderByCpfCnpj = function(cpfCnpj) {
		// Busca Cliente por cpfCnpj
		CustomerService.getByCpfCnpj(cpfCnpj).then(function(resp) {
			self.customerSender = resp.data;
			self.nameSender = self.customerSender.name;
			return resp;
		}).then(function(respCustomer) { 
			// Busca enderecos do Cliente (encadeado)
			if(respCustomer.data != "null") {
				AddressService.getListByPeople(respCustomer.data).then(function(resp) {
					self.addressesSender = resp.data;
				}, function(error) {
					alert(JSON.stringify(error));
				});
			} else {
				self.addressesSender = []; 
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);