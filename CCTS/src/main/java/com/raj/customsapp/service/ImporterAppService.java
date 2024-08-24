package com.raj.customsapp.service;

import java.util.List;
import com.raj.customsapp.model.ImporterApplication;

public interface ImporterAppService {
	
    void addApplication(ImporterApplication app);
    public List<ImporterApplication> getAllApp();
    public void updateApp(ImporterApplication exp);
    public ImporterApplication getApp(int id);  
     
}
