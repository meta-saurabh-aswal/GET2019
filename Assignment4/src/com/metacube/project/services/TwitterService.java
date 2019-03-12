package com.metacube.project.services;

public class TwitterService implements MessageService
{
	public void sendMessage(String message, String receiver)
	{
		System.out.println("\nTwitter \nTo,\n"+receiver+"\n"+message);
	}
	
}
