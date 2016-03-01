                <!-- Main content -->
                <section class="content" ng-controller="ProductListController as pListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-light-blue">
                                    Produtos
                                </header>
                                <div class="panel-body">
                                
                                  <form ng-submit="pListCtrl.findProductAdvanced(pListCtrl.fieldSearch)">
						                <div class="col-md-pull-8">
                                	  		<a href="#/produto" class="btn btn-success btn-lg pull-right">Novo</a>
                                	  	</div>
						                <div class="input-group col-md-4">
						                    <input ng-model="pListCtrl.fieldSearch" type="search" class="form-control input-lg" placeholder="pesquisar..." />
						                    <span class="input-group-btn">
						                        <button class="btn btn-default btn-lg" >
						                            <i class="glyphicon glyphicon-search"></i>
						                        </button>
						                    </span>
						                </div> 
							        </form>       
                                	<br/> 
                                    <table class="table table-bordered">
                                        <tr class="text-danger">
                                            <th class="text-center" style="width: 60px">Código</th>
                                            <th class="text-center">Descrição</th>
                                            <th class="text-center" style="width: 200px">Valor</th>
                                            <th class="text-center" style="width: 100px">Tipo</th>
                                            <th class="text-center" style="width: 10px">editar</th>
                                            <th class="text-center" style="width: 10px"></th>
                                        </tr> 
                                        <tr ng-repeat="p in pListCtrl.products">
                                            <td>{{ p.code }}</td>
                                            <td>{{ p.description }}</td>
                                            <td class="text-right">{{ p.valueUnit | currency }}</td>
                                            <td>{{ p.productType.description }}</td>
                                            <td><a href="#/produto/{{p.id}}"><span class="badge bg-red">editar</span></a></td>
                                            <td>
                                            	<a href ng-click="pListCtrl.deleteProduct(p)" title="Excluir">
                                            		<span class="glyphicon glyphicon-trash text-danger"></span>
                                            	</a>
                                            </td>                                            
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->