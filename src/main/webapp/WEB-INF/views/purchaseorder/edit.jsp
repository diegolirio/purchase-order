                <!-- Main content -->
                <section class="content" ng-controller="PurchaseOrderEditController as poEditCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-green">
                                    Pedido <span class="label label-danger">{{ poEditCtrl.purchaseOrder.id }}</span>
                                </header>
                                <div class="panel-body"> 
                                   			<div class="col-md-1 form-group">
		                                        <label class="text-primary">Numero</label>
		                                        <input type="text" class="form-control " disabled="disabled" value="{{poEditCtrl.purchaseOrder.id}}">
		                                    </div>
		                                    <div class="col-md-2 form-group">
		                                        <label class="text-primary">Data</label>
		                                        <input type="text" class="form-control" disabled="disabled" value="{{poEditCtrl.purchaseOrder.emissionDate}}">
		                                    </div>
		                                    <div class="col-md-2 form-group">
		                                        <label class="text-primary">Frete (Pagador)</label>
		                                        <input type="text" class="form-control" disabled="disabled" value="{{poEditCtrl.purchaseOrder.typeFreight == 'R' ? 'Remetente' : 'Destinatário'}}">
		                                    </div>
		                                    <div class="col-md-2 form-group">
		                                        <label title="Condições de pagamento" class="text-primary">Condições Pagto</label>
		                                        <input type="text" class="form-control" disabled="disabled" ng-model="poEditCtrl.purchaseOrder.condicaoPagamento">
		                                    </div>
		                                    <div class="col-md-12 form-group">
		                                        <label class="text-primary">Observação</label>
		                                        <input type="text" class="form-control" disabled="disabled" ng-model="poEditCtrl.purchaseOrder.remark">
		                                    </div>
									
                          	  					
	                                      <div class="col-md-2 form-group">
	                                          <label class="text-danger">CNPJ Remetente</label>
	                                          <input type="text" class="form-control" value="{{poEditCtrl.purchaseOrder.customerAddressSender.people.cpfCnpj}}" disabled="disabled">
	                                      </div>
	                                      <div class="col-md-4 form-group">
	                                          <label class="text-danger">Razão Social Remetente</label>
	                                          <input type="text" class="form-control" readonly="readonly" value="{{poEditCtrl.purchaseOrder.customerAddressSender.people.name}}">
	                                      </div>
	                                      <div class="col-md-4 form-group">
	                                          <label class="text-danger">Endereço Remetente</label>
	                                          <input type="text" class="form-control" readonly="readonly" 
	                                              value="{{poEditCtrl.purchaseOrder.customerAddressSender.publicPlace+', '+poEditCtrl.purchaseOrder.customerAddressSender.number+' - '+poEditCtrl.purchaseOrder.customerAddressSender.neighborhood+' - '+poEditCtrl.purchaseOrder.customerAddressSender.city+' - '+poEditCtrl.purchaseOrder.customerAddressSender.state.abbreviation}}">
	                                      </div>		
	                                      <div class="col-md-2 form-group">
	                                          <label class="text-danger">Telefone Remetente</label>
	                                          <input type="text" class="form-control" readonly="readonly" 
	                                              value="{{poEditCtrl.purchaseOrder.phoneSender}}">
	                                      </div>	

	                                      <div class="col-md-2 form-group">
	                                          <label class="text-success">CNPJ Destinatário</label>
	                                          <input type="text" class="form-control" value="{{poEditCtrl.purchaseOrder.customerAddressRecipient.people.cpfCnpj}}" disabled="disabled">
	                                      </div>
	                                      <div class="col-md-3 form-group">
	                                          <label class="text-success">Razão Social Destinatário</label>
	                                          <input type="text" class="form-control" readonly="readonly" value="{{poEditCtrl.purchaseOrder.customerAddressRecipient.people.name}}">
	                                      </div>
	                                      <div class="col-md-3 form-group">
	                                          <label class="text-success">Endereço Destinatário</label>
	                                          <input type="text" class="form-control" readonly="readonly" 
	                                              value="{{poEditCtrl.purchaseOrder.customerAddressRecipient.publicPlace+', '+poEditCtrl.purchaseOrder.customerAddressRecipient.number+' - '+poEditCtrl.purchaseOrder.customerAddressRecipient.neighborhood+' - '+poEditCtrl.purchaseOrder.customerAddressRecipient.city+' - '+poEditCtrl.purchaseOrder.customerAddressRecipient.state.abbreviation}}">
	                                      </div>		
	                                      <div class="col-md-2 form-group">
	                                          <label class="text-success">Telefone Destinatário</label>
	                                          <input type="text" class="form-control" readonly="readonly" 
	                                              value="{{poEditCtrl.purchaseOrder.phoneRecipient}}">
	                                      </div>	 
	                                      <div class="col-md-2 form-group">
	                                          <label class="text-success">Fax Destinatário</label>
	                                          <input type="text" class="form-control" readonly="readonly" 
	                                              value="{{poEditCtrl.purchaseOrder.faxRecipient}}">
	                                      </div>	

										  <table class="table table-bordered">
		                                        <tr>
		                                            <th class="text-center text-primary" colspan="5" >Produtos</th>
		                                        </tr>
		                                        <tr>
		                                            <th class="text-center" style="width: 50px">Cod.</th>
		                                            <th>Descrição</th>
		                                            <th class="text-center" style="width: 100px">Valor Unit.</th>
		                                            <th class="text-center" style="width: 60px">Qtde</th>
		                                            <th class="text-center" style="width: 200px">Valor Total</th>
		                                        </tr>
		                                        <tr ng-repeat="item in poEditCtrl.ordersProducts">
		                                            <td class="text-center">{{ item.product.code }}</td>
		                                            <td>{{ item.product.description }}</td>
		                                            <td class="text-right">{{ item.valueUnit | currency }}</td>
		                                            <td class="text-center">{{ item.amount }}</td>
		                                            <td class="text-right">{{ item.valueUnit * item.amount | currency }}</td>
		                                        </tr>
		                                        <tfoot>
		                                        	<tr>
			                                            <td colspan="5" class="text-right"> <b><span class="text-success">Total do Pedido:</span> {{ poEditCtrl.totalPO | currency }}</b> </td>
			                                        </tr>			                                        
		                                        </tfoot>
		                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->