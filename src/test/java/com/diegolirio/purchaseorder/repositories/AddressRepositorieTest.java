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
import com.diegolirio.purchaseorder.builder.StateBuilderTest;
import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.State;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class AddressRepositorieTest {

	private Address address;
	
	@Autowired
	private AddressRepositorie addressRepository;

	@Autowired
	private CustomerRepositorie customerRepositorie;

	@Autowired
	private StateRepositorie stateRepositoie;

	@Before
	public void before() {
		address = AddressBuilderTest.buildTest();			
	}
	
	@Test
	public void testInsert() {
		Customer customer = customerRepositorie.save(CustomerBuilderTest.buildTest());
		address.setPeople(customer);
		State state = stateRepositoie.save(StateBuilderTest.build());
		stateRepositoie.save(state);
		address.setState(state );
		address = addressRepository.save(address);
		Assert.assertTrue(address.getId() > 0);
	}
	
	@Test
	public void testFindByPeople() {
		Customer customer = CustomerBuilderTest.buildTest();
		customer = customerRepositorie.save(customer);
		Customer customer2 = customerRepositorie.findByCpfCnpjAndActive(CustomerBuilderTest.CUSTOMER_CPFCNPJ, true);
		List<Address> addresses = addressRepository.findByPeopleAndActive(customer2, true);
		Assert.assertNotNull(addresses);
		//for (Address address : addresses) {
		//	System.out.println(address);
		//}
		System.out.println("QTDE END = "+addresses.size());
	}
	
}
