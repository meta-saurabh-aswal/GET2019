package com.metacube.project.consumer;

import org.springframework.stereotype.Component;

import com.metacube.project.services.MessageService;

@Component
public class MyApp
{
	MessageService messageService = null;
	
	public void setMessageService(MessageService messageService)
	{
		this.messageService = messageService;
	
	}
	
	public void notification(String message, String receiver)
	{
		messageService.sendMessage(message, receiver);
	}

}
