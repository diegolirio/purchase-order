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
		
		var po2 = {}; //{"emissionDate":"2016-01-28","customerAddressSender":{"id":1,"cep":"07503270","publicPlace":"Rua Lidice","number":22,"neighborhood":"Parque Novo Mundo","city":"São Paulo","state":{"id":1,"abbreviation":"SP","name":"São Paulo"},"people":{"id":1,"cpfCnpj":"61139432000172","name":"Transportes Della Volpe S/A","signUpState":"31551515151"}},"phoneSender":"1129678511","customerAddressRecipient":{"id":1,"cep":"07503270","publicPlace":"Rua Lidice","number":22,"neighborhood":"Parque Novo Mundo","city":"São Paulo","state":{"id":1,"abbreviation":"SP","name":"São Paulo"},"people":{"id":1,"cpfCnpj":"61139432000172","name":"Transportes Della Volpe S/A","signUpState":"31551515151"}},"phoneRecipient":"11296785","faxRecipient":"1129678536","condicaoPagamento":"CARTAO","shippingCompany":{"id":1,"cpfCnpj":"61139432000172","name":"Transportes Della Volpe S/A","signUpState":"31551515151"},"phoneShippingCompany":"1146758597","typeFreight":"R","remark":"Teste Observacao"};
		po2.customerAddressSender = {};
		po2.customerAddressSender.id = po.customerAddressSender.id; 
		po2.phoneSender = po.phoneSender; 
		po2.customerAddressRecipient = {};
		po2.customerAddressRecipient.id = po.customerAddressRecipient.id;
		po2.phoneRecipient = po.phoneRecipient; 
		po2.faxRecipient = po.faxRecipient;
		po2.shippingCompany = {};
		po2.shippingCompany.id = po.shippingCompany.id;
		po2.phoneShippingCompany = {};
		po2.phoneShippingCompany.id = po.phoneShippingCompany.id;
		po2.typeFreight = po.typeFreight;
		po2.condicaoPagamento = po.condicaoPagamento;
		po2.remark = po.remark;

		console.log(JSON.stringify(po2));
		console.log(po2);
		
		PurchaseOrderService.save(po2).then(function(resp) {
			self.purchaseOrder = resp.data;
			self.formVisible = self.PRODUTOS;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
	};
	
	init();
	
}]);