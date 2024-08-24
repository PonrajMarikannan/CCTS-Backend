package com.raj.customsapp.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.raj.customsapp.model.Ship;
import com.raj.customsapp.serviceImpl.ShipServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ships")
public class ShipController {
	
	 @Autowired
	 private ShipServiceImpl serviceimpl;
	 
	 @PostMapping
	 public ResponseEntity<String> createShip(@RequestBody Ship ship) {

		 if (ship.getArrivalDate() == null) {
	         ship.setArrivalDate(new Date(System.currentTimeMillis()));
	     }
		 
	     try {
	         serviceimpl.addShip(ship);
	        
	         
	         return ResponseEntity.status(HttpStatus.CREATED).body("Ship Created");
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ship Not Created");
	     }
	 }

	 @GetMapping("/all")
	    public List<Ship> viewAllShips() {
	        return serviceimpl.getAllShips();
	    }
	 
	 
	 @PutMapping("/update")
		public String updateShip(@RequestBody Ship ship) {
			String msg = "";
			try {
				serviceimpl.updateShip(ship);
				msg="Success";
			}
			catch(Exception e) {
				msg="Failure";
			}
			return msg;
		}
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<String> updateShipStatus(@PathVariable("id") int id, @RequestBody Map<String, String> updates) {
	     String status = updates.get("status");
	     if (status == null || status.trim().isEmpty()) {
	         return ResponseEntity.badRequest().body("Status is required");
	     }

	     try {
	         Ship ship = serviceimpl.getShip(id);
	         if (ship == null) {
	             return ResponseEntity.notFound().build();
	         }
	         ship.setShipStatus(status);
	         serviceimpl.updateShip(ship); 
	         return ResponseEntity.ok("Ship status updated successfully");
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating ship status");
	     }
	 }



	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteShip(@PathVariable("id") int id) {
	        try {
	            serviceimpl.deleteShip(id);
	            return ResponseEntity.ok("Ship deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting ship");
	        }
	 }
}
