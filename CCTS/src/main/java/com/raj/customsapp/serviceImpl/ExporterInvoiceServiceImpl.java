package com.raj.customsapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.ExporterInvoice;
import com.raj.customsapp.repository.ExporterInvoiceRepo;
import com.raj.customsapp.service.ExporterInvoiceService;

@Service
public class ExporterInvoiceServiceImpl implements ExporterInvoiceService {

    @Autowired
    ExporterInvoiceRepo repo;

	public void addApplication(ExporterInvoice app) {
		repo.save(app);
		
	}
	

	@Override
	public ExporterInvoice getInv(int id) {
		return repo.getInv(id);
	}

	@Override
	public List<ExporterInvoice> getAllInv() {
		return repo.findAll();
	}

	public List<ExporterInvoice> getInvoicesByUserId(int userId) {
		return repo.getInvoicesByUserId(userId);
	}
	

}
