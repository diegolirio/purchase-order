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

import com.diegolirio.purchaseorder.builder.AdderssBuilder;
import com.diegolirio.purchaseorder.builder.PurchaseOrderBuilder;
import com.diegolirio.purchaseorder.builder.StateBuilder;
import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.State;
import com.diegolirio.purchaseorder.repositories.AddressRepository;
import com.diegolirio.purchaseorder.repositories.CustomerRepositorie;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepository;
import com.diegolirio.purchaseorder.repositories.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class PurchaseOrderRepositoryTest {

	private PurchaseOrder purchaseOrder;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private CustomerRepositorie customerRepositorie;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Before
	public void before() {
		purchaseOrder = buildTest();
	}
	
	public static PurchaseOrder buildTest() {
		PurchaseOrderBuilder purchaseOrderBuilder = new PurchaseOrderBuilder();		
		PurchaseOrder purchaseOrder = purchaseOrderBuilder.withEmissionDate(Calendar.getInstance().getTime())
										  .withFaxRecipient("1129678536")
										  .withPhoneRecipient("11296785")
										  .withPhoneSender("1129678511")
										  .withPhoneShippingCompany("1146758597")
										  .withRemark("Teste Observacao")
										  .withTypeFreight('R')
										  .build();
		return purchaseOrder;
	}
	
	@Test
	public void testSalvarOrdemCompra() {
		// Salva Customer
		Customer dellavolpe = CustomerRepositorieTest.buildTest();
		customerRepositorie.save(dellavolpe);
		// Salva Estado
		StateBuilder stateBuilder = new StateBuilder();
		State state = stateBuilder.withAbbreviation("SP")
				  				  .withName("São Paulo")
				  				  .build();
		stateRepository.save(state);		
		// Salva Endereco Customer
		AdderssBuilder adderssBuilder = new AdderssBuilder();
		Address dellavolpeAddressRecipient = adderssBuilder.withCep("07503270")
														   .withCity("São Paulo")
														   .withNeighborhood("Parque Novo Mundo")
														   .withNumber(22)
														   .withPeople(dellavolpe)
														   .withPublicPlace("Rua Lidice")
														   .withState(state)
														   .build();		
		addressRepository.save(dellavolpeAddressRecipient);
		// salva transportadora
		Customer transportadora = CustomerRepositorieTest.buildTest();
		customerRepositorie.save(transportadora);
		
		purchaseOrder.setCustomerAddressRecipient(dellavolpeAddressRecipient);
		purchaseOrder.setCustomerAddressSender(dellavolpeAddressRecipient);
		purchaseOrder.setShippingCompany(transportadora);
		
		purchaseOrderRepository.save(purchaseOrder);
		Assert.assertTrue(purchaseOrder.getId() > 0); 
	}
	
}
