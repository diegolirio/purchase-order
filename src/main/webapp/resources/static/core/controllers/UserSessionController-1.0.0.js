/**
 * 
 */
app.controller('UserSessionController', ['UserLoginService', function(UserLoginService) {
	
	var self = this;
	
	var init = function() {

		UserLoginService.getSession().then(function(resp) {
			self.userLogged = resp.data;
			// nao for maior q zero
			if(!self.userLogged.id > 0) 
				window.location.href = SERVER_APP;
		}, function(error) {
			if (error.status == 401)
				window.location.href = SERVER_APP;
			else
				alert(JSON.stringify(error));
		});
	};

	
	/**
	 * 
	 */
	self.logout = function() {
		UserLoginService.logout().then(function(resp) {
			window.location.href = SERVER_APP;
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);