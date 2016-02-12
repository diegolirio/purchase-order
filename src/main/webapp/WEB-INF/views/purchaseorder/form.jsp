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
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-danger">CNPJ &nbsp;&nbsp; <a href ng-click="poFormCtrl.showModalSearchCustomer('R')" class="text-right"><span class="glyphicon glyphicon-search"></span></a></label>
			                                          <input type="text" class="form-control" name="cpfCnpjSender" ng-model="poFormCtrl.cpfCnpjSender" required="required"
			                                                 ng-blur="poFormCtrl.getCustomerSenderByCpfCnpj(poFormCtrl.cpfCnpjSender)">
			                                      </div>
			                                      <div class="col-md-4 form-group">
			                                          <label class="text-danger">Razão Social</label>
			                                          <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.nameSender">
			                                      </div>
			                                      <div class="col-md-4 form-group">
			                                          <label class="text-danger">Endereço</label>
			                                          <select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.customerAddressSender" 
			                                          		  ng-options="a.publicPlace+', '+a.number+' - '+a.neighborhood+' - '+a.city+' - '+a.state.abbreviation for a in poFormCtrl.addressesSender" 
			                                          		  required="required"></select>
			                                      </div>		
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-danger">Telefone</label>
			                                          <select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.phoneSender" 
			                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesSender" 
			                                          		  required="required"></select>
			                                      </div>		
			                                      <button class="pull-right btn btn-primary" ng-disabled="formR.$invalid">Avançar</button>                           
				                              </div>
				                         </section>
				                   </form>     
				                   <form role="form" name="formD" ng-submit="poFormCtrl.formVisible = poFormCtrl.TRANSPORTADORA" >
				                     
										 <section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.DESTINATARIO">
				                              <header class="panel-heading">
				                                  <h4 class="text-primary">Destinatário</h4>
				                              </header>
				                              <div class="panel-body">
				                              	  <div class="row">
				                                      <div class="col-md-2 form-group">
				                                          <label class="text-success">CNPJ &nbsp;&nbsp; <a href ng-click="poFormCtrl.showModalSearchCustomer('D')" class="text-right"><span class="glyphicon glyphicon-search"></span></a></label>
				                                          <input type="text" class="form-control" ng-model="poFormCtrl.cpfCnpjRecipient" required="required"
				                                                 ng-blur="poFormCtrl.getCustomerRecipientByCpfCnpj(poFormCtrl.cpfCnpjRecipient)">
				                                      </div>
				                                      <div class="col-md-3 form-group">
				                                          <label class="text-success">Razão Social</label>
				                                          <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.nameRecipient">
				                                      </div>
				                                      <div class="col-md-3 form-group">
				                                          <label class="text-success">Endereço</label>
				                                          <select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.customerAddressRecipient" 
				                                          		  ng-options="a.publicPlace+', '+a.number+' - '+a.neighborhood+' - '+a.city+' - '+a.state.abbreviation for a in poFormCtrl.addressesRecipient" 
				                                          		  required="required"></select>
				                                      </div>			                                      
				                                      <div class="col-md-2 form-group">
				                                          <label class="text-success">Telefone</label>
				                                          <select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.phoneRecipient" 
				                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesRecipient" 
				                                          		  required="required"></select>
				                                      </div>	
				                                      <div class="col-md-2 form-group">
				                                          <label class="text-success">Fax</label>
				                                          <select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.faxRecipient" 
				                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesRecipient" 
				                                          		  required="required"></select>
				                                      </div>		         
			                                      </div>
			                                      <div class="row">
				                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.REMETENTE" class="btn btn-default">Voltar</a>                             		                                 
				                                      <button class="pull-right btn btn-primary" ng-disabled="formD.$invalid">Avançar</button>                             		                                 
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
			                                      <div class="col-md-3 form-group">
			                                          <label class="text-info">CNPJ &nbsp;&nbsp; <a href ng-click="poFormCtrl.showModalSearchCustomer('T')" class="text-right"><span class="glyphicon glyphicon-search"></span></a></label>
			                                          <input type="text" class="form-control" ng-model="poFormCtrl.purchaseOrder.shippingCompany.cpfCnpj" required="required"
				                                             ng-blur="poFormCtrl.getShippingCompanyByCpfCnpj(poFormCtrl.purchaseOrder.shippingCompany.cpfCnpj)">
			                                      </div>
			                                      <div class="col-md-7 form-group">
			                                          <label class="text-info">Razão Social</label>
			                                          <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.shippingCompany.name">
			                                      </div>
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-info">Telefone</label>
			                                          <select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.phoneShippingCompany" 
			                                          		  ng-options="phone.number as phone.number+' - '+phone.contactType for phone in poFormCtrl.phonesShippingCompany" 
			                                          		  required="required"></select>
			                                      </div>	
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.DESTINATARIO" class="btn btn-default">Voltar</a>                             		                                 
			                                      <button class="pull-right btn btn-primary" ng-disabled="formT.$invalid">Avançar</button> 			                                      		                                 
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
					                                    <div class="col-md-1 form-group">
					                                        <label>Numero</label>
					                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.id">
					                                    </div>
					                                    <div class="col-md-2 form-group">
					                                        <label>Data</label>
					                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.emissionDate">
					                                    </div>
					                                    <div class="col-md-2 form-group">
					                                        <label>Frete (Pagador)</label>
															<select class="form-control m-b-10" ng-model="poFormCtrl.purchaseOrder.typeFreight" required="required">
															      <option value=""></option>
															      <option value="R">Remetente</option>
															      <option value="D">Destinatário</option>
															</select>			                                          		  	
					                                    </div>
					                                    <div class="col-md-1 form-group">
					                                        <label title="Condições de pagamento">Condições Pagto</label>
					                                        <input type="text" class="form-control" ng-model="poFormCtrl.purchaseOrder.condicaoPagamento" required="required">
					                                    </div>
					                                    <div class="col-md-6 form-group">
					                                        <label>Observação</label>
					                                        <input type="text" class="form-control" ng-model="poFormCtrl.purchaseOrder.remark">
					                                    </div>
					                              </div>
					                              <div class="row">
				                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.TRANSPORTADORA" class="btn btn-default">Voltar</a>                             		                                 
				                                      <button class="pull-right btn btn-primary" ng-disabled="formPO.$invalid">Avançar</a> 				                                    
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
				                                          <label >Cod. <span ng-show="poFormCtrl.productOK == true" class="glyphicon glyphicon-ok text-success"></span> </label>
				                                          <input required="required" class="form-control" ng-model="poFormCtrl.orderProduct.product.code" ng-blur="poFormCtrl.findProductByCode(poFormCtrl.orderProduct.product.code)">
				                                      </div>
				                                      <div class="col-md-7 form-group">
				                                          <label >Descrição</label>
				                                          <input required="required" class="form-control" ng-model="poFormCtrl.orderProduct.product.description">
				                                      </div>
				                                      <div class="col-md-2 form-group">
				                                          <label >Quantidade</label>
				                                          <input required="required" type="text" class="form-control" ng-model="poFormCtrl.orderProduct.amount">
				                                      </div>
				                                      <br/>
				                                      <button class="btn btn-lg btn-success" ng-disabled="formProduct.$invalid">Adicionar</button>  
				                                      <a href ng-click="poFormCtrl.showFormModalProduct()" class="btn btn-lg btn-info pull-right">Novo Produto</a>  
												   </form>			                                      
												   <table class="table table-bordered">
				                                        <tr>
				                                            <th class="text-center" style="width: 50px">Cod.</th>
				                                            <th class="text-center">Descrição</th>
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
				                                      
				                                    <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PEDIDO" class="btn btn-default">Voltar</a> 
				                                    <button ng-disabled="poFormCtrl.ordersProducts.length == 0" ng-click="poFormCtrl.formVisible = poFormCtrl.EFETIVAR" class="pull-right btn btn-primary">Avançar</button>   
				                                      			                                 
				                              </div>
				                         </section>		                                  
                                  
	                          			<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.EFETIVAR">
			                        	      <header class="panel-heading">
			                            	      <h1 class="text-danger">Deseja Efetivar Pedido ?</h1>
			                              	  </header>
			                              	  <div class="panel-body">
			                              	  		<div class="row">
					                                    <div class="col-md-1 form-group">
					                                        <label>Numero</label>
					                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.id">
					                                    </div>
					                                    <div class="col-md-2 form-group">
					                                        <label>Data</label>
					                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.emissionDate">
					                                    </div>
					                                    <div class="col-md-2 form-group">
					                                        <label>Frete (Pagador)</label>
					                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.typeFreight">
					                                    </div>
					                                    <div class="col-md-1 form-group">
					                                        <label title="Condições de pagamento">Condições Pagto</label>
					                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.condicaoPagamento">
					                                    </div>
					                                    <div class="col-md-12 form-group">
					                                        <label>Observação</label>
					                                        <input type="text" class="form-control" disabled="disabled" ng-model="poFormCtrl.purchaseOrder.remark">
					                                    </div>
					                              </div>
					                              <div class="row">
				                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PRODUTOS" class="btn btn-default">Voltar</a>                             		                                 
				                                      <a href ng-click="poFormCtrl.completedPO(poFormCtrl.purchaseOrder)" class="pull-right btn btn-success">Efetivar</a> 				                                    
				                              	  </div>
				                              </div>
				                              
				                        </section>	                                  
	
	                          			<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.MESSAGE"> 
		                        	      <header class="panel-heading">
		                            	      <h1 class="text-primary">Pedido Concluído com sucesso!!!</h1>
		                              	  </header>
		                              	  	  <div class="row">
		                              	  	  		<h5>
		                              	  	  			Email enviado para: 
		                              	  	  			<br/>{{ poFormCtrl.purchaseOrder.customerAddressSender.people.email }}
		                              	  	  			<br/>{{ poFormCtrl.purchaseOrder.customerAddressRecipient.people.email }}
		                              	  	  		</h5>
		                              	  	  </div>
				                              <div class="row">
			                                      <a href="#/pedidos" class="btn btn-default">Voltar</a>                             		                                 
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
							          <div class="form-group col-md-2">
							            <label class="control-label">ID:</label>
							            <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.product.id" >
							          </div> 
							          <div class="form-group col-md-4">
							            <label class="control-label">Código:</label>
							            <input type="text" class="form-control" ng-model="poFormCtrl.product.code" >
							          </div>					 		          
							          <div class="form-group col-md-12">
							            <label class="control-label">Descrição:</label>
							            <input type="text" class="form-control" ng-model="poFormCtrl.product.description" >
							          </div>
							          <div class="form-group col-md-4">
							            <label class="control-label">Valor:</label>
							            <input type="text" class="form-control" ng-model="poFormCtrl.product.valueUnit" >
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
                    
					<!-- #### Modal Product #### -->
					<div class="modal fade" id="idSearchCustomerModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title">Consulta de Cliente <small>( {{ poFormCtrl.typeSearchCustomer == 'R' ? 'Remetente' : poFormCtrl.typeSearchCustomer == 'D' ? 'Destinatário' : 'Transportadora' }} )</small> </h4>
					      </div>
					      <div class="modal-body">
						        <form ng-submit="poFormCtrl.findCustomerByCpfCnpjOrName(poFormCtrl.searchCustomer.cpfCnpj, poFormCtrl.searchCustomer.name)">
						          <div class="form-group col-md-4">
						            <label class="control-label">CPF/CNPJ:</label>
						            <input type="text" class="form-control" ng-model="poFormCtrl.searchCustomer.cpfCnpj" >
						          </div>					 	 	          
						          <div class="form-group col-md-6">
						            <label class="control-label">Razão Social:</label>
						            <input type="text" class="form-control" ng-model="poFormCtrl.searchCustomer.name" >
						          </div>
						          <br/>
  						          <button class="btn btn-default btn-lg "><span class="glyphicon glyphicon-search"></span></button>
						        </form>
							    <table class="table table-bordered">
                                       <tr>
                                           <th class="text-center" style="width: 50px">Cpf/Cnpj</th>
                                           <th class="text-center">Razão Social</th>
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
					        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->                    
                    
                    
                </section><!-- /.content -->