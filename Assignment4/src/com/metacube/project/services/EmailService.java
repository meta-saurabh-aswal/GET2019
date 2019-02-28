package com.metacube.project.services;

public class EmailService implements MessageService
{
	public void sendMessage(String message, String receiver)
	{
		System.out.println("\nEmail \nTo,\n"+receiver+"\n"+message);
	}

}
