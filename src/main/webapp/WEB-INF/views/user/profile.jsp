                <!-- Main content -->
                <section class="content" ng-controller="UserProfileController as userProfileCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-light-blue">
                                    Perfil
                                </header>
                                <div class="panel-body">
                                
                                		<div class="alert alert-success" role="alert" ng-show="userProfileCtrl.message != null" ng-click="userProfileCtrl.message = null">
                                			<button type="button" class="close" ng-click="userProfileCtrl.message = null"><span aria-hidden="true">&times;</span></button>
											{{ userProfileCtrl.message }}
										</div>
                                
										<section class="panel">
				                              <header class="panel-heading">
				                                  <span class="text-success">Usuário</span>
				                              </header>
				                              <div class="panel-body">
													<form role="form" ng-submit="userProfileCtrl.save(userProfileCtrl.user)">
					                                      <div class="row">
													          <div class="form-group col-md-1">
													            <label class="control-label">Login:</label>
													            <input type="text" class="form-control input-lg" ng-model="userProfileCtrl.user.login" >
													          </div>					 		          
													          <div class="form-group col-md-5">
													            <label class="control-label">Nome:</label>
													            <input type="text" class="form-control input-lg" ng-model="userProfileCtrl.user.name" >
													          </div>
													          <div class="form-group col-md-3">
													            <label class="control-label">Email:</label>
													            <input type="text" class="form-control input-lg" ng-model="userProfileCtrl.user.email"> 
													          </div>							          
													          <div class="form-group col-md-3">
													            <label class="control-label">
													            	CNPJ: 
													            	<small class="text-primary">Minha empresa</small>
													            	&nbsp;&nbsp; <a href ng-click="userProfileCtrl.showModalMyCompany()" class="text-right"><span class="glyphicon glyphicon-search"></span></a> 
													            </label>
													            <input type="text" class="form-control input-lg" ng-model="userProfileCtrl.user.cnpj" ng-disabled="true"> 
													          </div>							          
						                                      <br/>
														  </div>
														  <div class="row">
					                                      	<button type="submit" class="btn btn-success btn-lg">Salvar</button>
					                                      	<a href class="btn btn-default btn-lg">Alterar Senha</button>
					                                      	<a href class="btn btn-default btn-lg">Empresa</button>
					                                      </div>
													</form>
		                              		   </div>
				                         </section>
				                          
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->

					<!-- #### Modal Customer #### -->
					<div class="modal fade" id="idSearchModalMyCompany" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content"> 
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title">Consulta </h4>
					      </div>
					      <div class="modal-body">
						        <form ng-submit="userProfileCtrl.findCustomerByCpfCnpjOrName(userProfileCtrl.searchCustomer.cpfCnpj, userProfileCtrl.searchCustomer.name)">
						          <div class="form-group col-md-4"> 
						            <label class="control-label">CPF/CNPJ:</label>
						            <input type="text" class="form-control input-lg" ng-model="userProfileCtrl.searchCustomer.cpfCnpj" >
						          </div>					 	 	          
						          <div class="form-group col-md-6">
						            <label class="control-label">Raz&atilde;o Social:</label>
						            <input type="text" class="form-control input-lg" ng-model="userProfileCtrl.searchCustomer.name" >
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
                                       <tr ng-repeat="c in userProfileCtrl.customers">
                                           <td class="text-center">{{ c.cpfCnpj }}</td>
                                           <td>{{ c.name }}</td>
                                           <td><a href ng-click="userProfileCtrl.selectedCustomer(c)" ><span class="glyphicon glyphicon-ok text-success"></span></a></td>
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
