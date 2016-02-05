                <!-- Main content -->
                <section class="content" ng-controller="ProductListController as pListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-light-blue">
                                    Produtos
                                </header>
                                <div class="panel-body">
                                	<a href="#/produto" class="btn btn-success pull-right">Novo</a>
                                	<br/><br/> 
                                    <table class="table table-bordered">
                                        <tr class="text-danger">
                                            <th class="text-center" style="width: 10px">#</th>
                                            <th class="text-center" style="width: 60px">Código</th>
                                            <th class="text-center">Descrição</th>
                                            <th class="text-center" style="width: 200px">Valor</th>
                                            <th class="text-center" style="width: 100px">Unidade</th>
                                            <th class="text-center" style="width: 10px">editar</th>
                                        </tr>
                                        <tr ng-repeat="p in pListCtrl.products">
                                            <td><small class="text-muted">{{ p.id }}</small></td>
                                            <td>{{ p.code }}</td>
                                            <td>{{ p.description }}</td>
                                            <td class="text-right">{{ p.valueUnit | currency }}</td>
                                            <td>{{ p.productUnit.description }}</td>
                                            <td><span class="badge bg-red">editar</span></td>
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->