package com.diegolirio.purchaseorder.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.CustomerBuilderTest;
import com.diegolirio.purchaseorder.builder.TelephoneBuilderTest;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.Telephone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional 
public class TelephoneRepositorieTest {

	private Telephone telephone;

	@Autowired
	private TelephoneRepositorie telephoneRepositorie;
	
	@Autowired
	private CustomerRepositorie customerRepositorie;

	@Before
	public void before() {
		telephone = TelephoneBuilderTest.builderTest();
	}

	@Test
	public void testInsert() {
		Customer customerTest = CustomerBuilderTest.buildTest();
		customerRepositorie.save(customerTest);
		telephone.setPeople(customerTest);
		telephone = telephoneRepositorie.save(telephone);
		Assert.assertTrue(telephone.getId() > 0);
	}
	
}
