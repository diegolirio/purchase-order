package com.diegolirio.purchaseorder.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		logger.info(uri);

		//  page login
		if(uri.contains("/login")) {
			return true;
		}
		
		// if user logged
		if(request.getSession().getAttribute("userLogged") != null) {
			return true;
		}
		
		//  page login
		if(uri.contains("/resources/static")) {
			return true;
		}
		
		// se usuario estiver logado redireciona p/ principal se nao p/ login
		response.sendRedirect(request.getSession().getAttribute("userLogged") == null ? "/pedido/login?next="+uri : "/pedido");
		return false;
	}
	
	

}
