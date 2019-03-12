package com.metacube.project;

import org.junit.Test;

import com.metacube.project.consumer.MyXMLApp;
import com.metacube.project.services.MessageService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyXMLAppTest
{
	ApplicationContext context = new FileSystemXmlApplicationContext("src/com/metacube/project/config/appContext.xml");
	@Test
	public void testEmail()
	{
		String message = "skgh juknbsuginbb nsg";
		String receiver = "Sun";
		String serviceType = "email";
				
		MyXMLApp app =(MyXMLApp) context.getBean("app");
		
		app.setMessageService((MessageService) context.getBean(serviceType));
		app.notification(message, receiver);
	}

	@Test
	public void testTwitter()
	{
		String message = "skgh jginbb nsggsuohg 67tr3q";
		String receiver = "Moon";
		String serviceType = "twitter";
		
		MyXMLApp app =(MyXMLApp) context.getBean("app");
		
		app.setMessageService((MessageService) context.getBean(serviceType));
		app.notification(message, receiver);
	}
}
