package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Customer;

public class CustomerBuilderTest {

	public static final String CUSTOMER_CPFCNPJ = "61139432000179";
	public static final String CUSTOMER_NAME = "Transportes Della Volpe S/A";
	public static final String CUSTOMER_SIGNUPSTATE = "31551515151";
	private static final String CUSTOMER_EMAIL = "diegolirio.dl@gmail.com";
	
	public static Customer buildTest() {
		CustomerBuilder customerBuilder = new CustomerBuilder(); 
		Customer customer = customerBuilder.withCpfCnpj(CUSTOMER_CPFCNPJ)
								  		   .withName(CUSTOMER_NAME)
								  		   .withSignUpState(CUSTOMER_SIGNUPSTATE)
								  		   .withEmail(CUSTOMER_EMAIL)
								  		   .build();
		return customer;
	}
	
}
