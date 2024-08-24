package com.raj.customsapp.repoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.ExporterApplication;
import com.raj.customsapp.repository.ExporterAppRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExporterAppRepoImpli implements ExporterAppRepo {

	@Autowired
	EntityManager eManager;

	public void save(ExporterApplication exp) {
		eManager.persist(exp);
	}

	@Override
	public List<ExporterApplication> findAll() {
		String hql = "from ExporterApplication";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public void update(ExporterApplication exp) {
		eManager.merge(exp);
	}

	@Override
	public ExporterApplication getApp(int id) {
		return eManager.find(ExporterApplication.class, id);	
	}

	@Override
	public List<ExporterApplication> findShipStatus(int userId) {
		String jpql = "SELECT ea FROM ExporterApplication ea WHERE ea.user.userId = :userId";

        TypedQuery<ExporterApplication> query = eManager.createQuery(jpql, ExporterApplication.class);
        query.setParameter("userId", userId);

        return query.getResultList();
	}
}
	


