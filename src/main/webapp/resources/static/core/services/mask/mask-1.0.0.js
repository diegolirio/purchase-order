/**
 * Máscaras ER 
 * @autor Diego Lirio
 * version 1.0.1 -> add mascara _decimal
 * version 1.0.2 -> add mascara _peso
 * version 1.0.3 -> ...
 */
app.factory('MaskService', ['$http', function($http) {

	
	var _cnpj = function(v) {
	    v=v.replace(/\D/g,"")                           //Remove tudo o que não é numero
	    v=v.replace(/^(\d{2})(\d)/,"$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
	    v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
	    v=v.replace(/\.(\d{3})(\d)/,".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
	    v=v.replace(/(\d{4})(\d)/,"$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
	    return v
	};

	var _num = function(v){
	    v=v.replace(/\D/g,""); //Remove tudo o que não é numero(numero)
	    return v;
	};
	
	var _currency = function(v) {
		v=String(v);
		v=v.replace(/\D/g,"");//Remove tudo o que não é numero
		v=String(Number(v));
		v=v.replace(/(\d)(\d{8})$/,"$1.$2");//coloca o ponto dos milhões
	    v=v.replace(/(\d)(\d{5})$/,"$1.$2");//coloca o ponto dos milhares
	    v=v.replace(/(\d)(\d{2})$/,"$1,$2");//coloca a virgula antes dos 2 últimos dígitos
	    return v;
	};	
	

	return {

		cnpj : _cnpj,
		
		num : _num,
		
		currency : _currency

	};
	
	
}]);
