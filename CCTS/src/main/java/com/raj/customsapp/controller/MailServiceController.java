package com.raj.customsapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.customsapp.service.MailService;
  
@RestController
@RequestMapping("/mailServices")
@CrossOrigin("http://localhost:3000")
public class MailServiceController {
	
//	MailService service;
//	static String cntOtp = "";
// 
//	public MailServiceController(MailService service) {
//		super();
//		this.service = service;
//	}
//	@GetMapping("/verifyOtp/{otp}")
//	public String doVerifyOtp(@PathVariable("otp") String otp) {
//		String msg = "";
//		try {
//			if(cntOtp.equals(otp)) {
//				msg = "Success";
//			} else {
//				msg = "Failed";				
//			}			
//		} catch (Exception e) {
//			msg = e.toString();							
//		}
//		return msg;
//	}
//
//	@GetMapping("{to}")
//	public String doSendOtpToUser(@PathVariable("to") String email, String password) {
//		String msg = "";
//		String otp = service.genOtp();
//		try {
//			service.sendOtp(email, password);
//			msg = otp;
//			cntOtp = otp;
//		} catch (Exception e) {
//			msg = e.toString();
//		}
//		return msg;
//	}
	
	
 
}