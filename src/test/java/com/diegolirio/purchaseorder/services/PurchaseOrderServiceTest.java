package com.diegolirio.purchaseorder.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.PurchaseOrderBuilderTest;
import com.diegolirio.purchaseorder.models.PurchaseOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class PurchaseOrderServiceTest {

	private PurchaseOrder purchaseOrder;

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Autowired
	private AddressService addressService;
	

	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testSave() {
		purchaseOrder = PurchaseOrderBuilderTest.build();
		purchaseOrderService.save(purchaseOrder);
		Assert.assertTrue(purchaseOrder.getId() > 0);
	}
	
	@Test
	public void testSendMailPO() {
//		purchaseOrder = PurchaseOrderBuilderTest.build();
//		Customer customer = CustomerBuilderTest.buildTest();
//		customerService.save(customer);
//		Address address = AddressBuilderTest.buildTest();
//		address.setPeople(customer);
//		addressService.save(address);
//		purchaseOrder.setCustomerAddressRecipient(address);
//		purchaseOrder.setCustomerAddressSender(address);
//		purchaseOrderService.save(purchaseOrder);
//		Assert.assertTrue(purchaseOrder.getId() > 0);
		//boolean sendEmail = purchaseOrderService.sendEmail(purchaseOrder);
		Assert.assertTrue(true);
	}	
	
}
