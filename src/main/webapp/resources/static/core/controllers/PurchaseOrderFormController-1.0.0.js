/**
 * 
 */
app.controller('PurchaseOrderFormController', ['$scope', '$routeParams', '$location', 'PurchaseOrderService', 'CustomerService', 
                                               'AddressService', 'TelephoneService', 'ProductService', 'ProductTypeService',
                                               'OrdersProductsService', 'StringCommon', 'MaskService',
                                               function($scope, $routeParams, $location, PurchaseOrderService, CustomerService, 
                                            		    AddressService, TelephoneService, ProductService, ProductTypeService,
                                            		    OrdersProductsService, StringCommon, MaskService) {
	
	var self = this;
	
	self.REMETENTE = 'RE';
	self.DESTINATARIO = 'DE';
	self.TRANSPORTADORA = 'TR';
	self.PEDIDO = 'PO';
	self.PRODUTOS = 'PR'; 
	self.MESSAGE = 'MS'; 

	self.productOK = false;
	self.totalPO = 0;
	
	
	/**
	 * Contructor Class
	 */
	var init = function() {
		self.formVisible = self.REMETENTE;
		
		// Load P.O if route with ID
		if($routeParams.id > 0) {
			self.loadPO($routeParams.id);
		} else 
			if($scope.userLogged.cnpj != "null" && 
			   $scope.userLogged.cnpj != null &&
			   $scope.userLogged.cnpj != undefined &&
			   $scope.userLogged.cnpj != "") {
				self.maskCnpjSender($scope.userLogged.cnpj); 
				self.getCustomerSenderByCpfCnpj($scope.userLogged.cnpj);
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
			// transport
			self.cpfCnpjShippingCompany = self.purchaseOrder.customerAddressShippingCompany.people.cpfCnpj;
			self.shippingCompanyName = self.purchaseOrder.customerAddressShippingCompany.people.name;
			return resp;
		}).then(function(respPO) {
			// Busca enderecos do Remetente (encadeado)
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
			// Busca enderecos do Destinatario (encadeado)
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
					if(self.phonesRecipient[i].number == self.purchaseOrder.phoneRecipient) {
						self.purchaseOrder.phoneRecipient = self.phonesRecipient[i].number; 
						break;
					}
				}					
			}, function(error) { 
				alert(JSON.stringify(error));
			});			
			return respPO;
		}).then(function(respPO) {
			
			// Busca enderecos do Transport (encadeado)
			if(respPO.data.customerAddressShippingCompany != null && respPO.data.customerAddressShippingCompany != undefined) {
				AddressService.getListByPeople(respPO.data.customerAddressShippingCompany.people).then(function(resp) {
					self.addressesShippingCompany = resp.data;
					for(var i = 0; i <= self.addressesShippingCompany.length-1; i++) { 
						if(self.addressesShippingCompany[i].id == self.purchaseOrder.customerAddressShippingCompany.id) {
							self.purchaseOrder.customerAddressShippingCompany = self.addressesShippingCompany[i]; 
							break;
						}
					}				
				}, function(error) {
					alert(JSON.stringify(error));
				});
			}
			return respPO;			
		}).then(function(respPO) { 
			// busca telefone e mantem o atual selecionado (Transport)
			TelephoneService.getListByPeople(respPO.data.customerAddressShippingCompany.people).then(function(resp) {
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
	 * 
	 */
	self.maskCnpjSender = function(v) {
		self.cpfCnpjSender = MaskService.cnpj(v);
	};

	/**
	 * 
	 */
	self.maskCnpjRecipient = function(v) {
		self.cpfCnpjRecipient = MaskService.cnpj(v);
	};
	
	/**
	 * 
	 */
	self.maskCurrency = function(value) {
		self.product.valueUnit = MaskService.currency(value); 
	};
 	
	/**
	 * 
	 */
	self.maskShippingCompanyCpfCnpj = function(value) {
		self.cpfCnpjShippingCompany = MaskService.cnpj(value);
	};
	
	/**
	 * busca cliente remetente por cpfCnpj
	 */
	self.getCustomerSenderByCpfCnpj = function(cpfCnpj) {
		if(cpfCnpj == '') return;
		cpfCnpj = MaskService.num(cpfCnpj); 
		// Busca Cliente por cpfCnpj
		CustomerService.getByCpfCnpj(cpfCnpj).then(function(resp) {
			self.customerSender = resp.data;
			self.nameSender = self.customerSender.name; // TODO: analisar pq dois name
			if(self.customerSender == "null" && cpfCnpj != undefined) { 
				alert('Cliente com CPF/CNPJ '+cpfCnpj+' não cadastrado'); 
			}
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

	self.typeSearchCustomer = '';
	/**
	 * Show Modal Customer Sender
	 */
	self.showModalSearchCustomer = function(rementeOuDestinatarioOuTransportadora) {
		self.typeSearchCustomer = rementeOuDestinatarioOuTransportadora;
		$('#idSearchCustomerModal').modal('show');
	};
	
	/**
	 * pesquisa cliente
	 */
	self.findCustomerByCpfCnpjOrName = function(cpfCnpj, name) {
		if (StringCommon.isEmpty(cpfCnpj) && StringCommon.isEmpty(name)) {
			alert('Campos em branco');
			return;
		}
		if (StringCommon.isEmpty(cpfCnpj)) cpfCnpj = "NULLO";
		if (StringCommon.isEmpty(name)) name = "NULLO";
		CustomerService.findByCpfCnpjOrName(cpfCnpj, name).then(function(resp) {
			self.customers = resp.data;
			if(self.customers.length == 0) return;  
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * Seleciona Customer
	 */
	self.selectedCustomer = function(customer) {
		if(self.typeSearchCustomer == 'R') { // Remetente
			self.cpfCnpjSender = customer.cpfCnpj;
			self.getCustomerSenderByCpfCnpj(self.cpfCnpjSender);
		} else if(self.typeSearchCustomer == 'D') { // Destinatario
			self.cpfCnpjRecipient = customer.cpfCnpj;
			self.getCustomerRecipientByCpfCnpj(self.cpfCnpjRecipient);
		} else if(self.typeSearchCustomer == 'T') { // Transportadora
			self.purchaseOrder.shippingCompany = {};
			self.purchaseOrder.shippingCompany.cpfCnpj = customer.cpfCnpj;
			self.getShippingCompanyByCpfCnpj(self.purchaseOrder.shippingCompany.cpfCnpj);
		}
		$('#idSearchCustomerModal').modal('hide');
		self.customers = [];
	};
 	
	
	/**
	 * busca cliente destinatario por cpfCnpj
	 */
	self.getCustomerRecipientByCpfCnpj = function(cpfCnpj) {
		cpfCnpj = MaskService.num(cpfCnpj);
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
		cpfCnpj = MaskService.num(cpfCnpj);
		CustomerService.getByCpfCnpj(cpfCnpj).then(function(resp) {
			self.cpfCnpjShippingCompany = resp.data.cpfCnpj;
			self.shippingCompanyName = resp.data.name;
			return resp;
		}).then(function(respCustomer) { 
			// Busca enderecos do Cliente (encadeado)
			if(respCustomer.data != "null") {
				AddressService.getListByPeople(respCustomer.data).then(function(resp) {
					self.addressesShippingCompany = resp.data;
				}, function(error) {
					alert(JSON.stringify(error));
				});
			} else {
				self.addressesShippingCompany = []; 
			}
			return respCustomer;
			
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
		po.userCreated = $scope.userLogged;
		PurchaseOrderService.saveParams(po).then(function(resp) {
			self.purchaseOrder = resp.data;
			self.formVisible = self.PRODUTOS;
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
	 * Carrega o total do Pedido
	 */
	self.loadTotalPO = function(ordersProducts) {
		self.totalPO = 0;
		for(var i = 0; i <= self.ordersProducts.length-1; i++) {
			self.totalPO = self.totalPO + (self.ordersProducts[i].product.valueUnit * self.ordersProducts[i].amount);
		}
	};
	
	/**
	 * Show Modal Product
	 */
	self.showFormModalProduct = function() {
		ProductTypeService.getAll().then(function(resp) {
			self.productTypes = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		$('#idProductModal').modal('show');
	};
	
	/**
	 * Salvar Produto
	 */
	self.saveProduct = function(product) {
		product.id = 0;
		if(product.productType == undefined) {
			product.productType = {};
			product.productType.id = null;
		}
		ProductService.saveParams(product).then(function(resp) {
			self.orderProduct = {};
			self.orderProduct.product = resp.data;
			$('#idProductModal').modal('hide');
			self.productOK = true;
			self.product = {};
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Adiciona produto na P.O
	 */
	self.addOrderProduct = function(orderProduct) {
		if (self.productOK == false) {
			alert('Digite um produto válido');
			return;
		}
		if (orderProduct.amount <= 0 || orderProduct.amount == undefined) { 
			alert('Digite a quantidade. Deve ser Maior que ZERO!');
			return;
		}
		orderProduct.purchaseOrder = self.purchaseOrder;
		OrdersProductsService.saveParams(orderProduct).then(function(resp) {
			self.orderProduct = {};
			self.ordersProducts.push(resp.data);
			self.productOK = false;
			self.loadTotalPO(self.ordersProducts); 
		}, function(error) {
			alert(JSON.stringify(error));
		});		
	};

	/**
	 * Delete item da p.o
	 */
	self.deleteOrderProduct = function(op) {
		OrdersProductsService.deleteOrderProduct(op).then(function(resp) {
			var index = self.ordersProducts.indexOf(op);
			self.ordersProducts.splice(index, 1);
			self.loadTotalPO(self.ordersProducts); 
			alert('Produto excluido do Pedido');
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * busca produto por codigo
	 */
	self.findProductByCode = function(code) {
		if(code == undefined || code == "" || code == null) return;
		ProductService.getByCode(code).then(function(resp) {
			var product = resp.data;
			if(product.id > 0) {
				self.orderProduct = {};
				self.orderProduct.product = resp.data; 
				self.productOK = true;
			} else {
				self.productOK = false;
				alert('Não existe produto com este codigo'); 
				$('#idProductModal').modal('show');
				self.product = {}; 
				self.product.code = code;
			}
		}, function(error) {
			self.productOK = false;
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * Show Modal search product
	 */
	self.showModalSearchProduct = function() {
		$('#idSearchProductModal').modal('show');
	};
	
	/**
	 * Search product by code or description
	 */
	self.findProductByCodeOrDescription = function(codeOrDescription) {
		ProductService.getByCodeOrDescription(codeOrDescription, codeOrDescription).then(function(resp) {
			self.products = resp.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Seleciona produto para adiciona-lo e fecha o modal
	 */
	self.selectedProduct = function(product) {
		self.orderProduct = {};
		self.orderProduct.product = product;
		$('#idSearchProductModal').modal('hide');
		self.productOK = true;
		self.products = [];		
	};
	
	/**
	 * Efetivar Pedido
	 */
	self.completedPO = function(po) {
		PurchaseOrderService.completedPurchaseOrder(po).then(function(resp) {
			//alert('Efetivado com sucesso!');
			//$location.path('/pedido');
			self.formVisible = self.MESSAGE; 
		}, function(error) {
			alert('Erro ao Efetivar.\n'+error.data);
		});
	};
	
	init();
	
}]);