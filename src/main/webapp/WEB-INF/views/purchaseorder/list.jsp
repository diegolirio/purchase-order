                <!-- Main content -->
                <section class="content" ng-controller="PurchaseOrderListController as poListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-ligth-blue">
                                    Pedidos
                                </header>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Task</th>
                                            <th>Progress</th>
                                            <th style="width: 40px">Label</th>
                                        </tr>
                                        <tr ng-repeat="po in poListCtrl.purchaseOrders">
                                            <td>{{ po.id }}</td>
                                            <td>{{ po.id }}</td>
                                            <td>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-danger" style="width: 55%"></div>
                                                </div>
                                            </td>
                                            <td><span class="badge bg-red">{{ po.id }}</span></td>
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->