package com.mail.mailService.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.mailService.entity.MailEntity;
import com.mail.mailService.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailServiceController {
	@Autowired
	private MailService mailService;
	
	@PostMapping("/send-mail")
	public String send(@RequestBody MailEntity mailEntity) {
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			mailService.sendEmail(mailEntity);
			return "Congratulations! Your mail has been send to the user.";
		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
		}
	}

	@PostMapping("/send-mail-attachment")
	public String sendWithAttachment(@RequestBody MailEntity mailEntity) throws MessagingException {

		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
		 * that contains a attachment.
		 */
		try {
			mailService.sendEmailWithAttachment(mailEntity);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

}
