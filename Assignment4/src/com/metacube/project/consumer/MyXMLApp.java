package com.metacube.project.consumer;

import com.metacube.project.services.MessageService;

public class MyXMLApp
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
