package com.diegolirio.purchaseorder.repositories;

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
import com.diegolirio.purchaseorder.builder.PurchaseOrderBuilderTest;
import com.diegolirio.purchaseorder.builder.StateBuilder;
import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.State;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class PurchaseOrderRepositoryTest {

	private PurchaseOrder purchaseOrder;

	@Autowired
	private PurchaseOrderRepositorie purchaseOrderRepositorie;
	
	@Autowired
	private CustomerRepositorie customerRepositorie;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private AddressRepositorie addressRepository;
	
	@Before
	public void before() {
		purchaseOrder = PurchaseOrderBuilderTest.build();
	}
	
	@Test
	public void testSalvarOrdemCompra() {
		// Salva Customer
		Customer dellavolpe = CustomerBuilderTest.buildTest();
		StateBuilder stateBuilder = new StateBuilder();
		State state = stateBuilder.withAbbreviation("SP")
				  				  .withName("São Paulo")
				  				  .build();
		stateRepository.save(state);		
		// Salva Endereco Customer
		Address dellavolpeAddressRecipient = AddressBuilderTest.buildTest();
		dellavolpeAddressRecipient.setPeople(dellavolpe);
		dellavolpeAddressRecipient.setState(state);
		addressRepository.save(dellavolpeAddressRecipient);
		// salva transportadora
		Customer transportadora = CustomerBuilderTest.buildTest();
		customerRepositorie.save(transportadora);
		
		purchaseOrder.setCustomerAddressRecipient(dellavolpeAddressRecipient);
		purchaseOrder.setCustomerAddressSender(dellavolpeAddressRecipient);
		purchaseOrder.setShippingCompany(transportadora);
		
		purchaseOrderRepositorie.save(purchaseOrder);
		Assert.assertTrue(purchaseOrder.getId() > 0); 
	}
	
}
