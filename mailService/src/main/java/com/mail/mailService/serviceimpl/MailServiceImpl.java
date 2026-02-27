package com.mail.mailService.serviceimpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.mailService.entity.MailEntity;
import com.mail.mailService.service.MailService;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(MailEntity mailEntity) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(mailEntity.getEmailAddress());
		mail.setSubject(mailEntity.getSubject());
		mail.setText(mailEntity.getMsg());

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @throws MailException
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(MailEntity mailEntity) throws MailException, MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(mailEntity.getEmailAddress());
		helper.setSubject(mailEntity.getSubject());
		helper.setText(mailEntity.getMsg());

		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
	}

}


