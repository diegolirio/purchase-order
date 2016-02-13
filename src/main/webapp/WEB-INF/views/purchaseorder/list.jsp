                <!-- Main content -->
                <section class="content" ng-controller="PurchaseOrderListController as poListCtrl">
                    <div class="row">
                        
                            <div class="panel">
                                <header class="panel-heading badge bg-green">
                                    Pedidos
                                </header>
                                <div class="panel-body"> 
									<select ng-model="poListCtrl.search.status"
											ng-options="s.status as s.display for s in poListCtrl.statusList">
									</select>	                                 
									<input type="date" ng-model="poListCtrl.search.dateStart" maxlength="10" size="12" class="datepicker" > &aacute; 
									<input type="date" ng-model="poListCtrl.search.dateEnd" maxlength="10" size="12" class="datepicker" >
									<a href ng-click="poListCtrl.searchAdv(poListCtrl.search.status, poListCtrl.search.dateStart, poListCtrl.search.dateEnd)" 
									   class="btn btn-default" id="id_search"><span class="glyphicon glyphicon-search"></span></a>
									<!-- <a href="#" class="btn btn-default" id="id_filter"><span class="glyphicon glyphicon-filter"></span></a> -->
                                	<a href="#/pedido" class="btn btn-success pull-right">Novo</a>
                                	<br/><br/> 
                                    <table class="table table-bordered">
                                        <tr class="text-danger">
                                            <th rowspan="2" class="text-center" style="width: 10px">Numero</th>
                                            <th rowspan="2" class="text-center">Data</th>
                                            <th rowspan="2" class="text-center">Status</th>
                                            <th colspan="2" class="text-center">Remetente</th>
                                            <th colspan="2" class="text-center">Destinatário</th>
                                            <th rowspan="2" class="text-center">Transportadora</th>
                                            <th rowspan="2" class="text-center"></th>
                                        </tr> 
                                        <tr class="text-muted"> 
                                            <th class="text-center">Razão</th>
                                            <th class="text-center">CNPJ</th>
                                            <th class="text-center">Razão</th>
                                            <th class="text-center">CNPJ</th>
                                        </tr>
                                        <tr ng-repeat="po in poListCtrl.purchaseOrders">
                                            <td class="text-center">
                                            	<a ng-show="po.status == 'completed' || po.status == 'canceled'" href="#/pedido/edit/{{po.id}}">{{ po.id }}</a>
                                            	<a ng-show="po.status == 'pending'" href="#/pedido/{{po.id}}">{{ po.id }}</a>
                                            </td>
                                            <td class="text-center">{{ po.emissionDate }}</td> 
                                            <td class="text-center">
                                            	<span ng-show="po.status == 'pending'" class="label label-warning">Pendente</span>
                                            	<span ng-show="po.status == 'completed'" class="label label-default">Concluído</span>
                                            	<span ng-show="po.status == 'canceled'" class="label label-danger">Cancelado</span>
                                            </td>
                                            <td>{{ po.customerAddressSender.people.name }}</td>
                                            <td class="text-center">{{ po.customerAddressSender.people.cpfCnpj }}</td>
                                            <td>{{ po.customerAddressRecipient.people.name }}</td>
                                            <td class="text-center">{{ po.customerAddressRecipient.people.cpfCnpj }}</td>
                                            <td>{{ po.shippingCompany.name }}</td>
                                            <td> 
                                            	<a href ng-click="poListCtrl.deletePO(po)" ng-show="po.status == 'pending'" title="Excluir Pedido"><span class="glyphicon glyphicon-trash text-danger"></span></a>
                                            	<a href="#/pedido/edit/{{po.id}}" ng-show="po.status == 'completed' || po.status == 'canceled'" title="Visualizar/Editar Pedido"><span class="glyphicon glyphicon-share-alt text-info"></span></a> 
                                            </td>
                                        </tr>
                                    </table>
                                </div><!-- /.panel-body -->
                            </div><!-- /.panel -->                        
                        
                    </div><!-- /.row -->
                </section><!-- /.content -->