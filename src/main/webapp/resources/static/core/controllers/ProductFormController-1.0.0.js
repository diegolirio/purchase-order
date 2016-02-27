/**
 * 
 */
app.controller('ProductFormController', ['$routeParams', 'ProductService', 'ProductTypeService', 
                                          function($routeParams, ProductService, ProductTypeService) {
	
	var self = this;

	self.message = null;
	self.messageError = null;
	
	var init = function() {
		if($routeParams.id > 0) {
			 
		}
		
		ProductTypeService.getAll().then(function(resp) {
			self.productTypes = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
	};
	
	 
	init();
	
}]);