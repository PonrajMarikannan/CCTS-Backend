package com.raj.customsapp.repoImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.ImporterApplication;
import com.raj.customsapp.repository.ImporterAppRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ImporterAppRepoImpli implements ImporterAppRepo {

	@Autowired
	EntityManager eManager;

	public void save(ImporterApplication exp) {
		eManager.persist(exp);
	}

	@Override
	public List<ImporterApplication> findAll() {
		String hql = "from ImporterApplication";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public void update(ImporterApplication exp) {
		eManager.merge(exp);
	}

	@Override
	public ImporterApplication getApp(int id) {
		return eManager.find(ImporterApplication.class, id);	
	}
}
	


