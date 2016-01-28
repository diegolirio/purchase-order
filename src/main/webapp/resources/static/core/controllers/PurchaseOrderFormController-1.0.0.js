/**
 * 
 */
app.controller('PurchaseOrderFormController', ['PurchaseOrderService', 'CustomerService', 'AddressService', 'TelephoneService',
                                               function(PurchaseOrderService, CustomerService, AddressService, TelephoneService) {
	
	var self = this;
	
	self.REMETENTE = 'RE';
	self.DESTINATARIO = 'DE';
	self.TRANSPORTADORA = 'TR';
	self.PEDIDO = 'PO';
	self.PRODUTOS = 'PR'; 

	var init = function() {
		self.formVisible = self.REMETENTE;
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
			return respCustomer;
		}).then(function(respCustomer) {
			// Busca telefones do Cliente (encadeado)
			if(respCustomer.data != "null") {
				TelephoneService.getListByPeople(respCustomer.data).then(function(resp) {
					self.phonesSender = resp.data;
				}, function(error) { 
					alert(JSON.stringify(error));
				});
			} else {
				self.phonesSender = [];
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};

	/**
	 * busca cliente destinatario por cpfCnpj
	 */
	self.getCustomerRecipientByCpfCnpj = function(cpfCnpj) {
		// Busca Cliente por cpfCnpj
		CustomerService.getByCpfCnpj(cpfCnpj).then(function(resp) {
			self.customerRecipient = resp.data;
			self.nameRecipient = self.customerRecipient.name;
			return resp;
		}).then(function(respCustomer) { 
			// Busca enderecos do Cliente (encadeado)
			if(respCustomer.data != "null") {
				AddressService.getListByPeople(respCustomer.data).then(function(resp) {
					self.addressesRecipient = resp.data;
				}, function(error) {
					alert(JSON.stringify(error));
				});
			} else {
				self.addressesRecipient = []; 
			}
			return respCustomer;
		}).then(function(respCustomer) {
			// Busca telefones do Cliente (encadeado)
			if(respCustomer.data != "null") {
				TelephoneService.getListByPeople(respCustomer.data).then(function(resp) {
					self.phonesRecipient = resp.data;
				}, function(error) { 
					alert(JSON.stringify(error));
				});
			} else {
				self.phonesRecipient = [];
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * busca cliente Transportadora por cpfCnpj
	 */
	self.getShippingCompanyByCpfCnpj = function(cpfCnpj) {
		// Busca Cliente por cpfCnpj
		CustomerService.getByCpfCnpj(cpfCnpj).then(function(resp) {
			self.purchaseOrder.shippingCompany = resp.data;
			return resp;
		}).then(function(respCustomer) { 
			// Busca telefones do Cliente (encadeado)
			if(respCustomer.data != "null") {
				TelephoneService.getListByPeople(respCustomer.data).then(function(resp) {
					self.phonesShippingCompany = resp.data;
				}, function(error) { 
					alert(JSON.stringify(error));
				});
			} else {
				self.phonesShippingCompany = [];
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};	
	
	/**
	 * Salvar P.O
	 */
	self.savePurchaseOrder = function(po) {
		alert(JSON.stringify(po));
		console.log(po);
		
//		PurchaseOrderService.save(po).then(function(resp) {
//			self.purchaseOrder = resp.data;
//		}, function(error) {
//			alert(JSON.stringify(error));
//		});
		
		self.formVisible = self.PRODUTOS;
	};
	
	init();
	
}]);