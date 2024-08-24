package com.raj.customsapp.service;

import java.util.List;
import com.raj.customsapp.model.ExporterApplication;

public interface ExporterAppService {
	
    void addApplication(ExporterApplication app);
    public List<ExporterApplication> getAllApp();
    public void updateApp(ExporterApplication exp);
    public ExporterApplication getApp(int id); 
    
    public List<ExporterApplication> getAllApp(int userId);
    
     
}
