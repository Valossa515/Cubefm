package com.felipe.cubefm.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipe.cubefm.services.DBService;
import com.felipe.cubefm.services.EmailService;
import com.felipe.cubefm.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	@Bean
	public boolean instantiateDataBase() throws ParseException
	{
		dbService.instantitateTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService()
	{
		return new MockEmailService();
	}
}
