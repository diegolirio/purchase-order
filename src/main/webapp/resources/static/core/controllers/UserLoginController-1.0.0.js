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
	
	/* function: _GET
	 * Funcao para pegar o valor do parametro da URL
	 */
	self.GetParam = function(name) {
		var url = window.location.search.replace("?", "");
		var itens = url.split("&");
		for(n in itens) {
			if( itens[n].match(name) ) {
				return decodeURIComponent(itens[n].replace(name+"=", ""));
			}
		}
		return null;
	}
	
	/**
	 * realiza login 
	 */
	self.login = function(user) {
		UserLoginService.login(user).then(function(resp) {
			self.userLogged = resp.data;
			var paramNext = self.GetParam('next');
			window.location.href = paramNext == null ? SERVER_APP : paramNext;
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);