package com.diegolirio.purchaseorder.services.mail;

import java.io.File;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {

	@Qualifier("tdvmailSender")
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMailSimple(String subject, String msg, String from, String to, String[] cc) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setCc(cc);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
		System.out.println("Email enviado!!!");
		return true;
	}

	public boolean sendMailHtml(String subject, String messageHtml, String from, String to, String [] cc) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// from email
		mimeMessage.setFrom(new InternetAddress(from));
		// to 
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
		// cc
		for (String emailCc : cc) 
			mimeMessage.addRecipients(RecipientType.TO, emailCc);
		// Date email
		mimeMessage.setSentDate(new Date());
		// subject
		mimeMessage.setSubject(subject);
		// message html
		MimeBodyPart attachment0 = new MimeBodyPart();
		attachment0.setContent(messageHtml, "text/html; charset=UTF-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(attachment0);
		mimeMessage.setContent(multipart);
		// send email
		mailSender.send(mimeMessage);
		System.out.println("Email enviado com sucesso!!!");
		return true;
	}

	public boolean sendMailHtml(String subject, String messageHtml, String from, String to, String[] cc, String pathFileAnexo) throws AddressException, MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// from email
		mimeMessage.setFrom(new InternetAddress(from));
		// to 
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
		// cc
		for (String emailCc : cc) 
			mimeMessage.addRecipients(RecipientType.TO, emailCc);
		// Date email
		mimeMessage.setSentDate(new Date());
		// subject
		mimeMessage.setSubject(subject);
		// message html
		MimeBodyPart attachment0 = new MimeBodyPart();
		attachment0.setContent(messageHtml, "text/html; charset=UTF-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(attachment0);
		mimeMessage.setContent(multipart);
		// anexo
        File file = new File(pathFileAnexo);
        MimeBodyPart attachment1 = new MimeBodyPart();  
        attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
        attachment1.setFileName(file.getName());
        multipart.addBodyPart(attachment1);
        // send email
		mailSender.send(mimeMessage);
		System.out.println("Email enviado com sucesso!!!");
		return true;
	}

}
