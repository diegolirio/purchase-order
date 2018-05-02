package com.diegolirio.purchaseorder.services.mail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class MailTest {

	@Autowired
	private Mail mail;
	
//	private String pathInitialTest;
	
	private static final String EMAIL_FROM = "pedido@cafglass.com.br"; //"ddamaceno@dellavolpe.com.br"; //"coletaweb@dellavolpe.com.br";

	@Before
	public void before() {
		//this.pathInitialTest = this.getClass().getClassLoader().getResource("").getPath();
	}
	
	@Test
	public void test() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testSendMail() {
		String emailTo = "diegolirio.dl@gmail.com";
		String [] emailsCC = {};
		boolean sendMail = mail.sendMailSimple("Test Email TDD", "Hello, my email send.\n\nNão responda este e-mail", EMAIL_FROM, emailTo, emailsCC);
		Assert.assertTrue(sendMail);
	}
//	
//	@Test
//	public void testSendMailHtml() throws MessagingException {
//		String subject = "Test email TDD HTML";
//		StringBuilder html = new StringBuilder();
////		html.append("<link href='http://extranet.dellavolpe.com.br:9090/resources/bootstrap/3x/css/bootstrap.css' rel='stylesheet' type='text/css' />");
//		html.append("<h1 class='text-success'>Envio de Email HTML</h1>");
//		html.append("<hr/>");
//		html.append("<img src='http://extranet.dellavolpe.com.br:9090/resources/img/logo-tdv.png'/>");
//		html.append("<br/><br/>");
//		html.append("Não responda este E-mail"); 
//		String emailTo = "diegolirio.dl@gmail.com";
//		String [] emailsCC = {};
//		boolean sendMailHtml = mail.sendMailHtml(subject, html.toString(), EMAIL_FROM, emailTo, emailsCC);
//		Assert.assertTrue(sendMailHtml);
//	}
//	
//	@Test
//	public void testSendMailHtmlAnexo() throws AddressException, MessagingException {
//		String subject = "Test email TDD Anexo";
//		StringBuilder html = new StringBuilder();
//		html.append("<h1 style='color:blue'>Envio de Email com anexo</h1>");
//		html.append("<hr/>");
//		html.append("<br/><br/>");
//		html.append("Não responda este E-mail"); 
//		String emailTo = "diegolirio.dl@gmail.com";
//		String [] emailsCC = {}; 
//		String pathFileAnexo = this.pathInitialTest+"com/diegolirio/purchaseorder/services/mail/attachment.png";
//		System.out.println(pathFileAnexo);
//		boolean sendMailHtml = mail.sendMailHtml(subject, html.toString(), EMAIL_FROM, emailTo, emailsCC, pathFileAnexo);
//		Assert.assertTrue(sendMailHtml);
//	}
//	
}