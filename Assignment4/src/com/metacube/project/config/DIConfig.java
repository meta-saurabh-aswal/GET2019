package com.metacube.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.metacube.project.services.EmailService;
import com.metacube.project.services.TwitterService;

@Configuration
@ComponentScan("com.metacube.project.consumer")
public class DIConfig
{
	@Bean
	public EmailService email()
	{
		return new EmailService();
	}
	
	@Bean
	public TwitterService twitter()
	{
		return new TwitterService();
	}

	
}
