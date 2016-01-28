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

import com.diegolirio.purchaseorder.builder.AddressBuilderTest;
import com.diegolirio.purchaseorder.builder.CustomerBuilderTest;
import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class AddressRepositorieTest {

	private Address address;
	
	@Autowired
	private AddressRepositorie addressRepository;

	@Autowired
	private CustomerRepositorie customerRepositorie;

	@Before
	public void before() {
		address = AddressBuilderTest.buildTest();			
	}
	
	@Test
	public void testInsert() {
		Customer customer = customerRepositorie.save(CustomerBuilderTest.buildTest());
		address.setPeople(customer);
		address = addressRepository.save(address);
		Assert.assertTrue(address.getId() > 0);
	}
	
	@Test
	public void testFindByPeople() {
		List<Customer> customers = customerRepositorie.findByCpfCnpj(CustomerBuilderTest.CUSTOMER_CPFCNPJ);
		List<Address> addresses = addressRepository.findByPeople(customers.get(0));
		Assert.assertNotNull(addresses);
		//for (Address address : addresses) {
		//	System.out.println(address);
		//}
		System.out.println("QTDE END = "+addresses.size());
	}
	
}
