/**
 * 
 */
app.controller('CustomerFormController', ['$routeParams', 'CustomerService', 'AddressService', 'StateService', 'TelephoneService', 'MaskService',
                                          function($routeParams, CustomerService, AddressService, StateService, TelephoneService, MaskService) {
	
	var self = this;

	self.message = null;
	self.messageError = null;
	
	self.contactTypes = [{"type": "COMERCIAL"},
	                     {"type": "CELULAR"}, 
	                     {"type": "FAX"},
	                     {"type": "TELEFAXFAX"},
	                     {"type": "RESIDENCIAL"},
	                     {"type": "OUTRO"},]
	
	var init = function() {
		if($routeParams.id > 0) {
			// Busca cliente por id
			CustomerService.get($routeParams.id).then(function(resp) {
				self.customer = resp.data;
				return resp;
			}).then(function(respCustomer) {
				// pega endereco por cliente
				AddressService.getListByPeople(respCustomer.data).then(function(resp) {
					self.addresses = resp.data;
				}, function(error) {
					alert(JSON.stringify(error));
				});
				return respCustomer;
			}).then(function(respCustomer) {
				// pega tel por cliente
				TelephoneService.getListByPeople(respCustomer.data).then(function(resp) {
					self.phones = resp.data;
				}, function(error) {
					alert(JSON.stringify(error));
				});				
			}, function(error) {
				alert(JSON.stringify(error)); 
			});
		} else {
			self.customer = {}; 
			self.customer.id = 0;
		}
		// Busca ufs
		StateService.getAll().then(function(resp) {
			self.states = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
	};
	 
	/** 
	 * 
	 */
	self.maskCnpj = function(v) {
		self.customer.cpfCnpj = MaskService.cnpj(v); 
	};	

	/** 
	 * 
	 */
	self.maskDddPhone = function(v) {
		self.phone.number = MaskService.dddPhone(v);  
	};	
	
	
	/**
	 * Salvar Cliente
	 */ 
	self.save = function(customer) {
		CustomerService.saveParams(customer).then(function(resp) {
			self.customer = resp.data;
			self.message = "Gravado com sucesso!";
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};
	
	/**
	 * Show Modal Address
	 */
	self.showAddressModal = function(address) {
		if(address == null || address == undefined) {
			self.address = {};
			self.address.id = 0;
		} else {
			self.address = address;
			for(var i = 0; i <= self.states.length-1; i++) {
				if(self.states[i].id == self.address.state.id) {
					self.address.state = self.states[i];
					break;
				}
			}
		}
		$('#idAddressModal').modal('show');
	};
	
	/**
	 * Salvar Cliente
	 */ 
	self.saveAddress = function(address) {
		address.people = {};
		address.people.id = self.customer.id;
		
		// Salvar endereco
		AddressService.saveParams(address).then(function(resp) {
			$('#idAddressModal').modal('hide');
			self.message = "Endereço gravado com sucesso!";
			return resp;
		}).then(function(respAddress) {
			// Apos salvar endereco recarrega a lista dos mesmos
			AddressService.getListByPeople(respAddress.data.people).then(function(resp) {
				self.addresses = resp.data;
			}, function(error) {
				self.messageError = JSON.stringify(error);
				alert(error.data);
			});
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};	
	
	/**
	 * Show Modal Address
	 */
	self.showPhoneModal = function(phone) {
		if(phone == null || phone == undefined) {
			self.phone = {};
			self.phone.id = 0;
		} else {
			
			self.phone = phone;
	
			for(var i = 0; i <= self.contactTypes.length-1; i++) { 
				if(self.contactTypes[i].type == self.phone.contactType) {
					self.phone.contactType = self.contactTypes[i].type;
				}
			}
			
		}
		$('#idPhoneModal').modal('show');
	};	
	
	/**
	 * Salvar Tel
	 */ 
	self.savePhone = function(phone) {
		phone.people = {};
		phone.people.id = self.customer.id;
		
		// Salvar endereco
		TelephoneService.saveParams(phone).then(function(resp) {
			$('#idPhoneModal').modal('hide');
			self.message = "Telefone gravado com sucesso";
			return resp;
		}).then(function(respPhone) {
			// Apos salvar endereco recarrega a lista dos mesmos
			TelephoneService.getListByPeople(respPhone.data.people).then(function(resp) {
				self.phones = resp.data;
			}, function(error) {
				self.messageError = JSON.stringify(error);
				alert(error.data);
			});
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};		
	
	/**
	 * delete address or desactive
	 */
	self.deleteAddress = function(address) {
		var _confirm = confirm("Deseja Excluir endereço ?");
		if(_confirm == false)
			return; 
		AddressService.deleteAddress(address).then(function(resp) {
			var index = self.addresses.indexOf(address);
			self.addresses.splice(index, 1);
			self.message = "Endereço excluido com sucesso";
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};
	
	/**
	 * delete telephone or desactive
	 */
	self.deleteTelephone = function(telephone) {
		var _confirm = confirm("Deseja Excluir telefone ?");
		if(_confirm == false)
			return; 
		TelephoneService.deleteTelephone(telephone).then(function(resp) {
			var index = self.phones.indexOf(telephone);
			self.phones.splice(index, 1);
			self.message = "Telefone excluido com sucesso!";
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};
	
	init();
	
}]);