/**
 * 
 */
app.factory('StringCommon', ['$http', function($http) {

	var _isEmpty = function(str) {
		if(str == null || str == undefined || str == "null" || str == "")
			return true;
		return false;
	};
	
	return {

		isEmpty : _isEmpty
		
	};
	
}]);
