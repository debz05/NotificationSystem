package com.notification.notificationSystem.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailSendingUtil {
	@Value("${spring.mail.username}")
	private String mail_send_username;
	@Value("${spring.mail.host}")
	private String mail_send_host;
	@Value("${spring.mail.password}")
	private String mail_send_password;
	@Value("${spring.mail.port}")
	private String mail_send_port;

	public MimeMessage formMail(String emailId, String content, String subject) {

		try {
			Properties properties = System.getProperties();
			properties.put("mail.transport.protocol", "smtp");
			properties.setProperty("mail.smtp.host", mail_send_host);
			properties.put("mail.smtp.port", mail_send_port);
			properties.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mail_send_username, mail_send_password);
				}
			});

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mail_send_username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			message.setSubject(subject);

			return message;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean sendMailWithInlineImage(String emailId, String content, String subject) {
		MimeMessage msg = formMail(emailId, content, subject);
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		try {
			messageBodyPart.setContent(content, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			msg.setContent(multipart);
			Transport.send(msg);
			return true;
		} catch (MessagingException e) {
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

}
