package com.harshi.flightReservation.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * put logic to segregate saveReservation itnerary and updatereservation
	 * itinerary mail should be more clear about what happened.
	 */
	
	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary for your flight.");
			mimeMessageHelper.setText("Please find your Itinerary attached.");
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		;
	}
}
