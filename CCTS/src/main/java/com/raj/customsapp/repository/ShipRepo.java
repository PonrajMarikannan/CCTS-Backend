package com.raj.customsapp.repository;

import java.util.List;
import com.raj.customsapp.model.Ship;

public interface ShipRepo {
	
    public void save(Ship ship);
    public List<Ship> findAll();
	public void delete(int id);
	public void update(Ship ship);
	public Ship getShip(Integer shipId);
}

