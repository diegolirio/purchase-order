package com.diegolirio.purchaseorder.repositories;

import java.util.List;

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
public class CustomerRepositorieTest {
	
	@Autowired 
	private CustomerRepositorie customerRepositorie;
	private Customer customer;
	
	@Before
	public void before() {
		customer = CustomerBuilderTest.buildTest();
	}
	
	@Test
	public void testSaveCustomer() {
		customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
	}
	
	@Test
	public void testUpdateCustomer() {
		customer = customerRepositorie.save(customer);
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
	
	@Test
	public void testFindByCpfCnpj() {
		customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);		
		customer.setCpfCnpj(CustomerBuilderTest.CUSTOMER_CPFCNPJ);
		customer = customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
		List<Customer> customersFind = customerRepositorie.findByCpfCnpj(CustomerBuilderTest.CUSTOMER_CPFCNPJ);
		Assert.assertNotNull(customersFind);
		Assert.assertEquals("CpfCnpj esperedo da consulta deve ser " + CustomerBuilderTest.CUSTOMER_CPFCNPJ, customersFind.get(0).getCpfCnpj(), CustomerBuilderTest.CUSTOMER_CPFCNPJ);
	}
	
	@Test
	public void testFindByCpfCnpjOrNameContainingIgnoreCase_withNameOK() {
		customer.setName(CustomerBuilderTest.CUSTOMER_NAME);
		customer = customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
		String name = CustomerBuilderTest.CUSTOMER_NAME.substring(2, 7);
		System.out.println(name);
		List<Customer> customersFind = customerRepositorie.findByCpfCnpjContainingOrNameContainingIgnoreCase("096X122", name);
		System.out.println(customersFind.size());
		Assert.assertNotNull(customersFind);
		Assert.assertTrue(customersFind.size() > 0);
	}

	@Test
	public void testFindByCpfCnpjOrNameContainingIgnoreCase_withCpfCnpjOK() {
		customer.setCpfCnpj(CustomerBuilderTest.CUSTOMER_CPFCNPJ);
		customer = customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
		String cnpj = CustomerBuilderTest.CUSTOMER_CPFCNPJ.substring(2, 4);
		System.out.println(cnpj);
		List<Customer> customersFind = customerRepositorie.findByCpfCnpjContainingOrNameContainingIgnoreCase(cnpj, "XxXXxxxX");
		System.out.println(customersFind.size());
		Assert.assertNotNull(customersFind);
		Assert.assertTrue(customersFind.size() > 0);
	}
	
	@Test
	public void testFindByNameContainingIgnoreCase() {
		customer.setName(CustomerBuilderTest.CUSTOMER_NAME);
		customer = customerRepositorie.save(customer);
		Assert.assertTrue(customer.getId() > 0);
		String name = CustomerBuilderTest.CUSTOMER_NAME.substring(2, 5).toLowerCase();
		System.out.println(name);
		List<Customer> customersFind = customerRepositorie.findByNameContainingIgnoreCase(name);
		System.out.println(customersFind.size());
		Assert.assertNotNull(customersFind);
		Assert.assertTrue(customersFind.size() > 0);
	}
	
}
