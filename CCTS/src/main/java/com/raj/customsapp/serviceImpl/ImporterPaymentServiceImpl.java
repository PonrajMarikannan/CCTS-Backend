package com.raj.customsapp.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.ImporterPayment;
import com.raj.customsapp.repository.ImporterPaymentRepo;
import com.raj.customsapp.service.ImporterPaymentService;

@Service
public class ImporterPaymentServiceImpl implements ImporterPaymentService {

    @Autowired
    ImporterPaymentRepo repo;

	public void addApplication(ImporterPayment pay) {
		repo.save(pay);
	}



	

}
