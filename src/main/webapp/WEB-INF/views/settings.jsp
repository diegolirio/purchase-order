                <!-- Main content -->
                <section class="content" ng-controller="SettingsController as sCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-light-blue">
                                    Configurações
                                </header>
                                <div class="panel-body">
                                
                                		<div class="alert alert-success" role="alert" ng-show="sCtrl.message != null" ng-click="sCtrl.message = null">
                                			<button type="button" class="close" ng-click="sCtrl.message = null"><span aria-hidden="true">&times;</span></button>
											{{ sCtrl.message }}
										</div>
                                
										<section class="panel">
				                              <header class="panel-heading">
				                                  <span class="text-success">Envio de Email do Pedido</span>
				                              </header>
				                              <div class="panel-body">
													<form role="form" ng-submit="sCtrl.save(sCtrl.emailSettingsPO)">
					                                      <div class="row">
					                                          <div class="form-group col-md-2">
													            <label class="control-label">Host</label>
													            <input type="text" class="form-control input-lg" ng-model="sCtrl.emailSettingsPO.host" >
													          </div>					 		          
													          <div class="form-group col-md-1">
													            <label class="control-label">Port</label>
													            <input type="text" class="form-control input-lg" ng-model="sCtrl.emailSettingsPO.port" >
													          </div>
													          <div class="form-group col-md-3">
													            <label class="control-label">Username</label>
													            <input type="text" class="form-control input-lg" ng-model="sCtrl.emailSettingsPO.username"> 
													          </div>							          
													          <div class="form-group col-md-3">
													            <label class="control-label">Password</label>
													            <input type="password" class="form-control input-lg" ng-model="sCtrl.emailSettingsPO.password"> 
													          </div>							          
													          <div class="form-group col-md-3">
													            <label class="control-label">From</label>
													            <input type="text" class="form-control input-lg" ng-model="sCtrl.emailSettingsPO.fromEmail"> 
													          </div>					          
						                                      <br/>
														  </div>
														  <div class="pull-right">
										                    <a href class="btn btn-default btn-lg" ng-show="sCtrl.emailSettingsPO.id > 0" ng-click="sCtrl.addShowModal()">Add copias</a>
					                                      	<button type="submit" class="btn btn-success btn-lg">Salvar</button>
					                                      </div>
													</form>
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
					        <h4 class="modal-title" id="gridSystemModalLabel">Cadastro de Endere&ccedil;o</h4>
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

                </section><!-- /.content -->
