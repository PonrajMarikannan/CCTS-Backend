package com.raj.customsapp.service;

import java.util.List;
import com.raj.customsapp.model.Ship;

public interface ShipService {
	
	public void addShip(Ship ship);
    public List<Ship> getAllShips();
    public void deleteShip(int id);
    public void updateShip(Ship ship);
    public Ship getShip(int id);  
}
