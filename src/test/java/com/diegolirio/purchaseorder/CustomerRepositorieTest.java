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
	
	@Before
	public void before() {
		CustomerBuilder customerBuilder = new CustomerBuilder(); 
		customer = customerBuilder.withCpfCnpj("61139432000172")
								  .withName("Transportes Della Volpe S/A")
								  .withSignUpState("31551515151")
								  .build();
	}
	
	@Test
	public void testSaveClient() {
		customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
	}
	
	
}
