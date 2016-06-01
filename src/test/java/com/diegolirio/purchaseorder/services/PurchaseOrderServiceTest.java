package com.diegolirio.purchaseorder.services;

import org.junit.Assert;
import org.junit.Before;
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

	@Autowired
	private StateService stateService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrdersProductsService ordersProductsService;

	@Before
	public void before() {
		purchaseOrder = PurchaseOrderBuilderTest.build();
	}

	/**
	 * Completa informacoes PO
	 * @param purchaseOrder
	 */
//	private void completaInfoPO(PurchaseOrder purchaseOrder) {
//		purchaseOrder.setCondicaoPagamento("30");
//		purchaseOrder.setEmissionDate(new Date());
//		purchaseOrder.setContactRecipient("João");
//		purchaseOrder.setPhoneRecipient("(11) 98888-7777"); 
//		purchaseOrder.setPhoneSender("(11) 95555-4444");
//		purchaseOrder.setPhoneShippingCompany("(11) 2563-9999");
//		purchaseOrder.setRemark("Test TDD");
//		purchaseOrder.setStatus(StatusType.completed);
//		purchaseOrder.setTypeFreight('D');
//		//User userCreated = UserBuildTest.buildTest();
//		//po.setUserCreated(userCreated );
//		
//		// cria cliente
//		Customer customer = this.customerService.save(CustomerBuilderTest.buildTest());
//
//		// cria estado
//		State state = StateBuilderTest.build();
//		this.stateService.save(state);
//
//		// cria endereco
//		Address address = AddressBuilderTest.buildTest();
//		address.setPeople(customer);
//		address.setState(state);
//		this.addressService.save(address);
//		
//		purchaseOrder.setCustomerAddressShippingCompany(address);
//		purchaseOrder.setCustomerAddressSender(address );
//		purchaseOrder.setCustomerAddressRecipient(address );
//
//		// cria produto
//		Product product = ProductBuilderTest.buildTest();
//		this.productService.save(product);
//		
//		List<OrdersProducts> ordersProducts = new ArrayList<OrdersProducts>();
//		
//		// cria produtos da po
//		OrdersProducts prod = new OrdersProducts();
//		prod.setAmount(3.0);
//		prod.setOrder(purchaseOrder);
//		prod.setProduct(product );
//		prod.setValueUnit(2855.59);
//		this.ordersProductsService.save(prod);
//		
//		ordersProducts.add(prod);
//		purchaseOrder.setOrdersProducts(ordersProducts);			
//	}
	
	@Test
	public void testSave() {
		purchaseOrderService.save(purchaseOrder);
		Assert.assertTrue(purchaseOrder.getId() > 0);
	}

//	@Test
//	public void sendEmailLinkPO() {
//		purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
//		completaInfoPO(purchaseOrder);
//		boolean sendEmail = purchaseOrderService.sendEmailLinkPO(purchaseOrder);
//		Assert.assertTrue(true);
//	}	

//	@Test
//	public void testSendMailAnexoPO() throws AddressException, MessagingException, JRException {
//		purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
//		completaInfoPO(purchaseOrder);
//		boolean sendEmailAttachmentPO = purchaseOrderService.sendEmailAttachmentPO(purchaseOrder);
//		Assert.assertTrue(sendEmailAttachmentPO);
//	}
	
//	@Test
//	public void testEfetivarPO() {
//		purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
//		completaInfoPO(purchaseOrder);
//		purchaseOrder.setStatus(StatusType.pending);
//		purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
//		PurchaseOrder completed = purchaseOrderService.completed(purchaseOrder.getId());
//		Assert.assertEquals(StatusType.completed, completed.getStatus());
//	}
	
	// testEfetivarPO -> TODO: Criar teste com Status completed que não passa 
	// testEfetivarPO -> TODO: Criar teste com Status canceled que não passa 
	
}
