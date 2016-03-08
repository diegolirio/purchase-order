/**
 * 
 */
app.controller('ProductFormController', ['$routeParams', '$route', 'ProductService', 'ProductTypeService', 'MaskService', 
                                          function($routeParams, $route, ProductService, ProductTypeService, MaskService) {
	
	var self = this;

	self.message = null;
	self.messageError = null;
	
	var init = function() {
		
		if($routeParams.id > 0) {
			ProductService.get($routeParams.id).then(function(resp) {
				self.product = resp.data;
				return resp;
			}).then(function(respProduct) {
				ProductTypeService.getAll().then(function(resp) {
					self.productTypes = resp.data;
					
					for(var i = 0; i <= self.productTypes.length-1; i++) { 
						if(self.productTypes[i].id == self.product.productType.id) {
							self.product.productType = self.productTypes[i];
							break;
						}
					}								
					
				}, function(error) {
					alert(JSON.stringify(error));
				});
			}, function(error) { 
				alert(JSON.stringify(error)); 
			});
		} 
		else {
		
			ProductTypeService.getAll().then(function(resp) {
				self.productTypes = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}
		
	};
	
	/**
	 * Mask currency
	 */
	self.maskCurrency = function(value) {
		self.product.valueUnit = MaskService.currency(value);
 	};
 	
	/**
	 * Salvar Prodct
	 */ 
	self.save = function(product) {
		if(product.id == undefined)
			product.id = 0;
		ProductService.saveParams(product).then(function(resp) {
			console.log(resp);
			self.product = resp.data;
			self.message = "Gravado com sucesso!";
		}, function(error) {
			self.messageError = JSON.stringify(error);
			alert(error.data);
		});
	};
	
	init();
	
}]);