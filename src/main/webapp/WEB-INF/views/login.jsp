<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
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
    <body class="skin-black">  
    
    
		<div id="spinner" class="spinner" style="display:none;"> 
	         <img id="img-spinner" src="${pageContext.request.contextPath}/resources/static/img/295.gif" alt="Aguarde..."/> <br/>
	    </div>  	
    
    
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="${pageContext.request.contextPath }" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Login
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href= class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
            </nav>
        </header>

            <!-- Right side column. Contains the navbar and content of the page -->
<!--             <aside class="right-side"> -->
            <aside ng-controller="UserLoginController as ulCtrl">
				
				<div class="col-md-4 col-sm-3"></div>
				<div class="col-md-4 col-sm-6">
					<!-- Content -->
					<h3 class="text-center">Login</h3>
						
		            <form ng-submit="ulCtrl.login(ulCtrl.user)">
		                <div class="body ">
		                    <div class="form-group">
		                        <input ng-model="ulCtrl.user.login" class="form-control input-lg" placeholder="Login"/>
		                    </div>
		                    <div class="form-group">
		                        <input ng-model="ulCtrl.user.password" type="password" class="form-control input-lg" placeholder="Senha"/>
		                    </div>          
<!-- 		                    <div class="form-group"> -->
<!-- 		                        <input type="checkbox" name="remember_me"/> Lembrar me -->
<!-- 		                    </div> -->
		                </div>
		                <div class="footer">                                                               
		                    <button type="submit" class="btn btn-success btn-lg btn-block">Entrar</button>  
		                    <p><a href="#">Esqueci a senha</a></p>
		                </div>
		            </form>				
				</div>
				<div class="col-md-4 col-sm-3"></div>				
                
            </aside><!-- /.right-side -->
            


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/static/director-free/js/jquery.min.js" type="text/javascript"></script>
        
	
		<!-- ########################## AngularJS ########################################################################### -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular-route.js"></script>
		<!--------- rotas e config da app angular ------------------->
		<script src="${pageContext.request.contextPath}/resources/static/core/app-1.0.0.js"></script>  
		<!--------- Services ----------------> 
		<script src="${pageContext.request.contextPath}/resources/static/core/services/UserLoginService-1.0.0.js"></script>
		<!--------- Controllers ------------->
		<script src="${pageContext.request.contextPath}/resources/static/core/controllers/UserLoginController-1.0.0.js"></script>
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
