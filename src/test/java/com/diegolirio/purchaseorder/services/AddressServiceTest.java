package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.CustomerBuilderTest;
import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class AddressServiceTest {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CustomerService customerService;

	@Test
	public void testGetListByPeople() {
		Customer customer = CustomerBuilderTest.buildTest();
		customerService.save(customer);
		List<Address> listByPeople = addressService.getListByPeople(customer);
		Assert.assertNotNull(listByPeople);
	}
	
}
