package com.notification.notificationSystem.dao;

import com.notification.notificationSystem.constants.EventConstants;
import com.notification.notificationSystem.entity.EmailTemplate;
import com.notification.notificationSystem.entity.SMSTemplate;
import com.notification.notificationSystem.entity.SlackTemplate;

public interface NotificationDao {
	//EmailTemplate getEmailTemplatesByName(String template);
	
	EmailTemplate getEmailTemplateByEvent(EventConstants eventConstant);
	SlackTemplate getSlackTemplateByEvent(EventConstants eventConstant);
	SMSTemplate getSMSTemplateByEvent(EventConstants eventConstant);

}
