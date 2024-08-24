package com.raj.customsapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.ExporterApplication;
import com.raj.customsapp.repository.ExporterAppRepo;
import com.raj.customsapp.service.ExporterAppService;

@Service
public class ExporterAppServiceImpl implements ExporterAppService {

    @Autowired
    ExporterAppRepo repo;

	public void addApplication(ExporterApplication app) {
		repo.save(app);
		
	}

	public List<ExporterApplication> getAllApp() {
		return repo.findAll();
	}	
	
	public void updateApp(ExporterApplication exp) {
		repo.update(exp);
	}

	@Override
	public ExporterApplication getApp(int id) {
		return repo.getApp(id);
	}

	@Override
	public List<ExporterApplication> getAllApp(int userId) {
		return repo.findShipStatus(userId);
	}
	

}
