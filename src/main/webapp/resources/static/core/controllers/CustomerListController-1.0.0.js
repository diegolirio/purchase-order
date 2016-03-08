/**
 * 
 */
app.controller('CustomerListController', ['$route', 'CustomerService', 'MaskService',
                                          function($route, CustomerService, MaskService) {
	
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
	
	self.deleteCustomer = function(customer) {
		var _confirm = confirm("Deseja realmente excluir " + customer.name + " ?") ;
		if (_confirm == false)
			return;
		CustomerService.deleteCustomer(customer).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);