package com.raj.customsapp.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.raj.customsapp.model.ImporterApplication;
import com.raj.customsapp.model.ImporterInvoice;
import com.raj.customsapp.serviceImpl.ImporterAppServiceImpl;
import com.raj.customsapp.serviceImpl.ImporterInvoiceServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/impinvoice")
public class ImporterInvoiceController {

    @Autowired
    private ImporterInvoiceServiceImpl serviceimpl;
    
    @Autowired
    private ImporterAppServiceImpl appserviceimpl;
    
    @PostMapping
    public ResponseEntity<String> submitInvoice(@RequestParam("amount") int amount,
            @RequestParam("applicationId") Integer applicationId)
    {
    	ImporterInvoice importerInvoice = new ImporterInvoice();
    	
    	ImporterApplication exp = appserviceimpl.getApp(applicationId);
    	    	
    	importerInvoice.setImporterApplication(exp);
    	importerInvoice.setAmount(amount);
    	
    	if (importerInvoice.getInvoiceDate() == null) {
    		importerInvoice.setInvoiceDate(new Date(System.currentTimeMillis()));
	     }
    	
    	
    	
        serviceimpl.addApplication(importerInvoice);
        return ResponseEntity.ok("Invoice submitted successfully.");
    }
    
    @GetMapping("/all")
    public List<ImporterInvoice> viewAllInvoices() {
        return serviceimpl.getAllInv();
    }
        
    @GetMapping("{id}")
	public ImporterInvoice getEmployeebyId(@PathVariable("id") int id) {
		return serviceimpl.getInv(id);
	}
    
    @GetMapping("/byUserId/{userId}")
    public List<ImporterInvoice> getInvoicesByUserId(@PathVariable("userId") int userId) {
        return serviceimpl.getInvoicesByUserId(userId);
    }
 
}

