package com.raj.customsapp.repoImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.ImporterPayment;
import com.raj.customsapp.repository.ImporterPaymentRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ImporterPaymentRepoImpli implements ImporterPaymentRepo {

	@Autowired
	EntityManager eManager;

	public void save(ImporterPayment inv) {
		eManager.persist(inv);
	}


}
	


