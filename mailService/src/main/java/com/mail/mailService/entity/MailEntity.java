package com.mail.mailService.entity;

import org.springframework.stereotype.Component;

@Component
public class MailEntity {

	private String emailAddress;

	private String subject;
	
	private String msg;

	public MailEntity(String emailAddress, String to, String subject, String msg) {
		super();
		this.emailAddress = emailAddress;
		this.subject = subject;
		this.msg = msg;
	}

	public MailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MailEntity [emailAddress=" + emailAddress + ", subject=" + subject + ", msg=" + msg + "]";
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
