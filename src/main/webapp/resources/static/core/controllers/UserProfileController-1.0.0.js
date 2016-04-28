/**
 * 
 */
app.controller('UserProfileController', ['UserLoginService', 'UserService', 'StringCommon', 'CustomerService',
                                         function(UserLoginService, UserService, StringCommon, CustomerService) {
	
	var self = this;
	
	var init = function() {
		 
		UserLoginService.getSession().then(function(resp) {
			self.user = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	/**
	 * Show Modal Customer Sender
	 */
	self.showModalMyCompany = function() {
		$('#idSearchModalMyCompany').modal('show');
	};	
	
	/**
	 * pesquisa cliente
	 */ 
	self.findCustomerByCpfCnpjOrName = function(cpfCnpj, name) {
		alert(cpfCnpj); 
		if (StringCommon.isEmpty(cpfCnpj) && StringCommon.isEmpty(name)) {
			alert('Campos em branco');
			return;
		} 
		if (StringCommon.isEmpty(cpfCnpj)) cpfCnpj = "NULLO";
		if (StringCommon.isEmpty(name)) name = "NULLO";
		CustomerService.findByCpfCnpjOrName(cpfCnpj, name).then(function(resp) {
			console.log(resp.data);  
			self.customers = resp.data;
			if(self.customers.length == 0) return;  
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};	
	
	/**
	 * save user
	 */
	self.save = function(user) {
		UserService.saveParams(user).then(function(resp) {
			self.user = resp.data;
		}, function(error) {
			
		});
	};
	
	init();
	
}]);