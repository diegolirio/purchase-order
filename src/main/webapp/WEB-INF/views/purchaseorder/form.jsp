                <!-- Main content -->
                <section class="content" ng-controller="PurchaseOrderFormController as poFormCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-green">
                                    Pedido
                                </header>
                                <div class="panel-body">
                                
                                
                                   <form role="form" name="formR" ng-submit="poFormCtrl.formVisible = poFormCtrl.DESTINATARIO" >
	                                   
										<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.REMETENTE">
				                              <header class="panel-heading">
				                                  <h4 class="text-primary">Remetente</h4>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="col-md-4 form-group">
			                                          <label class="text-danger">CNPJ &nbsp;&nbsp; <a href ng-click="poFormCtrl.showModalSearchCustomer('R')" class="text-right"><span class="glyphicon glyphicon-search"></span></a></label>
			                                          <input type="text" class="form-control input-lg" name="cpfCnpjSender" ng-model="poFormCtrl.cpfCnpjSender" required="required" maxlength="18"
			                                                 ng-blur="poFormCtrl.getCustomerSenderByCpfCnpj(poFormCtrl.cpfCnpjSender)" ng-keyup="poFormCtrl.maskCnpjSender(poFormCtrl.cpfCnpjSender)">
			                                      </div>
			                                      <div class="col-md-8 form-group">
			                                          <label class="text-danger">Raz&atilde;o Social</label>
			                                          <input type="text" class="form-control input-lg" readonly="readonly" ng-model="poFormCtrl.nameSender">
			                                      </div>
			                                      <div class="col-md-8 form-group">
			                                          <label class="text-danger">Endere&ccedil;o</label>
			                                          <select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.customerAddressSender" 
			                                          		  ng-options="a.publicPlace+', '+a.number+' - '+a.neighborhood+' - '+a.city+' - '+a.state.abbreviation for a in poFormCtrl.addressesSender" 
			                                          		  required="required"></select>
			                                      </div>		
			                                      <div class="col-md-4 form-group">
			                                          <label class="text-danger">Telefone</label>
			                                          <select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.phoneSender" 
			                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesSender" 
			                                          		  required="required"></select>
			                                      </div>		
			                                      <button class="pull-right btn btn-primary" ng-disabled="formR.$invalid">Avan&ccedil;ar</button>                           
				                              </div>
				                         </section>
				                   </form>     
				                   <form role="form" name="formD" ng-submit="poFormCtrl.formVisible = poFormCtrl.TRANSPORTADORA" >
				                     
										 <section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.DESTINATARIO">
				                              <header class="panel-heading">
				                                  <h4 class="text-primary">Destinat&aacute;rio</h4>
				                              </header>
				                              <div class="panel-body">
				                              	  <div class="row">
				                                      <div class="col-md-4 form-group">
				                                          <label class="text-success">CNPJ &nbsp;&nbsp; <a href ng-click="poFormCtrl.showModalSearchCustomer('D')" class="text-right"><span class="glyphicon glyphicon-search"></span></a></label>
				                                          <input type="text" class="form-control input-lg" ng-model="poFormCtrl.cpfCnpjRecipient" required="required"
				                                                 ng-blur="poFormCtrl.getCustomerRecipientByCpfCnpj(poFormCtrl.cpfCnpjRecipient)" 
				                                                 ng-keyup="poFormCtrl.maskCnpjRecipient(poFormCtrl.cpfCnpjRecipient)">
				                                      </div>
				                                      <div class="col-md-8 form-group">
				                                          <label class="text-success">Raz&atilde;o Social</label>
				                                          <input type="text" class="form-control input-lg" readonly="readonly" ng-model="poFormCtrl.nameRecipient">
				                                      </div>
				                                      <div class="col-md-6 form-group">
				                                          <label class="text-success">Endere&ccedil;o</label>
				                                          <select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.customerAddressRecipient" 
				                                          		  ng-options="a.publicPlace+', '+a.number+' - '+a.neighborhood+' - '+a.city+' - '+a.state.abbreviation for a in poFormCtrl.addressesRecipient" 
				                                          		  required="required"></select>
				                                      </div>			                                      
				                                      <div class="col-md-3 form-group">
				                                          <label class="text-success">Telefone</label>
				                                          <select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.phoneRecipient" 
				                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesRecipient" 
				                                          		  required="required"></select>
				                                      </div>	
				                                      <div class="col-md-3 form-group">
				                                          <label class="text-success">Contato</label>
				                                          <input type="text" class="form-control input-lg" ng-model="poFormCtrl.purchaseOrder.contactRecipient" >
				                                      </div>		         
			                                      </div>
			                                      <div class="row">
				                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.REMETENTE" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>                             		                                 
				                                      <button class="pull-right btn btn-primary" ng-disabled="formD.$invalid">Avan&ccedil;ar</button>                             		                                 
				                              	  </div>
				                              </div>
				                           </section>
				                    </form>
				                    <form role="form" name="formT" ng-submit="poFormCtrl.formVisible = poFormCtrl.PEDIDO" >
				                           
										<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.TRANSPORTADORA">
				                              <header class="panel-heading">
				                                  <h4 class="text-info">Transportadora</h4>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="col-md-4 form-group">
			                                          <label class="text-info">CNPJ &nbsp;&nbsp; <a href ng-click="poFormCtrl.showModalSearchCustomer('T')" class="text-right"><span class="glyphicon glyphicon-search"></span></a></label>
			                                          <input type="text" class="form-control input-lg" ng-model="poFormCtrl.cpfCnpjShippingCompany" required="required" 
				                                             ng-blur="poFormCtrl.getShippingCompanyByCpfCnpj(poFormCtrl.cpfCnpjShippingCompany)"
				                                             ng-keyup="poFormCtrl.maskShippingCompanyCpfCnpj(poFormCtrl.cpfCnpjShippingCompany)">
			                                      </div>
			                                      <div class="col-md-8 form-group">
			                                          <label class="text-info">Raz&atilde;o Social</label>
			                                          <input type="text" class="form-control input-lg" readonly="readonly" ng-model="poFormCtrl.shippingCompanyName">
			                                      </div>
			                                      <div class="col-md-8 form-group">
			                                          <label class="text-success">Endere&ccedil;o</label>
			                                          <select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.customerAddressShippingCompany" required="required" 
			                                          		  ng-options="a.publicPlace+', '+a.number+' - '+a.neighborhood+' - '+a.city+' - '+a.state.abbreviation for a in poFormCtrl.addressesShippingCompany" ></select>
			                                      </div>			  			                                      
			                                      <div class="col-md-4 form-group">
			                                          <label class="text-info">Telefone</label>
			                                          <select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.phoneShippingCompany" 
			                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesShippingCompany" 
			                                          		  ></select>
			                                      </div>	
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.DESTINATARIO" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>                             		                                 
			                                      <button class="pull-right btn btn-primary" ng-disabled="formT.$invalid">Avan&ccedil;ar</button> 			                                      		                                 
				                              </div>
				                         </section>				                           
				                     </form>
				                     <form role="form" name="formPO" ng-submit="poFormCtrl.savePurchaseOrder(poFormCtrl.purchaseOrder)"  >
				                     
	                          			<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.PEDIDO">
			                        	      <header class="panel-heading">
			                            	      <h4>Pedido</h4>
			                              	  </header>
			                              	  <div class="panel-body">
			                              	  		<div class="row">
					                                    <div class="col-md-2 form-group">
					                                        <label class="text-primary">Numero</label>
					                                        <input type="text" class="form-control input-lg" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.id">
					                                    </div>
					                                    <div class="col-md-3 form-group">
					                                        <label class="text-primary">Data</label>
					                                        <input type="date" class="form-control input-lg" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.emissionDate">
					                                    </div>
					                                    <div class="col-md-3 form-group">
					                                        <label class="text-primary">Frete (Pagador)</label>
															<select class="form-control m-b-10 input-lg" ng-model="poFormCtrl.purchaseOrder.typeFreight" required="required">
															      <option value=""></option>
															      <option value="R">Remetente</option>
															      <option value="D">Destinat&aacute;rio</option>
															</select>			                                          		  	
					                                    </div>
					                                    <div class="col-md-4 form-group">
					                                        <label title="Condições de pagamento" class="text-primary">Condi&ccedil;&otilde;es Pagto</label>
					                                        <input type="text" class="form-control input-lg" ng-model="poFormCtrl.purchaseOrder.condicaoPagamento" required="required">
					                                    </div>

					                                    <div class="col-md-9 form-group">
					                                        <label class="text-primary">Observa&ccedil;&atilde;o</label>
					                                        <input type="text" class="form-control input-lg" ng-model="poFormCtrl.purchaseOrder.remark">
					                                    </div>
					                                    <div class="col-md-3 form-group">
					                                        <label class="text-primary">Representante</label>
					                                        <input type="text" class="form-control input-lg" ng-model="poFormCtrl.purchaseOrder.representative">
					                                    </div>					                                    
					                              </div>
					                              <div class="row">
				                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.TRANSPORTADORA" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>                             		                                 
				                                      <button class="pull-right btn btn-primary" ng-disabled="formPO.$invalid">Avan&ccedil;ar</a> 				                                    
				                              	  </div>
				                              </div>
				                              
				                        </section>				                           
				                           
                                  </form>
                                  <br/>
                                  
										<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.PRODUTOS">
				                              <header class="panel-heading">
				                                  <h4 >Produtos</h4>
				                              </header>
				                              <div class="panel-body">
				                              	  <form role="form" name="formProduct" ng-submit="poFormCtrl.addOrderProduct(poFormCtrl.orderProduct)" >
				                                      <div class="col-md-1 form-group">
				                                          <label class="text-success">Cod. <span ng-show="poFormCtrl.productOK == true" class="glyphicon glyphicon-ok text-success"></span> </label>
				                                          <input required="required" class="form-control input-lg" ng-model="poFormCtrl.orderProduct.product.code" ng-blur="poFormCtrl.findProductByCode(poFormCtrl.orderProduct.product.code)">
				                                      </div>
				                                      <div class="form-group col-md-6">
				                                          <label class="text-success">Descri&ccedil;&atilde;o &nbsp;&nbsp;<a href ng-click="poFormCtrl.showModalSearchProduct(poFormCtrl.orderProduct.product.description)" class="text-right"><span class="glyphicon glyphicon-search"></span></a> </label>
				                                          <input required="required" class="form-control input-lg" ng-model="poFormCtrl.orderProduct.product.description">
				                                      </div>
				                                      <div class="col-md-2 form-group">
				                                          <label class="text-success">Quantidade</label>
				                                          <input required="required" type="text" class="form-control input-lg" ng-model="poFormCtrl.orderProduct.amount">
				                                      </div>
				                                      <div class="col-md-3 form-group">
					                                      <br/>
					                                      <button class="btn  btn-success btn-lg" ng-disabled="formProduct.$invalid">Adicionar</button>  
					                                      <a href ng-click="poFormCtrl.showFormModalProduct()" class="btn  btn-info pull-right btn-lg">Novo Produto</a>
					                                  </div>  
												   </form>			                                      
												   <table class="table table-bordered">
				                                        <tr>
				                                            <th class="text-center" style="width: 50px">Cod.</th>
				                                            <th class="text-center">Descri&ccedil;&atilde;o</th>
				                                            <th class="text-center" style="width: 100px">Valor Unit.</th>
				                                            <th class="text-center" style="width: 60px">Qtde</th>
				                                            <th class="text-center" style="width: 200px">Valor Total</th>
				                                            <th class="text-center" style="width: 40px"></th>
				                                        </tr>
				                                        <tr ng-repeat="item in poFormCtrl.ordersProducts">
				                                            <td class="text-center">{{ item.product.code }}</td>
				                                            <td>{{ item.product.description }}</td>
				                                            <td class="text-right">{{ item.valueUnit | currency }}</td>
				                                            <td class="text-center">{{ item.amount }}</td>
				                                            <td class="text-right">{{ item.valueUnit * item.amount | currency }}</td>
				                                            <td><a href ng-click="poFormCtrl.deleteOrderProduct(item)" ><span class="glyphicon glyphicon-trash text-danger"></span></a></td>
				                                        </tr>
				                                        <tfoot>
				                                        	<tr>
					                                            <td colspan="5" class="text-right"> <b><span class="text-success">Total do Pedido:</span> {{ poFormCtrl.totalPO | currency }}</b> </td>
					                                            <td></td>
					                                        </tr>			                                        
				                                        </tfoot>
				                                    </table>
				                                      
				                                    <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PEDIDO" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a> 
				                                    <button ng-disabled="poFormCtrl.ordersProducts.length == 0" ng-click="poFormCtrl.formVisible = poFormCtrl.EFETIVAR" class="pull-right btn btn-primary">Avan&ccedil;ar</button>   
				                                      			                                 
				                              </div>
				                         </section>		                                  
                                  
	                          			<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.EFETIVAR">
			                        	      <header class="panel-heading">
			                            	      <h2 class="text-warning">Deseja Efetivar Pedido ?</h2>
			                              	  </header>			                              	  
			                              	  <div class="panel-body">
			                              	  		<div class="panel panel-info">
													  <div class="panel-heading">Pedido</div>
													  <div class="panel-body">
			                                    			<div class="col-md-1 form-group">
						                                        <label class="text-primary">Numero</label>
						                                        <input type="text" class="form-control " disabled="disabled" value="{{poFormCtrl.purchaseOrder.id}}">
						                                    </div>
						                                    <div class="col-md-2 form-group">
						                                        <label class="text-primary">Data</label>
						                                        <input type="date" class="form-control" disabled="disabled" value="{{poFormCtrl.purchaseOrder.emissionDate}}">
						                                    </div>
						                                    <div class="col-md-2 form-group">
						                                        <label class="text-primary">Frete (Pagador)</label>
						                                        <input type="text" class="form-control" disabled="disabled" value="{{poFormCtrl.purchaseOrder.typeFreight == 'R' ? 'Remetente' : 'Destinat&aacute;rio'}}">
						                                    </div>
						                                    <div class="col-md-3 form-group">
						                                        <label title="Condições de pagamento" class="text-primary">Condi&ccedil;&otilde;es Pagto</label>
						                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.condicaoPagamento">
						                                    </div>
						                                    <div class="col-md-3 form-group">
						                                        <label title="Representante" class="text-primary">Representante</label>
						                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.representative">
						                                    </div>
						                                    <div class="col-md-5 form-group">
						                                    	
						                                    </div>
						                                    <div class="col-md-12 form-group">
						                                        <label class="text-primary">Observa&ccedil;&atilde;o</label>
						                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.remark">
						                                    </div>
													
                              	  					
					                                      <div class="col-md-2 form-group">
					                                          <label class="text-danger">CNPJ Remetente</label>
					                                          <input type="text" class="form-control" value="{{poFormCtrl.cpfCnpjSender}}" disabled="disabled">
					                                      </div>
					                                      <div class="col-md-4 form-group">
					                                          <label class="text-danger">Raz&atilde;o Social Remetente</label>
					                                          <input type="text" class="form-control" readonly="readonly" value="{{poFormCtrl.nameSender}}">
					                                      </div>
					                                      <div class="col-md-4 form-group">
					                                          <label class="text-danger">Endere&ccedil;o Remetente</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.customerAddressSender.publicPlace+', '+poFormCtrl.purchaseOrder.customerAddressSender.number+' - '+poFormCtrl.purchaseOrder.customerAddressSender.neighborhood+' - '+poFormCtrl.purchaseOrder.customerAddressSender.city+' - '+poFormCtrl.purchaseOrder.customerAddressSender.state.abbreviation}}">
					                                      </div>		
					                                      <div class="col-md-2 form-group">
					                                          <label class="text-danger">Telefone Remetente</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.phoneSender}}">
					                                      </div>	

					                                      <div class="col-md-2 form-group">
					                                          <label class="text-success">CNPJ Destinat&aacute;rio</label>
					                                          <input type="text" class="form-control" value="{{poFormCtrl.cpfCnpjRecipient}}" disabled="disabled">
					                                      </div>
					                                      <div class="col-md-3 form-group">
					                                          <label class="text-success">Raz&atilde;o Social Destinat&aacute;rio</label>
					                                          <input type="text" class="form-control" readonly="readonly" value="{{poFormCtrl.nameRecipient}}">
					                                      </div>
					                                      <div class="col-md-3 form-group">
					                                          <label class="text-success">Endere&ccedil;o Destinat&aacute;rio</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.customerAddressRecipient.publicPlace+', '+poFormCtrl.purchaseOrder.customerAddressRecipient.number+' - '+poFormCtrl.purchaseOrder.customerAddressRecipient.neighborhood+' - '+poFormCtrl.purchaseOrder.customerAddressRecipient.city+' - '+poFormCtrl.purchaseOrder.customerAddressRecipient.state.abbreviation}}">
					                                      </div>		
					                                      <div class="col-md-2 form-group">
					                                          <label class="text-success">Telefone Destinat&aacute;rio</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.phoneRecipient}}">
					                                      </div>	 
					                                      <div class="col-md-2 form-group">
					                                          <label class="text-success">Contato no Destinat&aacute;rio</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.contactRecipient}}">
					                                      </div>	

					                                      <div class="col-md-2 form-group">
					                                          <label class="text-warning">CNPJ Transportadora</label>
					                                          <input type="text" class="form-control" value="{{poFormCtrl.cpfCnpjShippingCompany}}" disabled="disabled">
					                                      </div>
					                                      <div class="col-md-4 form-group">
					                                          <label class="text-warning">Raz&atilde;o Social Transportadora</label>
					                                          <input type="text" class="form-control" readonly="readonly" value="{{poFormCtrl.shippingCompanyName}}">
					                                      </div>
					                                      <div class="col-md-4 form-group">
					                                          <label class="text-warning">Endere&ccedil;o Transportadora</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.customerAddressShippingCompany.publicPlace+', '+poFormCtrl.purchaseOrder.customerAddressShippingCompany.number+' - '+poFormCtrl.purchaseOrder.customerAddressShippingCompany.neighborhood+' - '+poFormCtrl.purchaseOrder.customerAddressShippingCompany.city+' - '+poFormCtrl.purchaseOrder.customerAddressShippingCompany.state.abbreviation}}">
					                                      </div>		
					                                      <div class="col-md-2 form-group">
					                                          <label class="text-warning">Telefone Transportadora</label>
					                                          <input type="text" class="form-control" readonly="readonly" 
					                                              value="{{poFormCtrl.purchaseOrder.phoneShippingCompany}}">
					                                      </div>	

														  <table class="table table-bordered">
						                                        <tr>
						                                            <th class="text-center text-primary" colspan="5" >Produtos</th>
						                                        </tr>
						                                        <tr>
						                                            <th class="text-center" style="width: 50px">Cod.</th>
						                                            <th>Descri&ccedil;&atilde;o</th>
						                                            <th class="text-center" style="width: 100px">Valor Unit.</th>
						                                            <th class="text-center" style="width: 60px">Qtde</th>
						                                            <th class="text-center" style="width: 200px">Valor Total</th>
						                                        </tr>
						                                        <tr ng-repeat="item in poFormCtrl.ordersProducts">
						                                            <td class="text-center">{{ item.product.code }}</td>
						                                            <td>{{ item.product.description }}</td>
						                                            <td class="text-right">{{ item.valueUnit | currency }}</td>
						                                            <td class="text-center">{{ item.amount }}</td>
						                                            <td class="text-right">{{ item.valueUnit * item.amount | currency }}</td>
						                                        </tr>
						                                        <tfoot>
						                                        	<tr>
							                                            <td colspan="5" class="text-right"> <b><span class="text-success">Total do Pedido:</span> {{ poFormCtrl.totalPO | currency }}</b> </td>
							                                        </tr>			                                        
						                                        </tfoot>
						                                    </table>
													  </div>
													</div>	
												    <div class="row"> 
				                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PRODUTOS" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>
				                                      <div class="pull-right">
				                                      		<a href="${pageContext.request.contextPath}/purchaseorder/{{poFormCtrl.purchaseOrder.id}}/print/pdf" target="_blank" class="btn btn-default">Pr&eacute;-visualiza&ccedil;&atilde;o do Pedido</a>
				                                      		<a href ng-click="poFormCtrl.completedPO(poFormCtrl.purchaseOrder)" class="btn btn-success">Efetivar</a> 				                                    
				                                      </div>                             		                                 
				                              	    </div>
			                              	  		
				                              </div>
				                              
				                        </section>	                                  
	
	                          			<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.MESSAGE"> 
		                        	      <header class="panel-heading">
		                            	      <h2 class="text-primary">Pedido Concluído com sucesso!!!</h2>
		                              	  </header>
		                              	  	  <div class="row">
		                              	  	  		<div class="col-md-offset-1">
		                              	  	  			<h2 class="text-success">Email enviado para:</h2> 
		                              	  	  			<h4>{{ poFormCtrl.purchaseOrder.customerAddressSender.people.email }}</h4>
		                              	  	  			<h4>{{ poFormCtrl.purchaseOrder.customerAddressRecipient.people.email }}</h4>
		                              	  	  		</div>
		                              	  	  </div>
				                              <div class="row">
			                                      <a href="#/pedidos" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>                             		                                 
			                              	  </div>
			                        	</section>	
	
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                    
                    
					<!-- #### Modal Product #### -->
					<div class="modal fade" id="idProductModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="gridSystemModalLabel">Cadastro de Produto</h4>
					      </div>
					      <div class="modal-body">
						        <form>
						        	<div class="row">
