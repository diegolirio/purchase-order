/**
 * 
 */
app.factory('DateCommon', ['$http', function($http) {

	/**
	 * Date today format DD/MM/YYYY
	 */
	var _getToday = function() {
		var date = new Date();
		// DD
		var day = date.getDate();
		day = String(day).length == 1 ? "0"+day : day;
		// MM
		var month = (date.getMonth()+1);
		month = String(month).length == 1 ? "0"+month : month;
		// to format
		var today = day+"/"+month+"/"+date.getFullYear();
		return today;
	};
	 
	/**
	 * Date today subtract
	 */
	var _getTodaySubtract = function(dd) {
		var date = new Date();
		date.setDate(date.getDate()-dd);  
		// DD
		var day = date.getDate();
		day = String(day).length == 1 ? "0"+day : day;
		console.log(day);
		// MM
		var month = (date.getMonth()+1);
		month = String(month).length == 1 ? "0"+month : month;
		// to format
		var today = day+"/"+month+"/"+date.getFullYear();
		return today;
	};
	
	/**
	 * Date today add
	 */
	var _getTodayAdd = function(dd) {
		var date = new Date();
		date.setDate(date.getDate()+dd);  
		// DD
		var day = date.getDate();
		day = String(day).length == 1 ? "0"+day : day;
		console.log(day);
		// MM
		var month = (date.getMonth()+1);
		month = String(month).length == 1 ? "0"+month : month;
		// to format
		var today = day+"/"+month+"/"+date.getFullYear();
		return today;
	};

	
	return {

		getToday : _getToday,
		
		getTodaySubtract : _getTodaySubtract
		
	};
	
}]);
