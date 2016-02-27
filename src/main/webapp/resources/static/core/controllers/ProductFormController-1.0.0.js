/**
 * 
 */
app.controller('ProductFormController', ['$routeParams', 'ProductService', 
                                          function($routeParams, ProductService) {
	
	var self = this;

	self.message = null;
	self.messageError = null;
	
	var init = function() {
		if($routeParams.id > 0) {
			ProductService.get($routeParams.id).then(function(resp) {
				self.product = resp.data;
				return resp;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}
	};
	
	/**
	 * Salvar Cliente
	 */ 
	self.save = function(product) {
		ProductService.saveParams(product).then(function(resp) {
			self.product = resp.data;
			self.message = "Gravado com sucesso!";
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};
	
}]);