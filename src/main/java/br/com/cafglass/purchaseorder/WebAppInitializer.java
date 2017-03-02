package br.com.cafglass.purchaseorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.cafglass.purchaseorder.interceptors.CORSInterceptor;

@Configuration
public class WebAppInitializer extends WebMvcConfigurerAdapter   {
	
	@Autowired
	private CORSInterceptor authorizerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorizerInterceptor);  
    }

}
