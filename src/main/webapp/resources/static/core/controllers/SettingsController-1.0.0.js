/**
 * 
 */
app.controller('SettingsController', ['EmailSettingsPOService', function(EmailSettingsPOService) {
	
	var self = this;
	
	/**
	 * onLoad 
	 */
	var init = function() {
		EmailSettingsPOService.getMain().then(function(resp) {
			self.emailSettingsPO = resp.data;
			if(self.emailSettingsPO == "null") {
				self.emailSettingsPO = {};
				self.emailSettingsPO.id = 0;
			}
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Save email configuration 
	 */
	self.save = function(emailSettingsPO) {
		EmailSettingsPOService.saveParams(emailSettingsPO).then(function(resp) {
			self.emailSettingsPO = resp.data;
			alert('Configuração de Email gravado com sucesso!'); 
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * call modal add copies
	 */
	self.addShowModal = function() {
		alert('Em desenvolvimento');
	};
	
	init();
	
}]);