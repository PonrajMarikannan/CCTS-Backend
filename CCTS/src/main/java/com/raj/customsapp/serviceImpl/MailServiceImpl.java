package com.raj.customsapp.serviceImpl;


import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired; 
import jakarta.mail.MessagingException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.raj.customsapp.service.MailService;

@Service

public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;
    private static final SecureRandom RANDOM = new SecureRandom();
 
//	public void sendOtp(String toMail, String otp) throws MessagingException {
//
//		 MimeMessage message = javaMailSender.createMimeMessage();
//
//	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
// 
//	        helper.setTo(toMail);
//
//	        helper.setSubject("Your OTP Code");
//
//	        String htmlContent = "<html>" +
//
//	        	    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f7; padding: 30px 0; color: #333;'>" +
//
//	        	    "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 10px; overflow: hidden; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);'>" +
//
//	        	    "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #f3f4f6; background-color: #fff;'>" +
//
//	        	    "<h1 style='margin: 0; font-size: 30px; font-weight: 700;'>Smart Kitchen App</h1>" +
//
//	        	    "</div>" +
//
//	        	    "<div style='padding: 30px 20px; text-align: center;'>" +
//
//	        	    "<p style='font-size: 16px; margin: 0 0 8px;'>Dear User,</p>" +
//
//	        	    "<p style='font-size: 16px; margin: 0 0 30px;'>Your One-Time Password (OTP) for verification is:</p>" +
//
//	        	    "<p style='font-size: 24px; font-weight: 700; margin: 0 0 30px; color: #FF5722;'>" + otp + "</p>" +
//
//	        	    "<p style='font-size: 14px; margin: 0;'>If you did not request this code, please ignore this email.</p>" +
//
//	        	    "</div>" +
//
//	        	    "<div style='padding: 20px; text-align: center; background-color: #f9f9f9;'>" +
//
//	        	    "<p style='margin: 0;'>Yours truly,<br>Team Smart Kitchen App</p>" +
//
//	        	    "</div>" +
//
//	        	    "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #aaa;'>" +
//
//	        	    "<p style='margin: 0;'>Secured by <a href='https://www.smartkitchenapp.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Smart Kitchen App</a></p>" +
//
//	        	    "</div>" +
//
//	        	    "</div>" +
//
//	        	    "</body>" +
//
//	        	    "</html>";
// 
// 
//	        helper.setText(htmlContent, true);
//
//	        javaMailSender.send(message);
//
//	}
// 
	
	
    
	@Override
	public String genOtp() {

		int otp = RANDOM.nextInt(999999); // Generate a random number up to 999999

        String otpStr = String.format("%06d", otp); // Format as a 6-digit number with leading zeros

        return otpStr;

	}

	@Override
	public void sendOtp(String toMail, String otp) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(toMail);
	    message.setSubject("Your OTP Code");
	    message.setText(otp);
	    javaMailSender.send(message);
		
	}

 
}

 