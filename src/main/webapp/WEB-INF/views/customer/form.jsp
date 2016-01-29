                <!-- Main content -->
                <section class="content" ng-controller="CustomerFormController as cFormCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-light-blue">
                                    Cliente
                                </header>
                                <div class="panel-body">
                                
										<section class="panel">
				                              <header class="panel-heading">
				                                  <span class="text-success">Cliente</span>
				                              </header>
				                              <div class="panel-body">
													<form role="form" ng-submit="cFormCtrl.save(cFormCtrl.customer)">
					                                      <div class="row">
						                                      <div class="col-md-1 form-group">
						                                          <label class="text-danger">ID</label>
						                                          <input type="text" class="form-control" readonly="readonly" ng-model="cFormCtrl.customer.id">
						                                      </div>
						                                      <div class="col-md-2 form-group">
						                                          <label class="text-danger">CNPJ</label>
						                                          <input type="text" class="form-control" ng-model="cFormCtrl.customer.cpfCnpj">
						                                      </div>
						                                      <div class="col-md-4 form-group">
						                                          <label class="text-danger">Razão Social</label>
						                                          <input type="text" class="form-control"  ng-model="cFormCtrl.customer.name">
						                                      </div>
						                                      <div class="col-md-2 form-group">
						                                          <label class="text-danger">Inscrição Estadual</label>
						                                          <input type="text" class="form-control" ng-model="cFormCtrl.customer.signUpState">
						                                      </div>
						                                      <br/>
						                                      <button type="submit" class="btn btn-lg btn-success">Salvar</button>
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
				                                      <a href class="pull-right btn btn-primary">Novo</a> 
				                                      <br/><br/>                           		                                 
				                              	  </div>
				                              	  <div class="row">
				                                    <table class="table table-bordered">
				                                        <tr class="text-danger">
				                                            <th class="text-center" style="width: 10px">#</th>
				                                            <th class="text-center">Logradouro</th>
				                                            <th class="text-center">Numero</th>
				                                            <th class="text-center">Bairro</th>
				                                            <th class="text-center">Cidade</th>
				                                            <th class="text-center">Estado</th>
				                                            <th class="text-center" style="width: 10px">editar</th>
				                                        </tr>
				                                        <tr ng-repeat="a in cFormCtrl.addresses">
				                                            <td>{{ a.id }}</td>
				                                            <td>{{ a.publicPlace }}</td> 
				                                            <td>{{ a.number }}</td> 
				                                            <td>{{ a.neighborhood }}</td>
				                                            <td>{{ a.city }}</td>
				                                            <td>{{ a.state.abbreviation }}</td>
				                                            <td><a href="#/endereco/{{a.id}}"><span class="badge bg-red">editar</span></a></td>
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
			                                      <a href class="pull-right btn btn-info">Novo</a>
			                                      <br/><br/> 	
				                                    <table class="table table-bordered">
				                                        <tr class="text-danger">
				                                            <th class="text-center" style="width: 10px">#</th>
				                                            <th class="text-center">Numero</th>
				                                            <th class="text-center">Tipo</th>
				                                            <th class="text-center" style="width: 10px">editar</th>
				                                        </tr>
				                                        <tr ng-repeat="p in cFormCtrl.phones">
				                                            <td>{{ p.id }}</td>
				                                            <td>{{ p.number }}</td> 
				                                            <td>{{ p.contactType }}</td> 
				                                            <td><a href="#/telefone/{{p.id}}"><span class="badge bg-red">editar</span></a></td>
				                                        </tr>
				                                    </table>				                                      
				                              </div>
				                         </section>				                           
				                           
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->