                <!-- Main content -->
                <section class="content" ng-controller="PurchaseOrderListController as poListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-green">
                                    Pedidos
                                </header>
                                <div class="panel-body">
                                	<a href="#/pedido" class="btn btn-success pull-right">Novo</a>
                                	<br/><br/> 
                                    <table class="table table-bordered">
                                        <tr class="text-danger">
                                            <th rowspan="2" class="text-center" style="width: 10px">Numero</th>
                                            <th rowspan="2" class="text-center">Data</th>
                                            <th colspan="2" class="text-center">Remetente</th>
                                            <th colspan="2" class="text-center">Destinatário</th>
                                            <th rowspan="2" class="text-center" style="width: 40px">Transportadora</th>
                                        </tr>
                                        <tr class="text-danger">
                                            <th>CNPJ</th>
                                            <th>Razão</th>
                                            <th>CNPJ</th>
                                            <th>Razão</th>
                                        </tr>
                                        <tr ng-repeat="po in poListCtrl.purchaseOrders">
                                            <td><a href="#/pedido/{{po.id}}">{{ po.id }}</a></td>
                                            <td>{{ po.emissionDate }}</td>
                                            <td>{{ po.customerAddressRecipient.people.name }}</td>
                                            <td>{{ po.customerAddressRecipient.people.cpfCnpj }}</td>
                                            <td>{{ po.customerAddressSender.people.name }}</td>
                                            <td>{{ po.customerAddressSender.people.cpfCnpj }}</td>
                                            <td><span class="badge bg-red">{{ po.shippingCompany.name }}</span></td>
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->