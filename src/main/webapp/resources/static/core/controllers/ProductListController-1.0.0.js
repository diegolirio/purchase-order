/**
 * 
 */
app.controller('ProductListController', ['ProductService', function(ProductService) {
	
	var self = this;
	
	var init = function() {
		ProductService.getAll().then(function(resp) {
			self.products = resp.data;
		});
	};
	
	init();
	
}]);