package com.diegolirio.purchaseorder.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.EmailSettingsPOBuilder;
import com.diegolirio.purchaseorder.models.EmailSettingsPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class EmailSettingsPORepositoryTest {
	
	private EmailSettingsPO emailSettingsPO;

	@Autowired
	private EmailSettingsPORepository emailSettingsPORepository; 
	
	@Test
	public void saveInsertTest() {
		EmailSettingsPOBuilder builder = new EmailSettingsPOBuilder();
		emailSettingsPO = builder.withUsername("pedido@cafglass.com.br")
							     .withPassword("carlos@1620")
							     .withHost("mx1.hostinger.com.br")
							     .withPort("2525")
							     .withFromEmail("pedido@cafglass.com.br")
							     .build();
		emailSettingsPORepository.save(emailSettingsPO);
		Assert.assertTrue("ID deve ser maior que ZERO indicando que foi incluido incluido a configuracao de envio de email",
						  emailSettingsPO.getId() > 0);
	}

}
