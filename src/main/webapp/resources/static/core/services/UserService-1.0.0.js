/**
 * UsuarioService
 */
app.factory('UserService', ['$http', function($http) {
	
	/*
	 * Save
	 */
	var _save = function(user) {
		return $http.post(SERVER_APP+'/user/save');
	};
	
	/*
	 * SaveParams
	 */
	var _saveParams = function(user) {
		var _params = "?id="+user.id+"&name="+user.name+"&email="+user.email+"&login="+user.login+
					  "&cnpj="+user.cnpj;
		return $http.post(SERVER_APP+'/user/save/my/user/params'+_params);
	};
	
	/*
	 * Acesso publico
	 */
	return {
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);