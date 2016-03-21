package com.diegolirio.purchaseorder.reports.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.AddressBuilderTest;
import com.diegolirio.purchaseorder.builder.CustomerBuilderTest;
import com.diegolirio.purchaseorder.builder.PurchaseOrderBuilderTest;
import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.Product;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.State;
import com.diegolirio.purchaseorder.models.StatusType;
import com.diegolirio.purchaseorder.repositories.CustomerRepositorie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class PurchaseOrderReportServiceTest {

	private PurchaseOrder po;

	@Autowired @Qualifier("purchaseOrderReportService")
	private ReportService reportService;
	
	@Autowired
	private CustomerRepositorie customerRepositorie;
	
	@Before
	public void before() {
		po = PurchaseOrderBuilderTest.build();
		po.setId(1l);
		po.setCondicaoPagamento("30");
		po.setEmissionDate(new Date());
		po.setContactRecipient("João");
		po.setPhoneRecipient("(11) 98888-7777"); 
		po.setPhoneSender("(11) 95555-4444");
		po.setPhoneShippingCompany("(11) 2563-9999");
		po.setRemark("Test TDD");
		po.setStatus(StatusType.completed);
		po.setTypeFreight('D');
		//User userCreated = UserBuildTest.buildTest();
		//po.setUserCreated(userCreated );
		Customer customer = this.customerRepositorie.save(CustomerBuilderTest.buildTest());
		
		Address address = AddressBuilderTest.buildTest();
		address.setId(1l);
		address.setPeople(customer);
		address.setCep("08543-270");
		address.setCity("São Paulo");
		address.setNeighborhood("Pq. Novo Mundo");
		address.setNumber(22);
		address.setPeople(customer);
		address.setPublicPlace("Rua Lidice");
		State state = new State();
		state.setAbbreviation("SP");
		state.setId(1l);
		state.setName("São Paulo");
		address.setState(state);
		po.setCustomerAddressShippingCompany(address);
		po.setCustomerAddressSender(address );
		po.setCustomerAddressRecipient(address );

		List<OrdersProducts> ordersProducts = new ArrayList<OrdersProducts>();
		OrdersProducts prod = new OrdersProducts(1l);
		prod.setAmount(3.0);
		prod.setOrder(po);
		Product product = new Product();
		product.setCode("999");
		product.setDescription("Notebook DELL");
		product.setValueUnit(2855.59);
		prod.setProduct(product );
		prod.setValueUnit(2855.59);
		ordersProducts.add(prod);
		po.setOrdersProducts(ordersProducts);		
	}
	
	@Test
	public void testGeraRelatorioGuardandoArquivoPDFEmDiscoRetornaPathVerificaExistencia() throws JRException {
		String pathFile = reportService.generateReportPath(po);
		System.out.println(pathFile);
		File pdf = new File(pathFile);
		Assert.assertTrue(pdf.exists());
	}
	
	@Test
	public void testGeraRelatorioPDFArrayBite() throws JRException {
		byte[] generateReport = reportService.generateReport(po);
		Assert.assertNotNull(generateReport);
	}
	
}
