package com.raj.customsapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.raj.customsapp.model.ExporterApplication;
import com.raj.customsapp.model.Ship;
import com.raj.customsapp.model.User;
import com.raj.customsapp.serviceImpl.ExporterAppServiceImpl;
import com.raj.customsapp.serviceImpl.ShipServiceImpl;
import com.raj.customsapp.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/exportapp")
public class ExporterAppController {

    @Autowired
    private ExporterAppServiceImpl serviceimpl;
    
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Autowired
    private ShipServiceImpl shipServiceImpl;
    
    
    @PostMapping
    public ResponseEntity<String> submitApplication(
            @RequestParam("userId") Integer userId,
            @RequestParam("shipId") Integer shipId,
            @RequestParam("importerName") String importerName,
            @RequestParam("importerEmail") String importerEmail,
            @RequestParam("impPhnum") String impPhnum,
            @RequestParam("exporterName") String exporterName,
            @RequestParam("exporterEmail") String exporterEmail,
            @RequestParam("expPhnum") String expPhnum,
            @RequestParam("productName") String productName,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("weight") Double weight,
            @RequestParam("destinationCountry") String destinationCountry,
            @RequestParam("file") MultipartFile file) throws IOException {

        byte[] fileBytes = null;
        if (file != null && !file.isEmpty()) {
            fileBytes = file.getBytes();
        }

        User user = userServiceImpl.getUser(userId);
        Ship ship = shipServiceImpl.getShip(shipId);

        ExporterApplication application = new ExporterApplication();
        
        application.setUser(user);
        application.setShip(ship);
        application.setImporterName(importerName);
        application.setImporterEmail(importerEmail);
        application.setImpPhnum(impPhnum);
        application.setExporterName(exporterName);
        application.setExporterEmail(exporterEmail);
        application.setExpPhnum(expPhnum);
        application.setProductName(productName);
        application.setProductDescription(productDescription);
        application.setWeight(weight);
        application.setDestinationCountry(destinationCountry);
        application.setSubmissionDate(new java.sql.Date(System.currentTimeMillis()));
        application.setStatus(ExporterApplication.Status.PENDING);
        application.setDocumentFile(fileBytes);
        
        serviceimpl.addApplication(application);
        
        return ResponseEntity.ok("Application submitted successfully.");
    }
    
    @GetMapping("/all")
    public List<ExporterApplication> viewAllShips() {
        return serviceimpl.getAllApp();
    }
    

    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(
            @RequestParam("id") Integer id,
            @RequestParam("status") String status) {
        
        try {
            ExporterApplication.Status newStatus = ExporterApplication.Status.valueOf(status);
            ExporterApplication application = serviceimpl.getApp(id);
            if (application != null) {
                application.setStatus(newStatus);
                serviceimpl.updateApp(application);
                return ResponseEntity.ok("Status updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Application not found.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid status value.");
        }
    }
    
    @GetMapping("/getShipStatus/{id}")
	public List<ExporterApplication> getShipDetailsById(@PathVariable("id") int id) {
		return serviceimpl.getAllApp(id);
	}
    
}

