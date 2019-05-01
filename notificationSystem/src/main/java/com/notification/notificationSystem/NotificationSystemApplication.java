package com.notification.notificationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.notification.*")
public class NotificationSystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NotificationSystemApplication.class, args);
	}

}
