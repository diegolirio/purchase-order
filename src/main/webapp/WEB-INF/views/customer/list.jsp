                <!-- Main content -->
                <section class="content" ng-controller="CustomerListController as cListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-red">
                                    Clientes
                                </header>
                                <div class="panel-body">
                                	<a href="#/cliente" class="btn btn-success pull-right">Novo</a>
                                	<br/><br/> 
                                    <table class="table table-bordered">
                                        <tr class="text-danger">
                                            <th class="text-center" style="width: 10px">#</th>
                                            <th class="text-center">CNPJ</th>
                                            <th class="text-center">Razão Social</th>
                                            <th class="text-center">Insc. Estadual</th>
                                            <th class="text-center" style="width: 10px">editar</th>
                                        </tr>
                                        <tr ng-repeat="c in cListCtrl.customers">
                                            <td>{{ c.id }}</td>
                                            <td>{{ c.cpfCnpj }}</td>
                                            <td>{{ c.name }}</td>
                                            <td>{{ c.signUpState }}</td>
                                            <td><span class="badge bg-red">editar</span></td>
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->