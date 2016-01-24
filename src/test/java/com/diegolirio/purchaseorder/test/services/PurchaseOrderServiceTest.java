package com.diegolirio.purchaseorder.test.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.service.PurchaseOrderService;
import com.diegolirio.purchaseorder.test.builder.PurchaseOrderBuilderTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class PurchaseOrderServiceTest {

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	private PurchaseOrder purchaseOrder;
	
	@Test
	public void testSave() {
		purchaseOrder = PurchaseOrderBuilderTest.build();
		purchaseOrderService.save(purchaseOrder);
		Assert.assertTrue(purchaseOrder.getId() > 0);
	}
	
}
