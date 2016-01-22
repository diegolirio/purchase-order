package com.diegolirio.purchaseorder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.CustomerBuilder;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.repositories.CustomerRepositorie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class CustomerRepositorieTest {
	
	@Autowired 
	private CustomerRepositorie customerRepositorie;
	private Customer customer;
	
	public static final String CUSTOMER_CPFCNPJ = "61139432000172";
	public static final String CUSTOMER_NAME = "Transportes Della Volpe S/A";
	public static final String CUSTOMER_SIGNUPSTATE = "31551515151";
	
	@Before
	public void before() {
		customer = buildTest();
	}
	
	public static Customer buildTest() {
		CustomerBuilder customerBuilder = new CustomerBuilder(); 
		Customer customer = customerBuilder.withCpfCnpj(CUSTOMER_CPFCNPJ)
								  		   .withName(CUSTOMER_NAME)
								  		   .withSignUpState(CUSTOMER_SIGNUPSTATE)
								  		   .build();
		return customer;
	}
	
	@Test
	public void testSaveCustomer() {
		customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
	}
	
	@Test
	public void testUpdateCustomer() {
		customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
		Long id = customer.getId();
		customer.setCpfCnpj("12345678910110");
		customer.setName("DIEGO S/A");
		customer.setSignUpState("999999999");
		customerRepositorie.save(customer);
		Customer customerUpdated = customerRepositorie.findOne(id);
		boolean fieldsUpdated = "12345678910110".equals(customerUpdated.getCpfCnpj()) && "DIEGO S/A".equals(customerUpdated.getName()) && "999999999".equals(customerUpdated.getSignUpState());
		Assert.assertTrue(fieldsUpdated);
	}	
	
	
}
