package com.notification.notificationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notification.notificationSystem.dto.NotificationDetailsDTO;
import com.notification.notificationSystem.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping(value = "/sendNotification.htm",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> sendNotification(@RequestBody NotificationDetailsDTO notificationDetailsDTO) {
		boolean flag =  notificationService.sendNotification(notificationDetailsDTO);
		if (flag) {
	        return new ResponseEntity<String>(HttpStatus.OK);
	    } else {
	        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);            
	    }
	}

}