<!-- 							          <div class="form-group col-md-2"> -->
<!-- 							            <label class="control-label">ID:</label> -->
<!-- 							            <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.product.id" > -->
<!-- 							          </div>  -->
							          <div class="form-group col-md-3">
							            <label class="control-label">C&oacute;digo:</label>
							            <input type="text" class="form-control" ng-model="poFormCtrl.product.code" >
							          </div>					 		          
							          <div class="form-group col-md-9">
							            <label class="control-label">Descri&ccedil;&atilde;o:</label>
							            <input type="text" class="form-control" ng-model="poFormCtrl.product.description" >
							          </div>
							          <div class="form-group col-md-4">
							            <label class="control-label">Valor:</label>
							            <input type="text" class="form-control" ng-model="poFormCtrl.product.valueUnit" ng-keyup="poFormCtrl.maskCurrency(poFormCtrl.product.valueUnit)">
							          </div>	
    								  <div class="form-group col-md-4">
							            <label class="control-label">Tipo:</label>
	                                            <select class="form-control m-b-10" ng-model="poFormCtrl.product.productType" 
	                                          		  ng-options="t.description for t in poFormCtrl.productTypes" 
	                                          		  required="required"></select>
							          </div>							          
                                     							          						          
							        </div>
						        </form>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					        <button type="button" class="btn btn-primary" ng-click="poFormCtrl.saveProduct(poFormCtrl.product)">Salvar</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->                    
                    
					<!-- #### Modal Search Product #### -->
					<div class="modal fade" id="idSearchProductModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title">Pesquisa de Produtos</h4>
					      </div>
					      <div class="modal-body">

							        <form ng-submit="poFormCtrl.findProductByCodeOrDescription(poFormCtrl.productSearch)">
						                <div class="input-group col-md-12">
						                    <input ng-model="poFormCtrl.productSearch" type="search" class="form-control input-lg" placeholder="pesquisar..." />
						                    <span class="input-group-btn">
						                        <button class="btn btn-default btn-lg">
						                            <i class="glyphicon glyphicon-search"></i>
						                        </button>
						                    </span>
						                </div> 
							        </form>  
							        <br/>
								    <table class="table table-bordered">
                                       <tr>
                                           <th class="text-center" style="width: 50px">C&oacute;digo</th>
                                           <th class="text-center">Descri&ccedil;&atilde;o</th>
                                           <th class="text-center">Valor</th>
                                           <th class="text-center" style="width:40px"></th>
                                       </tr>
                                       <tr ng-repeat="p in poFormCtrl.products">
                                           <td class="text-center">{{ p.code }}</td>
                                           <td>{{ p.description }}</td>
                                           <td class="text-right">{{ p.valueUnit | currency }}</td>
                                           <td><a href ng-click="poFormCtrl.selectedProduct(p)" ><span class="glyphicon glyphicon-ok text-success"></span></a></td>
                                       </tr>
    	                            </table>

					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->                    
                    
					<!-- #### Modal Customer #### -->
					<div class="modal fade" id="idSearchCustomerModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title">Consulta de Cliente <small>( {{ poFormCtrl.typeSearchCustomer == 'R' ? 'Remetente' : poFormCtrl.typeSearchCustomer == 'D' ? 'Destinat&aacute;rio' : 'Transportadora' }} )</small> </h4>
					      </div>
					      <div class="modal-body">
						        <form ng-submit="poFormCtrl.findCustomerByCpfCnpjOrName(poFormCtrl.searchCustomer.cpfCnpj, poFormCtrl.searchCustomer.name)">
						          <div class="form-group col-md-4">
						            <label class="control-label">CPF/CNPJ:</label>
						            <input type="text" class="form-control input-lg" ng-model="poFormCtrl.searchCustomer.cpfCnpj" >
						          </div>					 	 	          
						          <div class="form-group col-md-6">
						            <label class="control-label">Raz&atilde;o Social:</label>
						            <input type="text" class="form-control input-lg" ng-model="poFormCtrl.searchCustomer.name" >
						          </div>
						          <br/>
  						          <button class="btn btn-default btn-lg"><span class="glyphicon glyphicon-search"></span></button>
						        </form>
							    <table class="table table-bordered">
                                       <tr>
                                           <th class="text-center" style="width: 50px">Cpf/Cnpj</th>
                                           <th class="text-center">Raz&atilde;o Social</th>
                                           <th class="text-center" style="width: 40px"></th>
                                       </tr>
                                       <tr ng-repeat="c in poFormCtrl.customers">
                                           <td class="text-center">{{ c.cpfCnpj }}</td>
                                           <td>{{ c.name }}</td>
                                           <td><a href ng-click="poFormCtrl.selectedCustomer(c)" ><span class="glyphicon glyphicon-ok text-success"></span></a></td>
                                       </tr>
                                </table>						        
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" onClick="javascript:$('#idAddCustomerModal').modal('show');"><i class="glyphicon glyphicon-plus"></i>  Novo</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->                    
                
                </section><!-- /.content -->