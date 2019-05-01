package com.notification.notificationSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventTemplateMapping")
public class EventTemplateMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String eventName;

	@JoinColumn(name = "slackTemplate")
	@OneToOne(cascade = CascadeType.ALL)
	private SlackTemplate slackTemplate;

	@JoinColumn(name = "emailTemplate")
	@OneToOne(cascade = CascadeType.ALL)
	private EmailTemplate emailTemplate;

	@JoinColumn(name = "smsTemplate")
	@OneToOne(cascade = CascadeType.ALL)
	private SMSTemplate smsTemplate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public SlackTemplate getSlackTemplate() {
		return slackTemplate;
	}

	public void setSlackTemplate(SlackTemplate slackTemplate) {
		this.slackTemplate = slackTemplate;
	}

	public EmailTemplate getEmailTemplate() {
		return emailTemplate;
	}

	public void setEmailTemplate(EmailTemplate emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public SMSTemplate getSmsTemplate() {
		return smsTemplate;
	}

	public void setSmsTemplate(SMSTemplate smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

}
