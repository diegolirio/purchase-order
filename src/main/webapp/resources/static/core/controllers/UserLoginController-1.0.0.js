/**
 * 
 */
app.controller('UserLoginController', ['UserLoginService', function(UserLoginService) {
	
	var self = this;
	
	var init = function() {

		// TODO TEMP
		self.user = {};
		self.user.login = "admin";
		self.user.password = "admin@2016";
		 
		UserLoginService.getSession().then(function(resp) {
			self.userLogged = resp.data;
			if(self.userLogged.id > 0) 
				window.location.href = SERVER_APP;
		}, function(error) {
			if (error.status != 401)
				alert(JSON.stringify(error));
		});
	};
	
	/**
	 * 
	 */
	self.login = function(user) {
		UserLoginService.login(user).then(function(resp) {
			self.userLogged = resp.data;
			window.location.href = SERVER_APP;
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);