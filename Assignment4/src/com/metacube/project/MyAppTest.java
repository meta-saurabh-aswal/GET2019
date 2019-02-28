package com.metacube.project;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.metacube.project.config.DIConfig;
import com.metacube.project.consumer.MyApp;
import com.metacube.project.services.MessageService;

public class MyAppTest
{
	ApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
	
	@Test
	public void testEmail()
	{
		String message = "skgh juknbsug";
		String receiver = "Sun";
		String serviceType = "email";
		
		MyApp app = context.getBean(MyApp.class);
		
		app.setMessageService((MessageService) context.getBean(serviceType));
		app.notification(message, receiver);
	}

	@Test
	public void testTwitter()
	{
		String message = "skgh 67tr3q";
		String receiver = "Moon";
		String serviceType = "twitter";
		
		MyApp app = context.getBean(MyApp.class);
		
		app.setMessageService((MessageService) context.getBean(serviceType));
		app.notification(message, receiver);
	}
}
