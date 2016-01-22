package com.diegolirio.purchaseorder;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.PurchaseOrderBuilder;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class PurchaseOrderRepositoryTest {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	private PurchaseOrder purchaseOrder;
	
	@Before
	public void before() {
		PurchaseOrderBuilder purchaseOrderBuilder = new PurchaseOrderBuilder();
		purchaseOrder = purchaseOrderBuilder.withEmissionDate(Calendar.getInstance().getTime())
						    				.build();
	}
	
	
	@Test
	public void testSalvarOrdemCompra() {
		purchaseOrderRepository.save(purchaseOrder);
		Assert.assertTrue(purchaseOrder.getId() > 0); 
	}
	
}
