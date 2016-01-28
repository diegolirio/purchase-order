                <!-- Main content -->
                <section class="content" ng-controller="ProductListController as pListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-red">
                                    Produtos
                                </header>
                                <div class="panel-body">
                                	<a href="#/produto" class="btn btn-success pull-right">Novo</a>
                                	<br/><br/> 
                                    <table class="table table-bordered">
                                        <tr class="text-danger">
                                            <th class="text-center" style="width: 10px">#</th>
                                            <th class="text-center">Código</th>
                                            <th class="text-center">Descrição</th>
                                            <th class="text-center">Valor</th>
                                            <th class="text-center">Unidade</th>
                                            <th class="text-center" style="width: 10px">editar</th>
                                        </tr>
                                        <tr ng-repeat="p in pListCtrl.products">
                                            <td>{{ c.id }}</td>
                                            <td>{{ c.code }}</td>
                                            <td>{{ c.description }}</td>
                                            <td>{{ c.valueUnit }}</td>
                                            <td>{{ c.productUnit.description }}</td>
                                            <td><span class="badge bg-red">editar</span></td>
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->