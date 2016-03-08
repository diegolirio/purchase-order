                <!-- Main content -->
                <section class="content" ng-controller="CustomerFormController as cFormCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-red">
                                    Cliente
                                </header>
                                <div class="panel-body">
                                
                                
                                		<div class="alert alert-success" role="alert" ng-show="cFormCtrl.message != null" ng-click="cFormCtrl.message = null">
                                			<button type="button" class="close" ng-click="cFormCtrl.message = null"><span aria-hidden="true">&times;</span></button>
											{{ cFormCtrl.message }}
										</div>
                                
										<section class="panel">
				                              <header class="panel-heading">
				                                  <span class="text-success">Cliente</span>
				                              </header>
				                              <div class="panel-body">
													<form role="form" ng-submit="cFormCtrl.save(cFormCtrl.customer)" name="formCustomer">
					                                      <div class="row">
<!-- 						                                      <div class="col-md-1 form-group"> -->
<!-- 						                                          <label class="text-danger">ID</label> -->
<!-- 						                                          <input type="text" class="form-control" readonly="readonly" ng-model="cFormCtrl.customer.id"> -->
<!-- 						                                      </div> -->
						                                      <div class="col-md-2 form-group">
						                                          <label class="text-danger">CNPJ</label>
						                                          <input type="text" class="form-control input-lg" ng-model="cFormCtrl.customer.cpfCnpj" ng-keyup="cFormCtrl.maskCnpj(cFormCtrl.customer.cpfCnpj)" maxlength="18" required="required">
						                                      </div>
						                                      <div class="col-md-4 form-group">
						                                          <label class="text-danger">Razão Social</label>
						                                          <input type="text" class="form-control input-lg"  ng-model="cFormCtrl.customer.name" required="required">
						                                      </div>
						                                      <div class="col-md-4 form-group">
						                                          <label class="text-danger">Email</label>
						                                          <input type="email" class="form-control input-lg"  ng-model="cFormCtrl.customer.email" required="required">
						                                      </div>
						                                      <div class="col-md-2 form-group">
						                                          <label class="text-danger">Inscrição Estadual</label>
						                                          <input type="text" class="form-control input-lg" ng-model="cFormCtrl.customer.signUpState">
						                                      </div>
						                                      <br/>
						                                      <div class="pull-right">
						                                      		<button type="submit" class="btn  btn-success" ng-disabled="formCustomer.$invalid">Salvar</button>
						                                      </div>
														  </div>
													</form>
		                              		   </div>
				                         </section>
				                          
										 <section class="panel" ng-show="cFormCtrl.customer.id > 0">
				                              <header class="panel-heading">
				                                  <span class="text-primary">Endereços</span>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="row">
				                                      <a href ng-click="cFormCtrl.showAddressModal()" class="pull-right btn btn-primary">Novo</a> 
				                                      <br/><br/>                           		                                 
				                              	  </div>
				                              	  <div class="row">
				                                    <table class="table table-bordered">
				                                        <tr class="text-danger">
<!-- 				                                            <th class="text-center" style="width: 10px">#</th> -->
				                                            <th class="text-center">Logradouro</th>
				                                            <th class="text-center">Numero</th>
				                                            <th class="text-center">Bairro</th>
				                                            <th class="text-center">Cidade</th>
				                                            <th class="text-center">Estado</th>
				                                            <th class="text-center" style="width: 10px">editar</th>
				                                            <th class="text-center" style="width: 10px"></th>
				                                        </tr>
				                                        <tr ng-repeat="a in cFormCtrl.addresses">
<!-- 				                                            <td>{{ a.id }}</td> -->
				                                            <td>{{ a.publicPlace }}</td> 
				                                            <td>{{ a.number }}</td> 
				                                            <td>{{ a.neighborhood }}</td>
				                                            <td>{{ a.city }}</td>
				                                            <td>{{ a.state.abbreviation }}</td>
				                                            <td><a href ng-click="cFormCtrl.showAddressModal(a)"><span class="badge bg-red">editar</span></a></td>
				                                            <td><a href ng-click="cFormCtrl.deleteAddress(a)"><span class="glyphicon glyphicon-trash text-danger"></span></a></td>
				                                        </tr>
				                                    </table>			                                      		                                      		                                 
			                              	  
			                                      </div>
				                              </div>
				                           </section>
				                           
										<section class="panel" ng-show="cFormCtrl.customer.id > 0">
				                              <header class="panel-heading">
				                                  <span class="text-info">Telefones</span>
				                              </header>
				                              <div class="panel-body">
			                                      <a href ng-click="cFormCtrl.showPhoneModal()" class="pull-right btn btn-info">Novo</a>
			                                      <br/><br/> 	
				                                    <table class="table table-bordered">
				                                        <tr class="text-danger">
