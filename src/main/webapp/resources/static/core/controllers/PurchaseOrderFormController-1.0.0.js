/**
 * 
 */
app.controller('PurchaseOrderFormController', ['$routeParams', 'PurchaseOrderService', 'CustomerService', 
                                               'AddressService', 'TelephoneService', 'ProductService',
                                               'OrdersProductsService',
                                               function($routeParams, PurchaseOrderService, CustomerService, 
                                            		    AddressService, TelephoneService, ProductService,
                                            		    OrdersProductsService) {
	
	var self = this;
	
	self.REMETENTE = 'RE';
	self.DESTINATARIO = 'DE';
	self.TRANSPORTADORA = 'TR';
	self.PEDIDO = 'PO';
	self.PRODUTOS = 'PR'; 

	/**
	 * Contructor Class
	 */
	var init = function() {
		self.formVisible = self.REMETENTE;
		if($routeParams.id > 0) {
			self.loadPO($routeParams.id);
		}
	};
	
	/**
	 * Carrega P.O no form pelo ID
	 */
	self.loadPO = function(id) {
		PurchaseOrderService.get($routeParams.id).then(function(resp) {
			self.purchaseOrder = resp.data;
			// Sender (remetente)
			self.cpfCnpjSender = self.purchaseOrder.customerAddressSender.people.cpfCnpj;
			self.customerSender = self.purchaseOrder.customerAddressSender.people;
			self.nameSender = self.customerSender.name; // TODO: analisar pq dois name
			// Recipient (destinatario)
			self.cpfCnpjRecipient = self.purchaseOrder.customerAddressRecipient.people.cpfCnpj;
			self.customerRecipient = self.purchaseOrder.customerAddressRecipient.people;
			self.nameRecipient = self.customerRecipient.name; // TODO: analisar pq dois name
			return resp;
		}).then(function(respPO) {
			// Busca enderecos do Cliente (encadeado)
			AddressService.getListByPeople(respPO.data.customerAddressSender.people).then(function(resp) {
				self.addressesSender = resp.data;
				for(var i = 0; i <= self.addressesSender.length-1; i++) { 
					if(self.addressesSender[i].id == self.purchaseOrder.customerAddressSender.id) {
						self.purchaseOrder.customerAddressSender = self.addressesSender[i];
						break;
					}
				}				
			}, function(error) {
				alert(JSON.stringify(error));
			});
			return respPO;
		}).then(function(respPO) {
			// busca telefone e mantem o atual selecionado
			TelephoneService.getListByPeople(respPO.data.customerAddressSender.people).then(function(resp) {
				self.phonesSender = resp.data;
				for(var i = 0; i <= self.phonesSender.length-1; i++) { 
					if(self.phonesSender[i].number == self.purchaseOrder.phoneSender) {
						self.purchaseOrder.phoneSender = self.phonesSender[i].number; 
						break;
					}
				}					
			}, function(error) { 
				alert(JSON.stringify(error));
			});			
			return respPO;
		}).then(function(respPO) {
			// Busca enderecos do Cliente (encadeado)
			AddressService.getListByPeople(respPO.data.customerAddressRecipient.people).then(function(resp) {
				self.addressesRecipient = resp.data;
				for(var i = 0; i <= self.addressesRecipient.length-1; i++) { 
					if(self.addressesRecipient[i].id == self.purchaseOrder.customerAddressRecipient.id) {
						self.purchaseOrder.customerAddressRecipient = self.addressesRecipient[i]; 
						break;
					}
				}				
			}, function(error) {
				alert(JSON.stringify(error));
			});
			return respPO;			
		}).then(function(respPO) {
			// busca telefone e mantem o atual selecionado
			TelephoneService.getListByPeople(respPO.data.customerAddressRecipient.people).then(function(resp) {
				self.phonesRecipient = resp.data;
				for(var i = 0; i <= self.phonesRecipient.length-1; i++) { 
					// fone dest
					if(self.phonesRecipient[i].number == self.purchaseOrder.phoneRecipient) 
						self.purchaseOrder.phoneRecipient = self.phonesRecipient[i].number; 
					// fax
					if(self.phonesRecipient[i].number == self.purchaseOrder.faxRecipient) 
						self.purchaseOrder.faxRecipient = self.phonesRecipient[i].number; 
				}					
			}, function(error) { 
				alert(JSON.stringify(error));
			});	
			return respPO;
		}).then(function(respPO) {
			// busca telefone e mantem o atual selecionado
			TelephoneService.getListByPeople(respPO.data.shippingCompany).then(function(resp) {
				self.phonesShippingCompany = resp.data;
				for(var i = 0; i <= self.phonesShippingCompany.length-1; i++) { 
					// fone transportadora
					if(self.phonesShippingCompany[i].number == self.purchaseOrder.phoneShippingCompany) 
						self.purchaseOrder.phoneShippingCompany = self.phonesShippingCompany[i].number; 
				}					
			}, function(error) { 
				alert(JSON.stringify(error));
			});				
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
	};
	
	/**
	 * busca cliente remetente por cpfCnpj
	 */
	self.getCustomerSenderByCpfCnpj = function(cpfCnpj) {
		// Busca Cliente por cpfCnpj
		CustomerService.getByCpfCnpj(cpfCnpj).then(function(resp) {
			self.customerSender = resp.data;
			self.nameSender = self.customerSender.name; // TODO: analisar pq dois name
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
		
		PurchaseOrderService.saveParams(po).then(function(resp) {
			self.purchaseOrder = resp.data;
			self.formVisible = self.PRODUTOS;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
	};
	
	/**
	 * Show Modal Product
	 */
	self.showFormModalProduct = function() {
		$('#idProductModal').modal('show');
	};
	
	/**
	 * Salvar Produto
	 */
	self.saveProduct = function(product) {
		ProductService.saveParams(product).then(function(resp) {
			self.orderProduct = {};
			self.orderProduct.product = resp.data;
			$('#idProductModal').modal('hide');
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * Adiciona produto na P.O
	 */
	self.addOrderProduct = function(orderProduct) {
		OrdersProductsService.saveParams(orderProduct).then(function(resp) {
			self.orderProduct = {};
			self.ordersProducts.push(resp.data);
		}, function(error) {
			alert(JSON.stringify(error));
		});		
	};
	
	
	init();
	
}]);