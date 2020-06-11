package com.felipe.cubefm.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.felipe.cubefm.domain.Pedido;

public abstract class AbstractMailService implements EmailService
{	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj)
	{
		SimpleMailMessage ms = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(ms);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage ms = new SimpleMailMessage();
		ms.setText(obj.getCliente().getEmail());
		ms.setFrom(sender);
		ms.setSubject("Pedido confirmado! Código: " + obj.getId());
		ms.setSentDate(new Date(System.currentTimeMillis()));
		ms.setText(obj.toString());
		return ms;
	}
}
