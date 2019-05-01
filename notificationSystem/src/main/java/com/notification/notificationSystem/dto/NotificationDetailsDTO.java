package com.notification.notificationSystem.dto;

import java.util.List;

import com.notification.notificationSystem.constants.EventConstants;

public class NotificationDetailsDTO {
	
	private List<ReceiverDetailsDTO> receiverDetailsDTOs;
	
	private SenderDetailsDTO senderDetailsDTO;
	
	private EventConstants eventConstant;
	
	private List<String> channelList;

	public List<ReceiverDetailsDTO> getReceiverDetailsDTOs() {
		return receiverDetailsDTOs;
	}

	public void setReceiverDetailsDTOs(List<ReceiverDetailsDTO> receiverDetailsDTOs) {
		this.receiverDetailsDTOs = receiverDetailsDTOs;
	}

	public SenderDetailsDTO getSenderDetailsDTO() {
		return senderDetailsDTO;
	}

	public void setSenderDetailsDTO(SenderDetailsDTO senderDetailsDTO) {
		this.senderDetailsDTO = senderDetailsDTO;
	}

	public EventConstants getEventConstant() {
		return eventConstant;
	}

	public void setEventConstant(EventConstants eventConstant) {
		this.eventConstant = eventConstant;
	}

	public List<String> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<String> channelList) {
		this.channelList = channelList;
	}
	
}
