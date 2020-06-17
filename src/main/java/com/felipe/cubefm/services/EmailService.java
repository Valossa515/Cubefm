package com.felipe.cubefm.services;

import org.springframework.mail.SimpleMailMessage;

import com.felipe.cubefm.domain.Pedido;

public interface EmailService 
{
	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
}
