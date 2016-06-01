/**
 * AngularJS modulo de configuracao e rotas
 */

var app = angular.module('app', ['ngRoute']);

var SERVER_APP = '/pedido';

app.config(['$routeProvider', '$httpProvider', 
            function($routeProvider, $httpProvider) {
	  
	$routeProvider
		.when('/',           { templateUrl: SERVER_APP + '/purchaseorder/page/list'})//{ templateUrl: SERVER_APP + '/home'})
		.when('/pedidos',    { templateUrl: SERVER_APP + '/purchaseorder/page/list'})
		.when('/pedido',     { templateUrl: SERVER_APP + '/purchaseorder/page/form'})
		.when('/pedido/:id', { templateUrl: SERVER_APP + '/purchaseorder/page/form'})
		.when('/pedido/edit/:id', { templateUrl: SERVER_APP + '/purchaseorder/page/edit'})
		// Customer
		.when('/clientes',     { templateUrl: SERVER_APP + '/customer/page/list'})
		.when('/cliente',      { templateUrl: SERVER_APP + '/customer/page/form'})
		.when('/cliente/:id',  { templateUrl: SERVER_APP + '/customer/page/form'})
		// Product
		.when('/produtos',     { templateUrl: SERVER_APP + '/product/page/list'})
		.when('/produto',      { templateUrl: SERVER_APP + '/product/page/form'})
		.when('/produto/:id',      { templateUrl: SERVER_APP + '/product/page/form'})
		// User
		.when('/usuario/perfil', { templateUrl: SERVER_APP + '/user/profile'})
		// Settings
		.when('/configuracoes', { templateUrl: SERVER_APP + '/settings'})
		;
	
	/* ******************** Interceptor ******************** */
	$httpProvider.responseInterceptors.push('HttpInterceptor');
    /* ******************** Loading Gif ******************** */ 
    var spinnerFunction = function (data) {
            $('#spinner').show();
    		//$rootScope.spinnerVisibled = true;
            return data; 
    };      
    $httpProvider.defaults.transformRequest.push(spinnerFunction); 		
	

}]);  

 

app.factory('HttpInterceptor',['$q', 
                              function($q) { 
	/********************************************************************************************
     * Tratamento do retorno do response(ajax)...
	 ********************************************************************************************/	  	
	return function (promise) { 
		return promise.then(function (resp) {
			$('#spinner').hide();
			//$rootScope.spinnerVisibled = true;
			return resp;
		}, function (errorResp) {
			$('#spinner').hide();
			//$rootScope.spinnerVisibled = true;
			return $q.reject(errorResp);
		});
	};

}]);
