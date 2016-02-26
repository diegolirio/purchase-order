/**
 * 
 */
app.controller('CustomerListController', ['CustomerService', function(CustomerService) {
	
	var self = this;
	
	var init = function() {
		CustomerService.getAll().then(function(resp) {
			self.customers = resp.data;
		});
	};
	
	/**
	 * Busca avanacada dos clientes
	 */
	self.findCustomerAdvanced = function(fieldSearch) {
		CustomerService.findAdvanced(fieldSearch).then(function(resp) {
			self.customers = resp.data;
			console.log(self.customers);
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);