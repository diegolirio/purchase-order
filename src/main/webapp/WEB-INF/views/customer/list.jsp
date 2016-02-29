                <!-- Main content -->
                <section class="content" ng-controller="CustomerListController as cListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-red">
                                    Clientes
                                </header>
                                <div class="panel-body">
							        <form ng-submit="cListCtrl.findCustomerAdvanced(cListCtrl.fieldSearch)">
						                <div class="col-md-pull-8">
                                	  		<a href="#/cliente" class="btn btn-success btn-lg pull-right">Novo</a>
                                	  	</div>
						                <div class="input-group col-md-4">
						                    <input ng-model="cListCtrl.fieldSearch" type="search" class="form-control input-lg" placeholder="pesquisar..." />
						                    <span class="input-group-btn">
						                        <button class="btn btn-default btn-lg" >
						                            <i class="glyphicon glyphicon-search"></i>
						                        </button>
						                    </span>
						                </div> 
							        </form>       
                                	<br/> 
                                	<div class="table-responsive">
	                                    <table class="table table-bordered">
	                                        <tr class="text-danger">
	<!--                                             <th class="text-center" style="width: 10px">#</th> -->
	                                            <th class="text-center">CNPJ</th>
	                                            <th class="text-center">Razão Social</th>
	                                            <th class="text-center">Insc. Estadual</th>
	                                            <th class="text-center" style="width: 10px">editar</th>
	                                            <th class="text-center" style="width: 10px"></th>
	                                        </tr>
	                                        <tr ng-repeat="c in cListCtrl.customers">
	<!--                                             <td>{{ c.id }}</td> -->
	                                            <td>{{ c.cpfCnpj }}</td>
	                                            <td>{{ c.name }}</td>
	                                            <td>{{ c.signUpState }}</td>
	                                            <td><a href="#/cliente/{{c.id}}"><span class="badge bg-red">editar</span></a></td>
	                                            <td>
	                                            	<a href ng-click="cListCtrl.deleteCustomer(c)" title="Excluir">
	                                            		<span class="glyphicon glyphicon-trash text-danger"></span>
	                                            	</a>
	                                            </td>
	                                        </tr>
	                                    </table>
	                                </div>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->