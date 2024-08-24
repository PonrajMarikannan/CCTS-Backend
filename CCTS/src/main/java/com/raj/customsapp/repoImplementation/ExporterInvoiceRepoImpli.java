package com.raj.customsapp.repoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.ExporterInvoice;
import com.raj.customsapp.repository.ExporterInvoiceRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExporterInvoiceRepoImpli implements ExporterInvoiceRepo {

	@Autowired
	EntityManager eManager;

	public void save(ExporterInvoice inv) {
		eManager.persist(inv);
	}

	public List<ExporterInvoice> findAll() {
		String hql = "from ExporterInvoice";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}
	
	public void update(ExporterInvoice inv) {
		eManager.merge(inv);
	}

	@Override
	public ExporterInvoice getInv(int id) {
		return eManager.find(ExporterInvoice.class, id);	
	}

	@Override
    public List<ExporterInvoice> getInvoicesByUserId(int userId) {
        String hql = "SELECT e FROM ExporterInvoice e WHERE e.exporterApplication.user.userId = :userId";
		 Query query = eManager.createQuery(hql);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
	
}
	