<!-- 				                                            <th class="text-center" style="width: 10px">#</th> -->
				                                            <th class="text-center">Numero</th>
				                                            <th class="text-center">Tipo</th>
				                                            <th class="text-center" style="width: 10px">editar</th>
				                                            <th class="text-center" style="width: 10px"></th>
				                                        </tr>
				                                        <tr ng-repeat="p in cFormCtrl.phones">
<!-- 				                                            <td>{{ p.id }}</td> -->
				                                            <td>{{ p.number }}</td>  
				                                            <td>{{ p.contactType }}</td> 
				                                            <td><a href ng-click="cFormCtrl.showPhoneModal(p)"><span class="badge bg-red">editar</span></a></td>
				                                            <td><a href ng-click="cFormCtrl.deleteTelephone(p)"><span class="glyphicon glyphicon-trash text-danger"></span></a></td>
				                                        </tr>
				                                    </table>				                                      
				                              </div>
				                         </section>				                           
				                           
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
	
	
					<!-- #### Modal Endereco #### -->
					<div class="modal fade" id="idAddressModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="gridSystemModalLabel">Cadastro de Endereço</h4>
					      </div>
					      <div class="modal-body">
						        <form>
						        	<div class="row">
							          <div class="form-group col-md-2">
							            <label class="control-label">ID:</label>
							            <input type="text" class="form-control" readonly="readonly" ng-model="cFormCtrl.address.id" >
							          </div> 
							          <div class="form-group col-md-4">
							            <label class="control-label">Cep:</label>
							            <input type="text" class="form-control" ng-model="cFormCtrl.address.cep" >
							          </div>					 		          
							        </div>
							        <div class="row">
							          <div class="form-group col-md-10">
							            <label class="control-label">Logradouro: <small class="text-muted">Ex: Rua Av. Paulista</small></label>
							            <input type="text" class="form-control" ng-model="cFormCtrl.address.publicPlace" >
							          </div>
							          <div class="form-group col-md-2">
							            <label class="control-label">Nº</label>
							            <input type="text" class="form-control" ng-model="cFormCtrl.address.number" >
							          </div>
							        </div>
							        <div class="row">
							          <div class="form-group col-md-12">
							            <label class="control-label">Bairro:</label>
							            <input type="text" class="form-control" ng-model="cFormCtrl.address.neighborhood" >
							          </div>
							        </div>
							        <div class="row">
							          <div class="form-group col-md-10">
							            <label class="control-label">Cidade:</label>
							            <input type="text" class="form-control" ng-model="cFormCtrl.address.city" >
							          </div>
							          <div class="form-group col-md-2">
							            <label class="control-label">UF:</label>
                                        <select class="form-control m-b-10" ng-model="cFormCtrl.address.state" 
                                        		  ng-options="s.abbreviation for s in cFormCtrl.states"
                                        		  required="required"></select>							            
							          </div>
							        </div>
						        </form>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					        <button type="button" class="btn btn-primary" ng-click="cFormCtrl.saveAddress(cFormCtrl.address)">Salvar</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->


					<!-- #### Modal Telefone #### -->
					<div class="modal fade" id="idPhoneModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="gridSystemModalLabel">Cadastro de Telefone</h4>
					      </div>
					      <div class="modal-body">
						        <form>
						        	<div class="row">
<!-- 							          <div class="form-group col-md-2"> -->
<!-- 							            <label class="control-label">ID:</label> -->
<!-- 							            <input type="text" class="form-control" readonly="readonly" ng-model="cFormCtrl.phone.id" > -->
<!-- 							          </div>  -->
							          <div class="form-group col-md-4">
							            <label class="control-label">Numero:</label>
							            <input type="text" class="form-control" ng-model="cFormCtrl.phone.number" >
							          </div>					 		          
							          <div class="form-group col-md-4">
							            <label class="control-label">Tipo:</label>
										<select ng-model="cFormCtrl.phone.contactType" class="form-control"
												ng-options="ct.type as ct.type for ct in cFormCtrl.contactTypes">
										</select>	                                 
							          </div>							          
							        </div>
						        </form>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					        <button type="button" class="btn btn-primary" ng-click="cFormCtrl.savePhone(cFormCtrl.phone)">Salvar</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->


                </section><!-- /.content -->
