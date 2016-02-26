/**
 * UsuarioService, camada que acessa o back-end
 */
app.factory('UserLoginService', ['$http', function($http) {
	
	var _getSession = function() {
		return $http.get(SERVER_APP+'/user/login/session');
	};
	
	var _login = function(user) {
		return $http.post(SERVER_APP+'/user/login/temp?login='+user.login+'&password='+user.password);  
	};
	
	/*
	 * Invalida session no back-end
	 */
	var _logout = function() {
		return $http.get(SERVER_APP+'/user/login/logout');
	};
	
	/*
	 * Acesso publico
	 */
	return {
		
		getSession : _getSession,
		
		login : _login,
		
		logout : _logout
		
	};
	
}]);