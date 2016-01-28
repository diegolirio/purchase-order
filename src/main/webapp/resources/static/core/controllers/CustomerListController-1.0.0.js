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
	
	init();
	
}]);