package com.notification.notificationSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emailTemplate")
public class EmailTemplate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String template;
	private String emailSubject;
	private String emailBody;

	public EmailTemplate() {

	}

	public EmailTemplate(int id, String template, String emailSubject, String emailBody) {
		super();
		this.id = id;
		this.template = template;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

}
