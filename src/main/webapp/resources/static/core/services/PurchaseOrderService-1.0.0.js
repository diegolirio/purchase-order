/**
 * 
 */
app.factory('PurchaseOrderService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/purchaseorder' + url;
	};
	
	/**
	 * pega todos os pedidos
	 */
	var _getAll = function() {
		return $http.get(serverURL('/get/all'));
	};
	
	/**
	 * salvar P.O
	 */
	var _save = function(purchaseOrder) {
		return $http.post(serverURL('/save'), purchaseOrder);
	}
	
	/**
	 * salvar P.O Params
	 */
	var _saveParams = function(purchaseOrder) {
		if(purchaseOrder.id == undefined) purchaseOrder.id = 0;
		//if(purchaseOrder.emissionDate == undefined) {
		//	var date = new Date();
		//	purchaseOrder.emissionDate = date.getFullYear()+'-'+date.getMonth()+1+'-0'+date.getDate();
		//}
		var params = "?id="+purchaseOrder.id+
					 "&customerAddressSender.id="+purchaseOrder.customerAddressSender.id+
					 "&phoneSender="+purchaseOrder.phoneSender+
					 "&customerAddressRecipient.id="+purchaseOrder.customerAddressRecipient.id+
					 "&phoneRecipient="+purchaseOrder.phoneRecipient+
					 "&faxRecipient="+purchaseOrder.faxRecipient+
					 "&condicaoPagamento="+purchaseOrder.condicaoPagamento+
					 "&shippingCompany.id="+purchaseOrder.shippingCompany.id+
					 "&phoneShippingCompany="+purchaseOrder.phoneShippingCompany+
					 "&typeFreight="+purchaseOrder.typeFreight+
					 "&remark="+purchaseOrder.remark;
					 //"&emissionDate="+purchaseOrder.emissionDate;
		return $http.post(serverURL('/saveParams')+params);
	}
	
	return {
		
		getAll : _getAll,
		
		save : _save,
		
		saveParams : _saveParams
		
	};
	
}]);