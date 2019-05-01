package com.notification.notificationSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.notificationSystem.dao.NotificationDao;
import com.notification.notificationSystem.dto.NotificationDetailsDTO;
import com.notification.notificationSystem.dto.ReceiverDetailsDTO;
import com.notification.notificationSystem.dto.SenderDetailsDTO;
import com.notification.notificationSystem.entity.EmailTemplate;
import com.notification.notificationSystem.entity.SlackTemplate;
import com.notification.notificationSystem.util.MailSendingUtil;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDao notificationDao;

	@Autowired
	private MailSendingUtil mailSendingUtil;

	@Override
	public boolean sendNotification(NotificationDetailsDTO notificationDetailsDTO) {
		List<String> channelList = notificationDetailsDTO.getChannelList();
		String content = "";
		for(String channel : channelList)
		{
			if(channel.equals("Email"))
			{
				
				EmailTemplate emailTemplate = notificationDao.getEmailTemplateByEvent(notificationDetailsDTO.getEventConstant());
				
				List<ReceiverDetailsDTO> receiverDetailsDTOs = notificationDetailsDTO.getReceiverDetailsDTOs();
				try {
					if (receiverDetailsDTOs != null && !receiverDetailsDTOs.isEmpty()) {
						
						for(ReceiverDetailsDTO receiverDetailsDTO:receiverDetailsDTOs)
						{
							
							
							if(receiverDetailsDTO.getEmailId()!=null || !receiverDetailsDTO.getEmailId().isEmpty())
							{
								content = emailTemplate.getEmailBody();
								content = content.replace("[Receiver]", receiverDetailsDTO.getUserName());
								SenderDetailsDTO senderDetailsDTO = notificationDetailsDTO.getSenderDetailsDTO();
								content = content.replace("[Sender]",senderDetailsDTO.getUserName());
							}
							mailSendingUtil.sendMailWithInlineImage(receiverDetailsDTO.getEmailId(), content, emailTemplate.getEmailSubject());
						}
						
					}
				return true;
				} catch (Exception e) {
					//log exception
					return false;
				}
			
			}
			else if(channel.equals("Slack"))
			{
				SlackTemplate slackTemplate = notificationDao.getSlackTemplateByEvent(notificationDetailsDTO.getEventConstant());
				
				List<ReceiverDetailsDTO> receiverDetailsDTOs = notificationDetailsDTO.getReceiverDetailsDTOs();
				try {
					if (receiverDetailsDTOs != null && !receiverDetailsDTOs.isEmpty()) {
						
						for(ReceiverDetailsDTO receiverDetailsDTO:receiverDetailsDTOs)
						{
							
							
							if(receiverDetailsDTO.getEmailId()!=null || !receiverDetailsDTO.getEmailId().isEmpty())
							{
								String text = slackTemplate.getText();
								String emoji = slackTemplate.getEmoji();
								SenderDetailsDTO senderDetailsDTO = notificationDetailsDTO.getSenderDetailsDTO();
								content = content.replace("[Sender]",senderDetailsDTO.getUserName());
							}
							//implementation for sending msgs through slack
						}
						
					}
				return true;
				} catch (Exception e) {
					//log exception
					return false;
				}
				
			}
			else if(channel.equals("SMS"))
			{
				//implemntation for sending msgs through sms
			}
		}
		return false;
	}

}
