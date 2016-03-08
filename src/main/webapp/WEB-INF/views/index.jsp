<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <meta charset="UTF-8">
        <title>Pedido</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/resources/static/director-free/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/static/director-free/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/resources/static/director-free/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- google font -->
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/resources/static/director-free/css/style.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        
        <!-- spinner loading -->
        <link href="${pageContext.request.contextPath}/resources/static/css/spinner.css" rel="stylesheet" type="text/css" />
         
    </head>
    <body class="skin-black" ng-controller="UserSessionController as userSessionCtrl">  
    
    
		<div id="spinner" class="spinner" style="display:none;"> 
	         <img id="img-spinner" src="${pageContext.request.contextPath}/resources/static/img/295.gif" alt="Aguarde..."/> <br/>
	    </div>  	
    
    
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="${pageContext.request.contextPath }" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Pedido
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
<!--                         <li class="dropdown messages-menu"> -->
<!--                             <a href= class="dropdown-toggle" data-toggle="dropdown"> -->
<!--                                 <i class="fa fa-envelope"></i> -->
<!--                                 <span class="label label-success">4</span> -->
<!--                             </a> -->
<!--                             <ul class="dropdown-menu"> -->
<!--                                 <li class="header">You have 4 messages</li> -->
<!--                                 <li> -->
<!--                                     inner menu: contains the actual data -->
<!--                                     <ul class="menu"> -->
<!--                                         <li>start message -->
<!--                                             <a href=> -->
<!--                                                 <div class="pull-left"> -->
<%--                                                     <img src="${pageContext.request.contextPath}/resources/static/director-free/img/sem_avatar.png" class="img-circle" alt="User Image"/> --%>
<!--                                                 </div>  -->
<!--                                                 <h4>  -->
<!--                                                     Support Team -->
<!--                                                     <small><i class="fa fa-clock-o"></i> 5 mins</small> -->
<!--                                                 </h4> -->
<!--                                                 <p>Why not buy a new awesome theme?</p> -->
<!--                                             </a> -->
<!--                                         </li>end message -->
<!--                                         <li> -->
<!--                                             <a href=> -->
<!--                                                 <div class="pull-left"> -->
<%--                                                     <img src="${pageContext.request.contextPath}/resources/static/director-free/img/avatar2.png" class="img-circle" alt="user image"/> --%>
<!--                                                 </div> -->
<!--                                                 <h4> -->
<!--                                                     Director Design Team -->
<!--                                                     <small><i class="fa fa-clock-o"></i> 2 hours</small> -->
<!--                                                 </h4> -->
<!--                                                 <p>Why not buy a new awesome theme?</p> -->
<!--                                             </a> -->
<!--                                         </li> -->
<!--                                         <li> -->
<!--                                             <a href=> -->
<!--                                                 <div class="pull-left"> -->
<%--                                                     <img src="${pageContext.request.contextPath}/resources/static/director-free/img/avatar.png" class="img-circle" alt="user image"/> --%>
<!--                                                 </div> -->
<!--                                                 <h4> -->
<!--                                                     Developers -->
<!--                                                     <small><i class="fa fa-clock-o"></i> Today</small> -->
<!--                                                 </h4> -->
<!--                                                 <p>Why not buy a new awesome theme?</p> -->
<!--                                             </a> -->
<!--                                         </li> -->
<!--                                         <li> -->
<!--                                             <a href=> -->
<!--                                                 <div class="pull-left"> -->
<%--                                                     <img src="${pageContext.request.contextPath}/resources/static/director-free/img/avatar2.png" class="img-circle" alt="user image"/> --%>
<!--                                                 </div> -->
<!--                                                 <h4> -->
<!--                                                     Sales Department -->
<!--                                                     <small><i class="fa fa-clock-o"></i> Yesterday</small> -->
<!--                                                 </h4> -->
<!--                                                 <p>Why not buy a new awesome theme?</p> -->
<!--                                             </a> -->
<!--                                         </li> -->
<!--                                         <li> -->
<!--                                             <a href=> -->
<!--                                                 <div class="pull-left"> -->
<%--                                                     <img src="${pageContext.request.contextPath}/resources/static/director-free/img/avatar.png" class="img-circle" alt="user image"/> --%>
<!--                                                 </div> -->
<!--                                                 <h4> -->
<!--                                                     Reviewers -->
<!--                                                     <small><i class="fa fa-clock-o"></i> 2 days</small> -->
<!--                                                 </h4> -->
<!--                                                 <p>Why not buy a new awesome theme?</p> -->
<!--                                             </a> -->
<!--                                         </li> -->
<!--                                     </ul>  -->
<!--                                 </li> -->
<!--                                 <li class="footer"><a href=>See All Messages</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class="dropdown tasks-menu"> -->
<!--                             <a href= class="dropdown-toggle" data-toggle="dropdown"> -->
<!--                                 <i class="fa fa-tasks"></i> -->
<!--                                 <span class="label label-danger">9</span> -->
<!--                             </a> -->
<!--                             <ul class="dropdown-menu"> -->

