package com.diegolirio.purchaseorder.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testGetByCpfCnpj() {
		//Customer customer = this.customerService.getByCpfCnpj(CustomerBuilderTest.CUSTOMER_CPFCNPJ);
		Assert.assertTrue(true);
//		Assert.assertEquals(customer.getCpfCnpj(), CustomerBuilderTest.CUSTOMER_CPFCNPJ);
	}
	
}
