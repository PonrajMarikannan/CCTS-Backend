package com.raj.customsapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.ImporterInvoice;
import com.raj.customsapp.repository.ImporterInvoiceRepo;
import com.raj.customsapp.service.ImporterInvoiceService;

@Service
public class ImporterInvoiceServiceImpl implements ImporterInvoiceService {

    @Autowired
    ImporterInvoiceRepo repo;

	public void addApplication(ImporterInvoice app) {
		repo.save(app);
		
	}

	@Override
	public ImporterInvoice getInv(int id) {
		return repo.getInv(id);
	}

	@Override
	public List<ImporterInvoice> getAllInv() {
		return repo.findAll();
	}

	public List<ImporterInvoice> getInvoicesByUserId(int userId) {
		return repo.getInvoicesByUserId(userId);
	}
	

}