<!--                                 <li class="header">You have 9 tasks</li> -->
<!--                                 <li> -->
<!--                                     inner menu: contains the actual data -->
<!--                                     <ul class="menu"> -->
<!--                                         <li>Task item -->
<!--                                             <a href=> -->
<!--                                                 <h3> -->
<!--                                                     Design some buttons -->
<!--                                                     <small class="pull-right">20%</small> -->
<!--                                                 </h3> -->
<!--                                                 <div class="progress progress-striped xs"> -->
<!--                                                     <div class="progress-bar progress-bar-success" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"> -->
<!--                                                         <span class="sr-only">20% Complete</span> -->
<!--                                                     </div> -->
<!--                                                 </div> -->
<!--                                             </a> -->
<!--                                         </li>end task item -->
<!--                                         <li>Task item -->
<!--                                             <a href=> -->
<!--                                                 <h3> -->
<!--                                                     Create a nice theme -->
<!--                                                     <small class="pull-right">40%</small> -->
<!--                                                 </h3> -->
<!--                                                 <div class="progress progress-striped xs"> -->
<!--                                                     <div class="progress-bar progress-bar-danger" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"> -->
<!--                                                         <span class="sr-only">40% Complete</span> -->
<!--                                                     </div> -->
<!--                                                 </div> -->
<!--                                             </a> -->
<!--                                         </li>end task item -->
<!--                                         <li>Task item -->
<!--                                             <a href=> -->
<!--                                                 <h3> -->
<!--                                                     Some task I need to do -->
<!--                                                     <small class="pull-right">60%</small> -->
<!--                                                 </h3> -->
<!--                                                 <div class="progress progress-striped xs"> -->
<!--                                                     <div class="progress-bar progress-bar-info" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"> -->
<!--                                                         <span class="sr-only">60% Complete</span> -->
<!--                                                     </div> -->
<!--                                                 </div> -->
<!--                                             </a> -->
<!--                                         </li>end task item -->
<!--                                         <li>Task item -->
<!--                                             <a href=> -->
<!--                                                 <h3> -->
<!--                                                     Make beautiful transitions -->
<!--                                                     <small class="pull-right">80%</small> -->
<!--                                                 </h3> -->
<!--                                                 <div class="progress progress-striped xs"> -->
<!--                                                     <div class="progress-bar progress-bar-warning" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"> -->
<!--                                                         <span class="sr-only">80% Complete</span> -->
<!--                                                     </div> -->
<!--                                                 </div> -->
<!--                                             </a> -->
<!--                                         </li>end task item -->
<!--                                     </ul> -->
<!--                                 </li> -->
<!--                                 <li class="footer"> -->
<!--                                     <a href=>View all tasks</a> -->
<!--                                 </li> -->

<!--                             </ul> -->
<!--                         </li> -->
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">

                            <a href class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                <span>{{ userSessionCtrl.userLogged.name }} <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                <li class="dropdown-header text-center">Conta</li>

<!--                                 <li> -->
<!--                                     <a href=> -->
<!--                                     <i class="fa fa-clock-o fa-fw pull-right"></i> -->
<!--                                         <span class="badge badge-success pull-right">10</span> Updates</a> -->
<!--                                     <a href=> -->
<!--                                     <i class="fa fa-envelope-o fa-fw pull-right"></i> -->
<!--                                         <span class="badge badge-danger pull-right">5</span> Messages</a> -->
<!--                                     <a href=><i class="fa fa-magnet fa-fw pull-right"></i> -->
<!--                                         <span class="badge badge-info pull-right">3</span> Subscriptions</a> -->
<!--                                     <a href=><i class="fa fa-question fa-fw pull-right"></i> <span class= -->
<!--                                         "badge pull-right">11</span> FAQ</a> -->
<!--                                 </li> -->

