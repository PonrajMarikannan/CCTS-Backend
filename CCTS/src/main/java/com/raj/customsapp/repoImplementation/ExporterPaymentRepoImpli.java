package com.raj.customsapp.repoImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.ExporterPayment;
import com.raj.customsapp.repository.ExporterPaymentRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExporterPaymentRepoImpli implements ExporterPaymentRepo {

	@Autowired
	EntityManager eManager;

	public void save(ExporterPayment inv) {
		eManager.persist(inv);
	}


}
	


