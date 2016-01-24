package com.diegolirio.purchaseorder.test.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.diegolirio.purchaseorder.models.Client;
import com.diegolirio.purchaseorder.repositories.ClientRepositorie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class ClientRepositorieTest {
	
	@Autowired 
	private ClientRepositorie clientRepositorie;
	
	@Test
	public void testSaveClient() {
		Client client = new Client();
		client.setCpfCnpj("61139432000172");
		client.setName("Transportes Della Volpe S/A");
		client.setSignUpState("31551515151");
		clientRepositorie.save(client);
		Assert.assertTrue(client.getId() > 0);
	}

}
