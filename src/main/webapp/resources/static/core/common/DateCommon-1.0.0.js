/**
 * 
 */
app.factory('DateCommon', ['$http', function($http) {

	/**
	 * Date today format DD/MM/YYYY
	 */
	var _getTodayPtBr = function() {
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
	 * Date today format YYYY/MM/DD
	 */
	var _getTodayUsEn = function() {
		var date = new Date();
		// DD
		var day = date.getDate();
		day = String(day).length == 1 ? "0"+day : day;
		// MM
		var month = (date.getMonth()+1);
		month = String(month).length == 1 ? "0"+month : month;
		// to format
		var today =date.getFullYear()+"/"+month+"/" +day;
		return today;
	};	

	/** 
	 * Date today add
	 */
	var _getTodayAddPtBr = function(dd) {
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

	/** 
	 * Date today add
	 */
	var _getTodayAddUsEn = function(dd) {
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
		var today = date.getFullYear()+"/"+month+"/"+day;
		return today;
	};

	
	return {

		getTodayPtBr : _getTodayPtBr,
		
		getTodayUsEn : _getTodayUsEn,

		getTodayAddPtBr : _getTodayAddPtBr,

		getTodayAddUsEn : _getTodayAddUsEn
		
	};
	
}]);
