package com.notification.notificationSystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.notification.notificationSystem.constants.EventConstants;
import com.notification.notificationSystem.entity.EmailTemplate;
import com.notification.notificationSystem.entity.EventTemplateMapping;
import com.notification.notificationSystem.entity.SMSTemplate;
import com.notification.notificationSystem.entity.SlackTemplate;
import com.notification.notificationSystem.util.HibernateUtil;

@Repository
public class NotificationDaoImpl implements NotificationDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EmailTemplate getEmailTemplatesByName(String template)
	{
		Session session = HibernateUtil.getSession(entityManager);
		EmailTemplate emailTemplate = (EmailTemplate) session.createCriteria(EmailTemplate.class).add(Restrictions.eq("template", template)).uniqueResult();
		return emailTemplate;
	}

	@Override
	public EmailTemplate getEmailTemplateByEvent(EventConstants eventConstant) {
		Session session = HibernateUtil.getSession(entityManager);
		EventTemplateMapping eventTemplateMapping = (EventTemplateMapping) session.createCriteria(EventTemplateMapping.class).add(Restrictions.eq("eventName", eventConstant.toString())).uniqueResult();
		return eventTemplateMapping.getEmailTemplate();
	}
	
	@Override
	public SlackTemplate getSlackTemplateByEvent(EventConstants eventConstant) {
		Session session = HibernateUtil.getSession(entityManager);
		EventTemplateMapping eventTemplateMapping = (EventTemplateMapping) session.createCriteria(EventTemplateMapping.class).add(Restrictions.eq("eventName", eventConstant)).uniqueResult();
		return eventTemplateMapping.getSlackTemplate();
	}
	
	@Override
	public SMSTemplate getSMSTemplateByEvent(EventConstants eventConstant) {
		Session session = HibernateUtil.getSession(entityManager);
		EventTemplateMapping eventTemplateMapping = (EventTemplateMapping) session.createCriteria(EventTemplateMapping.class).add(Restrictions.eq("eventName", eventConstant)).uniqueResult();
		return eventTemplateMapping.getSmsTemplate();
	}

}
