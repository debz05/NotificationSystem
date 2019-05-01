package com.notification.notificationSystem.util;

import javax.persistence.EntityManager;

import org.hibernate.Session;

public class HibernateUtil {
	
	public static Session getSession(EntityManager entityManager)
	{
		return entityManager.unwrap(Session.class);
	}

}
