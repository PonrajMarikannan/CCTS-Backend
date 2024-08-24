package com.raj.customsapp.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.ExporterPayment;
import com.raj.customsapp.repository.ExporterPaymentRepo;
import com.raj.customsapp.service.ExporterPaymentService;

@Service
public class ExporterPaymentServiceImpl implements ExporterPaymentService {

    @Autowired
    ExporterPaymentRepo repo;

	public void addApplication(ExporterPayment pay) {
		repo.save(pay);
	}



	

}
