package com.raj.customsapp.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.ImporterApplication;
import com.raj.customsapp.repository.ImporterAppRepo;
import com.raj.customsapp.service.ImporterAppService;

@Service
public class ImporterAppServiceImpl implements ImporterAppService {

    @Autowired
    ImporterAppRepo repo;

	public void addApplication(ImporterApplication app) {
		repo.save(app);		
	}

	public List<ImporterApplication> getAllApp() {
		return repo.findAll();
	}	
	
	public void updateApp(ImporterApplication imp) {
		repo.update(imp);
	}

	@Override
	public ImporterApplication getApp(int id) {
		return repo.getApp(id);
	}
	
}
