/**
 * 
 */
app.controller('ProductListController', ['$route', 'ProductService', function($route, ProductService) {
	
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
	
	/**
	 * Delete Product
	 */
	self.deleteProduct = function(product) {
		var _confirm = confirm('Deseja realmente excluir produto ?');
		if(_confirm == false) 
			return;
		ProductService.deleteProduct(product).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert(JSON.stringify(error)); 
		}); 
	};	
	
	init();
	
}]);