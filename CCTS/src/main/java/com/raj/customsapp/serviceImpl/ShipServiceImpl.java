package com.raj.customsapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.Ship;
import com.raj.customsapp.repository.ShipRepo;
import com.raj.customsapp.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    ShipRepo repo;
    
    public void addShip(Ship ship) {
        repo.save(ship);	
    }
    
    public List<Ship> getAllShips() {
		return repo.findAll();
	}

	public void deleteShip(int id) {
		repo.delete(id);
	}

	public void updateShip(Ship ship) {
		repo.update(ship);
	}

	@Override
	public Ship getShip(int id) {
		return repo.getShip(id);
	}
	
  }