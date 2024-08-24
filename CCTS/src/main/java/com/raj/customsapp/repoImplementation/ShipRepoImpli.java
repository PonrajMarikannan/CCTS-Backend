package com.raj.customsapp.repoImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.Ship;
import com.raj.customsapp.repository.ShipRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ShipRepoImpli implements ShipRepo {

	@Autowired
	EntityManager eManager;

	@Override
	public void save(Ship ship) {
		eManager.persist(ship);
	}

	@Override
	public List<Ship> findAll() {
		String hql = "from Ship";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}
	
	
	@Override
	public void delete(int id) {
		Ship e = eManager.find(Ship.class, id);
		eManager.remove(e);
	}
	
	@Override
	public void update(Ship ship) {
		eManager.merge(ship);
	}

	@Override
	public Ship getShip(Integer shipId) {
		return eManager.find(Ship.class, shipId);	
	}
	
}
	


