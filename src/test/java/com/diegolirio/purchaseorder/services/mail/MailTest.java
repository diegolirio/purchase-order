package com.diegolirio.purchaseorder.services.mail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.diegolirio.purchaseorder.services.mail.Mail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class MailTest {

	@Autowired
	private Mail mail;

	@Test
	public void testSendMailSimple() {
		boolean sendMail = mail.sendMail("diegolirio.dl@gmail.com", "TESTE", "MENSAGEM");
		Assert.assertTrue(sendMail);
	}
	
	@Test
	public void testSendMail() {
		String emailTo = "diegolirio.dl@gmail.com";
		String [] emailsCC = {"fabianogoes@gmail.com"};
		boolean sendMail = mail.sendMail(emailTo, emailsCC);
		Assert.assertTrue(sendMail);
	}
	
}
