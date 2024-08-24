package com.raj.customsapp.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.raj.customsapp.model.ImporterPayment;
import com.raj.customsapp.serviceImpl.ImporterPaymentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/imppay")

public class ImporterPaymentController {

    @Autowired
    private ImporterPaymentServiceImpl serviceimpl;

    
    @PostMapping
    public ResponseEntity<String> submitInvoice(@RequestBody ImporterPayment pay)
    {
        if (pay.getPaymentDate() == null) {
        	pay.setPaymentDate(new Date(System.currentTimeMillis()));
        }
        
        serviceimpl.addApplication(pay);
        return ResponseEntity.ok("Payment processed successfully");
  
    }
}

