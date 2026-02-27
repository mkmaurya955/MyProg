package com.mail.mailService.service;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import com.mail.mailService.entity.MailEntity;

public interface MailService {

	void sendEmailWithAttachment(MailEntity mailEntity) throws MailException, MessagingException;

	void sendEmail(MailEntity mailEntity);

}
