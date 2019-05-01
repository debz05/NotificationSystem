package com.notification.notificationSystem.service;

import com.notification.notificationSystem.dto.NotificationDetailsDTO;

public interface NotificationService {
	
	boolean sendNotification(NotificationDetailsDTO notificationDetailsDTO);

}
