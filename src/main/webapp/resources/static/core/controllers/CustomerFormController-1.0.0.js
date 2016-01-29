/**
 * 
 */
app.controller('CustomerFormController', ['$routeParams', 'CustomerService', 'AddressService',
                                          function($routeParams, CustomerService, AddressService) {
	
	var self = this;
	 
	var init = function() {
		if($routeParams.id > 0) {
			CustomerService.get($routeParams.id).then(function(resp) {
				self.customer = resp.data;
				return resp;
			}).then(function(respCustomer) {
				AddressService.getListByPeople(respCustomer.data).then(function(resp) {
					self.addresses = resp.data;
					console.log(self.addresses); 
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
	};
	
	/**
	 * Salvar Cliente
	 */ 
	self.save = function(customer) {
		console.log(customer);
		CustomerService.saveParams(customer).then(function(resp) {
			self.customer = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);