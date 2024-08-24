package com.raj.customsapp.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.raj.customsapp.model.ExporterPayment;
import com.raj.customsapp.serviceImpl.ExporterPaymentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/exppay")

public class ExporterPaymentController {

    @Autowired
    private ExporterPaymentServiceImpl serviceimpl;

    
    @PostMapping
    public ResponseEntity<String> submitInvoice(@RequestBody ExporterPayment pay)
    {
        if (pay.getPaymentDate() == null) {
        	pay.setPaymentDate(new Date(System.currentTimeMillis()));
        }
        
        serviceimpl.addApplication(pay);
        return ResponseEntity.ok("Payment processed successfully");
    } 
}

