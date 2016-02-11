package com.diegolirio.purchaseorder.services.mail;

import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mail {

	private static final String EMAIL_FROM = "diegolirio.dl@gmail.com";
	
	@Autowired
    private JavaMailSender mailSender;
    
	public boolean sendMail(String to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(EMAIL_FROM);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
		return true;
	}
	
	public boolean sendMail(String emailTo, String... emailsCC) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			InternetAddress emailFrom = new InternetAddress(EMAIL_FROM);
			
			mimeMessage.setFrom( emailFrom );
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(emailTo));
			for (String email : emailsCC) {
				mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email));
			}	        
	        
	        mimeMessage.setSentDate( new Date() );
	        mimeMessage.setSubject("Envio de E-Mail com Spring");
	        
	        String htmlMessage = "<font color='red'>Envio de E-Mail com Spring</font>";
	        htmlMessage += "<hr/>";
	        htmlMessage += "<h3>Corpo do Email em HTML</h3>";
	        htmlMessage += "<h5>Email com arquivo anexo!</h5>";
	        htmlMessage += "<hr/>";
	        htmlMessage += "Agora sim ;) \\o/";
	        
	        MimeBodyPart attachment0 = new MimeBodyPart();
	        attachment0.setContent(htmlMessage,"text/html; charset=UTF-8");
	        
//	        Multipart multipart = new MimeMultipart();
//	        multipart.addBodyPart(attachment0);	        
//	        
//	        File file = new File("/webapps/");
//	        MimeBodyPart attachment1 = new MimeBodyPart();  
//	        attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
//	        attachment1.setFileName(file.getName());
//	        multipart.addBodyPart(attachment1);
//
//	        mimeMessage.setContent(multipart);	        
	        
	        System.out.println( "Iniciando Envio do Email..." );
	        mailSender.send(mimeMessage);	        
	        
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	
	
}
