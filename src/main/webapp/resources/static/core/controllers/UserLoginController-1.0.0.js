/**
 * 
 */
app.controller('UserLoginController', ['UserLoginService', function(UserLoginService) {
	
	var self = this;
	
	self.user.login = "admin";
	self.user.password = "admin@2016";
	
	var init = function() {
		UserLoginService.getSession().then(function(resp) {
			self.userLogged = resp.data;
			if(self.userLogged.id > 0) 
				window.location.href = SERVER_APP;
		}, function(error) {
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