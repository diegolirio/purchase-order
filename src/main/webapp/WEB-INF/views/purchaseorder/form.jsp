                <!-- Main content -->
                <section class="content" ng-controller="PurchaseOrderFormController as poFormCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-light-blue">
                                    Pedido
                                </header>
                                <div class="panel-body">
                                
                                
                                   <form role="form">
	                                   
										<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.REMETENTE">
				                              <header class="panel-heading">
				                                  <span class="text-danger">Remetente</span>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="col-md-3 form-group">
			                                          <label class="text-danger">CNPJ</label>
			                                          <input type="text" class="form-control" >
			                                      </div>
			                                      <div class="col-md-7 form-group">
			                                          <label class="text-danger">Razão Social</label>
			                                          <input type="text" class="form-control" readonly="readonly">
			                                      </div>
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-danger">Telefone</label>
			                                          <input type="text" class="form-control">
			                                      </div>		
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.DESTINATARIO" class="pull-right btn btn-primary">Avançar</a>  	                                 
				                              </div>
				                         </section>
				                          
										 <section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.DESTINATARIO">
				                              <header class="panel-heading">
				                                  <span class="text-success">Destinatário</span>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="col-md-3 form-group">
			                                          <label class="text-success">CNPJ</label>
			                                          <input type="text" class="form-control">
			                                      </div>
			                                      <div class="col-md-5 form-group">
			                                          <label class="text-success">Razão Social</label>
			                                          <input type="text" class="form-control" readonly="readonly">
			                                      </div>
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-success">Telefone</label>
			                                          <input type="text" class="form-control">
			                                      </div>	
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-success">Fax</label>
			                                          <input type="text" class="form-control">
			                                      </div>		         
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.REMETENTE" class="btn btn-default">Voltar</a>                             		                                 
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.TRANSPORTADORA" class="pull-right btn btn-primary">Avançar</a>                             		                                 
				                              </div>
				                           </section>
				                           
										<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.TRANSPORTADORA">
				                              <header class="panel-heading">
				                                  <span class="text-info">Transportadora</span>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="col-md-3 form-group">
			                                          <label class="text-info">CNPJ</label>
			                                          <input type="text" class="form-control">
			                                      </div>
			                                      <div class="col-md-7 form-group">
			                                          <label class="text-info">Razão Social</label>
			                                          <input type="text" class="form-control" readonly="readonly">
			                                      </div>
			                                      <div class="col-md-2 form-group">
			                                          <label class="text-info">Telefone</label>
			                                          <input type="text" class="form-control">
			                                      </div>	
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.DESTINATARIO" class="btn btn-default">Voltar</a>                             		                                 
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PEDIDO" class="pull-right btn btn-primary">Avançar</a> 			                                      		                                 
				                              </div>
				                         </section>				                           
				                           
	                          			<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.PEDIDO">
			                        	      <header class="panel-heading">
			                            	      Pedido
			                              	  </header>
			                              	  <div class="panel-body">
				                                    <div class="col-md-1 form-group">
				                                        <label>Numero</label>
				                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.id">
				                                    </div>
				                                    <div class="col-md-2 form-group">
				                                        <label>Data</label>
				                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.emissionDate">
				                                    </div>
				                                    <div class="col-md-2 form-group">
				                                        <label>Frete</label>
				                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.emissionDate">
				                                    </div>
				                                    <div class="col-md-2 form-group">
				                                        <label>Condições de Pagamento</label>
				                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.emissionDate">
				                                    </div>
				                                    <div class="col-md-5 form-group">
				                                        <label>Observação</label>
				                                        <input type="text" class="form-control" readonly="readonly" ng-model="poFormCtrl.purchaseOrder.emissionDate">
				                                    </div>
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.TRANSPORTADORA" class="btn btn-default">Voltar</a>                             		                                 
			                                      <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PRODUTOS" class="pull-right btn btn-primary">Avançar</a> 				                                    
				                              </div>
				                        </section>				                           
				                           
                                  </form>
                                  <br/>
                                  
										<section class="panel" ng-show="poFormCtrl.formVisible == poFormCtrl.PRODUTOS">
				                              <header class="panel-heading">
				                                  <span >Produtos</span>
				                              </header>
				                              <div class="panel-body">
			                                      <div class="col-md-1 form-group">
			                                          <label >Cod.</label>
			                                          <input type="text" class="form-control">
			                                      </div>
			                                      <div class="col-md-7 form-group">
			                                          <label >Descrição</label>
			                                          <input type="text" class="form-control">
			                                      </div>
			                                      <div class="col-md-2 form-group">
			                                          <label >Quantidade</label>
			                                          <input type="text" class="form-control">
			                                      </div>
			                                      <br/>
			                                      <button type="submit" class="btn btn-success">Adicionar</button>  
			                                      
												<table class="table table-bordered">
			                                        <tr>
			                                            <th style="width: 10px">Cod.</th>
			                                            <th>Task</th>
			                                            <th>Progress</th>
			                                            <th style="width: 40px">Label</th>
			                                        </tr>
			                                        <tr>
			                                            <td>1.</td>
			                                            <td>Update software</td>
			                                            <td>
			                                                <div class="progress xs">
			                                                    <div class="progress-bar progress-bar-danger" style="width: 55%"></div>
			                                                </div>
			                                            </td>
			                                            <td><span class="badge bg-red">55%</span></td>
			                                        </tr>
			                                        <tr>
			                                            <td>2.</td>
			                                            <td>Clean database</td>
			                                            <td>
			                                                <div class="progress xs">
			                                                    <div class="progress-bar progress-bar-yellow" style="width: 70%"></div>
			                                                </div>
			                                            </td>
			                                            <td><span class="badge bg-yellow">70%</span></td>
			                                        </tr>
			                                        <tr>
			                                            <td>3.</td>
			                                            <td>Cron job running</td>
			                                            <td>
			                                                <div class="progress xs progress-striped active">
			                                                    <div class="progress-bar progress-bar-primary" style="width: 30%"></div>
			                                                </div>
			                                            </td>
			                                            <td><span class="badge bg-light-blue">30%</span></td>
			                                        </tr>
			                                        <tr>
			                                            <td>4.</td>
			                                            <td>Fix and squish bugs</td>
			                                            <td>
			                                                <div class="progress xs progress-striped active">
			                                                    <div class="progress-bar progress-bar-success" style="width: 90%"></div>
			                                                </div>
			                                            </td>
			                                            <td><span class="badge bg-green">90%</span></td>
			                                        </tr>
			                                    </table>
			                                      
			                                    <a href ng-click="poFormCtrl.formVisible = poFormCtrl.PEDIDO" class="btn btn-default">Voltar</a> 
			                                    <a href ng-click="poFormCtrl.formVisible = poFormCtrl.EFETIVAR" class="pull-right btn btn-primary">Avançar</a>   
			                                      			                                 
				                              </div>
				                         </section>		                                  
                                  
	
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->