<!--                                 <li class="divider"></li> -->

                                <li>
                                    <a href >
                                    <i class="fa fa-user fa-fw pull-right"></i>
                                        Perfil
                                    </a>
                                    <a data-toggle="modal" href >
                                    <i class="fa fa-cog fa-fw pull-right"></i>
                                        Configurações
                                    </a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href ng-click="userSessionCtrl.logout()"><i class="fa fa-ban fa-fw pull-right"></i> Sair</a>
                                </li>
                            </ul>

                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${pageContext.request.contextPath}/resources/static/director-free/img/sem_avatar.png" class="img-circle" alt="User Image" />
                        </div>
                        
                        <div class="pull-left info">
                            <p>Olá, {{userSessionCtrl.userLogged.name}}</p>
<!--                             <a href=><i class="fa fa-circle text-success"></i> Online</a> -->
                        </div>
                    </div>
                    <!-- search form -->
<!--                     <form action= method="get" class="sidebar-form"> -->
<!--                         <div class="input-group"> -->
<!--                             <input type="text" name="q" class="form-control" placeholder="Search..."/> -->
<!--                             <span class="input-group-btn"> -->
<!--                                 <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button> -->
<!--                             </span> -->
<!--                         </div> -->
<!--                     </form> -->
                    <ul class="sidebar-menu">
                        <li>
                            <a href="#/pedidos">
                                <i class="fa fa-dashboard"></i> <span>Pedidos</span>
                            </a>
                        </li>
                        <li>
                            <a href="#/clientes">
                                <i class="fa fa-gavel"></i> <span>Clientes</span>
                            </a>
                        </li>

                        <li>
                            <a href="#/produtos">
                                <i class="fa fa-globe"></i> <span>Produtos</span>
                            </a>
                        </li>

<!--                         <li class="active"> -->
<!--                             <a href="simple.html"> -->
<!--                                 <i class="fa fa-glass"></i> <span>Simple tables</span> -->
<!--                             </a> -->
<!--                         </li> -->

                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
				
				<!-- Content -->
				<div ng-view></div>
				
<!--                 <div class="footer-main"> -->
<!--                     Copyright CafGlass, 2016 -->
<!--                 </div> -->
                
            </aside><!-- /.right-side -->
            
        </div><!-- ./wrapper -->

<c:import url="modal-costumer.jsp"></c:import>

        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/static/director-free/js/jquery.min.js" type="text/javascript"></script>
        
	
		<!-- ########################## AngularJS ########################################################################### -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular-route.js"></script>
		<!-- Conf do Local -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/core/angular-locale_pt-br.js"></script>
		<!--------- rotas e config da app angular ------------------->
		<script src="${pageContext.request.contextPath}/resources/static/core/app-1.0.0.js"></script>  
		<!--------- Common ----------------> 
		<script src="${pageContext.request.contextPath}/resources/static/core/common/StringCommon-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/common/DateCommon-1.0.0.js"></script>
		<!--------- Services ----------------> 
		<script src="${pageContext.request.contextPath}/resources/static/core/services/UserLoginService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/PurchaseOrderService-1.0.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/CustomerService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/AddressService-1.0.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/TelephoneService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/ProductService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/ProductTypeService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/StateService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/OrdersProductsService-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/services/mask/mask-1.0.0.js"></script>
		<!--------- Controllers -------------> 
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/UserSessionController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/PurchaseOrderListController-1.0.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/PurchaseOrderFormController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/PurchaseOrderEditController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/CustomerListController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/CustomerFormController-1.0.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/ProductListController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/ProductFormController-1.0.0.js"></script> 
		<!-- ########################## End AngularJS ####################################################################### -->
         

<!-- 		<script> -->
<!--  			$(function() { -->
<!--  				$( ".datepicker" ).datepicker({dateFormat: 'dd/mm/yy'}); -->
<!--  				$.ajaxSetup({ cache: false }); -->
<!--  			}); -->
<!-- 		</script> -->

        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/resources/static/director-free/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Director App -->
        <script src="${pageContext.request.contextPath}/resources/static/director-free/js/Director/app.js" type="text/javascript"></script>
    </body>
</html>
