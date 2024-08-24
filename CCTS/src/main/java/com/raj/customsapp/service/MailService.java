package com.raj.customsapp.service;


import jakarta.mail.MessagingException;

public interface MailService {
	
	public void sendOtp(String toMail, String otp) throws MessagingException;
	
	public String genOtp();
 
}