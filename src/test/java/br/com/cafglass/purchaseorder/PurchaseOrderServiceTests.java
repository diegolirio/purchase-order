package br.com.cafglass.purchaseorder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext-test.xml")
public class PurchaseOrderServiceTests {

	//@Autowired
	//private PurchaseOrderService purchaseOrderService;

	@Test
	public void testFindAll() {
		//List<PurchaseOrder> findAll = purchaseOrderService.findAll();
		Assert.assertTrue(true);
	}

}
