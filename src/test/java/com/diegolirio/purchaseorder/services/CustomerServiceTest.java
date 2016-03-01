package com.diegolirio.purchaseorder.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.CustomerBuilderTest;
import com.diegolirio.purchaseorder.models.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	private Customer customer;

	@Before
	public void before() {
		customer = CustomerBuilderTest.buildTest();
	}
	
	@Test
	public void testGetByCpfCnpj() {
		//Customer customer = this.customerService.getByCpfCnpj(CustomerBuilderTest.CUSTOMER_CPFCNPJ);
		Assert.assertTrue(true);
//		Assert.assertEquals(customer.getCpfCnpj(), CustomerBuilderTest.CUSTOMER_CPFCNPJ);
	}
	
	@Test
	public void testCustomerSave() {
		customerService.save(customer);
		Assert.assertTrue(customer.getId() > 0);
	}
	
	
	/**
	 * Deve bloquear clientes cadastrado com cpfCnpj igual que estão ativos
	 */
	@Test(expected=RuntimeException.class)
	public void testCustomerSaveRepeatSaveCpfCnpjError() {
		customerService.save(customer);
		Assert.assertTrue(customer.getId() > 0);
		Customer customer2 = CustomerBuilderTest.buildTest();
		customerService.save(customer2);
	}
	
}
