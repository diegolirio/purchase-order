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

	/**
	 * busca avancada
	 */
	self.findProductAdvanced = function(fieldSearch) {
		ProductService.findAdvanced(fieldSearch).then(function(resp) {
			self.products = resp.data; 
			console.log(self.products);
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);